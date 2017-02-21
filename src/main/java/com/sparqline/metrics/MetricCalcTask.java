/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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
package com.sparqline.metrics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.codetree.node.NamespaceNode;
import com.sparqline.codetree.node.ProjectNode;
import com.sparqline.codetree.node.TypeNode;
import com.sparqline.metrics.utility.Pair;

/**
 * @author Isaac Griffith
 */
public class MetricCalcTask extends RecursiveTask<List<Pair<String, Double>>> {

    /**
     * The metrics controller used to obtain metrics for calculation
     */
    protected MetricsController controller;
    /**
     * Entity to be measured
     */
    protected INode             entity;
    /**
     * Tree containing entity to be measured
     */
    protected CodeTree          tree;

    /**
     * Constructs a new MetricCalcTask for the given entity from the provided
     * tree using the given Metrics controller
     * 
     * @param controller
     *            The Metrics Controller providing metrics
     * @param entity
     *            Entity to be measured
     * @param tree
     *            CodeTree containing the entity.
     */
    public MetricCalcTask(final MetricsController controller, final INode entity, final CodeTree tree)
    {
        this.controller = controller;
        this.entity = entity;
        this.tree = tree;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pair<String, Double>> compute()
    {
        final List<Pair<String, Double>> values = new LinkedList<>();

        final List<Metric> metrics = getMetrics();
        final Map<String, RecursiveTask<Pair<String, Double>>> map = new ConcurrentHashMap<>();
        for (final Metric m : metrics)
        {
            map.put(m.getAcronym(), m);
        }

        for (final Metric m : metrics)
        {
            m.setTaskMap(map);
            m.setEntity(entity);
            m.setTree(tree);
            m.fork();
        }

        for (final Metric m : metrics)
        {
            values.add(m.join());
        }

        return values;
    }

    /**
     * @return List of metrics to be executed on the contained entity.
     */
    private List<Metric> getMetrics()
    {
        if (entity instanceof TypeNode)
        {
            return controller.getClassMetrics();
        }
        else if (entity instanceof MethodNode)
        {
            return controller.getMethodMetrics();
        }
        else if (entity instanceof NamespaceNode)
        {
            return controller.getPackageMetrics();
        }
        else if (entity instanceof ProjectNode)
        {
            return controller.getSystemMetrics();
        }
        return new ArrayList<Metric>();
    }

}
