/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright (c) 2017 Isaac Griffith, SparQLine Analytics, LLC
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
package com.sparqline.metrics.aggregators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.node.FileNode;
import com.sparqline.codetree.node.ProjectNode;
import com.sparqline.metrics.Register;

/**
 * @author Isaac Griffith
 */
public class SystemMetricsAggregatorTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * Test method for
     * {@link com.sparqline.metrics.aggregators.SystemMetricsAggregator#aggregate(com.sparqline.codetree.CodeTree)}.
     */
    @Test
    public final void testAggregate()
    {
        Register.register();
        CodeTree tree = new CodeTree();
        ProjectNode pn = ProjectNode.builder("project")
                .file(
                        FileNode.builder("file1")
                                .metric("LOC", 100d)
                                .metric("NC", 2.0)
                                .metric("NOS", 20d)
                                .metric("NOF", 5.0)
                                .metric("NOM", 10.0)
                                .create())
                .file(
                        FileNode.builder("file2")
                                .metric("NOS", 20d)
                                .metric("NC", 2.0)
                                .metric("LOC", 100d)
                                .metric("NOF", 5.0)
                                .metric("NOM", 10.0)
                                .create())
                .create();

        tree.setProject(pn);

        assertTrue(tree.getProject().getName().equals(pn.getName()));
        assertEquals(2, tree.getProject().getFiles().size());

        SystemMetricsAggregator aggr = new SystemMetricsAggregator();
        aggr.aggregate(tree);

        assertEquals(200.0, pn.getMetric("LOC"), 0.001);
        assertEquals(4.0, pn.getMetric("NC"), 0.001);
        assertEquals(40.0, pn.getMetric("NOS"), 0.001);
        assertEquals(10.0, pn.getMetric("NOF"), 0.001);
        assertEquals(20.0, pn.getMetric("NOM"), 0.001);
    }

}
