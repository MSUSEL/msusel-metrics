package com.sparqline.metrics.method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.StatementNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.statement.BlockStatement;
import com.sparqline.graph.nodes.statement.CatchClause;
import com.sparqline.graph.nodes.statement.DoStatement;
import com.sparqline.graph.nodes.statement.ForEachStatement;
import com.sparqline.graph.nodes.statement.ForStatement;
import com.sparqline.graph.nodes.statement.LabeledStatement;
import com.sparqline.graph.nodes.statement.SwitchEntryStatement;
import com.sparqline.graph.nodes.statement.SwitchStatement;
import com.sparqline.graph.nodes.statement.SynchronizedStatement;
import com.sparqline.graph.nodes.statement.TryStatement;
import com.sparqline.graph.nodes.statement.WhileStatement;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * MAXNESTING - Maximum Nesting Level. The maximum nesting level of control
 * structures within an operation.
 * 
 * @author Isaac Griffith
 */
public class MAXNESTING extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1214958509220635700L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static MAXNESTING getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new MAXNESTING("Maximum Nesting Level",
                "The maximum nesting level of control structures within an operation.", "MAXNESTING",
                MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private MAXNESTING(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double maxnesting = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            if (!method.isAbstract())
            {
                maxnesting = 1 + processStatement(method.getBody());
            }
        }

        return maxnesting;
    }

    private int processStatement(final StatementNode stmt)
    {
        int retVal = 0;

        if (stmt instanceof BlockStatement)
        {
            final BlockStatement bs = (BlockStatement) stmt;
            final List<Integer> counts = new ArrayList<>();
            for (final StatementNode se : bs.getStatements())
            {
                counts.add(processStatement(se));
            }

            if (!counts.isEmpty())
                retVal = Collections.max(counts);
        }
        else if (stmt instanceof CatchClause)
        {
            final CatchClause cc = (CatchClause) stmt;
            retVal = processStatement(cc.getCatchBlock());
        }
        else if (stmt instanceof DoStatement)
        {
            final DoStatement ds = (DoStatement) stmt;
            retVal = 1 + processStatement(ds.getBody());
        }
        else if (stmt instanceof ForEachStatement)
        {
            final ForEachStatement fes = (ForEachStatement) stmt;
            retVal = 1 + processStatement(fes.getBody());
        }
        else if (stmt instanceof ForStatement)
        {
            final ForStatement fs = (ForStatement) stmt;
            retVal = 1 + processStatement(fs.getBody());
        }
        else if (stmt instanceof LabeledStatement)
        {
            final LabeledStatement ls = (LabeledStatement) stmt;
            retVal = processStatement(ls.getStmt());
        }
        else if (stmt instanceof SwitchEntryStatement)
        {
            final SwitchEntryStatement ses = (SwitchEntryStatement) stmt;
            final List<Integer> counts = new ArrayList<>();

            for (final StatementNode se : ses.getStatements())
            {
                counts.add(processStatement(se));
            }

            retVal = Collections.max(counts);
        }
        else if (stmt instanceof SwitchStatement)
        {
            final SwitchStatement ss = (SwitchStatement) stmt;
            final List<Integer> counts = new ArrayList<>();

            for (final SwitchEntryStatement ses : ss.getEntries())
            {
                counts.add(processStatement(ses));
            }

            retVal = 1 + Collections.max(counts);
        }
        else if (stmt instanceof SynchronizedStatement)
        {
            final SynchronizedStatement ss = (SynchronizedStatement) stmt;
            retVal = 1 + processStatement(ss.getBlock());
        }
        else if (stmt instanceof TryStatement)
        {
            final TryStatement ts = (TryStatement) stmt;

            final List<Integer> counts = new ArrayList<>();
            counts.add(processStatement(ts.getTryBlock()));
            counts.add(processStatement(ts.getFinallyBlock()));
            for (final CatchClause cc : ts.getCatches())
            {
                counts.add(processStatement(cc));
            }

            retVal = 1 + Collections.max(counts);
        }
        else if (stmt instanceof WhileStatement)
        {
            final WhileStatement ws = (WhileStatement) stmt;

            retVal = 1 + processStatement(ws.getBody());
        }

        return retVal;
    }
}
