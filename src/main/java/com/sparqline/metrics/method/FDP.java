package com.sparqline.metrics.method;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

/**
 * FDP - Foreign Data Providers. The number of classes in which the attributes
 * accessed - in conformity with the ATFD metric - are defined.
 * 
 * @author Isaac Griffith
 */
public class FDP extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 8139337618979628568L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static FDP getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new FDP("Foreign Data Providers",
                "The number of classes in which the attributes accessed - in conformity with the ATFD metric - are defined.",
                "FDP", MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private FDP(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param method
     * @return
     */
    private Set<CodeNode> foreignDataProviders(final MethodNode method)
    {
        final Set<CodeNode> fdps = new HashSet<>();

        /*
         * final List<Connection> calls = tree.getConnectionsByType(method,
         * DirectedRelationshipType.MethodCall);
         * for (final Connection call : calls)
         * {
         * final ProgramNode callee = tree.getState().getDest(call);
         * if (callee instanceof MethodNode)
         * {
         * final MethodNode me = (MethodNode) callee;
         * if (me.isAccessorMethod(tree) || me.isMutatorMethod(tree))
         * {
         * if (!tree.getMethodOwner(me).equals(entity))
         * {
         * fdps.add(tree.getMethodOwner(method));
         * }
         * }
         * }
         * }
         * final List<Connection> uses = tree.getConnectionsByType(method,
         * DirectedRelationshipType.FieldUse);
         * for (final Connection use : uses)
         * {
         * final ProgramNode used = tree.getState().getDest(use);
         * if (used instanceof FieldNode)
         * {
         * final ProgramNode otherClass = tree.getFieldOwner((FieldNode) used);
         * if (!otherClass.equals(entity))
         * {
         * fdps.add(otherClass);
         * }
         * }
         * }
         */

        return fdps;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double numFDPs = 0;

        if (entity instanceof MethodNode)
        {
            numFDPs = foreignDataProviders((MethodNode) entity).size();
        }

        return numFDPs;
    }
}
