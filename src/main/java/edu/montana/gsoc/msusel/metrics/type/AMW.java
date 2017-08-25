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
package edu.montana.gsoc.msusel.metrics.type;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.metrics.ClassMetric;
import edu.montana.gsoc.msusel.metrics.DerivedMetric;
import edu.montana.gsoc.msusel.metrics.annotations.Acronym;
import edu.montana.gsoc.msusel.metrics.annotations.Aggregatable;
import edu.montana.gsoc.msusel.metrics.annotations.AggregationType;
import edu.montana.gsoc.msusel.metrics.annotations.Dependency;
import edu.montana.gsoc.msusel.metrics.annotations.Description;
import edu.montana.gsoc.msusel.metrics.annotations.Implemented;
import edu.montana.gsoc.msusel.metrics.annotations.MetricScale;
import edu.montana.gsoc.msusel.metrics.annotations.MetricScope;
import edu.montana.gsoc.msusel.metrics.annotations.Scale;
import edu.montana.gsoc.msusel.metrics.annotations.Title;

/**
 * Average Method Weight. The average static complexity of all methods in a
 * class. McCabe's cyclomatic number is used to quantify the method's
 * complexity.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
@Title("Average Method Weight")
@Acronym("AMW")
@Description("The average static complexity of all methods in a class. McCabe's cyclomatic number is used to quantify the method's complexity.")
@Dependency(name = "NOM", scope = MetricScope.Type)
@Dependency(name = "CYCLO", scope = MetricScope.Method, aggregation = AggregationType.Summation)
@Scale(MetricScale.Interval)
@Aggregatable
@Implemented
public class AMW extends ClassMetric implements DerivedMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static AMW getInstance()
    {
        return new AMW(
                "Average Method Weight",
                "The average static complexity of all methods in a class. McCabe's cyclomatic number is used to quantify the method's complexity.",
                "AMW");
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
    private AMW(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // final List<CodeNode> methods = tree.getMethods(entity);

        double totalCyclo = 0.0d;
        // for (final CodeNode method : methods)
        // {
        // totalCyclo += method.getMetric("CYCLO");
        // }

        // return (totalCyclo / methods.size());
        return totalCyclo;
    }
}
