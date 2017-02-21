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

import java.util.List;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.metrics.ProjectMetric;

/**
 * Association Complexity. ACX = R - NC + 2P. Where R is the number of
 * interactions between objects, P is the number of disconnected parts in the
 * graph, and NC is the number of classes.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class ACX extends ProjectMetric {

    /**
     * Total number of classes defined in the system.
     */
    private double totalClasses;

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static ACX getInstance()
    {
        return new ACX(
                "Association Complexity",
                "ACX = R - NC + 2P. Where R is the number of interactions between objects, P is the number of disconnected parts in the graph, and NC is the number of classes.",
                "ACX");
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
    private ACX(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * @param method
     * @param colors
     * @return
     */
    private List<MethodNode> findColor(final MethodNode method, final List<List<MethodNode>> colors)
    {
        for (final List<MethodNode> color : colors)
        {
            if (color.contains(method))
            {
                return color;
            }
        }

        return null;
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

    /**
     * @param method
     * @param subgraph
     * @param colors
     */
    /*
     * private void process(final MethodNode method, final Graph<MethodNode,
     * String> subgraph,
     * final List<List<MethodNode>> colors)
     * {
     * final List<MethodNode> color = findColor(method, colors);
     * final List<String> edges = new
     * LinkedList<>(subgraph.getIncidentEdges(method));
     * final Set<MethodNode> otherVertices = new HashSet<>();
     * for (final String e : edges)
     * {
     * otherVertices.add(subgraph.getOpposite(method, e));
     * }
     * for (final MethodNode other : otherVertices)
     * {
     * final List<MethodNode> otherColor = findColor(other, colors);
     * if (!otherColor.contains(method))
     * {
     * color.addAll(otherColor);
     * otherColor.clear();
     * colors.remove(otherColor);
     * }
     * process(other, subgraph, colors);
     * }
     * }
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // totalClasses = taskMap.containsKey("NC") ?
        // taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
