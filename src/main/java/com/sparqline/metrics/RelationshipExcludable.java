/**
 * 
 */
package com.sparqline.metrics;

import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.RelationshipType;

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
    void exclude(RelationshipType type, CodeNode entity);

    /**
     * @param type
     * @param source
     * @param dest
     */
    void exclude(RelationshipType type, CodeNode source, CodeNode dest);
}
