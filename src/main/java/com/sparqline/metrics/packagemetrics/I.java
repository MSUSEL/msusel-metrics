package com.sparqline.metrics.packagemetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;

/**
 * I - Instability. Measures the ratio between the outgoing and the total number
 * of in- and out-going couplings from classes inside the package from/to
 * classes outside the package. Each class counts only one. Zero, if the package
 * does not contain classes or if external classes are not used by the package's
 * classes. I(p) = Ce / (Ca + Ce)
 * 
 * @author Isaac
 */
public class I extends PackageMetric {

    /**
     * 
     */
    private double Ce;
    /**
     * 
     */
    private double Ca;

    /**
     * 
     */
    private static final long serialVersionUID = -2768307564434259081L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static I getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new I(
                "Instability",
                "Measures the ratio between the outgoing and the total number of in- and out-going couplings from classes inside the package from/to classes outside the package. Each class counts only once. Zero if the package does not contain classes or if external classes are not used by the package's classes. I(p) = Ce / (Ca + Ce)",
                "I", MetricScope.PackageLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private I(final String name, final String desc, final String acronym, final MetricScope scope,
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
        return Ce / (Ca + Ce);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        Ca = taskMap.containsKey("Ca") ? taskMap.get("Ca").join().getValue() : entity.getMetric("Ca");
        Ce = taskMap.containsKey("Ce") ? taskMap.get("Ce").join().getValue() : entity.getMetric("Ce");
    }
}
