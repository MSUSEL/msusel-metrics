package com.sparqline.metrics.packagemetrics;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CF - Coupling Factor. Measures the coupling between classes excluding
 * coupling due to inheritance. It is the ratio between the number of actually
 * coupled pairs of classes in a scope and the possible number of coupled pairs
 * of classes.
 * 
 * @author Isaac Griffith
 */
public class CF extends PackageMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -894776090284225095L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CF("Coupling Factor",
                "Measures the coupling between classes excluding coupling due to inheritance. It is the ratio between the number of actually coupled pairs of classes in a scope and the possible number of coupled pairs of classes.",
                "CF", MetricScope.PackageLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CF(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
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
         * if (entity instanceof PackageNode)
         * {
         * final List<CodeNode> classes = tree.getClasses((PackageNode) entity);
         * double totalCount = 0;
         * for (final CodeNode cls : classes)
         * {
         * final List<CodeNode> others = tree.getClasses((PackageNode) entity);
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
         * final double numClasses = classes.size();
         * cf = totalCount / ((numClasses * numClasses) - numClasses);
         * }
         */

        return cf;
    }
}
