/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * DAM - Average Data Access Metric
 * 
 * @author Isaac Griffith
 */
public class DAM extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8159583311389301289L;

    public static DAM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new DAM("Average Data Access Metric", "", "DAM", MetricScope.SystemLevel, entity, graph);
    }

    private DAM(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double value = 0.0d;

        if (entity instanceof SystemNode)
        {
            final SystemNode sys = (SystemNode) entity;
            final Set<ProgramNode> systemClasses = new HashSet<>();
            systemClasses.addAll(sys.getClasses());

            double totalDAM = 0.0d;
            for (ProgramNode ce : systemClasses)
            {
                int nonPubAttr = 0;
                for (FieldNode field : ((ClassOrInterfaceNode) ce).getFields())
                {
                    if (field.getAccessibility() != Accessibility.Public)
                        nonPubAttr++;
                }
                totalDAM = ((double) nonPubAttr) / ((double) ((ClassOrInterfaceNode) ce).getFields().size());
            }
            if (Double.isNaN(totalDAM))
                totalDAM = 0;

            value = totalDAM / systemClasses.size();
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }

}
