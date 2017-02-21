/**
 * The MIT License (MIT)
 *
 * SparQLine Metrics
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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
package com.sparqline.metrics;

import com.sparqline.metrics.file.NC;
import com.sparqline.metrics.method.NOS;
import com.sparqline.metrics.type.NOF;
import com.sparqline.metrics.type.NOM;
import com.sparqline.metrics.type.NOV;

/**
 * Temporary class that ensures quamoco required metrics register their names
 * correctly.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class Register {

    /**
     * Registers the quamoco metrics by creating instances.
     */
    public static void register()
    {
        NC.getInstance();
        NOS.getInstance();
        NOM.getInstance();
        NOF.getInstance();
        NOV.getInstance();
    }
}
