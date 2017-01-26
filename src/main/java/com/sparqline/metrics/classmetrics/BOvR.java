package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * BOvR - Base Class Overriding Ratio. The number of methods of the measured
 * class that override methods from the base class, divided by the total number
 * of methods in the class.
 * 
 * @author Isaac Griffith
 */
public class BOvR extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4473418557035460842L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static BOvR getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new BOvR("Base Class Overriding Ratio",
                "The number of methods of the measured class that override methods from the base class, divided by the total number of methods in the class.",
                "BOvR", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private BOvR(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param cls
     * @return
     */
    private List<MethodNode> getSuperMethods(final TypeNode cls)
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

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double bovr = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // double overridingCount = 0;
        // double methodCount = 0;
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        // final List<ProgramNode> methods = tree.getMethods(cls);
        //
        // for (final ProgramNode pe : methods)
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // if (method.isAbstract() ||
        // method.getAccessibility().equals(Accessibility.Private))
        // {
        // continue;
        // }
        //
        // final List<MethodNode> superMethods = getSuperMethods(cls);
        // for (final MethodNode superMethod : superMethods)
        // {
        // if (method.overrides(superMethod, tree))
        // {
        // overridingCount++;
        // break;
        // }
        // }
        // }
        // methodCount++;
        // }
        //
        // if (methodCount != 0)
        // bovr = overridingCount / methodCount;
        // }

        return bovr;
    }
}
