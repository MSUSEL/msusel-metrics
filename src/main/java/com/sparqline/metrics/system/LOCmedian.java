/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * LOC_median - Median Lines of Code. This metric calculates the median lines of
 * code for classes in the system.
 * 
 * @author Isaac Griffith
 */
public class LOCmedian extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5121549500017598018L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new AC("Median Lines of Code",
                "This metric calculates the median lines of code for classes in the system.", "LOC_median",
                MetricScope.SystemLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LOCmedian(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double medianLOC = 0;
        final List<ProgramNode> entities = tree.getClasses();

        final List<Double> locValues = new LinkedList<>();
        for (final ProgramNode entity : entities)
        {
            locValues.add(entity.getMetric("LOC"));
        }

        Collections.sort(locValues);

        if ((locValues.size() % 2) == 0)
        {
            medianLOC = (locValues.get((locValues.size() / 2) - 1) + locValues.get(locValues.size() / 2)) / 2;
        }
        else
        {
            medianLOC = (locValues.get((locValues.size() / 2) - 1));
        }

        return medianLOC;
    }

}
