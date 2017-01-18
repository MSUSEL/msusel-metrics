/**
 * 
 */
package com.sparqline.metrics;

import java.util.Map;
import java.util.concurrent.RecursiveTask;

import com.sparqline.metrics.utility.Pair;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * @author Isaac
 */
public abstract class Metric extends RecursiveTask<Pair<String, Double>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2262020337315061736L;
	/**
	 * 
	 */
	protected String name;
	/**
	 * 
	 */
	protected String acronym;
	/**
	 * 
	 */
	protected String description;
	/**
	 * 
	 */
	protected MetricScope scope;
	/**
	 * 
	 */
	protected CodeTree tree;
	/**
	 * 
	 */
	protected CodeNode entity;
	/**
	 * 
	 */
	protected Map<String, RecursiveTask<Pair<String, Double>>> taskMap;

	/**
	 * @param name
	 * @param desc
	 * @param acronym
	 * @param scope
	 * @param entity
	 * @param tree
	 */
	public Metric(final String name, final String desc, final String acronym, final MetricScope scope,
			final CodeNode entity, final CodeTree tree) {
		this.name = name;
		description = desc;
		this.scope = scope;
		this.acronym = acronym;
		this.tree = tree;
		this.entity = entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Pair<String, Double> compute() {
		setPrerequisites();
		return new Pair<String, Double>(acronym, measure());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.ui.DisplayInfo#getAcronym()
	 */
	public String getAcronym() {
		return acronym;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.refactor.DisplayInfo#getDescription()
	 */
	/* @Override */
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.siliconcode.truerefactor.refactor.DisplayInfo#getName()
	 */
	/* @Override */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public MetricScope getScope() {
		return scope;
	}

	/**
	 * @return
	 */
	public abstract double measure();

	/**
	 * 
	 */
	public void setPrerequisites() {
		// NOM = taskMap.containsKey("NOM") ?
		// taskMap.get("NOM").join().getValue() : entity.getMetric("NOM"); -
		// checks for invalidated values.
	}

	/**
	 * @param map
	 */
	public void setTaskMap(final Map<String, RecursiveTask<Pair<String, Double>>> map) {
		taskMap = map;
	}
}
