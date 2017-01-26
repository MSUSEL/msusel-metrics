/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.ProjectNode;

/**
 * DAM - Average Data Access Metric
 * 
 * @author Isaac Griffith
 */
public class DAM extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8159583311389301289L;

    public static DAM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new DAM("Average Data Access Metric", "", "DAM", MetricScope.SystemLevel, entity, graph);
    }

    private DAM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double value = 0.0d;

        if (entity instanceof ProjectNode)
        {
            /*
             * final ProjectNode sys = (ProjectNode) entity;
             * final Set<CodeNode> systemClasses = new HashSet<>();
             * systemClasses.addAll(sys.getClasses());
             * double totalDAM = 0.0d;
             * for (CodeNode ce : systemClasses)
             * {
             * int nonPubAttr = 0;
             * for (FieldNode field : ((TypeNode) ce).getFields())
             * {
             * if (field.getAccessibility() != Accessibility.Public)
             * nonPubAttr++;
             * }
             * totalDAM = ((double) nonPubAttr) / ((double) ((TypeNode)
             * ce).getFields().size());
             * }
             * if (Double.isNaN(totalDAM))
             * totalDAM = 0;
             * value = totalDAM / systemClasses.size();
             */
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }

}
