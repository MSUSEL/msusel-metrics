package com.sparqline.metrics.method;

import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

/**
 * ChM - Changing Methods. The number of distinct methods that call the measured
 * method
 * 
 * @author Isaac Griffith
 */
public class ChM extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -3844330083197966108L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ChM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new ChM("Changing Methods", "The number of distinct methods that call the measured method", "ChM",
                MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ChM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double chm = 0;

        if (entity instanceof MethodNode)
        {
            /*
             * final Set<ProgramNode> callSet = new HashSet<>();
             * final MethodNode method = (MethodNode) entity;
             * ClassOrInterfaceNode methodOwner = (ClassOrInterfaceNode)
             * tree.getMethodOwner(method);
             * Set<ProgramNode> others = new HashSet<>();
             * others.addAll(tree.getMethods());
             * others.remove(method);
             * for (ProgramNode pe : others)
             * {
             * MethodNode other = (MethodNode) pe;
             * if (other.getCalledMethods().contains(method))
             * callSet.add(other);
             * }
             * chm = callSet.size();
             */
        }

        return chm;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        // double CINT = taskMap.containsKey("CINT") ?
        // taskMap.get("CINT").join().getValue() : entity.getMetric("CINT");
    }
}
