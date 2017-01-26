package com.sparqline.metrics.method;

import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.Metric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CYCLO - Clyclomatic Complexity. The number of linearly-independent paths
 * through an operation.
 * 
 * @author Isaac Griffith
 */
public class CYCLO extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4661592552588539176L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static Metric getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CYCLO("McCabe's Cyclomatic Number", "The number of linearly-independent paths through an operation.",
                "CYCLO", MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CYCLO(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double retVal = 0;

        /*
         * if (entity instanceof MethodNode)
         * {
         * double edges = 0;
         * double nodes = 0;
         * double exits = 0;
         * final MethodNode method = (MethodNode) entity;
         * if (method.getBody() != null)
         * {
         * edges +=
         * method.getStatementCount(AssertStatement.class.getSimpleName()) * 2;
         * edges += method.getStatementCount(CatchClause.class.getSimpleName())
         * * 2;
         * edges += method.getStatementCount(DoStatement.class.getSimpleName())
         * * 2;
         * edges +=
         * method.getStatementCount(ForEachStatement.class.getSimpleName()) * 3;
         * edges += method.getStatementCount(IfStatement.class.getSimpleName())
         * * 2;
         * edges += method.getStatementCount(ForStatement.class.getSimpleName())
         * * 3;
         * edges +=
         * method.getStatementCount(WhileStatement.class.getSimpleName()) * 2;
         * edges +=
         * method.getStatementCount(ConditionalExpression.class.getSimpleName())
         * * 2;
         * edges +=
         * method.getStatementCount(SwitchEntryStatement.class.getSimpleName())
         * * 2;
         * edges +=
         * method.getStatementCount(BreakStatement.class.getSimpleName());
         * edges +=
         * method.getStatementCount(ContinueStatement.class.getSimpleName());
         * edges +=
         * method.getStatementCount(ExplicitConstructorInvocationStatement.class
         * .getSimpleName());
         * edges +=
         * method.getStatementCount(ExpressionStatement.class.getSimpleName());
         * nodes +=
         * method.getStatementCount(AssertStatement.class.getSimpleName());
         * nodes += method.getStatementCount(CatchClause.class.getSimpleName());
         * nodes += method.getStatementCount(DoStatement.class.getSimpleName());
         * nodes +=
         * method.getStatementCount(ForEachStatement.class.getSimpleName()) * 3;
         * nodes += method.getStatementCount(IfStatement.class.getSimpleName());
         * nodes += method.getStatementCount(ForStatement.class.getSimpleName())
         * * 3;
         * nodes +=
         * method.getStatementCount(WhileStatement.class.getSimpleName());
         * nodes +=
         * method.getStatementCount(ConditionalExpression.class.getSimpleName())
         * ;
         * nodes +=
         * method.getStatementCount(SwitchEntryStatement.class.getSimpleName());
         * nodes +=
         * method.getStatementCount(BreakStatement.class.getSimpleName());
         * nodes +=
         * method.getStatementCount(ContinueStatement.class.getSimpleName());
         * nodes +=
         * method.getStatementCount(ExplicitConstructorInvocationStatement.class
         * .getSimpleName());
         * nodes +=
         * method.getStatementCount(ExpressionStatement.class.getSimpleName());
         * exits = 1 +
         * method.getStatementCount(ReturnStatement.class.getSimpleName());
         * retVal = (edges - nodes) + (2 * exits);
         * }
         * }
         */

        return retVal;
    }

}
