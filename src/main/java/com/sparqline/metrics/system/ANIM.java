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
 * ANIM - Average Number of Public Instance Methods per Class. ANIM = Total PIM
 * / Total NC
 * 
 * @author Isaac Griffith
 */
public class ANIM extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2938755285344827866L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ANIM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ANIM("Average Number of Public Instance Methods per Class.", "ANIM = Total PIM / Total NC.", "ANIM",
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
    private ANIM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double anim = 0;
        if (entity instanceof PackageNode)
        {
            final PackageNode pkg = (PackageNode) entity;

            double totalPIM = 0;

            for (final ProgramNode cls : tree.getClasses(pkg))
            {
                totalPIM += cls.getMetric("PIM");
                totalClasses++;
            }

            anim = totalPIM / totalClasses;
        }

        return anim;
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
