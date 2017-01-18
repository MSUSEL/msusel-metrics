package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NOPA - Number of Public Attributes. The number of public attributes of a
 * class.
 * 
 * @author Isaac Griffith
 */
public class NOPA extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4809854319157705966L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NOPA getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOPA("Number of Public Attributes", "The number of public attributes of a class.", "NOPA",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NOPA(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> fields = tree.getFields(entity);

        double nopa = 0;

        for (final ProgramNode pe : fields)
        {
            if (pe instanceof FieldNode)
            {
                if (((FieldNode) pe).getAccessibility().equals(Accessibility.Public))
                {
                    nopa++;
                }
            }
        }

        return nopa;
    }

}
