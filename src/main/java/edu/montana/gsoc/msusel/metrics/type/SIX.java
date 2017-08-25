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
package edu.montana.gsoc.msusel.metrics.type;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.ClassMetric;

/**
 * Specialization Index. SIX = (NMO * HNL) / (NMI + NMA).
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class SIX extends ClassMetric {

    /**
     * number of overriding methods defined in the class
     */
    private double nmo;
    /**
     * class hierarchy nesting level
     */
    private double hnl;
    /**
     * number of methods inherited by the class
     */
    private double nmi;

    /**
     * number of methods added by the class
     */
    private double nma;

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static SIX getInstance()
    {
        return new SIX("Specialization Index", "SIX = (NMO * HNL) / (NMI + NMA).", "SIX");
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
    private SIX(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        return ((nmo * hnl) / (nmi + nma));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // nmo = taskMap.containsKey("NMO") ?
        // taskMap.get("NMO").join().getValue() : entity.getMetric("NMO");
        // hnl = taskMap.containsKey("HNL") ?
        // taskMap.get("HNL").join().getValue() : entity.getMetric("HNL");
        // nmi = taskMap.containsKey("NMI") ?
        // taskMap.get("NMI").join().getValue() : entity.getMetric("NMI");
        // nma = taskMap.containsKey("NMA") ?
        // taskMap.get("NMA").join().getValue() : entity.getMetric("NMA");
    }
}
