/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.Connection;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * CBO_U - Coupling Between Objects: Using. The part of CBO that consists of the
 * classes used by the target class.
 * 
 * @author Isaac Griffith
 */
public class CBO_U extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -7270544863760992071L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CBO_U getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CBO_U("Coupling Between Objects: Using",
                "The part of CBO that consists of the classes used by the target class.", "CBO_NA",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CBO_U(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final List<Connection> connections = tree.getEdgesContainingRelationType(entity,
                DirectedRelationshipType.Usage);

        final Set<ProgramNode> set = new HashSet<ProgramNode>();
        for (final Connection con : connections)
        {
            set.add(tree.getState().getOpposite(entity, con));
        }

        return set.size();
    }

}
