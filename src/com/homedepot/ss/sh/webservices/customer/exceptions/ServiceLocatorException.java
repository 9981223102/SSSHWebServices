package com.homedepot.ss.sh.webservices.customer.exceptions;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		ServiceLocatorException.java
 * Application:	SOSI Release 1
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/exceptions/ServiceLocatorException.java_v   1.0   31 Aug 2004 13:54:14   rlp05  $
 */

/*
 * ServiceLocatorException.java
 * 
 * Created: 	Jul 9, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:54:14  $
 * 
 * Exception thrown if the ServiceLocator encounters any errors 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/exceptions/ServiceLocatorException.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:54:14   rlp05
 * InitialRevision
 */
public class ServiceLocatorException extends Exception
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/exceptions/ServiceLocatorException.java_v   1.0   31 Aug 2004 13:54:14   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	
	/**
	 * Default Constructor
	 */
	public ServiceLocatorException()
	{
		super();
	} // end constructor
	
	/**
	 * Constructor
	 * 
	 * @param exception		Throwable to use to create this exception
	 */
	public ServiceLocatorException(Throwable exception)
	{
		super(exception.getMessage());
	} // end constructor
	
	/**
	 * Constructor
	 * 
	 * @param exception		String to use to create this exception
	 */
	public ServiceLocatorException(String exception)
	{
		super(exception);
	} // end constructor	
} // end ServiceLocatorException