/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.ProjectNode;

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
     * @param graphGraph
     * @return
     */
    public static ASC getInstance(final CodeNode entity, final CodeTree graph)
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
            final CodeNode entity, final CodeTree graph)
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

        if (entity instanceof ProjectNode)
        {
            double totalSize = 0;
            double numClasses = 0;
            /*
             * for (final CodeNode cls : tree.getClasses((ProjectNode) entity))
             * {
             * numClasses++;
             * totalSize += cls.getMetric("SIZE2");
             * }
             */

            asc = totalSize / numClasses;
        }

        return asc;
    }
}
