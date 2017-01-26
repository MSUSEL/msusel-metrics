package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class FD extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5342873952303515226L;

    public static FD getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new FD("Flow Density",
                "The Sum(Fl * P) with Fl being the number of invoked methods between two objects and the start node and P being the object invoking the methods.",
                "FD", MetricScope.ClassLevel, entity, graph);
    }

    private FD(final String name, final String desc, final String acronym, final MetricScope scope,
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
