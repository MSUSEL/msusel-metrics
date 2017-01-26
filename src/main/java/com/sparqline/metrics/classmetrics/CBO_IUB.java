package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * CBO_IUB - Coupling Between Objects: Is Used By. This definition of CBO merges
 * two coupling directsions: classes using the target class and classes used by
 * the target class.
 * 
 * @author Isaac Griffith
 */
public class CBO_IUB extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 3061855440431194979L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CBO_IUB getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CBO_IUB("Coupling Between Objects: Is Used By",
                "This definition of CBO merges two coupling directsions: classes using the target class and classes used by the target class.",
                "CBO_IUB", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CBO_IUB(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final double cbo_iub = 0;

        if (entity instanceof TypeNode)
        {

        }

        return cbo_iub;
    }
}
