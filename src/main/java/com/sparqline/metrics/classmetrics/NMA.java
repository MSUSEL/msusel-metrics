/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

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
    public static NMA getInstance(final CodeNode entity, final CodeTree graph)
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
            final CodeNode entity, final CodeTree graph)
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

        if (entity instanceof TypeNode)
        {
            final double nm = ((TypeNode) entity).getMethods().size();
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
        // nmo = taskMap.containsKey("NMO") ?
        // taskMap.get("NMO").join().getValue() : entity.getMetric("NMO");
    }
}
