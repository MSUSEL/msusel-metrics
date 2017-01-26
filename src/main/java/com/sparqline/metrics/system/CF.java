/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class CF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2436645709280819096L;

    public static CF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CF("Coupling Factor",
                "Number of overriding methods of a class as a ratio of the total possible number of overridden methods. Measures understandability and maintainability.",
                "CF", MetricScope.SystemLevel, entity, graph);
    }

    private double numClasses = 0;

    private CF(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param client
     * @param supplier
     * @return
     */
    private int isClient(final CodeNode client, final CodeNode supplier)
    {
        /*
         * if (tree.isEdge(client, supplier,
         * AssociationRelationshipType.DirectedAssociation)
         * || tree.isEdge(client, supplier, DirectedRelationshipType.Usage)
         * || tree.isEdge(client, supplier,
         * AssociationRelationshipType.Extension))
         * {
         * return 1;
         * }
         * else
         * {
         * return 0;
         * }
         */
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double cf = 0;

        /*
         * if (entity instanceof ProjectNode)
         * {
         * final List<CodeNode> classes = tree.getClasses((ProjectNode) entity);
         * double totalCount = 0;
         * for (final CodeNode cls : classes)
         * {
         * final List<CodeNode> others = tree.getClasses((ProjectNode) entity);
         * int count = 0;
         * for (final CodeNode other : others)
         * {
         * if (cls.equals(other))
         * {
         * continue;
         * }
         * count += isClient(cls, other);
         * }
         * totalCount += count;
         * }
         * cf = totalCount / ((numClasses * numClasses) - numClasses);
         * }
         */

        return cf;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        // numClasses = taskMap.containsKey("NC") ?
        // taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }
}
