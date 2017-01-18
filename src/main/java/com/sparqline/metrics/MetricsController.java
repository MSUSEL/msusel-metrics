package com.sparqline.metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import com.sparqline.graph.ProgramNode;
import com.sparqline.metrics.classmetrics.*;
import com.sparqline.metrics.field.IVMC;
import com.sparqline.metrics.method.CDISP;
import com.sparqline.metrics.method.CINT;
import com.sparqline.metrics.method.CYCLO;
import com.sparqline.metrics.method.ChC;
import com.sparqline.metrics.method.ChM;
import com.sparqline.metrics.method.FDP;
import com.sparqline.metrics.method.LAA;
import com.sparqline.metrics.method.MAXNESTING;
import com.sparqline.metrics.method.MCX;
import com.sparqline.metrics.method.NMC;
import com.sparqline.metrics.method.NMP;
import com.sparqline.metrics.method.NMS;
import com.sparqline.metrics.method.NOAV;
import com.sparqline.metrics.method.NOS;
import com.sparqline.metrics.method.NUP;
import com.sparqline.metrics.method.SLOC;
import com.sparqline.metrics.method.SMS;
import com.sparqline.metrics.packagemetrics.CDBC;
import com.sparqline.metrics.packagemetrics.CDOC;
import com.sparqline.metrics.packagemetrics.Ca;
import com.sparqline.metrics.packagemetrics.Ce;
import com.sparqline.metrics.packagemetrics.I;
import com.sparqline.metrics.packagemetrics.PDAC;
import com.sparqline.metrics.system.AC;
import com.sparqline.metrics.system.ACX;
import com.sparqline.metrics.system.ADI;
import com.sparqline.metrics.system.AHF;
import com.sparqline.metrics.system.AIF;
import com.sparqline.metrics.system.ANIM;
import com.sparqline.metrics.system.ANIV;
import com.sparqline.metrics.system.APG;
import com.sparqline.metrics.system.AR;
import com.sparqline.metrics.system.ARS;
import com.sparqline.metrics.system.ASC;
import com.sparqline.metrics.system.BC;
import com.sparqline.metrics.system.CAN;
import com.sparqline.metrics.system.CBC;
import com.sparqline.metrics.system.CF;
import com.sparqline.metrics.system.CRE;
import com.sparqline.metrics.system.CTF;
import com.sparqline.metrics.system.FD;
import com.sparqline.metrics.system.FDE;
import com.sparqline.metrics.system.HM;
import com.sparqline.metrics.system.KE;
import com.sparqline.metrics.system.KE_KNCSL;
import com.sparqline.metrics.system.MHF;
import com.sparqline.metrics.system.MIF;
import com.sparqline.metrics.system.MIL;
import com.sparqline.metrics.system.MSC;
import com.sparqline.metrics.system.NC;
import com.sparqline.metrics.system.NCSL;
import com.sparqline.metrics.system.NCT;
import com.sparqline.metrics.system.NMCl;
import com.sparqline.metrics.system.NOH;
import com.sparqline.metrics.system.NOSLOC;
import com.sparqline.metrics.system.OLE;
import com.sparqline.metrics.system.PF;
import com.sparqline.metrics.system.PRC;
import com.sparqline.metrics.system.PRO;
import com.sparqline.metrics.system.RAD;
import com.sparqline.metrics.system.REM;
import com.sparqline.metrics.system.SRE;
import com.sparqline.metrics.system.SU;
import com.sparqline.quamoco.codetree.CodeNode;
import com.sparqline.quamoco.codetree.CodeTree;
import com.sparqline.quamoco.codetree.TypeNode;

/**
 * @author Isaac Griffith
 */
public class MetricsController {

	/**
	 * 
	 */
	private final CodeTree tree;
	/**
	 * 
	 */
	private final ForkJoinPool forkJoinPool;

	/**
	 * @param tree
	 */
	public MetricsController(final CodeTree tree) {
		this.tree = tree;
		forkJoinPool = new ForkJoinPool();
	}

