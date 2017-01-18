/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * RFC_INF -
 * 
 * @author Isaac Griffith
 */
public class RFC_INF extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 3614300361043414022L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static RFC_INF getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new RFC_INF("", "", "RFC_INF", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private RFC_INF(final String name, final String desc, final String acronym, final MetricScope scope,
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
