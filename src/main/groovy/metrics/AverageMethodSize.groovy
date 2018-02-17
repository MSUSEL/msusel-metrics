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
    name = "Average Method Size",
    primaryHandle = "AMS",
    description = "Average size of methods in the project",
    properties = @MetricProperties(
        range = "Positive Real",
        aggregation = [],
        scope = MetricScope.STRUCTURAL,
        type = MetricType.Derived,
        scale = MetricScale.Ratio,
        category = MetricCategory.Size
    ),
    references = [
        'Lorenz, Mark, and Jeff Kidd. Object-oriented software metrics: a practical guide. Prentice-Hall, Inc., 1994.'
    ]
)
class AverageMethodSize extends AbstractMetric {

    /**
     * 
     */
    AverageMethodSize()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node)
    {
        int total = 0
        
        if (node instanceof StructuralNode) {
            total = getMetric(node, "LOC") / getMetric(node, "NOM")
        }
        
        total
    }

}
