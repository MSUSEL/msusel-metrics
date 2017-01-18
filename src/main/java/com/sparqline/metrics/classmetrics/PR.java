package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static PR getInstance(final ProgramNode entity, final CodeGraph graph)
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
        final List<ProgramNode> methods = tree.getMethods(entity);
        double methodCount = 0;
        double virtualCount = 0;

        for (final ProgramNode pe : methods)
        {
            if (pe instanceof MethodNode)
            {
                final MethodNode method = (MethodNode) pe;
                methodCount++;
                if (method.isVirtual() || method.isAbstract())
                {
                    virtualCount++;
                }
            }
        }

        return virtualCount / methodCount;
    }
}
