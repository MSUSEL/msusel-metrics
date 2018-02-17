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
import edu.montana.gsoc.msusel.codetree.node.Accessibility
import edu.montana.gsoc.msusel.codetree.node.member.ConstructorNode
import edu.montana.gsoc.msusel.codetree.node.member.DestructorNode
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode
import metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Data Access Metric",
        primaryHandle = "DAM",
        description = "Ratio of the number of private (protected) attributesto thetotal numberof attributes declaredin the class.",
        properties = @MetricProperties(
                range = "0.0..1.0",
                aggregation = [],
                scope = MetricScope.METHOD,
                type = MetricType.Model,
                scale = MetricScale.Ratio,
                category = MetricCategory.Encapsulation
        ),
        references = [
                'Bansiya, Jagdish, and Carl G. Davis. "A hierarchical model for object-oriented design quality assessment." IEEE Transactions on software engineering 28.1 (2002): 4-17.'
        ]
)
class DataAccessMetric extends AbstractMetric {

    /**
     *
     */
    DataAccessMetric() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        double total = 0.0

        if (node instanceof TypeNode) {
            def methods = node.methods().findAll { !(it instanceof ConstructorNode) && !(it instanceof DestructorNode) }
            total = methods.findAll {
                it.accessibility == Accessibility.PUBLIC
            }.size()

            total /= methods.size()
        }

        total
    }

}
