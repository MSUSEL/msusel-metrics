/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NCM - Number of Class Methods. Number of methods available in the class but
 * not its instances.
 * 
 * @author Isaac Griffith
 */
public class NCM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -1990128057685915611L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NCM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NCM("Number of Class Methods", "Number of methods available in the class but not its instances.",
                "NCM", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NCM(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
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
        // final List<ProgramNode> methods = tree.getMethods(entity);

        double staticCount = 0;

        // for (final ProgramNode pe : methods)
        // {
        // if (pe instanceof MethodNode)
        // {
        // if (((MethodNode) pe).isStatic())
        // {
        // staticCount++;
        // }
        // }
        // }

        return staticCount;
    }
}
