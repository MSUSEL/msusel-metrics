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
import edu.montana.gsoc.msusel.datamodel.structural.Structure
import edu.montana.gsoc.msusel.datamodel.type.Type
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Average Number of Ancestors",
        primaryHandle = "ANA",
        description = "The average number of classes from which a class inhertisinformation.It is computed by dtermingthe number of classes along all pathsfrom the 'root' class(es) to all classes in an inheritance structure",
        properties = @MetricProperties(
                range = "Positive Integers",
                aggregation = [],
                scope = MetricScope.STRUCTURAL,
                type = MetricType.Model,
                scale = MetricScale.Interval,
                category = MetricCategory.Inheritance
        ),
        references = [
                ''
        ]
)
class AverageNumberOfAncestors extends AbstractMetric {

    /**
     *
     */
    AverageNumberOfAncestors() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        double total = 0.0

        if (node instanceof Structure) {
            def map = [:]
            def classes = mediator.findTypes(node)
            classes.each { Type t ->
                total += recursiveSearch(t, map)
            }
            total /= classes.size()
        }

        total
    }

    private def recursiveSearch(Type type, map) {
        if (map[type]) {
            map[type]
        } else if (mediator.getRealizedFrom(type).isEmpty() && mediator.getGeneralizedFrom(type).isEmpty()) {
            map[type] = 0
            map[type]
        } else {
            int real = mediator.getRealizedFrom(type).collect {}
            int gen = mediator.getGeneralizedFrom(type).collect {}
            map[type] = 1 + real + gen
            map[type]
        }
    }
}
