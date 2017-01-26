package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NMCl - Average Number of Methods per Class. Total number of methods defined
 * in the system divided by the number of classes in the system.
 * 
 * @author Isaac
 */
public class NMCl extends SystemMetric {

    /**
     * 
     */
    private double nc;

    /**
     * 
     */
    private static final long serialVersionUID = -4680031373396119477L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NMCl getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NMCl("Average Number of Methods per Class",
                "Total number of methods defined in the system divided by the number of classes in the system.", "NMCl",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NMCl(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double nmcl = 0;

        /*
         * if (entity instanceof SystemNode)
         * {
         * final SystemNode sys = (SystemNode) entity;
         * final Set<ProgramNode> systemMethods = new HashSet<>();
         * for (final ProgramNode pe : tree.getPackages(sys))
         * {
         * if (pe instanceof PackageNode)
         * {
         * final PackageNode pkg = (PackageNode) pe;
         * for (final ProgramNode cls : tree.getClasses(pkg))
         * {
         * systemMethods.addAll(tree.getMethods(cls));
         * }
         * for (final ProgramNode enm : tree.getEnums(pkg))
         * {
         * systemMethods.addAll(tree.getMethods(enm));
         * }
         * for (final ProgramNode inter : tree.getInterfaces(pkg))
         * {
         * systemMethods.addAll(tree.getMethods(inter));
         * }
         * }
         * }
         * final double nom = systemMethods.size();
         * nmcl = nom / nc;
         * }
         */

        return nmcl;
    }

    /**
     * 
     */
    @Override
    public void setPrerequisites()
    {
        // nc = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue()
        // : entity.getMetric("NC");
    }
}
