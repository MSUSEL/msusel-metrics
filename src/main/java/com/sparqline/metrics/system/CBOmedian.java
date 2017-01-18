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
 * CBO_median - Median Coupling Between Objects. This metric calculates the
 * median value of the CBO metric for a system.
 * 
 * @author Isaac Griffith
 */
public class CBOmedian extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 570639681069256590L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CBOmedian getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CBOmedian("Median Coupling Between Objects",
                "This metric calculates the median value of the CBO metric for a system.", "CBO_median",
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
    private CBOmedian(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double medianCBO = 0;
        final List<ProgramNode> entities = tree.getClasses();

        final List<Double> cboValues = new LinkedList<>();
        for (final ProgramNode entity : entities)
        {
            cboValues.add(entity.getMetric("CBO"));
        }

        Collections.sort(cboValues);

        if ((cboValues.size() % 2) == 0)
        {
            medianCBO = (cboValues.get((cboValues.size() / 2) - 1) + cboValues.get(cboValues.size() / 2)) / 2;
        }
        else
        {
            medianCBO = (cboValues.get((cboValues.size() / 2) - 1));
        }

        return medianCBO;
    }

}
