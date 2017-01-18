package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NProtM - Number of Protected Members. The number of protected attributes and
 * methods of a class.
 * 
 * @author Isaac Griffith
 */
public class NProtM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6146092828130543910L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NProtM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NProtM("Number of Protected Members", "The number of protected attributes and methods of a class.",
                "NProtM", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NProtM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> methods = tree.getMethods(entity);
        final List<ProgramNode> fields = tree.getFields(entity);

        int count = 0;

        for (final ProgramNode entity : methods)
        {
            if (((MethodNode) entity).getAccessibility().equals(Accessibility.Protected))
            {
                count++;
            }
        }

        for (final ProgramNode entity : fields)
        {
            if (((FieldNode) entity).getAccessibility().equals(Accessibility.Protected))
            {
                count++;
            }
        }

        return count;
    }

}
