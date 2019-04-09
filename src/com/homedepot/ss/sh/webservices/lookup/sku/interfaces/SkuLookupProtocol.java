package com.homedepot.ss.sh.webservices.lookup.sku.interfaces;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		SkuLookupProtocol.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/interfaces/SkuLookupProtocol.java_v   1.6   07 Dec 2004 12:45:28   rlp05  $
 */

/*
 * SkuLookupProtocol.java
 * 
 * Created: 	Sep 10, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.6  $	Last Updated: $Date:   07 Dec 2004 12:45:28  $
 * 
 * Sku lookup protocol file 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/interfaces/SkuLookupProtocol.java_v  $
 * 
 *    Rev 1.6   07 Dec 2004 12:45:28   rlp05
 * added COMMIT_CONNECTION_ERR_MSG
 * 
 *    Rev 1.5   07 Dec 2004 12:39:10   rlp05
 * added CLOSE_CONNECTION_ERR_MSG
 * 
 *    Rev 1.4   02 Dec 2004 08:08:32   rlp05
 * modified query to pull 10 skus back instead of one.
 * 
 *    Rev 1.3   19 Nov 2004 14:48:28   rlp05
 * added ROLLBACK_ERR_MSG constant
 * 
 *    Rev 1.2   06 Oct 2004 16:15:00   rlp05
 * removed with UR from GET_SKU_SQL to ensure only one thread has access to a given SKU number
 * 
 *    Rev 1.1   06 Oct 2004 10:20:12   rlp05
 * modified the name of the datasource to match the DS SUF created by the J2EE infrastructure team
 * 
 *    Rev 1.0   04 Oct 2004 09:26:04   rlp05
 * InitialRevision
 */
public interface SkuLookupProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/interfaces/SkuLookupProtocol.java_v   1.6   07 Dec 2004 12:45:28   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.6  $";
	/**
	 * Application server container name
	 */
	public static final String DEFAULT_CONTEXT_NAME = "java:comp/env";
	/**
	 * Datasource name
	 */
	public static final String DATASOURCE_NAME = "jdbc/SS.MM.CENT-SKU-SVC.001";
	/**
	 * SKU number column
	 */
	public static final String COL_SKU_NBR = "SKU_NBR";
	/**
	 * Query to get the next available SKU number
	 */
	public static final String GET_SKUS_SQL = "SELECT SKU_NBR FROM AVAIL_SKU ORDER BY LAST_UPD_TS ASC FETCH FIRST 20 ROWS ONLY WITH UR";
	/**
	 * Query to remove the retrieved SKU number from the table (preventing it from being used more than once)
	 */
	public static final String DEL_SKU_SQL = "DELETE FROM AVAIL_SKU WHERE SKU_NBR = ?";	
	/**
	 * SQL exception message number
	 */
	public static final String SQL_ERR_MSG_NBR = "25035"; // "Unable to query database for SKU information"
	/**
	 * SQL exception message
	 */
	public static final String SQL_ERR_MSG = "An exception occurred retrieving the next available SKU number from the database";
	/**
	 * Exception cleaning up PreparedStatement message
	 */
	public static final String PREP_STMT_ERR_MSG = "An exception occurred closing prepared statement";
	/**
	 * Exception cleaning up Statement message
	 */
	public static final String STMT_ERR_MSG = "An exception occurred closing statement";
	/**
	 * Exception cleaning up ResultSet message
	 */
	public static final String RESULTSET_ERR_MSG = "An exception occurred closing resultset";
	/**
	 * Exception retrieving datasource from context message
	 */
	public static final String DS_ERR_MSG = "A fatal exception was encountered retrieving a datasource instance from the JNDI context";
	/**
	 * Exception rolling back DB transaction
	 */
	public static final String ROLLBACK_ERR_MSG = "An exception occurred rolling back the database transaction";
	/**
	 * Exception closing database transaction
	 */
	public static final String CLOSE_CONNECTION_ERR_MSG = "An exception occurred closing database connection";
	/**
	 * Exception committing database transaction
	 */
	public static final String COMMIT_CONNECTION_ERR_MSG = "An exception occurred committing the database transaction";
} // end SkuLookupProtocol