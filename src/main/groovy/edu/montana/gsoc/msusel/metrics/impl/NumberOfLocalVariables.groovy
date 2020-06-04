package edu.montana.gsoc.msusel.metrics.impl

import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Measure
import edu.isu.isuese.datamodel.Method
import edu.isu.isuese.datamodel.Project
import edu.isu.isuese.datamodel.Type
import edu.isu.isuese.datamodel.cfg.ControlFlowGraph
import edu.isu.isuese.datamodel.cfg.StatementType
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
        name = "Number of Local Variables",
        primaryHandle = "NOV",
        description = "Count of all the variables locally defined in a class.",
        properties = @MetricProperties(
                range = "Positive Integers",
                aggregation = [],
                scope = MetricScope.ALL,
                type = MetricType.Model,
                scale = MetricScale.Interval,
                category = MetricCategory.Size
        ),
        references = [
        ]
)
class NumberOfLocalVariables extends MetricEvaluator {

    @Override
    def measure(Measurable node) {
        double total = 0

        if (node instanceof Method) {
            ControlFlowGraph cfg = node.getCfg()
            cfg.graph.nodes().each {
                if (it.getType() == StatementType.VAR_DECL)
                    total += 1
            }
        }
        else if (node instanceof Type) {
            node.getMethods().each {
                total += measure(it)
            }
        } else if (node instanceof Project) {
            node.getAllTypes().each {
                total += measure(it)
            }
        }

        Measure.of("${repo.getRepoKey()}:NOV").on(node).withValue(total)

        total
    }
}
