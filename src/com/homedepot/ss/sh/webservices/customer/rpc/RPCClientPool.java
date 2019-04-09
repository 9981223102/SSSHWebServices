package com.homedepot.ss.sh.webservices.customer.rpc;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		RPCClientPool.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/RPCClientPool.java_v   1.0   31 Aug 2004 13:47:38   rlp05  $
 */

// Base class(es)
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Network class(es)
import java.net.InetAddress;

// logging class(es)
import org.apache.log4j.Logger;

// RPC class(es)
import com.homedepot.ta.aa.JRPC.RPCError;

// Architecture class(es)
import com.homedepot.ta.aa.util.TAAAProperties;
import com.homedepot.ta.aa.util.TAAAResourceManager;

// Application class(es)
import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;
import com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;

/*
 * RPCClientPool.java
 * 
 * Created: 	Aug 16, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:47:38  $
 * 
 * Pool of RPC clients for performance improvement 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/RPCClientPool.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:47:38   rlp05
 * InitialRevision
 */
public class RPCClientPool implements CustomerProtocol
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/RPCClientPool.java_v   1.0   31 Aug 2004 13:47:38   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	/**
	 * Pool of RPC clients
	 */
	private List mPool;
	/**
	 * Singleton instance
	 */
	private static RPCClientPool mSingleton;
	/**
	 * Synchronization object
	 */
	private static final Object mSynch = new Object();
	/**
	 * Logger instance
	 */
	private static Logger mLogger = Logger.getLogger(RPCClientPool.class);
	/**
	 * Number of RPC clients to initialize whenever singleton is created. The default is 2, to override this number
	 * set the "customer.webservice.cacheinit" property in taaa.properties
	 */
	private static int mRPCClientInit = TAAAResourceManager.getProperty(RPC_CLIENT_CACHE_INIT_PROP_NAME, RPC_CLIENT_CACHE_INIT_SIZE);
	/**
	 * Maximum number of RPC clients to cache. The default is 10, to override this number
	 * set the "customer.webservice.cachemax" property in taaa.properties
	 */
	private static int mRPCClientMax = TAAAResourceManager.getProperty(RPC_CLIENT_CACHE_MAX_PROP_NAME, RPC_CLIENT_CACHE_MAX_SIZE);
	/**
	 * Host name to create the RPC client to, this is the property set in the "service.rpchost" property
	 * in taaa.properties, default is cphpsrv1.
	 */
	public static String mHostName = TAAAResourceManager.getProperty(RPCSVR_CENTCUST, TAAAProperties.DEFAULT_RPCSVR);
	
	/**
	 * Constructor
	 * 
	 * @throws CustomerWebServiceException		Thrown if an exception occurs
	 * 					creating pooled RPC clients
	 */
	private RPCClientPool() throws CustomerWebServiceException
	{
		super();
		// initialize the connection pool container
		mPool = Collections.synchronizedList(new ArrayList(mRPCClientInit));
		if(mLogger.isDebugEnabled())
		{
			mLogger.debug("Client pool initialized with a size of " + mRPCClientInit);
		} // end if
		
		// create RPC clients and put them into the pool
		for(int i = 0; i < mRPCClientInit; i++)
		{
			mPool.add(createPooledClient());
			if(mLogger.isDebugEnabled())
			{
				mLogger.debug("RPC client connected to " + mHostName + " added to the client pool");
			} // end if
		} // end for
		
		mLogger.debug("RPCClientPool initialized");
	} // end constructor
	
	/**
	 * Singleton accessor method
	 * 
	 * @return			Singleton instance of RPCClientPool
	 * @throws CustomerWebServiceException		Thrown if an exception occurs initializing
	 * 			PooledRPCClients 
	 */
	public static RPCClientPool getInstance() throws CustomerWebServiceException
	{
		// if the singleton instance is null
		if(mSingleton == null)
		{
			// synchronize the synch object
			synchronized(mSynch)
			{
				// validate the singleton is still nul
				if(mSingleton == null)
				{
					mLogger.debug("RPCClientPool hasn't been initialized, creating...");
					// create the singleton instance
					mSingleton = new RPCClientPool();
				} // end if
			} // end synchronized
		} // end if
		// return the singleton
		return mSingleton;
	} // end getInstance
	
	/**
	 * Get a pooled RPC client
	 * 
	 * @return		A Pooled RPC client
	 * @throws CustomerWebServiceException		Thrown if an exception occurs
	 * 			creating Pooled RPC Client.
	 */
	public PooledRPCClient getRPCClient() throws CustomerWebServiceException
	{
		PooledRPCClient rpcClient = null;
		// iterate the cache and look for an available RPC client
		for(int i = 0; i < mPool.size(); i++)
		{
			// get the PooledRPCClient at the current index
			rpcClient = (PooledRPCClient)mPool.get(i);
			// check availability
			if(rpcClient.isAvail())
			{
				mLogger.debug("Available RPC client found in pool, returning...");
				// client is available, return the client
				return rpcClient;
			} // end if
		} // end for
		mLogger.debug("No available RPC clients exist in the pool, creating a new one...");
		// create a new RPCClient
		rpcClient = createPooledClient();
		// lock the RPC client
		rpcClient.isAvail();
		// put the locked client into the pool if pool size is less than max to cache
		if(mPool.size() < mRPCClientMax)
		{
			mPool.add(rpcClient);
			mLogger.debug("New RPC client created and added to the pool, pool size now: " + mPool.size());
		} // end if
		// return the newly created RPC client
		return rpcClient;
	} // end getRPCClient
	
	/**
	 * Release the RPC client back to the pool
	 * 
	 * @param client		The PooledRPCClient
	 */
	public void releaseRPCClient(PooledRPCClient client)
	{
		// release the PooledRPCClient
		client.makeAvail();
		mLogger.debug("RPC client released back to the pool");
	} // end releaseRPCClient
	
	/**
	 * Get the host name being used to create PooledRPCClient
	 * 
	 * @return		The host name
	 */
	public String getHostName()
	{
		return mHostName;
	} // end getHostName
	
	/**
	 * Set the host name being used to create PooledRPCClient
	 * 
	 * @param hostName		The host name
	 */
	public void setHostName(String hostName)
	{
		mHostName = hostName;
	} // end setHostName
	
	/*
	 * Create a PooledRPCClient
	 *  
	 * @return		New PooledRPCClient
	 * @throws CustomerWebServiceException		Thrown if an exception occurs
	 * 			creating the PooledRPCClient
	 */
	private PooledRPCClient createPooledClient() throws CustomerWebServiceException
	{
		PooledRPCClient rpcClient = null;
		// try to create a PooledRPCClient
		try
		{
			rpcClient = new PooledRPCClient(InetAddress.getByName(mHostName));			
		} // end try
		catch(RPCError rpce)
		{
			String errMsg = "An RPC exception occurred creating a new PooledRPCClient";
			mLogger.warn(errMsg, rpce);
			throw new CustomerWebServiceException(EXC_CD_RPC, errMsg);
		} // end catch	
		catch(Exception e)
		{
			String errMsg = "An exception occured creating a new PooledRPCClient";
			mLogger.warn(errMsg, e);
			throw new CustomerWebServiceException(EXC_CD_RPC, errMsg);
		} // end catch			
		// returned the PooledRPCClient
		return rpcClient;
	} // end createPooledClient
	
	/**
	 * Client is presumed unusable, respawn a new one in its place
	 * 
	 * @param client		Unusable PooledRPCClient
	 * @return					new PooledRPCClient
	 * @throws CustomerWebServiceException		Thrown if an exception occurs
	 * 			creating a new PooledRPCClient
	 */
	public PooledRPCClient respawnClient(PooledRPCClient client)
		throws CustomerWebServiceException
	{
		PooledRPCClient rpcClient = null;
		if(mPool.contains(client))
		{
			// if it's pooled, remove it from the pool
			client.close();
			mPool.remove(client);
			mLogger.debug("RPC Client dropped from the pool, respawning a new one to take its place..");
			// create a new client
			rpcClient = createPooledClient();
			// lock it
			rpcClient.isAvail();
			// add the new client to the pool
			mPool.add(rpcClient);
			mLogger.debug("New RPC client created and added to the pool, pool size now: " + mPool.size());			 
		} // end if
		else
		{
			client.close();
			mLogger.debug("RPC client closed, returning another client..");
			rpcClient = createPooledClient();
		} // end else
	
		return rpcClient;
	} // end respawnClient
	
	/**
	 * Clear the RPCClientPool
	 */
	public void removeAll()
	{
		// iterate the cache and close all of the RPC clients
		for(int i = 0; i < mPool.size(); i++)
		{
			((PooledRPCClient)mPool.get(i)).close();
			mLogger.debug("RPC client closed.");
		} // end for
	} // end removeAll
} // end RPCClientPool