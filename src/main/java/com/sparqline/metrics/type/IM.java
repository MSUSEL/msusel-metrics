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
package com.sparqline.metrics.type;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.codetree.node.TypeNode;
import com.sparqline.metrics.ClassMetric;

/**
 * Inherited Methods. Count of the number of methods that are inherited from all
 * the ancestor classes of the class.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class IM extends ClassMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static IM getInstance()
    {
        return new IM(
                "Inherited Methods",
                "Count of the number of methods that are inherited from all the ancestor classes of the class.", "IM");
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
    private IM(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double im = 0;

        // try
        // {
        // if (entity instanceof TypeNode)
        // {
        // final TypeNode cls = (TypeNode) entity;
        // final Set<MethodNode> inherited =
        // SetOperations.difference(MetricTreeUtils.getInheritedMethods(cls, tree),
        // MetricTreeUtils.getOverriddenMethods(cls, tree));
        //
        // im = inherited.size();
        // }
        // }
        // catch (final SetOperationsException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        return im;
    }
}
