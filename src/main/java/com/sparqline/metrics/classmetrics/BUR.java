package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * BUR - Base Class Usage Ratio. The number of inheritance-specific members used
 * by the measured class divided by the total number of inheritance-specific
 * members from the base class.
 * 
 * @author Isaac Griffith
 */
public class BUR extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 350896089686517873L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static BUR getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new BUR(
                "Base Class Usage Ratio",
                "The number of inheritance-specific members used by the measured class divided by the total number of inheritance-specific members from the base class.",
                "BUR", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private BUR(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> baseMethods = new LinkedList<>();
        final List<ProgramNode> baseFields = new LinkedList<>();

        double baseUses = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            for (final ProgramNode base : tree.getAllSuperClasses((ClassOrInterfaceNode) entity))
            {
                baseMethods.addAll(tree.getMethods(base));
                baseFields.addAll(tree.getFields(base));
            }

            for (final ProgramNode method : tree.getMethods(entity))
            {
                for (final ProgramNode baseMethod : baseMethods)
                {
                    if (!tree.getEdges(method, baseMethod, DirectedRelationshipType.MethodCall).isEmpty())
                    {
                        baseUses++;
                    }
                }

                for (final ProgramNode baseField : baseFields)
                {
                    if (!tree.getEdges(method, baseField, DirectedRelationshipType.FieldUse).isEmpty())
                    {
                        baseUses++;
                    }
                }
            }
        }

        if (baseUses == 0)
        {
            return 0;
        }
        else
        {
            return baseUses / (baseMethods.size() + baseFields.size());
        }
    }
}
