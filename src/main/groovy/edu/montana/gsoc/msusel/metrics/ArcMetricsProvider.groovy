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
package edu.montana.gsoc.msusel.metrics

import edu.isu.isuese.datamodel.MetricRepository
import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition
import org.reflections.Reflections

class ArcMetricsProvider implements MetricsProvider {

    static final String METRICS_PKG = "edu.montana.gsoc.msusel.metrics.impl"
    static final String REPO_KEY = ""
    static final String REPO_NAME = ""

    MetricRepository repository

    void registerRepository() {
        repository = MetricRepository.findOrCreateIt("repoKey", REPO_KEY, "name", REPO_NAME)
    }

    void registerMetrics() {

    }

    MetricEvaluator getMetricEvaluator() {

    }

    private void checkAndRegisterIfUnknown(Class cls) {
        cls.getName()
        Reflections reflections = new Reflections(METRICS_PKG)

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(MetricDefinition.class)

        annotated.each {
            MetricDefinition mdef = it.getAnnotation(MetricDefinition.class)
            if ((mdef.name() != null && !mdef.name().isEmpty()) && (mdef.primaryHandle() != null && !mdef.primaryHandle().isEmpty())) {
                MetricsRegistrar.instance.register[mdef.primaryHandle()] = it
            }
        }
    }
}
