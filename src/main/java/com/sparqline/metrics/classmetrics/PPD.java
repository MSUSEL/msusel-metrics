/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * PPD -
 * 
 * @author Isaac Griffith
 */
public class PPD extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 15599007656362477L;

    public static PPD getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new PPD("", "", "PPD", MetricScope.ClassLevel, entity, graph);
    }

    private PPD(final String name, final String desc, final String acronym, final MetricScope scope,
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
