package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * AMW - Average Method Weight. The average static complexity of all methods in
 * a class. McCabe's cyclomatic number is used to quantify the method's
 * complexity.
 * 
 * @author Isaac
 */
public class AMW extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -258029292616119514L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AMW getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new AMW("Average Method Weight",
                "The average static complexity of all methods in a class. McCabe's cyclomatic number is used to quantify the method's complexity.",
                "AMW", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private AMW(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // final List<CodeNode> methods = tree.getMethods(entity);

        double totalCyclo = 0.0d;
        // for (final CodeNode method : methods)
        // {
        // totalCyclo += method.getMetric("CYCLO");
        // }

        // return (totalCyclo / methods.size());
        return totalCyclo;
    }
}
