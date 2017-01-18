/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * ADI - Average Depth of Inheritance. The average depth of inheritance for the
 * classes in a system. If a class has no super classes then its inheritance
 * depth is 1. ADI = Total DIT / NC.
 * 
 * @author Isaac Griffith
 */
public class ADI extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6786118703284560164L;

    public static ADI getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ADI(
                "Average Depth of Inheritance",
                "The average depth of inheritance for the classes in a system. If a class has no super classes then its inheritance depth is 1. ADI = Total DIT / NC",
                "ADI", MetricScope.SystemLevel, entity, graph);
    }

    /**
     * 
     */
    private double numClasses;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ADI(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> classes = tree.getClasses();

        double totalDIT = 0;
        for (final ProgramNode cls : classes)
        {
            totalDIT = cls.getMetric("DIT");
        }

        return (totalDIT / numClasses);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        numClasses = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
