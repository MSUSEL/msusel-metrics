/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static NOP getInstance(final ProgramNode entity, final CodeGraph graph)
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
        ClassOrInterfaceNode cie = (ClassOrInterfaceNode) entity;
        Set<MethodNode> methods = cie.getMethods();

        int count = 0;
        for (MethodNode method : methods)
        {
            if (method.isVirtual())
                count++;
        }

        return count;
    }

}
