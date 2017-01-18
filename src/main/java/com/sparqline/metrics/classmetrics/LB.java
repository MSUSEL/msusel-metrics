package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * LB - Line Bias. When comparing two pieces of code (e.g., two files or two
 * functions) we usually find more than one exact clone. In this context, Line
 * Bias is the distance between two consecutive exact clones, i.e., the number
 * of non-matching lines of code between two exact clones. The LB value may
 * allow us to decide if two exact clones belong to the same cluster of
 * duplicated lines (e.g., the gap between the two exact clones could be a
 * modified portion of code within a duplicated block of code).
 * 
 * @author Isaac Griffith
 */
public class LB extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -7976521932153754226L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LB getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LB(
                "Line Bias",
                "When comparing two pieces of code (e.g., two files or two functions) we usually find more than one exact clone. In this context, Line Bias is the distance between two consecutive exact clones, i.e., the number of non-matching lines of code between two exact clones. The LB value may allow us to decide if two exact clones belong to the same cluster of duplicated lines (e.g., the gap between the two exact clones could be a modified portion of code within a duplicated block of code).",
                "LB", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LB(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
