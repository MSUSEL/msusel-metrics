/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * MIF - Method Inheritance Factor. Count of the number of inherited methods as
 * a ratio of total methods. Measures both inheritance and reuse.
 * 
 * @author Isaac Griffith
 */
public class MIF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 7899211850034554567L;

    public static MIF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new MIF("Method Inheritance Factor",
                "Count of the number of inherited methods as a ratio of total methods. Measures both inheritance and reuse.",
                "MIF", MetricScope.SystemLevel, entity, graph);
    }

    private MIF(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        // final List<CodeNode> classes = tree.getClasses();

        double totalInheritedMethods = 0;
        double totalMethods = 0;

        /*
         * for (final CodeNode cls : classes)
         * {
         * totalInheritedMethods += cls.getMetric("NMI");
         * totalMethods += cls.getMetric("NMI") + cls.getMetric("NOM");
         * }
         */

        return totalInheritedMethods / totalMethods;
    }
}
