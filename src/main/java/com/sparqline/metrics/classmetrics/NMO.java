/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NMO - Number of Methods Overridden by a subclass. Number of methods a
 * subclass overrides from its parent classes.
 * 
 * @author Isaac Griffith
 */
public class NMO extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -94680578957698419L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NMO getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NMO("Number of Methods Overridden by a Subclass",
                "Number of methods a subclass overrides from its parent classes.", "NMO", MetricScope.ClassLevel,
                entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NMO(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
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
        // final List<ProgramNode> methods = tree.getMethods(entity);
        // final List<ProgramNode> superMethods = new LinkedList<>();
        //
        // for (final ProgramNode pe :
        // tree.getSuperClasses((ClassOrInterfaceNode) entity))
        // {
        // superMethods.addAll(tree.getMethods(pe));
        // }
        //
        // for (final ProgramNode method : methods)
        // {
        // for (final ProgramNode superMethod : superMethods)
        // {
        // if (method instanceof MethodNode)
        // {
        // if (((MethodNode) method).overrides(superMethod, tree))
        // {
        // retVal++;
        // }
        // }
        // }
        // }

        return retVal;
    }
}