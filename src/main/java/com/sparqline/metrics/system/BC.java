/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * BC - Base Classes. The number of classes in the system which are inherited
 * from.
 * 
 * @author Isaac Griffith
 */
public class BC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 8065961946792636419L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static BC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new BC("Base Classes", "Number of classes in the system which are inherited from.", "BC",
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
    private BC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> classes = tree.getClasses();

        int count = 0;
        for (final ProgramNode entity : classes)
        {
            if (entity.getMetric("NOC") > 0)
            {
                count++;
            }
        }

        return count;
    }
}
