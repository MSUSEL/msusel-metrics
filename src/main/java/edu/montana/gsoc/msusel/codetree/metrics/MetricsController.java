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
package edu.montana.gsoc.msusel.codetree.metrics;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.metrics.field.IVMC;
import edu.montana.gsoc.msusel.codetree.metrics.namespace.CDBC;
import edu.montana.gsoc.msusel.codetree.metrics.namespace.CDOC;
import edu.montana.gsoc.msusel.codetree.metrics.namespace.I;
import edu.montana.gsoc.msusel.codetree.metrics.namespace.PDAC;
import edu.montana.gsoc.msusel.codetree.metrics.type.*;
import edu.montana.gsoc.msusel.codetree.metrics.type.CC;
import edu.montana.gsoc.msusel.codetree.metrics.type.ComR;
import edu.montana.gsoc.msusel.codetree.metrics.type.DAM;
import edu.montana.gsoc.msusel.codetree.metrics.type.FTF;
import edu.montana.gsoc.msusel.codetree.metrics.type.LOC;
import edu.montana.gsoc.msusel.codetree.metrics.type.MFA;
import edu.montana.gsoc.msusel.codetree.metrics.type.NOM;
import edu.montana.gsoc.msusel.codetree.node.ProjectNode;
import edu.montana.gsoc.msusel.codetree.node.TypeNode;
import edu.montana.gsoc.msusel.codetree.metrics.method.CDISP;
import edu.montana.gsoc.msusel.codetree.metrics.method.CINT;
import edu.montana.gsoc.msusel.codetree.metrics.method.CYCLO;
import edu.montana.gsoc.msusel.codetree.metrics.method.ChC;
import edu.montana.gsoc.msusel.codetree.metrics.method.ChM;
import edu.montana.gsoc.msusel.codetree.metrics.method.FDP;
import edu.montana.gsoc.msusel.codetree.metrics.method.LAA;
import edu.montana.gsoc.msusel.codetree.metrics.method.MAXNESTING;
import edu.montana.gsoc.msusel.codetree.metrics.method.MCX;
import edu.montana.gsoc.msusel.codetree.metrics.method.NMC;
import edu.montana.gsoc.msusel.codetree.metrics.method.NMP;
import edu.montana.gsoc.msusel.codetree.metrics.method.NMS;
import edu.montana.gsoc.msusel.codetree.metrics.method.NOAV;
import edu.montana.gsoc.msusel.codetree.metrics.method.NOS;
import edu.montana.gsoc.msusel.codetree.metrics.method.NUP;
import edu.montana.gsoc.msusel.codetree.metrics.method.SLOC;
import edu.montana.gsoc.msusel.codetree.metrics.method.SMS;
import edu.montana.gsoc.msusel.codetree.metrics.namespace.Ca;
import edu.montana.gsoc.msusel.codetree.metrics.namespace.Ce;
import edu.montana.gsoc.msusel.codetree.metrics.project.AC;
import edu.montana.gsoc.msusel.codetree.metrics.project.ACX;
import edu.montana.gsoc.msusel.codetree.metrics.project.ADI;
import edu.montana.gsoc.msusel.codetree.metrics.project.AHF;
import edu.montana.gsoc.msusel.codetree.metrics.project.AIF;
import edu.montana.gsoc.msusel.codetree.metrics.project.ANIM;
import edu.montana.gsoc.msusel.codetree.metrics.project.ANIV;
import edu.montana.gsoc.msusel.codetree.metrics.project.APG;
import edu.montana.gsoc.msusel.codetree.metrics.project.AR;
import edu.montana.gsoc.msusel.codetree.metrics.project.ARS;
import edu.montana.gsoc.msusel.codetree.metrics.project.ASC;
import edu.montana.gsoc.msusel.codetree.metrics.project.BC;
import edu.montana.gsoc.msusel.codetree.metrics.project.CAN;
import edu.montana.gsoc.msusel.codetree.metrics.project.CBC;
import edu.montana.gsoc.msusel.codetree.metrics.project.CF;
import edu.montana.gsoc.msusel.codetree.metrics.project.CRE;
import edu.montana.gsoc.msusel.codetree.metrics.project.CTF;
import edu.montana.gsoc.msusel.codetree.metrics.project.FD;
import edu.montana.gsoc.msusel.codetree.metrics.project.FDE;
import edu.montana.gsoc.msusel.codetree.metrics.project.HM;
import edu.montana.gsoc.msusel.codetree.metrics.project.KE;
import edu.montana.gsoc.msusel.codetree.metrics.project.KE_KNCSL;
import edu.montana.gsoc.msusel.codetree.metrics.project.MHF;
import edu.montana.gsoc.msusel.codetree.metrics.project.MIF;
import edu.montana.gsoc.msusel.codetree.metrics.project.MIL;
import edu.montana.gsoc.msusel.codetree.metrics.project.MSC;
import edu.montana.gsoc.msusel.codetree.metrics.project.NC;
import edu.montana.gsoc.msusel.codetree.metrics.project.NCSL;
import edu.montana.gsoc.msusel.codetree.metrics.project.NCT;
import edu.montana.gsoc.msusel.codetree.metrics.project.NMCl;
import edu.montana.gsoc.msusel.codetree.metrics.project.NOH;
import edu.montana.gsoc.msusel.codetree.metrics.project.NOSLOC;
import edu.montana.gsoc.msusel.codetree.metrics.project.OLE;
import edu.montana.gsoc.msusel.codetree.metrics.project.PF;
import edu.montana.gsoc.msusel.codetree.metrics.project.PRC;
import edu.montana.gsoc.msusel.codetree.metrics.project.PRO;
import edu.montana.gsoc.msusel.codetree.metrics.project.RAD;
import edu.montana.gsoc.msusel.codetree.metrics.project.REM;
import edu.montana.gsoc.msusel.codetree.metrics.project.SRE;
import edu.montana.gsoc.msusel.codetree.metrics.project.SU;

