package com.sparqline.metrics.method;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.BodyNode;
import com.sparqline.graph.nodes.CodeNode;
import com.sparqline.graph.nodes.StatementNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.expression.ObjectCreationExpression;
import com.sparqline.graph.nodes.statement.EmptyStatement;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * SLOC - Source Lines of Code. Count of the number of lines of code in this
 * method.
 * 
 * @author Isaac Griffith
 */
public class SLOC extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 7637661699530861707L;

    public static SLOC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new SLOC("Source Lines of Code", "Count of the number of lines of code in this method", "SLOC",
                MetricScope.MethodLevel, entity, graph);
    }

    private SLOC(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param me
     * @return
     */
    private int calculateLOC(final CodeNode me)
    {
        return 1 + getAllStatementsButEmpty(me);
    }

    /**
     * @param me
     * @return
     */
    private int getAllStatementsButEmpty(final CodeNode me)
    {
        final List<StatementNode> stmts = new LinkedList<>(me.getContainedStatements());
        final Iterator<StatementNode> iter = stmts.iterator();
        while (iter.hasNext())
        {
            if (iter.next() instanceof EmptyStatement)
            {
                iter.remove();
            }
        }

        return stmts.size() + getExpressionLOC(me);
    }

    /**
     * @param expr
     * @return
     */
    private int getExpressionLOC(final CodeNode me)
    {
        int retVal = 0;

        // TODO Fix this
        final List<ObjectCreationExpression> exprs = me.findExpressionByType(ObjectCreationExpression.class);
        for (final ObjectCreationExpression expr : exprs)
        {
            final List<BodyNode> bt = expr.getAnonymousClassBody();

            for (final CodeNode ent : bt)
            {
                retVal += calculateLOC(ent);
            }
        }

        return retVal;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double sloc = 0;

        if (entity instanceof MethodNode)
        {
            sloc = calculateLOC((MethodNode) entity);
        }

        return sloc;
    }
}
