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

import edu.isu.isuese.datamodel.Component
import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Metric
import edu.isu.isuese.datamodel.MetricRepository
import edu.isu.isuese.datamodel.Project
import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition
import org.jetbrains.annotations.NotNull

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
abstract class MetricEvaluator implements Comparable<MetricEvaluator> {

    abstract def measure(Measurable node)

    Metric toMetric(MetricRepository repository) {
        MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
        Metric metric = Metric.findFirst("metricKey = ?", "${repository.getRepoKey()}:${mdef.primaryHandle()}")
        if (!metric) {
            metric = Metric.builder()
                    .key("${repository.getRepoKey()}:${mdef.primaryHandle()}")
                    .handle(mdef.primaryHandle())
                    .name(mdef.name())
                    .description(mdef.description())
                    .evaluator(this.class.getCanonicalName())
                    .create()
            repository.addMetric(metric)
        }

        return metric
    }

    List<String> getDependencies() {
        []
    }

    @Override
    int compareTo(MetricEvaluator metricEvaluator) {
        getDependencies().size() <=> metricEvaluator.getDependencies().size()
    }

    double getMeasure(Component comp, String repo, String handle) {
        Project proj = comp.getParentProjects().first()

        proj.getMeasuredValue(comp, repo, handle)
    }
}
