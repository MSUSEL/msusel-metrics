/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MetricScope;

/**
 * NOC - Number of Children. The number of immediate subclasses subordinate to a
 * class in the hierarchy.
 * 
 * @author Isaac Griffith
 */
public class NOC extends com.sparqline.metrics.ClassMetric/* Metric */{

    /**
     * 
     */
    private static final long serialVersionUID = -5163421256250438805L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NOC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOC("Number of Children",
                "The number of immediate subclasses subordinate to a class in the hierarchy.", "NOC",
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
    private NOC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return tree.getSubClasses((ClassOrInterfaceNode) entity).size();
    }

}
