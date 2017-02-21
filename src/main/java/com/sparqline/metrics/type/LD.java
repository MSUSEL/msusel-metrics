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
package com.sparqline.metrics.type;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.metrics.ClassMetric;

/**
 * Locality of Data. Relates the amount of data being local to the class to the
 * total amount of data used by the class. This relates to the quality of
 * abstraction embodied by the class and allows conclusions on the reuse
 * potential of the class and testability.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class LD extends ClassMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static LD getInstance()
    {
        return new LD(
                "Locality of Data",
                "Relates the amount of data being local to the class to the total amount of data used by the class. This relates to the quality of abstraction embodied by the class and allows conclusions on the reuse potential of the class and testability.",
                "LD");
    }

    /**
     * Constructs a new instance of this metric with the given name, description
     * and acronym.
     * 
     * @param name
     *            Name of this metric
     * @param desc
     *            Description of this metric
     * @param acronym
     *            Acronym of this metric
     */
    private LD(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double ld = 0;
        // final Set<ProgramNode> setA = new HashSet<>();
        // final Set<ProgramNode> setB = new HashSet<>();
        // Set<ProgramNode> localAccess = new HashSet<>();
        // final Set<ProgramNode> directAccess = new HashSet<>();
        // final Set<ProgramNode> indirectAccess = new HashSet<>();
        // Set<ProgramNode> totalAccess = new HashSet<>();
        //
        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final List<MethodNode> mstar = getNonGetterSetterMethods();
        //
        // for (final MethodNode method : mstar)
        // {
        // for (final Connection conn :
        // tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.FieldUse))
        // {
        // final ProgramNode other = tree.getState().getOpposite(method, conn);
        // if (other instanceof FieldNode)
        // {
        // final ProgramNode otherOwn = tree.getFieldOwner((FieldNode) other);
        // if (otherOwn.equals(entity))
        // {
        // setA.add(other);
        // }
        //
        // directAccess.add(other);
        // }
        // }
        //
        // for (final Connection conn :
        // tree.getEdgesContainingRelationType(method,
        // DirectedRelationshipType.MethodCall))
        // {
        // final ProgramNode other = tree.getState().getOpposite(method, conn);
        // if (other instanceof MethodNode)
        // {
        // final MethodNode otherMethod = (MethodNode) other;
        // if (otherMethod.isAccessorMethod(tree) ||
        // otherMethod.isMutatorMethod(tree))
        // {
        // for (final Connection otherConn :
        // tree.getEdgesContainingRelationType(otherMethod,
        // DirectedRelationshipType.FieldUse))
        // {
        // final ProgramNode otherField =
        // tree.getState().getOpposite(otherMethod, otherConn);
        // if (otherField instanceof FieldNode)
        // {
        // final ProgramNode otherOwn = tree.getFieldOwner((FieldNode)
        // otherField);
        // if (otherOwn.equals(entity))
        // {
        // setB.add(otherField);
        // }
        //
        // indirectAccess.add(otherField);
        // }
        // }
        //
        // }
        // }
        // }
        // }
        //
        // try
        // {
        // localAccess = SetOperations.union(setA, setB);
        // totalAccess = SetOperations.union(directAccess, indirectAccess);
        //
        // ld = (double) localAccess.size() / (double) totalAccess.size();
        // }
        // catch (final SetOperationsException e)
        // {
        // }
        // }

        return ld;
    }
}
