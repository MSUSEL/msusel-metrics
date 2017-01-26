package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static NFM getInstance(final CodeNode entity, final CodeTree graph)
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
        double nfm = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // if (method.getContainedStatements().size() < 3)
        // {
        // if
        // (!method.findExpressionByType(MethodCallExpression.class).isEmpty())
        // {
        // nfm++;
        // }
        // }
        // }
        // }
        // }

        return nfm;
    }
}
