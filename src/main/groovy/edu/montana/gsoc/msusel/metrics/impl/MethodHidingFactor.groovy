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

import edu.isu.isuese.datamodel.Accessibility
import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Method
import edu.isu.isuese.datamodel.Structure
import edu.isu.isuese.datamodel.Type
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.3.0
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
class MethodHidingFactor extends MetricEvaluator {

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
    def measureValue(Measurable node) {
        double total = 0.0

        if (node instanceof Structure) {
            List<Type> classes = node.getTypes()

            def isVisible = { Method m ->
                Type t = (Type) m.parent

                Set<Type> dc = []
                dc += t.getGeneralizes()
                dc += t.getRealizes()

                Set<Type> pc = []
                pc += mediator.getNamespaceClasses(mediator.findNamespace(t)) // FIXME

                Set<Type> mc = []
                mc += mediator.getModuleClasses(mediator.findModule(t)) // FIXME

                Accessibility access = m.getAccessibility()

                switch (access) {
                    case Accessibility.PUBLIC:
                        return 1
                    case Accessibility.PRIVATE:
                        return 0
                    case Accessibility.PROTECTED:
                        return (double) dc.size() / (double) (classes.size() - 1)
                    case Accessibility.PACKAGE:
                        return (double) pc.size() / (double) (classes.size() - 1)
                    case Accessibility.DEFAULT:
                        return (double) pc.size() / (double) (classes.size() - 1)
                    case Accessibility.INTERNAL:
                        return (double) mc.size() / (double) (classes.size() - 1)
                    case Accessibility.PROTECTED_INTERNAL:
                        return (double) (dc.size() + mc.size()) / (double) (classes.size() - 1)
                    default:
                        return 0
                }
            }

            def visibility = { Method m ->
                double totalVisible = 0.0

                classes.each {
                    totalVisible += isVisible(m)
                }

                totalVisible / (classes.size() - 1)
            }

            double totalMd = 0.0
            double totalVis = 0.0

            classes.each {
                double mn = getMetric(it, "NMA")
                double mo = getMetric(it, "NMO")
                totalMd += mn + mo

                it.getMethods().each { method ->
                    totalVis += (1 - visibility(method))
                }
            }
        }

        total
    }

}
