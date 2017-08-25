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
package edu.montana.gsoc.msusel.metrics.annotations;

/**
 * Provides an enumeration of different applicable scopes for use with the
 * {@link Scope} annotation.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public enum MetricScope {

    /**
     * Selects all scopes greater than the scope set for the metric, used in the
     * {@link Aggregatable} annotation.
     */
    AllGreaterThanCurrent,
    /**
     * Scope applicable to FieldNodes
     */
    Field,
    /**
     * Scope applicable to MethodNodes
     */
    Method,
    /**
     * Scope applicable to TypeNodes
     */
    Type,
    /**
     * Scope applicable to FileNodes
     */
    File,
    /**
     * Scope applicable to NamespaceNodes
     */
    Namespace,
    /**
     * Scope applicable to ModuleNodes
     */
    Module,
    /**
     * Scope applicable to ProjectNodes
     */
    Project,
    /**
     * Scope applicable to System as a whole
     */
    System,
}
