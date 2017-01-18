/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * AC - Abstract Classes. Number of abstract classes in a system.
 * 
 * @author Isaac Griffith
 */
public class AC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5102498096270650072L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new AC("Abstract Classes", "Number of abstract classes in a system", "AC", MetricScope.SystemLevel,
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
    public AC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        int count = 0;
        if (entity instanceof SystemNode)
        {

            for (final ProgramNode pe : tree.getSystemClasses((SystemNode) entity))
            {
                if (pe instanceof ClassOrInterfaceNode)
                {
                    if (((ClassOrInterfaceNode) entity).isAbstract()
                            || ((ClassOrInterfaceNode) entity).isInterface())
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
