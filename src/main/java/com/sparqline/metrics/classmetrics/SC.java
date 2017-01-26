/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * SC - SubClasses. Count of the number of subclasses of this class.
 * 
 * @author Isaac Griffith
 */
public class SC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4200213370298888859L;

    public static SC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new SC("Subclasses", "Count of the number of subclasses of this class.", "SC", MetricScope.ClassLevel,
                entity, graph);
    }

    private SC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // return tree.getSubClasses((ClassOrInterfaceNode) entity).size();
        return 0;
    }
}
