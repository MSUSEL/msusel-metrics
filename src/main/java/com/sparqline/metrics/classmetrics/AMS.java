/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.Set;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * AMS - Average Method Size. Average size of the methods in the class. AMS =
 * Total Method LOC / NOM.
 * 
 * @author Isaac Griffith
 */
public class AMS extends ClassMetric {

	/**
	 * 
	 */
	private static final long serialVersionUID = -96191134747985963L;

	/**
	 * @param entity
	 * @param graph
	 * @return
	 */
	public static AMS getInstance(final CodeNode entity, final CodeTree graph) {
		// TODO add implementation and return statement
		return new AMS("Average Method Size", "Average size of the methods in the class. AMS = Total Method LOC / NOM.",
				"AMS", MetricScope.ClassLevel, entity, graph);
	}

	private double nom = 0.0;

	/**
	 * @param name
	 * @param desc
	 * @param acronym
	 * @param scope
	 * @param entity
	 * @param graph
	 */
	private AMS(final String name, final String desc, final String acronym, final MetricScope scope,
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
			TypeNode type = (TypeNode) entity;
			double totalLOC = 0.0;

			Set<MethodNode> methods = type.getMethods();

			for (final MethodNode method : methods) {
				totalLOC += method.getMetric("SLOC");
			}

			return (totalLOC / nom);
		}

		return 0.0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
	 */
	@Override
	public void setPrerequisites() {
		nom = (taskMap.containsKey("NOM") ? taskMap.get("NOM").join().getValue() : entity.getMetric("NOM"));
	}
}
