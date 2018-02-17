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
package edu.montana.gsoc.msusel.codetree.metrics;

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.relations.RelationshipType;

/**
 * Interface which denotes that a realizing Metric is capable of excluding those
 * nodes participating in a given relationship type.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public interface RelationshipExcludable {

    /**
     * Excludes relationships of the given type from consideration when
     * computing the measure value.
     * 
     * @param type
     *            RelationshipType to filter out
     */
    void exclude(RelationshipType type);

    /**
     * Excludes the given relationship type when it occurs between the entity
     * the name is applied to and the entity provided in the exclusion.
     * 
     * @param type
     *            RelationshipType to filter out
     * @param entity
     *            Entity to filter out when the relationship type is met
     */
    void exclude(RelationshipType type, INode entity);

    /**
     * Excludes the given relationshp type between the provided two nodes
     * whenever either of the two nodes are actively being measured.
     * 
     * @param type
     *            RelationshipType to filter out
     * @param source
     *            Source side of the relationship
     * @param dest
     *            Dest side of the relationship
     */
    void exclude(RelationshipType type, INode source, INode dest);
}
