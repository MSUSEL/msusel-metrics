/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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

    public static PPD getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new PPD("", "", "PPD", MetricScope.ClassLevel, entity, graph);
    }

    private PPD(final String name, final String desc, final String acronym, final MetricScope scope,
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
