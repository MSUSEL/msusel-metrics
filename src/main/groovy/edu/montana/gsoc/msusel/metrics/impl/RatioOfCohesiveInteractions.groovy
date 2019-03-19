package edu.montana.gsoc.msusel.metrics.impl

import com.google.common.graph.Graph
import edu.isu.isuese.datamodel.Measurable
import edu.montana.gsoc.msusel.metrics.MetricEvaluator
import edu.montana.gsoc.msusel.metrics.annotations.MetricCategory
import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition
import edu.montana.gsoc.msusel.metrics.annotations.MetricProperties
import edu.montana.gsoc.msusel.metrics.annotations.MetricScale
import edu.montana.gsoc.msusel.metrics.annotations.MetricScope
import edu.montana.gsoc.msusel.metrics.annotations.MetricType

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@MetricDefinition(
        name = "Ratio of Cohesive Interactions",
        primaryHandle = "RCI",
        description = "",
        properties = @MetricProperties(
                range = "0..1",
                aggregation = [],
                scope = MetricScope.METHOD,
                type = MetricType.Derived,
                scale = MetricScale.Interval,
                category = MetricCategory.Cohesion
        ),
        references = [
                ''
        ]
)
class RatioOfCohesiveInteractions extends MetricEvaluator{

    @Override
    def measure(Measurable node) {
        double total = 0.0
        // 1. Create a graph of all DD and DM interactions
        //    add type nodes
        //    add attribute nodes
        //    add method nodes
        //    add method return type nodes
        //    add method parameter nodes
        //    add DD edges
        //    add DM edges
        // 2. CI(c) = Count the number of interactions (edges)
        double ci = 0
        // 3. Max(c) = Count of all possible interations
        double max = 0
        //    number of types * (number of types - 1)
        //    for each variable add one per type
        //    for each method add one per type
        // 4. RCI = CI(c) / Max(c)
        total = ci / max
        // 5. Return RCI
        return total
    }
}
