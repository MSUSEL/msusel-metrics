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

import com.google.common.graph.GraphBuilder
import com.google.common.graph.MutableGraph
import edu.montana.gsoc.msusel.datamodel.measures.Measurable
import edu.montana.gsoc.msusel.datamodel.member.Field
import edu.montana.gsoc.msusel.datamodel.member.Method
import edu.montana.gsoc.msusel.datamodel.type.Type
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.annotations.*

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
class LackOfCohesionAmongMethods3 extends AbstractMetric {

    /**
     *
     */
    LackOfCohesionAmongMethods3() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        int total = 0

        if (node instanceof Type) {
            MutableGraph<Method> graph = GraphBuilder.undirected().build()

            Set<Method> methods = node.methods()
            Set<Field> fields = node.fields()

            methods.each {
                graph.addNode(it)
            }

            methods.each { Method m1 ->
                methods.each { Method m2 ->
                    if (m1 != m2) {
                        Set f1 = mediator.getFieldsUsedBy(m1).intersect(fields)
                        Set f2 = mediator.getFieldsUsedBy(m2).intersect(fields)

                        if (!f1.isEmpty() && !f2.isEmpty() && !f1.intersect(f2).isEmpty())
                            graph.putEdge(m1, m2)
                    }
                }
            }

            Set identified = []
            graph.nodes().each { Method mnode ->
                if (!identified.contains(mnode)) {
                    identified.add(mnode)
                    Set adj = []
                    adj += graph.adjacentNodes(mnode)
                    adj.removeAll(adj.intersect(identified))

                    Queue<Method> que = new ArrayDeque<>()
                    que.addAll(adj)
                    while (!que.isEmpty()) {
                        Method current = que.poll()
                        identified.add(current)
                        adj = []
                        adj += graph.adjacentNodes(mnode)
                        adj.removeAll(adj.intersect(identified))
                        que.addAll(adj)
                    }

                    total += 1
                }
            }
        }

        total
    }

}
