package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * PR - Polymorphism Ratio. The number of virtual methods, divided by the total
 * number of methods.
 * 
 * @author Isaac Griffith
 */
public class PR extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 3907397421100937690L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static PR getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new PR("Polymorphism Ratio", "The number of virtual methods, divided by the total number of methods.",
                "PR", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private PR(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double methodCount = 0;
        double virtualCount = 0;

        // final List<CodeNode> methods = tree.getMethods(entity);
        //
        // for (final CodeNode pe : methods)
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // methodCount++;
        // if (method.isVirtual() || method.isAbstract())
        // {
        // virtualCount++;
        // }
        // }
        // }

        return virtualCount / methodCount;
    }
}
