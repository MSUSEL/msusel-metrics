/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.graph.relations.AssociationRelationshipType;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

public class CF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2436645709280819096L;

    public static CF getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CF(
                "Coupling Factor",
                "Number of overriding methods of a class as a ratio of the total possible number of overridden methods. Measures understandability and maintainability.",
                "CF", MetricScope.SystemLevel, entity, graph);
    }

    private double numClasses = 0;

    private CF(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param client
     * @param supplier
     * @return
     */
    private int isClient(final ProgramNode client, final ProgramNode supplier)
    {
        if (tree.isEdge(client, supplier, AssociationRelationshipType.DirectedAssociation)
                || tree.isEdge(client, supplier, DirectedRelationshipType.Usage)
                || tree.isEdge(client, supplier, AssociationRelationshipType.Extension))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double cf = 0;

        if (entity instanceof SystemNode)
        {
            final List<ProgramNode> classes = tree.getClasses((SystemNode) entity);

            double totalCount = 0;
            for (final ProgramNode cls : classes)
            {
                final List<ProgramNode> others = tree.getClasses((SystemNode) entity);
                int count = 0;
                for (final ProgramNode other : others)
                {
                    if (cls.equals(other))
                    {
                        continue;
                    }

                    count += isClient(cls, other);
                }

                totalCount += count;
            }

            cf = totalCount / ((numClasses * numClasses) - numClasses);
        }

        return cf;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        numClasses = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
