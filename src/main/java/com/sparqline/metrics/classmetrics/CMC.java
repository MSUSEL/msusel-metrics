/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * CMC - Class Methods Complexity. This metrics is the sum of the internal
 * structural complexity of all local methods, regardless of whether they are
 * visible outside the class or not.
 * 
 * @author Isaac Griffith
 */
public class CMC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4221792549393846950L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CMC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CMC(
                "Class Methods Complexity",
                "This metrics is the sum of the internal structural complexity of all local methods, regardless of whether they are visible outside the class or not.",
                "CMC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CMC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double cmc = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            for (final ProgramNode method : tree.getMethods(entity))
            {
                if (method instanceof MethodNode)
                {
                    cmc += method.getMetric("CYCLO");
                }
            }
        }

        return cmc;
    }
}
