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
package edu.montana.gsoc.msusel.codetree.metrics.file;

import edu.montana.gsoc.msusel.codetree.node.FileNode;
import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.metrics.FileMetric;

/**
 * Number of Classes. The number of classes defined in a File.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class NC extends FileMetric {

    /**
     * Factory method for this name
     * 
     * @return An instance of this name
     */
    public static NC getInstance()
    {
        return new NC("Number of Classes", "The number of classes defined in a File", "NC");
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
    public NC(String name, String desc, String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree graph)
    {
        double nc = 0;

        if (entity instanceof FileNode)
        {
            nc = ((FileNode) entity).getTypes().size();
        }

        return nc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] altNames()
    {
        return new String[] { "#Types", "file/CountDeclClass", "#Classes", "CountDeclClass" };
    }

}
