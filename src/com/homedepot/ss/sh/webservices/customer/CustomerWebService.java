/**
 * CustomerWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

public interface CustomerWebService extends java.rmi.Remote {
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgNameCity(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String cityNm, java.lang.String stCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String firstNm, java.lang.String lastNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.InsertRecord insertCustomer(java.lang.String locTypCd, java.lang.String locNbr, com.homedepot.ss.sh.webservices.customer.CustomerRecord customer) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String firstNm, java.lang.String lastNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.CustomerRecord getCustomer(java.lang.String locTypCd, java.lang.String locNbr, int hcustNbr) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public void updateCustomer(java.lang.String locTypCd, java.lang.String locNbr, com.homedepot.ss.sh.webservices.customer.CustomerRecord customer) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgNameCity(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String cityNm, java.lang.String stCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByPhone(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String cntryCd, java.lang.String phnAreaCityCd, java.lang.String phnLoclNbr, short custTypInd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException;
}
