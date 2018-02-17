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
package edu.montana.gsoc.msusel.codetree.metrics.method;

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.MethodMetric;
import edu.montana.gsoc.msusel.codetree.node.MethodNode;
import edu.montana.gsoc.msusel.codetree.CodeTree;

/**
 * Number of Unused Parameters. A count of the number of parameters defined in a
 * method's signature that neither read from or written to in the corresponding
 * method body.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class NUP extends MethodMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static NUP getInstance()
    {
        return new NUP(
                "Number of Unused Parameters in a Method",
                "A count of the number of parameters defined in a method\'s signature that neither read from or written to in the corresponding method body.",
                "NUP");
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
    private NUP(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree graph)
    {
        double measure = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            /*
             * if (!method.isAbstract())
             * measure = method.getUnusedParams().size();
             */
        }

        return measure;
    }
}
