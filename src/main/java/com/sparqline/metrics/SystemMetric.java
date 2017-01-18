package com.sparqline.metrics;

import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * @author Isaac Griffith
 */
public abstract class SystemMetric extends Metric {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2350358438190409841L;

	/**
	 * @param name
	 * @param desc
	 * @param acronym
	 * @param scope
	 * @param entity
	 * @param graph
	 */
	public SystemMetric(final String name, final String desc, final String acronym, final MetricScope scope,
			final CodeNode entity, final CodeTree graph) {
		super(name, desc, acronym, scope, entity, graph);
	}

}
