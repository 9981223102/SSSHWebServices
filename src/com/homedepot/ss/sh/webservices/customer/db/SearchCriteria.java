package com.homedepot.ss.sh.webservices.customer.db;
/*
 * This program is proprietary to The Home Depot and is not to be reproduced,
 * used, or disclosed without permission of:
 *    The Home Depot
 *    2455 Paces Ferry Rd, N.W.
 *    Atlanta, GA, 30339-4024
 *
 * File Name: 	$Workfile:		CustomerWebService.java
 * Application:	SOSI Release 1	
 * 
 * $Header:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/db/SearchCriteria.java_v   1.0   31 Aug 2004 13:54:34   rlp05  $
 */

//Apache logging class(es)
import org.apache.log4j.Logger;

// Application class(es)
import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;
import com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;

/*
 * SearchCriteria.java
 * 
 * Created: 	Jul 6, 2004
 * 
 * @author		Lane Putnel
 * @version	$Revision:   1.0  $	Last Updated: $Date:   31 Aug 2004 13:54:34  $
 * 
 * Internally used search object
 * 
 * $Log:   V:/vcs/j2ee/ss/sh/SSSHWebServicesWeb/JavaSource/com/homedepot/ss/sh/webservices/customer/db/SearchCriteria.java_v  $
 * 
 *    Rev 1.0   31 Aug 2004 13:54:34   rlp05
 * InitialRevision
 */
public class SearchCriteria implements CustomerProtocol
{
	/**
	 * Indicates the type of customer search being performed
	 */
	private short mSearchTypCd;
	/**
	 * The location type performing this search
	 */
	private String mLocTypCd;
	/**
	 * The locatin number performing this search
	 */
	private String mLocNbr;
	/**
	 * Country code filter used for phone, DIY/PRO name, and customer id searches
	 */
	private String mCntryCd;
	/**
	 * Phone area/city filter used for phone searches
	 */
	private String mPhnAreaCityCd;
	/**
	 * Phone local number filter used for phone searches
	 */
	private String mPhnLoclNbr;
	/**
	 * Customer type filter used for phone number searches
	 */			
	private short mCustTypInd;
	/**
	 * First name filter used for DIY name searches 
	 */
	private String mFrstNm;
	/**
	 * Last name filter used for DIY name searches
	 */
	private String mLastNm;
	/**
	 * Organization name filter used for PRO name searches
	 */
	private String mOrgNm;
	/**
	 * Postal code filter used for DIY/PRO name searches
	 */
	private String mPstlCd;
	/**
	 * Customer ID type filter used for customer id searches
	 */
	private short mCustIdTypCd;
	/**
	 * Customer ID number filter used for customer id searches
	 */
	private String mCustIdNbr;
	/**
	 * Host customer number filter used for contact searches
	 */
	private int mHostCustNbr;
	/**
	 * City name filter used for PRO name searches
	 */
	private String mCityNm;
	/**
	 * State code filter used for PRO name searches
	 */
	private String mStCd;
	/**
	 * Logger instance
	 */
	private Logger mLogger;
	
	/**
	 * Constructor 
	 * 
	 * @param searchTypCd		The type of customer search being performed
	 */
	public SearchCriteria(short searchTypCd)
	{
		super();
		// set the search type
		mSearchTypCd = searchTypCd;
		// initialize the logger instance
		mLogger = Logger.getLogger(getClass());
	}
	
	/**
	 * Get the type of customer search being performed
	 * 
	 * @return		The type of customer search being performed
	 */
	public short getSearchTypCd()
	{
		return mSearchTypCd;
	}
	
	/**
	 * Set the type of customer search being performed
	 * 
	 * @param		The type of customer search being performed
	 */
	public void setSearchTypCd(short searchTypCd)
	{
		mSearchTypCd = searchTypCd;
	}
	
	/**
	 * Get the location type performing the search
	 * 
	 * @return		The location type performing the search
	 */
	public String getLocTypCd()
	{
		return mLocTypCd;
	}
	
