/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.codetree.metrics.utility;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.montana.gsoc.msusel.codetree.node.TypeNode;
import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.node.CodeNode;
import edu.montana.gsoc.msusel.codetree.node.MethodNode;

/**
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class MetricTreeUtils {

    public static Set<CodeNode> getHelperMethods(final INode entity, final CodeTree tree)
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

    public static double visibility(final INode node, final CodeTree tree)
    {
        /*
         * if (method.getAccessibility().equals(Accessibility.Public))
         * {
         * return 1;
         * }
         * else if (method.getAccessibility().equals(Accessibility.Private))
         * {
         * return 0;
         * }
         * else if (method.getAccessibility().equals(Accessibility.Protected))
         * {
         * return (tree.getAllSubClasses((ClassOrInterfaceNode) entity).size())
         * / (numClasses - 1);
         * }
         * else
         * {
         * return (tree.getClasses(((ClassOrInterfaceNode)
         * entity).getPackage()).size()) / (numClasses - 1);
         * }
         */
        return 0;
    }

    public static int isClient(final INode client, final INode supplier, final CodeTree tree)
    {
        /*
         * if (tree.isEdge(client, supplier,
         * AssociationRelationshipType.DirectedAssociation)
         * || tree.isEdge(client, supplier, DirectedRelationshipType.Usage)
         * || tree.isEdge(client, supplier,
         * AssociationRelationshipType.Extension))
         * {
         * return 1;
         * }
         * else
         * {
         * return 0;
         * }
         */
        return 0;
    }

    public static Set<TypeNode> getPackageClasses(final INode entity, final CodeTree tree)
    {
        final Set<TypeNode> componentClasses = new HashSet<>();

        /*
         * if (entity instanceof PackageNode)
         * {
         * for (final CodeNode cls : tree.getClasses((PackageNode) entity))
         * {
         * if (cls instanceof TypeNode)
         * {
         * componentClasses.add((TypeNode) cls);
         * }
         * }
         * }
         */
        return componentClasses;
    }

    public static Set<TypeNode> getSystemClassesExcludingPackageClasses(final INode entity,
            final Set<TypeNode> componentClasses, final CodeTree tree)
    {
        Set<TypeNode> systemClasses = new HashSet<>();

        /*
         * for (final CodeNode entity : tree.getClasses())
         * {
         * if (entity instanceof TypeNode)
         * {
         * systemClasses.add((TypeNode) entity);
         * }
         * }
         * for (final CodeNode entity : tree.getInterfaces())
         * {
         * if (entity instanceof TypeNode)
         * {
         * systemClasses.add((TypeNode) entity);
         * }
         * }
         * try
         * {
         * systemClasses = SetOperations.difference(systemClasses,
         * componentClasses);
         * }
         * catch (final SetOperationsException e)
         * {
         * systemClasses.clear();
         * }
         */

        return systemClasses;
    }

    public static int getNumberOfAccessedFields(final MethodNode method, final CodeTree tree)
    {
        int count = 0;

        // count = tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.FieldUse).size();

        return count;
    }

    public static int getNumberOfAccessedLocalVariables(final MethodNode method, final CodeTree tree)
    {
        int count = 0;

        /*
         * final List<VariableDeclarationExpression> varDecs = method
         * .findExpressionByType(VariableDeclarationExpression.class);
         * final List<String> varNames = Lists.newArrayList();
         * for (final VariableDeclarationExpression varDec : varDecs)
         * {
         * for (final VariableNode var : varDec.getVars())
         * {
         * varNames.add(var.getName());
         * }
         * }
         * final List<NameExpression> nameExprs =
         * method.findExpressionByType(NameExpression.class);
         * for (final NameExpression nameExpr : nameExprs)
         * {
         * if (nameExpr instanceof QualifiedNameExpression)
         * {
         * continue;
         * }
         * else if (varNames.contains(nameExpr.getContent()))
         * {
         * count++;
         * }
         * }
         */

        return count;
    }

    public static int getNumberOfAccessedParameters(final MethodNode method, final CodeTree tree)
    {
        int count = 0;

        /*
         * for (final Parameter param : method.getParameters())
         * {
         * final String name = param.getName();
         * final List<NameExpression> nameExprs =
         * method.findExpressionByType(NameExpression.class);
         * for (final NameExpression nameExpr : nameExprs)
         * {
         * if (nameExpr instanceof QualifiedNameExpression)
         * {
         * continue;
         * }
         * else if (nameExpr.getContent().equals(name))
         * {
         * count++;
         * }
         * }
         * }
         */

        return count;
    }

    public static double foreignAttributeAccesses(final MethodNode method, final CodeTree tree)
    {
        double count = 0;

        /*
         * final List<Connection> calls = tree.getConnectionsByType(method,
         * DirectedRelationshipType.MethodCall);
         * for (final Connection call : calls)
         * {
         * final CodeNode callee = tree.getState().getDest(call);
         * if (callee instanceof MethodNode)
         * {
         * final MethodNode me = (MethodNode) callee;
         * if (me.isAccessorMethod(tree) || me.isMutatorMethod(tree))
         * {
         * if (!tree.getMethodOwner(me).equals(entity))
         * {
         * count++;
         * }
         * }
         * }
         * }
         * final List<Connection> uses = tree.getConnectionsByType(method,
         * DirectedRelationshipType.FieldUse);
         * for (final Connection use : uses)
         * {
         * final CodeNode used = tree.getState().getDest(use);
         * if (used instanceof FieldNode)
         * {
         * final CodeNode otherClass = tree.getFieldOwner((FieldNode) used);
         * if (!otherClass.equals(entity))
         * {
         * count++;
         * }
         * }
         * }
         */

        return count;
    }

    public static Set<CodeNode> foreignDataProviders(final MethodNode method, final CodeTree tree)
    {
        final Set<CodeNode> fdps = new HashSet<>();

        /*
         * final List<Connection> calls = tree.getConnectionsByType(method,
         * DirectedRelationshipType.MethodCall);
         * for (final Connection call : calls)
         * {
         * final ProgramNode callee = tree.getState().getDest(call);
         * if (callee instanceof MethodNode)
         * {
         * final MethodNode me = (MethodNode) callee;
         * if (me.isAccessorMethod(tree) || me.isMutatorMethod(tree))
         * {
         * if (!tree.getMethodOwner(me).equals(entity))
         * {
         * fdps.add(tree.getMethodOwner(method));
         * }
         * }
         * }
         * }
         * final List<Connection> uses = tree.getConnectionsByType(method,
         * DirectedRelationshipType.FieldUse);
         * for (final Connection use : uses)
         * {
         * final ProgramNode used = tree.getState().getDest(use);
         * if (used instanceof FieldNode)
         * {
         * final ProgramNode otherClass = tree.getFieldOwner((FieldNode) used);
         * if (!otherClass.equals(entity))
         * {
         * fdps.add(otherClass);
         * }
         * }
         * }
         */

        return fdps;
    }

    public static Set<MethodNode> getFunctionalMethods(final TypeNode cls, final CodeTree tree)
    {
        final Set<MethodNode> retVal = new HashSet<>();
        //
        // for (final MethodNode method : cls.getMethods())
        // {
        // if (!method.isAbstract())
        // {
        // retVal.add(method);
        // }
        //
        // }
        //
        return retVal;
    }

    public static Set<MethodNode> getFunctionalSuperMethods(final TypeNode supCls, final CodeTree tree)
    {
        final Set<MethodNode> retVal = new HashSet<>();
        //
        // for (final MethodNode method : supCls.getMethods())
        // {
        // if (method.isVirtual())
        // {
        // retVal.add(method);
        // }
        // }
        //
        return retVal;
    }

    public static Set<MethodNode> getInheritedMethods(final TypeNode cls, final CodeTree tree)
    {
        // final List<ClassOrInterfaceNode> superClasses = Lists.newArrayList();
        // superClasses.addAll(cls.getExtendsSet());
        // superClasses.addAll(cls.getImplementsSet());
        //
        final Set<MethodNode> supMethods = new HashSet<>();
        //
        // for (final ClassOrInterfaceNode sup : superClasses)
        // {
        // for (final MethodNode method : sup.getMethods())
        // {
        // if (method.isVirtual())
        // {
        // supMethods.add(method);
        // }
        // }
        // }
        //
        return supMethods;
    }

    public static Set<MethodNode> getOverriddenMethods(final TypeNode cls, final CodeTree tree)
    {
        // final List<ProgramNode> superClasses = tree.getSuperClasses(cls);
        final Set<MethodNode> overridden = new HashSet<>();
        //
        // if (superClasses.isEmpty())
        // {
        // return new HashSet<>();
        // }
        // else
        // {
        // final Set<MethodNode> functionalMethods = getFunctionalMethods(cls);
        // for (final ProgramNode pe : superClasses)
        // {
        // if (pe instanceof ClassOrInterfaceNode)
        // {
        // final ClassOrInterfaceNode supCls = (ClassOrInterfaceNode) pe;
        // final Set<MethodNode> functionalSupMethods =
        // getFunctionalSuperMethods(supCls);
        //
        // for (final MethodNode me : functionalMethods)
        // {
        // for (final MethodNode sme : functionalSupMethods)
        // {
        // if (me.overrides(sme, tree))
        // {
        // overridden.add(sme);
        // }
        // }
        // }
        //
        // overridden.addAll(getOverriddenMethods(supCls));
        // }
        // }
        // }
        //
        return overridden;
    }

    public static int getHeight(final TypeNode cls, final CodeTree tree)
    {
        int retVal = 0;

        // if (tree.getSuperClasses(cls).isEmpty())
        // {
        // retVal = 1;
        // }
        // else
        // {
        // final List<Integer> depths = new LinkedList<>();
        // for (final ProgramNode sub : tree.getSuperClasses(cls))
        // {
        // if (sub instanceof ClassOrInterfaceNode)
        // {
        // depths.add(1 + getHeight((ClassOrInterfaceNode) sub));
        // }
        // }

        // retVal = Collections.max(depths);
        // }

        return retVal;
    }

    public static List<MethodNode> getAllInheritedMethods(final INode entity, final CodeTree tree)
    {
        // final List<ProgramNode> superClasses =
        // tree.getAllSuperClasses((ClassOrInterfaceNode) entity);
        final List<MethodNode> inherited = new LinkedList<>();

        // for (final ProgramNode sup : superClasses)
        // {
        // final List<ProgramNode> supMethods = tree.getMethods(sup);
        // for (final ProgramNode supMeth : supMethods)
        // {
        // if (supMeth instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) supMeth;
        // if (!method.getAccessibility().equals(Accessibility.Private))
        // {
        // inherited.add(method);
        // }
        // }
        // }
        // }

        return inherited;
    }

    public static int getAncestors(final TypeNode cie, final CodeTree tree)
    {
        int value = 0;

        Set<TypeNode> supers = new HashSet<>();
        // supers.addAll(cie.getExtendsSet());
        // supers.addAll(cie.getImplementsSet());
        // value = supers.size();
        // for (ClassOrInterfaceNode other : supers)
        // {
        // value += getAncestors(other);
        // }
        return value;
    }

    public static List<MethodNode> getNonGetterSetterMethods(final INode entity, final CodeTree tree)
    {
        final List<MethodNode> retVal = new LinkedList<>();
        //
        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // if (method.isAccessorMethod(tree) || method.isMutatorMethod(tree))
        // {
        // continue;
        // }
        //
        // retVal.add(method);
        // }
        // }
        //
        return retVal;
    }

    public static Set<CodeNode> getSuperAttributes(final TypeNode cls, final CodeTree tree)
    {
        final Set<CodeNode> retVal = new HashSet<>();

        // if (!tree.getSuperClasses(cls).isEmpty())
        // {
        // for (final ProgramNode sup : tree.getSuperClasses(cls))
        // {
        // for (final ProgramNode superAttrib : tree.getFields(sup))
        // {
        // for (final ProgramNode attrib : tree.getFields(cls))
        // {
        // if (!attrib.getName().equals(superAttrib.getName()))
        // {
        // retVal.add(superAttrib);
        // }
        // }
        // }
        // retVal.addAll(getSuperAttributes((ClassOrInterfaceNode) sup));
        // }
        // }

        return retVal;
    }

    public static List<MethodNode> getSuperMethods(final TypeNode cls, final CodeTree tree)
    {
        // final List<ProgramNode> superCls = tree.getSuperClasses(cls);
        final List<MethodNode> superMethods = new LinkedList<>();

        // for (final ProgramNode entity : superCls)
        // {
        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode superMethod = (MethodNode) pe;
        // if (superMethod.isVirtual() || superMethod.isAbstract())
        // {
        // superMethods.add(superMethod);
        // }
        // }
        // }
        // }
        // }

        return superMethods;

    }
}
