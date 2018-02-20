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
package edu.montana.gsoc.msusel.metrics.impl

import edu.montana.gsoc.msusel.metrics.AbstractLOCMetric
import edu.montana.gsoc.msusel.metrics.annotations.*
/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Comment Lines of Code",
        primaryHandle = "CLOC",
        description = "Count of the number of commented lines of code",
        properties = @MetricProperties(
                range = "Positive Integers",
                aggregation = [],
                scope = MetricScope.FILE,
                type = MetricType.SourceCode,
                scale = MetricScale.Interval,
                category = MetricCategory.Size
        ),
        references = [
                ''
        ]
)
class CommentLinesOfCode extends AbstractLOCMetric {

    /**
     * {@inheritDoc}
     */
    @Override
    def count(List<String> lines) {
        int total = 0
        boolean blockComment = false

        for (String line : lines) {
            String scrubbed = line.trim()
            if (!scrubbed.isEmpty()) {
                if (blockCommentStart != null && scrubbed.startsWith(blockCommentStart)) {
                    blockComment = true
                }
                if (blockCommentStart != null && scrubbed.contains(blockCommentStart) && !blockComment) {
                    blockComment = detectSequence(bcsQuotes, scrubbed, blockCommentStart)
                }
                if (!blockComment) {
                    if (scrubbed.startsWith(lineCommentStart)) {
                        if (!checkCommentExceptions(scrubbed)) {
                            total += 1
                        }
                    }
                    else if (scrubbed.contains(lineCommentStart)) {
                        boolean lineComment = detectSequence(lcQuotes, scrubbed, lineCommentStart)

                        if (lineComment || !checkCommentExceptions(scrubbed)) {
                            total += 1
                        }
                    }
                } else {
                    if (blockCommentEnd != null && scrubbed.contains(blockCommentEnd)) {
                        blockComment = detectSequence(bceQuotes, scrubbed, blockCommentEnd)

                        total += 1
                    }
                }
            }
        }

        total
    }
}
