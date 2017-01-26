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
 * AC - Abstract Classes. Number of abstract classes in a system.
 * 
 * @author Isaac Griffith
 */
public class AC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5102498096270650072L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new AC("Abstract Classes", "Number of abstract classes in a system", "AC", MetricScope.SystemLevel,
                entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    public AC(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
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
        int count = 0;
        if (entity instanceof ProjectNode)
        {

            /*
             * for (final CodeNode pe : tree.getSystemClasses((ProjectNode)
             * entity))
             * {
             * if (pe instanceof TypeNode)
             * {
             * if (((TypeNode) entity).isAbstract()
             * || ((TypeNode) entity).isInterface())
             * {
             * count++;
             * }
             * }
             * }
             */
        }

        return count;
    }
}
