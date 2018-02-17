/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;
import edu.montana.gsoc.msusel.codetree.metrics.utility.Pair;
import edu.montana.gsoc.msusel.codetree.node.CodeNode;

/**
 * Lack of Cohesion in Object Methods. Indicates the level of cohesion between
 * the methods. Count of the number of method pairs whose similarity is 0, minus
 * the count of method pairs whose similarity is not zero.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class LCOM extends ClassMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static LCOM getInstance()
    {
        return new LCOM(
                "Lack of Cohesion in Object Methods.",
                "Indicates the level of cohesion between the methods. Count of the number of method pairs whose similarity is 0, minus the count of method pairs whose similarity is not zero.",
                "LCOM");
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
    private LCOM(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        final Map<CodeNode, Set<CodeNode>> fieldUses = new HashMap<>();
        final Set<Pair<CodeNode, CodeNode>> pairsP = new HashSet<>();
        final Set<Pair<CodeNode, CodeNode>> pairsQ = new HashSet<>();

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        //
        // final List<CodeNode> fields = tree.getFields(cls);
        // final List<CodeNode> methods = tree.getMethods(cls);
        //
        // for (final CodeNode method : methods)
        // {
        // final Set<CodeNode> uses = new HashSet<>();
        // for (final CodeNode field : fields)
        // {
        // if (!tree.getEdges(method, field,
        // DirectedRelationshipType.FieldUse).isEmpty())
        // {
        // uses.add(field);
        // }
        // }
        //
        // fieldUses.put(method, uses);
        // }
        //
        // for (int i = 0; i < methods.size(); i++)
        // {
        // for (int j = i + 1; j < methods.size(); j++)
        // {
        // final CodeNode methodI = methods.get(i);
        // final CodeNode methodJ = methods.get(j);
        //
        // final Set<CodeNode> setI = fieldUses.get(methodI);
        // final Set<CodeNode> setJ = fieldUses.get(methodJ);
        //
        // try
        // {
        // if (SetOperations.intersection(setI, setJ).isEmpty())
        // {
        // pairsP.add(new Pair<CodeNode, CodeNode>(methodI, methodJ));
        // }
        // else
        // {
        // pairsQ.add(new Pair<CodeNode, CodeNode>(methodI, methodJ));
        // }
        // }
        // catch (final SetOperationsException e)
        // {
        // }
        // }
        // }
        // }

        return (pairsP.size() > pairsQ.size()) ? pairsP.size() - pairsQ.size() : 0;
    }
}
