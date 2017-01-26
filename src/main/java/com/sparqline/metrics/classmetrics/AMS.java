/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright c) 2017 Isaac Griffith, SparQLine Analytics, LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
		// nom = (taskMap.containsKey("NOM") ? taskMap.get("NOM").join().getValue() : entity.getMetric("NOM"));
	}
}
