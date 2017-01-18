/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

public class SRE extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -9221474129014010286L;

    public static SRE getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new SRE("", "", "SRE", MetricScope.ClassLevel, entity, graph);
    }

    private SRE(final String name, final String desc, final String acronym, final MetricScope scope,
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
