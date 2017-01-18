package com.sparqline.metrics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

import org.apache.commons.lang3.tuple.Pair;

import com.sparqline.graph.nodes.PackageNode;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;
import com.sparqline.quamoco.codetree.ProjectNode;
import com.sparqline.quamoco.codetree.TypeNode;

public class MetricCalcTask extends RecursiveTask<List<Pair<String, Double>>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5570500609489592537L;
	/**
	 * 
	 */
	protected MetricsController controller;
	/**
	 * 
	 */
	protected CodeNode entity;
	/**
	 * 
	 */
	protected CodeTree graph;

	/**
	 * @param controller
	 * @param entity
	 * @param graph
	 */
	public MetricCalcTask(final MetricsController controller, final CodeNode entity, final CodeTree graph) {
		this.controller = controller;
		this.entity = entity;
		this.graph = graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.RecursiveTask#compute()
	 */
	@Override
	public List<Pair<String, Double>> compute() {
		final List<Pair<String, Double>> values = new LinkedList<>();

		final List<Metric> metrics = getMetrics();
		final Map<String, RecursiveTask<Pair<String, Double>>> map = new ConcurrentHashMap<>();
		for (final Metric m : metrics) {
			map.put(m.getAcronym(), m);
		}

		for (final Metric m : metrics) {
			m.setTaskMap(map);
			m.fork();
		}

		for (final Metric m : metrics) {
			values.add(m.join());
		}

		return values;
	}

	/**
	 * @return
	 */
	private List<Metric> getMetrics() {
		if (entity instanceof TypeNode) {
			return controller.getClassMetrics(entity);
		} else if (entity instanceof MethodNode) {
			return controller.getMethodMetrics(entity);
		} else if (entity instanceof PackageNode) {
			return controller.getPackageMetrics(entity);
		} else if (entity instanceof ProjectNode) {
			return controller.getSystemMetrics(entity);
		}
		return new ArrayList<Metric>();
	}

}
