/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * ASC - Average Size per Class.
 * 
 * @author Isaac
 */
public class ASC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6376485245240872516L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ASC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ASC("Average Size per Class", "", "ASC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ASC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double asc = 0;

        if (entity instanceof SystemNode)
        {
            double totalSize = 0;
            double numClasses = 0;
            for (final ProgramNode cls : tree.getClasses((SystemNode) entity))
            {
                numClasses++;
                totalSize += cls.getMetric("SIZE2");
            }

            asc = totalSize / numClasses;
        }

        return asc;
    }
}
