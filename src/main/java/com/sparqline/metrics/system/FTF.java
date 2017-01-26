package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * FTF - Function Template Factor. Ratio of the number of functions using
 * function templates and the number of functions.
 * 
 * @author Isaac Griffith
 */
public class FTF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 850269661747110587L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static FTF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new FTF("Function Template Factor",
                "Ratio of the number of functions using function templates and the number of functions.", "FTF",
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
    private FTF(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // final List<CodeNode> methods = tree.getMethods();

        double templateMethodCount = 0;
        double methodCount = 0;

        /*
         * for (final CodeNode entity : methods)
         * {
         * if (entity instanceof MethodNode)
         * {
         * if (((MethodNode) entity).isTemplateMethod())
         * {
         * templateMethodCount++;
         * }
         * methodCount++;
         * }
         * }
         */

        return templateMethodCount / methodCount;
    }
}
