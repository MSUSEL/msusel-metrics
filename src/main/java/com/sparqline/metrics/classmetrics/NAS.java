/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * NAS - Number of Added Services. The number of public methods of a class that
 * are not overridden or specialized from an ancestor class.
 * 
 * @author Isaac Griffith
 */
public class NAS extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -7323401963040614468L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static NAS getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new NAS("Number of Added Services",
                "The number of public methods of a class that are not overridden or specialized from an ancestor class.",
                "NAS", MetricScope.ClassLevel, entity, graph);
    }

    /**
     * 
     */
    private double nmo = 0;
    /**
     * 
     */
    private double nom = 0;

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private NAS(final String name, final String desc, final String acronym, final MetricScope scope,
            final CodeNode entity, final CodeTree graph)
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
        return nom - nmo;
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
        // nom = taskMap.containsKey("NOM") ?
        // taskMap.get("NOM").join().getValue() : entity.getMetric("NOM");
    }
}
