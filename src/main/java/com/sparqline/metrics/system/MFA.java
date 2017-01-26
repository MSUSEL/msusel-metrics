/**
 * 
 */
package com.sparqline.metrics.system;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;

/**
 * MFA -
 * 
 * @author Isaac Griffith
 */
public class MFA extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = 1714939615608573616L;

    public static MFA getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new MFA("", "", "MFA", MetricScope.SystemLevel, entity, graph);
    }

    private MFA(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double value = 0.0d;

        /*
         * if (entity instanceof SystemNode)
         * {
         * final SystemNode sys = (SystemNode) entity;
         * final Set<ProgramNode> systemClasses = new HashSet<>();
         * systemClasses.addAll(sys.getClasses());
         * double totalMFA = 0.0d;
         * for (ProgramNode ce : systemClasses)
         * {
         * double NMI = ce.getMetric("NMI");
         * double NOM = ce.getMetric("NOM");
         * totalMFA = NMI / (NMI + NOM);
         * }
         * if (Double.isNaN(totalMFA))
         * totalMFA = 0;
         * value = totalMFA / systemClasses.size();
         * }
         * if (Double.isNaN(value))
         * value = 0;
         */
        return value;
    }
}
