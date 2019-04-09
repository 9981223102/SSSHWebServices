/**
 * CustomerWebServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

public class CustomerWebServiceSoapBindingSkeleton implements com.homedepot.ss.sh.webservices.customer.CustomerWebService, org.apache.axis.wsdl.Skeleton {
    private com.homedepot.ss.sh.webservices.customer.CustomerWebService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cityNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchByExOrgNameCity", _params, new javax.xml.namespace.QName("", "searchByExOrgNameCityReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByExOrgNameCity"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchByExOrgNameCity") == null) {
            _myOperations.put("searchByExOrgNameCity", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchByExOrgNameCity")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "firstNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lastNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchByName", _params, new javax.xml.namespace.QName("", "searchByNameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchByName") == null) {
            _myOperations.put("searchByName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchByName")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "customer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord"), com.homedepot.ss.sh.webservices.customer.CustomerRecord.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertCustomer", _params, new javax.xml.namespace.QName("", "insertCustomerReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "InsertRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "insertCustomer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertCustomer") == null) {
            _myOperations.put("insertCustomer", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertCustomer")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "firstNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lastNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchByExName", _params, new javax.xml.namespace.QName("", "searchByExNameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByExName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchByExName") == null) {
            _myOperations.put("searchByExName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchByExName")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hcustNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getCustomer", _params, new javax.xml.namespace.QName("", "getCustomerReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "getCustomer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCustomer") == null) {
            _myOperations.put("getCustomer", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getCustomer")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchByOrgName", _params, new javax.xml.namespace.QName("", "searchByOrgNameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByOrgName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchByOrgName") == null) {
            _myOperations.put("searchByOrgName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchByOrgName")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "customer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord"), com.homedepot.ss.sh.webservices.customer.CustomerRecord.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("updateCustomer", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "updateCustomer"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("updateCustomer") == null) {
            _myOperations.put("updateCustomer", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("updateCustomer")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cityNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchByOrgNameCity", _params, new javax.xml.namespace.QName("", "searchByOrgNameCityReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByOrgNameCity"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchByOrgNameCity") == null) {
            _myOperations.put("searchByOrgNameCity", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchByOrgNameCity")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "phnAreaCityCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "phnLoclNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "custTypInd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchByPhone", _params, new javax.xml.namespace.QName("", "searchByPhoneReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByPhone"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchByPhone") == null) {
            _myOperations.put("searchByPhone", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchByPhone")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchByExOrgName", _params, new javax.xml.namespace.QName("", "searchByExOrgNameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByExOrgName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchByExOrgName") == null) {
            _myOperations.put("searchByExOrgName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchByExOrgName")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("CustomerWebServiceException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"));
        _oper.addFault(_fault);
    }

    public CustomerWebServiceSoapBindingSkeleton() {
        this.impl = new com.homedepot.ss.sh.webservices.customer.CustomerWebServiceSoapBindingImpl();
    }

    public CustomerWebServiceSoapBindingSkeleton(com.homedepot.ss.sh.webservices.customer.CustomerWebService impl) {
        this.impl = impl;
    }
    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgNameCity(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String cityNm, java.lang.String stCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord ret = impl.searchByExOrgNameCity(locTypCd, locNbr, orgNm, cityNm, stCd, cntryCd);
        return ret;
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String firstNm, java.lang.String lastNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord ret = impl.searchByName(locTypCd, locNbr, firstNm, lastNm, pstlCd, cntryCd);
        return ret;
    }

    public com.homedepot.ss.sh.webservices.customer.InsertRecord insertCustomer(java.lang.String locTypCd, java.lang.String locNbr, com.homedepot.ss.sh.webservices.customer.CustomerRecord customer) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.InsertRecord ret = impl.insertCustomer(locTypCd, locNbr, customer);
        return ret;
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String firstNm, java.lang.String lastNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord ret = impl.searchByExName(locTypCd, locNbr, firstNm, lastNm, pstlCd, cntryCd);
        return ret;
    }

    public com.homedepot.ss.sh.webservices.customer.CustomerRecord getCustomer(java.lang.String locTypCd, java.lang.String locNbr, int hcustNbr) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.CustomerRecord ret = impl.getCustomer(locTypCd, locNbr, hcustNbr);
        return ret;
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord ret = impl.searchByOrgName(locTypCd, locNbr, orgNm, pstlCd, cntryCd);
        return ret;
    }

    public void updateCustomer(java.lang.String locTypCd, java.lang.String locNbr, com.homedepot.ss.sh.webservices.customer.CustomerRecord customer) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        impl.updateCustomer(locTypCd, locNbr, customer);
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgNameCity(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String cityNm, java.lang.String stCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord ret = impl.searchByOrgNameCity(locTypCd, locNbr, orgNm, cityNm, stCd, cntryCd);
        return ret;
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByPhone(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String cntryCd, java.lang.String phnAreaCityCd, java.lang.String phnLoclNbr, short custTypInd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord ret = impl.searchByPhone(locTypCd, locNbr, cntryCd, phnAreaCityCd, phnLoclNbr, custTypInd);
        return ret;
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException
    {
        com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord ret = impl.searchByExOrgName(locTypCd, locNbr, orgNm, pstlCd, cntryCd);
        return ret;
    }

}
