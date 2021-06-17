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


import edu.isu.isuese.datamodel.*
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Afferent Coupling",
        primaryHandle = "Ca",
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
class AfferentCoupling extends MetricEvaluator {

    Map<String, Set<String>> rels = [:]

    /**
     *
     */
    AfferentCoupling() {
        // TODO Auto-generated constructor stub
        rels = [:]
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        double total = 0

        if (node instanceof Type) {
            Type type = node as Type
            total += findCouplings([type.getCompKey()]).size()
            Measure.of("${repo.getRepoKey()}:Ca").on(node).withValue(total)
        }
        else if (node instanceof File) {
            File file = node as File
            List<Double> measures = []
            file.getAllTypes().each {
                measures << Measure.valueFor(repo.getRepoKey(), "Ca", it)
            }
            total = measures.max()
            Measure.of("${repo.getRepoKey()}:Ca").on(node).withValue(total)
        }
        else if (node instanceof PatternInstance) {
            PatternInstance inst = node as PatternInstance
            inst.getTypes().each {
                total += findCouplings(inst.getAllTypes()).size()
            }
            Measure.of("${repo.getRepoKey()}:Ca").on(node).withValue(total)
        }
//        else if (node instanceof System) {
//            System sys = node as System
//            sys.getProjects().each {
//                total += findCouplings(sys.getAllTypes()).size()
//            }
//            Measure.of("${repo.getRepoKey()}:Ca").on(node).withValue(total)
//        }
        else if (node instanceof Namespace) {
            Namespace ns = node as Namespace
            ns.getAllTypes().each {
                total += findCouplings(ns.getAllTypes()).size()
            }
            Measure.of("${repo.getRepoKey()}:Ca").on(node).withValue(total)
        }
//        else if (node instanceof Project) {
//            Project proj = node as Project
//            proj.getNamespaces().each {
//                total += findCouplings(proj.getAllTypes()).size()
//            }
//            Measure.of("${repo.getRepoKey()}:Ca").on(node).withValue(total)
//        }

        total
    }

    private Set<String> findCouplings(List<String> containedTypes) {
        Set<String> couplings = new HashSet<>()

        containedTypes.each {
            if (rels.containsKey(it)) {
                couplings.addAll(rels[it])
            } else {
                Type type = Type.findFirst("compKey = ?", it)
                Set<String> set = [] as Set<String>
                set += type.getRealizedBy()*.getCompKey()
                set += type.getGeneralizes()*.getCompKey()
                set += type.getAssociatedFrom()*.getCompKey()
                set += type.getAggregatedFrom()*.getCompKey()
                set += type.getComposedFrom()*.getCompKey()
                set += type.getDependencyFrom()*.getCompKey()
                set += type.getUseFrom()*.getCompKey()
                rels[it] = set

                couplings += set
            }
        }

        couplings.removeAll(containedTypes)

        couplings
    }

    void resetState() {
        rels = [:]
    }
}
