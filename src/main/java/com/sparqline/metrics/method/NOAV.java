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
 * NOAV - Number of Accessed Variables. The total number of variables accessed
 * directly from the measured operation. Variables include parameters, local
 * variables, but also instance variables and global variables.
 * 
 * @author Isaac Griffith
 */
public class NOAV extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -3929872169331381396L;

    public static NOAV getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NOAV("Number of Accessed Variables",
                "The total number of variables accessed directly from the measured operation. Variables include parameters, local variables, but also instance variables and global variables.",
                "NOAV", MetricScope.MethodLevel, entity, graph);
    }

    private NOAV(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param method
     * @return
     */
    private int getNumberOfAccessedFields(final MethodNode method)
    {
        int count = 0;

        // count = tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.FieldUse).size();

        return count;
    }

    /**
     * @param method
     * @return
     */
    private int getNumberOfAccessedLocalVariables(final MethodNode method)
    {
        int count = 0;

        /*
         * final List<VariableDeclarationExpression> varDecs = method
         * .findExpressionByType(VariableDeclarationExpression.class);
         * final List<String> varNames = new ArrayList<>();
         * for (final VariableDeclarationExpression varDec : varDecs)
         * {
         * for (final VariableNode var : varDec.getVars())
         * {
         * varNames.add(var.getName());
         * }
         * }
         * final List<NameExpression> nameExprs =
         * method.findExpressionByType(NameExpression.class);
         * for (final NameExpression nameExpr : nameExprs)
         * {
         * if (nameExpr instanceof QualifiedNameExpression)
         * {
         * continue;
         * }
         * else if (varNames.contains(nameExpr.getContent()))
         * {
         * count++;
         * }
         * }
         */

        return count;
    }

    /**
     * @param method
     * @return
     */
    private int getNumberOfAccessedParameters(final MethodNode method)
    {
        int count = 0;

        /*
         * for (final Parameter param : method.getParameters())
         * {
         * final String name = param.getName();
         * final List<NameExpression> nameExprs =
         * method.findExpressionByType(NameExpression.class);
         * for (final NameExpression nameExpr : nameExprs)
         * {
         * if (nameExpr instanceof QualifiedNameExpression)
         * {
         * continue;
         * }
         * else if (nameExpr.getContent().equals(name))
         * {
         * count++;
         * }
         * }
         * }
         */

        return count;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double noav = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;

            // noav += getNumberOfAccessedFields(method);
            // noav += getNumberOfAccessedLocalVariables(method);
            // noav += getNumberOfAccessedParameters(method);
            if (!method.isAbstract())
            {
                /*
                 * noav += method.getVariableDeclarations().size();
                 * noav += method.getFieldAccess().size();
                 * noav += method.getParameters().size();
                 */
            }
        }

        return noav;
    }
}
