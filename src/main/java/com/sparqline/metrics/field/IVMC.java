package com.sparqline.metrics.field;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.FieldMetric;
import com.sparqline.metrics.MetricScope;

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
    public static IVMC getInstance(final ProgramNode entity, final CodeGraph graph)
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
        double count = 0;

        if (entity instanceof FieldNode)
        {
            final ProgramNode owner = tree.getFieldOwner((FieldNode) entity);
            final List<ProgramNode> methods = tree.getMethods(owner);

            for (final ProgramNode method : methods)
            {
                if (tree.isEdge(method, entity, DirectedRelationshipType.FieldUse))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
