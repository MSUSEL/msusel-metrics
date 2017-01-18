package com.sparqline.metrics.method;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NUP - Number of Unused Parameters. A count of the number of parameters
 * defined in a method's signature that neither read from or written to in the
 * corresponding method body.
 * 
 * @author Isaac Griffith
 */
public class NUP extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -1684833037857423179L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NUP getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NUP(
                "Number of Unused Parameters in a Method",
                "A count of the number of parameters defined in a method\'s signature that neither read from or written to in the corresponding method body.",
                "NUP", MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NUP(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double measure = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            if (!method.isAbstract())
                measure = method.getUnusedParams().size();
        }

        return measure;
    }
}
