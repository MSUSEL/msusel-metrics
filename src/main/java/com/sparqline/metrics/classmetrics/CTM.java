package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CTM - Coupling Through Message passing. This metric measures the number of
 * different messages that are sent out from a class to other classes, excluding
 * the messages sent to the objects created as local objects in the local
 * methods of the class.
 * 
 * @author Isaac Griffith
 */
public class CTM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 3353256226398639065L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CTM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CTM("Coupling Through Message Passing",
                "This metric measures the number of different messages that are sent out from a class to other classes, excluding the messages sent to the objects created as local objects in the local methods of the class.",
                "CTM", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CTM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double ctm = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // for (final MethodCallExpression mce :
        // method.findExpressionByType(MethodCallExpression.class))
        // {
        // final ExpressionEntity expr = mce.getScope();
        // if (expr instanceof NameExpression)
        // {
        // final String name = ((NameExpression) expr).getContent();
        // for (final ProgramNode field : tree.getFields(entity))
        // {
        // if (field.getName().equals(name))
        // {
        // ctm++;
        // }
        // }
        // }
        // }
        // }
        // }
        // }

        return ctm;
    }
}
