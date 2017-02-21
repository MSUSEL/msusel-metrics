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
package com.sparqline.metrics.project;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.metrics.ProjectMetric;

/**
 * Median Coupling Between Objects. This metric calculates the median value of
 * the CBO metric for a system.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CBOmedian extends ProjectMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static CBOmedian getInstance()
    {
        return new CBOmedian(
                "Median Coupling Between Objects",
                "This metric calculates the median value of the CBO metric for a system.", "CBO_median");
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
    private CBOmedian(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double medianCBO = 0;
        // final List<CodeNode> entities = tree.getClasses();
        //
        // final List<Double> cboValues = new LinkedList<>();
        // for (final CodeNode entity : entities)
        // {
        // cboValues.add(entity.getMetric("CBO"));
        // }
        //
        // Collections.sort(cboValues);
        //
        // if ((cboValues.size() % 2) == 0)
        // {
        // medianCBO = (cboValues.get((cboValues.size() / 2) - 1) +
        // cboValues.get(cboValues.size() / 2)) / 2;
        // }
        // else
        // {
        // medianCBO = (cboValues.get((cboValues.size() / 2) - 1));
        // }

        return medianCBO;
    }

}
