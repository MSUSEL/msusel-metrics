package com.sparqline.metrics.field;

import com.sparqline.metrics.FieldMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.FieldNode;

public class IVMC extends FieldMetric {

    /**
      * 
      */
    private static final long serialVersionUID = -6179606493606447173L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static IVMC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new IVMC("Instance Variables per Method in a Class",
                "The number of methods that reference each instance variable defined in a class.", "IVMC",
                MetricScope.FieldLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private IVMC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double count = 0;

        if (entity instanceof FieldNode)
        {
            /*
             * final ProgramNode owner = tree.getFieldOwner((FieldNode) entity);
             * final List<ProgramNode> methods = tree.getMethods(owner);
             * for (final ProgramNode method : methods)
             * {
             * if (tree.isEdge(method, entity,
             * DirectedRelationshipType.FieldUse))
             * {
             * count++;
             * }
             * }
             */
        }
        return count;
    }
}
