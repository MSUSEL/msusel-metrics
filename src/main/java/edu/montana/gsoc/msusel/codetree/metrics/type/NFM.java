/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.codetree.metrics.type;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;

/**
 * Number of Forwarding Methods. Count of the number of methods which simply
 * delegate their action onto another method.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class NFM extends ClassMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static NFM getInstance()
    {
        return new NFM(
                "Number of Forwarding Methods",
                "Count of the number of methods which simply delegate their action onto another method.", "NFM");
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
    private NFM(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double nfm = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // if (method.getContainedStatements().size() < 3)
        // {
        // if
        // (!method.findExpressionByType(MethodCallExpression.class).isEmpty())
        // {
        // nfm++;
        // }
        // }
        // }
        // }
        // }

        return nfm;
    }
}
