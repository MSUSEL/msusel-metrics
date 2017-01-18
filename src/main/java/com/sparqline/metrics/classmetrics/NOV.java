/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NOV - Number of Variables. A count of the total number of variables in a
 * class. The total number of variables includes public private and protected
 * variables. The ratio of private and protected variables to the total number
 * of variables indicates the effort required by that class in providing
 * information to other classes.
 * 
 * @author Isaac Griffith
 */
public class NOV extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 8323399440529804934L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NOV getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NOV(
                "Number of Variables",
                "A count of the total number of variables in a class. The total number of variables includes public private and protected variables. The ratio of private and protected variables to the total number of variables indicates the effort required by that class in providing information to other classes.",
                "NOV", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NOV(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return tree.getFields(entity).size();
    }

}
