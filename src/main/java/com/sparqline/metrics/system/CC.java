package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

public class CC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4518498033114599357L;

    public static CC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CC(
                "Coherence of Classes",
                "Coherence between two classes is the amount of similarity between them, in terms of functionality and data. Coherence between classes indicates poor design areas. This metric determines the number of coherent classes in the design.",
                "CC", MetricScope.ClassLevel, entity, graph);
    }

    private CC(final String name, final String desc, final String acronym, final MetricScope scope,
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
