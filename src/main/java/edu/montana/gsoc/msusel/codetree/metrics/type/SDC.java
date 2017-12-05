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
package edu.montana.gsoc.msusel.codetree.metrics.type;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;

/**
 * Size of Duplication Chain. To improve the code we need to see more than just
 * a pile of small duplication chunks. We want to see the big picture, i.e., to
 * cluster the chunks of duplication into a more meaningful block of
 * duplication. This is what we call a duplication chain. Thus, a duplication
 * chain is composed of smaller islands of exact clones that are close enough
 * pairwise to be considered as belonging together, i.e., there LB value is less
 * than a given threshold.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class SDC extends ClassMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static SDC getInstance()
    {
        return new SDC(
                "Size of Duplication Chain",
                "To improve the code we need to see more than just a pile of small duplication chunks. We want to see the big picture, i.e., to cluster the chunks of duplication into a more meaningful block of duplication. This is what we call a duplication chain. Thus, a duplication chain is composed of smaller islands of exact clones that are close enough pairwise to be considered as belonging together, i.e., there LB value is less than a given threshold.",
                "SDC");
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
    private SDC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
