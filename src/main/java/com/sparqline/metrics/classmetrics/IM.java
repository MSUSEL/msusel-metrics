/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.utils.SetOperations;
import com.sparqline.graph.utils.SetOperationsException;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static IM getInstance(final ProgramNode entity, final CodeGraph graph)
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
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param cls
     * @return
     */
    private Set<MethodNode> getFunctionalMethods(final ClassOrInterfaceNode cls)
    {
        final Set<MethodNode> retVal = new HashSet<>();

        for (final ProgramNode entity : tree.getMethods(cls))
        {
            if (entity instanceof MethodNode)
            {
                final MethodNode method = (MethodNode) entity;
                if (!method.isAbstract())
                {
                    retVal.add(method);
                }
            }
        }

        return retVal;
    }

    /**
     * @param supCls
     * @return
     */
    private Set<MethodNode> getFunctionalSuperMethods(final ClassOrInterfaceNode supCls)
    {
        final Set<MethodNode> retVal = new HashSet<>();

        for (final ProgramNode entity : tree.getMethods(supCls))
        {
            if (entity instanceof MethodNode)
            {
                final MethodNode method = (MethodNode) entity;
                if ((method.isAbstract() || method.isVirtual())
                        && !method.getAccessibility().equals(Accessibility.Private))
                {
                    retVal.add(method);
                }
            }
        }

        return retVal;
    }

    /**
     * @param cls
     * @return
     */
    private Set<MethodNode> getInheritedMethods(final ClassOrInterfaceNode cls)
    {
        final List<ProgramNode> superClasses = tree.getAllSuperClasses(cls);
        superClasses.addAll(tree.getAllSuperInterfaces(cls));
        final Set<MethodNode> supMethods = new HashSet<>();

        for (final ProgramNode sup : superClasses)
        {
            for (final ProgramNode meth : tree.getMethods(sup))
            {
                if (meth instanceof MethodNode)
                {
                    final MethodNode method = (MethodNode) meth;
                    if (!method.isAbstract() && !method.getAccessibility().equals(Accessibility.Private))
                    {
                        supMethods.add(method);
                    }
                }
            }
        }

        return supMethods;
    }

    /**
     * @param cls
     * @return
     */
    private Set<MethodNode> getOverriddenMethods(final ClassOrInterfaceNode cls)
    {
        final List<ProgramNode> superClasses = tree.getSuperClasses(cls);
        final Set<MethodNode> overridden = new HashSet<>();

        if (superClasses.isEmpty())
        {
            return new HashSet<>();
        }
        else
        {
            final Set<MethodNode> functionalMethods = getFunctionalMethods(cls);
            for (final ProgramNode pe : superClasses)
            {
                if (pe instanceof ClassOrInterfaceNode)
                {
                    final ClassOrInterfaceNode supCls = (ClassOrInterfaceNode) pe;
                    final Set<MethodNode> functionalSupMethods = getFunctionalSuperMethods(supCls);

                    for (final MethodNode me : functionalMethods)
                    {
                        for (final MethodNode sme : functionalSupMethods)
                        {
                            if (me.overrides(sme, tree))
                            {
                                overridden.add(sme);
                            }
                        }
                    }

                    overridden.addAll(getOverriddenMethods(supCls));
                }
            }
        }

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

        try
        {
            if (entity instanceof ClassOrInterfaceNode)
            {
                final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
                final Set<MethodNode> inherited = SetOperations.difference(getInheritedMethods(cls),
                        getOverriddenMethods(cls));

                im = inherited.size();
            }
        }
        catch (final SetOperationsException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return im;
    }
}
