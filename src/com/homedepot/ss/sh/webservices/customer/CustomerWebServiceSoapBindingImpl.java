/**
 * CustomerWebServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.homedepot.ss.sh.webservices.customer.db.CustomerDAO;
import com.homedepot.ss.sh.webservices.customer.db.SearchCriteria;
import com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
import com.homedepot.ss.sh.webservices.customer.exceptions.ServiceLocatorException;
import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;
import com.homedepot.ss.sh.webservices.customer.rpc.PooledRPCClient;
import com.homedepot.ss.sh.webservices.customer.rpc.RPCClientPool;
import com.homedepot.ss.sh.webservices.customer.rpc.RPCUtils;
import com.homedepot.ss.sh.webservices.customer.rpc.XDRgr_cc_appl_cb;
import com.homedepot.ss.sh.webservices.customer.utils.CustomerApplLogMessage;
import com.homedepot.ss.sh.webservices.customer.utils.ServiceLocator;
import com.homedepot.ta.aa.JRPC.RPCError;

public class CustomerWebServiceSoapBindingImpl implements
		com.homedepot.ss.sh.webservices.customer.CustomerWebService,
		CustomerProtocol {
	public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgNameCity(
			java.lang.String locTypCd, java.lang.String locNbr,
			java.lang.String orgNm, java.lang.String cityNm,
			java.lang.String stCd, java.lang.String cntryCd)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {

		// WAS2TOMCAT Changes START

		// create search filter object
		SearchCriteria srchCriteria = new SearchCriteria(
				SEARCH_BY_ORG_NAME_CITY_EXACT);

		// Tomcat Migration - Tcs Changes 08/12/2010
		srchCriteria.setLocTypCd(locTypCd);
		srchCriteria.setLocNbr(locNbr);
		srchCriteria.setOrgNm(orgNm, false);
		srchCriteria.setCityNm(cityNm);
		srchCriteria.setStCd(stCd);
		srchCriteria.setCntryCd(cntryCd);

		// Tomcat Migration- TCS changes 08/12/2010
		// return (SearchRecord[])executeSearch(srchCriteria, true);
		SearchRecord[] arrSearchRecords;
		
		arrSearchRecords = (SearchRecord[]) executeSearch(srchCriteria, true);
		ArrayOfSearchRecord arrayOfSearchRecord = new ArrayOfSearchRecord(arrSearchRecords);
		return arrayOfSearchRecord;
		// WAS2TOMCAT Changes END
	}

	public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByName(
			java.lang.String locTypCd, java.lang.String locNbr,
			java.lang.String firstNm, java.lang.String lastNm,
			java.lang.String pstlCd, java.lang.String cntryCd)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
			// WAS2TOMCAT Changes START
	   	 
	    	// create search filter object	
	   		SearchCriteria srchCriteria = new SearchCriteria(SEARCH_BY_NAME);
	 		               		
	   		srchCriteria.setLocTypCd(locTypCd);
	 		srchCriteria.setLocNbr(locNbr);
	 		srchCriteria.setFrstNm(firstNm, true);
	 		srchCriteria.setLastNm(lastNm, true);
	 		srchCriteria.setPstlCd(pstlCd);
	 		srchCriteria.setCntryCd(cntryCd);
 		
	 		SearchRecord[] arrSearchRecords =  ((SearchRecord[])executeSearch(srchCriteria, true));
			ArrayOfSearchRecord arrayOfSearchRecord = new ArrayOfSearchRecord(arrSearchRecords);
			return arrayOfSearchRecord;
			// WAS2TOMCAT Changes END	 		
	}

	public com.homedepot.ss.sh.webservices.customer.InsertRecord insertCustomer(
			java.lang.String locTypCd, java.lang.String locNbr,
			com.homedepot.ss.sh.webservices.customer.CustomerRecord customer)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
   	 	
		// WAS2TOMCAT Changes START
		long startTime = 0;
		Logger logger = Logger.getLogger(getClass().getName());
	
		if(logger.isDebugEnabled())
		{
			startTime = System.currentTimeMillis();
			logger.debug("Attempting customer insert for location type: " + locTypCd + ", location number: " 
				+ locNbr + ", customer data: " + customer.toString());
		}
		
		// validate the location type code
		if(locTypCd == null || locTypCd.trim().length() < MIN_PARM_LEN_LOC_TYP ||
				locTypCd.trim().length() > MAX_PARM_LEN_LOC_TYP)
		{
			String errMsg = INV_PARM_TXT_1 + PARM_NM_LOC_TYP + INV_PARM_TXT_2 + 
				(locTypCd == null ? "null" : locTypCd) + INV_PARM_TXT_3;
			logger.debug(errMsg);
			throw new CustomerWebServiceException(EXC_CD_LOC_TYP, errMsg);
		} // end if
		// validate the location number
		if(locNbr == null || locNbr.trim().length() < MIN_PARM_LEN_LOC_NBR ||
				locNbr.trim().length() > MAX_PARM_LEN_LOC_NBR)
		{
			String errMsg = INV_PARM_TXT_1 + PARM_NM_LOC_NBR + INV_PARM_TXT_2 +
				(locNbr == null ? "null" : locNbr) + INV_PARM_TXT_3; 
			logger.debug(errMsg);
			throw new CustomerWebServiceException(EXC_CD_LOC_NBR, errMsg);			
		}

		InsertRecord insRec = new InsertRecord();
		// set the local customer number
		insRec.setLocalCustNbr(customer.getLocalCustNbr());
		
		PooledRPCClient smudgeClient = null;
		
		try
		{
			// create a SMUDGE client and get the insert inbound argument
			smudgeClient = RPCClientPool.getInstance().getRPCClient();
			// get insert object
			smudgeClient.rpc_ins_thd_hcust_arg = RPCUtils.populateRPCInsStruct(smudgeClient.rpc_ins_thd_hcust_arg, 
					customer, locTypCd, locNbr);
							
			try
			{
				// call to insert
				smudgeClient.rpc_ins_thd_hcust();
			} // end try
			catch(IOException ioe)
			{
				logger.debug("An IOException occurred during customer insert.", ioe);
				
				// retry times 1
				smudgeClient = RPCClientPool.getInstance().respawnClient(smudgeClient);
				// get insert object
				smudgeClient.rpc_ins_thd_hcust_arg = RPCUtils.populateRPCInsStruct(smudgeClient.rpc_ins_thd_hcust_arg,
						customer, locTypCd, locNbr);
				// call to insert
				smudgeClient.rpc_ins_thd_hcust();
			} // end catch
			catch(RPCError rpce)
			{
				logger.debug("A RPCError occurred during customer insert", rpce);
				
				// retry times 1
				smudgeClient = RPCClientPool.getInstance().respawnClient(smudgeClient);
				// get insert object
				smudgeClient.rpc_ins_thd_hcust_arg = RPCUtils.populateRPCInsStruct(smudgeClient.rpc_ins_thd_hcust_arg, 
						customer, locTypCd, locNbr);
				// call to insert
				smudgeClient.rpc_ins_thd_hcust();
			} // end catch

			// check the application control block for errors
			XDRgr_cc_appl_cb ctrlBlock = smudgeClient.rpc_ins_thd_hcust_rtn.gr_cc_appl_cb;
			
			// will have to write code to throw an exception
			if(ctrlBlock.appl_rtn_cd != 0)
			{
				String errMsg = CTRL_BLOCK_ERR_TXT_1 + ctrlBlock.appl_rtn_cd + CTRL_BLOCK_ERR_TXT_2 + ctrlBlock.sqlawarn.trim();
				throw new RPCError(errMsg);
			} // end if
			
			// get the hcust number generated by the RPC server and set it in the return structure
			insRec.setHostCustNbr(smudgeClient.rpc_ins_thd_hcust_rtn.gr_hcust_list_ib.str_svc_hcust_nbr);
			if(logger.isDebugEnabled())
			{
				logger.debug("Total time to insert customer record " + (System.currentTimeMillis() - startTime) + " milliseconds");
			}			
		} // end try
		catch(IOException ioe)
		{
			logger.debug("An IOException occurred during customer insert.", ioe);
				
			logger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_RPC), getHostName() + " : " + INS_RPC_HOST_EXC), ioe);
			throw new CustomerWebServiceException(EXC_CD_RPC, INS_RPC_HOST_EXC);
		} // end catch			
		catch(RPCError rpce)
		{
			logger.debug("A RPCError occurred during customer insert", rpce);

			// second RPC call failed, throw an RPC exception
			logger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_RPC), getHostName() + " : " + INS_RPC_EXC), rpce);
			throw new CustomerWebServiceException(EXC_CD_RPC, INS_RPC_EXC);
		} // end catch						
		finally
		{
			if(smudgeClient != null)
			{
				// create a new inbound argument, since clients are pooled this acts as a reset mechanism				
				smudgeClient.rpc_ins_thd_hcust_arg = smudgeClient.new rpc_ins_thd_hcust_arg();
				RPCClientPool.getInstance().releaseRPCClient(smudgeClient);
			} // end if
		} // end finally
		return insRec;
		// WAS2TOMCAT Changes END		
	}

	public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExName(
			java.lang.String locTypCd, java.lang.String locNbr,
			java.lang.String firstNm, java.lang.String lastNm,
			java.lang.String pstlCd, java.lang.String cntryCd)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
		// WAS2TOMCAT Changes START
    	// create search filter object		
 		SearchCriteria srchCriteria = new SearchCriteria(SEARCH_BY_NAME_EXACT);
 		
 		//Tomcat Migration - Tcs Changes 08/12/2010
 		
 		srchCriteria.setLocTypCd(locTypCd);
 		srchCriteria.setLocNbr(locNbr);
 		srchCriteria.setFrstNm(firstNm, false);
 		srchCriteria.setLastNm(lastNm, false);
 		srchCriteria.setPstlCd(pstlCd);
 		srchCriteria.setCntryCd(cntryCd);

 		SearchRecord[] arrSearchRecord = (SearchRecord[])executeSearch(srchCriteria, true);
 		ArrayOfSearchRecord arrayOfSearchRecord = new ArrayOfSearchRecord(arrSearchRecord);
 		return arrayOfSearchRecord;
		// WAS2TOMCAT Changes END		
	}

	public com.homedepot.ss.sh.webservices.customer.CustomerRecord getCustomer(
			java.lang.String locTypCd, java.lang.String locNbr, int hcustNbr)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
    	
		// WAS2TOMCAT Changes START
		// query object declarations
 		DataSource ds = null;
 		Connection connection = null;
 		CustomerRecord customer = null;
 		long startTime = 0;
 		Logger logger = Logger.getLogger(getClass());
 		
 		try
 		{			
 			if(logger.isDebugEnabled())
 			{
 				startTime = System.currentTimeMillis();
 			}
 			// get the datasource from the container
 			ds = ServiceLocator.getInstance().getDataSource(DATASOURCE_NAME);
 			// create a database connection
 			connection = ds.getConnection();
 			if(logger.isDebugEnabled())
 			{
 				logger.debug("Total time to get a database connection: " + (System.currentTimeMillis() - startTime + " milliseconds"));
 			}
 			
 			SearchCriteria srchCriteria = new SearchCriteria(SEARCH_BY_HCUST_ID);
 			
 			srchCriteria.setLocTypCd(locTypCd);
 			srchCriteria.setLocNbr(locNbr);
 			srchCriteria.setHostCustNbr(hcustNbr);
 			
 			// execute the query
 			customer = CustomerDAO.getCustomer(srchCriteria, connection);
 		} // end try
 		catch(ServiceLocatorException sle)
 		{
 			logger.fatal(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_SRCH), getHostName() + " : " + EXC_GET_DS_FROM_CTX), sle);
 			throw new CustomerWebServiceException(EXC_CD_SRCH, EXC_GET_DS_FROM_CTX);
 		} // end catch
 		catch(SQLException sqle)
 		{
 			// a database exception occurred retrieving customer data
 			logger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_SRCH), getHostName() + " : " + EXC_GETTING_CUST_REC), sqle);
 			throw new CustomerWebServiceException(EXC_CD_SRCH, EXC_GETTING_CUST_REC);					
 		} // end catch
 		finally
 		{
 			if(connection != null)
 			{
 				try
 				{
 					connection.close();
 				}
 				catch(SQLException sqle)
 				{
 					logger.warn(EXC_CLOSING_CONNECTION, sqle);
 				}
 			}
 		} // end finally
 		
   		return customer;
	}

	public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgName(
			java.lang.String locTypCd, java.lang.String locNbr,
			java.lang.String orgNm, java.lang.String pstlCd,
			java.lang.String cntryCd)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {

			// WAS2TOMCAT Changes START
			// create search filter object
	 		SearchCriteria srchCriteria = new SearchCriteria(SEARCH_BY_ORG_NAME_ZIP);
	 	             		
	 		srchCriteria.setLocTypCd(locTypCd);
	 		srchCriteria.setLocNbr(locNbr);
	 		srchCriteria.setOrgNm(orgNm, true);
	 		srchCriteria.setPstlCd(pstlCd);
	 		srchCriteria.setCntryCd(cntryCd);
	 		
	 		SearchRecord[] arrSearchRecord = (SearchRecord[])executeSearch(srchCriteria, true);
	 		ArrayOfSearchRecord arrayOfSearchRecord = new ArrayOfSearchRecord(arrSearchRecord);
	 		return arrayOfSearchRecord;	 		
			// WAS2TOMCAT Changes END 	
	}

	public void updateCustomer(java.lang.String locTypCd,
			java.lang.String locNbr,
			com.homedepot.ss.sh.webservices.customer.CustomerRecord customer)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {

		// WAS2TOMCAT Changes START
   	 	long startTime = 0;
 		Logger logger = Logger.getLogger(getClass().getName());
 	
 		if(logger.isDebugEnabled())
 		{
 			startTime = System.currentTimeMillis();
 			logger.debug("Attempting customer update for location type: " + locTypCd +", location number: " 
 				+ locNbr + ", customer data: " + customer.toString());
 		}

 		// validate the location type code
 		if(locTypCd == null || (locTypCd.trim().length() < MIN_PARM_LEN_LOC_TYP ||
 				locTypCd.trim().length() > MAX_PARM_LEN_LOC_TYP))
 		{
 			String errMsg = INV_PARM_TXT_1 + PARM_NM_LOC_TYP + INV_PARM_TXT_2 + 
 				(locTypCd == null ? "null" : locTypCd) + INV_PARM_TXT_3;
 			logger.debug(errMsg);
 			throw new CustomerWebServiceException(EXC_CD_LOC_TYP, errMsg);
 		} // end if
 		// validate the location number
 		if(locNbr == null || locNbr.trim().length() < MIN_PARM_LEN_LOCL_NBR ||
 				locNbr.trim().length() > MAX_PARM_LEN_LOC_NBR)
 		{
 			String errMsg = INV_PARM_TXT_1 + PARM_NM_LOC_NBR + INV_PARM_TXT_2 +
 				(locNbr == null ? "null" : locNbr + INV_PARM_TXT_3);
 			logger.debug(errMsg);
 			throw new CustomerWebServiceException(EXC_CD_LOC_NBR, errMsg);			
 		}

 		PooledRPCClient smudgeClient = null;
 		
 		try
 		{
 			// create a SMUDGE client and get the update inbound argument
 			smudgeClient = RPCClientPool.getInstance().getRPCClient();
 			// get update object
 			smudgeClient.rpc_upd_thd_hcust_arg = RPCUtils.populateRPCUpdStruct(smudgeClient.rpc_upd_thd_hcust_arg, 
 					customer, locTypCd, locNbr);
 							
 			try
 			{
 				// call to update
 				smudgeClient.rpc_upd_thd_hcust();
 			} // end try
 			catch(IOException ioe)
 			{
 				logger.debug("An IOException occurred during customer update", ioe);
 				
 				// retry times 1
 				smudgeClient = RPCClientPool.getInstance().respawnClient(smudgeClient);
 				// get update object
 				smudgeClient.rpc_upd_thd_hcust_arg = RPCUtils.populateRPCUpdStruct(smudgeClient.rpc_upd_thd_hcust_arg,
 						customer, locTypCd, locNbr);
 				// call to update
 				smudgeClient.rpc_upd_thd_hcust();
 			} // end catch
 			catch(RPCError rpce)
 			{
 				logger.debug("A RPCError occurred during customer update", rpce);

 				// retry times 1
 				smudgeClient = RPCClientPool.getInstance().respawnClient(smudgeClient);
 				// get update object
 				smudgeClient.rpc_upd_thd_hcust_arg = RPCUtils.populateRPCUpdStruct(smudgeClient.rpc_upd_thd_hcust_arg, 
 						customer, locTypCd, locNbr);
 				// call to update
 				smudgeClient.rpc_upd_thd_hcust();
 			} // end catch

 			// check the application control block for errors
 			XDRgr_cc_appl_cb ctrlBlock = smudgeClient.rpc_upd_thd_hcust_arg.gr_cc_appl_cb;
 			
 			// will have to write code to throw an exception
 			if(ctrlBlock.appl_rtn_cd != 0)
 			{
 				String errMsg = CTRL_BLOCK_ERR_TXT_1 + ctrlBlock.appl_rtn_cd + CTRL_BLOCK_ERR_TXT_2 + ctrlBlock.sqlawarn.trim();
 				throw new RPCError(errMsg);
 			} // end if
 			
 			if(logger.isDebugEnabled())
 			{
 				logger.debug("Total time to update customer record " + (System.currentTimeMillis() - startTime) + " milliseconds");
 			}			
 		} // end try
 		catch(IOException ioe)
 		{
 			logger.debug("An IOException occurred during customer update", ioe);
 						
 			logger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_RPC), getHostName() + " : " + UPD_RPC_HOST_EXC), ioe);
 			throw new CustomerWebServiceException(EXC_CD_RPC, UPD_RPC_HOST_EXC);
 		} // end catch			
 		catch(RPCError rpce)
 		{
 			logger.debug("A RPCError occurred during customer update", rpce);
 						
 			// second RPC call failed, throw an RPC exception
 			logger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_RPC), getHostName() + " : " + UPD_RPC_EXC), rpce);
 			throw new CustomerWebServiceException(EXC_CD_RPC, UPD_RPC_EXC);
 		} // end catch						
 		finally
 		{
 			if(smudgeClient != null)
 			{
 				// create a new inbound argument, since clients are pooled this acts as a reset mechanism				
 				smudgeClient.rpc_upd_thd_hcust_arg = smudgeClient.new rpc_upd_thd_hcust_arg();
 				RPCClientPool.getInstance().releaseRPCClient(smudgeClient);
 			} // end if
 		} // end finally
 		// end updateCustomer
 		//throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#updateCustomer");
		// WAS2TOMCAT Changes END		
	}

	public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgNameCity(
			java.lang.String locTypCd, java.lang.String locNbr,
			java.lang.String orgNm, java.lang.String cityNm,
			java.lang.String stCd, java.lang.String cntryCd)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {

			// WAS2TOMCAT Changes START
			// create search filter object
	 		SearchCriteria srchCriteria = new SearchCriteria(SEARCH_BY_ORG_NAME_CITY);
	 		
	 		srchCriteria.setLocTypCd(locTypCd);
	 		srchCriteria.setLocNbr(locNbr);
	 		srchCriteria.setOrgNm(orgNm,true);
	 		srchCriteria.setCityNm(cityNm);
	 		srchCriteria.setStCd(stCd);
	 		srchCriteria.setCntryCd(cntryCd);
	 		
	 		SearchRecord[] arrSearchRecord = (SearchRecord[])executeSearch(srchCriteria, true);
	 		ArrayOfSearchRecord arrayOfSearchRecord = new ArrayOfSearchRecord(arrSearchRecord);
	 		return arrayOfSearchRecord;	 		
			// WAS2TOMCAT Changes END	 		
	}

	public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByPhone(
			java.lang.String locTypCd, java.lang.String locNbr,
			java.lang.String cntryCd, java.lang.String phnAreaCityCd,
			java.lang.String phnLoclNbr, short custTypInd)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {

		// WAS2TOMCAT Changes START
		// create search filter object
		SearchCriteria srchCriteria = new SearchCriteria(SEARCH_BY_PHN_UNFILT);
   	 
   	 	srchCriteria.setLocTypCd(locTypCd);
 		srchCriteria.setLocNbr(locNbr);
 		srchCriteria.setPhnAreaCityCd(phnAreaCityCd);
 		srchCriteria.setPhnLoclNbr(phnLoclNbr);
 		srchCriteria.setCntryCd(cntryCd);
 		
 		// if the DIY or PRO customer filter was passed in, set it
 		if(custTypInd == DIY_CUST_TYP_CD || custTypInd  ==PRO_CUST_TYP_CD)
		{
			srchCriteria.setSearchTypCd(SEARCH_BY_PHN_FILT);
			srchCriteria.setCustTypInd(custTypInd);
		}
 		SearchRecord[] arrSearchRecord = (SearchRecord[])executeSearch(srchCriteria, true);
 		ArrayOfSearchRecord arrayOfSearchRecord = new ArrayOfSearchRecord(arrSearchRecord);
 		return arrayOfSearchRecord;		
		// WAS2TOMCAT Changes END
	}

	public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgName(
			java.lang.String locTypCd, java.lang.String locNbr,
			java.lang.String orgNm, java.lang.String pstlCd,
			java.lang.String cntryCd)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
	    	// create search filter object
	 		SearchCriteria srchCriteria = new SearchCriteria(SEARCH_BY_ORG_NAME_ZIP_EXACT);
	 		
	 		srchCriteria.setLocTypCd(locTypCd);
	 		srchCriteria.setLocNbr(locNbr);
	 		srchCriteria.setOrgNm(orgNm, false);
	 		srchCriteria.setPstlCd(pstlCd);
	 		srchCriteria.setCntryCd(cntryCd);
	
	 		SearchRecord[] arrSearchRecord = (SearchRecord[])executeSearch(srchCriteria, true);
	 		ArrayOfSearchRecord arrayOfSearchRecord = new ArrayOfSearchRecord(arrSearchRecord);
	 		return arrayOfSearchRecord;
	}
	// WAS2TOMCAT Changes START
    private Object[] executeSearch(SearchCriteria srchCriteria, boolean returnSearchStruct)
		throws CustomerWebServiceException
	{
		long startTime = 0;
		// query object declarations
		DataSource ds = null;
		Connection connection = null;

		Object[] results = null;
		Logger logger = Logger.getLogger(getClass());
			
		 try
		 {
		 	if(logger.isDebugEnabled())
		 	{
		 		startTime = System.currentTimeMillis();
		 	}
			 // get the datasource from the container
			 ds = ServiceLocator.getInstance().getDataSource(DATASOURCE_NAME);
			 // create a database connection
			 connection = ds.getConnection();
			 
			 if(logger.isDebugEnabled())
			 {
				logger.debug("Total time to get a database connection: " + (System.currentTimeMillis() - startTime + " milliseconds"));	
			 }
			 
			 results = CustomerDAO.lookupCustomer(srchCriteria, returnSearchStruct, connection);
		}
		catch(ServiceLocatorException sle)
		{
			logger.fatal(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_SRCH), getHostName() + " : " + EXC_GET_DS_FROM_CTX), sle);
			throw new CustomerWebServiceException(EXC_CD_SRCH, EXC_GET_DS_FROM_CTX);
		} // end catch
		catch(SQLException sqle)
		{
			// a database exception occurred retrieving customer data
			logger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_SRCH), getHostName() + " : " + EXC_SEARCH_CUST_RECS), sqle);
			throw new CustomerWebServiceException(EXC_CD_SRCH, EXC_SEARCH_CUST_RECS);					
		} // end catch	
		 finally
		 {
			 if(connection != null)
			 {
				 try
				 {
					 connection.close();
				 } // end try
				 catch(SQLException sqle)
				 {
					logger.warn(EXC_CLOSING_CONNECTION, sqle);
				 } // end catch
			 } // end if
		 } // end finally		
		 return results;			
	} // end executeSearch	
    /*
 	 * Get the hostname of the machine. This is used when writing to the 
 	 * APPL_LOG table because all of the WebSphere instances write
 	 * to the same APPL_LOG table.
 	 *  
 	 * @return		The host name of the machine or "" if an exception occurs
 	 */
 	private String getHostName()
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
    
	// WAS2TOMCAT Changes END
}
