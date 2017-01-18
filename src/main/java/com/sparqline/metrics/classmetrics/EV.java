/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static EV getInstance(final ProgramNode entity, final CodeGraph graph)
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

        int count = 0;
        for (final ProgramNode field : fields)
        {
            if (!((FieldNode) field).getAccessibility().equals(Accessibility.Public))
            {
                count++;
            }
        }

        return count;
    }
}
