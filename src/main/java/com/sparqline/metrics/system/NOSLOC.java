/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static NOSLOC getInstance(final CodeNode entity, final CodeTree graph)
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
            final CodeNode entity, final CodeTree graph)
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
        // final List<StatementNode> stmts = new
        // LinkedList<>(me.getContainedStatements());
        // final Iterator<StatementNode> iter = stmts.iterator();
        // while (iter.hasNext())
        // {
        // if (iter.next() instanceof EmptyStatement)
        // {
        // iter.remove();
        // }
        // }
        //
        // return stmts.size() + getExpressionLOC(me);
        return 0;
    }

    /**
     * @param expr
     * @return
     */
    private int getExpressionLOC(final CodeNode me)
    {
        int retVal = 0;

        // final List<ObjectCreationExpression> exprs =
        // me.findExpressionByType(ObjectCreationExpression.class);
        // for (final ObjectCreationExpression expr : exprs)
        // {
        // final List<BodyNode> bt = expr.getAnonymousClassBody();
        //
        // for (final CodeNode ent : bt)
        // {
        // retVal += calculateLOC(ent);
        // }
        // }

        return retVal;
    }

    /**
     * @return
     */
    private Set<CodeNode> getHelperMethods()
    {
        final Set<CodeNode> containedMethods = new HashSet<>();
        final Set<CodeNode> helperMethods = new HashSet<>();
        // containedMethods.addAll(tree.getMethods(entity));
        // for (final ProgramNode pkg : tree.getPackages((SystemNode) entity))
        // {
        // containedMethods.addAll(tree.getMethods(pkg));
        // }
        //
        // for (final ProgramNode helper : containedMethods)
        // {
        // boolean isHelper = true;
        // for (final Connection conn :
        // tree.getEdgesContainingRelationType(helper,
        // DirectedRelationshipType.MethodInclude))
        // {
        // if (tree.getState().getOpposite(helper, conn) instanceof
        // ClassOrInterfaceNode)
        // {
        // isHelper = false;
        // }
        // }
        //
        // if (isHelper)
        // {
        // helperMethods.add(helper);
        // }
        // }

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

        // if (entity instanceof SystemNode)
        // {
        // final Set<ProgramNode> helpers = getHelperMethods();
        //
        // for (final ProgramNode helper : helpers)
        // {
        // if (helper instanceof MethodNode)
        // {
        // nosloc += calculateLOC((MethodNode) helper);
        // }
        // }
        // }

        return nosloc;
    }
}
