/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * SIX - Specialization Index. SIX = (NMO * HNL) / (NMI + NMA).
 * 
 * @author Isaac Griffith
 */
public class SIX extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 7860307889858862721L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static SIX getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new SIX("Specialization Index", "SIX = (NMO * HNL) / (NMI + NMA).", "SIX", MetricScope.ClassLevel,
                entity, graph);
    }

    /**
     * 
     */
    private double nmo;
    /**
     * 
     */
    private double hnl;
    /**
     * 
     */
    private double nmi;

    /**
     * 
     */
    private double nma;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private SIX(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return ((nmo * hnl) / (nmi + nma));
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        nmo = taskMap.containsKey("NMO") ? taskMap.get("NMO").join().getValue() : entity.getMetric("NMO");
        hnl = taskMap.containsKey("HNL") ? taskMap.get("HNL").join().getValue() : entity.getMetric("HNL");
        nmi = taskMap.containsKey("NMI") ? taskMap.get("NMI").join().getValue() : entity.getMetric("NMI");
        nma = taskMap.containsKey("NMA") ? taskMap.get("NMA").join().getValue() : entity.getMetric("NMA");
    }
}
