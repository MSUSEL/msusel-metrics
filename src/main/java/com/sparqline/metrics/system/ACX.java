/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

import edu.uci.ics.jung.graph.Graph;

/**
 * ACX - Association Complexity. ACX = R - NC + 2P. Where R is the number of
 * interactions between objects, P is the number of disconnected parts in the
 * graph, and NC is the number of classes.
 * 
 * @author Isaac Griffith
 */
public class ACX extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4159276647904184870L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ACX getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ACX(
                "Association Complexity",
                "ACX = R - NC + 2P. Where R is the number of interactions between objects, P is the number of disconnected parts in the graph, and NC is the number of classes.",
                "ACX", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * 
     */
    private double totalClasses;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ACX(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
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

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
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

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        totalClasses = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
