package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * WOC - Weight of a Class. The number of functional public methods divided by
 * the total number of public methods.
 * 
 * @author Isaac Griffith
 */
public class WOC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5130563723947230223L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static WOC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new WOC("Weight of a Class",
                "The number of \"functional\" public methods divided by the total number of public members.", "WOC",
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
    private WOC(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
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
        double measure = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final List<MethodNode> pubMethods = new LinkedList<>();
        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // if (method.getAccessibility().equals(Accessibility.Public))
        // {
        // pubMethods.add(method);
        // }
        // }
        // }
        //
        // int abstractCount = 0;
        // for (final MethodNode method : pubMethods)
        // {
        // if (method.isAbstract())
        // {
        // abstractCount++;
        // }
        // }
        //
        // if (!pubMethods.isEmpty())
        // {
        // measure = (double) (pubMethods.size() - abstractCount) / (double)
        // pubMethods.size();
        // }
        // }

        return measure;
    }
}
