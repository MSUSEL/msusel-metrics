/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * WMC - Weighted Methods per Class. A weighted measure of the complexities of
 * methods defined in a class. Measures maintainability and reusability. WMC =
 * Sum(CYCLO(m_i), for all i methods). Uses a normalized complexity such that
 * the median complexity should equal 1.0
 * 
 * @author Isaac Griffith
 */
public class WMC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -3662545555276934969L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static WMC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new WMC(
                "Weighted Methods per Class",
                "A weighted measure of the complexities of methods defined in a class. Measures maintainability and reusability. WMC = Sum(CYCLO(m_i), for all i methods). Uses a normalized complexity such that the median complexity should equal 1.0",
                "WMC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private WMC(final String name, final String desc, final String acronym, final MetricScope scope,
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

        final List<Double> complexities = new LinkedList<>();
        for (final ProgramNode method : methods)
        {
            complexities.add(method.getMetric("CYCLO"));
        }

        double medianComplexity = 0;
        if (complexities.isEmpty())
        {
            return medianComplexity;
        }
        if ((complexities.size() % 2) == 0)
        {
            medianComplexity = (complexities.get(complexities.size() / 2) + complexities.get(complexities.size() / 2)) / 2;
        }
        else if (((complexities.size() % 2) != 0) && (complexities.size() > 2))
        {
            medianComplexity = (complexities.get((complexities.size() / 2) + 1));
        }
        else
        {
            medianComplexity = (complexities.get(0));
        }

        double totalComplexity = 0;
        for (final double comp : complexities)
        {
            totalComplexity += comp / medianComplexity;
        }

        if (Double.isNaN(totalComplexity))
        {
            totalComplexity = 0;
        }
        return totalComplexity;
    }
}
