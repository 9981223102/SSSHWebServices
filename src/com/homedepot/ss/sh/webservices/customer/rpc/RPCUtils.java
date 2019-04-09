package com.homedepot.ss.sh.webservices.customer.rpc;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		RPCUtils.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/RPCUtils.java_v   1.10   19 Nov 2004 15:46:20   rlp05  $
 */

// Base class(es)
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;

// Logging class(es)
import org.apache.log4j.Logger;

// SMUDGE RPC class(es)
import com.homedepot.ta.aa.JRPC.XDRSMUdec;
import com.homedepot.ta.aa.JRPC.XDRSMUdtime;

// Application class(es)
import com.homedepot.ss.sh.webservices.customer.AgentRecord;
import com.homedepot.ss.sh.webservices.customer.PhoneRecord;
import com.homedepot.ss.sh.webservices.customer.RentalRecord;
import com.homedepot.ss.sh.webservices.customer.ContactRecord;
import com.homedepot.ss.sh.webservices.customer.VhclInsrRecord;
import com.homedepot.ss.sh.webservices.customer.AddressRecord;
import com.homedepot.ss.sh.webservices.customer.TaxRuleRecord;
import com.homedepot.ss.sh.webservices.customer.TaxblStatRecord;
import com.homedepot.ss.sh.webservices.customer.DIYDetailRecord;
import com.homedepot.ss.sh.webservices.customer.CustomerRecord;
import com.homedepot.ss.sh.webservices.customer.PRODetailRecord;
import com.homedepot.ss.sh.webservices.customer.CustomerIdRecord;
import com.homedepot.ss.sh.webservices.customer.UnfvrRentalRecord;
import com.homedepot.ss.sh.webservices.customer.EmailAddressRecord;
import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;
import com.homedepot.ss.sh.webservices.customer.utils.CustomerApplLogMessage;
import com.homedepot.ss.sh.webservices.customer.db.CustomerDAO;
import com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;

/*
 * RPCUtils.java
 * 
 * Created: 	Aug 2, 2004
 * 
 * @author		Eric Crawford, Lane Putnel
 * @version	$Revision:   1.10  $	Last Updated: $Date:   19 Nov 2004 15:46:20  $
 * 
 * Utility functions to convert WebServices structures into SMUDGE RPC structures 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/RPCUtils.java_v  $
 * 
 *    Rev 1.10   19 Nov 2004 15:46:20   rlp05
 * modified to write specific message numbers to APPL_LOG for EMP monitoring
 * 
 *    Rev 1.9   24 Sep 2004 08:13:20   rlp05
 * wrote private function to get the hostname instead of having same code in multiple places to do it.
 * 
 *    Rev 1.8   23 Sep 2004 18:47:58   rlp05
 * modified code to only lookup hostname when it's needed for logging to APPL_LOG
 * 
 *    Rev 1.7   23 Sep 2004 18:41:00   rlp05
 * added code to lookup hostname for logging to APPL_LOG so that the box the exception occurred on can be identified
 * 
 *    Rev 1.6   10 Sep 2004 15:02:42   rlp05
 * modifed to support email collection code as a Short object instead of a short primitive
 * 
 *    Rev 1.5   08 Sep 2004 11:06:32   rlp05
 * fixed code so that vehicle insurance records would get inserted correctly.
 * 
 *    Rev 1.4   08 Sep 2004 08:50:46   rlp05
 * modified code to only convert timezone to GMT for datetime conversions
 * 
 *    Rev 1.3   07 Sep 2004 14:48:38   rlp05
 * modified code setting date/times again. GregorianCalendars work differently than Calendars do
 * 
 *    Rev 1.2   07 Sep 2004 10:53:12   rlp05
 * modified code to add offset back to time being inserted/updated.. GMT date/times aren't being handled gracefully
 * 
 *    Rev 1.1   03 Sep 2004 09:02:42   rlp05
 * modified function that converts Java date to Informix date to fix off by one day issue
 * 
 *    Rev 1.0   31 Aug 2004 13:47:48   rlp05
 * InitialRevision
 */
