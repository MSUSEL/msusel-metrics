package com.sparqline.metrics.packagemetrics;

import java.sql.Connection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

public class Ca extends PackageMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5373260046404144815L;

    public static Ca getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new Ca("Afferent Coupling",
                "Measures the total number of external classes coupled to classes of a package due to incoming couping. Each class counts only once. Zero, if the package does not contain any classes or if external classes do not use the package\'s classes",
                "Ca", MetricScope.PackageLevel, entity, graph);
    }

    private Ca(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @return
     */
    private Set<TypeNode> getPackageClasses()
    {
        final Set<TypeNode> componentClasses = new HashSet<>();

        /*
         * if (entity instanceof PackageNode)
         * {
         * for (final ProgramNode cls : tree.getClasses((PackageNode) entity))
         * {
         * if (cls instanceof ClassOrInterfaceNode)
         * {
         * componentClasses.add((ClassOrInterfaceNode) cls);
         * }
         * }
         * }
         */
        return componentClasses;
    }

    /**
     * @param componentClasses
     * @return
     */
    private Set<TypeNode> getSystemClassesExcludingPackageClasses(final Set<TypeNode> componentClasses)
    {
        Set<TypeNode> systemClasses = new HashSet<>();

        /*
         * for (final CodeNode entity : tree.getClasses())
         * {
         * if (entity instanceof TypeNode)
         * {
         * systemClasses.add((TypeNode) entity);
         * }
         * }
         * for (final CodeNode entity : tree.getInterfaces())
         * {
         * if (entity instanceof TypeNode)
         * {
         * systemClasses.add((TypeNode) entity);
         * }
         * }
         * try
         * {
         * systemClasses = SetOperations.difference(systemClasses,
         * componentClasses);
         * }
         * catch (final SetOperationsException e)
         * {
         * systemClasses.clear();
         * }
         */

        return systemClasses;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final Set<TypeNode> packageClasses = getPackageClasses();
        final Set<TypeNode> systemClasses = getSystemClassesExcludingPackageClasses(packageClasses);
        final Set<TypeNode> caClasses = new HashSet<>();

        for (final TypeNode comCls : packageClasses)
        {
            final List<Connection> conns = new LinkedList<Connection>();
            /*
             * conns.addAll(tree.getEdgesContainingRelationType(comCls,
             * AssociationRelationshipType.DirectedAssociation));
             * conns.addAll(tree.getEdgesContainingRelationType(comCls,
             * DirectedRelationshipType.Generalization));
             * conns.addAll(tree.getEdgesContainingRelationType(comCls,
             * DirectedRelationshipType.Dependency));
             * conns.addAll(tree.getEdgesContainingRelationType(comCls,
             * DirectedRelationshipType.InterfaceRealization));
             * conns.addAll(tree.getEdgesContainingRelationType(comCls,
             * DirectedRelationshipType.Realization));
             * conns.addAll(tree.getEdgesContainingRelationType(comCls,
             * DirectedRelationshipType.Usage));
             * for (final Connection conn : conns)
             * {
             * final ProgramNode pe = tree.getState().getSource(conn);
             * if (pe instanceof ClassOrInterfaceNode)
             * {
             * final ClassOrInterfaceNode source = (ClassOrInterfaceNode) pe;
             * if (systemClasses.contains(source))
             * {
             * caClasses.add(source);
             * }
             * }
             * }
             */
        }

        return caClasses.size();
    }
}
