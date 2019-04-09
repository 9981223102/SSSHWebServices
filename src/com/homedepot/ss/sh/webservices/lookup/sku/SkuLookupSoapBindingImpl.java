/**
 * SkuLookupSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.sku;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.homedepot.ss.sh.webservices.lookup.sku.db.SkuLookupDAO;
import com.homedepot.ss.sh.webservices.lookup.sku.exceptions.ServiceLocatorException;
import com.homedepot.ss.sh.webservices.lookup.sku.exceptions.SkuLookupException;
import com.homedepot.ss.sh.webservices.lookup.sku.interfaces.SkuLookupProtocol;
import com.homedepot.ss.sh.webservices.lookup.sku.utils.ServiceLocator;
import com.homedepot.ss.sh.webservices.lookup.sku.utils.SkuLookupApplLogMessage;

public class SkuLookupSoapBindingImpl implements com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup,SkuLookupProtocol{
    public int getNextAvailableSku() throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.lookup.sku.exceptions.SkuLookupException {
   	 long startTime = 0;
		int nextAvailSku = 0;
		DataSource ds = null;
		Connection connection = null;
		boolean commitTransaction = true;
		Logger logger = Logger.getLogger(getClass());
		
		try
		{
			if(logger.isDebugEnabled())
			{
				startTime = System.currentTimeMillis();
			} // end if
			
			logger.debug("Inside of getNextAvailableSku()");
			
			// get the datasource from the 
			ds = ServiceLocator.getInstance().getDataSource(DATASOURCE_NAME);
			// create a connection
			connection = ds.getConnection();
			// disable autocommits
			connection.setAutoCommit(false);
			logger.debug("AutoCommit disabled");
						
			// run the queries to get the next SKU number
			nextAvailSku = SkuLookupDAO.lookupSku(connection);
			
			if(logger.isDebugEnabled())
			{
				logger.debug("SKU " + nextAvailSku + " deleted successfully");
				logger.debug("Total time to lookup next available SKU(" + nextAvailSku + "): " + (System.currentTimeMillis() - startTime) + " milliseconds");
			} // end if
		} // end try
		catch(ServiceLocatorException sle)
		{			
			logger.fatal(new SkuLookupApplLogMessage(Integer.parseInt(SQL_ERR_MSG_NBR), getHostName() + ": " + DS_ERR_MSG), sle);
			throw new SkuLookupException(SQL_ERR_MSG_NBR, DS_ERR_MSG);
		} // end catch
		catch(SQLException sqle)
		{
			// log the SQL exception
			logger.fatal(new SkuLookupApplLogMessage(Integer.parseInt(SQL_ERR_MSG_NBR), getHostName() + ": " + SQL_ERR_MSG), sqle);
			// set flag so transaction is rolled back in finally block
			commitTransaction = false;
			// throw the exception						
			throw new SkuLookupException(SQL_ERR_MSG_NBR, SQL_ERR_MSG);
		} // end catch
		finally
		{		
			// if the transaction was not committed successfully, roll it back
			if(commitTransaction)
			{
				try
				{
					// commit the transaction
					connection.commit();
					logger.debug("Transaction committed successfully");
				}
				catch(SQLException sqle)
				{ 	
					// if the connection wasn't committed successfully, log the exception
					logger.fatal(new SkuLookupApplLogMessage(Integer.parseInt(SQL_ERR_MSG_NBR), getHostName()
						+ ": " + COMMIT_CONNECTION_ERR_MSG), sqle);
				} // end catch
			} // end if		
			else
			{
				try
				{
					connection.rollback();
					logger.debug("Transaction rolled back successfully");
				} // end try
				catch(SQLException nsqle)
				{
					// if the rollback failed, log the exception
					logger.fatal(new SkuLookupApplLogMessage(Integer.parseInt(SQL_ERR_MSG_NBR), getHostName() 
						+ ": " + ROLLBACK_ERR_MSG), nsqle);
				} // end catch
			} // end else
		
			// clean up the connection
			if(connection != null)
			{
				try
				{
					connection.close();
					logger.debug("Connection closed successfully");		
				} // end try
				catch(SQLException sqle)
				{
					logger.warn(CLOSE_CONNECTION_ERR_MSG, sqle);
				} // end catch
			} // end if		
		} // end finally
		
		//Tomcat Migration - TCS Changes 08/13/2010
		return nextAvailSku;
    }
    /*
 	 * Get the host name, used whenever writing to the APPL_LOG tables since
 	 * all WAS boxes log exceptions to the same database table.
 	 *  
 	 * @return		The hostname or empty string if an exception occurs looking
 	 * 				up the hostname
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
 		} // do nothing since hostname is only used for logging exception
 		
 		return hostName;
 	} // end getHostName()    

}
