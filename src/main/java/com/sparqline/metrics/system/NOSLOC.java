/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.Connection;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.BodyNode;
import com.sparqline.graph.nodes.CodeNode;
import com.sparqline.graph.nodes.StatementNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.expression.ObjectCreationExpression;
import com.sparqline.graph.nodes.statement.EmptyStatement;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * NOSLOC - Non Object-Oriented Source Lines of Code. The SLOC of Helper
 * Methods.
 * 
 * @author Isaac
 */
public class NOSLOC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4080881279691726285L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NOSLOC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOSLOC("Non Object-Oriented Source Lines of Code", "The SLOC of Helper Methods", "NOSLOC",
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
    private NOSLOC(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param me
     * @return
     */
    private int calculateLOC(final CodeNode me)
    {
        return 1 + getAllStatementsButEmpty(me);
    }

    /**
     * @param me
     * @return
     */
    private int getAllStatementsButEmpty(final CodeNode me)
    {
        final List<StatementNode> stmts = new LinkedList<>(me.getContainedStatements());
        final Iterator<StatementNode> iter = stmts.iterator();
        while (iter.hasNext())
        {
            if (iter.next() instanceof EmptyStatement)
            {
                iter.remove();
            }
        }

        return stmts.size() + getExpressionLOC(me);
    }

    /**
     * @param expr
     * @return
     */
    private int getExpressionLOC(final CodeNode me)
    {
        int retVal = 0;

        final List<ObjectCreationExpression> exprs = me.findExpressionByType(ObjectCreationExpression.class);
        for (final ObjectCreationExpression expr : exprs)
        {
            final List<BodyNode> bt = expr.getAnonymousClassBody();

            for (final CodeNode ent : bt)
            {
                retVal += calculateLOC(ent);
            }
        }

        return retVal;
    }

    /**
     * @return
     */
    private Set<ProgramNode> getHelperMethods()
    {
        final Set<ProgramNode> containedMethods = new HashSet<>();
        final Set<ProgramNode> helperMethods = new HashSet<>();
        containedMethods.addAll(tree.getMethods(entity));
        for (final ProgramNode pkg : tree.getPackages((SystemNode) entity))
        {
            containedMethods.addAll(tree.getMethods(pkg));
        }

        for (final ProgramNode helper : containedMethods)
        {
            boolean isHelper = true;
            for (final Connection conn : tree.getEdgesContainingRelationType(helper,
                    DirectedRelationshipType.MethodInclude))
            {
                if (tree.getState().getOpposite(helper, conn) instanceof ClassOrInterfaceNode)
                {
                    isHelper = false;
                }
            }

            if (isHelper)
            {
                helperMethods.add(helper);
            }
        }

        return helperMethods;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double nosloc = 0;

        if (entity instanceof SystemNode)
        {
            final Set<ProgramNode> helpers = getHelperMethods();

            for (final ProgramNode helper : helpers)
            {
                if (helper instanceof MethodNode)
                {
                    nosloc += calculateLOC((MethodNode) helper);
                }
            }
        }

        return nosloc;
    }
}
