package com.homedepot.ss.sh.webservices.lookup.sku.db;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		SkuLookupDAO.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/db/SkuLookupDAO.java_v   1.1   02 Dec 2004 08:09:04   rlp05  $
 */
 // query imports
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// logging imports
import org.apache.log4j.Logger;

// application imports
import com.homedepot.ss.sh.webservices.lookup.sku.interfaces.SkuLookupProtocol;

/*
 * SkuLookupDAO.java
 * 
 * Created: 	Sep 10, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.1  $	Last Updated: $Date:   02 Dec 2004 08:09:04  $
 * 
 * Data access object used to run the sku lookup queries
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/db/SkuLookupDAO.java_v  $
 * 
 *    Rev 1.1   02 Dec 2004 08:09:04   rlp05
 * modified to iterate through a list of 10 SKUs to handle multiple concurrent threads.
 * 
 *    Rev 1.0   04 Oct 2004 09:24:16   rlp05
 * InitialRevision
 */
public class SkuLookupDAO implements SkuLookupProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/db/SkuLookupDAO.java_v   1.1   02 Dec 2004 08:09:04   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.1  $";
	/**
	 * Logger instance
	 */
	private static Logger mLogger = Logger.getLogger(SkuLookupDAO.class);
	
	/**
	 * Run the queries required to lookup the next available sku number
	 * Runs the query defined by GET_SKUS_SQL in SkuLookupProtocol to get a list of sku's
	 * as of 2012-09-28 this list is the 20 oldes sku's in the list
	 * The it iterates through this list trying to delete each one
	 * The loop stops after it finds the first deletable (non-locked) sku, 
	 * and returns this value
	 * 
	 * @param connection							Database connection
	 * @return												Next available sku number
	 * @throws SkuLookupException		Thrown if a database exception is encountered
	 */
	public static int lookupSku(Connection connection) throws SQLException
	{
		int skuNbr = 0;
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		boolean skuObtained = false;
		
		try
		{
			// get the next 10 sku numbers from the table
			stmt = connection.createStatement();			
			// execute the query
			rs = stmt.executeQuery(GET_SKUS_SQL);
			
			/*
			 * Iterate the resultset and look for the first row
			 * that hasn't been deleted. This is being done because
			 * I cannot figure out how to make the query skip
			 * locked rows (isolation level isn't working).
			 */
			while(rs.next() && !skuObtained)
			{
				// get the sku number
				skuNbr = rs.getInt(COL_SKU_NBR);
				
				if(mLogger.isDebugEnabled())
				{
					mLogger.debug("Attempting to remove sku " + skuNbr + " from avail_sku");
				} // end if
				
				// prepare the statement to delete the sku number
				ps = connection.prepareStatement(DEL_SKU_SQL);
				// set the sku number
				ps.setInt(1, skuNbr);
				
				/*
				 * execute the query and set skuObtained to true if 
				 * the row was successfully deleted
				 */
				try
				{
					skuObtained = (ps.executeUpdate() == 1);
				} // end try
				catch(SQLException sqle)
				{
					// log the exception as a warning and continue on
					mLogger.warn(sqle);
				} // end catch
			} // end while
			
			/*
			 * If skuObtained is false (i.e. a sku number was not successfully
			 * deleted) throw an exception 
			 */
			if(!skuObtained)
			{
				throw new SQLException(SQL_ERR_MSG);
			} // end if
		} // end try
		finally
		{
			if(ps != null)
			{
				try
				{
					ps.close();
				} // end try
				catch(SQLException sqle)
				{
					mLogger.warn(PREP_STMT_ERR_MSG, sqle);
				} // end catch
			}
			if(stmt != null)
			{
				try
				{
					stmt.close();
				} // end try
				catch(SQLException sqle)
				{
					mLogger.warn(STMT_ERR_MSG, sqle);
				} // end catch
			} // end if
			if(rs != null)
			{
				try
				{
					rs.close();
				} // end try
				catch(SQLException sqle)
				{
					mLogger.warn(RESULTSET_ERR_MSG, sqle);
				} // end catch
			} // end if
		} // end finally
		
		return skuNbr;
	} // end lookupSku
} // end SkuLookupDAO