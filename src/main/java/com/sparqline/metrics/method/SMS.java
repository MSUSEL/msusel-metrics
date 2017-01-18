/**
 * 
 */
package com.sparqline.metrics.method;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

public class SMS extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4369871219207624065L;

    public static SMS getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new SMS("Strings of Message Sends", "", "SMS", MetricScope.MethodLevel, entity, graph);
    }

    private SMS(final String name, final String desc, final String acronym, final MetricScope scope,
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
