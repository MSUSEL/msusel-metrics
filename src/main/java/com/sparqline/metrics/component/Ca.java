/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sparqline.metrics.component;

/**
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class Ca /* extends ComponentMetric */ {

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
    // "Measures the total number of external classes coupled to classes of a
    // component due to incoming coupling. Each class counts only once. Zero, if
    // the component does not contain any classes or if external classes do not
    // use the component\'s classes.",
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
