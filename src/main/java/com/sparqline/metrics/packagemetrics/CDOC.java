package com.sparqline.metrics.packagemetrics;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * CDOC - Change Dependnecy of Classes. Measures class level coupling. It is a
 * measure assigned to classes describing how dependent other classes are on
 * this class. This allows conclusions on the follow-up work to be done in all
 * client classes, when the sender clas is changed in the course of
 * re-engineering. It is the accumulation of CDBC metric., for a server class
 * (SC) and its client class (CC). CDOC(c) = Sum(CDBC(s, c), for all s \\in
 * class^CDOC).
 * 
 * @author Isaac
 */
public class CDOC extends PackageMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8112186455645962493L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CDOC getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CDOC("Change Dependency of Classes",
                "Measures class level coupling. It is a measure assigned to classes describing how dependent other classes are on this class. This allows conclusions on the follow-up work to be done in all client class, when the sender class is changed in the course of re-engineering. It is the accumulation of CDBC metric., for a serverclass (SC) and its clientclass (CC). CDOC(c) = Sum(CDBC(s, c), for all s \\in class^CDOC)",
                "CDOC", MetricScope.PackageLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CDOC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
