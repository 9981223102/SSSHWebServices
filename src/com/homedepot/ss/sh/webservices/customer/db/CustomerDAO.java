package com.homedepot.ss.sh.webservices.customer.db;

/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		CustomerDAO.java
 * Application:	SOSI Release 1
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/db/CustomerDAO.java_v   1.7   19 Nov 2004 15:44:00   rlp05  $
 */

// base class(es)
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Calendar;

// logging class(es)
import org.apache.log4j.Logger;

// SQL class(es)
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// application class(es)
import com.homedepot.ss.sh.webservices.customer.AgentRecord;
import com.homedepot.ss.sh.webservices.customer.PhoneRecord;
import com.homedepot.ss.sh.webservices.customer.RentalRecord;
import com.homedepot.ss.sh.webservices.customer.SearchRecord;
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

import com.homedepot.ss.sh.webservices.customer.utils.CustomerRecordComparator;
import com.homedepot.ss.sh.webservices.customer.utils.SearchRecordComparator;
import com.homedepot.ss.sh.webservices.customer.utils.CustomerApplLogMessage;

import com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
/*
 * CustomerDAO.java
 * 
 * Created: 	Jul 27, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.7  $	Last Updated: $Date:   19 Nov 2004 15:44:00  $
 * 
 * Customer data access object 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/db/CustomerDAO.java_v  $
 * 
 *    Rev 1.7   19 Nov 2004 15:44:00   rlp05
 * modified to write specific message number to APPL_LOG for EMP monitoring
 * 
 *    Rev 1.6   23 Sep 2004 18:44:50   rlp05
 * modified the code to only lookup the hostname when the specific exception being written to APPL_LOG occurs
 * 
 *    Rev 1.5   23 Sep 2004 18:41:32   rlp05
 * added code to lookup hostname for logging to APPL_LOG so that the box the exception occurred on can be identified
 * 
 *    Rev 1.4   09 Sep 2004 08:48:04   rlp05
 * modified prepared statement arguments set when getting unfavorable rental detail
 * 
 *    Rev 1.3   03 Sep 2004 15:41:32   rlp05
 * modified code because getTimstamp(col, Calendar) not supported by version of DB/2 Connect currently being used. Changed
 * to add offset to make current time GMT format before tranmission back to client.
 * 
 *    Rev 1.2   03 Sep 2004 14:46:50   rlp05
 * modified getTimestamp() call to include calendar with GMT TimeZone instead of machines default
 * 
 *    Rev 1.1   01 Sep 2004 14:20:28   rlp05
 * modified code building structures from resultset to use getTimestamp() instead of getDate() to fix precision problems
 * 
 *    Rev 1.0   31 Aug 2004 13:54:44   rlp05
 * InitialRevision
 */
