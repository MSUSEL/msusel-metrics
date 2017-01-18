/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * OQFS -
 * 
 * @author Isaac Griffith
 */
public class OQFS extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5389811393521449879L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static OQFS getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new OQFS("", "", "OQFS", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private OQFS(final String name, final String desc, final String acronym, final MetricScope scope,
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
