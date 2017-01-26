/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * PF - Polymorphism Factor. Number of overriding methods of a class as a ratio
 * of the total possible number of overridden methods. Measures
 * understandability and maintainability.
 * 
 * @author Isaac Griffith
 */
public class PF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 3709735751514679957L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static PF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new PF("Polymorphism Factor",
                "Number of overriding methods of a class as a ratio of the total possible number of overridden methods. Measures understandability and maintainability.",
                "PF", MetricScope.SystemLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private PF(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // final List<ProgramNode> classes = tree.getClasses();

        double totalOverridenMethods = 0;
        double newMethodsFactor = 0;

        // for (final ProgramNode cls : classes)
        // {
        // totalOverridenMethods += cls.getMetric("NMO");
        // newMethodsFactor += cls.getMetric("NMA") * cls.getMetric("NDC");
        // }

        return totalOverridenMethods / newMethodsFactor;
    }
}
