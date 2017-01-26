/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CAM - Average Cohesion Among class Methods
 * 
 * @author Isaac Griffith
 */
public class CAM extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2084669828549649208L;

    public static CAM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CAM("Average Cohesion Among class Methods", "", "CAM", MetricScope.SystemLevel, entity, graph);
    }

    private CAM(final String name, final String desc, final String acronym, final MetricScope scope,
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

        /*
         * if (entity instanceof ProjectNode)
         * {
         * final ProjectNode sys = (ProjectNode) entity;
         * final Set<TypeNode> systemClasses = new HashSet<>();
         * systemClasses.addAll(sys.getClasses());
         * Set<TypeNode> types = new HashSet<>();
         * for (TypeNode ce : systemClasses)
         * {
         * for (MethodNode me : ce.getMethods())
         * {
         * for (Parameter p : me.getParameters())
         * {
         * types.add(p.getType());
         * }
         * }
         * }
         * double totalCAM = 0.0d;
         * for (TypeNode ce : systemClasses)
         * {
         * double classCAM = 0.0d;
         * for (MethodNode me : ce.getMethods())
         * {
         * Set<TypeNode> localTypes = new HashSet<>();
         * for (Parameter p : me.getParameters())
         * {
         * localTypes.add(p.getType());
         * }
         * if (types.size() > 0)
         * classCAM += localTypes.size() / types.size();
         * else
         * classCAM = 1.0;
         * }
         * totalCAM += classCAM / ce.getMethods().size();
         * }
         * value = totalCAM / systemClasses.size();
         * if (Double.isNaN(value))
         * value = 0;
         * }
         */

        return value;
    }
}
