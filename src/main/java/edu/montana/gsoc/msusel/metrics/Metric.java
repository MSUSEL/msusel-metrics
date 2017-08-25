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

import java.util.Map;
import java.util.concurrent.RecursiveTask;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.annotations.MetricScope;
import edu.montana.gsoc.msusel.metrics.utility.Pair;
import edu.montana.gsoc.msusel.util.MetricNameRegistry;

/**
 * @author Isaac Griffith
 */
public abstract class Metric extends RecursiveTask<Pair<String, Double>> {

    /**
     * The name of this metric
     */
    protected String                                           name;
    /**
     * The main acronym of this metric
     */
    protected String                                           acronym;
    /**
     * A description of this metric
     */
    protected String                                           description;
    /**
     * The applicable scope of this metric
     */
    protected MetricScope                                      scope;
    /**
     * Mapping for dependencies of this metric
     */
    protected Map<String, RecursiveTask<Pair<String, Double>>> taskMap;
    /**
     * Node to which this metric will be applied
     */
    private INode                                              entity;
    /**
     * CodeTree used to extract information for computation
     */
    private CodeTree                                           tree;

    /**
     * Constructs a new instance of this metric with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this metric
     * @param desc
     *            Description of this metric
     * @param acronym
     *            Acronym of this metric
     * @param scope
     *            Scoping level for this metric
     */
    public Metric(final String name, final String desc, final String acronym, final MetricScope scope)
    {
        this.name = name;
        description = desc;
        this.scope = scope;
        this.acronym = acronym;

        registerNames();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<String, Double> compute()
    {
        setPrerequisites();
        return new Pair<String, Double>(acronym, measure(entity, tree));
    }

    /**
     * @return This metric's acronym
     */
    public String getAcronym()
    {
        return acronym;
    }

    /**
     * @return This metric's description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return This metric's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return This metric's scope
     */
    public MetricScope getScope()
    {
        return scope;
    }

    /**
     * @param entity
     *            Entity to which this metric will be applied
     */
    public void setEntity(INode entity)
    {
        this.entity = entity;
    }

    /**
     * @param tree
     *            Tree containing the entity to which this metric will be
     *            applied
     */
    public void setTree(CodeTree tree)
    {
        this.tree = tree;
    }

    /**
     * Compute the measurement for the given entity which is found in the
     * provided tree.
     * 
     * @param entity
     *            Entity to measure
     * @param tree
     *            CodeTree containing the entity
     * @return Measurement value
     */
    public abstract double measure(INode entity, CodeTree tree);

    /**
     * Method used to set a dependency for this metric, default implementation
     * is blank.
     * <br>
     * Example:
     * <code>
     * NOM = taskMap.containsKey("NOM") ? taskMap.get("NOM").join().getValue() : entity.getMetric("NOM");
     * </code>
     * <br>
     * This assumes that the variable NOM is a field in an overriding method's
     * class
     */
    public void setPrerequisites()
    {

    }

    /**
     * @param map
     *            The new task map for dependencies
     */
    public void setTaskMap(final Map<String, RecursiveTask<Pair<String, Double>>> map)
    {
        taskMap = map;
    }

    /**
     * @return An array of alternative names, default value is an empty String
     *         array.
     */
    protected String[] altNames()
    {
        return new String[] {};
    }

    /**
     * Registers the acronym and altNames of this metric with the
     * MetricNameRegistry
     */
    private void registerNames()
    {
        MetricNameRegistry.getInstance().register(this.getAcronym(), this.altNames());
    }
}
