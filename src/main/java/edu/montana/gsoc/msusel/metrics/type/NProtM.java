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

import java.util.Set;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.ClassMetric;
import edu.montana.gsoc.msusel.node.FieldNode;
import edu.montana.gsoc.msusel.node.MethodNode;
import edu.montana.gsoc.msusel.node.TypeNode;

/**
 * Number of Protected Members. The number of protected attributes and
 * methods of a class.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class NProtM extends ClassMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static NProtM getInstance()
    {
        return new NProtM(
                "Number of Protected Members", "The number of protected attributes and methods of a class.", "NProtM");
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
    private NProtM(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        int count = 0;

        if (entity instanceof TypeNode)
        {
            TypeNode tn = (TypeNode) entity;
            final Set<MethodNode> methods = tn.getMethods();
            final Set<FieldNode> fields = tn.getFields();

            // for (final MethodNode entity : methods)
            // {
            // if (entity.getAccessibility().equals(Accessibility.Protected))
            // {
            // count++;
            // }
            // }
            //
            // for (final FieldNode entity : fields)
            // {
            // if (entity.getAccessibility().equals(Accessibility.Protected))
            // {
            // count++;
            // }
            // }
        }

        return count;
    }

}