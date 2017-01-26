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
 * NOPM - Number of Public Methods
 * 
 * @author Isaac
 */
public class NOPM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1042047101014300116L;

    public static NOPM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NOPM("Number of Public Methods", "", "NOPM", MetricScope.ClassLevel, entity, graph);
    }

    private NOPM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        List<MethodNode> methods = new LinkedList<>();
        // Set<MethodNode> classMethods = ((ClassOrInterfaceNode)
        // entity).getMethods();
        // for (MethodNode ent : classMethods)
        // {
        // MethodNode method = (MethodNode) ent;
        // if (method.isAbstract())
        // continue;
        // else if (method.getAccessibility() == Accessibility.Public)
        // methods.add(method);
        // }
        return methods.size();
    }
}
