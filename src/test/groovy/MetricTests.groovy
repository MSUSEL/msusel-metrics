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
import edu.montana.gsoc.msusel.codetree.CodeTree
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode
import edu.montana.gsoc.msusel.codetree.node.structural.ProjectNode
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode
import edu.montana.gsoc.msusel.codetree.parsers.JavaCodeTreeBuilder
import edu.montana.gsoc.msusel.metrics.AbstractMetric
import edu.montana.gsoc.msusel.metrics.MeasuresTable
import edu.montana.gsoc.msusel.metrics.MetricsRegistrar
import spock.lang.Shared
import spock.lang.Specification

class MetricTests extends Specification {

    @Shared
    CodeTree tree
    @Shared
    MeasuresTable table = MeasuresTable.instance

    def setup() {
        JavaCodeTreeBuilder builder = new JavaCodeTreeBuilder()
        tree = builder.build("Test", "data/test/")

        measureMetrics()
    }

    def measureMetrics() {
        MetricsRegistrar reg = MetricsRegistrar.instance
        def metrics = ["NOS"]

        tree.getUtils().getMethods().each { method ->
            AbstractMetric metric = reg.getMetric("NOS").newInstance()
            metric.setTree(tree)
            metric.measure(method)
        }

        metrics += ["NOF", "NOM", "SLOC", "BLOC", "CLOC"]

        tree.getUtils().getTypes().each { type ->
            metrics.each { handle ->
                AbstractMetric metric = reg.getMetric(handle).newInstance()
                metric.setTree(tree)
                metric.measure(type)
            }
        }

        ProjectNode project = tree.getProject()
        project.files().each { FileNode file ->
            metrics.each { handle ->
                AbstractMetric metric = reg.getMetric(handle).newInstance()
                metric.setTree(tree)
                metric.measure(file)
            }
        }

        metrics += ["NC"]
        metrics.each { handle ->
            AbstractMetric metric = reg.getMetric(handle).newInstance()
            metric.setTree(tree)
            metric.measure(project)
        }

    }

    def "Test Class A"() {
        given:
        TypeNode type = tree.getUtils().findType("A")

        when:
        // need to actual execute metrics
        def nof = table.retrieve(type, "NOF")
        def nos = table.retrieve(type, "NOS")
        def nom = table.retrieve(type, "NOM")
        def sloc = table.retrieve(type, "SLOC")
        def bloc = table.retrieve(type, "BLOC")
        def cloc = table.retrieve(type, "CLOC")

        then:
        nof == 2
        nos == 6
        nom == 3
        sloc == 17
        bloc == 4
        cloc == 3
    }

    def "Test Class B"() {
        given:
        TypeNode type = tree.getUtils().findType("B")

        when:
        // need to actual execute metrics
        def nof = table.retrieve(type, "NOF")
        def nos = table.retrieve(type, "NOS")
        def nom = table.retrieve(type, "NOM")
        def sloc = table.retrieve(type, "SLOC")
        def bloc = table.retrieve(type, "BLOC")
        def cloc = table.retrieve(type, "CLOC")

        then:
        nof == 2
        nos == 6
        nom == 3
        sloc == 17
        bloc == 4
        cloc == 3
    }

    def "Test Class C"() {
        given:
        TypeNode type = tree.getUtils().findType("C")

        when:
        // need to actual execute metrics
        def nof = table.retrieve(type, "NOF")
        def nos = table.retrieve(type, "NOS")
        def nom = table.retrieve(type, "NOM")
        def sloc = table.retrieve(type, "SLOC")
        def bloc = table.retrieve(type, "BLOC")
        def cloc = table.retrieve(type, "CLOC")

        then:
        nof == 2
        nos == 6
        nom == 3
        sloc == 17
        bloc == 4
        cloc == 3
    }

    def "Test Class D"() {
        given:
        TypeNode type = tree.getUtils().findType("D")

        when:
        // need to actual execute metrics
        def nof = table.retrieve(type, "NOF")
        def nos = table.retrieve(type, "NOS")
        def nom = table.retrieve(type, "NOM")
        def sloc = table.retrieve(type, "SLOC")
        def bloc = table.retrieve(type, "BLOC")
        def cloc = table.retrieve(type, "CLOC")

        then:
        nof == 2
        nos == 6
        nom == 3
        sloc == 17
        bloc == 4
        cloc == 3
    }

    def "Test Class E"() {
        given:
        TypeNode type = tree.getUtils().findType("E")

        when:
        // need to actual execute metrics
        def nof = table.retrieve(type, "NOF")
        def nos = table.retrieve(type, "NOS")
        def nom = table.retrieve(type, "NOM")
        def sloc = table.retrieve(type, "SLOC")
        def bloc = table.retrieve(type, "BLOC")
        def cloc = table.retrieve(type, "CLOC")

        then:
        nof == 2
        nos == 6
        nom == 3
        sloc == 17
        bloc == 4
        cloc == 3
    }

    def "Test Class F"() {
        given:
        TypeNode type = tree.getUtils().findType("F")

        when:
        // need to actual execute metrics
        def nof = table.retrieve(type, "NOF")
        def nos = table.retrieve(type, "NOS")
        def nom = table.retrieve(type, "NOM")
        def sloc = table.retrieve(type, "SLOC")
        def bloc = table.retrieve(type, "BLOC")
        def cloc = table.retrieve(type, "CLOC")

        then:
        nof == 2
        nos == 6
        nom == 3
        sloc == 17
        bloc == 4
        cloc == 3
    }

    def "Test Project"() {
        given:
        ProjectNode project = tree.getProject()

        when:
        // need to actual execute metrics
        def nof = table.retrieve(project, "NOF")
        def nos = table.retrieve(project, "NOS")
        def nom = table.retrieve(project, "NOM")
        def sloc = table.retrieve(project, "SLOC")
        def bloc = table.retrieve(project, "BLOC")
        def cloc = table.retrieve(project, "CLOC")
        def nc = table.retrieve(project, "NC")

        then:
        nof == 12
        nos == 36
        nom == 18
        nc == 6
        sloc == 102
        bloc == 24
        cloc == 18
    }
}
