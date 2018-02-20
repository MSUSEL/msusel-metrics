package edu.montana.gsoc.msusel.metrics

import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition
import org.reflections.Reflections

@Singleton
class MetricsRegistrar {

    static final String METRICS_PKG = "edu.montana.gsoc.msusel.metrics.impl"

    def register = [:]

    static {
        register()
    }

    static void register() {
        Reflections reflections = new Reflections(METRICS_PKG)

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(MetricDefinition.class)

        annotated.each {
            MetricDefinition mdef = it.getAnnotation(MetricDefinition.class)
            if ((mdef.name() != null && !mdef.name().isEmpty()) && (mdef.primaryHandle() != null && !mdef.primaryHandle().isEmpty())) {
                MetricsRegistrar.instance.register[mdef.primaryHandle()] = it
            }
        }
    }

    Class<? extends AbstractMetric> getMetric(String primaryHandle) {
        if (register[primaryHandle])
            register[primaryHandle]
        else
            null
    }
}
