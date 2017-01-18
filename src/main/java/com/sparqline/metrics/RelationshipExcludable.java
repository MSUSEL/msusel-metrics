/**
 * 
 */
package com.sparqline.metrics;

import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.relations.RelationshipType;

/**
 * @author Isaac Griffith
 */
public interface RelationshipExcludable {

    /**
     * @param type
     */
    void exclude(RelationshipType type);

    /**
     * @param type
     * @param entity
     */
    void exclude(RelationshipType type, ProgramNode entity);

    /**
     * @param type
     * @param source
     * @param dest
     */
    void exclude(RelationshipType type, ProgramNode source, ProgramNode dest);
}
