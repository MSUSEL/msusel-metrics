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

/**
 * Average Number of Methods per Class. Total number of methods defined
 * in the system divided by the number of classes in the system.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class NMCl extends ProjectMetric {

    /**
     * number of classes in the system
     */
    private double nc;

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static NMCl getInstance()
    {
        return new NMCl(
                "Average Number of Methods per Class",
                "Total number of methods defined in the system divided by the number of classes in the system.",
                "NMCl");
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
    private NMCl(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double nmcl = 0;

        /*
         * if (entity instanceof SystemNode)
         * {
         * final SystemNode sys = (SystemNode) entity;
         * final Set<ProgramNode> systemMethods = new HashSet<>();
         * for (final ProgramNode pe : tree.getPackages(sys))
         * {
         * if (pe instanceof PackageNode)
         * {
         * final PackageNode pkg = (PackageNode) pe;
         * for (final ProgramNode cls : tree.getClasses(pkg))
         * {
         * systemMethods.addAll(tree.getMethods(cls));
         * }
         * for (final ProgramNode enm : tree.getEnums(pkg))
         * {
         * systemMethods.addAll(tree.getMethods(enm));
         * }
         * for (final ProgramNode inter : tree.getInterfaces(pkg))
         * {
         * systemMethods.addAll(tree.getMethods(inter));
         * }
         * }
         * }
         * final double nom = systemMethods.size();
         * nmcl = nom / nc;
         * }
         */

        return nmcl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // nc = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue()
        // : entity.getMetric("NC");
    }
}
