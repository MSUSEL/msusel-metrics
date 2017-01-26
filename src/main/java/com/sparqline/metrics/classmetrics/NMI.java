/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NMI - Number of Methods Inherited. Count of the number of methods a class has
 * from inheritance alone.
 * 
 * @author Isaac Griffith
 */
public class NMI extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1976689538612692998L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NMI getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NMI("Number of Methods Inherited by a Subclass",
                "Count of the number of methods a class has from inheritance alone.", "NMI", MetricScope.ClassLevel,
                entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NMI(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param cls
     * @return
     */
    // private Set<MethodNode> getFunctionalMethods(final ClassOrInterfaceNode
    // cls)
    // {
    // final Set<MethodNode> retVal = new HashSet<>();
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
    // return retVal;
    // }

    /**
     * @param supCls
     * @return
     */
    // private Set<MethodNode> getFunctionalSuperMethods(final
    // ClassOrInterfaceNode supCls)
    // {
    // final Set<MethodNode> retVal = new HashSet<>();
    //
    // for (final MethodNode method : supCls.getMethods())
    // {
    // if (method.isVirtual())
    // {
    // retVal.add(method);
    // }
    // }
    //
    // return retVal;
    // }

    /**
     * @param cls
     * @return
     */
    // private Set<MethodNode> getInheritedMethods(final ClassOrInterfaceNode
    // cls)
    // {
    // final List<ClassOrInterfaceNode> superClasses = new ArrayList<>();
    // superClasses.addAll(cls.getExtendsSet());
    // superClasses.addAll(cls.getImplementsSet());
    //
    // final Set<MethodNode> supMethods = new HashSet<>();
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
    // return supMethods;
    // }

    /**
     * @param cls
     * @return
     */
    // private Set<MethodNode> getOverriddenMethods(final ClassOrInterfaceNode
    // cls)
    // {
    // final List<ProgramNode> superClasses = tree.getSuperClasses(cls);
    // final Set<MethodNode> overridden = new HashSet<>();
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
    // return overridden;
    // }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double nmi = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        // final Set<MethodNode> inherited = getInheritedMethods(cls);
        //
        // nmi = inherited.size();
        // // System.out.println("\nNMI="+nmi+"\n");
        // }

        return nmi;
    }
}
