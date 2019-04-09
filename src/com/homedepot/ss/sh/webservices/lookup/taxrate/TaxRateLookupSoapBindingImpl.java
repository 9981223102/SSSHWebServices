/**
 * TaxRateLookupSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.taxrate;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.homedepot.ss.sh.webservices.lookup.taxrate.exceptions.TaxLookupException;
import com.homedepot.ss.sh.webservices.lookup.taxrate.interfaces.TaxRateLoookupProtocol;
import com.homedepot.ss.sh.webservices.lookup.taxrate.utils.TaxRateApplLogMessage;
import com.homedepot.ta.aa.exceptions.services.lookup.LookupServiceException;
import com.homedepot.ta.aa.interfaces.services.lookup.LookupServiceProxy;
import com.homedepot.ta.aa.interfaces.services.lookup.TaxRates;

public class TaxRateLookupSoapBindingImpl implements
		com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookup,
		TaxRateLoookupProtocol {
	public com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateRecord getTaxRate(
			java.util.Calendar effectiveDate, java.lang.String zipCode,
			java.lang.String cityName, java.lang.String countyName,
			java.lang.String stateCode, java.lang.String countryCode)
			throws java.rmi.RemoteException,
			com.homedepot.ss.sh.webservices.lookup.taxrate.exceptions.TaxLookupException {
		// create a logger instance
		Logger logger = Logger.getLogger(getClass());
		// validate effective date not null, other data validations occur in
		// SMUDGE client

		// Tomcat Migration - TCS Changes 08/13/2010
		/* if(effectiveDate == null) */
		if (effectiveDate == null) {
			String errMsg = "Effective date contained the following invalid value 'null'";
			logger.debug(errMsg);
			throw new TaxLookupException(ERR_MSG_EFF_DT, errMsg);
		} // end if

		// validate zip code isn't null or empty
		// Tomcat Migration - TCS Changes 08/13/2010
		/* if(zipCode == null || zipCode.trim().length() == 0) */
		if (zipCode == null
				|| zipCode.trim().length() == 0)

		{
			// Tomcat Migration - TCS Changes 08/13/2010
			/*
			 * String errMsg =
			 * "Postal code parameter contains the following invalid value '" +
			 * (zipCode == null ? "null" : zipCode) + "'";
			 */
			String errMsg = "Postal code parameter contains the following invalid value '"
					+ (zipCode == null ? "null"
							: zipCode) + "'";

			logger.debug(errMsg);
			throw new TaxLookupException(ERR_MSG_PSTL_CD, errMsg);
		} // end if

		// validate the city name isn't null or empty
		// Tomcat Migration - TCS Changes 08/13/2010
		/* if(cityName == null || cityName.trim().length() == 0) */
		if (cityName == null
				|| cityName.trim().length() == 0)

		{
			// Tomcat Migration - TCS Changes 08/13/2010
			/*
			 * String errMsg =
			 * "City name parameter contains the following invalid value '" +
			 * (cityName == null ? "null" : cityName) + "'";
			 */
			String errMsg = "City name parameter contains the following invalid value '"
					+ (cityName == null ? "null"
							: cityName) + "'";
			logger.debug(errMsg);
			throw new TaxLookupException(ERR_MSG_CITY_NM, errMsg);
		} // end if

		// validate the county name isn't null or empty
		// Tomcat Migration - TCS Changes 08/13/2010
		/* if(countyName == null || countyName.trim().length() == 0) */
		if (countyName == null
				|| countyName.trim().length() == 0)

		{
			// Tomcat Migration - TCS Changes 08/13/2010
			/*
			 * String errMsg =
			 * "County name parameter contains the following invalid value '" +
			 * (countyName == null ? "null" : countyName) + "'";
			 */
			String errMsg = "County name parameter contains the following invalid value '"
					+ (countyName == null ? "null"
							: countyName) + "'";
			logger.debug(errMsg);
			throw new TaxLookupException(ERR_MSG_COUNTY_NM, errMsg);
		} // end if

		// validate the state code isn't null or empty
		// Tomcat Migration - TCS Changes 08/13/2010
		/* if(stateCode == null || stateCode.trim().length() == 0) */
		if (stateCode == null
				|| stateCode.trim().length() == 0) {
			// Tomcat Migration - TCS Changes 08/13/2010
			/*
			 * String errMsg =
			 * "State code parameter containse the following invalid value '" +
			 * (stateCode == null ? "null" : stateCode) + "'";
			 */
			String errMsg = "State code parameter containse the following invalid value '"
					+ (stateCode == null ? "null"
							: stateCode) + "'";
			logger.debug(errMsg);
			throw new TaxLookupException(ERR_MSG_ST_CD, errMsg);
		} // end if

		// validate the country code isn't null or empty
		// Tomcat Migration - TCS Changes 08/13/2010
		/* if(countryCode == null || countryCode.trim().length() == 0) */
		if (countryCode == null
				|| countryCode.trim().length() == 0) {
			// Tomcat Migration - TCS Changes 08/13/2010
			/*
			 * String errMsg =
			 * "Country code parameter contains the following invalid value '" +
			 * (countryCode == null ? "null" : countryCode) + "'";
			 */
			String errMsg = "Country code parameter contains the following invalid value '"
					+ (countryCode == null ? "null"
							: countryCode) + "'";
			logger.debug(errMsg);
			throw new TaxLookupException(ERR_MSG_COUNTRY_CD, errMsg);
		} // end if

		// create a return object
		TaxRateRecord taxRateRecord = new TaxRateRecord();
		// create an instance of the architecture SMUDGE client
		LookupServiceProxy smudgeClient = new LookupServiceProxy();
		// route the request to the legacy RPC server
		try {
			long startTime = 0;

			if (logger.isDebugEnabled()) {
				startTime = System.currentTimeMillis();
			}
			// Tomcat Migration - TCS Changes 08/13/2010
			/*
			 * TaxRates rates = smudgeClient.getTaxRate(effectiveDate, zipCode,
			 * cityName, countyName, stateCode, countryCode);
			 */
			TaxRates rates = smudgeClient.getTaxRate(
					effectiveDate.getTime(),
					zipCode, cityName,
					countyName, stateCode,
					countryCode);

			// log the total lookup time if debug enabled
			if (logger.isDebugEnabled()) {
				/*
				 * logger.debug("Total time to lookup tax rates for " + zipCode
				 * + " : " + (System.currentTimeMillis() - startTime) +
				 * " milliseconds");
				 */
				logger.debug("Total time to lookup tax rates for "
						+ zipCode + " : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");

			} // end if
			// populate the return structure
			taxRateRecord.setSalesTax(rates.getSalesTax());
			taxRateRecord.setFreightTax(rates.getFreightTax());
			taxRateRecord.setLaborTax(rates.getLaborTax());
			taxRateRecord.setUseTax(rates.getUseTax());
			taxRateRecord.setPSTincGST(rates.getPSTincGST());
		} // end try
		catch (LookupServiceException lse) {
			String hostName = "";

			try {
				hostName = InetAddress.getLocalHost().getHostName();
			} catch (UnknownHostException uhe) {
				// do nothing, only used for writing to APPL_LOG
			}
			// log the exception and throw a wrapped exception
			String errMsg = hostName
					+ " : A RPC exception occurred looking up tax rate";
			logger.warn(new TaxRateApplLogMessage(Integer
					.parseInt(ERR_MSG_RPC_ERR), errMsg), lse);
			throw new TaxLookupException(ERR_MSG_RPC_ERR, errMsg);
		} // end catch

		// return the structure
		// Tomcat Migration - TCS Changes 08/13/2010
		return taxRateRecord;
		// end getTaxRate()

		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#getTaxRate");

	}

}
