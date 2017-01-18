/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.Connection;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.graph.utils.SetOperations;
import com.sparqline.graph.utils.SetOperationsException;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * RFC - Response for a Class. The number of methods in the set of all methods
 * that can be invoked in response to a message sent to an object of a class.
 * 
 * @author Isaac Griffith
 */
public class RFC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4392135905350824143L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static RFC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new RFC(
                "Response for a Class",
                "The number of methods in the set of all methods that can be invoked in response to a message sent to an object of a class.",
                "RFC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private RFC(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final List<Set<ProgramNode>> responseSets = new LinkedList<>();

        final Set<ProgramNode> methods = new HashSet<>(tree.getMethods(entity));
        Set<ProgramNode> rs = new HashSet<>();

        for (final ProgramNode entity : methods)
        {
            final List<Connection> calls = tree.getEdgesContainingRelationType(entity,
                    DirectedRelationshipType.MethodCall);
            final Set<ProgramNode> responseSet = new HashSet<>();

            for (final Connection conn : calls)
            {
                final ProgramNode callee = tree.getState().getDest(conn);
                responseSet.add(callee);
            }

            responseSets.add(responseSet);
        }

        rs.addAll(methods);
        for (final Set<ProgramNode> responseSet : responseSets)
        {
            try
            {
                rs = SetOperations.union(rs, responseSet);
            }
            catch (final SetOperationsException e)
            {
            }
        }

        return rs.size();
    }
}
