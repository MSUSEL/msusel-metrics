package com.sparqline.metrics.packagemetrics;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

public class Ce extends PackageMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2326185934615699513L;

    public static Ce getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new Ce("Efferent Coupling",
                "Measures the total number of external classes coupled to classes of a package due to outgoing coupling (coupling to classes external to the package). Each class counts only once. Zero if the package does not contain any classes or if external classes are not used by the package\'s classes. Ce = |Coupled(p)|. Where Coupled(p) = { c \\in class^Ce | c \\in succ(CIP(p), coupling^Ce) and c \\in COP(p)}, set of classes coupled to p over afferent coupling. COP(p) = {c \\in class^Ce | c \\not_in CIP(p)}, set of classes outside p. CIP(p) = succ^*(p, contains^Ce), set of classes inside/contained in P.",
                "Ce", MetricScope.PackageLevel, entity, graph);
    }

    private Ce(final String name, final String desc, final String acronym, final MetricScope scope,
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
         * for (final CodeNode cls : tree.getClasses((PackageNode) entity))
         * {
         * if (cls instanceof TypeNode)
         * {
         * componentClasses.add((TypeNode) cls);
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
        final Set<TypeNode> ceClasses = new HashSet<>();

        /*
         * for (final TypeNode comCls : packageClasses)
         * {
         * final List<Connection> conns = new LinkedList<Connection>();
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
         * final CodeNode pe = tree.getState().getDest(conn);
         * if (pe instanceof TypeNode)
         * {
         * final TypeNode dest = (TypeNode) pe;
         * if (systemClasses.contains(dest))
         * {
         * ceClasses.add(dest);
         * }
         * }
         * }
         * }
         */

        return ceClasses.size();
    }
}
