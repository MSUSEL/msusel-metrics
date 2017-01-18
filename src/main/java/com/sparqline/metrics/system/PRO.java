/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

public class PRO extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1150421092034254401L;

    public static PRO getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new PRO("", "", "PRO", MetricScope.ClassLevel, entity, graph);
    }

    private PRO(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
