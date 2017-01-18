package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * AMW - Average Method Weight. The average static complexity of all methods in
 * a class. McCabe's cyclomatic number is used to quantify the method's
 * complexity.
 * 
 * @author Isaac
 */
public class AMW extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -258029292616119514L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AMW getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new AMW(
                "Average Method Weight",
                "The average static complexity of all methods in a class. McCabe's cyclomatic number is used to quantify the method's complexity.",
                "AMW", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private AMW(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> methods = tree.getMethods(entity);

        double totalCyclo = 0.0d;
        for (final ProgramNode method : methods)
        {
            totalCyclo += method.getMetric("CYCLO");
        }

        return (totalCyclo / methods.size());
    }
}
