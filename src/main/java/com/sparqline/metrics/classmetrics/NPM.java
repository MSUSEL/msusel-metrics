/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.List;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NPM - Number of Parameters per Method. The average number of parameters per
 * method in a class.
 * 
 * @author Isaac Griffith
 */
public class NPM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -5636300392609116644L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NPM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NPM("Number of Parameters per Method", "The average number of parameters per method in a class",
                "NPM", MetricScope.ClassLevel, entity, graph);
    }

    private double nom = 0;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NPM(final String name, final String desc, final String acronym, final MetricScope scope,
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
        final List<ProgramNode> methods = tree.getMethods(entity);

        double totalParams = 0;
        for (final ProgramNode method : methods)
        {
            totalParams += ((MethodNode) method).getParameters().size();
        }

        return totalParams / nom;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        nom = taskMap.containsKey("NOM") ? taskMap.get("NOM").join().getValue() : entity.getMetric("NOM");
    }

}
