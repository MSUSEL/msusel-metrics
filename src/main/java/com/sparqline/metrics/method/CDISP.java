package com.sparqline.metrics.method;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.ExpressionEntity;
import com.sparqline.graph.nodes.TypeNode;
import com.sparqline.graph.nodes.VariableNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.body.Parameter;
import com.sparqline.graph.nodes.expression.ClassExpression;
import com.sparqline.graph.nodes.expression.MethodCallExpression;
import com.sparqline.graph.nodes.expression.NameExpression;
import com.sparqline.graph.nodes.expression.SuperExpression;
import com.sparqline.graph.nodes.expression.SuperMemberAccessExpression;
import com.sparqline.graph.nodes.expression.VariableDeclarationExpression;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * CDISP - Coupling Dispersion. The number of classes in which the operations
 * called from the measured operation are defined, divided by CINT.
 * 
 * @author Isaac Griffith
 */
public class CDISP extends MethodMetric {

    private double CINT = 1;

    /**
     * 
     */
    private static final long serialVersionUID = -673097662615735183L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CDISP getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CDISP(
                "Coupling Dispersion",
                "The number of classes in which the operations called from the measured operation are defined, divided by CINT",
                "CDISP", MetricScope.MethodLevel, entity, graph);
    }

    private CDISP(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double cdisp = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            Set<ClassOrInterfaceNode> callOwners = new HashSet<>();
            Set<MethodNode> mces = method.getMethodCalls();
            /*for (MethodEntity mce : mces)
            {
                ExpressionEntity scope = mce.getScope();
                if (scope != null)
                {
                    if (scope instanceof SuperExpression)
                    {
                        SuperExpression sup = (SuperExpression) scope;
                        TypeEntity type = ((ClassExpression) sup.getClassExpression()).getType();
                        Set<String> imps = ((ClassOrInterfaceEntity) graph.getMethodOwner(method)).getImports();
                        callOwners.add((ClassOrInterfaceEntity) type);
                    }
                    else if (scope instanceof SuperMemberAccessExpression)
                    {
                        SuperMemberAccessExpression smae = (SuperMemberAccessExpression) scope;
                        Set<ProgramEntity> sups = new HashSet<>();
                        sups.addAll(graph.getAllSuperClasses((ClassOrInterfaceEntity) graph.getMethodOwner(method)));
                        for (ProgramEntity ent : sups)
                        {
                            boolean found = false;
                            List<ProgramEntity> methods = graph.getMethods(ent);
                            for (ProgramEntity pe : methods)
                            {
                                if (((MethodEntity) pe).getName().equals(mce.getMethodName())
                                        && !((MethodEntity) pe).isAbstract())
                                {
                                    callOwners.add((ClassOrInterfaceEntity) ent);
                                    found = true;
                                    break;
                                }
                            }

                            if (found)
                                break;
                        }
                    }
                    else if (scope instanceof ClassExpression)
                    {
                        ClassExpression ce = (ClassExpression) scope;
                        TypeEntity type = ce.getType();
                        callOwners.add((ClassOrInterfaceEntity) type);
                    }
                    else if (scope instanceof NameExpression)
                    {
                        String name = ((NameExpression) scope).getContent();
                        TypeEntity type = null;
                        for (Parameter param : method.getParameters())
                        {
                            if (param.getName().equals(name))
                            {
                                type = param.getType();
                            }
                        }
                        if (type == null)
                        {
                            for (VariableDeclarationExpression vde : method.getVariableDeclarations())
                            {
                                boolean found = false;
                                for (VariableEntity ve : vde.getVars())
                                {
                                    String value = ve.getName();
                                    if (name.equals(value))
                                    {
                                        type = ve.getType();
                                        found = true;
                                        break;
                                    }
                                }
                                if (found)
                                {
                                    break;
                                }
                            }
                        }

                        if (type == null)
                        {
                            for (ProgramEntity fe : graph.getFields(graph.getMethodOwner(method)))
                            {
                                FieldEntity field = (FieldEntity) fe;
                                if (name.equals(field.getName()))
                                {
                                    type = field.getType();
                                    break;
                                }
                            }
                        }
                        if (type instanceof ClassOrInterfaceEntity)
                        {
                            callOwners.add((ClassOrInterfaceEntity) type);
                        }
                    }
                }
                else
                {
                    callOwners.add((ClassOrInterfaceEntity) graph.getMethodOwner(method));
                }
            }
            
            method.setCalledMethodClasses(callOwners);

            if (CINT != 0)
            {
                cdisp = callOwners.size() / CINT;
            }
            else
            {
                cdisp = 0;
            }*/
        }

        return cdisp;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        CINT = taskMap.containsKey("CINT") ? taskMap.get("CINT").join().getValue() : entity.getMetric("CINT");
    }
}
