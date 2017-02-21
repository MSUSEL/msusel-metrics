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
package com.sparqline.metrics.namespace;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.CodeNode;
import com.sparqline.metrics.NamespaceMetric;

/**
 * Change Dependnecy of Classes. Measures class level coupling. It is a
 * measure assigned to classes describing how dependent other classes are on
 * this class. This allows conclusions on the follow-up work to be done in all
 * client classes, when the sender clas is changed in the course of
 * re-engineering. It is the accumulation of CDBC metric., for a server class
 * (SC) and its client class (CC). CDOC(c) = Sum(CDBC(s, c), for all s \\in
 * class^CDOC).
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CDOC extends NamespaceMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static CDOC getInstance()
    {
        return new CDOC(
                "Change Dependency of Classes",
                "Measures class level coupling. It is a measure assigned to classes describing how dependent other classes are on this class. This allows conclusions on the follow-up work to be done in all client class, when the sender class is changed in the course of re-engineering. It is the accumulation of CDBC metric., for a serverclass (SC) and its clientclass (CC). CDOC(c) = Sum(CDBC(s, c), for all s \\in class^CDOC)",
                "CDOC");
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
    private CDOC(final String name, final String desc, final String acronym)
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
