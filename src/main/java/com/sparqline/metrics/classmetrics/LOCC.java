/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * LOCC - Lines of Code per Class. Sum of the LOC for each method.
 * 
 * @author Isaac Griffith
 */
public class LOCC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 8363950909347298041L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LOCC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new LOCC("Lines of Code per Class", "Sum of the LOC for each method.", "LOCC", MetricScope.ClassLevel,
                entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LOCC(final String name, final String desc, final String acronym, final MetricScope scope,
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

        double locc = 0;
        // for (final CodeNode entity : methods)
        // {
        // locc += entity.getMetric("SLOC");
        // }

        return locc;
    }
}
