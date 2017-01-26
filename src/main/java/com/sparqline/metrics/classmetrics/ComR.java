package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * ComR - Comment Ratio. Number of comments divided by the LOC
 * 
 * @author Isaac Griffith
 */
public class ComR extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8156338524383857514L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ComR getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new ComR("Comment Ratio", "Number of comments divided by the LOC", "ComR", MetricScope.ClassLevel,
                entity, graph);
    }

    /**
     * 
     */
    private double loc;
    /**
     * 
     */
    private double ncc;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ComR(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return ncc / loc;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        // loc = taskMap.containsKey("LOC") ?
        // taskMap.get("LOC").join().getValue() : entity.getMetric("LOC");
        // ncc = taskMap.containsKey("NCC") ?
        // taskMap.get("NCC").join().getValue() : entity.getMetric("NCC");
    }
}
