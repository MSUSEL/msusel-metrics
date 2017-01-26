/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static PPM getInstance(final CodeNode entity, final CodeTree graph)
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
            final CodeNode entity, final CodeTree graph)
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
