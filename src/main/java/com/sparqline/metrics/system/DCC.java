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
 * DCC - Average Direct Class Couplings
 * 
 * @author Isaac Griffith
 */
public class DCC extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6337963676902383533L;

    public static DCC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new DCC("Average Direct Class Couplings", "", "DCC", MetricScope.SystemLevel, entity, graph);
    }

    private DCC(final String name, final String desc, final String acronym, final MetricScope scope,
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
             * double totalCouplings = 0.0d;
             * for (CodeNode ce : systemClasses)
             * {
             * Set<String> typeNames = new HashSet<>();
             * if (ce instanceof TypeNode)
             * {
             * TypeNode cie = (TypeNode) ce;
             * Set<MethodNode> methods = cie.getMethods();
             * Set<FieldNode> fields = cie.getFields();
             * for (MethodNode m : methods)
             * {
             * List<Parameter> param = m.getParameters();
             * for (Parameter p : param)
             * {
             * if (!(p.getType() instanceof PrimitiveTypeNode))
             * {
             * if (p.getType() != null)
             * typeNames.add(p.getType().getIdentifier());
             * }
             * }
             * }
             * for (FieldNode f : fields)
             * {
             * if (!(f.getType() instanceof PrimitiveTypeNode))
             * {
             * typeNames.add(f.getType().getIdentifier());
             * }
             * }
             * }
             * totalCouplings += typeNames.size();
             * }
             * value = totalCouplings / systemClasses.size();
             */
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }

}
