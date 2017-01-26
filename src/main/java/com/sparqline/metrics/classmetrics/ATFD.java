package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * ATFD - Access To Foreign Data. The number of attributes from unrelated
 * classes that are accessed directly or by invoking accessor methods.
 * 
 * @author Isaac Griffith
 */
public class ATFD extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8896795345362203234L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ATFD getInstance(final CodeNode entity, final CodeTree graph)
    {
        // TODO add implementation and return statement
        return new ATFD("Access To Foreign Data",
                "The number of attributes from unrelated classes that are accessed directly or by invoking accessor methods.",
                "ATFD", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ATFD(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // final List<CodeNode> methods = tree.getMethods(entity);
        int count = 0;

        // for (final CodeNode pe : methods)
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        //
        // final List<Connection> calls =
        // tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.MethodCall);
        // for (final Connection call : calls)
        // {
        // final CodeNode callee = tree.getState().getDest(call);
        // if (callee instanceof MethodNode)
        // {
        // final MethodNode me = (MethodNode) callee;
        // if (me.isAccessorMethod(tree) || me.isMutatorMethod(tree))
        // {
        // if (!tree.getMethodOwner(me).equals(entity))
        // {
        // count++;
        // }
        // }
        // }
        // }
        //
        // final List<Connection> uses =
        // tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.FieldUse);
        // for (final Connection use : uses)
        // {
        // final CodeNode used = tree.getState().getDest(use);
        // if (used instanceof FieldNode)
        // {
        // final CodeNode otherClass = tree.getFieldOwner((FieldNode) used);
        // if (!otherClass.equals(entity))
        // {
        // count++;
        // }
        // }
        // }
        // }
        // }

        return count;
    }
}
