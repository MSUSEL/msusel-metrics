/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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

    public static SC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new SC("Subclasses", "Count of the number of subclasses of this class.", "SC", MetricScope.ClassLevel,
                entity, graph);
    }

    private SC(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
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
        return tree.getSubClasses((ClassOrInterfaceNode) entity).size();
    }
}
