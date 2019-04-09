package com.homedepot.ss.sh.webservices.lookup.sku.utils;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		ServiceLocator.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/utils/ServiceLocator.java_v   1.0   04 Oct 2004 09:26:28   rlp05  $
 */

// base class imports
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

// naming imports
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

// JNDI object imports
import javax.sql.DataSource;

// logging imports
import org.apache.log4j.Logger;

// application imports
import com.homedepot.ss.sh.webservices.lookup.sku.interfaces.SkuLookupProtocol;
import com.homedepot.ss.sh.webservices.lookup.sku.exceptions.ServiceLocatorException;

/*
 * ServiceLocator.java
 * 
 * Created: 	Sep 10, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   04 Oct 2004 09:26:28  $
 * 
 * This class is an implementation of the Service Locator pattern. It is
 * used to lookup resources such as EJBHomes, DataSources, JMS Queues, etc.
 * This implementation uses the "singleton" strategy and also the "caching"
 * strategy.
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/utils/ServiceLocator.java_v  $
 * 
 *    Rev 1.0   04 Oct 2004 09:26:28   rlp05
 * InitialRevision
 */
public class ServiceLocator implements SkuLookupProtocol
{
	//	version control variables
 	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/utils/ServiceLocator.java_v   1.0   04 Oct 2004 09:26:28   rlp05  $";
 	public static final String RCS_REVISION = "$Revision:   1.0  $";
 	
 	/**
 	 * Singleton instance
 	 */
 	private static ServiceLocator mInstance;
 	/**
 	 * JNDI context
 	 */
 	private Context mJNDIContext;
 	/**
 	 * used to cache JNDI objects
 	 */
 	private Map mCache;
 	/**
 	 * Object used for synchronization
 	 */
 	private static final Object mSynchObj = new Object();
 	/**
 	 * Logger instance
 	 */
 	private static final Logger mLogWriter = Logger.getLogger(ServiceLocator.class);
 	
 	/**
 	 * Default Constructor
 	 */
 	private ServiceLocator() throws ServiceLocatorException
 	{
 		try
 		{
 			// initialize the context
 			mJNDIContext = (Context)new InitialContext().lookup(DEFAULT_CONTEXT_NAME);
 			// initialize the cache
 			mCache = Collections.synchronizedMap(new HashMap());
 		} // end try
 		catch(NamingException ne)
 		{
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
 	public static ServiceLocator getInstance() throws ServiceLocatorException
 	{
 		// if the singleton instance hasn't been initialized yet
 		if(mInstance == null)
 		{
 			// synchronize the synch object so only one thread can create the instance
 			synchronized(mSynchObj)
 			{
 				// if the singleton instance still hasn't been initialized, create it
 				if(mInstance == null)
 				{
 					mInstance = new ServiceLocator();
 					mLogWriter.debug("ServiceLocator instance initialized successfully.");
 				} // end if
 			} // end synchronized
 		} // end if
 		
 		return mInstance;
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
				if(mLogWriter.isDebugEnabled())
				{
					mLogWriter.debug("Cache doesn't contain datasource '" + jndiName + 
						"', attempting to retrieve it from the container context");
				} // end if
				// otherwise get it from the JNDI context and add it to the cache.
				dataSrc = (DataSource)mJNDIContext.lookup(jndiName);
				mCache.put(jndiName, dataSrc);
				if(mLogWriter.isDebugEnabled())
				{
					mLogWriter.debug("Datasource '" + jndiName + "' successfully added to the cache");
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