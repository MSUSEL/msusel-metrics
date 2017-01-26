/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.List;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

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
    public static ACX getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new ACX("Association Complexity",
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
            final CodeNode entity, final CodeTree graph)
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

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        // totalClasses = taskMap.containsKey("NC") ?
        // taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
