/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CC -
 * 
 * @author Isaac Griffith
 */
public class CC extends com.sparqline.metrics.ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 40558840925301698L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CC getInstance(final CodeNode entity, final CodeTree graph)
    {
        // TODO add implementation and return statement
        return new CC("", "", "CC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
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
