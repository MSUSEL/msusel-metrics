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
 * CBC - Coupling Between Classes. The average number of couplings per class.
 * CBC = Total CBO / NC.
 * 
 * @author Isaac Griffith
 */
public class CBC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8227045627463803710L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CBC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CBC("Coupling Between Classes", "The average number of couplings per class. CBC = Total CBO / NC.",
                "CBC", MetricScope.SystemLevel, entity, graph);
    }

    /**
     * 
     */
    private double numClasses;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CBC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double cbc = 0;
        double totalCBO = 0;

        if (entity instanceof SystemNode)
        {
            for (final ProgramNode cls : tree.getClasses((SystemNode) entity))
            {
                totalCBO += cls.getMetric("CBO");
            }

            cbc = totalCBO / numClasses;
        }

        return cbc;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        numClasses = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }

}
