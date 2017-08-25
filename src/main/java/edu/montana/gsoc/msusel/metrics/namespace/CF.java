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
package edu.montana.gsoc.msusel.metrics.namespace;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.NamespaceMetric;

/**
 * Coupling Factor. Measures the coupling between classes excluding
 * coupling due to inheritance. It is the ratio between the number of actually
 * coupled pairs of classes in a scope and the possible number of coupled pairs
 * of classes.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CF extends NamespaceMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static CF getInstance()
    {
        return new CF(
                "Coupling Factor",
                "Measures the coupling between classes excluding coupling due to inheritance. It is the ratio between the number of actually coupled pairs of classes in a scope and the possible number of coupled pairs of classes.",
                "CF");
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
    private CF(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double cf = 0;

        /*
         * if (entity instanceof PackageNode)
         * {
         * final List<CodeNode> classes = tree.getClasses((PackageNode) entity);
         * double totalCount = 0;
         * for (final CodeNode cls : classes)
         * {
         * final List<CodeNode> others = tree.getClasses((PackageNode) entity);
         * int count = 0;
         * for (final CodeNode other : others)
         * {
         * if (cls.equals(other))
         * {
         * continue;
         * }
         * count += MetricTreeUtils.isClient(cls, other, tree);
         * }
         * totalCount += count;
         * }
         * final double numClasses = classes.size();
         * cf = totalCount / ((numClasses * numClasses) - numClasses);
         * }
         */

        return cf;
    }
}
