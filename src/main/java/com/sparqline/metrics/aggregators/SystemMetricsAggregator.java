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
package com.sparqline.metrics.aggregators;

import java.util.Map;

import com.google.common.collect.Maps;
import com.sparqline.metrics.Metric;
import com.sparqline.metrics.MetricsAggregator;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.FileNode;
import com.sparqline.quamoco.codetree.ModuleNode;
import com.sparqline.quamoco.codetree.ProjectNode;

/**
 * @author Isaac Griffith
 */
public class SystemMetricsAggregator extends MetricsAggregator {

    /*
     * (non-Javadoc)
     * @see
     * com.sparqline.metrics.MetricsAggregator#aggregate(com.sparqline.metrics.
     * Metric, com.sparqline.quamoco.codetree.CodeTree)
     */
    @Override
    public void aggregate(Metric metric, CodeTree tree)
    {
        ProjectNode proj = tree.getProject();

        Map<String, Double> totals = Maps.newHashMap();

        for (ProjectNode pn : proj.getSubProjects())
        {
            metricSum(totals, pn);
        }

        for (ModuleNode mn : proj.getModules())
        {
            metricSum(totals, mn);
        }

        for (FileNode fn : proj.getFiles())
        {
            metricSum(totals, fn);
        }

        for (String m : totals.keySet())
        {
            proj.addMetric(m, totals.get(m));
        }
    }
}
