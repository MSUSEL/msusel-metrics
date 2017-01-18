package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * ER - Encapsulation Ratio. The number of private variables, divided by the
 * total number of variables.
 * 
 * @author Isaac Griffith
 */
public class ER extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6327145131045411671L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ER getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ER("Encapsulation Ratio",
                "The number of private variables, divided by the total number of variables.", "ER",
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
    private ER(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double retVal = 0;
        int countPriv = 0;
        int numFields = 0;

        for (final ProgramNode pe : fields)
        {
            if (pe instanceof FieldNode)
            {
                final FieldNode field = (FieldNode) pe;
                numFields++;
                if (field.getAccessibility().equals(Accessibility.Private))
                {
                    countPriv++;
                }
            }
        }

        if (numFields > 0)
        {
            retVal = (double) countPriv / (double) numFields;
        }

        return retVal;
    }
}
