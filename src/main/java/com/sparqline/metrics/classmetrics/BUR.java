package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

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
    public static BUR getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new BUR("Base Class Usage Ratio",
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
            final CodeNode entity, final CodeTree graph)
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
        final List<CodeNode> baseMethods = new LinkedList<>();
        final List<CodeNode> baseFields = new LinkedList<>();

        double baseUses = 0;

        // if (entity instanceof TypeNode)
        // {
        // for (final CodeNode base : tree.getAllSuperClasses((TypeNode)
        // entity))
        // {
        // baseMethods.addAll(tree.getMethods(base));
        // baseFields.addAll(tree.getFields(base));
        // }
        //
        // for (final CodeNode method : tree.getMethods(entity))
        // {
        // for (final CodeNode baseMethod : baseMethods)
        // {
        // if (!tree.getEdges(method, baseMethod,
        // DirectedRelationshipType.MethodCall).isEmpty())
        // {
        // baseUses++;
        // }
        // }
        //
        // for (final CodeNode baseField : baseFields)
        // {
        // if (!tree.getEdges(method, baseField,
        // DirectedRelationshipType.FieldUse).isEmpty())
        // {
        // baseUses++;
        // }
        // }
        // }
        // }

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
