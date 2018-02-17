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
package edu.montana.gsoc.msusel.codetree.metrics.aggregators;

import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.google.common.collect.Maps;
import com.google.common.collect.Queues;

import edu.montana.gsoc.msusel.codetree.node.FileNode;
import edu.montana.gsoc.msusel.codetree.node.ProjectNode;
import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.metrics.MetricsAggregator;
import edu.montana.gsoc.msusel.codetree.node.ModuleNode;

/**
 * Class for aggregating metrics up to the System level.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class SystemMetricsAggregator extends MetricsAggregator {

    /**
     * {@inheritDoc}
     */
    @Override
    public void aggregate(CodeTree tree)
    {
        Stack<ProjectNode> stack = new Stack<>();
        Queue<ProjectNode> queue = Queues.newArrayDeque();

        queue.offer(tree.getProject());
        while (!queue.isEmpty())
        {
            ProjectNode pn = queue.poll();
            stack.push(pn);
            queue.addAll(pn.getSubProjects());
        }

        Map<String, Double> totals = Maps.newHashMap();

        while (!stack.isEmpty())
        {
            ProjectNode parent = stack.pop();
            for (ProjectNode pn : parent.getSubProjects())
            {
                metricSum(totals, pn);
            }

            for (ModuleNode mn : parent.getModules())
            {
                metricSum(totals, mn);
            }

            for (FileNode fn : parent.getFiles())
            {
                metricSum(totals, fn);
            }

            for (String m : totals.keySet())
            {
                parent.addMetric(m, totals.get(m));
            }
        }
    }
}
