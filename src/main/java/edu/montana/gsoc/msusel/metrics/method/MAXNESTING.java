/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.metrics.method;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.MethodMetric;
import edu.montana.gsoc.msusel.node.MethodNode;
import edu.montana.gsoc.msusel.node.StatementNode;

/**
 * Maximum Nesting Level. The maximum nesting level of control structures within
 * an operation.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class MAXNESTING extends MethodMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static MAXNESTING getInstance()
    {
        return new MAXNESTING(
                "Maximum Nesting Level", "The maximum nesting level of control structures within an operation.",
                "MAXNESTING");
    }

    /**
     * Constructs a new instance of this metric with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this metric
     * @param desc
     *            Description of this metric
     * @param acronym
     *            Acronym of this metric
     */
    private MAXNESTING(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double maxnesting = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            if (!method.isAbstract())
            {
                // maxnesting = 1 + processStatement(method.getBody());
            }
        }

        return maxnesting;
    }

    /**
     * @param stmt
     * @return
     */
    private int processStatement(final StatementNode stmt)
    {
        int retVal = 0;

        /*
         * if (stmt instanceof BlockStatement)
         * {
         * final BlockStatement bs = (BlockStatement) stmt;
         * final List<Integer> counts = Lists.newArrayList();
         * for (final StatementNode se : bs.getStatements())
         * {
         * counts.add(processStatement(se));
         * }
         * if (!counts.isEmpty())
         * retVal = Collections.max(counts);
         * }
         * else if (stmt instanceof CatchClause)
         * {
         * final CatchClause cc = (CatchClause) stmt;
         * retVal = processStatement(cc.getCatchBlock());
         * }
         * else if (stmt instanceof DoStatement)
         * {
         * final DoStatement ds = (DoStatement) stmt;
         * retVal = 1 + processStatement(ds.getBody());
         * }
         * else if (stmt instanceof ForEachStatement)
         * {
         * final ForEachStatement fes = (ForEachStatement) stmt;
         * retVal = 1 + processStatement(fes.getBody());
         * }
         * else if (stmt instanceof ForStatement)
         * {
         * final ForStatement fs = (ForStatement) stmt;
         * retVal = 1 + processStatement(fs.getBody());
         * }
         * else if (stmt instanceof LabeledStatement)
         * {
         * final LabeledStatement ls = (LabeledStatement) stmt;
         * retVal = processStatement(ls.getStmt());
         * }
         * else if (stmt instanceof SwitchEntryStatement)
         * {
         * final SwitchEntryStatement ses = (SwitchEntryStatement) stmt;
         * final List<Integer> counts = Lists.newArrayList();
         * for (final StatementNode se : ses.getStatements())
         * {
         * counts.add(processStatement(se));
         * }
         * retVal = Collections.max(counts);
         * }
         * else if (stmt instanceof SwitchStatement)
         * {
         * final SwitchStatement ss = (SwitchStatement) stmt;
         * final List<Integer> counts = Lists.newArrayList();
         * for (final SwitchEntryStatement ses : ss.getEntries())
         * {
         * counts.add(processStatement(ses));
         * }
         * retVal = 1 + Collections.max(counts);
         * }
         * else if (stmt instanceof SynchronizedStatement)
         * {
         * final SynchronizedStatement ss = (SynchronizedStatement) stmt;
         * retVal = 1 + processStatement(ss.getBlock());
         * }
         * else if (stmt instanceof TryStatement)
         * {
         * final TryStatement ts = (TryStatement) stmt;
         * final List<Integer> counts = Lists.newArrayList();
         * counts.add(processStatement(ts.getTryBlock()));
         * counts.add(processStatement(ts.getFinallyBlock()));
         * for (final CatchClause cc : ts.getCatches())
         * {
         * counts.add(processStatement(cc));
         * }
         * retVal = 1 + Collections.max(counts);
         * }
         * else if (stmt instanceof WhileStatement)
         * {
         * final WhileStatement ws = (WhileStatement) stmt;
         * retVal = 1 + processStatement(ws.getBody());
         * }
         */

        return retVal;
    }
}
