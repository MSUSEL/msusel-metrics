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
 * Lines of Code
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class LOC extends ClassMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static LOC getInstance()
    {
        return new LOC("", "", "LOC");
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
    private LOC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * @param pe
     * @return
     */
    // private int calculateLOC(final CodeNode pe)
    // {
    // return 1 + getAllStatementsButEmpty(pe);
    // }

    /**
     * @param pe
     * @return
     */
    // private int getAllStatementsButEmpty(final CodeNode pe)
    // {
    // final List<StatementNode> stmts = new
    // LinkedList<>(pe.getContainedStatements());
    // final Iterator<StatementNode> iter = stmts.iterator();
    // while (iter.hasNext())
    // {
    // if (iter.next() instanceof EmptyStatement)
    // {
    // iter.remove();
    // }
    // }
    //
    // return stmts.size();
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        int loc = 0;

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        // loc++; // for class definition
        // for (final String imp : cls.getImports())
        // {
        // loc++; // for each import
        // }
        //
        // if ((cls.getPackageName() != null) ||
        // !cls.getPackageName().isEmpty())
        // {
        // loc++; // for package declaration
        // }
        //
        // for (final ProgramNode pe : tree.getMethods(cls))
        // {
        // loc++; // for method declaration
        //
        // loc += pe.getMetric("LOC");
        // }
        //
        // loc += tree.getFields(cls).size(); // One for each field defined
        //
        // for (final ProgramNode pe : tree.getInitializers(cls))
        // {
        // loc++;
        //
        // loc += calculateLOC((CodeNode) pe);
        // }
        // }

        return loc;
    }
}
