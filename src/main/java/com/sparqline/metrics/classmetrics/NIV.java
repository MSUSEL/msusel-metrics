/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NIV - Number of Instance Variables. Measures relations of a class with other
 * objects in the program.
 * 
 * @author Isaac Griffith
 */
public class NIV extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -1484577013592005219L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NIV getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NIV("Number of Instance Variables in a Class",
                "Measures relations of a class with other objects in the program.", "NIV", MetricScope.ClassLevel,
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
    private NIV(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> fields = new LinkedList<>(tree.getFields(entity));
        for (final Iterator<ProgramNode> iter = fields.iterator(); iter.hasNext();)
        {
            final ProgramNode entity = iter.next();
            final FieldNode field = entity instanceof FieldNode ? (FieldNode) entity : null;

            if (field == null)
            {
                continue;
            }

            if (field.isStatic())
            {
                iter.remove();
            }
        }

        return fields.size();
    }
}
