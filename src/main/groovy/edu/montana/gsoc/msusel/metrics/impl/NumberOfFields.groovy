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

import edu.montana.gsoc.msusel.codetree.node.AbstractNode
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode
import edu.montana.gsoc.msusel.codetree.node.structural.ModuleNode
import edu.montana.gsoc.msusel.codetree.node.structural.ProjectNode
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.Measurement
import edu.montana.gsoc.msusel.metrics.annotations.*
import edu.montana.gsoc.msusel.metrics.MeasuresTable

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Number of Fields",
        primaryHandle = "NOF",
        description = "Count of the number of fields or attributes defined but not inherited by a class",
        properties = @MetricProperties(
                range = "Postive Integers",
                aggregation = [],
                scope = MetricScope.TYPE,
                type = MetricType.Model,
                scale = MetricScale.Interval,
                category = MetricCategory.BasicProperty
        ),
        references = [
                ''
        ]
)
class NumberOfFields extends AbstractMetric {

    /**
     *
     */
    NumberOfFields() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        int total = 0

        if (node instanceof TypeNode) {
            total = node.fields().size()
        } else if (node instanceof FileNode) {
            ((FileNode) node).types().each { TypeNode type ->
                total += type.fields().size()
            }
        } else if (node instanceof ProjectNode) {
            ((ProjectNode) node).types().each { TypeNode type ->
                total += type.fields().size()
            }
        } else if (node instanceof ModuleNode) {
            ((ModuleNode) node).types().each { TypeNode type ->
                total += type.fields().size()
            }
        }

        MeasuresTable.instance.store(Measurement.of(this).on(node).withValue(total))
        total
    }

}
