/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.FieldNode;

/**
 * AHF - Attribute Hiding Factor. Ratio of hidden attributes to total
 * attributes. A measure of encapsulation.
 * 
 * @author Isaac
 */
public class AHF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 4645159835573291704L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static AHF getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new AHF("Attribute Hiding Factor",
                "Ratio of hidden attributes to total attributes. A measure of encapsulation.", "AHF",
                MetricScope.SystemLevel, entity, graph);
    }

    /**
     * 
     */
    private double numClasses = 0.0;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private AHF(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double measure()
    {
        // final List<CodeNode> classes = tree.getClasses();

        double totalFields = 1.0;
        double totalVisibility = 0.0;

        /*
         * for (final CodeNode cls : classes)
         * {
         * final List<CodeNode> fields = tree.getFields(cls);
         * totalFields += fields.size();
         * double visible = 0.0;
         * for (final CodeNode field : fields)
         * {
         * visible += visibility((FieldNode) field);
         * }
         * totalVisibility += visible;
         * }
         */

        return totalVisibility / totalFields;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrerequisites()
    {
        // numClasses = taskMap.containsKey("NC") ?
        // taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }

    /**
     * @param attribute
     * @return
     */
    private double visibility(final FieldNode attribute)
    {
        /*
         * if (attribute.getAccessibility().equals(Accessibility.Public))
         * {
         * return 1;
         * }
         * else if (attribute.getAccessibility().equals(Accessibility.Private))
         * {
         * return 0;
         * }
         * else if
         * (attribute.getAccessibility().equals(Accessibility.Protected))
         * {
         * return (tree.getAllSubClasses((ClassOrInterfaceNode) entity).size())
         * / (numClasses - 1);
         * }
         * else
         * {
         * return (tree.getClasses(((ClassOrInterfaceNode)
         * entity).getPackage()).size()) / (numClasses - 1);
         * }
         */
        return 1.0;
    }
}
