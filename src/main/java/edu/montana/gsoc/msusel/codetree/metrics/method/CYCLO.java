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
package edu.montana.gsoc.msusel.codetree.metrics.method;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.MethodMetric;
import edu.montana.gsoc.msusel.codetree.metrics.Metric;

/**
 * Clyclomatic Complexity. The number of linearly-independent paths through an
 * operation.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CYCLO extends MethodMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static Metric getInstance()
    {
        return new CYCLO(
                "McCabe's Cyclomatic Number", "The number of linearly-independent paths through an operation.",
                "CYCLO");
    }

    /**
     * Constructs a new instance of this name with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this name
     * @param desc
     *            Description of this name
     * @param acronym
     *            Acronym of this name
     */
    private CYCLO(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
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
