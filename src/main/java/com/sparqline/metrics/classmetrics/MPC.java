package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * MPC - Message Passing Coupling. The number of send statments defined in a
 * class.
 * 
 * @author Isaac Griffith
 */
public class MPC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -3608184309766828507L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static MPC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new MPC("Message Passing Coupling", "The number of send statements defined in a class.", "MPC",
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
    private MPC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double mpc = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        //
        // final List<MethodCallExpression> calls =
        // cls.findExpressionByType(MethodCallExpression.class);
        // mpc = calls.size();
        // }

        return mpc;
    }
}
