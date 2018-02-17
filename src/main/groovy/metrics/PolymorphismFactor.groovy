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
import edu.montana.gsoc.msusel.codetree.node.structural.StructuralNode
import metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Polymorphism Factor",
        primaryHandle = "PF",
        description = "Ratio of the number of overriding methods of a class tot he total possible number of overriden methods",
        properties = @MetricProperties(
                range = "",
                aggregation = [],
                scope = MetricScope.METHOD,
                type = MetricType.Model,
                scale = MetricScale.Ratio,
                category = MetricCategory.Polymorphism
        ),
        references = [
                'Abreu, Fernando Brito, and Rogério Carapuça. "Object-oriented software engineering: Measuring and controlling the development process." Proceedings of the 4th international conference on software quality. Vol. 186. 1994.',
                'e Abreu, F. Brito, and Walcelio Melo. "Evaluating the impact of object-oriented design on software quality." Software Metrics Symposium, 1996., Proceedings of the 3rd International. IEEE, 1996.',
                'Abreu, F. Brito, Miguel Goulão, and Rita Esteves. "Toward the design quality evaluation of object-oriented software systems." Proceedings of the 5th International Conference on Software Quality, Austin, Texas, USA. 1995.'
        ]
)
class PolymorphismFactor extends AbstractMetric {

    /**
     *
     */
    PolymorphismFactor() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        double total = 0

        if (node instanceof StructuralNode) {
            def classes = node.classes()

            double totalMo = 0
            double totalProd = 0

            classes.each {
                double dc = getMetric("NDC", it)
                double mn = getMetric("NMA", it)
                totalMo += getMetric("NMO", it)
                totalProd += dc * mn
            }

            total = totalMo / totalProd
        }

        total
    }
}
