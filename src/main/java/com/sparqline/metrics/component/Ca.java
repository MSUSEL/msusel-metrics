/**
 * 
 */
package com.sparqline.metrics.component;


public class Ca /* extends ComponentMetric */{

    // /**
    // *
    // */
    // private static final long /* serialVersionUID = -5771410484350826840L */;

    // /**
    // * @param name
    // * @param desc
    // * @param acronym
    // * @param scope
    // * @param graph
    // * @param entities
    // */
    // public Ca(String name, String desc, String acronym, MetricScope scope,
    // ProgramEntity entity, CodeGraph graph)
    // {
    // super(name, desc, acronym, scope, entity, graph);
    // }

    // /**
    // * @param graph
    // * @param entities
    // * @return
    // */
    // public static Ca getInstance(ProgramEntity entity, final CodeGraph graph)
    // {
    // return new Ca(
    // "Afferent Coupling",
    // "Measures the total number of external classes coupled to classes of a component due to incoming coupling. Each class counts only once. Zero, if the component does not contain any classes or if external classes do not use the component\'s classes.",
    // "Ca", MetricScope.ComponentLevel, entity, graph);
    // }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    // @Override
    // public double measure()
    // {
    // double ca = 0;

    // if (entity instanceof ComponentEntity)
    // {
    // Set<ClassOrInterfaceEntity> componentClasses = new
    // HashSet<>(((ComponentEntity) entity).getContents());
    // Set<ClassOrInterfaceEntity> systemClasses =
    // getSystemClassesExcludingComponentClasses(componentClasses);
    // Set<ClassOrInterfaceEntity> caClasses = new HashSet<>();

    // for (ClassOrInterfaceEntity comCls : componentClasses)
    // {
    // List<Connection> conns = new LinkedList<Connection>();
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // AssociationRelationshipType.DirectedAssociation));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Generalization));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Dependency));
    // conns.addAll(graph
    // .getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.InterfaceRealization));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Realization));
    // conns.addAll(graph.getEdgesContainingRelationType(comCls,
    // DirectedRelationshipType.Usage));

    // for (Connection conn : conns)
    // {
    // ProgramEntity pe = graph.getState().getSource(conn);
    // if (pe instanceof ClassOrInterfaceEntity)
    // {
    // ClassOrInterfaceEntity source = (ClassOrInterfaceEntity) pe;
    // if (systemClasses.contains(source))
    // {
    // caClasses.add(source);
    // }
    // }
    // }
    // }

    // ca = caClasses.size();
    // }

    // return ca;
    // }

    // /**
    // * @param componentClasses
    // * @return
    // */
    // private Set<ClassOrInterfaceEntity>
    // getSystemClassesExcludingComponentClasses(
    // Set<ClassOrInterfaceEntity> componentClasses)
    // {
    // Set<ClassOrInterfaceEntity> systemClasses = new HashSet<>();

    // for (ProgramEntity entity : graph.getClasses())
    // {
    // if (entity instanceof ClassOrInterfaceEntity)
    // systemClasses.add((ClassOrInterfaceEntity) entity);
    // }

    // for (ProgramEntity entity : graph.getInterfaces())
    // {
    // if (entity instanceof ClassOrInterfaceEntity)
    // systemClasses.add((ClassOrInterfaceEntity) entity);
    // }

    // try
    // {
    // systemClasses = SetOperations.difference(systemClasses,
    // componentClasses);
    // }
    // catch (SetOperationsException e)
    // {
    // systemClasses.clear();
    // }

    // return systemClasses;
    // }

}
