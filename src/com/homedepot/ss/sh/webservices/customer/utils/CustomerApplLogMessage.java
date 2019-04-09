package com.homedepot.ss.sh.webservices.customer.utils;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		CustomerApplLogMessage.java
 * Application:	SOSI Release 1	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/CustomerApplLogMessage.java_v   1.0   31 Aug 2004 13:45:52   rlp05  $
 */

// THD WebSphere architecture class(es)
import com.homedepot.ta.aa.log4j.ApplLogMessage;

/*
 * CustomerApplLogMessage.java
 * 
 * Created: 	Jul 9, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:45:52  $
 * 
 * Used to create entries in the APPL_LOG tables from the WebSphere cluster 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/CustomerApplLogMessage.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:45:52   rlp05
 * InitialRevision
 */
public class CustomerApplLogMessage extends ApplLogMessage
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/CustomerApplLogMessage.java_v   1.0   31 Aug 2004 13:45:52   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	
	/**
	 * Program Id
	 */
	private static final String PROGRAM_ID = "CENT-CUST";
	
	/**
	 * Subsystem code
	 */
	private static final String SUBSYSTEM_CODE = "sh";

	/**
	 * Constructor
	 * 
	 * @param the message text
	 */
	public CustomerApplLogMessage(String msgTxt)
	{
		super(msgTxt);
	} // end constructor

	/**
	 * Constructor
	 *
	 * @param				msgNbr		The msg_nbr to log this exception with.
	 */
	public CustomerApplLogMessage(int msgNbr)
	{
		super(msgNbr);
	} // end constructor

	/**
	 * Constructor
	 *
	 * @param	the msg_nbr of the message
	 * @param  the message text
	 */
	public CustomerApplLogMessage(int msgNbr, String msgTxt)
	{
		super(msgNbr, msgTxt);
	} // end constructor

	/**
	 *  get the program id for this class
	 */
	public String getProgramID()
	{
		return PROGRAM_ID;
	} // end getProgramID

	/**
	 * get the subsystem code for this class
	 */
	public String getSubsystemCode()
	{
		return SUBSYSTEM_CODE;
	} // end SubsystemCode
} // end CustomerApplLogMessage