/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NDC - Number of Descendant Classes. This metric measures the number of
 * classes that may potentially be influenced by the class because of
 * inheritance relations. It addresses a problem wit the CK NOC metric. A class
 * influences all its subclasses and not just the immediate children.
 * 
 * @author Isaac Griffith
 */
public class NDC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5162046695368104193L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NDC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NDC(
                "Number of Descendant Classes",
                "This metric measures the number of classes that may potentially be influenced by the class because of inheritance relations. It addresses a problem wit the CK NOC metric. A class influences all its subclasses and not just the immediate children.",
                "NDC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NDC(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        return tree.getAllSubClasses((ClassOrInterfaceNode) entity).size();
    }
}
