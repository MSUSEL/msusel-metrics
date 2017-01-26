/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static NIV getInstance(final CodeNode entity, final CodeTree graph)
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
        // final List<ProgramNode> fields = new
        // LinkedList<>(tree.getFields(entity));
        // for (final Iterator<ProgramNode> iter = fields.iterator();
        // iter.hasNext();)
        // {
        // final ProgramNode entity = iter.next();
        // final FieldNode field = entity instanceof FieldNode ? (FieldNode)
        // entity : null;
        //
        // if (field == null)
        // {
        // continue;
        // }
        //
        // if (field.isStatic())
        // {
        // iter.remove();
        // }
        // }
        //
        // return fields.size();

        return 0;
    }
}
