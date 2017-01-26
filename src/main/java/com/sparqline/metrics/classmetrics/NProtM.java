package com.sparqline.metrics.classmetrics;

import java.util.Set;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.FieldNode;
import com.sparqline.quamoco.codetree.MethodNode;
import com.sparqline.quamoco.codetree.TypeNode;

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
    public static NProtM getInstance(final CodeNode entity, final CodeTree graph)
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
        int count = 0;

        if (entity instanceof TypeNode)
        {
            TypeNode tn = (TypeNode) entity;
            final Set<MethodNode> methods = tn.getMethods();
            final Set<FieldNode> fields = tn.getFields();

            // for (final MethodNode entity : methods)
            // {
            // if (entity.getAccessibility().equals(Accessibility.Protected))
            // {
            // count++;
            // }
            // }
            //
            // for (final FieldNode entity : fields)
            // {
            // if (entity.getAccessibility().equals(Accessibility.Protected))
            // {
            // count++;
            // }
            // }
        }

        return count;
    }

}
