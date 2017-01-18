/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NCV - Number of Class Variables. Number of fields found in the class but not
 * in its instances.
 * 
 * @author Isaac Griffith
 */
public class NCV extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 2268484905566075192L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NCV getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NCV("Number of Class Variables", "Number of fields found in the class but not in its instances.",
                "NCV", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NCV(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        final List<ProgramNode> fields = tree.getFields(entity);

        double staticFields = 0;

        for (final ProgramNode pe : fields)
        {
            if (pe instanceof FieldNode)
            {
                if (((FieldNode) pe).isStatic())
                {
                    staticFields++;
                }
            }
        }

        return staticFields;
    }

}
