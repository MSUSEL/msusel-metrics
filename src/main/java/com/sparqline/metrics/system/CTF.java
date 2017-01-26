/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CTF - Class Template Factor. Ratio of the number of classes using clas
 * templates and the number of classes.
 * 
 * @author Isaac
 */
public class CTF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2628707390320103830L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CTF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CTF("Class Template Factor",
                "Ratio of the number of classes using class templates and the number of classes.", "CTF",
                MetricScope.ClassLevel, entity, graph);
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
    private CTF(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // final List<CodeNode> classes = tree.getClasses();
        // final List<CodeNode> interfaces = tree.getInterfaces();

        double templateClassCount = 0;

        /*
         * for (final CodeNode entity : classes)
         * {
         * if (entity instanceof TypeNode)
         * {
         * if (((TypeNode) entity).isTemplate())
         * {
         * templateClassCount++;
         * }
         * }
         * }
         */

        double numIntefaces = 0;

        /*
         * for (final CodeNode entity : interfaces)
         * {
         * if ((entity instanceof TypeNode) && ((TypeNode)
         * entity).isInterface())
         * {
         * if (((TypeNode) entity).isTemplate())
         * {
         * templateClassCount++;
         * }
         * numIntefaces++;
         * }
         * }
         */

        return templateClassCount / (numClasses + numIntefaces);
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
}
