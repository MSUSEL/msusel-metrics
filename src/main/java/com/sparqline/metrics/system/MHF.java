/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

/**
 * MHF - Method Hiding Factor. Ratio of hidden methods to total methods. This is
 * a measure of encapsulation.
 * 
 * @author Isaac Griffith
 */
public class MHF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2383416020611566724L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static MHF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new MHF("Method Hiding Factor",
                "Ratio of hidden methods to total methods. This is a measure of encapsulation.", "MHF",
                MetricScope.SystemLevel, entity, graph);
    }

    /**
     * 
     */
    private double numClasses;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private MHF(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // final List<ProgramNode> classes = tree.getClasses();

        double totalMethods = 0.0;
        double totalVisibility = 0.0;

        /*
         * for (final ProgramNode cls : classes)
         * {
         * final List<ProgramNode> methods = tree.getMethods(cls);
         * totalMethods += methods.size();
         * double visible = 0.0;
         * for (final ProgramNode method : methods)
         * {
         * visible += visibility((MethodNode) method);
         * }
         * totalVisibility += visible;
         * }
         */

        return totalVisibility / totalMethods;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        // numClasses = taskMap.containsKey("NC") ?
        // taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }

    /**
     * @param method
     * @return
     */
    private double visibility(final MethodNode method)
    {
        /*
         * if (method.getAccessibility().equals(Accessibility.Public))
         * {
         * return 1;
         * }
         * else if (method.getAccessibility().equals(Accessibility.Private))
         * {
         * return 0;
         * }
         * else if (method.getAccessibility().equals(Accessibility.Protected))
         * {
         * return (tree.getAllSubClasses((ClassOrInterfaceNode) entity).size())
         * / (numClasses - 1);
         * }
         * else
         * {
         * return (tree.getClasses(((ClassOrInterfaceNode)
         * entity).getPackage()).size()) / (numClasses - 1);
         * }
         */
        return 0;
    }
}
