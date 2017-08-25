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
 * Lack of Cohesion in Object Methods 3. Consider an undirected graph G, where
 * the vertices are the methods of the class, and there is an edge between two
 * vertices if the corresponding methods use at least an attribute in common.
 * LCOM is then the number of connected components in G.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class LCOM3 extends ClassMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static LCOM3 getInstance()
    {
        return new LCOM3(
                "Lack of Cohesion in Object Methods 3",
                "Consider an undirected graph G, where the vertices are the methods of the class, and there is an edge between two vertices if the corresponding methods use at least an attribute in common. LCOM is then the number of connected components in G.",
                "LCOM3");
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
    private LCOM3(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * @param methods
     * @param subgraph
     */
    // private void buildGraph(final List<MethodNode> methods, final
    // Graph<MethodNode, String> subgraph)
    // {
    // final Map<FieldNode, List<MethodNode>> fieldsToMethods = new HashMap<>();
    //
    // for (final ProgramNode pe : tree.getFields(entity))
    // {
    // if (pe instanceof FieldNode)
    // {
    // fieldsToMethods.put((FieldNode) pe, new LinkedList<MethodNode>());
    // }
    // }
    //
    // for (final MethodNode method : methods)
    // {
    // final List<Connection> fieldUses =
    // tree.getEdgesContainingRelationType(method,
    // DirectedRelationshipType.FieldUse);
    // for (final Connection conn : fieldUses)
    // {
    // final ProgramNode opp = tree.getState().getOpposite(method, conn);
    // if (fieldsToMethods.containsKey(opp))
    // {
    // final List<MethodNode> list = fieldsToMethods.get(opp);
    // list.add(method);
    // fieldsToMethods.put((FieldNode) opp, list);
    // }
    // }
    // }
    //
    // for (final FieldNode field : fieldsToMethods.keySet())
    // {
    // final List<MethodNode> meths = fieldsToMethods.get(field);
    // for (int i = 0; i < meths.size(); i++)
    // {
    // for (int j = i + 1; j < meths.size(); j++)
    // {
    // final MethodNode arg1 = meths.get(i);
    // final MethodNode arg2 = meths.get(j);
    // subgraph.addEdge(arg1.getName() + " to " + arg2.getName(), arg1, arg2);
    // }
    // }
    // }
    // }

    /**
     * @param method
     * @param colors
     * @return
     */
    // private List<MethodNode> findColor(final MethodNode method, final
    // List<List<MethodNode>> colors)
    // {
    // for (final List<MethodNode> color : colors)
    // {
    // if (color.contains(method))
    // {
    // return color;
    // }
    // }
    //
    // return null;
    // }

    /**
     * @return
     */
    // private List<MethodNode> getFunctionalMethods()
    // {
    // final List<MethodNode> retVal = new LinkedList<>();
    //
    // for (final ProgramNode pe : tree.getMethods(entity))
    // {
    // if (pe instanceof MethodNode)
    // {
    // final MethodNode method = (MethodNode) pe;
    // if (method.isAbstract())
    // {
    // continue;
    // }
    //
    // retVal.add(method);
    // }
    // }
    //
    // return retVal;
    // }

    /**
     * @param subgraph
     * @return
     */
    // private double getNumberOfConnectedComponents(final Graph<MethodNode,
    // String> subgraph)
    // {
    // final List<List<MethodNode>> colors = new LinkedList<>();
    //
    // for (final MethodNode me : subgraph.getVertices())
    // {
    // final List<MethodNode> color = new LinkedList<>();
    // color.add(me);
    // colors.add(color);
    // }
    //
    // for (final MethodNode me : subgraph.getVertices())
    // {
    // process(me, subgraph, colors);
    // }
    //
    // return colors.size();
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // final Graph<MethodNode, String> subgraph = new SparseMultigraph<>();
        double lcom = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final List<MethodNode> methods = getFunctionalMethods();
        // buildGraph(methods, subgraph);
        //
        // lcom = getNumberOfConnectedComponents(subgraph);
        // }

        return lcom;
    }

    /**
     * @param method
     * @param subgraph
     * @param colors
     */
    // private void process(final MethodNode method, final Graph<MethodNode,
    // String> subgraph,
    // final List<List<MethodNode>> colors)
    // {
    // final List<MethodNode> color = findColor(method, colors);
    // final List<String> edges = new
    // LinkedList<>(subgraph.getIncidentEdges(method));
    // final Set<MethodNode> otherVertices = new HashSet<>();
    // for (final String e : edges)
    // {
    // otherVertices.add(subgraph.getOpposite(method, e));
    // }
    //
    // for (final MethodNode other : otherVertices)
    // {
    // final List<MethodNode> otherColor = findColor(other, colors);
    // if (!otherColor.contains(method))
    // {
    // color.addAll(otherColor);
    // otherColor.clear();
    // colors.remove(otherColor);
    // }
    //
    // process(other, subgraph, colors);
    // }
    // }
}
