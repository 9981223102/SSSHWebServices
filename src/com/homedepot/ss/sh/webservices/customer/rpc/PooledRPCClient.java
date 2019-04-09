package com.homedepot.ss.sh.webservices.customer.rpc;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		PooledRPCClient.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/PooledRPCClient.java_v   1.0   31 Aug 2004 13:47:30   rlp05  $
 */
// Input/Output class(es)
import java.io.IOException;

// Network class(es)
import java.net.InetAddress;

// RPC class(es)
import com.homedepot.ta.aa.JRPC.RPCError;

/*
 * PooledRPCClient.java
 * 
 * Created: 	Aug 16, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:47:30  $
 * 
 * Pooled RPC SMUDGE Client 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/PooledRPCClient.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:47:30   rlp05
 * InitialRevision
 */
public class PooledRPCClient extends shp825j
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/rpc/PooledRPCClient.java_v   1.0   31 Aug 2004 13:47:30   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	/**
	 * Indicates if the RPC client is in use
	 */
	private boolean mInUse;
	
	/**
	 * Constructor
	 * 
	 * @param host						Host name to create RPC client to
	 * @throws RPCError			Thrown if an RPC exception occurs
	 * @throws IOException		Thrown if an exception is encountered looking up the host provided
	 */
	public PooledRPCClient(InetAddress host) throws RPCError, IOException
	{
		super(host);
	} // end constructor
	
	/**
	 * Find out if this RPC client is available. If the client is available it is locked
	 * to be returned to the calling thread
	 *  
	 * @return		true if connection is available, false otherwise
	 */
	public synchronized boolean isAvail()
	{
		// if the client is in use, return false
		if(mInUse)
		{
			return false;
		} // end if
		
		// "lock" the client
		mInUse = true;
		// return true
		return mInUse;
	} // end isAvail
	
	/**
	 * Make the RPC client available for use again
	 */
	public synchronized void makeAvail()
	{
		mInUse = false;
	} // end makeAvail
} // end PooledRPCClient