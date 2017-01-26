package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NUIV - Number of Unused Instance Variables. Count of a classes fields which
 * are not either read from or written to in any of the class's methods.
 * 
 * @author Isaac Griffith
 */
public class NUIV extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4526295575820921350L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NUIV getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NUIV("Number of Unused Instance Variables",
                "Count of a classes fields which are not either read from or written to in any of the class\'s methods.",
                "NUIV", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NUIV(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double nuiv = 0;
        // final List<CodeNode> fields = tree.getFields(entity);
        //
        // for (final CodeNode field : fields)
        // {
        // final List<Connection> edges =
        // tree.getEdgesContainingRelationType(field,
        // DirectedRelationshipType.IntraClassAssociation);
        // if (edges.isEmpty())
        // {
        // nuiv++;
        // }
        // }

        return nuiv;
    }
}
