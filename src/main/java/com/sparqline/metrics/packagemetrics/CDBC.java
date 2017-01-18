package com.sparqline.metrics.packagemetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;

/**
 * CDBC - Change Dependency Between Classes. Measures class level coupling. It
 * is a measure assigned to pairs of classes describing how dependent one class
 * (client class) is on the other (server class). CDBC(CC, SS) = min(n, A). n =
 * NOM. A = .
 * 
 * @author Isaac Griffith
 */
public class CDBC extends PackageMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -2044503071653954901L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static CDBC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new CDBC(
                "Change Dependency Between Classes",
                "Measures class level coupling. It is a measure assigned to pairs of classes describing how dependent one class (client class) is on the other (server class). CDBC(CC, SC) = min(n, A). n = NOM. A = ",
                "CDBC", MetricScope.PackageLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private CDBC(final String name, final String desc, final String acronym, final MetricScope scope,
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
        // TODO add implementation and return statement
        return Double.NEGATIVE_INFINITY;
    }
}
