/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CAED - Client Access to Encapsulated Data. Number of methods that return a
 * reference or pointer to encapsulated data.
 * 
 * @author Isaac Griffith
 */
public class CAED extends com.sparqline.metrics.ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5457405709948051893L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CAED getInstance(final CodeNode entity, final CodeTree graph)
    {
        // TODO add implementation and return statement
        return new CAED("Client Access to Encapsulated Data",
                "Number of methods that return a reference or pointer to encapsulated data.", "CAED",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CAED(final String name, final String desc, final String acronym, final MetricScope scope,
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
