/**
 * TaxRateLookup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.taxrate;

public interface TaxRateLookup extends java.rmi.Remote {
    public com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateRecord getTaxRate(java.util.Calendar effectiveDate, java.lang.String zipCode, java.lang.String cityName, java.lang.String countyName, java.lang.String stateCode, java.lang.String countryCode) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.lookup.taxrate.exceptions.TaxLookupException;
}
