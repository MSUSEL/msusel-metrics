package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.expression.MethodCallExpression;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static MPC getInstance(final ProgramNode entity, final CodeGraph graph)
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
        double mpc = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;

            final List<MethodCallExpression> calls = cls.findExpressionByType(MethodCallExpression.class);
            mpc = calls.size();
        }

        return mpc;
    }
}
