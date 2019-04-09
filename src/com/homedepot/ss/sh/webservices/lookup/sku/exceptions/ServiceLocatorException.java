package com.homedepot.ss.sh.webservices.lookup.sku.exceptions;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		ServiceLocatorException.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/exceptions/ServiceLocatorException.java_v   1.0   04 Oct 2004 09:24:40   rlp05  $
 */

/*
 * ServiceLocatorException.java
 * 
 * Created: 	Sep 10, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   04 Oct 2004 09:24:40  $
 * 
 * ========== CLASS DESCRIPTION GOES HERE ========== 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/exceptions/ServiceLocatorException.java_v  $
 * 
 *    Rev 1.0   04 Oct 2004 09:24:40   rlp05
 * InitialRevision
 */
public class ServiceLocatorException extends Exception
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/exceptions/ServiceLocatorException.java_v   1.0   04 Oct 2004 09:24:40   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";

	/**
	 * Default Constructor
	 */
	public ServiceLocatorException()
	{
		super();
	} // end ServiceLocatorException()

	/**
	 * Constructor
	 *
	 * @param exception		Throwable to use to create this exception
	 */
	public ServiceLocatorException(Throwable exception)
	{
		super(exception.getMessage());
	} // end ServiceLocatorException()

	/**
	 * Constructor
	 *
	 * @param exception		String to use to create this exception
	 */
	public ServiceLocatorException(String exception)
	{
		super(exception);
	} // end ServiceLocatorException()
} // end ServiceLocatorException