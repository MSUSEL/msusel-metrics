/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.graph.nodes.TypeNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.body.Parameter;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * CAM - Average Cohesion Among class Methods
 * 
 * @author Isaac Griffith
 */
public class CAM extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2084669828549649208L;

    public static CAM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CAM("Average Cohesion Among class Methods", "", "CAM", MetricScope.SystemLevel, entity, graph);
    }

    private CAM(final String name, final String desc, final String acronym, final MetricScope scope,
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
            final Set<ClassOrInterfaceNode> systemClasses = new HashSet<>();
            systemClasses.addAll(sys.getClasses());

            Set<TypeNode> types = new HashSet<>();

            for (ClassOrInterfaceNode ce : systemClasses)
            {
                for (MethodNode me : ce.getMethods())
                {
                    for (Parameter p : me.getParameters())
                    {
                        types.add(p.getType());
                    }
                }
            }

            double totalCAM = 0.0d;
            for (ClassOrInterfaceNode ce : systemClasses)
            {
                double classCAM = 0.0d;
                for (MethodNode me : ce.getMethods())
                {
                    Set<TypeNode> localTypes = new HashSet<>();
                    for (Parameter p : me.getParameters())
                    {
                        localTypes.add(p.getType());
                    }

                    if (types.size() > 0)
                        classCAM += localTypes.size() / types.size();
                    else
                        classCAM = 1.0;
                }

                totalCAM += classCAM / ce.getMethods().size();
            }

            value = totalCAM / systemClasses.size();
            if (Double.isNaN(value))
                value = 0;
        }

        return value;
    }
}
