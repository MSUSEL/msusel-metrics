/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class HM extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5537647500806840912L;

    public static HM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new HM("Helper Methods", "The number of methods in a system that do not belong to any class.", "HM",
                MetricScope.SystemLevel, entity, graph);
    }

    private HM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double hm = 0;

        /*
         * if (entity instanceof SystemNode)
         * {
         * final Set<ProgramNode> containedMethods = new HashSet<>();
         * final Set<ProgramNode> helperMethods = new HashSet<>();
         * containedMethods.addAll(tree.getMethods(entity));
         * for (final ProgramNode pkg : tree.getPackages((SystemNode) entity))
         * {
         * containedMethods.addAll(tree.getMethods(pkg));
         * }
         * for (final ProgramNode helper : containedMethods)
         * {
         * boolean isHelper = true;
         * for (final Connection conn :
         * tree.getEdgesContainingRelationType(helper,
         * DirectedRelationshipType.MethodInclude))
         * {
         * if (tree.getState().getOpposite(helper, conn) instanceof
         * ClassOrInterfaceNode)
         * {
         * isHelper = false;
         * }
         * }
         * if (isHelper)
         * {
         * helperMethods.add(helper);
         * }
         * }
         * hm = helperMethods.size();
         * }
         */

        return hm;
    }
}
