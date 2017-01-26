package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static ER getInstance(final CodeNode entity, final CodeTree graph)
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
        // final List<ProgramNode> fields = tree.getFields(entity);
        double retVal = 0;
        int countPriv = 0;
        int numFields = 0;

        // for (final ProgramNode pe : fields)
        // {
        // if (pe instanceof FieldNode)
        // {
        // final FieldNode field = (FieldNode) pe;
        // numFields++;
        // if (field.getAccessibility().equals(Accessibility.Private))
        // {
        // countPriv++;
        // }
        // }
        // }
        //
        // if (numFields > 0)
        // {
        // retVal = (double) countPriv / (double) numFields;
        // }

        return retVal;
    }
}
