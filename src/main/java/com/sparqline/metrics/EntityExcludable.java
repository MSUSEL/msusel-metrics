/**
 * 
 */
package com.sparqline.metrics;

import com.sparqline.quamoco.codetree.CodeNode;

/**
 * @author Isaac Griffith
 */
public interface EntityExcludable {

    /**
     * @param entities
     */
    void exclude(CodeNode... entities);
}
