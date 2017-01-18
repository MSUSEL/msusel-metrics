package com.sparqline.metrics.method;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NMP - Number of Method Parameters. A count of the number of defined
 * parameters in the target method's signature.
 * 
 * @author Isaac Griffith
 */
public class NMP extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5666397189893708797L;

    public static NMP getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NMP("Number of Method Parameters",
                "A count of the number of defined parameters in the target method's signature.", "NMP",
                MetricScope.MethodLevel, entity, graph);
    }

    private NMP(final String name, final String desc, final String acronym, final MetricScope scope,
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
        int numParams = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            numParams = method.getParameters().size();
        }

        return numParams;
    }
}
