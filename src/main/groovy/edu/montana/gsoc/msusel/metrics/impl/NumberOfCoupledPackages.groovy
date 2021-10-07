/*
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
import edu.isu.isuese.datamodel.Namespace
import edu.isu.isuese.datamodel.Type
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*
/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "",
        primaryHandle = "",
        description = "",
        properties = @MetricProperties(
                range = "",
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
class NumberOfCoupledPackages extends MetricEvaluator {

    /**
     *
     */
    NumberOfCoupledPackages() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measureValue(Measurable node) {
        int total = 0

        if (node instanceof Namespace) {
            Set classes = []
            Set otherNS = []

            node.getAllTypes().each {
                classes += it.getAssociatedFrom()
                classes += it.getAssociatedTo()
                classes += it.getAggregatedFrom()
                classes += it.getAggregatedTo()
                classes += it.getComposedFrom()
                classes += it.getComposedTo()
                classes += it.getRealizedBy()
                classes += it.getRealizes()
                classes += it.getGeneralizedBy()
                classes += it.getGeneralizes()
                classes += it.getUseFrom()
                classes += it.getUseTo()
                classes += it.getDependencyFrom()
                classes += it.getDependencyTo()
            }

            classes.removeAll(node.getAllTypes())

            classes.each { Type t ->
                otherNS << mediator.findNamespace(t) // FIXME
            }

            total = otherNS.size()
        }

        total
    }

}
