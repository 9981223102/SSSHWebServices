package com.homedepot.ss.sh.webservices.customer.utils;

/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		SearchRecordComparator.java
 * Application:	SOSI Release 1	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/SearchRecordComparator.java_v   1.0   31 Aug 2004 13:46:08   rlp05  $
 */
 
 // utitlity class(es)
import java.util.Comparator;

// application class(es)
import com.homedepot.ss.sh.webservices.customer.SearchRecord;

/*
 * SearchRecordComparator.java
 * 
 * Created: 	Jul 20, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:46:08  $
 * 
 * Comparator for the SearchRecord object 
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/SearchRecordComparator.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:46:08   rlp05
 * InitialRevision
 */
public class SearchRecordComparator implements Comparator
{
	//	version control variables
	public static final String RCS_HEADER = "$Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/utils/SearchRecordComparator.java_v   1.0   31 Aug 2004 13:46:08   rlp05  $";
	public static final String RCS_REVISION = "$Revision:   1.0  $";
	
	/**
	 * Compare search records using customer name
	 * 
	 * @param record1		First customer record
	 * @param record2		Second customer record
	 * 
	 * @return	<UL><LI>Negative integer if searchRecord1 is before searchRecord2</LI>
	 * 			<LI>0 if searchRecord1 is equal to searchRecord2</LI><LI>Positive integer if
	 * 			searchRecord1 is after searchRecord2</LI></UL>
	 */
	public int compare(Object record1, Object record2)
	{
		// get customer name from each search record
		String name1 = buildNameString((SearchRecord)record1);
		String name2 = buildNameString((SearchRecord)record2);
		// compare names
		return (name1.compareTo(name2));
	} // end compare
	
	/*
	 * Build the customer name. 
	 * 
	 * @param record		search record to get the name from
	 * 
	 * @return		<UL><LI>DIY customers - name in format "LastName", "FirstName"</LI>
	 * 				<LI>PRO customers - name in format "OrgName"</LI></UL>
	 */	
	private String buildNameString(SearchRecord record)
	{
		String results = null;
		
		// if it's a DIY customer, concatenate the last and first name seperated by a comma
		if(record.getOrgNm() == null || record.getOrgNm().trim().length() == 0)
		{
			results = record.getLastNm().trim() + ", " + record.getFirstNm().trim();
		} // end if
		// it's a PRO customer, just use organization name
		else
		{
			results = record.getOrgNm().trim();
		} // end else
		
		return results;
	} // end buildNameString
} // end SearchRecordComparator