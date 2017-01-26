/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.MethodNode;

/**
 * NPrivM - Number of Private and Protected Methods. The number of private
 * methods of a class.
 * 
 * @author Isaac Griffith
 */
public class NPrivProtM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6146092828130543910L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NPrivProtM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NPrivProtM("Number of Private Methods", "The number of private methods of a class.", "NPrivM",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NPrivProtM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // ClassOrInterfaceNode cie = (ClassOrInterfaceNode) entity;
        List<MethodNode> methods = new LinkedList<>();
        // for (MethodNode ent : cie.getMethods())
        // {
        // MethodNode method = (MethodNode) ent;
        // if (method.isAbstract() ||
        // method.getAccessibility().equals(Accessibility.Public))
        // continue;
        // else
        // methods.add(method);
        // }
        return methods.size();
    }
}
