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
