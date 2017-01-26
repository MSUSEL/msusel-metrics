/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright c) 2017 Isaac Griffith, SparQLine Analytics, LLC
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

import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

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

    public static SLOC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new SLOC("Source Lines of Code", "Count of the number of lines of code in this method", "SLOC",
                MetricScope.MethodLevel, entity, graph);
    }

    private SLOC(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
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
    private int getExpressionLOC(final CodeNode me)
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
