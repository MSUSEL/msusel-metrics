/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.PackageNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * ANIV - Average Number of Instance Variables per Class. ANIV = Total NIV /
 * Total NC.
 * 
 * @author Isaac Griffith
 */
public class ANIV extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -7875676006575460610L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ANIV getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ANIV("Average Number of Instance Variables per Class", "ANIV = Total NIV / Total NC", "ANIV",
                MetricScope.SystemLevel, entity, graph);
    }

    /**
     * 
     */
    private double totalClasses;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ANIV(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double aniv = 0;

        if (entity instanceof PackageNode)
        {
            double totalNIV = 0;

            for (final ProgramNode pe : tree.getClasses((PackageNode) entity))
            {
                totalNIV += pe.getMetric("NIV");
            }

            aniv = totalNIV / totalClasses;
        }

        return aniv;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        totalClasses = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
