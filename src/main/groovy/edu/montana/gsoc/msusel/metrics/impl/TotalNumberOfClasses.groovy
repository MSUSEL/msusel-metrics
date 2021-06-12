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

import edu.isu.isuese.datamodel.ComponentContainer
import edu.isu.isuese.datamodel.File
import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Measure
import edu.isu.isuese.datamodel.Namespace
import edu.isu.isuese.datamodel.PatternInstance
import edu.isu.isuese.datamodel.Structure
import edu.isu.isuese.datamodel.Type
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Total Number of Classes",
        primaryHandle = "TNOC",
        description = "The total number of classes defined within this structure",
        properties = @MetricProperties(
                range = "",
                aggregation = [],
                scope = MetricScope.ALL,
                type = MetricType.Derived,
                scale = MetricScale.Interval,
                category = MetricCategory.Size
        ),
        references = [
                ''
        ]
)
class TotalNumberOfClasses extends MetricEvaluator {

    /**
     *
     */
    TotalNumberOfClasses() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        double total = 0

        if (node instanceof Type) {
            total = node.getValueFor("${repo.getRepoKey()}:NC")
            node.getContained().each {
                total += it.getValueFor("${repo.getRepoKey()}:NC")
            }

            Measure.of("${repo.getRepoKey()}:TNOC").on(node).withValue(total)
        }
        else if (node instanceof ComponentContainer) {
            node.getAllTypes().each {
                total += it.getValueFor("${repo.getRepoKey()}:NC")
            }
            Measure.of("${repo.getRepoKey()}:TNOC").on(node).withValue(total)
        }


        total
    }

}
