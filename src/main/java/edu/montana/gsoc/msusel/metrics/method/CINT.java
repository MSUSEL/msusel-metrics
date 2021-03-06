/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.metrics.method;

import java.util.HashSet;
import java.util.Set;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.MethodMetric;
import edu.montana.gsoc.msusel.node.MethodNode;

/**
 * Coupling Intensity. The number of distinct operations called by the measured
 * operation.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CINT extends MethodMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static CINT getInstance()
    {
        return new CINT(
                "Coupling Intensity", "The number of distinct operations called by the measured operation.", "CINT");
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
    private CINT(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double cint = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            Set<MethodNode> calledMethods = new HashSet<>();
            /*
             * List<MethodCallExpression> mces = method.getMethodCalls();
             * for (MethodCallExpression mce : mces)
             * {
             * ClassOrInterfaceEntity owner = null;
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
             * owner = (ClassOrInterfaceEntity) type;
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
             * owner = (ClassOrInterfaceEntity) ent;
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
             * owner = (ClassOrInterfaceEntity) type;
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
             * owner = (ClassOrInterfaceEntity) type;
             * }
             * }
             * }
             * else
             * {
             * owner = (ClassOrInterfaceEntity) graph.getMethodOwner(method);
             * }
             * if (owner != null)
             * {
             * Set<MethodEntity> methods = owner.getMethods();
             * for (MethodEntity m : methods)
             * {
             * if (m.getName().equals(mce.getMethodName()))
             * {
             * calledMethods.add(m);
             * break;
             * }
             * }
             * }
             * }
             */

            cint = calledMethods.size();

            // method.setCalledMethods(calledMethods);
        }

        return cint;
    }
}
