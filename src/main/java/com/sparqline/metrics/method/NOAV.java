package com.sparqline.metrics.method;

import java.util.ArrayList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.VariableNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.body.Parameter;
import com.sparqline.graph.nodes.expression.NameExpression;
import com.sparqline.graph.nodes.expression.QualifiedNameExpression;
import com.sparqline.graph.nodes.expression.VariableDeclarationExpression;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NOAV - Number of Accessed Variables. The total number of variables accessed
 * directly from the measured operation. Variables include parameters, local
 * variables, but also instance variables and global variables.
 * 
 * @author Isaac Griffith
 */
public class NOAV extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -3929872169331381396L;

    public static NOAV getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOAV(
                "Number of Accessed Variables",
                "The total number of variables accessed directly from the measured operation. Variables include parameters, local variables, but also instance variables and global variables.",
                "NOAV", MetricScope.MethodLevel, entity, graph);
    }

    private NOAV(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param method
     * @return
     */
    private int getNumberOfAccessedFields(final MethodNode method)
    {
        int count = 0;

        count = tree.getEdgesContainingRelationType(method, DirectedRelationshipType.FieldUse).size();

        return count;
    }

    /**
     * @param method
     * @return
     */
    private int getNumberOfAccessedLocalVariables(final MethodNode method)
    {
        int count = 0;

        final List<VariableDeclarationExpression> varDecs = method
                .findExpressionByType(VariableDeclarationExpression.class);
        final List<String> varNames = new ArrayList<>();
        for (final VariableDeclarationExpression varDec : varDecs)
        {
            for (final VariableNode var : varDec.getVars())
            {
                varNames.add(var.getName());
            }
        }

        final List<NameExpression> nameExprs = method.findExpressionByType(NameExpression.class);
        for (final NameExpression nameExpr : nameExprs)
        {
            if (nameExpr instanceof QualifiedNameExpression)
            {
                continue;
            }
            else if (varNames.contains(nameExpr.getContent()))
            {
                count++;
            }
        }

        return count;
    }

    /**
     * @param method
     * @return
     */
    private int getNumberOfAccessedParameters(final MethodNode method)
    {
        int count = 0;

        for (final Parameter param : method.getParameters())
        {
            final String name = param.getName();

            final List<NameExpression> nameExprs = method.findExpressionByType(NameExpression.class);
            for (final NameExpression nameExpr : nameExprs)
            {
                if (nameExpr instanceof QualifiedNameExpression)
                {
                    continue;
                }
                else if (nameExpr.getContent().equals(name))
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
        double noav = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;

            // noav += getNumberOfAccessedFields(method);
            // noav += getNumberOfAccessedLocalVariables(method);
            // noav += getNumberOfAccessedParameters(method);
            if (!method.isAbstract())
            {
                noav += method.getVariableDeclarations().size();
                noav += method.getFieldAccess().size();
                noav += method.getParameters().size();
            }
        }

        return noav;
    }
}
