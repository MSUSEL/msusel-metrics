/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * OM - Overridden Methods. Count of the number of methods overridden by this
 * class.
 * 
 * @author Isaac Griffith
 */
public class OM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 115984745694229043L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static OM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new OM("Overridden Methods", "Count of the number of methods overridden by this class.", "OM",
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
    private OM(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double retVal = 0;
        final List<ProgramNode> methods = tree.getMethods(entity);
        final List<ProgramNode> superMethods = new LinkedList<>();

        for (final ProgramNode pe : tree.getSuperClasses((ClassOrInterfaceNode) entity))
        {
            superMethods.addAll(tree.getMethods(pe));
        }

        for (final ProgramNode method : methods)
        {
            for (final ProgramNode superMethod : superMethods)
            {
                if (method instanceof MethodNode)
                {
                    if (((MethodNode) method).overrides(superMethod, tree))
                    {
                        retVal++;
                    }
                }
            }
        }

        return retVal;
    }
}
