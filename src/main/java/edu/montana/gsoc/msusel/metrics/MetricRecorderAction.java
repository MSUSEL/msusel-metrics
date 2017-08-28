/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.metrics;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import com.google.common.collect.Sets;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.utility.Pair;
import edu.montana.gsoc.msusel.node.NamespaceNode;
import edu.montana.gsoc.msusel.node.ProjectNode;
import edu.montana.gsoc.msusel.node.TypeNode;

/**
 * @author Isaac Griffith
 */
public class MetricRecorderAction extends RecursiveAction {

    /**
     * 
     */
    private static final long                   serialVersionUID = 7647678407471722940L;
    /**
     * 
     */
    private final MetricsController             controller;
    /**
     * 
     */
    private final INode                         entity;
    /**
     * 
     */
    private final CodeTree                      tree;
    /**
     * 
     */
    private final Map<String, RecursiveTask<?>> taskMap;

    /**
     * @param controller
     * @param entity
     * @param graph
     */
    public MetricRecorderAction(final MetricsController controller, final INode entity, final CodeTree graph)
    {
        this.controller = controller;
        this.entity = entity;
        this.tree = graph;
        taskMap = new ConcurrentHashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void compute()
    {
        Set<INode> entities = Sets.newHashSet();
        final List<RecursiveAction> forks = new LinkedList<>();

        if (entity instanceof ProjectNode)
        {
            entities.addAll(((ProjectNode) entity).getNamespaces());
        }
        else if (entity instanceof NamespaceNode)
        {
            entities.addAll(((NamespaceNode) entity).getTypes());
        }
        else if (entity instanceof TypeNode)
        {
            entities.addAll(((TypeNode) entity).getMethods());
        }

        for (final INode pe : entities)
        {
            final MetricRecorderAction action = new MetricRecorderAction(controller, pe, tree);
            forks.add(action);
            action.fork();
        }

        for (final RecursiveAction action : forks)
        {
            action.join();
        }

        final MetricCalcTask task = new MetricCalcTask(controller, entity, tree);
        task.fork();
        addMetricsToEntity(task.join());
    }

    /**
     * @param entity
     * @param join
     */
    private void addMetricsToEntity(List<Pair<String, Double>> join)
    {
        join.forEach((pair) -> {
            entity.addMetric(pair.key(), pair.value());
        });
    }

    /**
     * @return the taskMap
     */
    public Map<String, RecursiveTask<?>> getTaskMap()
    {
        return taskMap;
    }

}
