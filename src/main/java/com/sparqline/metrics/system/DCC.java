/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.body.Parameter;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.nodes.type.PrimitiveTypeNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

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

    public static DCC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new DCC("Average Direct Class Couplings", "", "DCC", MetricScope.SystemLevel, entity, graph);
    }

    private DCC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double value = 0.0d;

        if (entity instanceof SystemNode)
        {
            final SystemNode sys = (SystemNode) entity;
            final Set<ProgramNode> systemClasses = new HashSet<>();
            systemClasses.addAll(sys.getClasses());

            double totalCouplings = 0.0d;
            for (ProgramNode ce : systemClasses)
            {
                Set<String> typeNames = new HashSet<>();
                if (ce instanceof ClassOrInterfaceNode)
                {
                    ClassOrInterfaceNode cie = (ClassOrInterfaceNode) ce;
                    Set<MethodNode> methods = cie.getMethods();
                    Set<FieldNode> fields = cie.getFields();

                    for (MethodNode m : methods)
                    {
                        List<Parameter> param = m.getParameters();
                        for (Parameter p : param)
                        {
                            if (!(p.getType() instanceof PrimitiveTypeNode))
                            {
                                if (p.getType() != null)
                                    typeNames.add(p.getType().getIdentifier());
                            }
                        }
                    }

                    for (FieldNode f : fields)
                    {
                        if (!(f.getType() instanceof PrimitiveTypeNode))
                        {
                            typeNames.add(f.getType().getIdentifier());
                        }
                    }
                }
                totalCouplings += typeNames.size();
            }

            value = totalCouplings / systemClasses.size();
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }

}
