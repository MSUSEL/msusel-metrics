package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CTA - Coupling Through Abstract data types. This metric counts the total
 * number of classes that are used as abstract data types in the data attribute
 * declaration of a class.
 * 
 * @author Isaac Griffith
 */
public class CTA extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -191452187069047548L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CTA getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CTA("Coupling Through Abstract data types",
                "This metric counts the total number of classes that are used as abstract data types in the data attribute declaration of a class.",
                "CTA", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CTA(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double cta = 0;

        /*
         * if (entity instanceof TypeNode)
         * {
         * final TypeNode cls = (TypeNode) entity;
         * final List<CodeNode> fields = tree.getFields(cls);
         * for (final CodeNode pe : fields)
         * {
         * if (pe instanceof FieldNode)
         * {
         * final FieldNode field = (FieldNode) pe;
         * if (!field.isPrimitive())
         * {
         * cta++;
         * }
         * }
         * }
         * }
         */

        return cta;
    }
}
