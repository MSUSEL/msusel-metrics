/**
 * 
 */
package com.sparqline.metrics.method;

import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

public class NMS extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6252259534992947142L;

    public static NMS getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NMS("Number of Message Sends",
                "Measures the number of messages sent in the method, segregated by type of message. The types include: Unary (messages with no arguments), Binary (messages with one argument, separated by a special selector name), and Keyword (messages with one or more arguments).",
                "NMS", MetricScope.MethodLevel, entity, graph);
    }

    private NMS(final String name, final String desc, final String acronym, final MetricScope scope,
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
