package com.homedepot.ss.sh.webservices.customer.rpc.net;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		RPCClientPoolServlet.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/net/RPCClientPoolServlet.java_v   1.0   31 Aug 2004 13:47:02   rlp05  $
 */

// Servlet class(es)
import javax.servlet.http.HttpServlet;

// logging class(es)
import org.apache.log4j.Logger;

// application class(es)
import com.homedepot.ss.sh.webservices.customer.rpc.RPCClientPool;
import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;
import com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;

/*
 * RPCClientPoolServlet.java
 * 
 * Created: 	Aug 16, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:47:02  $
 * 
 * Class runs when WebSphere App Server starts and creates a pool of customer RPC clients 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/net/RPCClientPoolServlet.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:47:02   rlp05
 * InitialRevision
 */
public class RPCClientPoolServlet extends HttpServlet
	implements CustomerProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/net/RPCClientPoolServlet.java_v   1.0   31 Aug 2004 13:47:02   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	
	public void init()
	{
		try
		{
			RPCClientPool.getInstance();
		} // end try
		catch(CustomerWebServiceException cwse)
		{
			Logger logger = Logger.getLogger(getClass());
			logger.warn("An exception occurred initializing the RPCClientPool upon startup");
		} // end catch
	} // end init
	
	public void destroy()
	{
		try
		{
			RPCClientPool.getInstance().removeAll();
		}
		catch(CustomerWebServiceException cwse)
		{
			Logger logger = Logger.getLogger(getClass());
			logger.warn("An exception occurred clearing the RPCClientPool.");
		}
	}
} // end RPCClientPoolServlet