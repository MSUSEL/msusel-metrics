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
package edu.montana.gsoc.msusel.codetree.metrics.project;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.ProjectMetric;
import edu.montana.gsoc.msusel.codetree.node.ProjectNode;

/**
 * Total Direct Class Couplings defined within the system.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class DCC extends ProjectMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static DCC getInstance()
    {
        return new DCC("Direct Class Couplings", "", "DCC");
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
    private DCC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double value = 0.0d;

        if (entity instanceof ProjectNode)
        {
            /*
             * final ProjectNode sys = (ProjectNode) entity;
             * final Set<CodeNode> systemClasses = new HashSet<>();
             * systemClasses.addAll(sys.getClasses());
             * double totalCouplings = 0.0d;
             * for (CodeNode ce : systemClasses)
             * {
             * Set<String> typeNames = new HashSet<>();
             * if (ce instanceof TypeNode)
             * {
             * TypeNode cie = (TypeNode) ce;
             * Set<MethodNode> methods = cie.getMethods();
             * Set<FieldNode> fields = cie.getFields();
             * for (MethodNode m : methods)
             * {
             * List<Parameter> param = m.getParameters();
             * for (Parameter p : param)
             * {
             * if (!(p.getType() instanceof PrimitiveTypeNode))
             * {
             * if (p.getType() != null)
             * typeNames.add(p.getType().getIdentifier());
             * }
             * }
             * }
             * for (FieldNode f : fields)
             * {
             * if (!(f.getType() instanceof PrimitiveTypeNode))
             * {
             * typeNames.add(f.getType().getIdentifier());
             * }
             * }
             * }
             * totalCouplings += typeNames.size();
             * }
             * value = totalCouplings;
             */
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }

}
