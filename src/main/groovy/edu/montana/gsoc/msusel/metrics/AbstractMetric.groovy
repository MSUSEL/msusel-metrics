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
package edu.montana.gsoc.msusel.metrics

import com.google.inject.Inject
import edu.montana.gsoc.msusel.datamodel.DataModelMediator
import edu.montana.gsoc.msusel.datamodel.measures.Measurable
import edu.montana.gsoc.msusel.datamodel.measures.MeasuresTable
import edu.montana.gsoc.msusel.datamodel.measures.Metric
import edu.montana.gsoc.msusel.datamodel.measures.MetricRepository
import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
abstract class AbstractMetric {

    @Inject
    protected DataModelMediator mediator
    @Inject
    protected MeasuresTable table
    
    abstract def measure(Measurable node)

    double getMetric(Measurable node, String handle) {
    }

    Metric toMetric(MetricRepository repo) {
        MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
        Metric.builder()
                .name(mdef.name())
                .metricKey("${repo.repoKey}:${mdef.primaryHandle()}")
                .description(mdef.description())
                .repository(repo)
                .create()
    }
}
