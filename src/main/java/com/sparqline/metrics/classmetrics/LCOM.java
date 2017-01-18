/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.graph.relations.DirectedRelationshipType;
import com.sparqline.graph.utils.Pair;
import com.sparqline.graph.utils.SetOperations;
import com.sparqline.graph.utils.SetOperationsException;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

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
    public static LCOM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LCOM(
                "Lack of Cohesion in Object Methods.",
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
        final Map<ProgramNode, Set<ProgramNode>> fieldUses = new HashMap<>();
        final Set<Pair<ProgramNode, ProgramNode>> pairsP = new HashSet<>();
        final Set<Pair<ProgramNode, ProgramNode>> pairsQ = new HashSet<>();

        if (entity instanceof ClassOrInterfaceNode)
        {
            final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;

            final List<ProgramNode> fields = tree.getFields(cls);
            final List<ProgramNode> methods = tree.getMethods(cls);

            for (final ProgramNode method : methods)
            {
                final Set<ProgramNode> uses = new HashSet<>();
                for (final ProgramNode field : fields)
                {
                    if (!tree.getEdges(method, field, DirectedRelationshipType.FieldUse).isEmpty())
                    {
                        uses.add(field);
                    }
                }

                fieldUses.put(method, uses);
            }

            for (int i = 0; i < methods.size(); i++)
            {
                for (int j = i + 1; j < methods.size(); j++)
                {
                    final ProgramNode methodI = methods.get(i);
                    final ProgramNode methodJ = methods.get(j);

                    final Set<ProgramNode> setI = fieldUses.get(methodI);
                    final Set<ProgramNode> setJ = fieldUses.get(methodJ);

                    try
                    {
                        if (SetOperations.intersection(setI, setJ).isEmpty())
                        {
                            pairsP.add(new Pair<ProgramNode, ProgramNode>(methodI, methodJ));
                        }
                        else
                        {
                            pairsQ.add(new Pair<ProgramNode, ProgramNode>(methodI, methodJ));
                        }
                    }
                    catch (final SetOperationsException e)
                    {
                    }
                }
            }
        }

        return (pairsP.size() > pairsQ.size()) ? pairsP.size() - pairsQ.size() : 0;
    }
}
