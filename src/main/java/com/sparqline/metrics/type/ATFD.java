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

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.metrics.ClassMetric;

/**
 * Access To Foreign Data. The number of attributes from unrelated classes that
 * are accessed directly or by invoking accessor methods.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class ATFD extends ClassMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static ATFD getInstance()
    {
        // TODO add implementation and return statement
        return new ATFD(
                "Access To Foreign Data",
                "The number of attributes from unrelated classes that are accessed directly or by invoking accessor methods.",
                "ATFD");
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
    private ATFD(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // final List<CodeNode> methods = tree.getMethods(entity);
        int count = 0;

        // for (final CodeNode pe : methods)
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        //
        // final List<Connection> calls =
        // tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.MethodCall);
        // for (final Connection call : calls)
        // {
        // final CodeNode callee = tree.getState().getDest(call);
        // if (callee instanceof MethodNode)
        // {
        // final MethodNode me = (MethodNode) callee;
        // if (me.isAccessorMethod(tree) || me.isMutatorMethod(tree))
        // {
        // if (!tree.getMethodOwner(me).equals(entity))
        // {
        // count++;
        // }
        // }
        // }
        // }
        //
        // final List<Connection> uses =
        // tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.FieldUse);
        // for (final Connection use : uses)
        // {
        // final CodeNode used = tree.getState().getDest(use);
        // if (used instanceof FieldNode)
        // {
        // final CodeNode otherClass = tree.getFieldOwner((FieldNode) used);
        // if (!otherClass.equals(entity))
        // {
        // count++;
        // }
        // }
        // }
        // }
        // }

        return count;
    }
}
