/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.metrics.component;

/**
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class Ce /* extends ComponentMetric */ {

    // /**
    // *
    // */
    // private static final long /* serialVersionUID = 3567737741649126324L */;

    // /**
    // * @param name
    // * @param desc
    // * @param acronym
    // * @param scope
    // * @param graph
    // * @param entities
    // */
    // public Ce(String name, String desc, String acronym, MetricScope scope,
    // ProgramEntity entity, CodeGraph graph)
    // {
    // super(name, desc, acronym, scope, entity, graph);
    // }

    // /**
    // * @param graph
    // * @param entities
    // * @return
    // */
    // public static Ce getInstance(final ProgramEntity entity, final CodeGraph
    // graph)
    // {
    // return new Ce(
    // "Efferent Coupling",
    // "Measures the total number of external classes coupled to classes of a
    // component due to outgoing coupling (coupling to classes external to the
    // component). Each class counts only once. Zero, if the component does not
    // contain classes or if external classes are not used by the component's
    // classes. Ce = |Coupled(p)|. Where Coupled(p) = { c \\in succ(CIP(p),
    // coupling^Ce) and c \\in COP(p)}, set of classes coupled to p over
    // afferent coupling. COP(p) = {c \\in class^Ce | c \\in class^Ce | c
    // \\not_in CIP(p)}, set of classes outside p. CIP(p) = succ^*(p,
    // contains^Ce), set of classes inside/contained in P.",
    // "Ce", MetricScope.PackageLevel, entity, graph);
    // }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    // @Override
    // public double measure()
    // {
    // double ce = 0;

    // if (entity instanceof ComponentEntity)
    // {
    // Set<ClassOrInterfaceEntity> componentClasses = new
    // HashSet<>(((ComponentEntity) entity).getContents());
    // Set<ClassOrInterfaceEntity> systemClasses =
    // getSystemClassesExcludingComponentClasses(componentClasses);
    // Set<ClassOrInterfaceEntity> ceClasses = new HashSet<>();

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
    // ProgramEntity pe = graph.getState().getDest(conn);
    // if (pe instanceof ClassOrInterfaceEntity)
    // {
    // ClassOrInterfaceEntity dest = (ClassOrInterfaceEntity) pe;
    // if (systemClasses.contains(dest))
    // {
    // ceClasses.add(dest);
    // }
    // }
    // }
    // }

    // ce = ceClasses.size();
    // }

    // return ce;
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
