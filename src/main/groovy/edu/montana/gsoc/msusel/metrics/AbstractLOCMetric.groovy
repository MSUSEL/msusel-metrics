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
package edu.montana.gsoc.msusel.metrics

import edu.montana.gsoc.msusel.codetree.node.AbstractNode
import edu.montana.gsoc.msusel.codetree.node.CodeNode
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode
import edu.montana.gsoc.msusel.codetree.node.structural.StructuralNode
import edu.montana.gsoc.msusel.metrics.annotations.MetricDefinition

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
abstract class AbstractLOCMetric extends AbstractSourceMetric {

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
    def measure(AbstractNode node) {
        if (node instanceof CodeNode) {
            List<String> lines = getLines(node)
            String ext = tree.getUtils().findParent(node).getKey().find(/\.\w{2,4}$/)
            ext = ext.substring(1)

            loadProfile(LoCProfileManager.instance.getProfileByExtension(ext))

            MeasuresTable.instance.store(Measurement.of(this).on(node).withValue(count(lines)))
        } else if (node instanceof FileNode) {
            List<String> lines = getLines(node)
            String ext = node.getKey().find(/\.\w{2,4}$/)
            ext = ext.substring(1)

            loadProfile(LoCProfileManager.instance.getProfileByExtension(ext))

            MeasuresTable.instance.store(Measurement.of(this).on(node).withValue(count(lines)))
        }
        else if (node instanceof StructuralNode) {
            int total = 0

            node.files().each { file ->
                MetricDefinition mdef = this.getClass().getAnnotation(MetricDefinition.class)
                total += MeasuresTable.instance.retrieve(file, mdef.primaryHandle())
            }
            MeasuresTable.instance.store(Measurement.of(this).on(node).withValue(total))
        } else {
            0
        }

    }

    /**
     * Provides the logic necessary to update the counts for each metric
     * correctly
     *
     * @param lines
     *            List of lines to be counted.
     */
    abstract def count(List<String> lines)

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
        boolean found = false
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
