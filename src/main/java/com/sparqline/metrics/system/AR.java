package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * AR - Abstraction Ratio. The number of abstract classes divided by the total
 * number of classes.
 * 
 * @author Isaac Griffith
 */
public class AR extends SystemMetric {

    /**
     * 
     */
    private double nc;
    /**
     * 
     */
    private double ac;

    /**
     * 
     */
    private static final long serialVersionUID = 695991844281940296L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AR getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new AR("Abstraction Ratio", "The number of abstract classes divided by the total number of classes.",
                "AR", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private AR(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return ac / nc;
    }

    /**
     * 
     */
    @Override
    public void setPrerequisites()
    {
        nc = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue() : entity.getMetric("NC");
        ac = taskMap.containsKey("AC") ? taskMap.get("AC").join().getValue() : entity.getMetric("AC");
    }
}
