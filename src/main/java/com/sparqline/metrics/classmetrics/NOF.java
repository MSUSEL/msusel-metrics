/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * NOF - Number of Fields. Number of Fields locally defined in the class.
 * 
 * @author Isaac Griffith
 */
public class NOF extends ClassMetric {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1704066780004221472L;

	/**
	 * @param entity
	 * @param graph
	 * @return
	 */
	public static NOF getInstance(final CodeNode entity, final CodeTree graph) {
		return new NOF("Number of Fields", "Number of Fields locally defined in the class.", "NOF",
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
	private NOF(final String name, final String desc, final String acronym, final MetricScope scope,
			final CodeNode entity, final CodeTree graph) {
		super(name, desc, acronym, scope, entity, graph);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.metrics.Metric#measure()
	 */
	@Override
	public double measure() {
		if (entity instanceof TypeNode) {
			return ((TypeNode) entity).getFields().size();
		}
		return 0.0;
	}

}
