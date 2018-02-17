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
package edu.montana.gsoc.msusel.codetree.metrics.type;

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;
import edu.montana.gsoc.msusel.codetree.CodeTree;

/**
 * Weighted Methods per Class. A weighted measure of the complexities of methods
 * defined in a class. Measures maintainability and reusability. WMC =
 * Sum(CYCLO(m_i), for all i methods). Uses a normalized complexity such that
 * the median complexity should equal 1.0
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class WMC extends ClassMetric {

    /**
     * @return
     */
    public static WMC getInstance()
    {
        return new WMC(
                "Weighted Methods per Class",
                "A weighted measure of the complexities of methods defined in a class. Measures maintainability and reusability. WMC = Sum(CYCLO(m_i), for all i methods). Uses a normalized complexity such that the median complexity should equal 1.0",
                "WMC");
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
    private WMC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // final List<ProgramNode> methods = tree.getMethods(entity);
        //
        // final List<Double> complexities = new LinkedList<>();
        // for (final ProgramNode method : methods)
        // {
        // complexities.add(method.getMetric("CYCLO"));
        // }
        //
        // double medianComplexity = 0;
        // if (complexities.isEmpty())
        // {
        // return medianComplexity;
        // }
        // if ((complexities.size() % 2) == 0)
        // {
        // medianComplexity = (complexities.get(complexities.size() / 2) +
        // complexities.get(complexities.size() / 2)) / 2;
        // }
        // else if (((complexities.size() % 2) != 0) && (complexities.size() >
        // 2))
        // {
        // medianComplexity = (complexities.get((complexities.size() / 2) + 1));
        // }
        // else
        // {
        // medianComplexity = (complexities.get(0));
        // }

        double totalComplexity = 0;
        // for (final double comp : complexities)
        // {
        // totalComplexity += comp / medianComplexity;
        // }
        //
        // if (Double.isNaN(totalComplexity))
        // {
        // totalComplexity = 0;
        // }
        return totalComplexity;
    }
}