	/**
	 * @param entity
	 * @return
	 */
	public synchronized List<Metric> getClassMetrics(final CodeNode entity) {
		final List<Metric> metrics = new ArrayList<>();

		metrics.add(AMS.getInstance(entity, tree));
		metrics.add(AMW.getInstance(entity, tree));
		metrics.add(APP.getInstance(entity, tree));
		metrics.add(ATFD.getInstance(entity, tree));
		metrics.add(BOvR.getInstance(entity, tree));
		metrics.add(BUR.getInstance(entity, tree));
		metrics.add(CAED.getInstance(entity, tree));
		metrics.add(CBO_IUB.getInstance(entity, tree));
		metrics.add(CBO_NA.getInstance(entity, tree));
		metrics.add(CBO_U.getInstance(entity, tree));
		metrics.add(CBO.getInstance(entity, tree));
		metrics.add(CC.getInstance(entity, tree));
		metrics.add(CCO.getInstance(entity, tree));
		metrics.add(CEC.getInstance(entity, tree));
		metrics.add(CLD.getInstance(entity, tree));
		metrics.add(CLM.getInstance(entity, tree));
		metrics.add(CLTD.getInstance(entity, tree));
		metrics.add(CMC.getInstance(entity, tree));
		metrics.add(Co.getInstance(entity, tree));
		metrics.add(Coh.getInstance(entity, tree));
		metrics.add(ComR.getInstance(entity, tree));
		metrics.add(CP.getInstance(entity, tree));
		metrics.add(CR.getInstance(entity, tree));
		metrics.add(CS.getInstance(entity, tree));
		metrics.add(CTA.getInstance(entity, tree));
		metrics.add(DAC.getInstance(entity, tree));
		metrics.add(DAM.getInstance(entity, tree));
		metrics.add(DAR.getInstance(entity, tree));
		metrics.add(DiAC.getInstance(entity, tree));
		metrics.add(DIT.getInstance(entity, tree));
		metrics.add(DS.getInstance(entity, tree));
		metrics.add(ENM.getInstance(entity, tree));
		metrics.add(ER.getInstance(entity, tree));
		metrics.add(EV.getInstance(entity, tree));
		metrics.add(FOC.getInstance(entity, tree));
		metrics.add(FTF.getInstance(entity, tree));
		metrics.add(HIT.getInstance(entity, tree));
		metrics.add(HNL.getInstance(entity, tree));
		metrics.add(ICH.getInstance(entity, tree));
		metrics.add(IDM.getInstance(entity, tree));
		metrics.add(IM.getInstance(entity, tree));
		metrics.add(INP.getInstance(entity, tree));
		metrics.add(IVMC.getInstance(entity, tree));
		metrics.add(LB.getInstance(entity, tree));
		metrics.add(LCC.getInstance(entity, tree));
		metrics.add(LCOM.getInstance(entity, tree));
		metrics.add(LCOM1.getInstance(entity, tree));
		metrics.add(LCOM2.getInstance(entity, tree));
		metrics.add(LCOM3.getInstance(entity, tree));
		metrics.add(LCOM4.getInstance(entity, tree));
		metrics.add(LCOM5.getInstance(entity, tree));
		metrics.add(LD.getInstance(entity, tree));
		metrics.add(LOC.getInstance(entity, tree));
		metrics.add(LOCC.getInstance(entity, tree));
		metrics.add(MAA.getInstance(entity, tree));
		metrics.add(MFA.getInstance(entity, tree));
		metrics.add(MM.getInstance(entity, tree));
		metrics.add(MPC.getInstance(entity, tree));
		metrics.add(NAC.getInstance(entity, tree));
		metrics.add(NAD.getInstance(entity, tree));
		metrics.add(NAS.getInstance(entity, tree));
		metrics.add(NCC.getInstance(entity, tree));
		metrics.add(NCM.getInstance(entity, tree));
		metrics.add(NCV.getInstance(entity, tree));
		metrics.add(NDC.getInstance(entity, tree));
		metrics.add(NEV.getInstance(entity, tree));
		metrics.add(NFM.getInstance(entity, tree));
		metrics.add(NIV.getInstance(entity, tree));
		metrics.add(NLM.getInstance(entity, tree));
		metrics.add(NMA.getInstance(entity, tree));
		metrics.add(NMI.getInstance(entity, tree));
		metrics.add(NMO.getInstance(entity, tree));
		metrics.add(NOAM.getInstance(entity, tree));
		metrics.add(NOC.getInstance(entity, tree));
		metrics.add(NOF.getInstance(entity, tree));
		metrics.add(NOM.getInstance(entity, tree));
		metrics.add(NOPA.getInstance(entity, tree));
		metrics.add(NOPM.getInstance(entity, tree));
		metrics.add(NOpV.getInstance(entity, tree));
		metrics.add(NOV.getInstance(entity, tree));
		metrics.add(NPA.getInstance(entity, tree));
		metrics.add(NPM.getInstance(entity, tree));
		metrics.add(NProtM.getInstance(entity, tree));
		metrics.add(NPV.getInstance(entity, tree));
		metrics.add(NRA.getInstance(entity, tree));
		metrics.add(NUIV.getInstance(entity, tree));
		metrics.add(OM.getInstance(entity, tree));
		metrics.add(OPFS.getInstance(entity, tree));
		metrics.add(OQFS.getInstance(entity, tree));
		metrics.add(PCM.getInstance(entity, tree));
		metrics.add(PDA.getInstance(entity, tree));
		metrics.add(PIM.getInstance(entity, tree));
		metrics.add(PM.getInstance(entity, tree));
		metrics.add(PMR.getInstance(entity, tree));
		metrics.add(PNAS.getInstance(entity, tree));
		metrics.add(PPD.getInstance(entity, tree));
		metrics.add(PPM.getInstance(entity, tree));
		metrics.add(PR.getInstance(entity, tree));
		metrics.add(RFC_INF.getInstance(entity, tree));
		metrics.add(RFC.getInstance(entity, tree));
		metrics.add(SC.getInstance(entity, tree));
		metrics.add(SDC.getInstance(entity, tree));
		metrics.add(SEC.getInstance(entity, tree));
		metrics.add(SIX.getInstance(entity, tree));
		metrics.add(SIZE1.getInstance(entity, tree));
		metrics.add(SIZE2.getInstance(entity, tree));
		metrics.add(TCC.getInstance(entity, tree));
		metrics.add(WCS.getInstance(entity, tree));
		metrics.add(WMC.getInstance(entity, tree));
		metrics.add(WMSO.getInstance(entity, tree));
		metrics.add(WOC.getInstance(entity, tree));

		return metrics;
	}

