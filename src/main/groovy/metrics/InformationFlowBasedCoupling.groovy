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
package metrics

import edu.montana.gsoc.msusel.codetree.node.AbstractNode
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode
import edu.montana.gsoc.msusel.codetree.node.structural.StructuralNode
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode
import metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Information Flow Based Coupling",
        primaryHandle = "IH-ICP",
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
class InformationFlowBasedCoupling extends AbstractMetric {

    /**
     *
     */
    InformationFlowBasedCoupling() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        int total = 0

        if (node instanceof MethodNode) {
            def others = tree.getMethodsCalledFrom(node).findAll {
                it.parentKey != node.parentKey
            }

            others.each { other ->
                int nop = other.getParams().size() + 1
                int npi = 0 // TODO fix this

                total += nop * npi
            }
        } else if (node instanceof TypeNode) {
            node.methods().each {
                total += getMetric("ICP", it)
            }
        } else if (node instanceof StructuralNode) {
            node.types().each {
                total += getMetric("ICP", it)
            }
        }

        total
    }

}