	/**
	 * Set the location type performing the search
	 * 
	 * @param locTypCd		The location type performing the search
	 * 
	 * @throws CustomerWebServiceException		Thown if the value sent in is null, empty
	 * 			or has a length > 4
	 */
	public void setLocTypCd(String locTypCd) throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_LOC_TYP,
			locTypCd, MIN_PARM_LEN_LOC_TYP, EXC_CD_LOC_TYP);
		
		validateParameter(VAL_MAX_LEN, PARM_NM_LOC_TYP, 
			locTypCd, MAX_PARM_LEN_LOC_TYP, EXC_CD_LOC_TYP);

		mLocTypCd = locTypCd;
	}
	
	/**
	 * Get the location number performing the search
	 * 
	 * @return		The location type performing the search
	 */
	public String getLocNbr()
	{
		return mLocNbr;
	}
	
	/**
	 * Set the location type performing the search
	 * 
	 * @param locNbr	The location number performing the search
	 * 
	 * @throws CustomerWebServiceException		Thown if the value sent in is null, empty
	 * 			or has a length > 4
	 */
	public void setLocNbr(String locNbr) throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_LOC_NBR,
			locNbr, MIN_PARM_LEN_LOC_NBR, EXC_CD_LOC_NBR);
		
		validateParameter(VAL_MAX_LEN, PARM_NM_LOC_NBR, 
			locNbr, MAX_PARM_LEN_LOC_NBR, EXC_CD_LOC_NBR);

		mLocNbr = locNbr;
	}
		
	/**
	 * Get the country code filter used for phone, DIY/PRO name and customer id searches
	 * 
	 * @return		The country code filter value
	 */
	public String getCntryCd()
	{
		return mCntryCd;
	}
	
	/**
	 * Set the country code filter used for phone, DIY/PRO name and customer id searches
	 * 
	 * @param cntryCd		The country code filter
	 *
	 * @throws CustomerWebServiceException		Thown if the value sent in is null, empty
	 * 			or has a length > 2  
	 */
	public void setCntryCd(String cntryCd) throws CustomerWebServiceException
	{
		validateParameter(VAL_MAX_LEN, PARM_NM_CNTRY_CD, 
			cntryCd, MAX_PARM_LEN_CNTRY_CD, EXC_CD_CNTRY_CD);

		validateParameter(VAL_MIN_LEN, PARM_NM_CNTRY_CD, 
			cntryCd, MIN_PARM_LEN_CNTRY_CD, EXC_CD_CNTRY_CD);

		mCntryCd = cntryCd;
	}
	
	/**
	 * Get the phone area/city filter used for phone searches
	 * 
	 * @return		The phone area/city filter 
	 */
	public String getPhnAreaCityCd()
	{
		return mPhnAreaCityCd;
	}
	
	/**
	 * Set the area/city filter used for phone searches
	 * 
	 * @param phnAreaCityCd		The phone area/city filter
	 * 
	 * @throws CustomerWebServiceException		Thrown if the value sent in is null, empty
	 *			or has a length > 5
	 */
	public void setPhnAreaCityCd(String phnAreaCityCd) throws CustomerWebServiceException
	{
		validateParameter(VAL_MAX_LEN, PARM_NM_AREA_CD, 
			phnAreaCityCd, MAX_PARM_LEN_AREA_CD, EXC_CD_AREA_CD);

		validateParameter(VAL_MIN_LEN, PARM_NM_AREA_CD, 
			phnAreaCityCd, MIN_PARM_LEN_AREA_CD, EXC_CD_AREA_CD);

		mPhnAreaCityCd = phnAreaCityCd;
	}

	/**
	 * Get the phone local number filter used for phone searches
	 * 
	 * @return		The phone local number filter
	 */
	public String getPhnLoclNbr()
	{
		return mPhnLoclNbr;
	}
		
	/**
	 * Set the phone local number filter used for phone searches
	 * 
	 * @param phnLoclNbr		The phone local number filter
	 * 
	 * @throws CustomerWebServiceException		Thrown if the value sent in is null, empty
	 *			or has a length > 9
	 */
	public void setPhnLoclNbr(String phnLoclNbr) throws CustomerWebServiceException
	{
		validateParameter(VAL_MAX_LEN, PARM_NM_LOCL_NBR, 
			phnLoclNbr, MAX_PARM_LEN_LOCL_NBR, EXC_CD_LOCL_NBR);

		validateParameter(VAL_MIN_LEN, PARM_NM_LOCL_NBR, 
			phnLoclNbr, MIN_PARM_LEN_LOCL_NBR, EXC_CD_LOCL_NBR);

		mPhnLoclNbr = phnLoclNbr;
	}
	
	/**
	 * Get the customer type filter used for phone number searches
	 * 
	 * @return		The customer type filter
	 */
	public short getCustTypInd()
	{
		return mCustTypInd;
	}
	
	/**
	 * Set the customer type filter used for phone searches
	 * 
	 * @param custTypInd		The customer type filter
	 */
	public void setCustTypInd(short custTypInd)
	{
		mCustTypInd = custTypInd;
	}
	
	/**
	 * Get the first name filter used for DIY name searches
	 * 
	 * @return		The first name filter
	 */
	public String getFrstNm()
	{
		return mFrstNm;
	}

	/**
	 * Set the first name filter used for DIY name searches
	 * 
	 * @param frstNm					The first name filter 
	 * @param partialSearch		True if the first name needs to be set up for
	 * 												a partial search, false otherwise.
	 * 
	 * @throws CustomerWebServiceException		Thrown if the value sent in is null 
	 * 		or has a length < 1
	 */
	public void setFrstNm(String frstNm, boolean partialSearch) 
		throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_FRST_NM, frstNm, 
			MIN_PARM_LEN_FRST_NM, EXC_CD_FRST_NM);

		mFrstNm = frstNm;

		if(partialSearch)
		{
			mFrstNm = createLikeSQLValue(mFrstNm);
		}
	}
	
	/**
	 * Get the last name filter used for DIY name searches
	 * 
	 * @return		The last name filter
	 */
	public String getLastNm()
	{
		return mLastNm;
	}

	/**
	 * Set the last name filter used for DIY name searches
	 * 
	 * @param lastNm		The last name filter
	 * @param partialSearch		True if the first name needs to be set up for
	 * 												a partial search, false otherwise. 
	 * 
	 * @throws CustomerWebServiceException		Thrown if the value sent in is null
	 * 		or has a length < 1
	 */
	public void setLastNm(String lastNm, boolean partialSearch) 
		throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_LAST_NM, lastNm, 
			MIN_PARM_LEN_LAST_NM, EXC_CD_LAST_NM);

		mLastNm = lastNm;

		if(partialSearch)
		{
			mLastNm = createLikeSQLValue(mLastNm);
		}
	}
	
	/**
	 * Get the organization name filter used for PRO name searches
	 * 
	 * @return		The organization name filter
	 */
	public String getOrgNm()
	{
		return mOrgNm;
	}

	/**
	 * Set the organization name filter used for PRO name searches
	 * 
	 * @param orgNm		The organization name filter
	 * @param partialSearch		True if the first name needs to be set up for
	 * 												a partial search, false otherwise.
	 *  
	 * @throws CustomerWebServiceException		Thrown if the value sent in is null
	 * 		or has a length < 1
	 */
	public void setOrgNm(String orgNm, boolean partialSearch) 
		throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_ORG_NM, orgNm, 
			MIN_PARM_LEN_ORG_NM, EXC_CD_ORG_NM);

		mOrgNm = orgNm;

		if(partialSearch)
		{
			mOrgNm = createLikeSQLValue(mOrgNm);
		}
	}
	
	/**
	 * Get the postal code filter used for DIY/PRO name searches
	 * 
	 * @return		The postal code filter
	 */
	public String getPstlCd()
	{
		return mPstlCd;
	}

	/**
	 * Set the postal code filter used for DIY/PRO name searches
	 * 
	 * @param pstlCd		the postal code filter
	 * 
	 * @throws CustomerWebServiceException		Thrown if the value sent in is null,
	 * 		empty, or has a length > 5
	 */
	public void setPstlCd(String pstlCd) throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_PSTL_CD, pstlCd, 
			MIN_PARM_LEN_PSTL_CD, EXC_CD_PSTL_CD);

		mPstlCd = createLikeSQLValue(pstlCd.substring(0, MIN_PARM_LEN_PSTL_CD));
	}
	
	/**
	 * Get the customer id type filter used for customer id searches
	 * 
	 * @return		The customer id filter
	 */
	public short getCustIdTypCd()
	{
		return mCustIdTypCd;
	}
	
	/**
	 * Set the customer id type filter used for customer id searches
	 * 	
	 * @param custIdTypCd		The customer id type filter
	 */
	public void setCustIdTypCd(short custIdTypCd)
	{
		mCustIdTypCd = custIdTypCd;
	}

	/**
	 * Get the customer id number filter used for customer id searches
	 * 
 	 * @return		The customer id number filter
	 */
	public String getCustIdNbr()
	{
		return mCustIdNbr;	
	}
	
	/**
	 * Set the customer id number filter used for customer id searches
	 * 
	 * @param custIdNbr		The customer id number filter
	 * 
	 * @throws CustomerWebServiceException		Thrown if the value sent in is null
	 * 		or has a length < 1
	 */
	public void setCustIdNbr(String custIdNbr) throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_ID_NBR, custIdNbr, 
			MIN_PARM_LEN_ID_NBR, EXC_CD_ID_NBR);

		mCustIdNbr = custIdNbr;
	} 
	
	/**
	 * Get the host customer number filter used for contact searches
	 * @return
	 */
	public int getHostCustNbr()
	{
		return mHostCustNbr;
	}

	/**
	 * Set the host customer number filter used for contact searches
	 * 
	 * @param hostCustNbr		The host customer number filter
	 */
	public void setHostCustNbr(int hostCustNbr)
	{
		mHostCustNbr = hostCustNbr;
	}
	
	public String getCityNm()
	{
		return mCityNm;
	}

	public void setCityNm(String cityNm) throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_CITY_NM, cityNm, 
			MIN_PARM_LEN_CITY_NM, EXC_CD_CITY_NM);

		mCityNm = cityNm;
	}
	
	public String getStCd()
	{
		return mStCd;
	}
	
	public void setStCd(String stCd) throws CustomerWebServiceException
	{
		validateParameter(VAL_MIN_LEN, PARM_NM_ST_CD, stCd, 
			MIN_PARM_LEN_ST_CD, EXC_CD_ST_CD);

		mStCd = stCd;
	}
	
	/*
	 * Validate parameter length
	 *  
	 * @param validationType			Min/Max validation
	 * @param parmName				String name of the parameter used for logging/exception handling
	 * @param parmValue				Value of the parameter
	 * @param parmLength				Length the parameter is suppost to be over/under
	 * @param errCd							Exception code, used by calling application to retrieve language
	 * 													specific exception message
	 * @throws CustomerWebServiceException		Thrown if validation fails
	 */
	private void validateParameter(short validationType, String parmName, String parmValue,
		short parmLength, String errCd) throws CustomerWebServiceException
	{
		// if parameter is null throw an exception
		if(parmValue == null || parmValue.trim().length() == 0)
		{
			String errMsg = INV_PARM_TXT_1 + parmName + INV_PARM_NULL_TXT;
			mLogger.info(errMsg); 
			// throw exception
			throw new CustomerWebServiceException(errCd, errMsg);
		} // end if
		
		// strip any wildcards from the parameter value
		parmValue = stripWildcardChars(parmValue);
		
		// determine the type of validation to perform
		switch(validationType)
		{
			// validation not under minimum length
			case VAL_MIN_LEN:
			{
				// if the parameter is < length provided
				if(parmValue.trim().length() < parmLength)
				{
					String errMsg = INV_PARM_TXT_1 + parmName + INV_PARM_TXT_2 + parmValue + 
						INV_PARM_LESS_MIN + parmLength;
					mLogger.info(errMsg);
					throw new CustomerWebServiceException(errCd, errMsg);
				} // end if
				break;
			} // end case
			case VAL_MAX_LEN: 
			{
				// if the parameter is > length provided
				if(parmValue.trim().length() > parmLength)
				{
					String errMsg = INV_PARM_TXT_1 + parmName + INV_PARM_TXT_2 + parmValue +
						INV_PARM_GREAT_MAX + parmLength;
					throw new CustomerWebServiceException(errCd, errMsg);
				} // end if
				break;
			} // end case
		} // end switch
	} // end validateParameter
	
	/*
	 * Strip the wildcard character that would be located at the end of a search string
	 *  
	 * @param value		The string to strip the wildcard from
	 * @return					String without wildcard character
	 */
	private String stripWildcardChars(String value)
	{
		String updValue = value;
		// if the string ends with a *, strip it
		if(updValue.trim().endsWith(ASTERICK_WILDCARD))
		{
			updValue = updValue.substring(0, updValue.trim().length() - 1);
		} // end if
		// return the value minus the wildcard
		return updValue;
	} // end stripWildcardChars
	
	/*
	 * Create a SQL LIKE clause string
	 * 
	 * @param value			The value to create the like clause string from
	 * 
	 * @return						String ending with a %
	 */
	private String createLikeSQLValue(String value)
	{
		String updValue = stripWildcardChars(value);
		updValue += PERCENT_WILDCARD;
				
		return updValue;
	} // end createLikeSQLValue
	
	/**
	 * To String Method
	 * 
	 * @return		String representation of the SearchCriteria Object
	 */
	public String toString()
	{
		// create buffer
		StringBuffer retString = new StringBuffer(100);
		// populate buffer
		retString.append("Search Type: ").append(mSearchTypCd)
					   .append("\nLocation Type Code: ").append(mLocTypCd)
					   .append("\nLocation Number: ").append(mLocNbr)
					   .append("\nCountry Code: ").append(mCntryCd)
					   .append("\nPhone Area Code: ").append(mPhnAreaCityCd)
					   .append("\nPhone Local Number: ").append(mPhnLoclNbr)
					   .append("\nCustomer type: ").append(mCustTypInd)
					   .append("\nFirst Name: ").append(mFrstNm)
					   .append("\nLast Name; ").append(mLastNm)
					   .append("\nOrganization Name: ").append(mOrgNm)
					   .append("\nPostal Code: ").append(mPstlCd)
					   .append("\nCustomer Id Type: ").append(mCustIdTypCd)
					   .append("\nCustomer Id Number: " ).append(mCustIdNbr)
					   .append("\nHost Customer Number: ").append(mHostCustNbr)
					   .append("\n");
		// return string
		return retString.toString();
	} // end toString
} // end SearchCriteria