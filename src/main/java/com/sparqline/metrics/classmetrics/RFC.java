/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static RFC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new RFC("Response for a Class",
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
            final CodeNode entity, final CodeTree graph)
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
        // final List<Set<ProgramNode>> responseSets = new LinkedList<>();
        //
        // final Set<ProgramNode> methods = new
        // HashSet<>(tree.getMethods(entity));
        Set<CodeNode> rs = new HashSet<>();

        // for (final ProgramNode entity : methods)
        // {
        // final List<Connection> calls =
        // tree.getEdgesContainingRelationType(entity,
        // DirectedRelationshipType.MethodCall);
        // final Set<ProgramNode> responseSet = new HashSet<>();
        //
        // for (final Connection conn : calls)
        // {
        // final ProgramNode callee = tree.getState().getDest(conn);
        // responseSet.add(callee);
        // }
        //
        // responseSets.add(responseSet);
        // }
        //
        // rs.addAll(methods);
        // for (final Set<ProgramNode> responseSet : responseSets)
        // {
        // try
        // {
        // rs = SetOperations.union(rs, responseSet);
        // }
        // catch (final SetOperationsException e)
        // {
        // }
        // }

        return rs.size();
    }
}
