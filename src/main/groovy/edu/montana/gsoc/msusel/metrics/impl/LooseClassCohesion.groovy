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

import edu.montana.gsoc.msusel.datamodel.Accessibility
import edu.montana.gsoc.msusel.datamodel.measures.Measurable
import edu.montana.gsoc.msusel.datamodel.member.Field
import edu.montana.gsoc.msusel.datamodel.member.Method
import edu.montana.gsoc.msusel.datamodel.type.Type
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.annotations.*
import org.apache.commons.lang3.tuple.Pair

/**
 * @author Isaac Griffith
 * @version 1.2.0
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
class LooseClassCohesion extends AbstractMetric {

    /**
     *
     */
    LooseClassCohesion() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        double total = 0

        if (node instanceof Type) {
            def methods = node.methods()
            def pubMethods = methods.findAll { it.access == Accessibility.PUBLIC }

            Set<Pair<Method, Method>> ndc = []
            methods.each { Method first ->
                methods.each { Method second ->
                    if (first != second) {
                        Set<Field> firstFldUse = mediator.getFieldUseInSameClass(first, (Type) node)
                        Set<Field> secondFldUse = mediator.getFieldUseInSameClass(second, (Type) node)

                        if (!firstFldUse.intersect(secondFldUse).isEmpty())
                            ndc << Pair.of(first, second)
                    }
                }
            }

            Set<Pair<Method, Method>> nid = []
            methods.each { Method first ->
                methods.each { Method second ->
                    if (first != second) {
                        Set<Method> firstMethUse = mediator.getMethodUseInSameClass(first, (Type) node)
                        Set<Method> secondMethUse = mediator.getMethodUseInSameClass(second, (Type) node)

                        if (!firstMethUse.intersect(secondMethUse).isEmpty())
                            nid << Pair.of(first, second)
                    }
                }
            }

            double np = (pubMethods.size() * pubMethods.size() - 1) / 2

            total = (double) (nid.size() + ndc.size()) / np
        }

        total
    }
}