/**
 * Class used to control which metrics are loaded and how they are executed.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class MetricsController {

    /**
     * CodeTree to which the metrics will be applied
     */
    private final CodeTree tree;
    /**
     * ForkJoinPool used to execute the metrics in a concurrent recursion.
     */
    private final ForkJoinPool forkJoinPool;

    /**
     * Constructs a new MetricsController for the given tree
     * 
     * @param tree
     *            CodeTree to execute metrics on
     */
    public MetricsController(final CodeTree tree)
    {
        this.tree = tree;
        forkJoinPool = new ForkJoinPool();
    }

    /**
     * @return Returns a set of all available type scoped metrics
     */
    synchronized List<Metric> getClassMetrics()
    {
        final List<Metric> metrics = Lists.newArrayList();

        metrics.add(AMS.getInstance());
        metrics.add(AMW.getInstance());
        metrics.add(APP.getInstance());
        metrics.add(ATFD.getInstance());
        metrics.add(BOvR.getInstance());
        metrics.add(BUR.getInstance());
        metrics.add(CAED.getInstance());
        metrics.add(CBO_IUB.getInstance());
        metrics.add(CBO_NA.getInstance());
        metrics.add(CBO_U.getInstance());
        metrics.add(CBO.getInstance());
        metrics.add(CC.getInstance());
        metrics.add(CCO.getInstance());
        metrics.add(CEC.getInstance());
        metrics.add(CLD.getInstance());
        metrics.add(CLM.getInstance());
        metrics.add(CLTD.getInstance());
        metrics.add(CMC.getInstance());
        metrics.add(Co.getInstance());
        metrics.add(Coh.getInstance());
        metrics.add(ComR.getInstance());
        metrics.add(CP.getInstance());
        metrics.add(CR.getInstance());
        metrics.add(CS.getInstance());
        metrics.add(CTA.getInstance());
        metrics.add(DAC.getInstance());
        metrics.add(DAM.getInstance());
        metrics.add(DAR.getInstance());
        metrics.add(DiAC.getInstance());
        metrics.add(DIT.getInstance());
        metrics.add(DS.getInstance());
        metrics.add(ENM.getInstance());
        metrics.add(ER.getInstance());
        metrics.add(EV.getInstance());
        metrics.add(FOC.getInstance());
        metrics.add(FTF.getInstance());
        metrics.add(HIT.getInstance());
        metrics.add(HNL.getInstance());
        metrics.add(ICH.getInstance());
        metrics.add(IDM.getInstance());
        metrics.add(IM.getInstance());
        metrics.add(INP.getInstance());
        metrics.add(IVMC.getInstance());
        metrics.add(LB.getInstance());
        metrics.add(LCC.getInstance());
        metrics.add(LCOM.getInstance());
        metrics.add(LCOM1.getInstance());
        metrics.add(LCOM2.getInstance());
        metrics.add(LCOM3.getInstance());
        metrics.add(LCOM4.getInstance());
        metrics.add(LCOM5.getInstance());
        metrics.add(LD.getInstance());
        metrics.add(LOC.getInstance());
        metrics.add(LOCC.getInstance());
        metrics.add(MAA.getInstance());
        metrics.add(MFA.getInstance());
        metrics.add(MM.getInstance());
        metrics.add(MPC.getInstance());
        metrics.add(NAC.getInstance());
        metrics.add(NAD.getInstance());
        metrics.add(NAS.getInstance());
        metrics.add(NCC.getInstance());
        metrics.add(NCM.getInstance());
        metrics.add(NCV.getInstance());
        metrics.add(NDC.getInstance());
        metrics.add(NEV.getInstance());
        metrics.add(NFM.getInstance());
        metrics.add(NIV.getInstance());
        metrics.add(NLM.getInstance());
        metrics.add(NMA.getInstance());
        metrics.add(NMI.getInstance());
        metrics.add(NMO.getInstance());
        metrics.add(NOAM.getInstance());
        metrics.add(NOC.getInstance());
        metrics.add(NOF.getInstance());
        metrics.add(NOM.getInstance());
        metrics.add(NOPA.getInstance());
        metrics.add(NOPM.getInstance());
        metrics.add(NOpV.getInstance());
        metrics.add(NOV.getInstance());
        metrics.add(NPA.getInstance());
        metrics.add(NPM.getInstance());
        metrics.add(NPrivProtM.getInstance());
        metrics.add(NProtM.getInstance());
        metrics.add(NPV.getInstance());
        metrics.add(NRA.getInstance());
        metrics.add(NUIV.getInstance());
        metrics.add(OM.getInstance());
        metrics.add(OPFS.getInstance());
        metrics.add(OQFS.getInstance());
        metrics.add(PCM.getInstance());
        metrics.add(PDA.getInstance());
        metrics.add(PIM.getInstance());
        metrics.add(PM.getInstance());
        metrics.add(PMR.getInstance());
        metrics.add(PNAS.getInstance());
        metrics.add(PPD.getInstance());
        metrics.add(PPM.getInstance());
        metrics.add(PR.getInstance());
        metrics.add(RFC_INF.getInstance());
        metrics.add(RFC.getInstance());
        metrics.add(SC.getInstance());
        metrics.add(SDC.getInstance());
        metrics.add(SEC.getInstance());
        metrics.add(SIX.getInstance());
        metrics.add(SIZE1.getInstance());
        metrics.add(SIZE2.getInstance());
        metrics.add(TCC.getInstance());
        metrics.add(WCS.getInstance());
        metrics.add(WMC.getInstance());
        metrics.add(WMSO.getInstance());
        metrics.add(WOC.getInstance());

        return metrics;
    }

    /**
     * @return A list of all module scoped metrics
     */
    public synchronized List<Metric> getComponentMetrics()
    {
        return Lists.newArrayList();
    }

    /**
     * @return A list of all method scoped metrics
     */
    synchronized List<Metric> getMethodMetrics()
    {
        final List<Metric> metrics = Lists.newArrayList();

        metrics.add(CDISP.getInstance());
        metrics.add(ChC.getInstance());
        metrics.add(ChM.getInstance());
        metrics.add(CINT.getInstance());
        metrics.add(ComR.getInstance());
        metrics.add(CYCLO.getInstance());
        metrics.add(FDP.getInstance());
        metrics.add(LAA.getInstance());
        metrics.add(MAXNESTING.getInstance());
        metrics.add(MCX.getInstance());
        metrics.add(NMC.getInstance());
        metrics.add(NMP.getInstance());
        metrics.add(NMS.getInstance());
        metrics.add(NOAV.getInstance());
        metrics.add(NOS.getInstance());
        metrics.add(NUP.getInstance());
        metrics.add(SLOC.getInstance());
        metrics.add(SMS.getInstance());

        return metrics;
    }

    /**
     * @return A list of all namespace scoped metrics
     */
    synchronized List<Metric> getPackageMetrics()
    {
        final List<Metric> metrics = Lists.newArrayList();

        metrics.add(Ca.getInstance());
        metrics.add(CDBC.getInstance());
        metrics.add(CDOC.getInstance());
        metrics.add(Ce.getInstance());
        metrics.add(edu.montana.gsoc.msusel.codetree.metrics.namespace.CF.getInstance());
        metrics.add(I.getInstance());
        metrics.add(PDAC.getInstance());

        return metrics;
    }

    /**
     * @return A list of all project scoped metrics
     */
    synchronized List<Metric> getSystemMetrics()
    {
        final List<Metric> metrics = Lists.newArrayList();

        metrics.add(AC.getInstance());
        metrics.add(ACX.getInstance());
        metrics.add(ADI.getInstance());
        metrics.add(AHF.getInstance());
        metrics.add(AIF.getInstance());
        metrics.add(ANIM.getInstance());
        metrics.add(ANIV.getInstance());
        metrics.add(APG.getInstance());
        metrics.add(AR.getInstance());
        metrics.add(ARS.getInstance());
        metrics.add(ASC.getInstance());
        metrics.add(BC.getInstance());
        metrics.add(CAN.getInstance());
        metrics.add(CBC.getInstance());
        metrics.add(edu.montana.gsoc.msusel.codetree.metrics.project.CC.getInstance());
        metrics.add(CF.getInstance());
        metrics.add(CRE.getInstance());
        metrics.add(CTF.getInstance());
        metrics.add(FD.getInstance());
        metrics.add(FDE.getInstance());
        metrics.add(edu.montana.gsoc.msusel.codetree.metrics.project.FTF.getInstance());
        metrics.add(HM.getInstance());
        metrics.add(KE_KNCSL.getInstance());
        metrics.add(KE.getInstance());
        metrics.add(edu.montana.gsoc.msusel.codetree.metrics.project.LOC.getInstance());
        metrics.add(MHF.getInstance());
        metrics.add(MIF.getInstance());
        metrics.add(MIL.getInstance());
        metrics.add(MSC.getInstance());
        metrics.add(NC.getInstance());
        metrics.add(NCSL.getInstance());
        metrics.add(NCT.getInstance());
        metrics.add(NMCl.getInstance());
        metrics.add(NOH.getInstance());
        metrics.add(NOSLOC.getInstance());
        metrics.add(OLE.getInstance());
        metrics.add(PF.getInstance());
        metrics.add(PRC.getInstance());
        metrics.add(PRO.getInstance());
        metrics.add(RAD.getInstance());
        metrics.add(REM.getInstance());
        metrics.add(SRE.getInstance());
        metrics.add(SU.getInstance());

        return metrics;
    }

    /**
     * Concurrently measures all metrics across each project node in the tree.
     */
    public void measureAllMetrics()
    {
        final Set<ProjectNode> systems = tree.getUtils().getProjects();

        for (final ProjectNode sys : systems)
        {
            forkJoinPool.invoke(new MetricRecorderAction(this, sys, tree));
        }
    }

    /**
     * Concurrently measures all type metrics across each type in the tree
     */
    public void measureClasses()
    {
        // TODO add implementation
    }

    /**
     * Concurrently measures all method name for all methods in the given
     * type.
     * 
     * @param entity
     *            Type whose methods are to be measured
     */
    public void measureMethods(final TypeNode entity)
    {
        // TODO add implementation
    }

    /**
     * Concurrently measures all namespace metrics for each namespace defined in
     * the system.
     */
    public void measurePackages()
    {
        // TODO add implementation
    }

    /**
     * Concurrently measures the entire system
     */
    public void measureSystem()
    {
        // TODO add implementation
    }
}
