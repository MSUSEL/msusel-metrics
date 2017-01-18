package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.Connection;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static NUIV getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NUIV(
                "Number of Unused Instance Variables",
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
        double nuiv = 0;
        final List<ProgramNode> fields = tree.getFields(entity);

        for (final ProgramNode field : fields)
        {
            final List<Connection> edges = tree.getEdgesContainingRelationType(field,
                    DirectedRelationshipType.IntraClassAssociation);
            if (edges.isEmpty())
            {
                nuiv++;
            }
        }

        return nuiv;
    }
}
