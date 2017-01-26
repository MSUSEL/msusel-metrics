package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NOAM - Number of Accessor Methods. The number of accessor (getter and setter)
 * methods of a class.
 * 
 * @author Isaac Griffith
 */
public class NOAM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 8506315716366795190L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NOAM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NOAM("Number of Accessor Methods", "The number of accessor (getter and setter) methods of a class.",
                "NOAM", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NOAM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double retVal = 0.0;
        // final List<ProgramNode> methods = tree.getMethods(entity);
        //
        // for (final ProgramNode method : methods)
        // {
        // if (method instanceof MethodNode)
        // {
        // final MethodNode me = (MethodNode) method;
        // if (me.isAccessorMethod(tree) || me.isMutatorMethod(tree))
        // {
        // retVal++;
        // }
        // }
        // }

        return retVal;
    }
}
