package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * PNAS - Percentage of Newly Added Services. The number of public methods of a
 * class that are not overridden or specialized from ancestors, divided by the
 * total number of public methods.
 * 
 * @author Isaac Griffith
 */
public class PNAS extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8298684776444864230L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static PNAS getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new PNAS(
                "Percentatge of Newly Added Services",
                "The number of public methods of a class that are not overridden or specialized from ancestors, divided by the total number of public methods.",
                "PNAS", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private PNAS(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @return
     */
    private List<MethodNode> getAllInheritedMethods()
    {
        final List<ProgramNode> superClasses = tree.getAllSuperClasses((ClassOrInterfaceNode) entity);
        final List<MethodNode> inherited = new LinkedList<>();

        for (final ProgramNode sup : superClasses)
        {
            final List<ProgramNode> supMethods = tree.getMethods(sup);
            for (final ProgramNode supMeth : supMethods)
            {
                if (supMeth instanceof MethodNode)
                {
                    final MethodNode method = (MethodNode) supMeth;
                    if (!method.getAccessibility().equals(Accessibility.Private))
                    {
                        inherited.add(method);
                    }
                }
            }
        }

        return inherited;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final List<MethodNode> inherited = getAllInheritedMethods();
        final List<MethodNode> pubMethods = new LinkedList<>();
        double newServices = 0;

        for (final ProgramNode pe : tree.getMethods(entity))
        {
            if (pe instanceof MethodNode)
            {
                final MethodNode method = (MethodNode) pe;
                if (method.getAccessibility().equals(Accessibility.Public))
                {
                    pubMethods.add(method);
                }
            }
        }

        for (final MethodNode method : pubMethods)
        {
            for (final MethodNode inherit : inherited)
            {
                if (!method.overrides(inherit, tree))
                {
                    newServices++;
                }
            }
        }

        return newServices / pubMethods.size();
    }
}
