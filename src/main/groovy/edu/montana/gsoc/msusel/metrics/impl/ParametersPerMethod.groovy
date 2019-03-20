/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.metrics.impl

import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Type
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Parameters Per Method",
        primaryHandle = "PPM",
        description = "The average number of parameters per method in a class",
        properties = @MetricProperties(
                range = "Positive Real",
                aggregation = [],
                scope = MetricScope.TYPE,
                type = MetricType.Derived,
                scale = MetricScale.Ratio,
                category = MetricCategory.Complexity
        ),
        references = [
                'Lorenz, Mark, and Jeff Kidd. Object-oriented software metrics: a practical guide. Prentice-Hall, Inc., 1994.'
        ]
)
class ParametersPerMethod extends MetricEvaluator {

    /**
     *
     */
    ParametersPerMethod() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        double total = 0.0

        if (node instanceof Type) {
            def methods = node.getMethods()

            methods.each {
                total += getMetric(it, "NumPar")
            }

            total /= methods.size()
        }

        total
    }

}
