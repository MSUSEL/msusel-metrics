package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * HIT - Height of Inheritance Tree. The maximum path length from a class to its
 * deepest subclass.
 * 
 * @author Isaac Griffith
 */
public class HIT extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -64055851030910212L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static HIT getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new HIT("Height of Inheritance Tree", "The maximum path length from a class to its deepest subclass.",
                "HIT", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private HIT(final String name, final String desc, final String acronym, final MetricScope scope,
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

        // if (tree.getSubClasses(cls).isEmpty())
        // {
        // retVal = 1;
        // }
        // else
        // {
        // final List<Integer> depths = new LinkedList<>();
        // for (final ProgramNode sub : tree.getSubClasses(cls))
        // {
        // if (sub instanceof ClassOrInterfaceNode)
        // {
        // depths.add(1 + getHeight((ClassOrInterfaceNode) sub));
        // }
        // }
        //
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
        double hit = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // hit = getHeight((ClassOrInterfaceNode) entity);
        // }

        return hit;
    }
}
