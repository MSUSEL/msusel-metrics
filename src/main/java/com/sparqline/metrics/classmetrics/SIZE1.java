/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * SIZE1 - Class Size. Equivalent to LOC. It is a count of the number of
 * semicolons in a class.
 * 
 * @author Isaac Griffith
 */
public class SIZE1 extends com.sparqline.metrics.ClassMetric {

    /**
     * 
     */
    private double loc;

    /**
     * 
     */
    private static final long serialVersionUID = -5783643283365872043L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static SIZE1 getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new SIZE1("Class Size", "Equivalent to LOC. It is a count of the number of semicolons in a class.",
                "SIZE1", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private SIZE1(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return loc;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        // loc = taskMap.containsKey("loc") ?
        // taskMap.get("loc").join().getValue() : entity.getMetric("loc");
    }
}
