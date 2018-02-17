/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.codetree.metrics.component;

/**
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class CF /* extends ComponentMetric */ {

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
    // "Measures the coupling between classes excluding coupling due to
    // inheritance. It is the ratio between the number of actually coupled pairs
    // of classes in a scope and the possible number of coupled pairs of
    // classes.",
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
