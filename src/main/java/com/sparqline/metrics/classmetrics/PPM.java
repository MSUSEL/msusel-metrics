/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * PPM - Parameters Per Method. PPM = Total NOP / Total NOM.
 * 
 * @author Isaac Griffith
 */
public class PPM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -847764760656248995L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static PPM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new PPM("Parameters Per Method", "PPM = Total NOP / Total NOM", "PPM", MetricScope.ClassLevel, entity,
                graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private PPM(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        // TODO Auto-generated method stub
        return 0;
    }
}
