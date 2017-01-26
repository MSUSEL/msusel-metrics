/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.utility.Pair;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * LCOM - Lack of Cohesion in Object Methods. Indicates the level of cohesion
 * between the methods. Count of the number of method pairs whose similarity is
 * 0, minus the count of method pairs whose similarity is not zero.
 * 
 * @author Isaac Griffith
 */
public class LCOM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4768992105913532526L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LCOM getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new LCOM("Lack of Cohesion in Object Methods.",
                "Indicates the level of cohesion between the methods. Count of the number of method pairs whose similarity is 0, minus the count of method pairs whose similarity is not zero.",
                "LCOM", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LCOM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final Map<CodeNode, Set<CodeNode>> fieldUses = new HashMap<>();
        final Set<Pair<CodeNode, CodeNode>> pairsP = new HashSet<>();
        final Set<Pair<CodeNode, CodeNode>> pairsQ = new HashSet<>();

        // if (entity instanceof ClassOrInterfaceNode)
        // {
        // final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
        //
        // final List<CodeNode> fields = tree.getFields(cls);
        // final List<CodeNode> methods = tree.getMethods(cls);
        //
        // for (final CodeNode method : methods)
        // {
        // final Set<CodeNode> uses = new HashSet<>();
        // for (final CodeNode field : fields)
        // {
        // if (!tree.getEdges(method, field,
        // DirectedRelationshipType.FieldUse).isEmpty())
        // {
        // uses.add(field);
        // }
        // }
        //
        // fieldUses.put(method, uses);
        // }
        //
        // for (int i = 0; i < methods.size(); i++)
        // {
        // for (int j = i + 1; j < methods.size(); j++)
        // {
        // final CodeNode methodI = methods.get(i);
        // final CodeNode methodJ = methods.get(j);
        //
        // final Set<CodeNode> setI = fieldUses.get(methodI);
        // final Set<CodeNode> setJ = fieldUses.get(methodJ);
        //
        // try
        // {
        // if (SetOperations.intersection(setI, setJ).isEmpty())
        // {
        // pairsP.add(new Pair<CodeNode, CodeNode>(methodI, methodJ));
        // }
        // else
        // {
        // pairsQ.add(new Pair<CodeNode, CodeNode>(methodI, methodJ));
        // }
        // }
        // catch (final SetOperationsException e)
        // {
        // }
        // }
        // }
        // }

        return (pairsP.size() > pairsQ.size()) ? pairsP.size() - pairsQ.size() : 0;
    }
}
