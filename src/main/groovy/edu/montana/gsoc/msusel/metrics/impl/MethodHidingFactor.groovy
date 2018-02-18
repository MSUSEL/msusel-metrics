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
import edu.montana.gsoc.msusel.codetree.node.Accessibility
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode
import edu.montana.gsoc.msusel.codetree.node.structural.StructuralNode
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Method Hiding Factor",
        primaryHandle = "MHF",
        description = "Ratio of hidden methods to total methods",
        properties = @MetricProperties(
                range = "0.0..1.0",
                aggregation = [],
                scope = MetricScope.TYPE,
                type = MetricType.Model,
                scale = MetricScale.Ratio,
                category = MetricCategory.Encapsulation
        ),
        references = [
                'Abreu, Fernando Brito, and Rogério Carapuça. "Object-oriented software engineering: Measuring and controlling the development process." Proceedings of the 4th international conference on software quality. Vol. 186. 1994.',
                'e Abreu, F. Brito, and Walcelio Melo. "Evaluating the impact of object-oriented design on software quality." Software Metrics Symposium, 1996., Proceedings of the 3rd International. IEEE, 1996.',
                'Abreu, F. Brito, Miguel Goulão, and Rita Esteves. "Toward the design quality evaluation of object-oriented software systems." Proceedings of the 5th International Conference on Software Quality, Austin, Texas, USA. 1995.'
        ]
)
class MethodHidingFactor extends AbstractMetric {

    /**
     *
     */
    MethodHidingFactor() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        double total = 0.0

        if (node instanceof StructuralNode) {
            def classes = node.classes()

            def isVisible = { MethodNode m ->
                TypeNode t = tree.getMethodOwnerType(m)

                Set<TypeNode> dc = []
                dc += tree.getGeneralizedTo(t)
                dc += tree.getRealizedTo(t)

                Set<TypeNode> pc = []
                pc += tree.getNamespaceClasses(t.getNamespace())

                Set<TypeNode> mc = []
                mc += tree.getModuleClasses(tree.getModuleForType(t))

                Accessibility access = m.getAccessibility()

                switch (access) {
                    case Accessibility.PUBLIC:
                        1
                    case Accessibility.PRIVATE:
                        0
                    case Accessibility.PROTECTED:
                        (double) dc.size() / (double) (classes.size() - 1)
                    case Accessibility.PACKAGE:
                        (double) pc.size() / (double) (classes.size() - 1)
                    case Accessibility.DEFAULT:
                        (double) pc.size() / (double) (classes.size() - 1)
                    case Accessibility.INTERNAL:
                        (double) mc.size() / (double) (classes.size() - 1)
                    case Accessibility.PROTECTED_INTERNAL:
                        (double) (dc.size() + mc.size()) / (double) (classes.size() - 1)
                    default:
                        0
                }
            }

            def visibility = { MethodNode m ->
                double totalVisible = 0.0

                classes.each {
                    totalVisible += isVisible(m, it)
                }

                totalVisible / (classes.size() - 1)
            }

            double totalMd = 0.0
            double totalVis = 0.0

            classes.each {
                double mn = getMetric("NMA", it)
                double mo = getMetric("NMO", it)
                totalMd += mn + mo

                it.methods().each { method ->
                    totalVis += (1 - visibility(method))
                }
            }
        }

        total
    }

}
