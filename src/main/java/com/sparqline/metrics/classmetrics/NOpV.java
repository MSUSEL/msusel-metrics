package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.type.PrimitiveTypeNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NOpV - Number of Primitive Variables. A count of the number of variables
 * defined in a class and whose type is a primitive (non-class) type.
 * 
 * @author Isaac Griffith
 */
public class NOpV extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5643984178282831608L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NOpV getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NOpV(
                "Number of Primitive Variables",
                "A count of the number of variables defined in a class and whose type is a primitive (non-class) type.",
                "NOpV", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NOpV(final String name, final String desc, final String acronym, final MetricScope scope,
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

        double nopv = 0;

        for (final ProgramNode pe : fields)
        {
            if (pe instanceof FieldNode)
            {
                if ((((FieldNode) pe).getType() instanceof PrimitiveTypeNode) || ((FieldNode) pe).isPrimitive())
                {
                    nopv++;
                }
            }
        }

        return nopv;
    }
}
