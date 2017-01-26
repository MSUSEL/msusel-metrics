/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * IM - Inherited Methods. Count of the number of methods that are inherited
 * from all the ancestor classes of the class.
 * 
 * @author Isaac Griffith
 */
public class IM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2991606330208744955L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static IM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new IM("Inherited Methods",
                "Count of the number of methods that are inherited from all the ancestor classes of the class.", "IM",
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
    private IM(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param cls
     * @return
     */
    private Set<MethodNode> getFunctionalMethods(final TypeNode cls)
    {
        final Set<MethodNode> retVal = new HashSet<>();

//        for (final ProgramNode entity : tree.getMethods(cls))
//        {
//            if (entity instanceof MethodNode)
//            {
//                final MethodNode method = (MethodNode) entity;
//                if (!method.isAbstract())
//                {
//                    retVal.add(method);
//                }
//            }
//        }

        return retVal;
    }

    /**
     * @param supCls
     * @return
     */
    private Set<MethodNode> getFunctionalSuperMethods(final TypeNode supCls)
    {
        final Set<MethodNode> retVal = new HashSet<>();

//        for (final ProgramNode entity : tree.getMethods(supCls))
//        {
//            if (entity instanceof MethodNode)
//            {
//                final MethodNode method = (MethodNode) entity;
//                if ((method.isAbstract() || method.isVirtual())
//                        && !method.getAccessibility().equals(Accessibility.Private))
//                {
//                    retVal.add(method);
//                }
//            }
//        }

        return retVal;
    }

    /**
     * @param cls
     * @return
     */
    private Set<MethodNode> getInheritedMethods(final TypeNode cls)
    {
//        final List<ProgramNode> superClasses = tree.getAllSuperClasses(cls);
//        superClasses.addAll(tree.getAllSuperInterfaces(cls));
        final Set<MethodNode> supMethods = new HashSet<>();

//        for (final ProgramNode sup : superClasses)
//        {
//            for (final ProgramNode meth : tree.getMethods(sup))
//            {
//                if (meth instanceof MethodNode)
//                {
//                    final MethodNode method = (MethodNode) meth;
//                    if (!method.isAbstract() && !method.getAccessibility().equals(Accessibility.Private))
//                    {
//                        supMethods.add(method);
//                    }
//                }
//            }
//        }

        return supMethods;
    }

    /**
     * @param cls
     * @return
     */
    private Set<MethodNode> getOverriddenMethods(final TypeNode cls)
    {
//        final List<ProgramNode> superClasses = tree.getSuperClasses(cls);
        final Set<MethodNode> overridden = new HashSet<>();

//        if (superClasses.isEmpty())
//        {
//            return new HashSet<>();
//        }
//        else
//        {
//            final Set<MethodNode> functionalMethods = getFunctionalMethods(cls);
//            for (final ProgramNode pe : superClasses)
//            {
//                if (pe instanceof TypeNode)
//                {
//                    final TypeNode supCls = (TypeNode) pe;
//                    final Set<MethodNode> functionalSupMethods = getFunctionalSuperMethods(supCls);
//
//                    for (final MethodNode me : functionalMethods)
//                    {
//                        for (final MethodNode sme : functionalSupMethods)
//                        {
//                            if (me.overrides(sme, tree))
//                            {
//                                overridden.add(sme);
//                            }
//                        }
//                    }
//
//                    overridden.addAll(getOverriddenMethods(supCls));
//                }
//            }
//        }

        return overridden;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double im = 0;

//        try
//        {
//            if (entity instanceof TypeNode)
//            {
        // final TypeNode cls = (TypeNode) entity;
//                final Set<MethodNode> inherited = SetOperations.difference(getInheritedMethods(cls),
//                        getOverriddenMethods(cls));
//
//                im = inherited.size();
//            }
//        }
//        catch (final SetOperationsException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        return im;
    }
}
