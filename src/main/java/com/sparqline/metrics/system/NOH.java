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

public class NOH extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2325361177142303108L;

    public static NOH getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOH("Number of Hierarchies", "", "NOH", MetricScope.SystemLevel, entity, graph);
    }

    private NOH(final String name, final String desc, final String acronym, final MetricScope scope,
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

            for (ProgramNode ce : systemClasses)
            {
                if (Double.compare(0, ce.getMetric("DIT")) == 0)
                    value++;
            }
        }
        if (Double.isNaN(value))
            value = 0;
        return value;
    }
}
