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
package edu.montana.gsoc.msusel.codetree.metrics.namespace;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.NamespaceMetric;

/**
 * Instability. Measures the ratio between the outgoing and the total number
 * of in- and out-going couplings from classes inside the package from/to
 * classes outside the package. Each class counts only one. Zero, if the package
 * does not contain classes or if external classes are not used by the package's
 * classes. I(p) = Ce / (Ca + Ce)
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class I extends NamespaceMetric {

    /**
     * the package efferent coupling
     */
    private double Ce;
    /**
     * the package afferent coupling
     */
    private double Ca;

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static I getInstance()
    {
        return new I(
                "Instability",
                "Measures the ratio between the outgoing and the total number of in- and out-going couplings from classes inside the package from/to classes outside the package. Each class counts only once. Zero if the package does not contain classes or if external classes are not used by the package's classes. I(p) = Ce / (Ca + Ce)",
                "I");
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
    private I(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        return Ce / (Ca + Ce);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // Ca = taskMap.containsKey("Ca") ? taskMap.get("Ca").join().getValue()
        // : entity.getMetric("Ca");
        // Ce = taskMap.containsKey("Ce") ? taskMap.get("Ce").join().getValue()
        // : entity.getMetric("Ce");
    }
}
