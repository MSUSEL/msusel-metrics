/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NOP - Number of Polymorphic Methods. This is a count of the number of methods
 * that can be overridden in a class.
 * 
 * @author Isaac Griffith
 */
public class NOP extends ClassMetric {

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NOP getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NOP("Number of Polymorphic Methods",
                "This is a count of the number of methods that can be overridden in a class.", "NOP",
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
    private NOP(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // ClassOrInterfaceNode cie = (ClassOrInterfaceNode) entity;
        // Set<MethodNode> methods = cie.getMethods();

        int count = 0;
        // for (MethodNode method : methods)
        // {
        // if (method.isVirtual())
        // count++;
        // }

        return count;
    }

}
