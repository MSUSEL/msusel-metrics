package com.sparqline.metrics.method;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.Connection;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * LAA - Locality of Attribute Accesses. The number of attributes from the
 * method's definition class, divided by the total number of variables accessed
 * (including attributes used via accessor methods, see ATFD), whereby the
 * number of local attributes accessed is computed in conformity with the LAA
 * specification.
 * 
 * @author Isaac
 */
public class LAA extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 904796005807106603L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LAA getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LAA(
                "Locality of Attribute Accesses",
                "The number of attributes from the method's definition class, divided by the total number of variables accessed (including attributes used via accessor methods, see ATFD), whereby the number of local attributes accessed is computed in conformity with the LAA specification.",
                "LAA", MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LAA(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param method
     * @return
     */
    private double foreignAttributeAccesses(final MethodNode method)
    {
        double count = 0;

        final List<Connection> calls = tree.getConnectionsByType(method, DirectedRelationshipType.MethodCall);
        for (final Connection call : calls)
        {
            final ProgramNode callee = tree.getState().getDest(call);
            if (callee instanceof MethodNode)
            {
                final MethodNode me = (MethodNode) callee;
                if (me.isAccessorMethod(tree) || me.isMutatorMethod(tree))
                {
                    if (!tree.getMethodOwner(me).equals(entity))
                    {
                        count++;
                    }
                }
            }
        }

        final List<Connection> uses = tree.getConnectionsByType(method, DirectedRelationshipType.FieldUse);
        for (final Connection use : uses)
        {
            final ProgramNode used = tree.getState().getDest(use);
            if (used instanceof FieldNode)
            {
                final ProgramNode otherClass = tree.getFieldOwner((FieldNode) used);
                if (!otherClass.equals(entity))
                {
                    count++;
                }
            }
        }

        return count;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double laa = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            final double localAttributesAccessed = tree.getFields(tree.getMethodOwner(method)).size();

            laa = localAttributesAccessed / (localAttributesAccessed + foreignAttributeAccesses(method));
        }

        if (Double.isNaN(laa))
            laa = 0;

        return laa;
    }
}
