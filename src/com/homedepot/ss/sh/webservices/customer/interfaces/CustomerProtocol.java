package com.homedepot.ss.sh.webservices.customer.interfaces;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		CustomerProtocol.java
 * Application:	SOSI Release 1	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/interfaces/CustomerProtocol.java_v   1.9   26 Sep 2005 14:02:10   rlp05  $
 */
import java.util.GregorianCalendar;
/*
 * CustomerProtocol.java
 * 
 * Created: 	Jul 7, 2004
 * 
 * @author		Eric Crawford, Lane Putnel
 * @version	$Revision:   1.9  $	Last Updated: $Date:   26 Sep 2005 14:02:10  $
 * 
 * Customer web service protocol file 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/interfaces/CustomerProtocol.java_v  $
 * 
 *    Rev 1.9   26 Sep 2005 14:02:10   rlp05
 * removed ; from SQL statements causing production issue related to WAS upgrade
 * 
 *    Rev 1.8   25 Jan 2005 10:35:18   rlp05
 * modified exception text to be more specific
 * 
 *    Rev 1.7   23 Sep 2004 18:18:46   rlp05
 * added message number constants
 * 
 *    Rev 1.6   10 Sep 2004 15:02:10   rlp05
 * added N4MX_NULL_SMALLINT variable
 * 
 *    Rev 1.5   09 Sep 2004 08:48:40   rlp05
 * modified query to get unfavorable rental activity to handle additional location type and number
 * 
 *    Rev 1.4   08 Sep 2004 10:31:38   rlp05
 * modified the get unfavorable rental activity query from "... AND LOC_TYP_CD = ?" to "... AND LOC_TYP_CD <> ?" because now not
 * all location type codes are the same
 * 
 *    Rev 1.3   03 Sep 2004 15:42:38   rlp05
 * removed GMT_CALENDAR
 * 
 *    Rev 1.2   03 Sep 2004 14:49:26   rlp05
 * removed some unused constants and added GMT_CALENDAR
 * 
 *    Rev 1.1   03 Sep 2004 09:02:16   rlp05
 * added constants for new Java date to Informix date conversion function
 * 
 *    Rev 1.0   31 Aug 2004 13:53:04   rlp05
 * InitialRevision
 */
