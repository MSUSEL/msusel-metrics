/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NAC - Number of Ancestor Classes. Measures the total number of ancestor
 * classes from which a class inherits in the class hierarchy. It addresses a
 * problem with multiple inheritance int he CK DIT metric.
 * 
 * @author Isaac Griffith
 */
public class NAC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5801408807153629766L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NAC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NAC(
                "Number of Ancestor Classes",
                "Measures the total number of ancestor classes from which a class inherits in the class hierarchy. It addresses a problem with multiple inheritance int he CK DIT metric.",
                "NAC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NAC(final String name, final String desc, final String acronym, final MetricScope scope,
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

        int total = getAncestors(cie);
        return total;
    }

    /**
     * @param cie
     * @return
     */
    private int getAncestors(ClassOrInterfaceNode cie)
    {
        int value = 0;

        Set<ClassOrInterfaceNode> supers = new HashSet<>();
        supers.addAll(cie.getExtendsSet());
        supers.addAll(cie.getImplementsSet());
        value = supers.size();
        for (ClassOrInterfaceNode other : supers)
        {
            value += getAncestors(other);
        }
        return value;
    }
}
