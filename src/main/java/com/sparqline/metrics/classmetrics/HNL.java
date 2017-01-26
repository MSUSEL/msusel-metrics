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
 * HNL - Class Hierarchy Nesting Level. Number of levels below the root a class
 * appears at in the hierarchy + 1 (for root).
 * 
 * @author Isaac Griffith
 */
public class HNL extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -3749773696163149268L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static HNL getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new HNL("Class Hierarchy Nesting Level",
                "Number of levels below the root a class appears at in the hierarchy + 1 (for root).", "HNL",
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
    private HNL(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param cls
     * @return
     */
    private int getHeight(final TypeNode cls)
    {
        int retVal = 0;

        // if (tree.getSuperClasses(cls).isEmpty())
        // {
        // retVal = 1;
        // }
        // else
        // {
        // final List<Integer> depths = new LinkedList<>();
        // for (final ProgramNode sub : tree.getSuperClasses(cls))
        // {
        // if (sub instanceof ClassOrInterfaceNode)
        // {
        // depths.add(1 + getHeight((ClassOrInterfaceNode) sub));
        // }
        // }

        // retVal = Collections.max(depths);
        // }

        return retVal;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double hnl = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // hnl = getHeight((ClassOrInterfaceNode) entity);
        // }

        return hnl;
    }
}
