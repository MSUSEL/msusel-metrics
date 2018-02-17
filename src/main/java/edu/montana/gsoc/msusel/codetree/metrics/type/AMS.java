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
package edu.montana.gsoc.msusel.codetree.metrics.type;

import java.util.Set;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;
import edu.montana.gsoc.msusel.codetree.node.MethodNode;
import edu.montana.gsoc.msusel.codetree.node.TypeNode;
import edu.montana.gsoc.msusel.codetree.metrics.DerivedMetric;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.Acronym;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.Aggregatable;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.Dependency;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.AggregationType;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.Description;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.Implemented;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.MetricScale;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.MetricScope;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.Scale;
import edu.montana.gsoc.msusel.codetree.metrics.annotations.Title;

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
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static AMS getInstance()
    {
        return new AMS(
                "Average Method Size", "Average size of the methods in the class. AMS = Total Method LOC / NOM.",
                "AMS");
    }

    /**
     * Constructs a new instance of this name with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this name
     * @param desc
     *            Description of this name
     * @param acronym
     *            Acronym of this name
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
