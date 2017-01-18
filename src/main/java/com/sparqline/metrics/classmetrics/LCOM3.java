/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.Connection;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

/**
 * LCOM3 - Lack of Cohesion in Object Methods 3. Consider an undirected graph G,
 * where the vertices are the methods of the class, and there is an edge between
 * two vertices if the corresponding methods use at least an attribute in
 * common. LCOM is then the number of connected components in G.
 * 
 * @author Isaac Griffith
 */
public class LCOM3 extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 7432331446650420069L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LCOM3 getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LCOM3(
                "Lack of Cohesion in Object Methods 3",
                "Consider an undirected graph G, where the vertices are the methods of the class, and there is an edge between two vertices if the corresponding methods use at least an attribute in common. LCOM is then the number of connected components in G.",
                "LCOM3", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LCOM3(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param methods
     * @param subgraph
     */
    private void buildGraph(final List<MethodNode> methods, final Graph<MethodNode, String> subgraph)
    {
        final Map<FieldNode, List<MethodNode>> fieldsToMethods = new HashMap<>();

        for (final ProgramNode pe : tree.getFields(entity))
        {
            if (pe instanceof FieldNode)
            {
                fieldsToMethods.put((FieldNode) pe, new LinkedList<MethodNode>());
            }
        }

        for (final MethodNode method : methods)
        {
            final List<Connection> fieldUses = tree.getEdgesContainingRelationType(method,
                    DirectedRelationshipType.FieldUse);
            for (final Connection conn : fieldUses)
            {
                final ProgramNode opp = tree.getState().getOpposite(method, conn);
                if (fieldsToMethods.containsKey(opp))
                {
                    final List<MethodNode> list = fieldsToMethods.get(opp);
                    list.add(method);
                    fieldsToMethods.put((FieldNode) opp, list);
                }
            }
        }

        for (final FieldNode field : fieldsToMethods.keySet())
        {
            final List<MethodNode> meths = fieldsToMethods.get(field);
            for (int i = 0; i < meths.size(); i++)
            {
                for (int j = i + 1; j < meths.size(); j++)
                {
                    final MethodNode arg1 = meths.get(i);
                    final MethodNode arg2 = meths.get(j);
                    subgraph.addEdge(arg1.getName() + " to " + arg2.getName(), arg1, arg2);
                }
            }
        }
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
     * @return
     */
    private List<MethodNode> getFunctionalMethods()
    {
        final List<MethodNode> retVal = new LinkedList<>();

        for (final ProgramNode pe : tree.getMethods(entity))
        {
            if (pe instanceof MethodNode)
            {
                final MethodNode method = (MethodNode) pe;
                if (method.isAbstract())
                {
                    continue;
                }

                retVal.add(method);
            }
        }

        return retVal;
    }

    /**
     * @param subgraph
     * @return
     */
    private double getNumberOfConnectedComponents(final Graph<MethodNode, String> subgraph)
    {
        final List<List<MethodNode>> colors = new LinkedList<>();

        for (final MethodNode me : subgraph.getVertices())
        {
            final List<MethodNode> color = new LinkedList<>();
            color.add(me);
            colors.add(color);
        }

        for (final MethodNode me : subgraph.getVertices())
        {
            process(me, subgraph, colors);
        }

        return colors.size();
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final Graph<MethodNode, String> subgraph = new SparseMultigraph<>();
        double lcom = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            final List<MethodNode> methods = getFunctionalMethods();
            buildGraph(methods, subgraph);

            lcom = getNumberOfConnectedComponents(subgraph);
        }

        return lcom;
    }

    /**
     * @param method
     * @param subgraph
     * @param colors
     */
    private void process(final MethodNode method, final Graph<MethodNode, String> subgraph,
            final List<List<MethodNode>> colors)
    {
        final List<MethodNode> color = findColor(method, colors);
        final List<String> edges = new LinkedList<>(subgraph.getIncidentEdges(method));
        final Set<MethodNode> otherVertices = new HashSet<>();
        for (final String e : edges)
        {
            otherVertices.add(subgraph.getOpposite(method, e));
        }

        for (final MethodNode other : otherVertices)
        {
            final List<MethodNode> otherColor = findColor(other, colors);
            if (!otherColor.contains(method))
            {
                color.addAll(otherColor);
                otherColor.clear();
                colors.remove(otherColor);
            }

            process(other, subgraph, colors);
        }
    }
}
