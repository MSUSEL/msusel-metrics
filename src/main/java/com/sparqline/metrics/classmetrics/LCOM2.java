/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * LCOM2 -
 * 
 * @author Isaac Griffith
 */
public class LCOM2 extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2641401396339403431L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LCOM2 getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new LCOM2("", "", "LCOM2", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LCOM2(final String name, final String desc, final String acronym, final MetricScope scope,
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