public class RPCUtils implements CustomerProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/RPCUtils.java_v   1.10   19 Nov 2004 15:46:20   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.10  $";
	

	/*
	 * Logger instance 
	 */
	private static Logger mLogger = Logger.getLogger(RPCUtils.class);
	
	/**
	 * populate the inbound insert RPC structure
	 * 
	 * @param inbArg				The RPC structure to populate				
	 * @param customer		Customer data
	 * @param locTypCd		Location type code
	 * @param locNbr				Location number
	 * @return							populated RPC structure
	 * @throws CustomerWebServiceException		Thrown if a data exception occurs
	 */
	public static shp825j.rpc_ins_thd_hcust_arg populateRPCInsStruct(shp825j.rpc_ins_thd_hcust_arg inbArg, 
		CustomerRecord customer, String locTypCd, String locNbr) throws CustomerWebServiceException
	{		
		// populate the customer header RPC structure
		inbArg.gr_str_svc_hcust_ib = populateRPCCustHdrStruct(customer);
		// populate the DIY customer detail RPC structure
		inbArg.gr_str_svc_indv_hcust_ib = populateRPCIndvCustStruct(customer);
		// populate the PRO customer detail RPC structure
		inbArg.gr_str_svc_org_hcust_ib = populateRPCOrgCustStruct(customer);
		// if the customer is a PRO customer that has agents
		if(customer.getPRODetailRecord() != null && customer.getPRODetailRecord().getAgents() != null)
		{
			// populate the agent RPC structures
			inbArg.ga_org_hcust_agnt_ib = populateRPCAgentStruct(customer);
			inbArg.ga_org_hcust_agnt_ib_nrec = new Integer(inbArg.ga_org_hcust_agnt_ib.length).shortValue();
		} // end if
		// if no customer address records were passed in, throw an exception
		
		//Tomcat Migration- TCS changes 08/10/2010
		
		if(customer.getAddrRecords() == null || customer.getAddrRecords().length == 0)
		{
					
		/*if(customer.getAddrRecords() == null || customer.getAddrRecords().length == 0)
		{*/
		
			mLogger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_INS_UPD), getHostName() + " : " + INS_NO_ADDR_RECS));
			throw new CustomerWebServiceException(EXC_CD_INS_UPD, INS_NO_ADDR_RECS);				
		} // end if
		// populat ethe customer address RPC structures
		inbArg.ga_str_svc_hcust_addr_ib = populateRPCAddrStruct(customer);
		inbArg.ga_str_svc_hcust_addr_ib_nrec = new Integer(inbArg.ga_str_svc_hcust_addr_ib.length).shortValue();
		// if no customer phone records were passed in, throw an exception
		
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getPhoneRecords() == null || customer.getPhoneRecords().length == 0)
		{
			/*if(customer.getPhoneRecords() == null || customer.getPhoneRecords().length == 0)
			{*/
			
			
			mLogger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_INS_UPD), getHostName() + " : " + INS_NO_PHN_RECS));
			throw new CustomerWebServiceException(EXC_CD_INS_UPD, INS_NO_PHN_RECS);	
		} // end if
		// populate the customer phone RPC structures
		inbArg.ga_str_svc_hcust_phn_ib = populateRPCPhnStruct(customer);
		inbArg.ga_str_svc_hcust_phn_ib_nrec = new Integer(inbArg.ga_str_svc_hcust_phn_ib.length).shortValue();
						
		// if email addresses were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getEmailAddrRecords() != null && customer.getEmailAddrRecords().length > 0)
		{
		
		/*if(customer.getEmailAddrRecords() != null && customer.getEmailAddrRecords().length > 0)
		{*/
		
			// populate the customer email RPC structures
			inbArg.ga_hcust_email_addr_ib = populateRPCEmailAddrStruct(customer);
			inbArg.ga_hcust_email_addr_ib_nrec = new Integer(inbArg.ga_hcust_email_addr_ib.length).shortValue();	
		} // end if
		
		// if customer id records were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		
		if(customer.getCustIdRecords() != null && customer.getCustIdRecords().length > 0)
		{
		/*if(customer.getCustIdRecords() != null && customer.getCustIdRecords().length > 0)
		{*/
			// populate the customer id RPC structures
			inbArg.ga_str_svc_hcust_id_ib = populateRPCCustIdStruct(customer);
			inbArg.ga_str_svc_hcust_id_ib_nrec = new Integer(inbArg.ga_str_svc_hcust_id_ib.length).shortValue();
		} // end if
		 
		// populate the Vehicle Insurance RPC structure
		inbArg.gr_hcust_vhcl_insr_ib = populateRPCVhclInsrStruct(customer);
		// populate the Taxbl Stat RPC structure
		inbArg.gr_hcust_taxbl_stat_ib = populateRPCTaxblStatStruct(customer);				
		
		// If tax rules were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getTaxRuleRecords() != null && customer.getTaxRuleRecords().length > 0)
		{
			
		/*if(customer.getTaxRuleRecords() != null && customer.getTaxRuleRecords().length > 0)
		{
		*/
			// populate the customer tax rule RPC structures
			inbArg.ga_hcust_tax_rul_ib = populateRPCTaxRuleStruct(customer);
			inbArg.ga_hcust_tax_rul_ib_nrec = new Integer(inbArg.ga_hcust_tax_rul_ib.length).shortValue();
		} // end if
		
		// if contact records were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getCntctRecords() != null && customer.getCntctRecords().length > 0)
		{
		/*if(customer.getCntctRecords() != null && customer.getCntctRecords().length > 0)
		{*/
			// populate the contact record RPC structures
			inbArg.ga_hcust_cntct_ib = populateRPCContactStruct(customer);
			inbArg.ga_hcust_cntct_ib_nrec = new Integer(inbArg.ga_hcust_cntct_ib.length).shortValue();
		} // end if
		
		// populate the customer rental detail RPC structure 
		inbArg.gr_rntl_hcust_dtl_ib = populateRPCRentalStruct(customer);
		
		// if the customer has rental detail and unfavorable rental records
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getRentalRecord() != null && customer.getRentalRecord().getUnfvrRactvyRecords() != null 
			&& customer.getRentalRecord().getUnfvrRactvyRecords().length > 0)
		{
		
		/*
		if(customer.getRentalRecord() != null && customer.getRentalRecord().getUnfvrRactvyRecords() != null 
			&& customer.getRentalRecord().getUnfvrRactvyRecords().length > 0)
		{
		*/	

			// populate the unfavorable rental RPC structures
			inbArg.ga_hcust_unfvr_ractvy_ib = populateRPCUnfvrRntlStruct(customer);
			inbArg.ga_hcust_unfvr_ractvy_ib_nrec = new Integer(inbArg.ga_hcust_unfvr_ractvy_ib.length).shortValue();
		} // end if
		
		// populate the inbound list RPC structure
		inbArg.gr_hcust_list_ib  = populateRPCCustListStruct(locTypCd, locNbr, customer);
		// create an inbound control block RPC structure		
		inbArg.gr_cc_appl_cb = new XDRgr_cc_appl_cb();
		// return the populated inbound RPC structure
		return inbArg;
	} //populateRPCInsStruct
	
	
	/**
	 * populate the inbound update RPC structure
	 * 
	 * @param inbArg				The RPC structure to populate				
	 * @param customer		Customer data
	 * @param locTypCd		Location type code
	 * @param locNbr				Location number
	 * @return							populated RPC structure
	 * @throws CustomerWebServiceException		Thrown if a data exception occurs
	 */
	public static shp825j.rpc_upd_thd_hcust_arg populateRPCUpdStruct(shp825j.rpc_upd_thd_hcust_arg inbArg, 
		CustomerRecord customer, String locTypCd, String locNbr) throws CustomerWebServiceException
	{		
		// populate the customer header RPC structure
		inbArg.gr_str_svc_hcust_ib = populateRPCCustHdrStruct(customer);
		// populate the DIY customer detail RPC structure
		inbArg.gr_str_svc_indv_hcust_ib = populateRPCIndvCustStruct(customer);
		// populate the PRO customer detail RPC structure
		inbArg.gr_str_svc_org_hcust_ib = populateRPCOrgCustStruct(customer);
		// if the customer is a PRO customer that has agents
		if(customer.getPRODetailRecord() != null && customer.getPRODetailRecord().getAgents() != null)
		{
			// populate the agent RPC structures
			inbArg.ga_org_hcust_agnt_ib = populateRPCAgentStruct(customer);
			inbArg.ga_org_hcust_agnt_ib_nrec = new Integer(inbArg.ga_org_hcust_agnt_ib.length).shortValue();
		} // end if
		// if no customer address records were passed in, throw an exception
		
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getAddrRecords() == null || customer.getAddrRecords().length == 0)
		{
		/*if(customer.getAddrRecords() == null || customer.getAddrRecords().length == 0)
		{*/
			mLogger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_INS_UPD), getHostName() + " : " + UPD_NO_ADDR_RECS));
			throw new CustomerWebServiceException(EXC_CD_INS_UPD, UPD_NO_ADDR_RECS);				
		} // end if
		// populat ethe customer address RPC structures
		inbArg.ga_str_svc_hcust_addr_ib = populateRPCAddrStruct(customer);
		inbArg.ga_str_svc_hcust_addr_ib_nrec = new Integer(inbArg.ga_str_svc_hcust_addr_ib.length).shortValue();
		// if no customer phone records were passed in, throw an exception
		
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getPhoneRecords() == null || customer.getPhoneRecords().length == 0)
		{
			/*if(customer.getPhoneRecords() == null || customer.getPhoneRecords().length == 0)
			}*/
		
			mLogger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_INS_UPD), getHostName() + " : " + UPD_NO_PHN_RECS));
			throw new CustomerWebServiceException(EXC_CD_INS_UPD, UPD_NO_PHN_RECS);	
		} // end if
		// populate the customer phone RPC structures
		inbArg.ga_str_svc_hcust_phn_ib = populateRPCPhnStruct(customer);
		inbArg.ga_str_svc_hcust_phn_ib_nrec = new Integer(inbArg.ga_str_svc_hcust_phn_ib.length).shortValue();
						
		// if email addresses were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getEmailAddrRecords() != null && customer.getEmailAddrRecords().length > 0)
		{
		
		/*if(customer.getEmailAddrRecords() != null && customer.getEmailAddrRecords().length > 0)
		{*/

			// populate the customer email RPC structures
			inbArg.ga_hcust_email_addr_ib = populateRPCEmailAddrStruct(customer);
			inbArg.ga_hcust_email_addr_ib_nrec = new Integer(inbArg.ga_hcust_email_addr_ib.length).shortValue();	
		} // end if
		
		// if customer id records were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getCustIdRecords() != null && customer.getCustIdRecords().length > 0)
		{
		/*if(customer.getCustIdRecords() != null && customer.getCustIdRecords().length > 0)
		{*/

			// populate the customer id RPC structures
			inbArg.ga_str_svc_hcust_id_ib = populateRPCCustIdStruct(customer);
			inbArg.ga_str_svc_hcust_id_ib_nrec = new Integer(inbArg.ga_str_svc_hcust_id_ib.length).shortValue();
		} // end if
		 
		// populate the Vehicle Insurance RPC structure
		inbArg.gr_hcust_vhcl_insr_ib = populateRPCVhclInsrStruct(customer);
		// populate the Taxbl Stat RPC structure
		inbArg.gr_hcust_taxbl_stat_ib = populateRPCTaxblStatStruct(customer);				
		
		// If tax rules were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getTaxRuleRecords() != null && customer.getTaxRuleRecords().length > 0)
		{
			
		/*if(customer.getTaxRuleRecords() != null && customer.getTaxRuleRecords().length > 0)
		{
		*/
			// populate the customer tax rule RPC structures
			inbArg.ga_hcust_tax_rul_ib = populateRPCTaxRuleStruct(customer);
			inbArg.ga_hcust_tax_rul_ib_nrec = new Integer(inbArg.ga_hcust_tax_rul_ib.length).shortValue();
		} // end if
		
		// if contact records were passed in
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getCntctRecords() != null && customer.getCntctRecords().length > 0)
		{
		/*if(customer.getCntctRecords() != null && customer.getCntctRecords().length > 0)
		{*/
			// populate the contact record RPC structures
			inbArg.ga_hcust_cntct_ib = populateRPCContactStruct(customer);
			inbArg.ga_hcust_cntct_ib_nrec = new Integer(inbArg.ga_hcust_cntct_ib.length).shortValue();
		} // end if
		
		// populate the customer rental detail RPC structure 
		inbArg.gr_rntl_hcust_dtl_ib = populateRPCRentalStruct(customer);
		
		// if the customer has rental detail and unfavorable rental records
		
		//Tomcat Migration- TCS changes 08/10/2010
		if(customer.getRentalRecord() != null && customer.getRentalRecord().getUnfvrRactvyRecords() != null 
			&& customer.getRentalRecord().getUnfvrRactvyRecords().length > 0)
		{
		/*
		if(customer.getRentalRecord() != null && customer.getRentalRecord().getUnfvrRactvyRecords() != null 
			&& customer.getRentalRecord().getUnfvrRactvyRecords().length > 0)
		{*/
			// populate the unfavorable rental RPC structures
			inbArg.ga_hcust_unfvr_ractvy_ib = populateRPCUnfvrRntlStruct(customer);
			inbArg.ga_hcust_unfvr_ractvy_ib_nrec = new Integer(inbArg.ga_hcust_unfvr_ractvy_ib.length).shortValue();
		} // end if
		
		// populate the inbound list RPC structure
		inbArg.gr_hcust_list_ib  = populateRPCCustListStruct(locTypCd, locNbr, customer);
		// create an inbound control block RPC structure		
		inbArg.gr_cc_appl_cb = new XDRgr_cc_appl_cb();
		// return the populated inbound RPC structure
		return inbArg;
	} // end populateRPCUpdStruct
		
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer			Customer data
	 * @return	SMUDGE object for the str_svc_hcust table
	 */
	private static XDRgr_str_svc_hcust_ib populateRPCCustHdrStruct(CustomerRecord customer)
	{
		// create the inbound RPC structure
		XDRgr_str_svc_hcust_ib ibRec = new XDRgr_str_svc_hcust_ib();
		// load the RPC structure with the customer data
		ibRec.str_svc_hcust_nbr = customer.getLocalCustNbr();
		ibRec.cust_typ_cd = customer.getCustTypCd();
		ibRec.cust_stat_cd = customer.getCustStatCd();
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*ibRec.cust_stat_eff_dt = dateToInformixDate(customer.getStatEffDt());*/
		ibRec.cust_stat_eff_dt = dateToInformixDate(customer.getStatEffDt().getTime());
		
		ibRec.cntct_meth_cd = customer.getCntctMethCd();
		ibRec.cntct_phn_typ_cd = customer.getCntctPhnCd();
		ibRec.cntct_addr_typ_cd = customer.getCntctAddrCd();
		ibRec.cntct_email_typ_cd = customer.getCntctEmailTypCd();
	
		String value = customer.getCntctWkBgnTm();
		// If the contact week begin time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
		ibRec.cntct_wk_bgn_tm = dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));
		
		value = customer.getCntctWkEndTm();
		// if the contact week end time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
		ibRec.cntct_wk_end_tm = dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));		
		
		value = customer.getCntctWkendBgnTm();
		// if the contact weekend begin time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
		ibRec.cntct_wknd_bgn_tm = dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));
				
		value = customer.getCntctWkendEndTm();
		// if the contact weekend end time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
		ibRec.cntct_wknd_end_tm = dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));
						
		ibRec.last_upd_user_id = customer.getLastUpdUserId();
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*ibRec.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		ibRec.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		// if the email_clt_cd is null, send in the informix null small int value
		//Tomcat Migration - Tcs Changes 08/12/2010
		ibRec.email_clt_cd = (customer.getEmailCltCd() == 0 ? N4MX_NULL_SMALL_INT : customer.getEmailCltCd());
		/*ibRec.email_clt_rqst_dt = dateToInformixDate(customer.getEmailCltRqstDt());*/
	//ibRec.email_clt_cd = (customer.getEmailCltCd()== 0 ? N4MX_NULL_SMALL_INT : customer.getEmailCltCd());
		/*ibRec.email_clt_rqst_dt = dateToInformixDate(customer.getEmailCltRqstDt());*/
		
		ibRec.email_clt_rqst_dt = dateToInformixDate(customer.getEmailCltRqstDt().getTime());
		

						
		return ibRec;
	} // end crtIbRPCCustHdrRec

	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	SMUDGE object for the str_svc_indv_hcust table
	 */	
	private static XDRgr_str_svc_indv_hcust_ib populateRPCIndvCustStruct(CustomerRecord customer)
	{
		// create the inbound RPC structure
		XDRgr_str_svc_indv_hcust_ib ibStruct = new XDRgr_str_svc_indv_hcust_ib();
		// populate the last_upd_timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		// get the DIY customer detail
		DIYDetailRecord diyDetail = customer.getDIYDetailRecord();
		// if the DIY customer detail isn't null, populate the rest of the RPC structure
		if(diyDetail != null)
		{
			ibStruct.str_svc_hcust_nbr = customer.getHostCustNbr();
			ibStruct.last_upd_user_id = customer.getLastUpdUserId();
			ibStruct.frst_nm = diyDetail.getFirstNm();
			ibStruct.mid_nm = diyDetail.getMiddleNm();
			ibStruct.last_nm = diyDetail.getLastNm();
			ibStruct.ttl_nm = diyDetail.getTitle();
			ibStruct.sfx_nm = diyDetail.getSuffix();
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibStruct.brth_dt = dateToInformixDate(diyDetail.getBirthDt());*/
			ibStruct.brth_dt = dateToInformixDate(diyDetail.getBirthDt().getTime());
			
			} // end if
		
		return ibStruct;		
	} // end crtIbRPCIndvCustRec
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	SMUDGE object for the str_svc_org_hcust table
	 */
	private static XDRgr_str_svc_org_hcust_ib populateRPCOrgCustStruct(CustomerRecord customer)
	{
		// create the inbound RPC structure
		XDRgr_str_svc_org_hcust_ib ibStruct = new XDRgr_str_svc_org_hcust_ib();		
		// load the last update timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		// get the PRO customer detail
		PRODetailRecord proDetail = customer.getPRODetailRecord();
		// if the PRO detail isn't null, populate the rest of the RPC structure		
		if(proDetail != null)
		{
			ibStruct.str_svc_hcust_nbr = customer.getHostCustNbr();		
			ibStruct.last_upd_user_id = customer.getLastUpdUserId();
			ibStruct.org_cust_nm = proDetail.getOrgNm();
			ibStruct.sic_cd = proDetail.getSICCd();
			ibStruct.fed_tax_id = proDetail.getFedTaxId();			
			ibStruct.tax_exmpt_flg = proDetail.getTaxExmptFlg();
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibStruct.tax_exmpt_upd_dt = dateToInformixDate(proDetail.getTaxExmptUpdDt());*/
			ibStruct.tax_exmpt_upd_dt = dateToInformixDate(proDetail.getTaxExmptUpdDt().getTime());
		} // end if
		
		return ibStruct;				
	} // end crtIbRPCOrgCustRec
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return 	Array of SMUDGE objects for the org_hcust_agnt table
	 */
	private static XDRga_org_hcust_agnt_ib[] populateRPCAgentStruct(CustomerRecord customer)
	{
		// get the agents from the customer record
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*AgentRecord[] agents = customer.getPRODetailRecord().getAgents();*/
		AgentRecord[] agents = customer.getPRODetailRecord().getAgents();
		
		// create an array of inbound RPC structures 
		XDRga_org_hcust_agnt_ib[] ibStructs = new XDRga_org_hcust_agnt_ib[agents.length];
		// iterate the agent array and populate the RPC structure
		for(int i = 0; i < ibStructs.length; i++)
		{
			// set the current array index to a new RPC structure
			ibStructs[i] = new XDRga_org_hcust_agnt_ib();
			ibStructs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
			ibStructs[i].last_upd_user_id = agents[i].getLastUpdUserId();
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibStructs[i].last_upd_ts = dt2IdtYr2Frac3(agents[i].getLastUpdTm());*/
			ibStructs[i].last_upd_ts = dt2IdtYr2Frac3(agents[i].getLastUpdTm().getTime());
			
			ibStructs[i].loc_typ_cd = agents[i].getLocTypCd();
			ibStructs[i].loc_nbr = agents[i].getLocNbr();
			ibStructs[i].seq_nbr = agents[i].getSeqNbr();
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibStructs[i].crt_ts = dt2IdtYr2Frac3(agents[i].getCrtTm());*/
			ibStructs[i].crt_ts = dt2IdtYr2Frac3(agents[i].getCrtTm().getTime());
			
			ibStructs[i].jursd_typ_cd = agents[i].getJursdTypCd();
			ibStructs[i].jursd_lvl_cd = agents[i].getJursdLvl();
			ibStructs[i].jursd_cd = agents[i].getJursdCd();
			ibStructs[i].cust_id_typ_cd = agents[i].getCustIdTypCd();
			ibStructs[i].cust_id_nbr = agents[i].getCustIdNbr();
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibStructs[i].cust_id_expir_dt = dateToInformixDate(agents[i].getCustIdExpDt());*/
			ibStructs[i].cust_id_expir_dt = dateToInformixDate(agents[i].getCustIdExpDt().getTime());
			
			ibStructs[i].frst_nm = agents[i].getFirstNm();
			ibStructs[i].mid_nm = agents[i].getMiddleNm();
			ibStructs[i].last_nm = agents[i].getLastNm();
			ibStructs[i].sfx_nm = agents[i].getSuffix();
			ibStructs[i].ttl_nm = agents[i].getTitle();
			ibStructs[i].actv_flg = agents[i].getActvFlg();
		} // end for		
		return ibStructs;
	} // end crtIbRPCAgentRecs
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param	customer		Customer data
	 * @return	Array of SMUDGE objects for the str_svc_hcust_addr table
	 */
	private static XDRga_str_svc_hcust_addr_ib[] populateRPCAddrStruct(CustomerRecord customer)
	{
		// get the customer address data
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*AddressRecord[] addrRecs = customer.getAddrRecords();*/
		AddressRecord[] addrRecs = customer.getAddrRecords();
		
		// create an array of inbound RPC structures
		XDRga_str_svc_hcust_addr_ib[] ibStructs = new XDRga_str_svc_hcust_addr_ib[addrRecs.length];	

		// get the last update user id
		String lastUpdUser = customer.getLastUpdUserId();
		// get the last update time
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		// iterate the address array and populate the RPC structures		
		for(int i = 0; i < ibStructs.length; i++)
		{
			// create a new inbound RPC structure in the current array index
			ibStructs[i] = new XDRga_str_svc_hcust_addr_ib();
			// populate the RPC structure
			ibStructs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
			ibStructs[i].last_upd_user_id = lastUpdUser;
			ibStructs[i].last_upd_ts = lastUpdDt;					
			ibStructs[i].cust_addr_typ_cd = addrRecs[i].getAddrTypCd();
			ibStructs[i].addr_line1_txt = addrRecs[i].getAddrLn1Txt();
			ibStructs[i].addr_line2_txt = addrRecs[i].getAddrLn2Txt();
			ibStructs[i].addr_line3_txt = addrRecs[i].getAddrLn3Txt();
			ibStructs[i].addr_line4_txt = addrRecs[i].getAddrLn4Txt();
			ibStructs[i].addr_line5_txt = addrRecs[i].getAddrLn5Txt();			
			ibStructs[i].city_nm = addrRecs[i].getCityNm();
			ibStructs[i].cnty_nm = addrRecs[i].getCntyNm();
			ibStructs[i].st_cd = addrRecs[i].getStCd();
			ibStructs[i].pstl_cd = addrRecs[i].getPstlCd();
			ibStructs[i].cntry_cd = addrRecs[i].getCntryCd();
			ibStructs[i].prim_addr_tax_flg = addrRecs[i].getPrimAddrTaxFlg();			
			ibStructs[i].ax_geo_cd  = addrRecs[i].getAxGeoCd();			
		} // end for
		return ibStructs;
	} // end populateRPCAddrRecs
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	Array of SMUDGE objects for the str_svc_hcust_phn table
	 */
	private static XDRga_str_svc_hcust_phn_ib[] populateRPCPhnStruct(CustomerRecord customer)
	{
		// get the customer phone number data
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*PhoneRecord[] phnRecs = customer.getPhoneRecords();*/
		PhoneRecord[] phnRecs = customer.getPhoneRecords();
		
		// create an array of inbound RPC structures
		XDRga_str_svc_hcust_phn_ib[] ibStructs = new XDRga_str_svc_hcust_phn_ib[phnRecs.length];
		// get the last updated user id
		String lastUpdUser = customer.getLastUpdUserId();
		// get the last updated timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
				
		// iterate the phone array and populate the inbound RPC array
		for(int i = 0; i < ibStructs.length; i++)
		{
			ibStructs[i] = new XDRga_str_svc_hcust_phn_ib();
			ibStructs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
			ibStructs[i].last_upd_user_id = lastUpdUser;
			ibStructs[i].last_upd_ts = lastUpdDt;
			ibStructs[i].phn_nbr_typ_cd = phnRecs[i].getPhnNbrTypCd();
			ibStructs[i].phn_area_city_cd = phnRecs[i].getPhnAreaCityCd();
			ibStructs[i].phn_locl_nbr = phnRecs[i].getPhnLoclNbr();
			ibStructs[i].phn_ext_nbr = phnRecs[i].getPhnExt();		
			ibStructs[i].phn_pin_nbr = phnRecs[i].getPhnPin();			
			ibStructs[i].cntry_cd = phnRecs[i].getCntryCd();
			ibStructs[i].pref_phn_flg = phnRecs[i].getPrefFlg();			
		} // end for
		
		return ibStructs;
	} // end populateRPCPhnRecs
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	Array of SMUDGE objects for the hcust_email_addr table
	 */
	private static XDRga_hcust_email_addr_ib[] populateRPCEmailAddrStruct(CustomerRecord customer)
	{
		// get the customer email address data
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*EmailAddressRecord[] emailRecs = customer.getEmailAddrRecords();*/
		EmailAddressRecord[] emailRecs = customer.getEmailAddrRecords();
		
		// create an array of inbound RPC structures
		XDRga_hcust_email_addr_ib[] ibStructs = new XDRga_hcust_email_addr_ib[emailRecs.length];
		// get the last updated user id
		String lastUpdUser = customer.getLastUpdUserId();
		// get the last updated timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		// iterate the email address array and populate the inbound RPC structure array				
		for(int i = 0; i < ibStructs.length; i++)
		{
			// create a new inbound RPC structure at this index in the array
			ibStructs[i] = new XDRga_hcust_email_addr_ib();
			ibStructs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
			ibStructs[i].last_upd_user_id = lastUpdUser;
			ibStructs[i].last_upd_ts = lastUpdDt;
			ibStructs[i].email_addr_typ_cd = emailRecs[i].getEmailAddrTypCd();
			ibStructs[i].email_addr_txt = emailRecs[i].getEmailAddrTxt();
			ibStructs[i].solct_flg = emailRecs[i].getSolicitFlg();			
		} // end for
		return ibStructs;
	} // end populateRPCEmailAddrStruct
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data	
	 * @return	Array of SMUDGE objects for the str_svc_hcust_id table
	 */
	private static XDRga_str_svc_hcust_id_ib[] populateRPCCustIdStruct(CustomerRecord customer)
	{
		// get the customer id data
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*CustomerIdRecord[] custIdRecs = customer.getCustIdRecords();*/
		CustomerIdRecord[] custIdRecs = customer.getCustIdRecords();
		
		// create an array of inbound RPC structures
		XDRga_str_svc_hcust_id_ib[] ibRecs = new XDRga_str_svc_hcust_id_ib[custIdRecs.length];
		// get the last updated user id
		String lastUpdUser = customer.getLastUpdUserId();
		// get the last updated timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		// iterate the customer id array and populate the RPC structure				
		for(int i = 0; i < ibRecs.length; i++)
		{
			// create a new RPC structure at this index in the array
			ibRecs[i] = new XDRga_str_svc_hcust_id_ib();
			ibRecs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
			ibRecs[i].last_upd_user_id = lastUpdUser;
			ibRecs[i].last_upd_ts = lastUpdDt;
			ibRecs[i].loc_typ_cd = custIdRecs[i].getLocTypCd();
			ibRecs[i].loc_nbr = custIdRecs[i].getLocNbr();
			ibRecs[i].seq_nbr = custIdRecs[i].getSeqNbr();
			ibRecs[i].cust_id_typ_cd = custIdRecs[i].getCustIdTypCd();
			ibRecs[i].cust_id_nbr = custIdRecs[i].getCustIdNbr();
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibRecs[i].cust_id_expir_dt = dateToInformixDate(custIdRecs[i].getCustIdExpDt());*/
			ibRecs[i].cust_id_expir_dt = dateToInformixDate(custIdRecs[i].getCustIdExpDt().getTime());
			
			ibRecs[i].jursd_typ_cd = custIdRecs[i].getJursdTypCd();
			ibRecs[i].jursd_lvl_cd = custIdRecs[i].getJursdLvl();
			ibRecs[i].jursd_cd = custIdRecs[i].getJursdCd();			
		} // end for
		return ibRecs;
	} // end populateRPCCustIdStruct

	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	SMUDGE object for the hcust_vhcl_insr table
	 */
	private static XDRgr_hcust_vhcl_insr_ib populateRPCVhclInsrStruct(CustomerRecord customer)
	{
		// create a new inbound RPC structure
		XDRgr_hcust_vhcl_insr_ib ibStruct = new XDRgr_hcust_vhcl_insr_ib();
		// populate the last updated timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		//  get the customer vehicle insurance record
		VhclInsrRecord insrRec = customer.getVhclInsrRecord();
		// if the vehicle insurance record isn't null, populate the rest of the inbound RPC structure
		if(insrRec != null)
		{
			ibStruct.str_svc_hcust_nbr = customer.getLocalCustNbr();
			ibStruct.last_upd_user_id = customer.getLastUpdUserId();
			ibStruct.insr_plcy_nbr = insrRec.getPlcyNbr();
			ibStruct.insr_prvdr_nm = insrRec.getPrvdrNm();
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibStruct.insr_plcy_expir_dt = dateToInformixDate(insrRec.getPlcyExpDt());*/
			ibStruct.insr_plcy_expir_dt = dateToInformixDate(insrRec.getPlcyExpDt().getTime());
			
			ibStruct.phn_area_city_cd = insrRec.getPhnAreaCityCd();
			ibStruct.phn_locl_nbr = insrRec.getPhnLoclNbr();
			ibStruct.phn_ext_nbr = insrRec.getPhnExt();
		} // end if
		return ibStruct;
	} // end populateRPCVhclInsrStruct
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	SMUDGE object for the hcust_taxbl_stat table
	 */
	private static XDRgr_hcust_taxbl_stat_ib populateRPCTaxblStatStruct(CustomerRecord customer)
	{
		// create the inbound RPC structure
		XDRgr_hcust_taxbl_stat_ib ibStruct = new XDRgr_hcust_taxbl_stat_ib();
		// get the taxbl stat data from the customer record
		TaxblStatRecord taxblStat = customer.getTaxblStatRecord();
		// set the last updated timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());

		// if the taxbl stat data isn't null, populate the rest of the inbound RPC structure
		if(taxblStat != null)
		{	
			ibStruct.str_svc_hcust_nbr = customer.getLocalCustNbr();
			ibStruct.last_upd_user_id = customer.getLastUpdUserId();
			ibStruct.taxbl_stat_cd = taxblStat.getTaxblStatCd();
			ibStruct.tax_pay_agree_cd = taxblStat.getTaxPayAgreeCd();
		} // end if
		
		return ibStruct;
	} // end populateRPCTaxblStatStruct
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	Array of SMUDGE objects for the hcust_tax_rul table
	 * @throws CustomerWebServiceException	Thrown if an exception is encountered
	 * 		setting the tax exemption amount/percentage values
	 */
	private static XDRga_hcust_tax_rul_ib[] populateRPCTaxRuleStruct(CustomerRecord customer)
		throws CustomerWebServiceException
	{
		// get the customer tax rule data
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*TaxRuleRecord[] taxRules = customer.getTaxRuleRecords();*/
		TaxRuleRecord[] taxRules = customer.getTaxRuleRecords();
		
		// create an array of inbound RPC structures
		XDRga_hcust_tax_rul_ib[] ibStructs = new XDRga_hcust_tax_rul_ib[taxRules.length];
		// get the last updated user id
		String lastUpdUser = customer.getLastUpdUserId();
		// get the last updated timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		
		try
		{
			// iterate the tax rule array and populate the inbound RPC array
			for(int i = 0; i < ibStructs.length; i++)
			{
				// create a new RPC structure at this element in the array
				ibStructs[i] = new XDRga_hcust_tax_rul_ib();
				ibStructs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
				ibStructs[i].last_upd_user_id = lastUpdUser;
				ibStructs[i].last_upd_ts = lastUpdDt;
				ibStructs[i].loc_typ_cd = taxRules[i].getLocTypCd();
				ibStructs[i].loc_nbr = taxRules[i].getLocNbr();
				ibStructs[i].seq_nbr = taxRules[i].getSeqNbr();
				ibStructs[i].jursd_typ_cd = taxRules[i].getJursdTypCd();
				ibStructs[i].jursd_lvl_cd = taxRules[i].getJursdLvl();
				ibStructs[i].jursd_cd = taxRules[i].getJursdCd();
				ibStructs[i].tax_exmpt_actv_flg = taxRules[i].getTaxExmptActvFlg();
				ibStructs[i].tax_paymt_auth_flg = taxRules[i].getTaxPaymtAuthFlg();
				ibStructs[i].tax_typ_cd = taxRules[i].getTaxTyp();
				ibStructs[i].tax_cd = taxRules[i].getTaxCd();
				
				//Tomcat Migration - Tcs Changes 08/12/2010
				/*ibStructs[i].eff_bgn_dt = dateToInformixDate(taxRules[i].getEffBgnDt());
				ibStructs[i].eff_end_dt = dateToInformixDate(taxRules[i].getEffEndDt());*/
				ibStructs[i].eff_bgn_dt = dateToInformixDate(taxRules[i].getEffBgnDt().getTime());
				ibStructs[i].eff_end_dt = dateToInformixDate(taxRules[i].getEffEndDt().getTime());
				
				ibStructs[i].tax_exmpt_amt = new XDRSMUdec(taxRules[i].getTaxExmptAmt());
				ibStructs[i].tax_exmpt_pct = new XDRSMUdec(taxRules[i].getTaxExmptPct());
			} // end if
		} // end try
		catch(InstantiationException ie)
		{	
			mLogger.warn("An exception occurred setting the tax exemption amount/percentage for a customer tax rule", ie);
			throw new CustomerWebServiceException(EXC_CD_INV_AMT_PCT);
		} // end catch					
		return ibStructs;
	} // end populateRPCTaxRuleStruct
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	Array of SMUDGE objects for the hcust_cntct table
	 */
	private static XDRga_hcust_cntct_ib[] populateRPCContactStruct(CustomerRecord customer)
	{
		// get the customer contact data
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*ContactRecord[] cntctRecs = customer.getCntctRecords();*/
		ContactRecord[] cntctRecs = customer.getCntctRecords();
		
		// create an array of inbound RPC structures
		XDRga_hcust_cntct_ib[] ibStructs = new XDRga_hcust_cntct_ib[cntctRecs.length];
		// get the last updated user id
		String lastUpdUser = customer.getLastUpdUserId();
		// get the last updated timestamp
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
		XDRSMUdtime lastUpdDt = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
		
		// iterate the array of contact data and populate the inbound RPC structures
		for(int i = 0; i < ibStructs.length; i++)
		{
			// create a new inbound RPC structure at this index in the array
			ibStructs[i] = new XDRga_hcust_cntct_ib();
			ibStructs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
			ibStructs[i].last_upd_user_id = lastUpdUser;
			ibStructs[i].last_upd_ts = lastUpdDt;
			ibStructs[i].cntct_hcust_nbr = cntctRecs[i].getCntctHostCustNbr();
			ibStructs[i].loc_typ_cd = cntctRecs[i].getLocTypCd();
			ibStructs[i].loc_nbr = cntctRecs[i].getLocNbr();
			ibStructs[i].seq_nbr = cntctRecs[i].getSeqNbr();
			ibStructs[i].cntct_meth_cd = cntctRecs[i].getCntctMethCd();
			ibStructs[i].cntct_addr_typ_cd = cntctRecs[i].getCntctAddrCd();
			ibStructs[i].cntct_phn_typ_cd = cntctRecs[i].getCntctPhnCd();
			ibStructs[i].cntct_email_typ_cd = cntctRecs[i].getCntctEmailTypCd();
			
			String value = customer.getCntctWkBgnTm();
			// If the contact week begin time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
			ibStructs[i].cntct_wk_bgn_tm = dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));
		
			value = customer.getCntctWkEndTm();
			// If the contact week end time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
			ibStructs[i].cntct_wk_end_tm= dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));
		
			value = customer.getCntctWkendBgnTm();
			// If the contact weekend begin time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
			ibStructs[i].cntct_wknd_bgn_tm = dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));
				
			value = customer.getCntctWkendEndTm();
			// If the contact weekend end time is null or empty, create a null dtime, otherwise create a dtime structure from the value sent in
			ibStructs[i].cntct_wknd_end_tm = dt2IdtHour2Fract3((value == null || value.trim().length() == 0 ? null : MyTime.valueOf(value)));

			ibStructs[i].actv_flg = cntctRecs[i].getActvFlg();
			ibStructs[i].agnt_loc_typ_cd = cntctRecs[i].getAgntLocTypCd();
			ibStructs[i].agnt_loc_nbr = cntctRecs[i].getAgntLocNbr();
			ibStructs[i].agnt_seq_nbr = cntctRecs[i].getAgntSeqNbr();			
		} // end for
		return ibStructs;
	} // end populateRPCContactStruct
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	SMUDGE object for the rntl_hcust_dtl table
	 * @throws CustomerWebServiceException	Thrown if an exception is encountered
	 * 		setting the lifetime rental amount
	 */
	private static XDRgr_rntl_hcust_dtl_ib populateRPCRentalStruct(CustomerRecord customer)
		throws CustomerWebServiceException
	{
		// create the inbound RPC structure
		XDRgr_rntl_hcust_dtl_ib ibStruct = new XDRgr_rntl_hcust_dtl_ib();

		try
		{	
			// set the last updated timestamp	
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm());*/
			ibStruct.last_upd_ts = dt2IdtYr2Frac3(customer.getLastUpdTm().getTime());
			
			// default to 0.00d					
			ibStruct.ltd_rntl_amt = new XDRSMUdec(0.00d);
			// get the customer rental data
			RentalRecord rentalRecord = customer.getRentalRecord();
			// if the rental record isn't null, populate the rest of the RPC structure
			if(rentalRecord != null)
			{		
				ibStruct.str_svc_hcust_nbr = customer.getLocalCustNbr();
				ibStruct.cust_stat_cd= rentalRecord.getRntlCustStatCd();
				ibStruct.dflt_depst_meth_cd = rentalRecord.getDfltDpstMeth();
				ibStruct.dmg_wvr_reqd_flg = rentalRecord.getDmgWvrReqdFlg();
				ibStruct.cust_po_reqd_flg = rentalRecord.getCustPOReqdFlg();
				ibStruct.job_site_reqd_flg = rentalRecord.getJobSiteReqdFlg();
				ibStruct.ltd_rntl_cnt = rentalRecord.getLtdRntlCnt();	
				ibStruct.ltd_rntl_amt = new XDRSMUdec(rentalRecord.getLtdRntlAmt());
				
				//Tomcat Migration - Tcs Changes 08/12/2010
				/*ibStruct.cust_last_rntl_dt = dateToInformixDate(rentalRecord.getCustLastRntlDt());
				ibStruct.tax_exmpt_upd_dt = dateToInformixDate(rentalRecord.getRntlTaxExmptUpdDt());*/
				ibStruct.cust_last_rntl_dt = dateToInformixDate(rentalRecord.getCustLastRntlDt().getTime());
				ibStruct.tax_exmpt_upd_dt = dateToInformixDate(rentalRecord.getRntlTaxExmptUpdDt().getTime());
				
				ibStruct.fed_tax_id = rentalRecord.getRntlFedTaxId();
				ibStruct.last_upd_user_id = customer.getLastUpdUserId();
			} // end if
		} // end try
		catch(InstantiationException ie)
		{	
			mLogger.warn("An exception occurred setting the lifetime rental amount for customer rental record", ie);
			throw new CustomerWebServiceException(EXC_CD_INV_AMT_PCT);
		} // end catch	
		
		return ibStruct;
	} // end populateRPCRentalStruct
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param 	customer		Customer data
	 * @return	Array of SMUDGE objects for the hcust_unfvr_ractvy table
	 * @throws CustomerWebServiceException	Thrown if an exception is encountered
	 * 		setting the tax exemption amount/percentage
	 */
	private static XDRga_hcust_unfvr_ractvy_ib[] populateRPCUnfvrRntlStruct(CustomerRecord customer)
		throws CustomerWebServiceException
	{
		// get the unfavorable rental data 
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*UnfvrRentalRecord[] unfvrRecs = customer.getRentalRecord().getUnfvrRactvyRecords();*/
		UnfvrRentalRecord[] unfvrRecs = customer.getRentalRecord().getUnfvrRactvyRecords();
		
		// create an array of inbound RPC structures
		XDRga_hcust_unfvr_ractvy_ib[] ibStructs = new XDRga_hcust_unfvr_ractvy_ib[unfvrRecs.length];
		// iterate the unfavorable rental records and populate the inbound RPC array
		for(int i = 0; i < unfvrRecs.length; i++)
		{
			try
			{
				// create a new inbound RPC structure in this element of the array
				ibStructs[i] = new XDRga_hcust_unfvr_ractvy_ib();
				ibStructs[i].str_svc_hcust_nbr = customer.getHostCustNbr();
				ibStructs[i].loc_typ_cd = unfvrRecs[i].getLocTypCd();
				ibStructs[i].loc_nbr = unfvrRecs[i].getLocNbr();
				ibStructs[i].loc_nm = unfvrRecs[i].getLocName();
				ibStructs[i].ragree_nbr = unfvrRecs[i].getRntlAgrmntNbr();
				ibStructs[i].rpgm_phn_acty_cd = unfvrRecs[i].getRpgmPhnAreaCd();
				ibStructs[i].rpgm_phn_locl_nbr = unfvrRecs[i].getRpgmPhnLoclNbr();
				ibStructs[i].rpgm_phn_ext_nbr = unfvrRecs[i].getRpgmPhnExt();
				ibStructs[i].unfvr_ractvy_cd = unfvrRecs[i].getUnfvrRactvyCd();
				
				//Tomcat Migration - Tcs Changes 08/12/2010
				/*ibStructs[i].rsltn_dt = dateToInformixDate(unfvrRecs[i].getResDt());
				ibStructs[i].ragree_cls_dt = dateToInformixDate(unfvrRecs[i].getRntlAgrmntCloseDt());*/
				ibStructs[i].rsltn_dt = dateToInformixDate(unfvrRecs[i].getResDt().getTime());
				ibStructs[i].ragree_cls_dt = dateToInformixDate(unfvrRecs[i].getRntlAgrmntCloseDt().getTime());
				
				ibStructs[i].unfvr_ractvy_amt = new XDRSMUdec(unfvrRecs[i].getUnfvrRactvyAmt());
				ibStructs[i].last_upd_user_id = unfvrRecs[i].getLastUpdUserId();
				
				//Tomcat Migration - Tcs Changes 08/12/2010
				/*ibStructs[i].last_upd_ts = dt2IdtYr2Frac3(unfvrRecs[i].getLastUpdTm());*/
				ibStructs[i].last_upd_ts = dt2IdtYr2Frac3(unfvrRecs[i].getLastUpdTm().getTime());
				
			} // end try
			catch(InstantiationException ie)
			{	
				mLogger.warn("An exception occurred setting the tax exemption amount/percentage for customer unfavorable rental record", ie);
				throw new CustomerWebServiceException(EXC_CD_INV_AMT_PCT);
			} // end catch					
		} // end for
		return ibStructs;
	} // end populateRPCUnfvrRntlStruct
	
	/**
	 * Create inbound customer SMUDGE object
	 * 
	 * @param locTypCd			Location type code
	 * @param locNbr					Location number
	 * @param customer			Customer data
	 * @return								SMUDGE object containing local customer number, location type, and location number
	 */
	private static XDRgr_hcust_list_ib populateRPCCustListStruct(String locTypCd, String locNbr, 
		CustomerRecord customer)
	{
		// create the inbound RPC structure
		XDRgr_hcust_list_ib ibStruct = new XDRgr_hcust_list_ib();
		// populate the inbound RPC structure
		ibStruct.str_nbr = locNbr;
		ibStruct.loc_typ_cd = locTypCd;
		ibStruct.str_svc_hcust_nbr = customer.getHostCustNbr();
		ibStruct.str_svc_lcust_nbr = customer.getLocalCustNbr();
		
		return	ibStruct; 
	} // end populateRPCCustListStruct
	
	private static String getHostName()
	{
		String hostName = "";
		
		try
		{
			hostName = InetAddress.getLocalHost().getHostName();
		} // end try
		catch(UnknownHostException uhe)
		{
			/*
			 * do nothing, this function will only be used in exception cases
			 * so the hostname can be appended to the beginning of 
			 * APPL_LOG messages.
			 */
		} // end catch
		
		return hostName;
	} // end getHostName

	/*
	 * Convert java.util.Date to integer for transmission to Informix RPC server
	 *  
	 * @param date		Date to convert
	 * @return					int representation of the java.util.Date. This value is the number of
	 * 								days since 12/21/1899. If the date is null this value is -2147483648 which is interpreted
	 * 								by the Informix RPC server as null
	 */
	private static int dateToInformixDate(Date date)
	{
		int numOfDays = 0;
		
		if(date == null)
		{
			numOfDays = N4MX_NULL_DATE;
		} // end if
		else
		{		
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);

			int currYear = calendar.get(Calendar.YEAR);
			int currMonth = calendar.get(Calendar.MONTH);
			int currDay = calendar.get(Calendar.DATE);
			int numOfYears = 0;
			
			// if the date passed in is after the baseline date of 12/31/1899
			if(N4MX_BASELINE_DATE.before(calendar))
			{
				 numOfYears = currYear - N4MX_EPOCH_YEAR;
				 // if the number of years is > 0, the date passed in is not 12/31/1899 with a time other than 00:00:00
				 if(numOfYears > 0)
				 {
				 	// iterate the number of full years, less the current one and add the total number of days
				 	for(int i = (N4MX_EPOCH_YEAR + 1); i < currYear; i++)
				 	{
				 		numOfDays += DAYS_PER_YEAR;
				 		// if the current year is a leap year, add an extra day
				 		if(calendar.isLeapYear(i))
				 		{
				 			numOfDays += LEAP_YEAR_DAY;
				 		} // end if
				 	} // end for
				 	
				 	// iterate the number of completed months in the current year and add days
				 	for(int i = Calendar.JANUARY; i < currMonth; i++)
				 	{
				 		switch(i)
				 		{
							case Calendar.JANUARY:
							case Calendar.MARCH:
							case Calendar.MAY:
							case Calendar.JULY:
							case Calendar.AUGUST:
							case Calendar.OCTOBER:
							case Calendar.DECEMBER:
							{
								numOfDays += NUM_OF_DAYS_LONG_MTH;
								break;
							} // end case
							case Calendar.APRIL:
							case Calendar.JUNE:
							case Calendar.SEPTEMBER:
							case Calendar.NOVEMBER:
							{
								numOfDays += NUM_OF_DAYS_SHORT_MTH;
								break;							
							} // end case
							case Calendar.FEBRUARY:
							{
								numOfDays += NUM_OF_DAYS_FEB;							
								if(calendar.isLeapYear(currYear))
								{
									numOfDays += LEAP_YEAR_DAY;
								} // end if								
								break;							
							} // end case
				 		} // end switch
				 	} // end for
				 	
				 	// add the number of days passed in the current month
				 	numOfDays += currDay;
				 } // end if
			} // end if
			else if(N4MX_BASELINE_DATE.after(calendar))
			{
				numOfYears = N4MX_EPOCH_YEAR - currYear;			
				// if the number of years != 0, add the number of days in 1899 minus the N4MX_EPOCH_DATE
				if(numOfYears != 0)
				{
					numOfDays -= (DAYS_PER_YEAR - 1);
				} // end if
				
				// iterate the years from the current year + 1to the year before N4MX_EPOCH_YEAR and subtract days 
				for(int i = (currYear + 1); i < N4MX_EPOCH_YEAR; i++)
				{
					numOfDays -= DAYS_PER_YEAR;
					
					// if the current year is a leap year add an additional day
					if(calendar.isLeapYear(i))
					{
						numOfDays -= LEAP_YEAR_DAY;
					} // end if
				} // end for
				
				// iterate the months > than the current month and add the number of days to them
				for(int i = Calendar.DECEMBER; i > currMonth; i--)
				{
					switch(i)
					{
						case Calendar.JANUARY:
						case Calendar.MARCH:
						case Calendar.MAY:
						case Calendar.JULY:
						case Calendar.AUGUST:
						case Calendar.OCTOBER:
						case Calendar.DECEMBER:
						{
							numOfDays -= NUM_OF_DAYS_LONG_MTH;
							break;
						} // end case
						case Calendar.APRIL:
						case Calendar.JUNE:
						case Calendar.SEPTEMBER:
						case Calendar.NOVEMBER:
						{
							numOfDays -= NUM_OF_DAYS_SHORT_MTH;
							break;							
						} // end case
						case Calendar.FEBRUARY:
						{
							numOfDays -= NUM_OF_DAYS_FEB;
							// if the current year is a leap year, add an additional day							
							if(calendar.isLeapYear(currYear))
							{
								numOfDays -= LEAP_YEAR_DAY;
							} // end if								
							break;							
						} // end case
					} // end switch
				} // end for								
				
				// add the number of days from the current date until the end of the month
				switch(currMonth)
				{
					case Calendar.JANUARY:
					case Calendar.MARCH:
					case Calendar.MAY:
					case Calendar.JULY:
					case Calendar.AUGUST:
					case Calendar.OCTOBER:
					case Calendar.DECEMBER:
					{
						numOfDays -= (NUM_OF_DAYS_LONG_MTH - currDay);
						break;
					} // end case
					case Calendar.APRIL:
					case Calendar.JUNE:
					case Calendar.SEPTEMBER:
					case Calendar.NOVEMBER:
					{
						numOfDays -= (NUM_OF_DAYS_SHORT_MTH - currDay);
						break;							
					} // end case
					case Calendar.FEBRUARY:
					{
						numOfDays -= (NUM_OF_DAYS_FEB - currDay);
						// if the current year is a leap year, add an additional day							
						if(calendar.isLeapYear(currYear))
						{
							numOfDays -= LEAP_YEAR_DAY;
						} // end if								
						break;							
					} // end case
				} // end switch				
				
			} // end else if
		} // end else
		
		return numOfDays;
	} // end dateToInformixDate
	
	/**
	 * Implementation of Time class that initializes month, date, and year to the
	 * current date instead of the epic date (1/1/1970)
	 */
	static class MyTime extends Date
	{
		/**
		 * Constructor
		 * 
		 * @param hour					hour
		 * @param minute			minute
		 * @param second			second
		 */
		public MyTime(int hour, int minute, int second)
		{
			super();
			Calendar calendar = Calendar.getInstance();
			GregorianCalendar gc = new GregorianCalendar(calendar.get(Calendar.YEAR), 
				calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), hour, minute, second);
			setTime(gc.getTime().getTime());
		} // end constructor

		/**
		 * Create MyTime instance from a String
		 * 
		 * @param string		Time value
		 * @return					MyTime implementation of stringTime
		 */
		public static MyTime valueOf(String stringTime)
		{
			int hour;
			int minute;
			int second;
			int firstColon;
			int secondColon;

			if (stringTime == null) throw new java.lang.IllegalArgumentException();

			firstColon = stringTime.indexOf(':');
			secondColon = stringTime.indexOf(':', firstColon+1);
			
			if ((firstColon > 0) & (secondColon > 0) & (secondColon < stringTime.length()-1)) 
			{
				hour = Integer.parseInt(stringTime.substring(0, firstColon));
				minute = Integer.parseInt(stringTime.substring(firstColon+1, secondColon));
				second = Integer.parseInt(stringTime.substring(secondColon+1));
			} // end if 
			else 
			{
				throw new java.lang.IllegalArgumentException();
			} // end else

			return new MyTime(hour, minute, second);
		} // end valueOf
	} // end MyTime	

	/**
	 * @author elc03 Eric Crawford
	 *
	 * @return end time unit in datetime qualifier
	 */
	private static int endTimeUnit(int qual)
	{
		return (qual & 15);
	}

	/**
	 * @author elc03 Eric Crawford
	 *
	 * @return start time unit in datetime qualifier
	 */
	private static int startTimeUnit(int qual)
	{
		return ((qual >> 4) & 15);
	}	


	/** 
	 * @author elc03 Eric Crawford
	 * 
	 * Converts a java.util.Date to a SMUDGE compliant implementation
	 * of an Informix DATETIME YEAR TO FRACTION(3)
	 * 
	 *
	 * @param dt the java.util.Date to be converted to an Informix DATETIME YEAR TO FRACTION(3)
	 * @return a SMUDGE compliant implementation of an Informix DATETIME YEAR TO FRACTION(3)
	 */
	public static XDRSMUdtime dt2IdtYr2Frac3(Date dt)
	{
		return dt2idt(dt, (short) 4365);
	}

	/**
	 * @author elc03 Eric Crawford
	 * 
	 * Converts a java.util.Date to a SMUDGE compliant implementation
	 * of an Informix DATETIME MINUTE TO FRACTION(3)
	 * 
	 * @param dt the java.util.Date to be converted to an Informix DATETIME MINUTE TO FRACTION(3)
	 * @return a SMUDGE compliant implementation of an Informix DATETIME MINUTE TO FRACTION(3)
	 */
	public static XDRSMUdtime dt2IdtMin2Frac3(Date dt)
	{
		return dt2idt(dt, (short) 1933);
	}
	
	/**
	 * @author elc03 Eric Crawford
	 * 
	 * Converts a java.uti.Date to a SMUDGE compliant implementation
	 * of an Informix DATETIME HOUR TO FRACTION(3)
	 * 
	 * @param dt		The java.util.Date to be converted to an Informix DATETIME HOUR TO FRACTION(3)
	 * @return			a SMUDGE compliant implementation of an Informix DATETIME HOUR TO FRACTION(3)
	 */
	public static XDRSMUdtime dt2IdtHour2Fract3(Date dt)
	{
		return dt2idt(dt, (short)2413);
	}

	/**
	 *
	 * @author elc03
	 *
	 * Convert java.util.Date to a SMUDGE compliant implementation of an 
	 * Informix DateTime type of precision qual. 
	 * 
	 * @param dt the java.util.Date to be converted to an Informix DATETIME
	 * @param qual the Informix DATETIME qualifier
	 * 
	 */
	private static XDRSMUdtime dt2idt(Date dt, short qual)
	{
		XDRSMUdtime idt = new XDRSMUdtime();

		if (dt == null)
		{
			idt.dt_dec.dec_pos = -1;
			dt = Calendar.getInstance().getTime();	
		}
		else
		{
			idt.dt_dec.dec_pos = 1;		
		}
		
		int strt, end;
		int year, month, day, hour, minute, second, fraction;
		int index = 0;

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dt);
		
		if(qual == 4365)
		{
			// Set the timezone to GMT. Only do this for datetime year to fraction conversions. 
			cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		} // end if

		idt.dt_qual = qual;
		idt.dt_dec.dec_ndgts = 0;
		idt.dt_dec.dec_exp = 0;
		
		strt = startTimeUnit(idt.dt_qual);
		end = endTimeUnit(idt.dt_qual);
		year = cal.get(Calendar.YEAR);
		month = (cal.get(Calendar.MONTH) + 1);
		day = cal.get(Calendar.DAY_OF_MONTH);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		second = cal.get(Calendar.SECOND);
		fraction = cal.get(Calendar.MILLISECOND);
		
		if (fraction >= 1000)
		{
			second += fraction / 1000;
			fraction %= 1000;
		}

		if (strt == TU_YEAR)
		{
			idt.dt_dec.dec_dgts[index++] = (byte) (year / 100);
			idt.dt_dec.dec_dgts[index++] = (byte) (year % 100);
			idt.dt_dec.dec_ndgts = (short) (idt.dt_dec.dec_ndgts + 2);
			idt.dt_dec.dec_exp = (short) (idt.dt_dec.dec_exp + 2);
		}
		if (strt <= TU_MONTH && end >= TU_MONTH)
		{
			idt.dt_dec.dec_dgts[index++] = (byte) month;
			idt.dt_dec.dec_ndgts++;
			idt.dt_dec.dec_exp++;
		}
		if (strt <= TU_DAY && end >= TU_DAY)
		{
			idt.dt_dec.dec_dgts[index++] = (byte) day;
			idt.dt_dec.dec_ndgts++;
			idt.dt_dec.dec_exp++;
		}
		if (strt <= TU_HOUR && end >= TU_HOUR)
		{
			idt.dt_dec.dec_dgts[index++] = (byte) hour;
			idt.dt_dec.dec_ndgts++;
			idt.dt_dec.dec_exp++;
		}
		if (strt <= TU_MINUTE && end >= TU_MINUTE)
		{
			idt.dt_dec.dec_dgts[index++] = (byte) minute;
			idt.dt_dec.dec_ndgts++;
			idt.dt_dec.dec_exp++;
		}
		if (strt <= TU_SECOND && end >= TU_SECOND)
		{
			idt.dt_dec.dec_dgts[index++] = (byte) second;
			idt.dt_dec.dec_ndgts++;
			idt.dt_dec.dec_exp++;
		}
		if (end >= TU_F1)
		{
			switch (end)
			{
				case TU_F5 :
					idt.dt_dec.dec_dgts[index++] =
						(byte) ((fraction / 10) % 100);
					idt.dt_dec.dec_ndgts++;
					idt.dt_dec.dec_dgts[index++] =
						(byte) ((fraction / .1) % 100);
					idt.dt_dec.dec_ndgts++;
					idt.dt_dec.dec_dgts[index++] = (byte) (fraction % 100);
					idt.dt_dec.dec_ndgts++;
					break;
				case TU_F3 :
				case TU_F4 :
					idt.dt_dec.dec_dgts[index++] =
						(byte) ((fraction / 10) % 100);
					idt.dt_dec.dec_ndgts++;
					idt.dt_dec.dec_dgts[index++] =
						(byte) ((fraction / .1) % 100);
					idt.dt_dec.dec_ndgts++;
					break;
				case TU_F1 :
					/* strip the 10ths digit */
					fraction -= fraction % 100;
				case TU_F2 :
					idt.dt_dec.dec_dgts[index++] = (byte) (fraction / 10);
					idt.dt_dec.dec_ndgts++;
					break;
			}
		}
		return idt;
	}
} // end RPCUtils