package com.sparqline.metrics.classmetrics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.CodeNode;
import com.sparqline.graph.nodes.StatementNode;
import com.sparqline.graph.nodes.statement.EmptyStatement;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * LOC - Lines of Code
 * 
 * @author Isaac Griffith
 */
public class LOC extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -1784797110751013156L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static LOC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new LOC("", "", "LOC", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private LOC(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @param pe
     * @return
     */
    private int calculateLOC(final CodeNode pe)
    {
        return 1 + getAllStatementsButEmpty(pe);
    }

    /**
     * @param pe
     * @return
     */
    private int getAllStatementsButEmpty(final CodeNode pe)
    {
        final List<StatementNode> stmts = new LinkedList<>(pe.getContainedStatements());
        final Iterator<StatementNode> iter = stmts.iterator();
        while (iter.hasNext())
        {
            if (iter.next() instanceof EmptyStatement)
            {
                iter.remove();
            }
        }

        return stmts.size();
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        int loc = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            final ClassOrInterfaceNode cls = (ClassOrInterfaceNode) entity;
            loc++; // for class definition
            for (final String imp : cls.getImports())
            {
                loc++; // for each import
            }

            if ((cls.getPackageName() != null) || !cls.getPackageName().isEmpty())
            {
                loc++; // for package declaration
            }

            for (final ProgramNode pe : tree.getMethods(cls))
            {
                loc++; // for method declaration

                loc += pe.getMetric("LOC");
            }

            loc += tree.getFields(cls).size(); // One for each field defined

            for (final ProgramNode pe : tree.getInitializers(cls))
            {
                loc++;

                loc += calculateLOC((CodeNode) pe);
            }
        }

        return loc;
    }
}
