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
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.graph.utils.SetOperations;
import com.sparqline.graph.utils.SetOperationsException;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * LD - Locality of Data. Relates the amount of data being local to the class to
 * the total amount of data used by the class. This relates to the quality of
 * abstraction embodied by the class and allows conclusions on the reuse
 * potential of the class and testability.
 * 
 * @author Isaac Griffith
 */
public class LD extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6744528826931568293L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LD getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LD(
                "Locality of Data",
                "Relates the amount of data being local to the class to the total amount of data used by the class. This relates to the quality of abstraction embodied by the class and allows conclusions on the reuse potential of the class and testability.",
                "LD", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LD(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @return
     */
    private List<MethodNode> getNonGetterSetterMethods()
    {
        final List<MethodNode> retVal = new LinkedList<>();

        for (final ProgramNode pe : tree.getMethods(entity))
        {
            if (pe instanceof MethodNode)
            {
                final MethodNode method = (MethodNode) pe;
                if (method.isAccessorMethod(tree) || method.isMutatorMethod(tree))
                {
                    continue;
                }

                retVal.add(method);
            }
        }

        return retVal;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double ld = 0;
        final Set<ProgramNode> setA = new HashSet<>();
        final Set<ProgramNode> setB = new HashSet<>();
        Set<ProgramNode> localAccess = new HashSet<>();
        final Set<ProgramNode> directAccess = new HashSet<>();
        final Set<ProgramNode> indirectAccess = new HashSet<>();
        Set<ProgramNode> totalAccess = new HashSet<>();

        if (entity instanceof ClassOrInterfaceNode)
        {
            final List<MethodNode> mstar = getNonGetterSetterMethods();

            for (final MethodNode method : mstar)
            {
                for (final Connection conn : tree.getEdgesContainingRelationType(method,
                        DirectedRelationshipType.FieldUse))
                {
                    final ProgramNode other = tree.getState().getOpposite(method, conn);
                    if (other instanceof FieldNode)
                    {
                        final ProgramNode otherOwn = tree.getFieldOwner((FieldNode) other);
                        if (otherOwn.equals(entity))
                        {
                            setA.add(other);
                        }

                        directAccess.add(other);
                    }
                }

                for (final Connection conn : tree.getEdgesContainingRelationType(method,
                        DirectedRelationshipType.MethodCall))
                {
                    final ProgramNode other = tree.getState().getOpposite(method, conn);
                    if (other instanceof MethodNode)
                    {
                        final MethodNode otherMethod = (MethodNode) other;
                        if (otherMethod.isAccessorMethod(tree) || otherMethod.isMutatorMethod(tree))
                        {
                            for (final Connection otherConn : tree.getEdgesContainingRelationType(otherMethod,
                                    DirectedRelationshipType.FieldUse))
                            {
                                final ProgramNode otherField = tree.getState().getOpposite(otherMethod, otherConn);
                                if (otherField instanceof FieldNode)
                                {
                                    final ProgramNode otherOwn = tree.getFieldOwner((FieldNode) otherField);
                                    if (otherOwn.equals(entity))
                                    {
                                        setB.add(otherField);
                                    }

                                    indirectAccess.add(otherField);
                                }
                            }

                        }
                    }
                }
            }

            try
            {
                localAccess = SetOperations.union(setA, setB);
                totalAccess = SetOperations.union(directAccess, indirectAccess);

                ld = (double) localAccess.size() / (double) totalAccess.size();
            }
            catch (final SetOperationsException e)
            {
            }
        }

        return ld;
    }
}
