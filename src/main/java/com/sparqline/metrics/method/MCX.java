/**
 * 
 */
package com.sparqline.metrics.method;

import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

/**
 * MCX - Method Complexity. A complexity measure that looks at the number and
 * types of message sends in a method.
 * 
 * @author Isaac Griffith
 */
public class MCX extends MethodMetric {

    private double cyclo;

    /**
     * 
     */
    private static final long serialVersionUID = 7221825476185487435L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static MCX getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new MCX("Method Complexity", "Complexity of the statements in a method's body. Uses CYCLO(m).", "MCX",
                MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private MCX(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        if (entity instanceof MethodNode)
        {
            /*
             * MethodNode method = (MethodNode) entity;
             * int assigments =
             * method.getBody().findExpressionByType(AssignmentExpression.class)
             * .size();
             * int binary =
             * method.getBody().findExpressionByType(BinaryExpression.class).
             * size();
             * int params = method.getParameters().size();
             * int unary =
             * method.getBody().findExpressionByType(UnaryExpression.class).size
             * ();
             * int tempvars = method.getBody().findExpressionByType(
             * VariableDeclarationExpression.class).size();
             * int methodcalls =
             * method.getBody().findExpressionByType(MethodCallExpression.class)
             * .size();
             * int primitives = 0;
             * List<FieldAccessExpression> faes =
             * method.getBody().findExpressionByType(FieldAccessExpression.class
             * );
             * for (FieldAccessExpression fae : faes) {
             * ProgramNode pe = tree.getMethodOwner(method);
             * for (ProgramNode fe : tree.getFields(pe)) {
             * if (fe.getName().equals(fae.getName())) {
             * FieldNode field = (FieldNode) fe;
             * if (field.isPrimitive()) {
             * primitives++;
             * }
             * }
             * }
             * }
             * double mcx = 0;
             */
        }

        return 0;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
    }
}
