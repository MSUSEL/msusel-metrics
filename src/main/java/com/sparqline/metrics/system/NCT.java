/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class NCT extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1886498003689425944L;

    public static NCT getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NCT("", "", "NCT", MetricScope.ClassLevel, entity, graph);
    }

    private NCT(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
