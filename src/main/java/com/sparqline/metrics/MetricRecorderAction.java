package com.sparqline.metrics;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import com.google.common.collect.Sets;
import com.sparqline.metrics.utility.Pair;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.PackageNode;
import com.sparqline.quamoco.codetree.ProjectNode;
import com.sparqline.quamoco.codetree.TypeNode;

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
    private final CodeNode                      entity;
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
    public MetricRecorderAction(final MetricsController controller, final CodeNode entity, final CodeTree graph)
    {
        this.controller = controller;
        this.entity = entity;
        this.tree = graph;
        taskMap = new ConcurrentHashMap<>();
    }

    /*
     * (non-Javadoc)
     * @see java.util.concurrent.RecursiveAction#compute()
     */
    @Override
    public void compute()
    {
        Set<CodeNode> entities = Sets.newHashSet();
        final List<RecursiveAction> forks = new LinkedList<>();

        if (entity instanceof ProjectNode)
        {
            entities.addAll(((ProjectNode) entity).getPackages());
        }
        else if (entity instanceof PackageNode)
        {
            entities.addAll(((PackageNode) entity).getTypes());
        }
        else if (entity instanceof TypeNode)
        {
            entities.addAll(((TypeNode) entity).getMethods());
        }

        for (final CodeNode pe : entities)
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
        join.parallelStream().forEach((pair) -> {
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
