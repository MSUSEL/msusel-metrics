/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

public class NCSL extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2644736585024826488L;

    public static NCSL getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NCSL("", "", "NCSL", MetricScope.ClassLevel, entity, graph);
    }

    private NCSL(final String name, final String desc, final String acronym, final MetricScope scope,
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
