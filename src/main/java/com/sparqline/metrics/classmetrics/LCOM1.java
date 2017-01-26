/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * LCOM1 - Lack of Cohesion in Object Methods. Indicates the level of cohesion
 * between the methods in an object. It is a count of the number of method pairs
 * whose similarity is 0 minus the count of method pairs whose similarity is not
 * zero.
 * 
 * @author Isaac Griffith
 */
public class LCOM1 extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -7443895656844924988L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LCOM1 getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new LCOM1("Lack of Cohesion in Object Methods - 1",
                "Indicates the level of cohesion between the methods in an object. It is a count of the number of method pairs whose similarity is 0 minus the count of method pairs whose similarity is not zero.",
                "LCOM1", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LCOM1(final String name, final String desc, final String acronym, final MetricScope scope,
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
