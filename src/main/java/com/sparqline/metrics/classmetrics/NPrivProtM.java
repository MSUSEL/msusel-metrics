/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static NPrivProtM getInstance(final ProgramNode entity, final CodeGraph graph)
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
        ClassOrInterfaceNode cie = (ClassOrInterfaceNode) entity;
        List<MethodNode> methods = new LinkedList<>();
        for (MethodNode ent : cie.getMethods())
        {
            MethodNode method = (MethodNode) ent;
            if (method.isAbstract() || method.getAccessibility().equals(Accessibility.Public))
                continue;
            else
                methods.add(method);
        }
        return methods.size();
    }
}
