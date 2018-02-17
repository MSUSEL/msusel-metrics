/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.codetree.metrics;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;

/**
 * Base class for metrics aggregators.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public abstract class MetricsAggregator {

    /**
     * List of excluded metrics
     */
    protected final List<String> excludedMetrics = Lists.newArrayList();

    /**
     * Aggregates metrics for all nodes in the given tree.
     * 
     * @param tree
     *            CodeTree
     */
    public abstract void aggregate(CodeTree tree);

    /**
     * Calculates the total value of metrics for the given node, by simply
     * summing the values found in the provided map.
     * 
     * @param totals
     *            Totals for all children of the given node for each name.
     * @param node
     *            node to append summed values to
     */
    protected void metricSum(Map<String, Double> totals, INode node)
    {
        for (String m : node.getMetricNames())
        {
            if (excludedMetrics.contains(m))
                continue;

            double total = 0.0;
            if (totals.containsKey(m))
                total = totals.get(m);

            total += node.getMetric(m);
            totals.put(m, total);
        }
    }

    /**
     * Adds the named name to the list of metrics excluded from this
     * aggregation
     * 
     * @param name
     *            Metric name
     */
    public void addExcludedMetric(String name)
    {
        if (name == null || name.isEmpty() || excludedMetrics.contains(name))
            return;

        excludedMetrics.add(name);
    }
}
