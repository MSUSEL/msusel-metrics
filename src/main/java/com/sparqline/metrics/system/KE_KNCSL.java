/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class KE_KNCSL extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1281838496120282235L;

    public static KE_KNCSL getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new KE_KNCSL("", "", "KE_KNCSL", MetricScope.ClassLevel, entity, graph);
    }

    private KE_KNCSL(final String name, final String desc, final String acronym, final MetricScope scope,
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
