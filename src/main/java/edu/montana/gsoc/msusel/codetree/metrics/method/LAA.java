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

import edu.montana.gsoc.msusel.codetree.metrics.utility.MetricTreeUtils;
import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.MethodMetric;
import edu.montana.gsoc.msusel.codetree.node.MethodNode;

/**
 * Locality of Attribute Accesses. The number of attributes from the method's
 * definition class, divided by the total number of variables accessed
 * (including attributes used via accessor methods, see ATFD), whereby the
 * number of local attributes accessed is computed in conformity with the LAA
 * specification.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class LAA extends MethodMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static LAA getInstance()
    {
        return new LAA(
                "Locality of Attribute Accesses",
                "The number of attributes from the method's definition class, divided by the total number of variables accessed (including attributes used via accessor methods, see ATFD), whereby the number of local attributes accessed is computed in conformity with the LAA specification.",
                "LAA");
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
    private LAA(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double laa = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            final double localAttributesAccessed = 1; // tree.getFields(tree.getMethodOwner(method)).size();

            laa = localAttributesAccessed
                    / (localAttributesAccessed + MetricTreeUtils.foreignAttributeAccesses(method, tree));
        }

        if (Double.isNaN(laa))
            laa = 0;

        return laa;
    }
}
