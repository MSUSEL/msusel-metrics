/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * LCOM5 -
 * 
 * @author Isaac Griffith
 */
public class LCOM5 extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2457050414774401425L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LCOM5 getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LCOM5("", "", "LCOM5", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LCOM5(final String name, final String desc, final String acronym, final MetricScope scope,
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
