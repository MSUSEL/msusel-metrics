/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * CLD -
 * 
 * @author Isaac Griffith
 */
public class CLD extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 8513860024232590929L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CLD getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        // TODO add implementation and return statement
        return new CLD("", "", "CLD", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CLD(final String name, final String desc, final String acronym, final MetricScope scope,
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
