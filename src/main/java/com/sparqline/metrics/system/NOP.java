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
 * NOP - Average Number of Polymorphic Methods
 * 
 * @author Isaac Griffith
 */
public class NOP extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 8745881595270623402L;

    public static NOP getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOP("Average Number of Polymorphic Methods", "", "NOP", MetricScope.SystemLevel, entity, graph);
    }

    private NOP(final String name, final String desc, final String acronym, final MetricScope scope,
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

            double totalNOP = 0.0d;
            for (ProgramNode ce : systemClasses)
            {
                totalNOP += ce.getMetric("NOP");
            }

            value = totalNOP / systemClasses.size();
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }
}
