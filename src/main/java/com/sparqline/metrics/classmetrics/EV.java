/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * EV - Number of Encapsulated Variables. Count of the number of private
 * attributes in the target class.
 * 
 * @author Isaac Griffith
 */
public class EV extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6569551912075378561L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static EV getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new EV("Number of Encapsulated Variables",
                "Count of the number of private attributes in the target class.", "EV", MetricScope.ClassLevel, entity,
                graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private EV(final String name, final String desc, final String acronym, final MetricScope scope,
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

        int count = 0;
        // for (final ProgramNode field : fields)
        // {
        // if (!((FieldNode)
        // field).getAccessibility().equals(Accessibility.Public))
        // {
        // count++;
        // }
        // }

        return count;
    }
}
