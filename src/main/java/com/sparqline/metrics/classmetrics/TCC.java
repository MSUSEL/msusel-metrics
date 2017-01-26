/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * TCC - Tight Class Coupling. Measures the ratio between the actual number of
 * visible directly connected methods in a class, NDC(c), divided by the number
 * of maximal possible number of connections between the visible methods of a
 * class, NP(c). Two visible methods are directly connected, if they are
 * accessing the same instance variables of the class. TCC = NDC / NP
 * 
 * @author Isaac Griffith
 */
public class TCC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 7163919365829443819L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static TCC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new TCC("Tight Class Cohesion",
                "Measures the ratio betwen the actual number of visible directly connected methods in a class, NDC(c), divided by the number of maximal possible number of connections between the visible methods of a class, NP(c). Two visible methods are directly connected, if they are accessing the same instance variables of the class. TCC = NDC / NP",
                "TCC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private TCC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double retVal = 0;

        // if (entity instanceof TypeNode)
        // {
        // TypeNode tn = (TypeNode) entity;
        // final List<MethodNode> methods = Lists.newLinkedList();
        // final Set<FieldNode> fields = tn.getFields();
        // final Map<MethodNode, Set<FieldNode>> fieldUses = Maps.newHashMap();
        // final Set<Pair<MethodNode, MethodNode>> ndc = Sets.newHashSet();
        //
        // for (final MethodNode method : tn.getMethods())
        // {
        // if (method.getAccessibility().equals(Accessibility.Public))
        // {
        // methods.add(method);
        // }
        // }
        //
        // for (final MethodNode method : methods)
        // {
        // final Set<FieldNode> fieldsUsed = Sets.newHashSet();
        //
        // for (final FieldNode field : fields)
        // {
        // if (tree.isEdge(method, field, DirectedRelationshipType.FieldUse))
        // {
        // fieldsUsed.add(field);
        // }
        // }
        //
        // fieldUses.put(method, fieldsUsed);
        // }
        //
        // for (int i = 0; i < methods.size(); i++)
        // {
        // for (int j = 0; j < methods.size(); j++)
        // {
        // final MethodNode methodI = methods.get(i);
        // final MethodNode methodJ = methods.get(j);
        //
        // final Set<FieldNode> setI = fieldUses.get(methodI);
        // final Set<FieldNode> setJ = fieldUses.get(methodJ);
        //
        // try
        // {
        // if (!SetOperations.intersection(setI, setJ).isEmpty())
        // {
        // ndc.add(new Pair<MethodNode, MethodNode>(methodI, methodJ));
        // }
        // }
        // catch (final SetOperationsException e)
        // {
        // }
        // }
        // }
        //
        // final double np = (methods.size() * (methods.size() - 1)) / 2;
        //
        // retVal = ndc.size() / np;
        // }

        return retVal;
    }
}
