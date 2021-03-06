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
package edu.montana.gsoc.msusel.metrics.utility;

/**
 * A simple key-value pair data type.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 * @param <K>
 *            Key type
 * @param <V>
 *            Value type
 */
public class Pair<K, V> {

    /**
     * The key of this pair
     */
    private K key;
    /**
     * The value of this pair
     */
    private V value;

    /**
     * Constructs a new Pair with the given key and value
     * 
     * @param x
     *            Key
     * @param y
     *            Value
     */
    public Pair(K x, V y)
    {
        this.key = x;
        this.value = y;
    }

    /**
     * @return The key of this pair
     */
    public K key()
    {
        return key;
    }

    /**
     * @return The value of this pair
     */
    public V value()
    {
        return value;
    }
}
