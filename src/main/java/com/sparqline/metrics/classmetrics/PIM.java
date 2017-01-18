/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * PIM - Number of Public Instance Methods in a class.
 * 
 * @author Isaac Griffith
 */
public class PIM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 80700667179124191L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static PIM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new PIM("Number of Public Instance Methods in a class.",
                "Count of the number of public methods locally defined within a class.", "PIM", MetricScope.ClassLevel,
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
    private PIM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> methods = tree.getMethods(entity);

        double pim = 0;

        for (final ProgramNode pe : methods)
        {
            if (pe instanceof MethodNode)
            {
                if (((MethodNode) pe).getAccessibility().equals(Accessibility.Public))
                {
                    pim++;
                }
            }
        }

        return pim;
    }

}
