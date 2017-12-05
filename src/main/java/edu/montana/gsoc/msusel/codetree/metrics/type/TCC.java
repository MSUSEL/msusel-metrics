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
package edu.montana.gsoc.msusel.codetree.metrics.type;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;

/**
 * Tight Class Coupling. Measures the ratio between the actual number of visible
 * directly connected methods in a class, NDC(c), divided by the number of
 * maximal possible number of connections between the visible methods of a
 * class, NP(c). Two visible methods are directly connected, if they are
 * accessing the same instance variables of the class. TCC = NDC / NP
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class TCC extends ClassMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static TCC getInstance()
    {
        return new TCC(
                "Tight Class Cohesion",
                "Measures the ratio betwen the actual number of visible directly connected methods in a class, NDC(c), divided by the number of maximal possible number of connections between the visible methods of a class, NP(c). Two visible methods are directly connected, if they are accessing the same instance variables of the class. TCC = NDC / NP",
                "TCC");
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
    private TCC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double retVal = 0;

        // if (entity instanceof TypeNode)
        // {
        // TypeNode tn = (TypeNode) entity;
        // final List<MethodNode> methods = Lists.newLinkedList();
        // final Set<FieldNode> fields = tn.getFields();
        // final Map<MethodNode, Set<FieldNode>> fieldUses = Maps.newHashMap();
        // final Set<Pair<MethodNode, MethodNode>> ndc = Sets.newHashSet();
        //
        // for (final MethodNode method : tn.getMethods())
        // {
        // if (method.getAccessibility().equals(Accessibility.Public))
        // {
        // methods.add(method);
        // }
        // }
        //
        // for (final MethodNode method : methods)
        // {
        // final Set<FieldNode> fieldsUsed = Sets.newHashSet();
        //
        // for (final FieldNode field : fields)
        // {
        // if (tree.isEdge(method, field, DirectedRelationshipType.FieldUse))
        // {
        // fieldsUsed.add(field);
        // }
        // }
        //
        // fieldUses.put(method, fieldsUsed);
        // }
        //
        // for (int i = 0; i < methods.size(); i++)
        // {
        // for (int j = 0; j < methods.size(); j++)
        // {
        // final MethodNode methodI = methods.get(i);
        // final MethodNode methodJ = methods.get(j);
        //
        // final Set<FieldNode> setI = fieldUses.get(methodI);
        // final Set<FieldNode> setJ = fieldUses.get(methodJ);
        //
        // try
        // {
        // if (!SetOperations.intersection(setI, setJ).isEmpty())
        // {
        // ndc.add(new Pair<MethodNode, MethodNode>(methodI, methodJ));
        // }
        // }
        // catch (final SetOperationsException e)
        // {
        // }
        // }
        // }
        //
        // final double np = (methods.size() * (methods.size() - 1)) / 2;
        //
        // retVal = ndc.size() / np;
        // }

        return retVal;
    }
}
