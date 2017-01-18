/**
 * 
 */
package com.sparqline.metrics.method;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.StatementNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * ComR - Comment Ratio. Number of comments divided by the LOC.
 * 
 * @author Isaac Griffith
 */
public class ComR extends MethodMetric {

    /**
     * 
     */
    private double loc;

    /**
     * 
     */
    private static final long serialVersionUID = 7705887957271667310L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ComR getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ComR("Comment Ratio", "Number of comments divided by the LOC", "ComR", MetricScope.MethodLevel,
                entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ComR(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double comr = 0;

        if (entity instanceof MethodNode)
        {
            final MethodNode method = (MethodNode) entity;
            double numComments = method.getComments().size();

            if ((method.getDocumentation() != null) && (method.getDocumentation().getContent() != null)
                    && !method.getDocumentation().getContent().isEmpty())
            {
                numComments++;
            }

            for (final StatementNode se : method.getContainedStatements())
            {
                numComments += se.getComments().size();
            }
            comr = numComments / loc;
        }

        return comr;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        loc = taskMap.containsKey("SLOC") ? taskMap.get("SLOC").join().getValue() : entity.getMetric("SLOC");
    }
}
