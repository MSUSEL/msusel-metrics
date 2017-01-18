package com.sparqline.metrics;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.PackageNode;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.ProjectNode;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * @author Isaac Griffith
 */
public class MetricRecorderAction extends RecursiveAction {

    /**
     * 
     */
    private static final long serialVersionUID = 7647678407471722940L;
    /**
     * 
     */
    private final MetricsController controller;
    /**
     * 
     */
    private final CodeNode entity;
    /**
     * 
     */
    private final CodeTree tree;
    /**
     * 
     */
    private final Map<String, RecursiveTask<?>> taskMap;

    /**
     * @param controller
     * @param entity
     * @param graph
     */
    public MetricRecorderAction(final MetricsController controller, final ProgramNode entity, final CodeGraph graph)
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
        List<CodeNode> entities = new LinkedList<>();
        final List<RecursiveAction> forks = new LinkedList<>();

        if (entity instanceof ProjectNode)
        {
            entities = tree.getPackages();
        }
        else if (entity instanceof PackageNode)
        {
            entities = tree.getClasses();
        }
        else if (entity instanceof TypeNode)
        {
            entities = tree.getMethods();
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
        entity.addMetrics(task.join());
    }

    /**
     * @return the taskMap
     */
    public Map<String, RecursiveTask<?>> getTaskMap()
    {
        return taskMap;
    }

}
