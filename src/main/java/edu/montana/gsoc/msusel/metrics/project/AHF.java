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
package edu.montana.gsoc.msusel.metrics.project;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.ProjectMetric;
import edu.montana.gsoc.msusel.node.FieldNode;

/**
 * Attribute Hiding Factor. Ratio of hidden attributes to total attributes. A
 * measure of encapsulation.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class AHF extends ProjectMetric {

    /**
     * Total number of classes defined in the system
     */
    private double numClasses = 0.0;

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static AHF getInstance()
    {
        return new AHF(
                "Attribute Hiding Factor",
                "Ratio of hidden attributes to total attributes. A measure of encapsulation.", "AHF");
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
    private AHF(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // final List<CodeNode> classes = tree.getClasses();

        double totalFields = 1.0;
        double totalVisibility = 0.0;

        /*
         * for (final CodeNode cls : classes)
         * {
         * final List<CodeNode> fields = tree.getFields(cls);
         * totalFields += fields.size();
         * double visible = 0.0;
         * for (final CodeNode field : fields)
         * {
         * visible += visibility((FieldNode) field);
         * }
         * totalVisibility += visible;
         * }
         */

        return totalVisibility / totalFields;
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

    /**
     * @param attribute
     * @return
     */
    private double visibility(final FieldNode attribute)
    {
        /*
         * if (attribute.getAccessibility().equals(Accessibility.Public))
         * {
         * return 1;
         * }
         * else if (attribute.getAccessibility().equals(Accessibility.Private))
         * {
         * return 0;
         * }
         * else if
         * (attribute.getAccessibility().equals(Accessibility.Protected))
         * {
         * return (tree.getAllSubClasses((ClassOrInterfaceNode) entity).size())
         * / (numClasses - 1);
         * }
         * else
         * {
         * return (tree.getClasses(((ClassOrInterfaceNode)
         * entity).getPackage()).size()) / (numClasses - 1);
         * }
         */
        return 1.0;
    }
}
