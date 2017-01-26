package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CBO_NA - Coupling Between Objects: No Ancestors. Same as CBO, but does not
 * take the coupling between the target class and its ancestors into
 * consideration.
 * 
 * @author Isaac Griffith
 */
public class CBO_NA extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -6006664997073855954L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CBO_NA getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CBO_NA("Coupling Between Objects: No Ancestors",
                "Same as CBO, but does not take the coupling between the target class and its ancestors into consideration.",
                "CBO_NA", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CBO_NA(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // final List<ProgramNode> ancestors =
        // tree.getSuperClasses((ClassOrInterfaceNode) entity);
        // final List<ProgramNode> classes = tree.getAdjacencies(entity,
        // ClassOrInterfaceNode.class);
        // final List<ProgramNode> interfaces = tree.getAdjacencies(entity,
        // ClassOrInterfaceNode.class);
        // final List<ProgramNode> enums = tree.getAdjacencies(entity,
        // EnumNode.class);

        final Set<CodeNode> set = new HashSet<>();
        // set.addAll(classes);
        // set.addAll(interfaces);
        // set.addAll(enums);
        // set.removeAll(ancestors);

        return set.size();
    }
}
