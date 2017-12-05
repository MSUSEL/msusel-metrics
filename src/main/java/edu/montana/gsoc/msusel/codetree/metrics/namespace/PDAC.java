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
package edu.montana.gsoc.msusel.codetree.metrics.namespace;

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.NamespaceMetric;
import edu.montana.gsoc.msusel.codetree.CodeTree;

/**
 * Package Data Abstraction Coupling. Measures the coupling complexity
 * caused by ADTs at the package level. Based on DAC, it transfers the effects
 * of the coupling between classes on the reuse degree, maintenance and testing
 * effort to more abstract organization units like packages and modules, which
 * are as well decisively influenced by the coupling between classes of
 * different packages. C(p = succ(p, contains^PDAC). PDAC(p) = |succ(C(p),
 * referencestype^PDAC) \\ C(p)|.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class PDAC extends NamespaceMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static PDAC getInstance()
    {
        return new PDAC(
                "Package Data Abstraction Coupling",
                "Measures the coupling complexity caused by ADTs at the package level. Based on DAC, it transfers the effects of the coupling between classes on the reuse degree, maintenance and testing effort to more abstract organization units like packages and modules, which are as well decisively influenced by the coupling between classes of different packages. C(p = succ(p, contains^PDAC). PDAC(p) = |succ(C(p), referencestype^PDAC) \\ C(p)|.",
                "PDAC");
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
    private PDAC(final String name, final String desc, final String acronym)
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
