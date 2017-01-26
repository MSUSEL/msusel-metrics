package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * SEC - Size of Exact Clone. An exact clone is a group of consecutive
 * line-pairs that are detected as duplicated. Consequently, the Size of Exact
 * Clone metric measures the size of a clone in terms of LOC. The size of a
 * clone is relevant, because in most of the cases our interest in a piece of
 * duplicated code is proportional to its size.
 * 
 * @author Isaac Griffith
 */
public class SEC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2619703137601969283L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static SEC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new SEC("Size of Exact Clone",
                "An exact clone is a group of consecutive line-pairs that are detected as duplicated. Consequently, the Size of Exact Clone metric measures the size of a clnoe in terms of LOC. The size of a clone is relevant, because in most of the cases our interest in a piece of duplicated code is proportional to its size.",
                "SEC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private SEC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
