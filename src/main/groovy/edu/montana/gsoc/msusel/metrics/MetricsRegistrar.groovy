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

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
class MetricsRegistrar {

    Map<String, MetricEvaluator> primary = [:]
    Map<String, MetricEvaluator> secondary = [:]
    Map<String, String> handles = [:]
    MetricRepository repo

    MetricsRegistrar(MetricRepository repo) {
        this.repo = repo
    }

    void registerPrimary(MetricEvaluator evaluator) {
        Class<? extends MetricEvaluator> clazz = evaluator.getClass()
        MetricDefinition mdef = clazz.getAnnotation(MetricDefinition.class)
        if ((mdef.name() != null && !mdef.name().isEmpty()) && (mdef.primaryHandle() != null && !mdef.primaryHandle().isEmpty())) {
            primary[mdef.primaryHandle()] = evaluator
            handles[mdef.primaryHandle()] = mdef.primaryHandle()
            mdef.otherHandles().each {
                handles[it] = mdef.primaryHandle()
            }
        }

        evaluator.setRepo(this.repo)
    }

    void registerSecondary(MetricEvaluator evaluator) {
        Class<? extends MetricEvaluator> clazz = evaluator.getClass()
        MetricDefinition mdef = clazz.getAnnotation(MetricDefinition.class)
        if ((mdef.name() != null && !mdef.name().isEmpty()) && (mdef.primaryHandle() != null && !mdef.primaryHandle().isEmpty())) {
            secondary[mdef.primaryHandle()] = evaluator
            handles[mdef.primaryHandle()] = mdef.primaryHandle()
            mdef.otherHandles().each {
                handles[it] = mdef.primaryHandle()
            }
        }

        evaluator.setRepo(this.repo)
    }

    MetricEvaluator getMetric(String primaryHandle) {
        if (primary[primaryHandle])
            primary[primaryHandle]
        else if (secondary[primaryHandle])
            secondary[primaryHandle]
        else
            null
    }

    List<MetricEvaluator> getPrimaryEvaluators() {
        return primary.values().asList()
    }

    List<MetricEvaluator> getSecondaryEvaluators() {
        return secondary.values().asList()
    }

    String getHandle(String handle) {
        handles[handle]
    }

    MetricEvaluator getEvaluator(String handle) {
        String eval = getHandle(handle)
        if (this.primary[eval])
            this.primary[eval]
        else if (this.secondary[eval])
            this.secondary[eval]
        else
            null
    }
}
