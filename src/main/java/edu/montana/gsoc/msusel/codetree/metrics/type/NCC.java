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
 * Number of Comments per Class. Count of the number of individual comments
 * defined within the scope of a class, including comments for the class itself.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class NCC extends ClassMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static NCC getInstance()
    {
        return new NCC(
                "Number of Comments per Class",
                "Count of the number of individual comments defined within the scope of a class, including comments for the class itself.",
                "NCC");
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
    private NCC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        double numComments = 0;
        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        // if (cls.getDocumentation() != null)
        // {
        // final String classComment = ((ClassOrInterfaceNode)
        // entity).getDocumentation().getContent();
        // if ((classComment != null) && !classComment.isEmpty())
        // {
        // numComments++;
        // }
        // }
        // numComments += cls.getComments().size();
        //
        // for (final ProgramNode ie : tree.getInitializers(cls))
        // {
        // if (ie instanceof InitializerNode)
        // {
        // final InitializerNode init = (InitializerNode) ie;
        // if ((init.getDocumentation() != null) &&
        // (init.getDocumentation().getContent() != null)
        // && !init.getDocumentation().getContent().isEmpty())
        // {
        // numComments++;
        // }
        // numComments += init.getComments().size();
        //
        // for (final StatementNode se : init.getContainedStatements())
        // {
        // numComments += se.getComments().size();
        // }
        // }
        // }
        //
        // for (final ProgramNode fe : tree.getFields(entity))
        // {
        // if (fe instanceof FieldNode)
        // {
        // final FieldNode field = (FieldNode) fe;
        // if ((field.getDocumentation() != null) &&
        // (field.getDocumentation().getContent() != null)
        // && !(field.getDocumentation().getContent().isEmpty()))
        // {
        // numComments++;
        // }
        // numComments += field.getComments().size();
        // }
        // }
        //
        // for (final ProgramNode me : tree.getMethods(entity))
        // {
        // if (me instanceof MethodNode)
        // {
        // final MethodNode method = (MethodNode) me;
        // if ((method.getDocumentation() != null) &&
        // (method.getDocumentation().getContent() != null)
        // && !method.getDocumentation().getContent().isEmpty())
        // {
        // numComments++;
        // }
        // numComments += method.getComments().size();
        //
        // for (final StatementNode se : method.getContainedStatements())
        // {
        // numComments += se.getComments().size();
        // }
        // }
        // }
        // }

        return numComments;
    }
}
