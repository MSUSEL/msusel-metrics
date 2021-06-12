/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.metrics

import edu.isu.isuese.datamodel.Component
import edu.isu.isuese.datamodel.File
import edu.isu.isuese.datamodel.FileType
import edu.isu.isuese.datamodel.Measurable
import edu.isu.isuese.datamodel.Measure
import edu.isu.isuese.datamodel.Module
import edu.isu.isuese.datamodel.Namespace
import edu.isu.isuese.datamodel.Project
import edu.isu.isuese.datamodel.Structure
import edu.isu.isuese.datamodel.System
import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
abstract class LOCMetricEvaluator extends SourceMetricEvaluator {

    /**
     * String indicating the start of a single line comment
     */
    String lineCommentStart
    /**
     * String indicating the start of a multi-line, or block, comment
     */
    String blockCommentStart
    /**
     * String indicating the end of a multi-line, or block, comment
     */
    String blockCommentEnd
    /**
     * String used to indicate the end of a line of text
     */
    String newLineSeparator
    /**
     * List of known comment start exceptions
     */
    List<String> commentStartExceptions

    Pattern bcsQuotes = Pattern.compile("([\"\']).*(\\Q" + blockCommentStart + "\\E)")
    Pattern bceQuotes = Pattern.compile("([\"\']).*(\\Q" + blockCommentEnd + "\\E)")
    Pattern lcQuotes = Pattern.compile("[\"\'].*(\\Q" + lineCommentStart + "\\E)")

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(Measurable node) {
        double cnt = 0

        if (node instanceof Component) {
            List<String> lines = getLines(node)
            String ext = node.getParentFile().getRefKey().find(/\.\w{2,4}$/)
            ext = ext.substring(1)

            loadProfile(LoCProfileManager.instance.getProfileByExtension(ext))

            cnt = count(lines)
            MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
            Measure.of("${repo.getRepoKey()}:${mdef.primaryHandle()}").on(node).withValue(cnt)
        } else if (node instanceof File) {
            List<String> lines = getLines(node)
            String ext = node.getRefKey().find(/\.\w{2,4}$/)
            ext = ext.substring(1)

            loadProfile(LoCProfileManager.instance.getProfileByExtension(ext))

            cnt = count(lines)
            MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
            Measure.of("${repo.getRepoKey()}:${mdef.primaryHandle()}").on(node).withValue(cnt)
        } else if (node instanceof System) {
            (node as System).getProjects().each { proj ->
                MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
                cnt += proj.getValueFor("${repo.getRepoKey()}:${mdef.primaryHandle()}")
            }
            MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
            Measure.of("${repo.getRepoKey()}:${mdef.primaryHandle()}").on(node).withValue(cnt)
        } else if (node instanceof Project) {
            node.getNamespaces().each { ns ->
                MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
                cnt += ns.getValueFor("${repo.getRepoKey()}:${mdef.primaryHandle()}")
            }
            node.getModules().each {mod ->
                MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
                cnt += mod.getValueFor("${repo.getRepoKey()}:${mdef.primaryHandle()}")
            }
            MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
            Measure.of("${repo.getRepoKey()}:${mdef.primaryHandle()}").on(node).withValue(cnt)
        } else if (node instanceof Namespace) {
            node.getFiles().each { type ->
                MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
                cnt += type.getValueFor("${repo.getRepoKey()}:${mdef.primaryHandle()}")
            }
            MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
            Measure.of("${repo.getRepoKey()}:${mdef.primaryHandle()}").on(node).withValue(cnt)
        } else if (node instanceof Module) {
            node.getFilesByType(FileType.SOURCE).each { file ->
                MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
                cnt += file.getValueFor("${repo.getRepoKey()}:${mdef.primaryHandle()}")
            }
            MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
            Measure.of("${repo.getRepoKey()}:${mdef.primaryHandle()}").on(node).withValue(cnt)
        }

        cnt
    }

    /**
     * Provides the logic necessary to update the counts for each metric
     * correctly
     *
     * @param lines
     *            List of lines to be counted.
     */
    abstract double count(List<String> lines)

    /**
     * Sets the current LoCProfile to the provided one, if not null.
     *
     * @param profile
     *            new LoCProfile to use.
     */
    void loadProfile(LoCProfile profile) {
        if (profile == null)
            return

        this.blockCommentEnd = profile.getBlockCommentEnd()
        this.blockCommentStart = profile.getBlockCommentStart()
        this.commentStartExceptions = profile.getCommentStartExceptions()
        this.lineCommentStart = profile.getLineCommentStart()
    }

    /**
     * Checks whether the scrubbed input string matches any of the known line
     * comment exceptions.
     *
     * @param scrubbed
     *            Cleansed input string
     * @return true if the string matches any of the known exceptions, false
     *         otherwise.
     */
    protected boolean checkCommentExceptions(String scrubbed) {
        boolean excepted = false
        for (String exc : commentStartExceptions) {
            if (scrubbed.startsWith(exc)) {
                excepted = true
                break
            }
        }
        return excepted
    }

    /**
     * @param pattern The pattern providing the matcher
     * @param scrubbed The scrubbed string in which to look
     * @param sequence Sequence denoting what is to be identified
     * @return true if the sequence was detected
     */
    protected boolean detectSequence(Pattern pattern, String scrubbed, String sequence) {
        Matcher m = pattern.matcher(scrubbed)
        boolean found
        boolean retVal = true
        while (true) {
            found = m.find()
            if (found && m.start(1) == scrubbed.lastIndexOf(sequence))
                retVal = false

            if (!found || m.hitEnd())
                break
        }

        retVal
    }
}
