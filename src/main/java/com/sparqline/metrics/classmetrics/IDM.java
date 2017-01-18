/**
 * 
 */
package com.sparqline.metrics.classmetrics;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.ClassMetric;
import com.sparqline.metrics.MetricScope;

/**
 * IDM - Inherited Data Members. Number of attributes inherited from all
 * ancestor classes of the class.
 * 
 * @author Isaac Griffith
 */
public class IDM extends ClassMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -4779251450315597804L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static IDM getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new IDM("Inherited Data Members",
                "Number of attributes inherited from all ancestor classes of the class.", "IDM",
                MetricScope.ClassLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private IDM(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /**
     * @return
     */
    private Set<ProgramNode> getSuperAttributes(final ClassOrInterfaceNode cls)
    {
        final Set<ProgramNode> retVal = new HashSet<>();

        if (!tree.getSuperClasses(cls).isEmpty())
        {
            for (final ProgramNode sup : tree.getSuperClasses(cls))
            {
                for (final ProgramNode superAttrib : tree.getFields(sup))
                {
                    for (final ProgramNode attrib : tree.getFields(cls))
                    {
                        if (!attrib.getName().equals(superAttrib.getName()))
                        {
                            retVal.add(superAttrib);
                        }
                    }
                }
                retVal.addAll(getSuperAttributes((ClassOrInterfaceNode) sup));
            }
        }

        return retVal;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double idm = 0;

        if (entity instanceof ClassOrInterfaceNode)
        {
            final Set<ProgramNode> superAttribs = getSuperAttributes((ClassOrInterfaceNode) entity);
            idm = superAttribs.size();
        }

        return idm;
    }
}
