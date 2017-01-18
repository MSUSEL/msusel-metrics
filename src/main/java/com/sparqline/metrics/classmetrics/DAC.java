/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * DAC - Data Abstraction Coupling. The number of ADT's defined in a class.
 * 
 * @author Isaac Griffith
 */
public class DAC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 3636899776029357927L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static DAC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new DAC("Data Abstraction Coupling", "The number of ADT's defined in a class.", "DAC",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private DAC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double dac = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;

            final List<ProgramNode> fields = tree.getFields(cls);
            for (final ProgramNode pe : fields)
            {
                if (pe instanceof FieldNode)
                {
                    final FieldNode field = (FieldNode) pe;
                    if (!field.isPrimitive())
                    {
                        dac++;
                    }
                }
            }
        }

        return dac;
    }
}
