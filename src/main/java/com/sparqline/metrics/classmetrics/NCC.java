package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.StatementNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.body.InitializerNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NCC - Number of Comments per Class. Count of the number of individual
 * comments defined within the scope of a class, including comments for the
 * class itself.
 * 
 * @author Isaac Griffith
 */
public class NCC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6076385736130998894L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NCC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NCC(
                "Number of Comments per Class",
                "Count of the number of individual comments defined within the scope of a class, including comments for the class itself.",
                "NCC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NCC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double numComments = 0;
        if (entity instanceof ClassOrInterfaceNode)
        {
            final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
            if (cls.getDocumentation() != null)
            {
                final String classComment = ((ClassOrInterfaceNode) entity).getDocumentation().getContent();
                if ((classComment != null) && !classComment.isEmpty())
                {
                    numComments++;
                }
            }
            numComments += cls.getComments().size();

            for (final ProgramNode ie : tree.getInitializers(cls))
            {
                if (ie instanceof InitializerNode)
                {
                    final InitializerNode init = (InitializerNode) ie;
                    if ((init.getDocumentation() != null) && (init.getDocumentation().getContent() != null)
                            && !init.getDocumentation().getContent().isEmpty())
                    {
                        numComments++;
                    }
                    numComments += init.getComments().size();

                    for (final StatementNode se : init.getContainedStatements())
                    {
                        numComments += se.getComments().size();
                    }
                }
            }

            for (final ProgramNode fe : tree.getFields(entity))
            {
                if (fe instanceof FieldNode)
                {
                    final FieldNode field = (FieldNode) fe;
                    if ((field.getDocumentation() != null) && (field.getDocumentation().getContent() != null)
                            && !(field.getDocumentation().getContent().isEmpty()))
                    {
                        numComments++;
                    }
                    numComments += field.getComments().size();
                }
            }

            for (final ProgramNode me : tree.getMethods(entity))
            {
                if (me instanceof MethodNode)
                {
                    final MethodNode method = (MethodNode) me;
                    if ((method.getDocumentation() != null) && (method.getDocumentation().getContent() != null)
                            && !method.getDocumentation().getContent().isEmpty())
                    {
                        numComments++;
                    }
                    numComments += method.getComments().size();

                    for (final StatementNode se : method.getContainedStatements())
                    {
                        numComments += se.getComments().size();
                    }
                }
            }
        }

        return numComments;
    }
}
