package com.sparqline.metrics.packagemetrics;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.PackageMetric;

/**
 * PDAC - Package Data Abstraction Coupling. Measures the coupling complexity
 * caused by ADTs at the package level. Based on DAC, it transfers the effects
 * of the coupling between classes on the reuse degree, maintenance and testing
 * effort to more abstract organization units like packages and modules, which
 * are as well decisively influenced by the coupling between classes of
 * different packages. C(p = succ(p, contains^PDAC). PDAC(p) = |succ(C(p),
 * referencestype^PDAC) \\ C(p)|.
 * 
 * @author Isaac Griffith
 */
public class PDAC extends PackageMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 6443235746800681538L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static PDAC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new PDAC(
                "Package Data Abstraction Coupling",
                "Measures the coupling complexity caused by ADTs at the package level. Based on DAC, it transfers the effects of the coupling between classes on the reuse degree, maintenance and testing effort to more abstract organization units like packages and modules, which are as well decisively influenced by the coupling between classes of different packages. C(p = succ(p, contains^PDAC). PDAC(p) = |succ(C(p), referencestype^PDAC) \\ C(p)|.",
                "PDAC", MetricScope.PackageLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private PDAC(final String name, final String desc, final String acronym, final MetricScope scope,
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
