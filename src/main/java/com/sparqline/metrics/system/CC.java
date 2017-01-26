package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class CC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4518498033114599357L;

    public static CC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CC("Coherence of Classes",
                "Coherence between two classes is the amount of similarity between them, in terms of functionality and data. Coherence between classes indicates poor design areas. This metric determines the number of coherent classes in the design.",
                "CC", MetricScope.ClassLevel, entity, graph);
    }

    private CC(final String name, final String desc, final String acronym, final MetricScope scope,
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
