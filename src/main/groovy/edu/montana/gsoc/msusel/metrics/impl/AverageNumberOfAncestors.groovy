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
import edu.isu.isuese.datamodel.Measure
import edu.isu.isuese.datamodel.Project
import edu.isu.isuese.datamodel.Structure
import edu.isu.isuese.datamodel.Type
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Average Number of Ancestors",
        primaryHandle = "ANA",
        description = "The average number of classes from which a class inherits .It is computed by determining the number of classes along all paths from the 'root' class(es) to all classes in an inheritance structure",
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
class AverageNumberOfAncestors extends MetricEvaluator {

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

        if (node instanceof Project) {
            Project struct = (Project) node
            def map = [:]
            def classes = struct.getAllTypes()
            classes.each { Type t ->
                total += recursiveSearch(t, map)
            }
            if (classes)
                total /= classes.size()
        }

        Measure.of("${repo.getRepoKey()}:ANA").on(node).withValue(total)

        total
    }

    private def recursiveSearch(Type type, map) {
        if (map[type]) {
            map[type]
        } else if (type.getRealizedBy().isEmpty() && type.getGeneralizedBy().isEmpty()) {
            map[type] = 0
            map[type]
        } else {
            int real = type.getRealizedBy().collect {}
            int gen = type.getGeneralizedBy().collect {}
            map[type] = 1 + real + gen
            map[type]
        }
    }
}