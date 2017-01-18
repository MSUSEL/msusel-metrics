/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.TypeNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.body.Parameter;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * PM - Number of Polymorphic Methods. Count of the methods with parameters that
 * support polymorphism (accept more than one type of object)."
 * 
 * @author Isaac Griffith
 */
public class PM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 5466044902086337995L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static PM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new PM(
                "Number of Polymorphic Methods",
                "Count of the methods with parameters that support polymorphism (accept more than one type of object).",
                "PM", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private PM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double pm = 0;

        final List<ProgramNode> methods = tree.getMethods(entity);

        for (final ProgramNode pe : methods)
        {
            if (pe instanceof MethodNode)
            {
                final MethodNode method = (MethodNode) pe;
                final List<Parameter> params = method.getParameters();
                for (final Parameter param : params)
                {
                    final TypeNode type = param.getType();
                    if (type instanceof ClassOrInterfaceNode)
                    {
                        if (tree.getAllSubClasses((ClassOrInterfaceNode) type).size() > 1)
                        {
                            pm++;
                        }
                    }
                }
            }
        }

        return pm;
    }
}
