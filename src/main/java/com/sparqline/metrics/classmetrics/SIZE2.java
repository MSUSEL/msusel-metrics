/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * SIZE2 - Class Size. Measures class size, where class size is the number of
 * attributes plus the number of local methods.
 * 
 * @author Isaac Griffith
 */
public class SIZE2 extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 7718368588208245749L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static SIZE2 getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new SIZE2("Class Size",
                "Measure class size, where class size is the number of attributes plus the number of local methods.",
                "SIZE2", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * 
     */
    private double nom = 0;
    /**
     * 
     */
    private double nof = 0;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private SIZE2(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return nof + nom;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        nof = taskMap.containsKey("NOF") ? taskMap.get("NOF").join().getValue() : entity.getMetric("NOF");
        nom = taskMap.containsKey("NOM") ? taskMap.get("NOM").join().getValue() : entity.getMetric("NOM");
    }
}
