/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * LOC - Lines of Code. Sum of LOC for all classes in the system.
 * 
 * @author Isaac Griffith
 */
public class LOC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8728850460214657313L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LOC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new LOC("Lines of Code", "Sum of LOC for all classes in the system", "LOC", MetricScope.ClassLevel,
                entity, graph);
    }

    private LOC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double loc = 0;

        /*
         * if (entity instanceof SystemNode)
         * {
         * for (final ProgramNode cls : tree.getClasses((SystemNode) entity))
         * {
         * loc += cls.getMetric("LOC");
         * }
         * }
         */

        return loc;
    }
}
