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

import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Measure
import edu.isu.isuese.datamodel.Method
import edu.isu.isuese.datamodel.Project
import edu.isu.isuese.datamodel.Type
import edu.isu.isuese.datamodel.cfg.ControlFlowGraph
import edu.isu.isuese.datamodel.cfg.StatementType
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.MetricCategory
import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition
import edu.montana.gsoc.msusel.metrics.annotations.MetricProperties
import edu.montana.gsoc.msusel.metrics.annotations.MetricScale
import edu.montana.gsoc.msusel.metrics.annotations.MetricScope
import edu.montana.gsoc.msusel.metrics.annotations.MetricType

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Number of Local Variables",
        primaryHandle = "NOV",
        otherHandles = ['#LocalVariableDeclarations'],
        description = "Count of all the variables locally defined in a class.",
        properties = @MetricProperties(
                range = "Positive Integers",
                aggregation = [],
                scope = MetricScope.ALL,
                type = MetricType.Model,
                scale = MetricScale.Interval,
                category = MetricCategory.Size
        ),
        references = [
        ]
)
class NumberOfLocalVariables extends MetricEvaluator {

    @Override
    def measure(Measurable node) {
        double total = 0

        if (node instanceof Method) {
            ControlFlowGraph cfg = node.getCfg()
            cfg.graph.nodes().each {
                if (it.getType() == StatementType.VAR_DECL)
                    total += 1
            }
        }
        else if (node instanceof Type) {
            node.getMethods().each {
                total += measure(it)
            }
        } else if (node instanceof Project) {
            node.getAllTypes().each {
                total += measure(it)
            }
        }

        Measure.of("${repo.getRepoKey()}:NOV").on(node).withValue(total)

        total
    }
}
