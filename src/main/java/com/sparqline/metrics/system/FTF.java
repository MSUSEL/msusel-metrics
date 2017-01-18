package com.sparqline.metrics.system;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

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
    public static FTF getInstance(final ProgramNode entity, final CodeGraph graph)
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
        final List<ProgramNode> methods = tree.getMethods();

        double templateMethodCount = 0;
        double methodCount = 0;

        for (final ProgramNode entity : methods)
        {
            if (entity instanceof MethodNode)
            {
                if (((MethodNode) entity).isTemplateMethod())
                {
                    templateMethodCount++;
                }
                methodCount++;
            }
        }

        return templateMethodCount / methodCount;
    }
}
