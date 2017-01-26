/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static DAC getInstance(final CodeNode entity, final CodeTree graph)
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
            final CodeNode entity, final CodeTree graph)
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

        /*
         * if (entity instanceof ClassOrInterfaceNode)
         * {
         * final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
         * final List<ProgramNode> fields = tree.getFields(cls);
         * for (final ProgramNode pe : fields)
         * {
         * if (pe instanceof FieldNode)
         * {
         * final FieldNode field = (FieldNode) pe;
         * if (!field.isPrimitive())
         * {
         * dac++;
         * }
         * }
         * }
         * }
         */

        return dac;
    }
}
