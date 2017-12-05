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
package edu.montana.gsoc.msusel.codetree.metrics.component;


/**
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class I /* extends ComponentMetric */{

    // /**
    // *
    // */
    // private static final long /* serialVersionUID = -147707591161337270L */;

    // /**
    // * @param name
    // * @param desc
    // * @param acronym
    // * @param scope
    // * @param graph
    // * @param entities
    // */
    // public I(String name, String desc, String acronym, MetricScope scope,
    // ProgramEntity entity, CodeGraph graph)
    // {
    // super(name, desc, acronym, scope, entity, graph);
    // }

    // /**
    // * @param entity
    // * @param graph
    // * @return
    // */
    // public static I getInstance(final ProgramEntity entity, final CodeGraph
    // graph)
    // {
    // return new I(
    // "Instability",
    // "Measures the ratio between the outgoing and the total number of in- and out-going couplings from classes inside the package from/to classes outside the package. Each class counts only once. Zero if the package does not contain classes or if external classes are not used by the package's classes. I(p) = Ce / (Ca + Ce)",
    // "I", MetricScope.ComponentLevel, entity, graph);
    // }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    // @Override
    // public double measure()
    // {
    // Ca caMetric = Ca.getInstance(entity, graph);
    // Ce ceMetric = Ce.getInstance(entity, graph);

    // double ca = caMetric.measure();
    // double ce = ceMetric.measure();

    // return ce / (ca + ce);
    // }

}
