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
 * NOM -
 * 
 * @author Isaac Griffith
 */
public class NOM extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static NOM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOM("Average Number of Methods", "", "NOM", MetricScope.SystemLevel, entity, graph);
    }

    private NOM(final String name, final String desc, final String acronym, final MetricScope scope,
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

            double totalNOM = 0.0d;
            for (ProgramNode ce : systemClasses)
            {
                totalNOM += ce.getMetric("NOM");
            }

            value = totalNOM / systemClasses.size();
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }

}
