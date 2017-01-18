package com.sparqline.metrics.method;

import java.util.HashMap;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NMC - Number of Method Calls. Count of the number of methods called from the
 * target method.
 * 
 * @author Isaac Griffith
 */
public class NMC extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4036764620704434640L;

    public static NMC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NMC("Number of Method Calls", "Count of the number of methods called from the target method.",
                "NMC", MetricScope.MethodLevel, entity, graph);
    }

    private NMC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // TODO Fix this
        // final List<Connection> calls = graph.getConnectionsByType(entity,
        // DirectedRelationshipType.MethodCall);
        MethodNode me = (MethodNode) entity;
        HashMap<MethodNode, Integer> map = new HashMap<>();
        for (MethodNode ex : me.getMethodCalls())
        {
            if (map.containsKey(ex))
            {
                int value = map.get(ex);
                map.put(ex, ++value);
            }
            else
            {
                map.put(ex, 1);
            }
        }

        int total = 0;
        for (MethodNode method : map.keySet())
        {
            total += map.get(method);
        }

        return total;
    }
}
