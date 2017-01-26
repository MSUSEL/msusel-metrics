package com.sparqline.metrics.method;

import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

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

    public static NMP getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NMP("Number of Method Parameters",
                "A count of the number of defined parameters in the target method's signature.", "NMP",
                MetricScope.MethodLevel, entity, graph);
    }

    private NMP(final String name, final String desc, final String acronym, final MetricScope scope,
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
        int numParams = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            // numParams = method.getParameters().size();
        }

        return numParams;
    }
}
