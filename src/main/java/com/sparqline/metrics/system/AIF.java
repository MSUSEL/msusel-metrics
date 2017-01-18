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
 * AIF - Attribute Inheritance Factor. Counts the number of inherited attributes
 * as a ratio of total attributes.
 * 
 * @author Isaac
 */
public class AIF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6140441098943388270L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AIF getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new AIF("Attribute Inheritance Factor",
                "Counts the number of inherited attributes as a ratio of total attributes.", "AIF",
                MetricScope.SystemLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private AIF(final String name, final String desc, final String acronym, final MetricScope scope,
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

        double totalInheritedAttributes = 0;
        double totalAttributes = 0;

        for (final ProgramNode cls : classes)
        {
            totalInheritedAttributes += cls.getMetric("IDM");
            totalAttributes += cls.getMetric("IDM") + cls.getMetric("NOF");
        }

        return totalInheritedAttributes / totalAttributes;
    }
}
