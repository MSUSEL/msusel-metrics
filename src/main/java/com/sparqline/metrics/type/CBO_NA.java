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
import com.sparqline.codetree.node.CodeNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.annotations.MetricScope;

/**
 * Coupling Between Objects: No Ancestors. Same as CBO, but does not take the
 * coupling between the target class and its ancestors into consideration.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CBO_NA extends ClassMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static CBO_NA getInstance()
    {
        return new CBO_NA(
                "Coupling Between Objects: No Ancestors",
                "Same as CBO, but does not take the coupling between the target class and its ancestors into consideration.",
                "CBO_NA");
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
    private CBO_NA(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // final List<ProgramNode> ancestors =
        // tree.getSuperClasses((ClassOrInterfaceNode) entity);
        // final List<ProgramNode> classes = tree.getAdjacencies(entity,
        // ClassOrInterfaceNode.class);
        // final List<ProgramNode> interfaces = tree.getAdjacencies(entity,
        // ClassOrInterfaceNode.class);
        // final List<ProgramNode> enums = tree.getAdjacencies(entity,
        // EnumNode.class);

        final Set<CodeNode> set = new HashSet<>();
        // set.addAll(classes);
        // set.addAll(interfaces);
        // set.addAll(enums);
        // set.removeAll(ancestors);

        return set.size();
    }
}
