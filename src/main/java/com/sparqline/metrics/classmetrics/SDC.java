package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * SDC - Size of Duplication Chain. To improve the code we need to see more than
 * just a pile of small duplication chunks. We want to see the big picture,
 * i.e., to cluster the chunks of duplication into a more meaningful block of
 * duplication. This is what we call a duplication chain. Thus, a duplication
 * chain is composed of smaller islands of exact clones that are close enough
 * pairwise to be considered as belonging together, i.e., there LB value is less
 * than a given threshold.
 * 
 * @author Isaac Griffith
 */
public class SDC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6066264369445697340L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static SDC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new SDC(
                "Size of Duplication Chain",
                "To improve the code we need to see more than just a pile of small duplication chunks. We want to see the big picture, i.e., to cluster the chunks of duplication into a more meaningful block of duplication. This is what we call a duplication chain. Thus, a duplication chain is composed of smaller islands of exact clones that are close enough pairwise to be considered as belonging together, i.e., there LB value is less than a given threshold.",
                "SDC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private SDC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
