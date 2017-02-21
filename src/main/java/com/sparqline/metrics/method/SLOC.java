/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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
package com.sparqline.metrics.method;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.metrics.MethodMetric;

/**
 * Source Lines of Code. Count of the number of lines of code in this method.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class SLOC extends MethodMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static SLOC getInstance()
    {
        return new SLOC("Source Lines of Code", "Count of the number of lines of code in this method", "SLOC");
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
    private SLOC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * @param me
     * @return
     */
    private int calculateLOC(final INode me)
    {
        return 1 + getAllStatementsButEmpty(me);
    }

    /**
     * @param me
     * @return
     */
    private int getAllStatementsButEmpty(final INode me)
    {
        /*
         * final List<StatementNode> stmts = new
         * LinkedList<>(me.getContainedStatements());
         * final Iterator<StatementNode> iter = stmts.iterator();
         * while (iter.hasNext())
         * {
         * if (iter.next() instanceof EmptyStatement)
         * {
         * iter.remove();
         * }
         * }
         * return stmts.size() + getExpressionLOC(me);
         */
        return 0;
    }

    /**
     * @param expr
     * @return
     */
    private int getExpressionLOC(final INode me)
    {
        int retVal = 0;

        // TODO Fix this
        /*
         * final List<ObjectCreationExpression> exprs =
         * me.findExpressionByType(ObjectCreationExpression.class);
         * for (final ObjectCreationExpression expr : exprs)
         * {
         * final List<BodyNode> bt = expr.getAnonymousClassBody();
         * for (final CodeNode ent : bt)
         * {
         * retVal += calculateLOC(ent);
         * }
         * }
         */

        return retVal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double sloc = 0;

        if (entity instanceof MethodNode)
        {
            sloc = calculateLOC((MethodNode) entity);
        }

        return sloc;
    }
}
