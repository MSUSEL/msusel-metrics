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
import com.sparqline.graph.nodes.CodeNode;
import com.sparqline.graph.nodes.TypeNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * CBO - Coupling Between Objects. Counts the number of classes a class is
 * coupled with.
 * 
 * @author Isaac Griffith
 */
public class CBO extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6209457768911928027L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CBO getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CBO("Coupling Between Objects", "Counts the number of classes a class is coupled with.", "CBO",
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
    private CBO(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final Set<ProgramNode> collection = new HashSet<>();

        for (final ProgramNode meth : tree.getMethods(entity))
        {
            final List<Connection> conns = tree.getConnectionsByType(meth, DirectedRelationshipType.MethodCall);
            conns.addAll(tree.getConnectionsByType(meth, DirectedRelationshipType.FieldUse));

            for (final Connection rel : conns)
            {
                ProgramNode other = tree.getState().getOpposite(meth, rel);
                if (other instanceof FieldNode)
                {
                    collection.add((other = tree.getFieldOwner((FieldNode) other)));
                }
                else if (other instanceof MethodNode)
                {
                    collection.add((other = tree.getMethodOwner((MethodNode) other)));
                }
                else if (other instanceof TypeNode)
                {
                    collection.add(other);
                }

                if (other instanceof ClassOrInterfaceNode)
                {
                    collection.addAll(tree.getSubClasses((ClassOrInterfaceNode) other));
                }
            }

            conns.clear();
            conns.addAll(tree.getConnectionsByType(tree.getMethodOwner((CodeNode) meth),
                    DirectedRelationshipType.Generalization));
            conns.addAll(tree.getConnectionsByType(tree.getMethodOwner((CodeNode) meth),
                    DirectedRelationshipType.InterfaceRealization));
            for (final Connection rel : conns)
            {
                ProgramNode other = tree.getState().getOpposite(tree.getMethodOwner((CodeNode) meth), rel);
                if (other instanceof ClassOrInterfaceNode)
                {
                    collection.addAll(tree.getSubClasses((ClassOrInterfaceNode) other));
                }
            }
        }

        return collection.size();
    }
}
