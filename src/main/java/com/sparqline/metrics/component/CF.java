/**
 * 
 */
package com.sparqline.metrics.component;


public class CF /* extends ComponentMetric */{

    // /**
    // *
    // */
    // private static final long /* serialVersionUID = 4658683602819093662L */;

    // /**
    // * @param name
    // * @param desc
    // * @param acronym
    // * @param scope
    // * @param graph
    // * @param entities
    // */
    // public CF(String name, String desc, String acronym, MetricScope scope,
    // ProgramEntity entity, CodeGraph graph)
    // {
    // super(name, desc, acronym, scope, entity, graph);
    // // TODO Auto-generated constructor stub
    // }

    // /**
    // * @param graph
    // * @param entities
    // * @return
    // */
    // public static CF getInstance(final ProgramEntity entity, final CodeGraph
    // graph)
    // {
    // return new CF(
    // "Coupling Factor",
    // "Measures the coupling between classes excluding coupling due to inheritance. It is the ratio between the number of actually coupled pairs of classes in a scope and the possible number of coupled pairs of classes.",
    // "CF", MetricScope.PackageLevel, entity, graph);
    // }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    // @Override
    // public double measure()
    // {
    // double cf = 0;

    // if (entity instanceof ComponentEntity)
    // {
    // double totalCount = 0;
    // for (final ClassOrInterfaceEntity cls : ((ComponentEntity)
    // entity).getContents())
    // {
    // final List<ProgramEntity> others = graph.getClasses();
    // int count = 0;
    // for (final ProgramEntity other : others)
    // {
    // if (cls.equals(other))
    // {
    // continue;
    // }

    // count += isClient(cls, other);
    // }

    // totalCount += count;
    // }

    // double numClasses = ((ComponentEntity) entity).getContents().size();
    // cf = totalCount / ((numClasses * numClasses) - numClasses);
    // }
    // return cf;
    // }

    // /**
    // * @param client
    // * @param supplier
    // * @return
    // */
    // private int isClient(final ProgramEntity client, final ProgramEntity
    // supplier)
    // {
    // if (graph.isEdge(client, supplier,
    // AssociationRelationshipType.DirectedAssociation)
    // || graph.isEdge(client, supplier, DirectedRelationshipType.Usage)
    // || graph.isEdge(client, supplier, AssociationRelationshipType.Extension))
    // {
    // return 1;
    // }
    // else
    // {
    // return 0;
    // }
    // }

}
