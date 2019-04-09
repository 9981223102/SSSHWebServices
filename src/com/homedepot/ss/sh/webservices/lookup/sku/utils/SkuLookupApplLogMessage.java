package com.homedepot.ss.sh.webservices.lookup.sku.utils;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		SkuLookupApplLogMessage.java
 * Application:	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/utils/SkuLookupApplLogMessage.java_v   1.0   04 Oct 2004 09:26:40   rlp05  $
 */

import com.homedepot.ta.aa.log4j.ApplLogMessage;

/*
 * SkuLookupApplLogMessage.java
 * 
 * Created: 	Sep 10, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   04 Oct 2004 09:26:40  $
 * 
 * Class used to log messages to the APPL_LOG table 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/utils/SkuLookupApplLogMessage.java_v  $
 * 
 *    Rev 1.0   04 Oct 2004 09:26:40   rlp05
 * InitialRevision
 */
public class SkuLookupApplLogMessage extends ApplLogMessage
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/lookup/sku/utils/SkuLookupApplLogMessage.java_v   1.0   04 Oct 2004 09:26:40   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	
	/**
	 * Program Id
	 */
	private static final String PROGRAM_ID = "SKU-LOOKUP";
	
	/**
	 * Subsystem code
	 */
	private static final String SUBSYSTEM_CODE = "sh";

	/**
	 * Constructor
	 * 
	 * @param the message text
	 */
	public SkuLookupApplLogMessage(String msgTxt)
	{
		super(msgTxt);
	} // end constructor

	/**
	 * Constructor
	 *
	 * @param				msgNbr		The msg_nbr to log this exception with.
	 */
	public SkuLookupApplLogMessage(int msgNbr)
	{
		super(msgNbr);
	} // end constructor

	/**
	 * Constructor
	 *
	 * @param	the msg_nbr of the message
	 * @param  the message text
	 */
	public SkuLookupApplLogMessage(int msgNbr, String msgTxt)
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

}