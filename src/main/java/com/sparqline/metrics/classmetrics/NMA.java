/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * NMA - Number of Methods Added by a Subclass. Number of methods newly added by
 * the class (and not overridden or inherited).
 * 
 * @author Isaac Griffith
 */
public class NMA extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4087957237958514876L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NMA getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new NMA("Number of Methods Added by a Subclass",
                "Number of methods newly added by the class (and not overridden or inherited).", "NMA",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * 
     */
    private double nmo;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NMA(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double nma = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            final double nm = tree.getMethods(entity).size();
            nma = nm - nmo;
        }

        return nma;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        nmo = taskMap.containsKey("NMO") ? taskMap.get("NMO").join().getValue() : entity.getMetric("NMO");
    }
}
