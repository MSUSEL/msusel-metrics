/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * DIT - Depth of Inheritance Tree. DIT of a class is the maximum depth of
 * inheritance. That is, the maximum path length from the node to the root of
 * the tree.
 * 
 * @author Isaac Griffith
 */
public class DIT extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1026452182237009390L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static DIT getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new DIT(
                "Depth of Inheritance Tree",
                "DIT of a class is the maximum depth of inheritance. That is, the maximum path length from the node to the root of the tree.",
                "DIT", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private DIT(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return measure(entity);
    }

    /**
     * @param entity
     * @return
     */
    private double measure(final ProgramNode entity)
    {
        if (entity instanceof ClassOrInterfaceNode)
        {
            final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
            final Set<ClassOrInterfaceNode> superClasses = new HashSet<>();
            superClasses.addAll(cls.getExtendsSet());
            superClasses.addAll(cls.getImplementsSet());

            if (superClasses.isEmpty())
            {
                return 0;
            }
            else
            {
                final List<Double> values = new LinkedList<>();
                for (final ProgramNode superClass : superClasses)
                {
                    values.add(measure(superClass));
                }

                return 1 + Collections.max(values);
            }
        }
        else
        {
            return 0;
        }
    }
}
