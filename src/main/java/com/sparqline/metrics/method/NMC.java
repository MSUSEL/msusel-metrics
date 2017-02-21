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
package com.sparqline.metrics.method;

import java.util.HashMap;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.metrics.MethodMetric;

/**
 * Number of Method Calls. Count of the number of methods called from the target
 * method.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class NMC extends MethodMetric {

    /**
     * Factory method for this metric
     * 
     * @return An instance of this metric
     */
    public static NMC getInstance()
    {
        return new NMC(
                "Number of Method Calls", "Count of the number of methods called from the target method.", "NMC");
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
    private NMC(final String name, final String desc, final String acronym)
    {
        super(name, desc, acronym);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure(final INode entity, final CodeTree tree)
    {
        // TODO Fix this
        // final List<Connection> calls = graph.getConnectionsByType(entity,
        // DirectedRelationshipType.MethodCall);
        MethodNode me = (MethodNode) entity;
        HashMap<MethodNode, Integer> map = new HashMap<>();
        /*
         * for (MethodNode ex : me.getMethodCalls())
         * {
         * if (map.containsKey(ex))
         * {
         * int value = map.get(ex);
         * map.put(ex, ++value);
         * }
         * else
         * {
         * map.put(ex, 1);
         * }
         * }
         */

        int total = 0;
        for (MethodNode method : map.keySet())
        {
            total += map.get(method);
        }

        return total;
    }
}
