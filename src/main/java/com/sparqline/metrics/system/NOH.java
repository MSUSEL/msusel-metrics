/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class NOH extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2325361177142303108L;

    public static NOH getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NOH("Number of Hierarchies", "", "NOH", MetricScope.SystemLevel, entity, graph);
    }

    private NOH(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double value = 0.0d;

        /*
         * if (entity instanceof SystemNode)
         * {
         * final SystemNode sys = (SystemNode) entity;
         * final Set<ProgramNode> systemClasses = new HashSet<>();
         * systemClasses.addAll(sys.getClasses());
         * for (ProgramNode ce : systemClasses)
         * {
         * if (Double.compare(0, ce.getMetric("DIT")) == 0)
         * value++;
         * }
         * }
         */

        if (Double.isNaN(value))
            value = 0;
        return value;
    }
}
