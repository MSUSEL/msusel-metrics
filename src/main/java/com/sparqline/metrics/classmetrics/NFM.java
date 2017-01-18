package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.expression.MethodCallExpression;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NFM - Number of Forwarding Methods. Count of the number of methods which
 * simply delegate their action onto another method.
 * 
 * @author Isaac Griffith
 */
public class NFM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6697494570502211868L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NFM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NFM("Number of Forwarding Methods",
                "Count of the number of methods which simply delegate their action onto another method.", "NFM",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NFM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double nfm = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            for (final ProgramNode pe : tree.getMethods(entity))
            {
                if (pe instanceof MethodNode)
                {
                    final MethodNode method = (MethodNode) pe;
                    if (method.getContainedStatements().size() < 3)
                    {
                        if (!method.findExpressionByType(MethodCallExpression.class).isEmpty())
                        {
                            nfm++;
                        }
                    }
                }
            }
        }

        return nfm;
    }
}
