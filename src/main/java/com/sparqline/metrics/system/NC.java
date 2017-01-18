/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.ProjectNode;

public class NC extends SystemMetric {

	/**
	 * 
	 */
	private static final long serialVersionUID = -415700333259541365L;

	public static NC getInstance(final CodeNode entity, final CodeTree graph) {
		return new NC("Number of Classes",
				"The number of classes in the design is an indication of object-orientness of the program. The programming effort is related to the number of classes that have been implemented.",
				"NC", MetricScope.SystemLevel, entity, graph);
	}

	private NC(final String name, final String desc, final String acronym, final MetricScope scope,
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
		double nc = 0;

		if (entity instanceof ProjectNode) {
			final ProjectNode sys = (ProjectNode) entity;

			nc = sys.getTypes().size();
		}
		if (Double.isNaN(nc))
			nc = 0;
		return nc;
	}
}
