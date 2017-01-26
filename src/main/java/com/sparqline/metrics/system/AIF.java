/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static AIF getInstance(final CodeNode entity, final CodeTree graph)
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
        // final List<CodeNode> classes = tree.getClasses();

        double totalInheritedAttributes = 0;
        double totalAttributes = 0;

        /*for (final CodeNode cls : classes)
        {
            totalInheritedAttributes += cls.getMetric("IDM");
            totalAttributes += cls.getMetric("IDM") + cls.getMetric("NOF");
        }*/

        return totalInheritedAttributes / totalAttributes;
    }
}

