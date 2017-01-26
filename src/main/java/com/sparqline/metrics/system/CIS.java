/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.ProjectNode;

/**
 * CIS -
 * 
 * @author Isaac Griffith
 */
public class CIS extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -439283271884547529L;

    public static CIS getInstance(final CodeNode entity, final CodeTree graph)
    {
        return new CIS("", "", "CIS", MetricScope.SystemLevel, entity, graph);
    }

    private CIS(final String name, final String desc, final String acronym, final MetricScope scope,
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

        if (entity instanceof ProjectNode)
        {
            final ProjectNode sys = (ProjectNode) entity;
            final Set<CodeNode> systemClasses = new HashSet<>();
            // systemClasses.addAll(sys.getClasses());

            double totalNOPM = 0.0d;
            for (CodeNode ce : systemClasses)
            {
                totalNOPM += ce.getMetric("NOPM");
            }

            value = totalNOPM / systemClasses.size();
        }

        if (Double.isNaN(value))
            value = 0;
        return value;
    }

}
