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

/**
 * Method Complexity. A complexity measure that looks at the number and types of
 * message sends in a method.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class MCX extends MethodMetric {

    /**
     * Method's cyclomatic complexity
     */
    private double cyclo;

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static MCX getInstance()
    {
        return new MCX("Method Complexity", "Complexity of the statements in a method's body. Uses CYCLO(m).", "MCX");
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
    private MCX(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        if (entity instanceof MethodNode)
        {
            /*
             * MethodNode method = (MethodNode) entity;
             * int assigments =
             * method.getBody().findExpressionByType(AssignmentExpression.class)
             * .size();
             * int binary =
             * method.getBody().findExpressionByType(BinaryExpression.class).
             * size();
             * int params = method.getParameters().size();
             * int unary =
             * method.getBody().findExpressionByType(UnaryExpression.class).size
             * ();
             * int tempvars = method.getBody().findExpressionByType(
             * VariableDeclarationExpression.class).size();
             * int methodcalls =
             * method.getBody().findExpressionByType(MethodCallExpression.class)
             * .size();
             * int primitives = 0;
             * List<FieldAccessExpression> faes =
             * method.getBody().findExpressionByType(FieldAccessExpression.class
             * );
             * for (FieldAccessExpression fae : faes) {
             * ProgramNode pe = tree.getMethodOwner(method);
             * for (ProgramNode fe : tree.getFields(pe)) {
             * if (fe.getName().equals(fae.getName())) {
             * FieldNode field = (FieldNode) fe;
             * if (field.isPrimitive()) {
             * primitives++;
             * }
             * }
             * }
             * }
             * double mcx = 0;
             */
        }

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
    }
}
