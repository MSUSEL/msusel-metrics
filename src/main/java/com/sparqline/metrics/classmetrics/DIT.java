/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

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
    public static DIT getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new DIT("Depth of Inheritance Tree",
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
        return measure(entity);
    }

    /**
     * @param entity
     * @return
     */
    private double measure(final CodeNode entity)
    {
        if (entity instanceof TypeNode)
        {
            // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
            // final Set<ClassOrInterfaceNode> superClasses = new HashSet<>();
            // superClasses.addAll(cls.getExtendsSet());
            // superClasses.addAll(cls.getImplementsSet());
            //
            // if (superClasses.isEmpty())
            // {
            // return 0;
            // }
            // else
            // {
            // final List<Double> values = new LinkedList<>();
            // for (final ProgramNode superClass : superClasses)
            // {
            // values.add(measure(superClass));
            // }
            //
            // return 1 + Collections.max(values);
            // }
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
