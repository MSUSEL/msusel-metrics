/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * LOD - Lack of Documentation. How many comments are lacking in a class,
 * considering one class comment and a comment per method as optimum. Structure
 * and content of the comments are ignored.
 * 
 * @author Isaac
 */
public class LOD extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LOD getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LOD(
                "Lack of Documentation",
                "How many comments are lacking in a class, considering one class comment and a comment per method as optimum. Structure and content of the comments are ignored.",
                "LOD", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    public LOD(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double lod = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            double commentCount = 0;
            final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;

            if ((cls.getDocumentation() != null) && (cls.getDocumentation().getContent() != null)
                    && !cls.getDocumentation().getContent().isEmpty())
            {
                commentCount++;
            }

            commentCount += cls.getComments().size();

            for (final ProgramNode pe : tree.getMethods(entity))
            {
                if (pe instanceof MethodNode)
                {
                    final MethodNode method = (MethodNode) pe;
                    commentCount += method.getComments().size();

                    if ((method.getDocumentation() != null) && (method.getDocumentation().getContent() != null)
                            && !method.getDocumentation().getContent().isEmpty())
                    {
                        commentCount++;
                    }
                }
            }

            final double optComments = 1 + tree.getMethods().size();

            if (commentCount < optComments)
            {
                lod = optComments - commentCount;
            }
            else
            {
                lod = 0;
            }
        }

        return lod;
    }

}
