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
package edu.montana.gsoc.msusel.codetree.metrics.annotations;

/**
 * Enumeration of the different aggregation operations available to metrics.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public enum AggregationType {

    /**
     * All forms of aggregation are applicable to a given name
     */
    All,
    /**
     * No form of aggregation is applicable to a given name
     */
    None,
    /**
     * Basic summation
     */
    Summation,
    /**
     * Max value
     */
    Max,
    /**
     * Min value
     */
    Min,
    /**
     * Mean value
     */
    Mean,
    /**
     * Median value
     */
    Median,
    /**
     * Range dispersion value
     */
    Range,
    /**
     * Standard Deviation
     */
    StandardDev
}