	/**
	 * @param entity
	 * @return
	 */
	public synchronized List<Metric> getComponentMetrics(final ProgramNode entity) {
		final List<Metric> metrics = new ArrayList<>();

		return metrics;
	}

	/**
	 * @param entity
	 * @return
	 */
	public synchronized List<Metric> getMethodMetrics(final CodeNode entity) {
		final List<Metric> metrics = new ArrayList<>();

		metrics.add(CDISP.getInstance(entity, tree));
		metrics.add(ChC.getInstance(entity, tree));
		metrics.add(ChM.getInstance(entity, tree));
		metrics.add(CINT.getInstance(entity, tree));
		metrics.add(ComR.getInstance(entity, tree));
		metrics.add(CYCLO.getInstance(entity, tree));
		metrics.add(FDP.getInstance(entity, tree));
		metrics.add(LAA.getInstance(entity, tree));
		metrics.add(MAXNESTING.getInstance(entity, tree));
		metrics.add(MCX.getInstance(entity, tree));
		metrics.add(NMC.getInstance(entity, tree));
		metrics.add(NMP.getInstance(entity, tree));
		metrics.add(NMS.getInstance(entity, tree));
		metrics.add(NOAV.getInstance(entity, tree));
		metrics.add(NOS.getInstance(entity, tree));
		metrics.add(NUP.getInstance(entity, tree));
		metrics.add(SLOC.getInstance(entity, tree));
		metrics.add(SMS.getInstance(entity, tree));

		return metrics;
	}