public interface CustomerProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/interfaces/CustomerProtocol.java_v   1.9   26 Sep 2005 14:02:10   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.9  $";

	//=======================================================
	// Customer Type Constants
	//=======================================================
	/**
	 * DIY customer type indicator
	 */
	public static final short DIY_CUST_TYP_CD = 1;
	/**
	 * PRO customer type indicator
	 */
	public static final short PRO_CUST_TYP_CD = 2;

	//=======================================================
	// JNDI constants
	//=======================================================
	/**
	 * WebSphere container JNDI context name
	 */
	public static final String DEFAULT_CONTEXT_NAME = "java:comp/env";
	/**
	 * DataSource JNDI name
	 */	
	public static final String DATASOURCE_NAME = "jdbc/TA.CU.CENT-CUST.001";

	/**
	 * taaa.properties file name for the central customer RPC server
	 */
	public static final String RPCSVR_CENTCUST = "host.SVR_CENTCUST";
	
	/**
	 * informix representation of a null smallint 
	 */
	public static final short N4MX_NULL_SMALL_INT = -32768;
	
	//=======================================================
	// Search type constants
	//=======================================================
	/**
	 * Search by phone with customer type filter indicator
	 */
	public static final short SEARCH_BY_PHN_FILT = 1;
	/**
	 *  Search by phone with no customer type filter indicator
	 */
	public static final short SEARCH_BY_PHN_UNFILT = 2;
	/**
	 * Search by name (DIY customers only) indicator
	 */
	public static final short SEARCH_BY_NAME = 3;
	/**
	 * Search by organization name / zip (PRO customers only) indicator
	 */
	public static final short SEARCH_BY_ORG_NAME_ZIP = 4;
	/**
	 * Search by customer id indicator
	 */
	public static final short SEARCH_BY_CUST_ID = 5;
	/**
	 * Search for contacts indicator
	 */
	public static final short SEARCH_BY_CNTCT_HCUST = 6;	
	/**
	 * Get customer indicator
	 */
	public static final short SEARCH_BY_HCUST_ID = 7;
	/**
	 * Exact search by name
	 */
	public static final short SEARCH_BY_NAME_EXACT = 8;
	/**
	 * Exact search by org name
	 */
	public static final short SEARCH_BY_ORG_NAME_ZIP_EXACT = 9;
	/**
	 * Search by organization name / city - st (PRO customers only) indicator
	 */
	public static final short SEARCH_BY_ORG_NAME_CITY = 10;
	/**
	 * Exact search by organization name / city - st (PRO customers only) indicator
	 */
	public static final short SEARCH_BY_ORG_NAME_CITY_EXACT = 11;

	//=======================================================
	// Exception message constants 
	//=======================================================
	public static final String EXC_GET_DS_FROM_CTX = "A fatal exception was encountered retrieving a datasource instance from the JNDI context";
	public static final String EXC_GETTING_CUST_REC = "A database exception was encountered getting customer record";
	public static final String EXC_SEARCH_CUST_RECS = "A database exception was encountered performing customer search.";
	public static final String EXC_CLOSING_RESULTSET = "An exception occurred closing a ResultSet";
	public static final String EXC_CLOSING_PREPSTAT = "An exception occurred closing a PreparedStatement";
	public static final String EXC_CLOSING_CONNECTION = "An exception occurred closing a Connection";
	
	public static final String CTRL_BLOCK_ERR_TXT_1 = "The following RPC SQL exception occurred: return code: ";
	public static final String CTRL_BLOCK_ERR_TXT_2 = " return message: ";
	
	public static final String INS_RPC_EXC = "An RPC exception occurred performing customer insert.";
	public static final String INS_RPC_HOST_EXC = "An exception occurred reading/writing to the RPC socket, insert could not be performed";
	public static final String INS_NO_ADDR_RECS = "An attempt was made to insert a customer without an address record";
	public static final String INS_NO_PHN_RECS = "An attempt was made to insert a customer without a phone record";
	
	public static final String UPD_RPC_EXC = "An RPC exception occurred performing customer update.";
	public static final String UPD_RPC_HOST_EXC = "An exception occurred reading/writing to the RPC socket, update could not be performed.";
	public static final String UPD_NO_ADDR_RECS = "An attempt was made to update a customer without an address record";
	public static final String UPD_NO_PHN_RECS = "An attempt was made to update a customer without a phone record";
	
	public static final String INV_PARM_TXT_1 = "The ";
	public static final String INV_PARM_TXT_2 = " parameter contains the following invalid value '";
	public static final String INV_PARM_TXT_3 = "'";
	
	public static final String INV_PARM_NULL_TXT = " parameter contains a null value";
	public static final String INV_PARM_LESS_MIN = "' which is < than the minimum parameter length of ";
	public static final String INV_PARM_GREAT_MAX = "' which is > than the maximum parameter length of ";

	//=======================================================
	// Validation type constants 
	//=======================================================
	public static final short VAL_MIN_LEN = 0;
	public static final short VAL_MAX_LEN = 1;
	
	//=======================================================
	// Parameter name constants used to build meaningful exception 
	// messages
	//=======================================================
	public static final String PARM_NM_ST_CD = "state code";
	public static final String PARM_NM_CITY_NM = "city name";
	public static final String PARM_NM_LAST_NM = "last name";
	public static final String PARM_NM_FRST_NM = "first name";
	public static final String PARM_NM_PSTL_CD = "postal code";
	public static final String PARM_NM_CNTRY_CD = "country code";
	public static final String PARM_NM_LOC_NBR = "location number";
	public static final String PARM_NM_LOC_TYP = "location type code";
	public static final String PARM_NM_ID_NBR = "customer id number";
	public static final String PARM_NM_ORG_NM = "organization name";
	public static final String PARM_NM_AREA_CD = "phone area/city code"; 
	public static final String PARM_NM_LOCL_NBR = "phone local number";
	
	//=======================================================
	// Parameter length constants used to validate search criteria
	//=======================================================
	public static final short MIN_PARM_LEN_ST_CD = 2;
	public static final short MIN_PARM_LEN_ID_NBR = 1;
	public static final short MIN_PARM_LEN_CITY_NM = 1;
	public static final short MIN_PARM_LEN_ORG_NM = 1;
	public static final short MIN_PARM_LEN_AREA_CD = 1;
	public static final short MIN_PARM_LEN_PSTL_CD = 5;
	public static final short MIN_PARM_LEN_LAST_NM = 1;
	public static final short MIN_PARM_LEN_FRST_NM = 1;
	public static final short MIN_PARM_LEN_LOCL_NBR = 1;
	public static final short MIN_PARM_LEN_CNTRY_CD = 2;
	public static final short MIN_PARM_LEN_LOC_TYP = 1;
	public static final short MIN_PARM_LEN_LOC_NBR = 1;

	public static final short MAX_PARM_LEN_LOC_TYP = 4;
	public static final short MAX_PARM_LEN_LOC_NBR = 4;
	public static final short MAX_PARM_LEN_AREA_CD = 5;
	public static final short MAX_PARM_LEN_LOCL_NBR = 9;
	public static final short MAX_PARM_LEN_CNTRY_CD = 2;
	public static final short MAX_PARM_LEN_ST_CD = 2;
	//=======================================================
	// Exception constants that are returned to calling applications.	
	//=======================================================
	public static final String EXC_CD_LOC_TYP = "14118";
	public static final String EXC_CD_LOC_NBR = "00650";
	public static final String EXC_CD_CNTRY_CD = "00687";
	public static final String EXC_CD_AREA_CD = "16810";
	public static final String EXC_CD_LOCL_NBR = "16811";
	public static final String EXC_CD_FRST_NM = "10400";
	public static final String EXC_CD_LAST_NM = "10405";
	public static final String EXC_CD_ORG_NM = "13903";
	public static final String EXC_CD_PSTL_CD = "10414";
	public static final String EXC_CD_ID_NBR = "16812";
	public static final String EXC_CD_CITY_NM = "10420";
	public static final String EXC_CD_ST_CD = "10423";
	
	public static final String EXC_CD_SRCH = "13936";
	public static final String EXC_CD_INS_UPD = "13942";
	public static final String EXC_CD_RPC = "10409";
	
	public static final String EXC_CD_INV_AMT_PCT = "20070";
		
	//=======================================================
	// Query wildcard constants
	//=======================================================	
	public static final String ASTERICK_WILDCARD = "*";
	public static final String PERCENT_WILDCARD = "%";
	
	//=======================================================
	// RpcUtils constants used for date conversions
	//=======================================================
	public static final int TU_YEAR = 0;
	public static final int TU_MONTH = 2;
	public static final int TU_DAY = 4;
	public static final int TU_HOUR = 6;
	public static final int TU_MINUTE = 8;
	public static final int TU_SECOND = 10;
	public static final int TU_FRAC = 12;
	public static final int TU_F1 = 11;
	public static final int TU_F2 = 12;
	public static final int TU_F3 = 13;
	public static final int TU_F4 = 14;
	public static final int TU_F5 = 15;	

	public static final int DAYS_PER_YEAR = 365;
	public static final int LEAP_YEAR_DAY = 1;
	public static final int NUM_OF_DAYS_LONG_MTH = 31;
	public static final int NUM_OF_DAYS_SHORT_MTH = 30;
	public static final int NUM_OF_DAYS_FEB = 28;

	public static final int N4MX_EPOCH_YEAR =1899;
	public static final int N4MX_EPOCH_MONTH = GregorianCalendar.DECEMBER;
	public static final int N4MX_EPOCH_DATE = 31;
	public static final int N4MX_EPOCH_HOUR = 0;
	public static final int N4MX_EPOCH_MINUTE = 0;
	public static final int N4MX_EPOCH_SECOND = 0;
	public static final int N4MX_NULL_DATE = -2147483648;	
	public static final GregorianCalendar N4MX_BASELINE_DATE = new GregorianCalendar(N4MX_EPOCH_YEAR, 
		N4MX_EPOCH_MONTH, N4MX_EPOCH_DATE, N4MX_EPOCH_HOUR, N4MX_EPOCH_MINUTE, N4MX_EPOCH_SECOND);
	
	//=======================================================
	// RPC client pool constants
	//=======================================================
	public static final int RPC_CLIENT_CACHE_INIT_SIZE  = 2;
	public static final int RPC_CLIENT_CACHE_MAX_SIZE = 10;
	public static final String RPC_CLIENT_CACHE_INIT_PROP_NAME = "customer.webservice.cacheinit";
	public static final String RPC_CLIENT_CACHE_MAX_PROP_NAME = "customer.webservice.cachemax";
		
	//=======================================================
	// Central customer table column name constants
	//=======================================================
	// STR_SVC_HCUST
	public static final String COL_HOST_CUST_NBR = "STR_SVC_HCUST_NBR";
	public static final String COL_CUST_TYP_CD = "CUST_TYP_CD";
	public static final String COL_CUST_STAT_CD = "CUST_STAT_CD";
	public static final String COL_CUST_STAT_EFF_DT = "CUST_STAT_EFF_DT";
	public static final String COL_CNTCT_METH_CD = "CNTCT_METH_CD";
	public static final String COL_CNTCT_ADDR_TYP_CD = "CNTCT_ADDR_TYP_CD";
	public static final String COL_CNTCT_PHN_TYP_CD = "CNTCT_PHN_TYP_CD";
	public static final String COL_CNTCT_EMAIL_TYP_CD = "CNTCT_EMAIL_TYP_CD";
	public static final String COL_CNTCT_WK_BGN_TM = "CNTCT_WK_BGN_TM";
	public static final String COL_CNTCT_WK_END_TM = "CNTCT_WK_END_TM";
	public static final String COL_CNTCT_WKND_BGN_TM = "CNTCT_WKND_BGN_TM";
	public static final String COL_CNTCT_WKND_END_TM = "CNTCT_WKND_END_TM";
	public static final String COL_EMAIL_CLT_CD = "EMAIL_CLT_CD";
	public static final String COL_EMAIL_CLT_RQST_DT = "EMAIL_CLT_RQST_DT";
	public static final String COL_LAST_UPD_USER_ID = "LAST_UPD_USER_ID";
	public static final String COL_LAST_UPD_TS = "LAST_UPD_TS";
	// STR_SVC_INDV_HCUST
	public static final String COL_FRST_NM = "FRST_NM";
	public static final String COL_MID_NM = "MID_NM";
	public static final String COL_LAST_NM = "LAST_NM";
	public static final String COL_SFX_NM = "SFX_NM";
	public static final String COL_TTL_NM = "TTL_NM";
	public static final String COL_BRTH_DT = "BRTH_DT";
	// STR_SVC_ORG_HCUST	
	public static final String COL_ORG_CUST_NM = "ORG_CUST_NM";
	public static final String COL_SIC_CD = "SIC_CD";
	public static final String COL_TAX_EXMPT_FLG = "TAX_EXMPT_FLG";
	public static final String COL_TAX_EXMPT_UPD_DT = "TAX_EXMPT_UPD_DT";
	public static final String COL_FED_TAX_ID = "FED_TAX_ID";
	// HCUST_TAXBL_STAT
	public static final String COL_TAXBL_STAT_CD = "TAXBL_STAT_CD";
	public static final String COL_TAX_PAY_AGREE_CD = "TAX_PAY_AGREE_CD";
	// HCUST_VHCL_INSR
	public static final String COL_INSR_PRVDR_NM = "INSR_PRVDR_NM";
	public static final String COL_INSR_PLCY_NBR = "INSR_PLCY_NBR";
	public static final String COL_INSR_PLCY_EXPIR_DT = "INSR_PLCY_EXPIR_DT";
	// RNTL_HCUST_DTL
	public static final String COL_DFLT_DEPST_METH_CD = "DFLT_DEPST_METH_CD";
	public static final String COL_DMG_WVR_REQD_FLG = "DMG_WVR_REQD_FLG";
	public static final String COL_CUST_PO_REQD_FLG = "CUST_PO_REQD_FLG";
	public static final String COL_JOB_SITE_REQD_FLG = "JOB_SITE_REQD_FLG";
	public static final String COL_LTD_RNTL_CNT = "LTD_RNTL_CNT";
	public static final String COL_LTD_RNTL_AMT = "LTD_RNTL_AMT";
	public static final String COL_CUST_LAST_RNTL_DT = "CUST_LAST_RNTL_DT";
	// HCUST_LOC_XREF
	public static final String COL_LOCAL_CUST_NBR = "STR_SVC_LCUST_NBR";	
	// STR_SVC_HCUST_ADDR
	public static final String COL_CUST_ADDR_TYP_CD = "CUST_ADDR_TYP_CD";
	public static final String COL_ADDR_LINE1_TXT = "ADDR_LINE1_TXT";
	public static final String COL_ADDR_LINE2_TXT = "ADDR_LINE2_TXT";
	public static final String COL_ADDR_LINE3_TXT = "ADDR_LINE3_TXT";
	public static final String COL_ADDR_LINE4_TXT = "ADDR_LINE4_TXT";
	public static final String COL_ADDR_LINE5_TXT = "ADDR_LINE5_TXT";
	public static final String COL_CITY_NM = "CITY_NM";
	public static final String COL_CNTY_NM = "CNTY_NM";
	public static final String COL_ST_CD = "ST_CD";
	public static final String COL_PSTL_CD = "PSTL_CD";
	public static final String COL_CNTRY_CD = "CNTRY_CD";
	public static final String COL_PRIM_ADDR_TAX_FLG = "PRIM_ADDR_TAX_FLG";
	public static final String COL_AX_GEO_CD = "AX_GEO_CD";	
	// STR_SVC_HCUST_PHN	
	public static final String COL_PHN_NBR_TYP_CD = "PHN_NBR_TYP_CD";
	public static final String COL_PHN_AREA_CITY_CD = "PHN_AREA_CITY_CD";
	public static final String COL_PHN_LOCAL_NBR = "PHN_LOCL_NBR";
	public static final String COL_PHN_EXT_NBR = "PHN_EXT_NBR";
	public static final String COL_PREF_PHN_FLG = "PREF_PHN_FLG";
	public static final String COL_PHN_PIN_NBR = "PHN_PIN_NBR";	
	// HCUST_EMAIL_ADDR
	public static final String COL_EMAIL_ADDR_TYP_CD = "EMAIL_ADDR_TYP_CD";
	public static final String COL_EMAIL_ADDR_TXT = "EMAIL_ADDR_TXT";
	public static final String COL_SOLCT_FLG = "SOLCT_FLG";
	// STR_SVC_HCUST_ID
	public static final String COL_LOC_TYP_CD = "LOC_TYP_CD";
	public static final String COL_LOC_NBR = "LOC_NBR";
	public static final String COL_SEQ_NBR = "SEQ_NBR";
	public static final String COL_JURSD_TYP_CD = "JURSD_TYP_CD";
	public static final String COL_JURSD_LVL_CD = "JURSD_LVL_CD";
	public static final String COL_JURSD_CD = "JURSD_CD";
	public static final String COL_CUST_ID_TYP_CD = "CUST_ID_TYP_CD";
	public static final String COL_CUST_ID_NBR = "CUST_ID_NBR";
	public static final String COL_CUST_ID_EXPIR_DT = "CUST_ID_EXPIR_DT";
	// HCUST_TAX_RUL
	public static final String COL_TAX_PAYMT_AUTH_FLG = "TAX_PAYMT_AUTH_FLG";
	public static final String COL_TAX_EXMPT_ACTV_FLG = "TAX_EXMPT_ACTV_FLG";
	public static final String COL_TAX_TYP_CD = "TAX_TYP_CD";
	public static final String COL_TAX_CD = "TAX_CD";
	public static final String COL_EFF_BGN_DT = "EFF_BGN_DT";
	public static final String COL_EFF_END_DT = "EFF_END_DT";
	public static final String COL_TAX_EXMPT_AMT = "TAX_EXMPT_AMT";
	public static final String COL_TAX_EXMPT_PCT = "TAX_EXMPT_PCT";
	// ORG_HCUST_AGNT
	public static final String COL_CRT_TS = "CRT_TS";
	public static final String COL_ACTV_FLG = "ACTV_FLG";
	// HCUST_UNFVR_RACTVY
	public static final String COL_RAGREE_NBR = "RAGREE_NBR";
	public static final String COL_RPGM_PHN_ACTY_CD = "RPGM_PHN_ACTY_CD";
	public static final String COL_RPGM_PHN_LOCL_NBR = "RPGM_PHN_LOCL_NBR";
	public static final String COL_RPGM_PHN_EXT_NBR = "RPGM_PHN_EXT_NBR";
	public static final String COL_UNFVR_RACTVY_CD = "UNFVR_RACTVY_CD";
	public static final String COL_UNFVR_RACTVY_AMT = "UNFVR_RACTVY_AMT";
	public static final String COL_RSLTN_DT = "RSLTN_DT";
	public static final String COL_RAGREE_CLS_DT = "RAGREE_CLS_DT";
	public static final String COL_LOC_NM = "LOC_NM";	
	// HCUST_CNTCT
	public static final String COL_CNTCT_HCUST_NBR = "CNTCT_HCUST_NBR";
	public static final String COL_AGNT_SEQ_NBR = "AGNT_SEQ_NBR";
	public static final String COL_AGNT_LOC_NBR = "AGNT_LOC_NBR";
	public static final String COL_AGNT_LOC_TYP_CD = "AGNT_LOC_TYP_CD";

	//=======================================================
	// Query constants
	//=======================================================	
	/**
	 * Search queries perform a select first using this constant to limit
	 * the number of rows being returned.
	 */
	public static final int MAX_NUM_SEARCH_ROWS = 250;
	
	/**
	 * Query used to perform phone number searches, results will include
	 * DIY or PRO customers only
	 */
	public static final String DIY_PRO_PHN_SEARCH_SQL = 
		"SELECT DIY.LAST_NM, " +
		"				 DIY.FRST_NM, " +
		"				 PRO.ORG_CUST_NM, " +
		"				 PHN.PHN_NBR_TYP_CD, " + 
		"				 PHN.PHN_AREA_CITY_CD, " +
		"				 PHN.PHN_LOCL_NBR, " +
		"				 ADDR.ADDR_LINE1_TXT, " +
		" 				 ADDR.CITY_NM, " + 
		"				 ADDR.ST_CD, " + 
		"				 ADDR.PSTL_CD, " + 
		"				 HDR.STR_SVC_HCUST_NBR, " +
		"				 HDR.CUST_TYP_CD, " +
		"				 HDR.CUST_STAT_CD, " + 
		"				 XREF.STR_SVC_LCUST_NBR, " +
		"				 HDR.LAST_UPD_TS, " +
		"				 0 SEQ_NBR " + 
		"FROM			 STR_SVC_HCUST_ADDR ADDR, " +
		"				 STR_SVC_HCUST_PHN PHN, " +
		"				 STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN STR_SVC_INDV_HCUST DIY " +
		"	ON (HDR.STR_SVC_HCUST_NBR = DIY.STR_SVC_HCUST_NBR) " +
		"LEFT OUTER JOIN STR_SVC_ORG_HCUST PRO " +
		"	ON (HDR.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR) " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR  " +
		"		AND XREF.LOC_NBR = ? AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			 PHN.PHN_AREA_CITY_CD = ? " +
		"AND			 PHN.PHN_LOCL_NBR = ? " +
		"AND			 PHN.CNTRY_CD = ? " +
		"AND			 ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			 HDR.CUST_TYP_CD = ? " +
		"AND			 HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			 HDR.STR_SVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"AND			 HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"FETCH FIRST " + MAX_NUM_SEARCH_ROWS + " ROWS ONLY " +
		"WITH UR";	
	
	/**
	 * Query used to perform phone searches, results will include both
	 * DIY and PRO customers
	 */
	public static final String PHN_SEARCH_SQL = 
		"SELECT	DIY.LAST_NM, " +
		"					DIY.FRST_NM, " +
		"					PRO.ORG_CUST_NM, " +
		"					PHN.PHN_AREA_CITY_CD, " +
		"					PHN.PHN_LOCL_NBR, " +
		"					PHN.PHN_NBR_TYP_CD, " + 
		"					ADDR.ADDR_LINE1_TXT, " +
		"					ADDR.CITY_NM, " + 
		"					ADDR.ST_CD, " + 
		"					ADDR.PSTL_CD, " + 
		"					HDR.STR_SVC_HCUST_NBR, " +
		"					HDR.CUST_TYP_CD, " +
		"					HDR.CUST_STAT_CD, " + 	
		"					XREF.STR_SVC_LCUST_NBR, " +
		"					HDR.LAST_UPD_TS, " +
		"					0 SEQ_NBR " + 		
		"FROM		STR_SVC_HCUST_ADDR ADDR, " +
		"					STR_SVC_HCUST_PHN PHN, " +
		"					STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN STR_SVC_INDV_HCUST DIY " +
		"	ON (HDR.STR_SVC_HCUST_NBR = DIY.STR_SVC_HCUST_NBR) " +
		"LEFT OUTER JOIN STR_SVC_ORG_HCUST PRO " +
		"	ON (HDR.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR) " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR  " +
		"		AND XREF.LOC_NBR = ? AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			PHN.PHN_AREA_CITY_CD = ? " +
		"AND				PHN.PHN_LOCL_NBR = ? " +
		"AND				PHN.CNTRY_CD = ? " +
		"AND				ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND				HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND				HDR.STR_SVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"AND				HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"FETCH FIRST " + MAX_NUM_SEARCH_ROWS + " ROWS ONLY " +
		"WITH UR";
		
	/**
	 * Query used to perform DIY customer name searches
	 */
	public static final String NAME_SEARCH_SQL = 
		"SELECT			DIY.FRST_NM, " +
		"				DIY.LAST_NM, " +
		"    			'' ORG_CUST_NM, " + 
		"				PHN.PHN_NBR_TYP_CD, " + 
		"				PHN.PHN_AREA_CITY_CD, " +
		"				PHN.PHN_LOCL_NBR, " +
		"				ADDR.ADDR_LINE1_TXT, " +
		"				ADDR.CITY_NM, " + 
		"				ADDR.ST_CD, " + 
		"				ADDR.PSTL_CD, " +
		"				HDR.STR_SVC_HCUST_NBR, " +
		"				HDR.CUST_TYP_CD, " +
		"				HDR.CUST_STAT_CD, " +
		"				XREF.STR_SVC_LCUST_NBR, " +
		"				HDR.LAST_UPD_TS, " +
		"				0 SEQ_NBR " + 
		"FROM			STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_INDV_HCUST DIY, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR AND XREF.LOC_NBR = ? " +
		"		AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			DIY.LAST_NM LIKE ? " +
		"AND			DIY.FRST_NM LIKE ? " +
		"AND			(ADDR.PSTL_CD LIKE ? OR ADDR.PSTL_CD = '00000') " +
		"AND			PHN.PHN_NBR_TYP_CD = 1 " +
		"AND			ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			ADDR.CNTRY_CD = ? " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			HDR.STR_SVC_HCUST_NBR = DIY.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"ORDER BY DIY.LAST_NM, DIY.FRST_NM " +
		"WITH UR";	
			
	/**
	 * Query used to perform DIY customer name searches
	 */
	public static final String EXACT_NAME_SEARCH_SQL = 
		"SELECT			DIY.FRST_NM, " +
		"				DIY.LAST_NM, " +
		"    			'' ORG_CUST_NM, " + 
		"				PHN.PHN_NBR_TYP_CD, " + 
		"				PHN.PHN_AREA_CITY_CD, " +
		"				PHN.PHN_LOCL_NBR, " +
		"				ADDR.ADDR_LINE1_TXT, " +
		"				ADDR.CITY_NM, " + 
		"				ADDR.ST_CD, " + 
		"				ADDR.PSTL_CD, " +
		"				HDR.STR_SVC_HCUST_NBR, " +
		"				HDR.CUST_TYP_CD, " +
		"				HDR.CUST_STAT_CD, " +
		"				XREF.STR_SVC_LCUST_NBR, " +
		"				HDR.LAST_UPD_TS, " +
		"				0 SEQ_NBR " + 
		"FROM			STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_INDV_HCUST DIY, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR AND XREF.LOC_NBR = ? " +
		"		AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			DIY.LAST_NM = ? " +
		"AND			DIY.FRST_NM = ? " +
		"AND			(ADDR.PSTL_CD LIKE ? OR ADDR.PSTL_CD = '00000') " +
		"AND			PHN.PHN_NBR_TYP_CD = 1 " +
		"AND			ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			ADDR.CNTRY_CD = ? " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			HDR.STR_SVC_HCUST_NBR = DIY.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"ORDER BY DIY.LAST_NM, DIY.FRST_NM " +
		"WITH UR";			
		
	/**
	 * Query used to perform PRO customer name searches
	 */
	public static final String ORG_NAME_ZIP_SEARCH_SQL = 
		"SELECT			'' FRST_NM, " +
		"  						'' LAST_NM, " + 		"							PRO.ORG_CUST_NM, " +
		"							PHN.PHN_NBR_TYP_CD, " + 
		"							PHN.PHN_AREA_CITY_CD, " +
		"							PHN.PHN_LOCL_NBR, " +
		"							ADDR.ADDR_LINE1_TXT, " +
		" 							ADDR.CITY_NM, " + 
		"							ADDR.ST_CD, " + 
		"							ADDR.PSTL_CD, " + 
		"							HDR.STR_SVC_HCUST_NBR, " +
		"							HDR.CUST_TYP_CD, " +
		"							HDR.CUST_STAT_CD, " + 	
		"							XREF.STR_SVC_LCUST_NBR, " +
		"							HDR.LAST_UPD_TS, " +
		"							0 SEQ_NBR " +
		"FROM			STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_ORG_HCUST PRO, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF  " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR AND XREF.LOC_NBR = ? " +
		"		AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			PRO.ORG_CUST_NM LIKE ? " +
		"AND			(ADDR.PSTL_CD LIKE ? OR ADDR.PSTL_CD = '00000') " +
		"AND			PHN.PHN_NBR_TYP_CD = 1 " +
		"AND			ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			ADDR.CNTRY_CD = ? " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			HDR.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_sVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"ORDER BY PRO.ORG_CUST_NM " +
		"WITH UR";
		
	/**
	 * Query used to perform exact PRO customer name searches
	 */
	public static final String EXACT_ORG_NAME_ZIP_SEARCH_SQL = 
		"SELECT			'' FRST_NM, " +
		"  						'' LAST_NM, " + 
		"							PRO.ORG_CUST_NM, " +
		"							PHN.PHN_NBR_TYP_CD, " + 
		"							PHN.PHN_AREA_CITY_CD, " +
		"							PHN.PHN_LOCL_NBR, " +
		"							ADDR.ADDR_LINE1_TXT, " +
		" 							ADDR.CITY_NM, " + 
		"							ADDR.ST_CD, " + 
		"							ADDR.PSTL_CD, " + 
		"							HDR.STR_SVC_HCUST_NBR, " +
		"							HDR.CUST_TYP_CD, " +
		"							HDR.CUST_STAT_CD, " + 	
		"							XREF.STR_SVC_LCUST_NBR, " +
		"							HDR.LAST_UPD_TS, " +
		"							0 SEQ_NBR " +
		"FROM			STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_ORG_HCUST PRO, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF  " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR AND XREF.LOC_NBR = ? " +
		"		AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			PRO.ORG_CUST_NM = ? " +
		"AND			(ADDR.PSTL_CD LIKE ? OR ADDR.PSTL_CD = '00000') " +
		"AND			PHN.PHN_NBR_TYP_CD = 1 " +
		"AND			ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			ADDR.CNTRY_CD = ? " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			HDR.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_sVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"ORDER BY PRO.ORG_CUST_NM " +
		"WITH UR";		

	/**
	 * Query used to perform PRO customer name searches
	 */
	public static final String ORG_NAME_CITY_SEARCH_SQL = 
		"SELECT			'' FRST_NM, " +
		"  						'' LAST_NM, " + 
		"							PRO.ORG_CUST_NM, " +
		"							PHN.PHN_NBR_TYP_CD, " + 
		"							PHN.PHN_AREA_CITY_CD, " +
		"							PHN.PHN_LOCL_NBR, " +
		"							ADDR.ADDR_LINE1_TXT, " +
		" 							ADDR.CITY_NM, " + 
		"							ADDR.ST_CD, " + 
		"							ADDR.PSTL_CD, " + 
		"							HDR.STR_SVC_HCUST_NBR, " +
		"							HDR.CUST_TYP_CD, " +
		"							HDR.CUST_STAT_CD, " + 	
		"							XREF.STR_SVC_LCUST_NBR, " +
		"							HDR.LAST_UPD_TS, " +
		"							0 SEQ_NBR " +
		"FROM			STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_ORG_HCUST PRO, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF  " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR AND XREF.LOC_NBR = ? " +
		"		AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			PRO.ORG_CUST_NM LIKE ? " +
		"AND			ADDR.CITY_NM = ? " +
		"AND			ADDR.ST_CD = ? " +
		"AND			PHN.PHN_NBR_TYP_CD = 1 " +
		"AND			ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			ADDR.CNTRY_CD = ? " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			HDR.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_sVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"ORDER BY PRO.ORG_CUST_NM " +
		"WITH UR";
		
	/**
	 * Query used to perform exact PRO customer name searches
	 */
	public static final String EXACT_ORG_NAME_CITY_SEARCH_SQL = 
		"SELECT			'' FRST_NM, " +
		"  						'' LAST_NM, " + 
		"							PRO.ORG_CUST_NM, " +
		"							PHN.PHN_NBR_TYP_CD, " + 
		"							PHN.PHN_AREA_CITY_CD, " +
		"							PHN.PHN_LOCL_NBR, " +
		"							ADDR.ADDR_LINE1_TXT, " +
		" 							ADDR.CITY_NM, " + 
		"							ADDR.ST_CD, " + 
		"							ADDR.PSTL_CD, " + 
		"							HDR.STR_SVC_HCUST_NBR, " +
		"							HDR.CUST_TYP_CD, " +
		"							HDR.CUST_STAT_CD, " + 	
		"							XREF.STR_SVC_LCUST_NBR, " +
		"							HDR.LAST_UPD_TS, " +
		"							0 SEQ_NBR " +
		"FROM			STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_ORG_HCUST PRO, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF  " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR AND XREF.LOC_NBR = ? " +
		"		AND XREF.LOC_TYP_CD = ?) " +
		"WHERE			PRO.ORG_CUST_NM = ? " +
		"AND			ADDR.CITY_NM = ? " +
		"AND			ADDR.ST_CD = ? " +
		"AND			PHN.PHN_NBR_TYP_CD = 1 " +
		"AND			ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			ADDR.CNTRY_CD = ? " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			HDR.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_sVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"ORDER BY PRO.ORG_CUST_NM " +
		"WITH UR";		
				
	/*
	 * Query used to perform customer id searches
	 */	 
	public static final String CUST_ID_SEARCH_SQL = 
		"SELECT			DIY.LAST_NM, " +
		"				DIY.FRST_NM, " +
		"				PRO.ORG_CUST_NM, " +
		"				PHN.PHN_NBR_TYP_CD, " + 
		"				PHN.PHN_AREA_CITY_CD, " +
		"				PHN.PHN_LOCL_NBR, " +
		"				ADDR.ADDR_LINE1_TXT, " +
		"				ADDR.CITY_NM, " + 
		"				ADDR.ST_CD, " + 
		"				ADDR.PSTL_CD, " + 
		"				HDR.STR_SVC_HCUST_NBR, " +
		"				HDR.CUST_TYP_CD, " +
		"				HDR.CUST_STAT_CD, " + 	
		"				XREF.STR_SVC_LCUST_NBR, " +
		"				ID.CUST_ID_NBR, " +
		"				ID.CUST_ID_TYP_CD, " +
		"				HDR.LAST_UPD_TS, " +
		"				0 SEQ_NBR " +
		"FROM			STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_HCUST_ID ID, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN STR_SVC_INDV_HCUST DIY " +
		"	ON (HDR.STR_SVC_HCUST_NBR = DIY.STR_SVC_HCUST_NBR) " +
		"LEFT OUTER JOIN STR_SVC_ORG_HCUST PRO " +
		"	ON (HDR.STR_SVC_HCUST_NBR = PRO.STR_sVC_HCUST_NBR) " +
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF  " +
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR AND XREF.LOC_NBR = ? " +
		"		AND XREF.LOC_TYP_CD = ?) " +
		"WHERE 			ID.CUST_ID_NBR = ? " +
		"AND			ID.CUST_ID_TYP_CD = ? " +
		"AND			PHN.PHN_NBR_TYP_CD = 1 " +
		"AND			ADDR.CUST_ADDR_TYP_CD = 1 " +
		"AND			ADDR.CNTRY_CD = ? " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"AND			HDR.STR_SVC_HCUST_NBR = ID.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			HDR.STR_SVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"ORDER BY DIY.LAST_NM, DIY.FRST_NM, PRO.ORG_CUST_NM " +
		"WITH UR";
				
	/*
	 * Query used to perform contact search by host customer number
	 */
	 
	public static final String CONTACT_ID_SEARCH_SQL =
		"SELECT			DIY.LAST_NM. " +
		"				DIY.FRST_NM, " +
		"				PRO.ORG_CUST_NM, " +
		"				PHN.PHN_NBR_TYP_CD, " + 
		"				PHN.PHN_AREA_CITY_CD, " +
		"				PHN.PHN_LOCL_NBR, " +
		"				ADDR.ADDR_LINE1_TXT, " +
		"				ADDR.CITY_NM, " + 
		"				ADDR.ST_CD, " +
		"				ADDR.PSTL_CD, " +	
		"				CNTCT.CNTCT_HCUST_NBR, " +
		"				HDR.CUST_STAT_CD, " + 
		"				HDR.CUST_TYP_CD, " +	
		"				CNTCT.SEQ_NBR, " +
		"				CNTCT.LAST_UPD_TS " +
		"FROM			HCUST_CNTCT CNTCT CNTCT, " +
		"				STR_SVC_HCUST_ADDR ADDR, " +
		"				STR_SVC_HCUST_PHN PHN, " +
		"				STR_SVC_HCUST HDR " +
		"LEFT OUTER JOIN STR_SVC_INDV_HCUST DIY " +
		"	ON (CNTCT.STR_SVC_HCUST_NBR = DIY.STR_SVC_HCUST_NBR) " +
		"LEFT OUTER JOIN STR_SVC_ORG_HCUST PRO " +
		"	ON (CNTCT.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR) " +
		"WHERE			CNTCT.STR_SVC_HCUST_NBR = ? " +
		"AND			CNTCT.ACTV_FLG = 'Y' " +
		"AND			CNTCT.STR_SVC_HCUST_NBR = HDR.STR_SVC_HCUST_NBR " +
		"AND			CNTCT.STR_SVC_HCUST_NBR = ADDR.STR_SVC_HCUST_NBR " +
		"AND			CNTCT.STR_SVC_HCUST_NBR = PHN.STR_SVC_HCUST_NBR " +
		"AND			PHN.PHN_NBR_TYP_CD = " +
		"( " +
		"	SELECT	MIN(PHN_NBR_TYP_CD) " +
		"	FROM	STR_SVC_HCUST_PHN  " +
		"	WHERE	STR_SVC_HCUST_PHN.STR_SVC_HCUST_NBR = CNTCT.STR_SVC_HCUST_NBR " +
		") " +
		"AND			ADDR.CUST_ADDR_TYP_CD =  " +
		"( " +
		"	SELECT	MIN(CUST_ADDR_TYP_CD) " +
		"	FROM	STR_SVC_HCUST_ADDR  " +
		"	WHERE	STR_SVC_HCUST_ADDR.STR_SVC_HCUST_NBR = CNTCT.STR_SVC_HCUST_NBR " +
		") " +
		"AND			HDR.STR_SVC_HCUST_NBR <> 0 " +
		"ORDER BY DIY.LAST_NM, DIY.FRST_NM, PRO.ORG_CUST_NM " +
		"WITH UR";

	/**
	 * Query used to get customer header data
	 */
	public static final String GET_CUST_HDR_SQL = 
		"SELECT	HDR.STR_SVC_HCUST_NBR,   " + 
		"					HDR.CUST_TYP_CD,   " + 
		"				HDR.CUST_STAT_CD,   " + 
		"				HDR.CUST_STAT_EFF_DT,   " + 
		"				HDR.CNTCT_METH_CD,   " + 
		"				HDR.CNTCT_ADDR_TYP_CD,   " + 
		"				HDR.CNTCT_PHN_TYP_CD,   " + 
		"				HDR.CNTCT_EMAIL_TYP_CD,   " + 
		"				HDR.CNTCT_WK_BGN_TM,   " + 
		"				HDR.CNTCT_WK_END_TM,   " + 
		"				HDR.CNTCT_WKND_BGN_TM,   " + 
		"				HDR.CNTCT_WKND_END_TM,   " + 
		"				HDR.EMAIL_CLT_CD,   " + 
		"				HDR.EMAIL_CLT_RQST_DT,   " + 
		"				HDR.LAST_UPD_USER_ID,   " + 
		"				HDR.LAST_UPD_TS,   " + 
		"				DIY.FRST_NM,   " + 
		"				DIY.MID_NM,   " + 
		"				DIY.LAST_NM,   " + 
		"				DIY.SFX_NM,   " + 
		"				DIY.TTL_NM,   " + 
		"				DIY.BRTH_DT,   " + 
		"				PRO.ORG_CUST_NM,   " + 
		"				PRO.SIC_CD,   " + 
		"				PRO.TAX_EXMPT_FLG,   " + 
		"				PRO.TAX_EXMPT_UPD_DT,   " + 
		"				PRO.FED_TAX_ID,   " + 
		"				XREF.STR_SVC_LCUST_NBR   " + 
		"FROM	STR_SVC_HCUST HDR   " + 
		"LEFT OUTER JOIN STR_SVC_INDV_HCUST DIY   " + 
		"	ON (HDR.STR_SVC_HCUST_NBR = DIY.STR_SVC_HCUST_NBR)   " + 
		"LEFT OUTER JOIN STR_SVC_ORG_HCUST PRO   " + 
		"	ON (HDR.STR_SVC_HCUST_NBR = PRO.STR_SVC_HCUST_NBR)   " + 
		"LEFT OUTER JOIN HCUST_LOC_XREF XREF   " + 
		"	ON (HDR.STR_SVC_HCUST_NBR = XREF.STR_SVC_HCUST_NBR   " + 
		"		AND XREF.LOC_NBR = ? AND XREF.LOC_TYP_CD = ?)   " + 
		"WHERE	HDR.STR_SVC_HCUST_NBR = ? WITH UR ";
	
	/**
	 * Query used to get customer address data
	 */
	public static final String GET_CUST_ADDR_SQL = 
		"SELECT	CUST_ADDR_TYP_CD,   " + 
		"					ADDR_LINE1_TXT,   " + 
		"					ADDR_LINE2_TXT,   " + 
		"					ADDR_LINE3_TXT,   " + 
		"					ADDR_LINE4_TXT,   " + 
		"					ADDR_LINE5_TXT,   " + 
		"					CITY_NM,   " + 
		"					CNTY_NM,   " + 
		"					ST_CD,   " + 
		"					PSTL_CD,   " + 
		"					CNTRY_CD,   " + 
		"					PRIM_ADDR_TAX_FLG,   " + 
		"					AX_GEO_CD   " + 
		"FROM		STR_SVC_HCUST_ADDR   " + 
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR	 ";
	
	/**
	 * Query used to get customer phone data
	 */
	public static final String GET_CUST_PHN_SQL =  
		"SELECT	PHN_NBR_TYP_CD,   " + 
		"					PHN_AREA_CITY_CD,   " + 
		"					PHN_LOCL_NBR,   " + 
		"					PHN_EXT_NBR,   " + 
		"					CNTRY_CD,   " + 
		"					PREF_PHN_FLG,   " + 
		"					PHN_PIN_NBR   " + 
		"FROM		STR_SVC_HCUST_PHN   " + 
		"WHERE 	STR_SVC_HCUST_NBR = ? WITH UR ";
	
	/**
	 * Query used to get customer email address data
	 */
	public static final String GET_CUST_EMAIL_SQL = 
		"SELECT	EMAIL_ADDR_TYP_CD,   " + 
		"					EMAIL_ADDR_TXT,   " + 
		"					SOLCT_FLG   " + 
		"FROM		HCUST_EMAIL_ADDR   " + 
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR ";
		
	/**
	 * Query used to get customer id data
	 */
	public static final String GET_CUST_ID_SQL =  
		"SELECT	LOC_TYP_CD,   " + 
		"					LOC_NBR,   " + 
		"					SEQ_NBR,   " + 
		"					JURSD_TYP_CD,   " + 
		"					JURSD_LVL_CD,   " + 
		"					JURSD_CD,   " + 
		"					CUST_ID_TYP_CD,   " + 
		"					CUST_ID_NBR,   " + 
		"					CUST_ID_EXPIR_DT   " + 
		"FROM		STR_SVC_HCUST_ID   " + 
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR	 "; 
		
	/**
	 * Query used to get customer taxbl stat data
	 */
	public static final String GET_CUST_TAXBL_STAT_SQL =
		"SELECT	TAXBL_STAT_CD, " +
		"		TAX_PAY_AGREE_CD " +
		"FROM	HCUST_TAXBL_STAT " +
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR ";	

	/**
	 * Query used to get customer tax rule data
	 */
	public static final String GET_CUST_TAX_RUL_SQL = 		
		"SELECT	LOC_TYP_CD,   " + 
		"					LOC_NBR,   " + 
		"					SEQ_NBR,   " + 
		"					JURSD_TYP_CD,   " + 
		"					JURSD_LVL_CD,   " + 
		"					JURSD_CD,   " + 
		"					TAX_PAYMT_AUTH_FLG,   " + 
		"					TAX_EXMPT_ACTV_FLG,   " + 
		"					TAX_TYP_CD,   " + 
		"					TAX_CD,   " + 
		"					EFF_BGN_DT,   " + 
		"					EFF_END_DT,   " + 
		"					TAX_EXMPT_AMT,   " + 
		"					TAX_EXMPT_PCT   " + 
		"FROM		HCUST_TAX_RUL   " + 
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR ";
		
	/**
	 * Query used to get customer agent data
	 */
	public static final String GET_CUST_AGNT_SQL =  
		"SELECT	LOC_TYP_CD,   " + 
		"					LOC_NBR,   " + 
		"					SEQ_NBR,   " + 
		"					CRT_TS,   " + 
		"					JURSD_TYP_CD,   " + 
		"					JURSD_LVL_CD,   " + 
		"					JURSD_CD,   " + 
		"					CUST_ID_TYP_CD,   " + 
		"					CUST_ID_EXPIR_DT,   " + 
		"					CUST_ID_NBR,   " + 
		"					FRST_NM,   " + 
		"					MID_NM,   " + 
		"					LAST_NM,   " + 
		"					SFX_NM,   " + 
		"					TTL_NM,   " + 
		"					ACTV_FLG,   " + 
		"					LAST_UPD_USER_ID,   " + 
		"					LAST_UPD_TS   " + 
		"FROM		ORG_HCUST_AGNT   " + 
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR ";
		
	/**
	 * Query used to get customer insurance data
	 */
	public static final String GET_CUST_INSR_SQL = 
		"SELECT	INSR_PRVDR_NM, " +
		"		INSR_PLCY_NBR, " +
		"		INSR_PLCY_EXPIR_DT, " +
		"		PHN_AREA_CITY_CD, " +
		"		PHN_LOCL_NBR, " +
		"		PHN_EXT_NBR " +
		"FROM	HCUST_VHCL_INSR  " +
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR ";
		
	/**
	 * Query used to get customer rental data
	 */
	public static final String GET_CUST_RNTL_SQL = 	
		"SELECT	CUST_STAT_CD, " +
		"		DFLT_DEPST_METH_CD, " +
		"		DMG_WVR_REQD_FLG, " +
		"		CUST_PO_REQD_FLG, " +
		"		JOB_SITE_REQD_FLG, " +
		"		LTD_RNTL_CNT, " +
		"		LTD_RNTL_AMT, " +
		"		CUST_LAST_RNTL_DT, " +
		"		TAX_EXMPT_UPD_DT, " +
		"		FED_TAX_ID " +
		"FROM	RNTL_HCUST_DTL " +
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR ";		
		
	/**
	 * Query used to get customer unfavorable rental data
	 */
	public static final String GET_CUST_UNFVR_RACTVY_SQL =  
		"SELECT	LOC_NBR,   " + 
		"					LOC_TYP_CD,   " + 
		"					RAGREE_NBR,   " + 
		"					RPGM_PHN_ACTY_CD,   " + 
		"					RPGM_PHN_LOCL_NBR,   " + 
		"					RPGM_PHN_EXT_NBR,   " + 
		"					UNFVR_RACTVY_CD,   " + 
		"					UNFVR_RACTVY_AMT,   " + 
		"					RSLTN_DT,   " + 
		"					RAGREE_CLS_DT,   " + 
		"					LAST_UPD_USER_ID,   " + 
		"					LAST_UPD_TS,   " + 
		"					LOC_NM   " + 
		"FROM		HCUST_UNFVR_RACTVY   " + 
		"WHERE	STR_SVC_HCUST_NBR = ?   " +
		"AND			((LOC_TYP_CD <> ? AND LOC_NBR = ?) OR " +
		"					(LOC_TYP_CD = ? AND LOC_NBR <> ?)) WITH UR ";		
	/**
	 * Query used to get customer contact data
	 */
	public static final String GET_CUST_CNTCT_SQL = 
		"SELECT	CNTCT_HCUST_NBR,   " + 
		"					LOC_TYP_CD,   " + 
		"					LOC_NBR,   " + 
		"					SEQ_NBR,   " + 
		"					CNTCT_METH_CD,   " + 
		"					CNTCT_ADDR_TYP_CD,   " + 
		"					CNTCT_PHN_TYP_CD,   " + 
		"					CNTCT_EMAIL_TYP_CD,   " + 
		"					CNTCT_WK_BGN_TM,   " + 
		"					CNTCT_WK_END_TM,   " + 
		"					CNTCT_WKND_BGN_TM,   " + 
		"					CNTCT_WKND_END_TM,   " + 
		"					ACTV_FLG,   " + 
		"					AGNT_SEQ_NBR,   " + 
		"					AGNT_LOC_NBR,   " + 
		"					AGNT_LOC_TYP_CD   " + 
		"FROM		HCUST_CNTCT   " + 
		"WHERE	STR_SVC_HCUST_NBR = ? WITH UR ";	
} // end CustomerProtocol