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
package edu.montana.gsoc.msusel.metrics.aggregators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.metrics.Register;
import edu.montana.gsoc.msusel.metrics.aggregators.SystemMetricsAggregator;
import edu.montana.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.node.ProjectNode;

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
     * {@link edu.montana.gsoc.msusel.metrics.aggregators.SystemMetricsAggregator#aggregate(edu.montana.gsoc.msusel.CodeTree)}.
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
