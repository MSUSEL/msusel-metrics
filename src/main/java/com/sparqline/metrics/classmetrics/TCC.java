/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.Accessibility;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.graph.utils.Pair;
import com.sparqline.graph.utils.SetOperations;
import com.sparqline.graph.utils.SetOperationsException;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * TCC - Tight Class Coupling. Measures the ratio betwen the actual number of
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
    public static TCC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new TCC(
                "Tight Class Cohesion",
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
        double retVal = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            final List<MethodNode> methods = new LinkedList<>();
            final List<ProgramNode> fields = tree.getFields(entity);
            final Map<MethodNode, Set<ProgramNode>> fieldUses = new HashMap<>();
            final Set<Pair<MethodNode, MethodNode>> ndc = new HashSet<>();

            for (final ProgramNode pe : tree.getMethods(entity))
            {
                if (pe instanceof MethodNode)
                {
                    final MethodNode method = (MethodNode) pe;
                    if (method.getAccessibility().equals(Accessibility.Public))
                    {
                        methods.add(method);
                    }
                }
            }

            for (final MethodNode method : methods)
            {
                final Set<ProgramNode> fieldsUsed = new HashSet<>();

                for (final ProgramNode field : fields)
                {
                    if (tree.isEdge(method, field, DirectedRelationshipType.FieldUse))
                    {
                        fieldsUsed.add(field);
                    }
                }

                fieldUses.put(method, fieldsUsed);
            }

            for (int i = 0; i < methods.size(); i++)
            {
                for (int j = 0; j < methods.size(); j++)
                {
                    final MethodNode methodI = methods.get(i);
                    final MethodNode methodJ = methods.get(j);

                    final Set<ProgramNode> setI = fieldUses.get(methodI);
                    final Set<ProgramNode> setJ = fieldUses.get(methodJ);

                    try
                    {
                        if (!SetOperations.intersection(setI, setJ).isEmpty())
                        {
                            ndc.add(new Pair<MethodNode, MethodNode>(methodI, methodJ));
                        }
                    }
                    catch (final SetOperationsException e)
                    {
                    }
                }
            }

            final double np = (methods.size() * (methods.size() - 1)) / 2;

            retVal = ndc.size() / np;
        }

        return retVal;
    }
}
