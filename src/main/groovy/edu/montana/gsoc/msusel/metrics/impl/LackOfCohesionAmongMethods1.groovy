/*
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

import com.google.common.collect.Sets
import edu.isu.isuese.datamodel.Field
import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Measure
import edu.isu.isuese.datamodel.Method
import edu.isu.isuese.datamodel.Modifier
import edu.isu.isuese.datamodel.Type
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.*
/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Lack of Cohesion among Object Methods",
        primaryHandle = "LCOM1",
        description = "A count of the number of mehtod pairs whose similarity is 0 minus the count of methods whose similarity is not 0.",
        properties = @MetricProperties(
                range = "Positive Integer",
                aggregation = [],
                scope = MetricScope.TYPE,
                type = MetricType.Model,
                scale = MetricScale.Interval,
                category = MetricCategory.Cohesion
        ),
        references = [
                'Chidamber, Shyam R., and Chris F. Kemerer. Towards a metrics suite for object oriented design. Vol. 26. No. 11. ACM, 1991.',
                'Chidamber, Shyam R., and Chris F. Kemerer. "A metrics suite for object oriented design." IEEE Transactions on software engineering 20.6 (1994): 476-493.',
                'Briand, Lionel C., John W. Daly, and Jurgen Wust. "A unified framework for cohesion measurement in object-oriented systems." Software Metrics Symposium, 1997. Proceedings., Fourth International. IEEE, 1997.'
        ]
)
class LackOfCohesionAmongMethods1 extends MetricEvaluator {

    /**
     * {@inheritDoc}
     */
    @Override
    def measureValue(Measurable node) {
        int total = 0

        if (node instanceof Type) {
            List<Field> fields = node.getFields().findAll { !it.hasModifier(Modifier.Values.STATIC) }
            List<Method> methods = node.getMethods()

            Set I = { Type t, Method m ->
                Sets.newHashSet(m.getFieldsUsed()).intersect(fields)
            }

            Set p = []
            Set q = []

            methods.each { Method m1 ->
                methods.each { Method m2 ->
                    if (m1 != m2) {
                        if (I(node, m1).intersect(I(node, m2)).isEmpty()) {  // TODO Fix this
                            p += I(node, m1)
                            p += I(node, m2)
                        } else {
                            q += I(node, m1)
                            q += I(node, m2)
                        }
                    }
                }
            }

            if (p.size() > q.size())
                total = p.size() - q.size()
        }

        //Measure.of(this).on(node).withValue(total).store())
    }
}
