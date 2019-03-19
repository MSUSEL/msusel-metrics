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

import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Modifier
import edu.isu.isuese.datamodel.Structure
import edu.isu.isuese.datamodel.Type
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*
/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Abstraction Ratio",
        primaryHandle = "AR",
        description = "",
        properties = @MetricProperties(
                range = "0..1",
                aggregation = [],
                scope = MetricScope.METHOD,
                type = MetricType.Derived,
                scale = MetricScale.Interval,
                category = MetricCategory.Coupling
        ),
        references = [
                ''
        ]
)
class AbstractionRatio extends MetricEvaluator {

    /**
     *
     */
    AbstractionRatio() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        double total = 0.0

        if (node instanceof Structure) {
            List<Type> types = node.getTypes()
            total = types.findAll { it.hasModifier(Modifier.Values.ABSTRACT) }.size()
            total /= types.size()
        }

        total
    }

}
