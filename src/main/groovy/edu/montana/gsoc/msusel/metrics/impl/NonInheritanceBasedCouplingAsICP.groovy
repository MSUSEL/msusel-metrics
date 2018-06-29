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
package edu.montana.gsoc.msusel.metrics.impl

import edu.montana.gsoc.msusel.datamodel.measures.Measurable
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.annotations.*
/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Non-Inheritance Based Coupling as Information Flow Based Coupling",
        primaryHandle = "NIH-ICP",
        description = "",
        properties = @MetricProperties(
                range = "Positive Integers",
                aggregation = [],
                scope = MetricScope.METHOD,
                type = MetricType.Derived,
                scale = MetricScale.Interval,
                category = MetricCategory.Coupling
        ),
        references = [
                'Lee, Y. S., et al. "Measuring the coupling and cohesion of an object-oriented program based on information flow." Proc. International Conference on Software Quality, Maribor, Slovenia. 1995.',
                'Briand, Lionel C., John W. Daly, and Jurgen K. Wust. "A unified framework for coupling measurement in object-oriented systems." IEEE Transactions on software Engineering 25.1 (1999): 91-121.'
        ]
)
class NonInheritanceBasedCouplingAsICP extends AbstractMetric {

    /**
     *
     */
    NonInheritanceBasedCouplingAsICP() {
        // TODO Auto-generated constructor stub
    }

    @Override
    def measure(Measurable node) {
        return null
    }
}