	/**
	 * @param entity
	 * @return
	 */
	public synchronized List<Metric> getPackageMetrics(final ProgramNode entity) {
		final List<Metric> metrics = new ArrayList<>();

		metrics.add(Ca.getInstance(entity, tree));
		metrics.add(CDBC.getInstance(entity, tree));
		metrics.add(CDOC.getInstance(entity, tree));
		metrics.add(Ce.getInstance(entity, tree));
		metrics.add(com.sparqline.metrics.packagemetrics.CF.getInstance(entity, tree));
		metrics.add(I.getInstance(entity, tree));
		metrics.add(PDAC.getInstance(entity, tree));

		return metrics;
	}

	/**
	 * @param entity
	 * @return
	 */
	public synchronized List<Metric> getSystemMetrics(final CodeNode entity) {
		final List<Metric> metrics = new ArrayList<>();

		metrics.add(AC.getInstance(entity, tree));
		metrics.add(ACX.getInstance(entity, tree));
		metrics.add(ADI.getInstance(entity, tree));
		metrics.add(AHF.getInstance(entity, tree));
		metrics.add(AIF.getInstance(entity, tree));
		metrics.add(ANIM.getInstance(entity, tree));
		metrics.add(ANIV.getInstance(entity, tree));
		metrics.add(APG.getInstance(entity, tree));
		metrics.add(AR.getInstance(entity, tree));
		metrics.add(ARS.getInstance(entity, tree));
		metrics.add(ASC.getInstance(entity, tree));
		metrics.add(BC.getInstance(entity, tree));
		metrics.add(CAN.getInstance(entity, tree));
		metrics.add(CBC.getInstance(entity, tree));
		metrics.add(com.sparqline.metrics.system.CC.getInstance(entity, tree));
		metrics.add(CF.getInstance(entity, tree));
		metrics.add(CRE.getInstance(entity, tree));
		metrics.add(CTF.getInstance(entity, tree));
		metrics.add(FD.getInstance(entity, tree));
		metrics.add(FDE.getInstance(entity, tree));
		metrics.add(com.sparqline.metrics.system.FTF.getInstance(entity, tree));
		metrics.add(HM.getInstance(entity, tree));
		metrics.add(KE_KNCSL.getInstance(entity, tree));
		metrics.add(KE.getInstance(entity, tree));
		metrics.add(com.sparqline.metrics.system.LOC.getInstance(entity, tree));
		metrics.add(MHF.getInstance(entity, tree));
		metrics.add(MIF.getInstance(entity, tree));
		metrics.add(MIL.getInstance(entity, tree));
		metrics.add(MSC.getInstance(entity, tree));
		metrics.add(NC.getInstance(entity, tree));
		metrics.add(NCSL.getInstance(entity, tree));
		metrics.add(NCT.getInstance(entity, tree));
		metrics.add(NMCl.getInstance(entity, tree));
		metrics.add(NOH.getInstance(entity, tree));
		metrics.add(NOSLOC.getInstance(entity, tree));
		metrics.add(OLE.getInstance(entity, tree));
		metrics.add(PF.getInstance(entity, tree));
		metrics.add(PRC.getInstance(entity, tree));
		metrics.add(PRO.getInstance(entity, tree));
		metrics.add(RAD.getInstance(entity, tree));
		metrics.add(REM.getInstance(entity, tree));
		metrics.add(SRE.getInstance(entity, tree));
		metrics.add(SU.getInstance(entity, tree));

		return metrics;
	}

	/**
	 * @param metricName
	 * @param threshold
	 * @return
	 */
	public double lookUp(final String metricName, final DetectionThreshold threshold) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	public void measureAllMetrics() {
		final List<CodeNode> systems = tree.getSystems();

		for (final ProgramNode sys : systems) {
			forkJoinPool.invoke(new MetricRecorderAction(this, sys, tree));
		}
	}

	public void measureClasses() {
		// TODO add implementation
	}

	public void measureMethods(final TypeNode entity) {
		// TODO add implementation
	}

	public void measurePackages() {
		// TODO add implementation
	}

	public void measureSystem() {
		// TODO add implementation
	}
}