public class CustomerDAO implements CustomerProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/db/CustomerDAO.java_v   1.7   19 Nov 2004 15:44:00   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.7  $";
	// Logger instance
	private static Logger mLogger = Logger.getLogger(CustomerDAO.class);

	/**
	 * Execute customer lookup query
	 * 
	 * @param srchCriteria					Contains query filter
	 * @param returnSearchStruct		true if SearchRecord is to be returned, false otherwise
	 * @param connection						Database connection to use to execute the query
	 * @return											Array of customer objects
	 * @throws CustomerWebServiceException	Thrown if a database exception occurs
	 */
	public static Object[] lookupCustomer(SearchCriteria srchCriteria, boolean returnSearchStruct, 
		Connection connection) throws CustomerWebServiceException
	{
		long startTime = 0;
		
		if(mLogger.isDebugEnabled())
		{
			startTime = System.currentTimeMillis();
		}
		// initialize function variables
		ResultSet rs = null;
		Object[] results = null;
		PreparedStatement ps = null;
		boolean sortRecords = false;	
		
		if(mLogger.isDebugEnabled())
		{
			mLogger.debug("Performing search using the following criteria\n" + srchCriteria);
		}
		
		try
		{
			// figure out the type of search to run
			switch(srchCriteria.getSearchTypCd())
			{
				// search by phone number with a customer type filter
				case SEARCH_BY_PHN_FILT:
				{
					ps = connection.prepareStatement(DIY_PRO_PHN_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getPhnAreaCityCd());
					ps.setString(4, srchCriteria.getPhnLoclNbr());
					ps.setString(5, srchCriteria.getCntryCd());				
					ps.setInt(6, srchCriteria.getCustTypInd());		
					// sort the records programatically since temp tables are frounded upon in DB/2
					sortRecords = true;				
					break;
				} // end case SEARCH_BY_PHN_FILT
				// search by phone number without a customer type filter 
				case SEARCH_BY_PHN_UNFILT:
				{
					ps = connection.prepareStatement(PHN_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getPhnAreaCityCd());
					ps.setString(4, srchCriteria.getPhnLoclNbr());
					ps.setString(5, srchCriteria.getCntryCd());
//					sort the records programatically since temp tables are frounded upon in DB/2
					sortRecords = true;					
					break;
				} // end case SEARCH_BY_PHN_UNFILT
				// search customer name (DIY customer only)
				case SEARCH_BY_NAME:
				{
					ps = connection.prepareStatement(NAME_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getLastNm());
					ps.setString(4, srchCriteria.getFrstNm());
					ps.setString(5, srchCriteria.getPstlCd());
					ps.setString(6, srchCriteria.getCntryCd());
					break;
				} // end case SEARCH_BY_NAME
				// exact search by name
				case SEARCH_BY_NAME_EXACT:
				{	
					ps = connection.prepareStatement(EXACT_NAME_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getLastNm());
					ps.setString(4, srchCriteria.getFrstNm());
					ps.setString(5, srchCriteria.getPstlCd());
					ps.setString(6, srchCriteria.getCntryCd());					
					break;
				} // end SEARCH_BY_NAME_EXACT				
				// search by customer organization name / zip code (PRO customer only)
				case SEARCH_BY_ORG_NAME_ZIP:
				{
					ps = connection.prepareStatement(ORG_NAME_ZIP_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getOrgNm());
					ps.setString(4, srchCriteria.getPstlCd());
					ps.setString(5, srchCriteria.getCntryCd());
					break;
				} // end case SEARCH_BY_ORG_NAME
				// exact search by org name
				case SEARCH_BY_ORG_NAME_ZIP_EXACT:
				{
					ps = connection.prepareStatement(EXACT_ORG_NAME_ZIP_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getOrgNm());
					ps.setString(4, srchCriteria.getPstlCd());
					ps.setString(5, srchCriteria.getCntryCd());					
					break;
				} // end case SEARCH_BY_ORG_NAME_EXACT				
				case SEARCH_BY_ORG_NAME_CITY:
				{
					ps = connection.prepareStatement(ORG_NAME_CITY_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getOrgNm());
					ps.setString(4, srchCriteria.getCityNm());
					ps.setString(5, srchCriteria.getStCd());
					ps.setString(6, srchCriteria.getCntryCd());					
					break;				
				}
				case SEARCH_BY_ORG_NAME_CITY_EXACT:
				{
					ps = connection.prepareStatement(EXACT_ORG_NAME_CITY_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getOrgNm());
					ps.setString(4, srchCriteria.getCityNm());
					ps.setString(5, srchCriteria.getStCd());
					ps.setString(6, srchCriteria.getCntryCd());					
					break;
				}
				case SEARCH_BY_CUST_ID:
				{
					ps = connection.prepareStatement(CUST_ID_SEARCH_SQL);
					// set the variables
					ps.setString(1, srchCriteria.getLocNbr());
					ps.setString(2, srchCriteria.getLocTypCd());
					ps.setString(3, srchCriteria.getCustIdNbr());
					ps.setShort(4, srchCriteria.getCustIdTypCd());
					ps.setString(5, srchCriteria.getCntryCd());					
					break;
				} // end case SEARCH_BY_CUST_ID		
				// get contacts for customer
				case SEARCH_BY_CNTCT_HCUST:
				{
					ps = connection.prepareStatement(CONTACT_ID_SEARCH_SQL);
					// set the variables
					ps.setInt(1, srchCriteria.getHostCustNbr());
					break;
				} // end case SEARCH_BY_CNTCT_HCUST 
			} // end switch 
			
			// run the query
			rs = ps.executeQuery();
			
			if(mLogger.isDebugEnabled())
			{
				mLogger.debug("Total time to execute query: " + (System.currentTimeMillis() - startTime) + " milliseconds");
			} // end if
			// build the customer return objects
			results = buildReturnStructure(rs, returnSearchStruct, sortRecords, srchCriteria, connection);
						
		} // end try
		catch(SQLException sqle)
		{
			String hostName = "";
			try
			{		
				// set the hostname, used to log exceptions
				hostName = InetAddress.getLocalHost().getHostName();
			}
			catch(UnknownHostException uhe)
			{
				// do nothing, hostname is only used for writing to APPL_LOG
			}				
			// log the error
			mLogger.warn(new CustomerApplLogMessage(Integer.parseInt(EXC_CD_SRCH), hostName + " : " + EXC_SEARCH_CUST_RECS), sqle);
			// throw exception
			throw new CustomerWebServiceException(EXC_CD_SRCH, EXC_SEARCH_CUST_RECS);			
		} // end catch
		finally
		{
			closeQueryObjects(rs, ps);
		} // end finally
		// return the results
		return results;
	} // end lookupCustomer
	
	/**
	 * Get all customer data for the specified host customer number
	 * 
	 * @param srchCriteria					Contains query filter
	 * @param connection						Database connection to use to execute the query
	 * @return											Complete customer record
	 * @throws SQLException				Thrown if a database exception occurs
	 */
	public static CustomerRecord getCustomer(SearchCriteria srchCriteria, 
		Connection connection) throws SQLException
	{	
		long startTime = 0;
		
		if(mLogger.isDebugEnabled())
		{
			startTime = System.currentTimeMillis();	
		}
		
		// query object declarations
		ResultSet rs = null;
		PreparedStatement ps = null;
		// declare return object
		CustomerRecord customer = null;
		
		if(mLogger.isDebugEnabled())
		{
			mLogger.debug("Getting customer record using the following criteria\n" + srchCriteria);
		}
		
		try
		{
			// create the header prepared statement
			ps = connection.prepareStatement(GET_CUST_HDR_SQL);
			// set filter values
			ps.setString(1, srchCriteria.getLocNbr());
			ps.setString(2, srchCriteria.getLocTypCd());
			ps.setInt(3, srchCriteria.getHostCustNbr());
			// run the query
			rs = ps.executeQuery();
			
			// if the query yields a record
			if(rs.next())
			{
				// populate the customer header information
				customer = new CustomerRecord(rs);
				// clean up
				rs.close();
				ps.close();
			
				// define ArrayList to be used to build return arrays
				ArrayList resultsList = new ArrayList();	
				// prepare the address query
				ps = connection.prepareStatement(GET_CUST_ADDR_SQL);
				// set filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query 
				rs = ps.executeQuery();
				// populate the results (there should always be at least one record)
				// iterate resultset and build AddressRecords
				while(rs.next())
				{
					resultsList.add(new AddressRecord(rs));
				} // end while
				
				// move into AddressRecord[]
				if(resultsList.size() > 0)
				{
					AddressRecord[] addrRecords = new AddressRecord[resultsList.size()];
					addrRecords = (AddressRecord[])resultsList.toArray(addrRecords);
					// add address data to the customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					customer.setAddrRecords(addrRecords);
			
				} // end if
				// clean up
				rs.close();
				ps.close();
				resultsList.clear();
				
				// prepare the phone query
				ps = connection.prepareStatement(GET_CUST_PHN_SQL);
				// set filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results (there should always be at least one record)
				// iterate resultset and build PhoneRecords
				while(rs.next())
				{
					resultsList.add(new PhoneRecord(rs));
				} // end while
				
				if(resultsList.size() > 0)
				{
					// move into PhoneRecord[]
					PhoneRecord[] phnRecords = new PhoneRecord[resultsList.size()];
					phnRecords = (PhoneRecord[])resultsList.toArray(phnRecords);
					// add phone data to the customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					// WAS2TOMCAT Changes START
					customer.setPhoneRecords(phnRecords);
					// WAS2TOMCAT Changes END					
					
				} // end if
				// clean up
				rs.close();
				ps.close();
				resultsList.clear();
				
				// prepare the email query
				ps = connection.prepareStatement(GET_CUST_EMAIL_SQL);
				// set the filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				while(rs.next())
				{
					resultsList.add(new EmailAddressRecord(rs));
				} // end while
				
				if(resultsList.size() > 0)
				{
					// move into EmailAddressRecord[] 
					EmailAddressRecord[] emailAddrs = new EmailAddressRecord[resultsList.size()];
					emailAddrs = (EmailAddressRecord[])resultsList.toArray(emailAddrs);
					// add email data to the customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					// WAS2TOMCAT Changes START
					customer.setEmailAddrRecords(emailAddrs);
					// WAS2TOMCAT Changes END
					
				} // end if
				// clean up
				rs.close();
				ps.close();
				resultsList.clear();
				
				// prepare the customer id query
				ps = connection.prepareStatement(GET_CUST_ID_SQL);
				// set the filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				while(rs.next())
				{
					resultsList.add(new CustomerIdRecord(rs));
				} // end while
				
				if(resultsList.size() > 0)
				{
					// move into CustomerIdRecord[]
					CustomerIdRecord[] custIds = new CustomerIdRecord[resultsList.size()];
					custIds = (CustomerIdRecord[])resultsList.toArray(custIds);
					// add id data to the customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					// WAS2TOMCAT Changes START
					customer.setCustIdRecords(custIds);
					// WAS2TOMCAT Changes END
					
				} // end if
				// clean up
				rs.close();
				ps.close();
				resultsList.clear();
				
				// prepare the agent query
				ps = connection.prepareStatement(GET_CUST_AGNT_SQL);
				// set the filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				while(rs.next())
				{
					resultsList.add(new AgentRecord(rs));
				} // end while
				
				if(resultsList.size() > 0 && customer.getPRODetailRecord() != null)
				{
					// move into AgentRecord[] 
					AgentRecord[] agents = new AgentRecord[resultsList.size()];
					agents = (AgentRecord[])resultsList.toArray(agents);
					// add agent data to customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					// WAS2TOMCAT Changes START
					customer.getPRODetailRecord().setAgents(agents);
					// WAS2TOMCAT Changes END					

				} // end if
				// clean up
				rs.close();
				ps.close();
				resultsList.clear();
				
				// prepare the insurance query
				ps = connection.prepareStatement(GET_CUST_INSR_SQL);
				// set the filter values
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				if(rs.next())
				{
					VhclInsrRecord insrRecord = new VhclInsrRecord(rs);
					// add insurance data to the customer record
					customer.setVhclInsrRecord(insrRecord);
				} // end if
				// clean up
				rs.close();
				ps.close();
				
				// prepare the rental query
				ps = connection.prepareStatement(GET_CUST_RNTL_SQL);
				// set the filter values
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				if(rs.next())
				{
					RentalRecord rntlRecord = new RentalRecord(rs);
					// add rental data to the customer record
					customer.setRentalRecord(rntlRecord);
				} // end if
				// clean up
				rs.close();
				ps.close();
				
				// prepare the unfavorable rental query
				ps = connection.prepareStatement(GET_CUST_UNFVR_RACTVY_SQL);
				// set the filter values
				ps.setInt(1, srchCriteria.getHostCustNbr());
				ps.setString(2, srchCriteria.getLocTypCd());
				ps.setString(3, srchCriteria.getLocNbr());
				ps.setString(4, srchCriteria.getLocTypCd());
				ps.setString(5, srchCriteria.getLocNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				while(rs.next())
				{
					resultsList.add(new UnfvrRentalRecord(rs));
				} // end while
				
				if(resultsList.size() > 0)
				{
					// move into UnvfrRentalRecord[]
					UnfvrRentalRecord[] unfvrRentals = new UnfvrRentalRecord[resultsList.size()];
					unfvrRentals = (UnfvrRentalRecord[])resultsList.toArray(unfvrRentals);
					// add unfavorable rental data to customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					// WAS2TOMCAT Changes START
					customer.getRentalRecord().setUnfvrRactvyRecords(unfvrRentals);
					// WAS2TOMCAT Changes END					
					
				} // end if
				// clean up
				rs.close();
				ps.close();
				resultsList.clear();
				
				// prepare the contacts query
				ps = connection.prepareStatement(GET_CUST_CNTCT_SQL);
				//set the filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				while(rs.next())
				{
					resultsList.add(new ContactRecord(rs));
				} // end while
				
				if(resultsList.size() > 0)
				{
					// move into ContactRecord[]
					ContactRecord[] contacts = new ContactRecord[resultsList.size()];
					contacts = (ContactRecord[])resultsList.toArray(contacts);
					// add contact data to customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					// WAS2TOMCAT Changes START
					customer.setCntctRecords(contacts);
					// WAS2TOMCAT Changes END					
					
				} // end if
				// clean up
				rs.close();
				ps.close();
				resultsList.clear();			
				
				// prepare the taxbl stat query
				ps = connection.prepareStatement(GET_CUST_TAXBL_STAT_SQL);
				// set the filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				if(rs.next())
				{
					TaxblStatRecord taxblStat = new TaxblStatRecord(rs);
					// add taxbl stat data to the customer record
					customer.setTaxblStatRecord(taxblStat);
				} // end if
				// clean up
				rs.close();
				ps.close();
				
				// prepare the tax rule query
				ps = connection.prepareStatement(GET_CUST_TAX_RUL_SQL);
				// set the filter value
				ps.setInt(1, srchCriteria.getHostCustNbr());
				// run the query
				rs = ps.executeQuery();
				// populate the results
				while(rs.next())
				{
					resultsList.add(new TaxRuleRecord(rs));
				} // end while
				
				if(resultsList.size() > 0)
				{
					// move into TaxRuleRecord[]
					TaxRuleRecord[] taxRules = new TaxRuleRecord[resultsList.size()];
					taxRules = (TaxRuleRecord[])resultsList.toArray(taxRules);
					// add tax rule data to the customer record
					
					//Tomcat Migration-TCS Changes 08/12/2010
					// WAS2TOMCAT Changes START
					customer.setTaxRuleRecords(taxRules);
					// WAS2TOMCAT Changes END					
				} // end if
	
				if(mLogger.isDebugEnabled())
				{
					mLogger.debug("Total time to execute queries: " + (System.currentTimeMillis() - startTime) + " milliseconds");
				} // end if			
			} // end if
		} // end try
		finally
		{
			// clean up all query objects
			closeQueryObjects(rs, ps);
		} // end finally
		// return the customer object
		//System.out.println(customer.getEmailCltRqstDt());
		return customer;
	} // end getCustomer
		
	/*
	 * Build return array 
	 *  
	 * @param rs										Customer data
	 * @param returnSearchStruct			true to return SearchRecord[], 
	 * 															false to return CustomerRecord[]
	 * @param sortRecords						true if records are to be sorted programatically.
	 * @param srchCriteria						Search filter data
	 * @param connection						Database connection
	 * @return												Array of structures containing the customer data
	 * @throws SQLException					Thrown if a database exception occurs
	 */
	private static Object[] buildReturnStructure(ResultSet rs, boolean returnSearchStruct,
		boolean sortRecords, SearchCriteria srchCriteria, Connection connection) 
		throws SQLException
	{
		// function variable declarations
		Object[] results = null;
		// initialize a collection to temporarily hold results until they can be transfered into an array
		ArrayList resultsList = new ArrayList();
		// if a SearchRecord return is requested
		if(returnSearchStruct)
		{
			// iterate the resultset
			while(rs.next())
			{
				// add a new SearchRecord to the array
				resultsList.add(new SearchRecord(rs));	
			} // wend
			
			// initialize the results[]
			results = new SearchRecord[resultsList.size()];
			results = (SearchRecord[])resultsList.toArray(results);
			
			// sort records if required
			if(sortRecords)
			{
				long startTime = 0;
				if(mLogger.isDebugEnabled())
				{
					startTime = System.currentTimeMillis();
				}
				Arrays.sort(results, new SearchRecordComparator());
				if(mLogger.isDebugEnabled())
				{
					mLogger.debug("Total time to sort customer records: "  + (System.currentTimeMillis() - startTime) + " milliseconds");
				} // end if
			} // end if
		} // end if
		else
		{
			// an array of CustomerRecords is requested
			CustomerRecord customer = null;
			
			// iterate the resultset
			while(rs.next())
			{
				// create a new CustomerRecord
				customer = new CustomerRecord();
				// set common data values
				customer.setHostCustNbr(rs.getInt(COL_HOST_CUST_NBR));
				customer.setLocalCustNbr(rs.getInt(COL_LOCAL_CUST_NBR));
				customer.setCustTypCd(rs.getShort(COL_CUST_TYP_CD));
				customer.setCustStatCd(rs.getShort(COL_CUST_STAT_CD));
				customer.setSeqNbr(rs.getInt(COL_SEQ_NBR));
				/* 
				 * Time pulled from the resultset will be in the format of the timezone on the machine.
				 * Since this is the case, we will add the offset back to the time to make it GMT.
				 */
				Calendar calendar = Calendar.getInstance();
				if (rs.getTimestamp(COL_LAST_UPD_TS)!= null){
					calendar.setTime(rs.getTimestamp(COL_LAST_UPD_TS));
					int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
					calendar.add(Calendar.MILLISECOND, offset);
					
					//Tomcat Migration-TCS Changes 08/12/2010
					/*customer.setLastUpdTm(calendar.getTime());*/
					customer.setLastUpdTm(calendar);
				}
			
				// add partial address data
				AddressRecord addrRecord = new AddressRecord();
				addrRecord.setAddrLn1Txt(rs.getString(COL_ADDR_LINE1_TXT));
				addrRecord.setCityNm(rs.getString(COL_CITY_NM));
				addrRecord.setStCd(rs.getString(COL_ST_CD));
				addrRecord.setPstlCd(rs.getString(COL_PSTL_CD));
				
				//Tomcat Migration-TCS Changes 08/12/2010
				// WAS2TOMCAT Changes START
				customer.setAddrRecords(new AddressRecord[]{addrRecord});
				// WAS2TOMCAT Changes END				
				// add partial phone data
				PhoneRecord phnRecord = new PhoneRecord();
				phnRecord.setPhnNbrTypCd(rs.getShort(COL_PHN_NBR_TYP_CD));
				phnRecord.setPhnAreaCityCd(rs.getString(COL_PHN_AREA_CITY_CD));
				phnRecord.setPhnLoclNbr(rs.getString(COL_PHN_LOCAL_NBR));
				
				//Tomcat Migration-TCS Changes 08/12/2010
				// WAS2TOMCAT Changes START
				customer.setPhoneRecords(new PhoneRecord[]{phnRecord});
				// WAS2TOMCAT Changes END				
				// add DIY detail
				if(customer.getCustTypCd() == DIY_CUST_TYP_CD)
				{
					DIYDetailRecord diyRecord = new DIYDetailRecord();
					diyRecord.setFirstNm(rs.getString(COL_FRST_NM));
					diyRecord.setLastNm(rs.getString(COL_LAST_NM));
					customer.setDIYDetailRecord(diyRecord);
				} // end if
				else
				{
					// add PRO detail
					PRODetailRecord proRecord = new PRODetailRecord();
					proRecord.setOrgNm(rs.getString(COL_ORG_CUST_NM));
					customer.setPRODetailRecord(proRecord);
				} // end else
				// add the record to the return collection
				resultsList.add(customer);				
			} // wend
			
			// initialize the results[]
			results = new CustomerRecord[resultsList.size()];
			// if one row was returned, return the entire customer object
			if(resultsList.size() == 1)
			{
				// get the partial customer record
				customer = (CustomerRecord)resultsList.get(0);
				// set the host customer number in the search criteria
				srchCriteria.setHostCustNbr(customer.getHostCustNbr());
				// call getCustoemr
				results[0] = getCustomer(srchCriteria, connection);				
			} // end if
			else
			{
				// multiple rows were returned, so iterate the list and build the results[]
				results = (CustomerRecord[])resultsList.toArray(results);

				// sort records if required
				if(sortRecords)
				{
					long startTime = 0;
					if(mLogger.isDebugEnabled())
					{
						startTime = System.currentTimeMillis();
					}
					Arrays.sort(results, new CustomerRecordComparator());
					if(mLogger.isDebugEnabled())
					{
						mLogger.debug("Total time to sort customer records: "  + (System.currentTimeMillis() - startTime) + " milliseconds");
					} // end if	
				} // end if
			} // end else
		} // end else
		// return the results
		return results;
	} // buildReturnStructure
		
	/*
	 * Close open query objects
	 *  
	 * @param rs		ResultSet to close
	 * @param ps		PreparedStatement to close
	 */
	private static void closeQueryObjects(ResultSet rs, PreparedStatement ps)
	{
		if(rs != null)
		{
			try
			{
				rs.close();
			} // end try
			catch(SQLException sqle)
			{
				mLogger.warn(EXC_CLOSING_RESULTSET, sqle);
			} // end catch
		} // end if
		
		if(ps != null)
		{
			try
			{
				ps.close();
			} // end try
			catch(SQLException sqle)
			{
				mLogger.warn(EXC_CLOSING_PREPSTAT, sqle);
			} // end catch
		} // end if
	} // end closeQueryObjects
} // end CustomerDAO