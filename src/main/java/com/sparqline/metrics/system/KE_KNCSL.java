/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

public class KE_KNCSL extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1281838496120282235L;

    public static KE_KNCSL getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new KE_KNCSL("", "", "KE_KNCSL", MetricScope.ClassLevel, entity, graph);
    }

    private KE_KNCSL(final String name, final String desc, final String acronym, final MetricScope scope,
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
