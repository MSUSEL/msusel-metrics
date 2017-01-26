/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CCO -
 * 
 * @author Isaac Griffith
 */
public class CCO extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4541769254332570279L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CCO getInstance(final CodeNode entity, final CodeTree graph)
    {
        // TODO add implementation and return statement
        return new CCO("", "", "CCO", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CCO(final String name, final String desc, final String acronym, final MetricScope scope,
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
