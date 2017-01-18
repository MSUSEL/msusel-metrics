/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

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
    public static AHF getInstance(final ProgramNode entity, final CodeGraph graph)
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
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final List<ProgramNode> classes = tree.getClasses();

        double totalFields = 0.0;
        double totalVisibility = 0.0;

        for (final ProgramNode cls : classes)
        {
            final List<ProgramNode> fields = tree.getFields(cls);
            totalFields += fields.size();

            double visible = 0.0;
            for (final ProgramNode field : fields)
            {
                visible += visibility((FieldNode) field);
            }

            totalVisibility += visible;
        }

        return totalVisibility / totalFields;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        numClasses = taskMap.containsKey("NC") ? taskMap.get("NC").join().getValue() : entity.getMetric("NC");
    }

    /**
     * @param attribute
     * @return
     */
    private double visibility(
            final com.sparqline.graph.nodes.body.FieldNode/* FieldEntity */attribute)
    {
        if (attribute.getAccessibility().equals(Accessibility.Public))
        {
            return 1;
        }
        else if (attribute.getAccessibility().equals(Accessibility.Private))
        {
            return 0;
        }
        else if (attribute.getAccessibility().equals(Accessibility.Protected))
        {
            return (tree.getAllSubClasses((ClassOrInterfaceNode) entity).size()) / (numClasses - 1);
        }
        else
        {
            return (tree.getClasses(((ClassOrInterfaceNode) entity).getPackage()).size()) / (numClasses - 1);
        }
    }
}
