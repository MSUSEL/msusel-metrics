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
package edu.montana.gsoc.msusel.metrics.method;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.MethodMetric;
import edu.montana.gsoc.msusel.metrics.annotations.MetricScope;
import edu.montana.gsoc.msusel.node.CodeNode;
import edu.montana.gsoc.msusel.node.MethodNode;

/**
 * Changing Methods. The number of distinct methods that call the measured
 * method
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class ChM extends MethodMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static ChM getInstance()
    {
        return new ChM("Changing Methods", "The number of distinct methods that call the measured method", "ChM");
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
    private ChM(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double chm = 0;

        if (entity instanceof MethodNode)
        {
            /*
             * final Set<ProgramNode> callSet = new HashSet<>();
             * final MethodNode method = (MethodNode) entity;
             * ClassOrInterfaceNode methodOwner = (ClassOrInterfaceNode)
             * tree.getMethodOwner(method);
             * Set<ProgramNode> others = new HashSet<>();
             * others.addAll(tree.getMethods());
             * others.remove(method);
             * for (ProgramNode pe : others)
             * {
             * MethodNode other = (MethodNode) pe;
             * if (other.getCalledMethods().contains(method))
             * callSet.add(other);
             * }
             * chm = callSet.size();
             */
        }

        return chm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // double CINT = taskMap.containsKey("CINT") ?
        // taskMap.get("CINT").join().getValue() : entity.getMetric("CINT");
    }
}
