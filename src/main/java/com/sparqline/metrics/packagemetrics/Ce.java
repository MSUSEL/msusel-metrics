package com.sparqline.metrics.packagemetrics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.Connection;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.PackageNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.AssociationRelationshipType;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.graph.utils.SetOperations;
import com.sparqline.graph.utils.SetOperationsException;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;

public class Ce extends PackageMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2326185934615699513L;

    public static Ce getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new Ce(
                "Efferent Coupling",
                "Measures the total number of external classes coupled to classes of a package due to outgoing coupling (coupling to classes external to the package). Each class counts only once. Zero if the package does not contain any classes or if external classes are not used by the package\'s classes. Ce = |Coupled(p)|. Where Coupled(p) = { c \\in class^Ce | c \\in succ(CIP(p), coupling^Ce) and c \\in COP(p)}, set of classes coupled to p over afferent coupling. COP(p) = {c \\in class^Ce | c \\not_in CIP(p)}, set of classes outside p. CIP(p) = succ^*(p, contains^Ce), set of classes inside/contained in P.",
                "Ce", MetricScope.PackageLevel, entity, graph);
    }

    private Ce(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @return
     */
    private Set<ClassOrInterfaceNode> getPackageClasses()
    {
        final Set<ClassOrInterfaceNode> componentClasses = new HashSet<>();

        if (entity instanceof PackageNode)
        {
            for (final ProgramNode cls : tree.getClasses((PackageNode) entity))
            {
                if (cls instanceof ClassOrInterfaceNode)
                {
                    componentClasses.add((ClassOrInterfaceNode) cls);
                }
            }
        }
        return componentClasses;
    }

    /**
     * @param componentClasses
     * @return
     */
    private Set<ClassOrInterfaceNode> getSystemClassesExcludingPackageClasses(
            final Set<ClassOrInterfaceNode> componentClasses)
    {
        Set<ClassOrInterfaceNode> systemClasses = new HashSet<>();

        for (final ProgramNode entity : tree.getClasses())
        {
            if (entity instanceof ClassOrInterfaceNode)
            {
                systemClasses.add((ClassOrInterfaceNode) entity);
            }
        }

        for (final ProgramNode entity : tree.getInterfaces())
        {
            if (entity instanceof ClassOrInterfaceNode)
            {
                systemClasses.add((ClassOrInterfaceNode) entity);
            }
        }

        try
        {
            systemClasses = SetOperations.difference(systemClasses, componentClasses);
        }
        catch (final SetOperationsException e)
        {
            systemClasses.clear();
        }

        return systemClasses;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final Set<ClassOrInterfaceNode> packageClasses = getPackageClasses();
        final Set<ClassOrInterfaceNode> systemClasses = getSystemClassesExcludingPackageClasses(packageClasses);
        final Set<ClassOrInterfaceNode> ceClasses = new HashSet<>();

        for (final ClassOrInterfaceNode comCls : packageClasses)
        {
            final List<Connection> conns = new LinkedList<Connection>();
            conns.addAll(tree.getEdgesContainingRelationType(comCls, AssociationRelationshipType.DirectedAssociation));
            conns.addAll(tree.getEdgesContainingRelationType(comCls, DirectedRelationshipType.Generalization));
            conns.addAll(tree.getEdgesContainingRelationType(comCls, DirectedRelationshipType.Dependency));
            conns.addAll(tree.getEdgesContainingRelationType(comCls, DirectedRelationshipType.InterfaceRealization));
            conns.addAll(tree.getEdgesContainingRelationType(comCls, DirectedRelationshipType.Realization));
            conns.addAll(tree.getEdgesContainingRelationType(comCls, DirectedRelationshipType.Usage));

            for (final Connection conn : conns)
            {
                final ProgramNode pe = tree.getState().getDest(conn);
                if (pe instanceof ClassOrInterfaceNode)
                {
                    final ClassOrInterfaceNode dest = (ClassOrInterfaceNode) pe;
                    if (systemClasses.contains(dest))
                    {
                        ceClasses.add(dest);
                    }
                }
            }
        }

        return ceClasses.size();
    }
}
