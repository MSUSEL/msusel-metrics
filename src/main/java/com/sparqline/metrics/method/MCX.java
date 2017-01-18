/**
 * 
 */
package com.sparqline.metrics.method;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.expression.AssignmentExpression;
import com.sparqline.graph.nodes.expression.BinaryExpression;
import com.sparqline.graph.nodes.expression.FieldAccessExpression;
import com.sparqline.graph.nodes.expression.MethodCallExpression;
import com.sparqline.graph.nodes.expression.UnaryExpression;
import com.sparqline.graph.nodes.expression.VariableDeclarationExpression;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

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
	public static MCX getInstance(final ProgramNode entity, final CodeGraph graph) {
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
			final ProgramNode entity, final CodeGraph graph) {
		super(name, desc, acronym, scope, entity, graph);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.metrics.Metric#measure()
	 */
	@Override
	public double measure() {
		if (entity instanceof MethodNode) {
			MethodNode method = (MethodNode) entity;

			int assigments = method.getBody().findExpressionByType(AssignmentExpression.class).size();
			int binary = method.getBody().findExpressionByType(BinaryExpression.class).size();
			int params = method.getParameters().size();
			int unary = method.getBody().findExpressionByType(UnaryExpression.class).size();
			int tempvars = method.getBody().findExpressionByType(VariableDeclarationExpression.class).size();
			int methodcalls = method.getBody().findExpressionByType(MethodCallExpression.class).size();

			int primitives = 0;
			List<FieldAccessExpression> faes = method.getBody().findExpressionByType(FieldAccessExpression.class);
			for (FieldAccessExpression fae : faes) {
				ProgramNode pe = tree.getMethodOwner(method);
				for (ProgramNode fe : tree.getFields(pe)) {
					if (fe.getName().equals(fae.getName())) {
						FieldNode field = (FieldNode) fe;
						if (field.isPrimitive()) {
							primitives++;
						}
					}
				}
			}

			double mcx = 0;
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
	 */
	@Override
	public void setPrerequisites() {
	}
}
