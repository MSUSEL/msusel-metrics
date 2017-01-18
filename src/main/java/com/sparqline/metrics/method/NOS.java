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
 * NOS - Number of Statements. A count of the number of statements in a method
 * body.
 * 
 * @author Isaac Griffith
 */
public class NOS extends MethodMetric {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731941334929675014L;

	/**
	 * @param entity
	 * @param graph
	 * @return
	 */
	public static NOS getInstance(final CodeNode entity, final CodeTree graph) {
		return new NOS("Number of Statements", "A count of the number of statements in a method body.", "NOS",
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
	private NOS(final String name, final String desc, final String acronym, final MetricScope scope,
			final CodeNode entity, final CodeTree graph) {
		super(name, desc, acronym, scope, entity, graph);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	private double countStatements() {
		double retVal = 0;

		if (entity instanceof MethodNode) {
			final MethodNode method = (MethodNode) entity;

			retVal += method.getStatements().size();
		}

		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.metrics.Metric#measure()
	 */
	@Override
	public double measure() {
		return countStatements();
	}

}
