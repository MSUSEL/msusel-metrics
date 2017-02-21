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
 * Class Template Factor. Ratio of the number of classes using class templates
 * and the number of classes.
 * 
 * @author Isaac
 * @version 1.1.0
 */
public class CTF extends ProjectMetric {

    /**
     * 
     */
    private double numClasses;

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static CTF getInstance()
    {
        return new CTF(
                "Class Template Factor",
                "Ratio of the number of classes using class templates and the number of classes.", "CTF");
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
    private CTF(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * @return
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // final List<CodeNode> classes = tree.getClasses();
        // final List<CodeNode> interfaces = tree.getInterfaces();

        double templateClassCount = 0;

        /*
         * for (final CodeNode entity : classes)
         * {
         * if (entity instanceof TypeNode)
         * {
         * if (((TypeNode) entity).isTemplate())
         * {
         * templateClassCount++;
         * }
         * }
         * }
         */

        double numIntefaces = 0;

        /*
         * for (final CodeNode entity : interfaces)
         * {
         * if ((entity instanceof TypeNode) && ((TypeNode)
         * entity).isInterface())
         * {
         * if (((TypeNode) entity).isTemplate())
         * {
         * templateClassCount++;
         * }
         * numIntefaces++;
         * }
         * }
         */

        return templateClassCount / (numClasses + numIntefaces);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // numClasses = taskMap.containsKey("NC") ?
        // taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
