/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * ANA -
 * 
 * @author Isaac Griffith
 */
public class ANA extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5031886526757704510L;

    public static ANA getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ANA("Abstraction", "", "ANA", MetricScope.SystemLevel, entity, graph);
    }

    private ANA(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double value = 0.0d;

        if (entity instanceof SystemNode)
        {
            final SystemNode sys = (SystemNode) entity;
            final Set<ProgramNode> systemClasses = new HashSet<>();
            systemClasses.addAll(sys.getClasses());

            double totalNAC = 0.0d;
            for (ProgramNode ce : systemClasses)
            {
                totalNAC += ce.getMetric("NAC");
            }

            value = totalNAC / systemClasses.size();
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }
}
