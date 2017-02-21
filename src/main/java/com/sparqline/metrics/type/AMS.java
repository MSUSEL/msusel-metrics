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
package com.sparqline.metrics.type;

import java.util.Set;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.codetree.node.TypeNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.DerivedMetric;
import com.sparqline.metrics.annotations.Acronym;
import com.sparqline.metrics.annotations.Aggregatable;
import com.sparqline.metrics.annotations.AggregationType;
import com.sparqline.metrics.annotations.Dependency;
import com.sparqline.metrics.annotations.Description;
import com.sparqline.metrics.annotations.Implemented;
import com.sparqline.metrics.annotations.MetricScale;
import com.sparqline.metrics.annotations.MetricScope;
import com.sparqline.metrics.annotations.Scale;
import com.sparqline.metrics.annotations.Title;

/**
 * Average Method Size. Average size of the methods in the class. AMS = Total
 * Method LOC / NOM.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
@Title("Average Method Size")
@Acronym("AMS")
@Description("Average size of the methods in the class. AMS = Total Method LOC / NOM.")
@Dependency(name = "NOM", scope = MetricScope.Type)
@Dependency(name = "LOC", scope = MetricScope.Method, aggregation = AggregationType.Summation)
@Scale(MetricScale.Interval)
@Aggregatable
@Implemented
public class AMS extends ClassMetric implements DerivedMetric {

    /**
     * number of methods defined in teh class
     */
    private double nom = 0.0;

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static AMS getInstance()
    {
        return new AMS(
                "Average Method Size", "Average size of the methods in the class. AMS = Total Method LOC / NOM.",
                "AMS");
    }

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
     */
    private AMS(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(INode entity, CodeTree tree)
    {
        if (entity instanceof TypeNode)
        {
            TypeNode type = (TypeNode) entity;
            double totalLOC = 0.0;

            Set<MethodNode> methods = type.getMethods();

            for (final MethodNode method : methods)
            {
                totalLOC += method.getMetric("SLOC");
            }

            return (totalLOC / nom);
        }

        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // nom = (taskMap.containsKey("NOM") ?
        // taskMap.get("NOM").join().getValue() : entity.getMetric("NOM"));
    }
}
