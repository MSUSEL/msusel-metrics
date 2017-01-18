/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Lists;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * NOM - Number of Methods. The number of methods of a class.
 * 
 * @author Isaac Griffith
 */
public class NOM extends ClassMetric {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1145554523831787102L;

	/**
	 * @param entity
	 * @param graph
	 * @return
	 */
	public static NOM getInstance(final CodeNode entity, final CodeTree graph) {
		return new NOM("Number of Methods", "The number of methods of a class.", "NOM", MetricScope.ClassLevel, entity,
				graph);
	}

	/**
	 * @param name
	 * @param desc
	 * @param acronym
	 * @param scope
	 * @param entity
	 * @param graph
	 */
	private NOM(final String name, final String desc, final String acronym, final MetricScope scope,
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
		List<MethodNode> methods = Lists.newArrayList();
		for (MethodNode method : ((TypeNode) entity).getMethods()) {
			if (method.isAccessorMethod() || method.isAbstract())
				continue;
			else
				methods.add(method);
		}
		return methods.size();
	}

}
