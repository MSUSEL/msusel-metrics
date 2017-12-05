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
package edu.montana.gsoc.msusel.codetree.metrics.namespace;

import java.util.HashSet;
import java.util.Set;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.NamespaceMetric;
import edu.montana.gsoc.msusel.codetree.metrics.utility.MetricTreeUtils;
import edu.montana.gsoc.msusel.codetree.node.TypeNode;

/**
 * Efferent Coupling. Measures the total number of external classes coupled to
 * classes of a package due to outgoing coupling (coupling to classes external
 * to the package). Each class counts only once. Zero if the package does not
 * contain any classes or if external classes are not used by the package\'s
 * classes. Ce = |Coupled(p)|. Where Coupled(p) = { c \\in class^Ce | c \\in
 * succ(CIP(p), coupling^Ce) and c \\in COP(p)}, set of classes coupled to p
 * over afferent coupling. COP(p) = {c \\in class^Ce | c \\not_in CIP(p)}, set
 * of classes outside p. CIP(p) = succ^*(p, contains^Ce), set of classes
 * inside/contained in P.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class Ce extends NamespaceMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static Ce getInstance()
    {
        return new Ce(
                "Efferent Coupling",
                "Measures the total number of external classes coupled to classes of a package due to outgoing coupling (coupling to classes external to the package). Each class counts only once. Zero if the package does not contain any classes or if external classes are not used by the package\'s classes. Ce = |Coupled(p)|. Where Coupled(p) = { c \\in class^Ce | c \\in succ(CIP(p), coupling^Ce) and c \\in COP(p)}, set of classes coupled to p over afferent coupling. COP(p) = {c \\in class^Ce | c \\not_in CIP(p)}, set of classes outside p. CIP(p) = succ^*(p, contains^Ce), set of classes inside/contained in P.",
                "Ce");
    }

    /**
     * Constructs a new instance of this name with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this name
     * @param desc
     *            Description of this name
     * @param acronym
     *            Acronym of this name
     */
    private Ce(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        final Set<TypeNode> packageClasses = MetricTreeUtils.getPackageClasses(entity, tree);
        final Set<TypeNode> systemClasses = MetricTreeUtils
                .getSystemClassesExcludingPackageClasses(entity, packageClasses, tree);
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
