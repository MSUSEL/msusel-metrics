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

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.metrics.ClassMetric;

/**
 * Lack of Documentation. How many comments are lacking in a class, considering
 * one class comment and a comment per method as optimum. Structure and content
 * of the comments are ignored.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class LOD extends ClassMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static LOD getInstance()
    {
        return new LOD(
                "Lack of Documentation",
                "How many comments are lacking in a class, considering one class comment and a comment per method as optimum. Structure and content of the comments are ignored.",
                "LOD");
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
    public LOD(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double lod = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // double commentCount = 0;
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        //
        // if ((cls.getDocumentation() != null) &&
        // (cls.getDocumentation().getContent() != null)
        // && !cls.getDocumentation().getContent().isEmpty())
        // {
        // commentCount++;
        // }
        //
        // commentCount += cls.getComments().size();
        //
        // for (final ProgramNode pe : tree.getMethods(entity))
        // {
        // if (pe instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) pe;
        // commentCount += method.getComments().size();
        //
        // if ((method.getDocumentation() != null) &&
        // (method.getDocumentation().getContent() != null)
        // && !method.getDocumentation().getContent().isEmpty())
        // {
        // commentCount++;
        // }
        // }
        // }
        //
        // final double optComments = 1 + tree.getMethods().size();
        //
        // if (commentCount < optComments)
        // {
        // lod = optComments - commentCount;
        // }
        // else
        // {
        // lod = 0;
        // }
        // }

        return lod;
    }

}
