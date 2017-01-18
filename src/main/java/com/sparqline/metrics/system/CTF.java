/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * CTF - Class Template Factor. Ratio of the number of classes using clas
 * templates and the number of classes.
 * 
 * @author Isaac
 */
public class CTF extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2628707390320103830L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CTF getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CTF("Class Template Factor",
                "Ratio of the number of classes using class templates and the number of classes.", "CTF",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * 
     */
    private double numClasses;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CTF(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> classes = tree.getClasses();
        final List<ProgramNode> interfaces = tree.getInterfaces();

        double templateClassCount = 0;

        for (final ProgramNode entity : classes)
        {
            if (entity instanceof ClassOrInterfaceNode)
            {
                if (((ClassOrInterfaceNode) entity).isTemplate())
                {
                    templateClassCount++;
                }
            }
        }

        double numIntefaces = 0;

        for (final ProgramNode entity : interfaces)
        {
            if ((entity instanceof ClassOrInterfaceNode) && ((ClassOrInterfaceNode) entity).isInterface())
            {
                if (((ClassOrInterfaceNode) entity).isTemplate())
                {
                    templateClassCount++;
                }
                numIntefaces++;
            }
        }

        return templateClassCount / (numClasses + numIntefaces);
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
}
