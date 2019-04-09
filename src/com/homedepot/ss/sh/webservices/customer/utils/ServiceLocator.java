package com.homedepot.ss.sh.webservices.customer.utils;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		CustomerServiceLocator.java
 * Application:	SOSI Release 1	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/ServiceLocator.java_v   1.0   31 Aug 2004 13:46:20   rlp05  $
 */

// utility class(es)
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

// JNDI class(es)
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// Apache logging class(es)
import org.apache.log4j.Logger;

// Application class(es)
import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;
import com.homedepot.ss.sh.webservices.customer.exceptions.ServiceLocatorException;

/*
 * CustomerServiceLocator.java
 * 
 * Created: 	Jul 9, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:46:20  $
 * 
 * This class is an implementation of the Service Locator pattern. It is
 * used to lookup resources such as EJBHomes, DataSources, JMS Queues, etc.
 * This implementation uses the "singleton" strategy and also the "caching"
 * strategy.
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/ServiceLocator.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:46:20   rlp05
 * InitialRevision
 */
public class ServiceLocator implements CustomerProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/ServiceLocator.java_v   1.0   31 Aug 2004 13:46:20   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	/**
	 * Singleton instance
	 */
	private static ServiceLocator mSvcLocator;
	/**
	 * JNDI context
	 */
	private Context mJNDICtx;
	/**
	 * Used to cache JNDI objects
	 */
	private Map mCache;
	/**
	 * Used for synchronization
	 */
	private static final Object mSynch = new Object();
	/**
	 * Logger instance
	 */
	private static final Logger mLogger = Logger.getLogger(ServiceLocator.class);
	
	/*
	 * Default Constructor
	 */
	private ServiceLocator() throws ServiceLocatorException
	{
		try
		{
			// initialize the JNDI context			
			mJNDICtx = (Context)new InitialContext().lookup(DEFAULT_CONTEXT_NAME);
			// initialize the cache
			mCache = Collections.synchronizedMap(new HashMap());
		} // end try
		catch(NamingException ne)
		{
			// an exception occurred retrieving container JNDI context
			throw new ServiceLocatorException(ne);
		} // end catch
	} // end constructor
	
	/**
	 * Singleton accessor method
	 * 
	 * @return		The singleton instance
	 * 
	 * @throws ServiceLocatorException	Thrown if an exception is encountered 
	 * 									creating the JNDI context.
	 */
	public static ServiceLocator getInstance() 
		throws ServiceLocatorException
	{
		// see if the singleton instance has been initialized yet
		if(mSvcLocator == null)
		{
			// synchronize this object so only one thread can create the instance 
			synchronized(mSynch)
			{
				// if after synchronized the singleton still hasn't been initialized, create it.
				if(mSvcLocator == null)
				{
					mSvcLocator = new ServiceLocator();
					mLogger.debug("ServiceLocator instance initialized successfully");
				} // end if
			} // end synchronized
		} // end if
		// return singleton
		return mSvcLocator;
	} // end getInstance
	
	/**
	 * Lookup the specified datasource. The cache is checked before performing the 
	 * JNDI lookup
	 * 
	 * @param jndiName		The JNDI name of the datasource
	 * 
	 * @return				DataSource
	 * @throws ServiceLocatorException 	Thrown if an exception is encountered
	 * 									retrieving the DataSource from the JNDI
	 * 									context
	 */
	public DataSource getDataSource(String jndiName)
		throws ServiceLocatorException
	{
		DataSource dataSrc = null;
		
		try
		{
			// check the cache, if found return it
			if(mCache.containsKey(jndiName))
			{
				dataSrc = (DataSource)mCache.get(jndiName);	
			} // end if
			else
			{
				if(mLogger.isDebugEnabled())
				{
					mLogger.debug("Cache doesn't contain datasource '" + jndiName + 
						"', attempting to retrieve it from the container context");
				} // end if
				// otherwise get it from the JNDI context and add it to the cache.
				dataSrc = (DataSource)mJNDICtx.lookup(jndiName);
				mCache.put(jndiName, dataSrc);
				if(mLogger.isDebugEnabled())
				{
					mLogger.debug("Datasource '" + jndiName + "' successfully added to the cache");
				} // end if
			} // end else
		} // end try
		catch(NamingException ne)
		{
			// an exception occurred retrieving the object from the JNDI context
			throw new ServiceLocatorException(ne);
		} // end catch
		// return the data source
		return dataSrc;
	} // end getDataSource
} // end ServiceLocator