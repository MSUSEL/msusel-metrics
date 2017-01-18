/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * LCOM4 -
 * 
 * @author Isaac Griffith
 */
public class LCOM4 extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4464229496892713103L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LCOM4 getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LCOM4("", "", "LCOM4", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LCOM4(final String name, final String desc, final String acronym, final MetricScope scope,
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
