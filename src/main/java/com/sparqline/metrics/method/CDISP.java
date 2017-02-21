/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sparqline.metrics.method;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.metrics.MethodMetric;

/**
 * Coupling Dispersion. The number of classes in which the operations called
 * from the measured operation are defined, divided by CINT.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CDISP extends MethodMetric {

    /**
     * 
     */
    private double CINT = 1;

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static CDISP getInstance()
    {
        return new CDISP(
                "Coupling Dispersion",
                "The number of classes in which the operations called from the measured operation are defined, divided by CINT",
                "CDISP");
    }

    /**
     * Constructs a new instance of this metric with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this metric
     * @param desc
     *            Description of this metric
     * @param acronym
     *            Acronym of this metric
     */
    private CDISP(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double cdisp = 0;

        if (entity instanceof MethodNode)
        {
            // final MethodNode method = (MethodNode) entity;
            // Set<ClassOrInterfaceNode> callOwners = new HashSet<>();
            // Set<MethodNode> mces = method.getMethodCalls();
            /*
             * for (MethodEntity mce : mces)
             * {
             * ExpressionEntity scope = mce.getScope();
             * if (scope != null)
             * {
             * if (scope instanceof SuperExpression)
             * {
             * SuperExpression sup = (SuperExpression) scope;
             * TypeEntity type = ((ClassExpression)
             * sup.getClassExpression()).getType();
             * Set<String> imps = ((ClassOrInterfaceEntity)
             * graph.getMethodOwner(method)).getImports();
             * callOwners.add((ClassOrInterfaceEntity) type);
             * }
             * else if (scope instanceof SuperMemberAccessExpression)
             * {
             * SuperMemberAccessExpression smae = (SuperMemberAccessExpression)
             * scope;
             * Set<ProgramEntity> sups = new HashSet<>();
             * sups.addAll(graph.getAllSuperClasses((ClassOrInterfaceEntity)
             * graph.getMethodOwner(method)));
             * for (ProgramEntity ent : sups)
             * {
             * boolean found = false;
             * List<ProgramEntity> methods = graph.getMethods(ent);
             * for (ProgramEntity pe : methods)
             * {
             * if (((MethodEntity) pe).getName().equals(mce.getMethodName())
             * && !((MethodEntity) pe).isAbstract())
             * {
             * callOwners.add((ClassOrInterfaceEntity) ent);
             * found = true;
             * break;
             * }
             * }
             * if (found)
             * break;
             * }
             * }
             * else if (scope instanceof ClassExpression)
             * {
             * ClassExpression ce = (ClassExpression) scope;
             * TypeEntity type = ce.getType();
             * callOwners.add((ClassOrInterfaceEntity) type);
             * }
             * else if (scope instanceof NameExpression)
             * {
             * String name = ((NameExpression) scope).getContent();
             * TypeEntity type = null;
             * for (Parameter param : method.getParameters())
             * {
             * if (param.getName().equals(name))
             * {
             * type = param.getType();
             * }
             * }
             * if (type == null)
             * {
             * for (VariableDeclarationExpression vde :
             * method.getVariableDeclarations())
             * {
             * boolean found = false;
             * for (VariableEntity ve : vde.getVars())
             * {
             * String value = ve.getName();
             * if (name.equals(value))
             * {
             * type = ve.getType();
             * found = true;
             * break;
             * }
             * }
             * if (found)
             * {
             * break;
             * }
             * }
             * }
             * if (type == null)
             * {
             * for (ProgramEntity fe :
             * graph.getFields(graph.getMethodOwner(method)))
             * {
             * FieldEntity field = (FieldEntity) fe;
             * if (name.equals(field.getName()))
             * {
             * type = field.getType();
             * break;
             * }
             * }
             * }
             * if (type instanceof ClassOrInterfaceEntity)
             * {
             * callOwners.add((ClassOrInterfaceEntity) type);
             * }
             * }
             * }
             * else
             * {
             * callOwners.add((ClassOrInterfaceEntity)
             * graph.getMethodOwner(method));
             * }
             * }
             * method.setCalledMethodClasses(callOwners);
             * if (CINT != 0)
             * {
             * cdisp = callOwners.size() / CINT;
             * }
             * else
             * {
             * cdisp = 0;
             * }
             */
        }

        return cdisp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // CINT = taskMap.containsKey("CINT") ?
        // taskMap.get("CINT").join().getValue() : entity.getMetric("CINT");
    }
}
