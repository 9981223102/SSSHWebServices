/**
 * CustomerWebServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

public class CustomerWebServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.homedepot.ss.sh.webservices.customer.CustomerWebService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchByExOrgNameCity");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cityNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchByExOrgNameCityReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "SearchRecord"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchByName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "firstNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lastNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchByNameReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "SearchRecord"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "customer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord"), com.homedepot.ss.sh.webservices.customer.CustomerRecord.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "InsertRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.InsertRecord.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "insertCustomerReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchByExName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "firstNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "lastNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchByExNameReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "SearchRecord"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hcustNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.CustomerRecord.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCustomerReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchByOrgName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchByOrgNameReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "SearchRecord"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateCustomer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "customer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord"), com.homedepot.ss.sh.webservices.customer.CustomerRecord.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchByOrgNameCity");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cityNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchByOrgNameCityReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "SearchRecord"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchByPhone");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "phnAreaCityCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "phnLoclNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "custTypInd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), short.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchByPhoneReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "SearchRecord"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchByExOrgName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locTypCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locNbr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "orgNm"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pstlCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cntryCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        oper.setReturnClass(com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "searchByExOrgNameReturn"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "SearchRecord"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"),
                      "com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException",
                      new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    public CustomerWebServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CustomerWebServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CustomerWebServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AddressRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.AddressRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AgentRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.AgentRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfAddressRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.AddressRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AddressRecord");
            qName2 = new javax.xml.namespace.QName("", "AddressRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfAgentRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.AgentRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AgentRecord");
            qName2 = new javax.xml.namespace.QName("", "AgentRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfContactRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.ContactRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ContactRecord");
            qName2 = new javax.xml.namespace.QName("", "ContactRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfCustomerIdRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.CustomerIdRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerIdRecord");
            qName2 = new javax.xml.namespace.QName("", "CustomerIdRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfEmailAddressRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.EmailAddressRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "EmailAddressRecord");
            qName2 = new javax.xml.namespace.QName("", "EmailAddressRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfPhoneRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.PhoneRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "PhoneRecord");
            qName2 = new javax.xml.namespace.QName("", "PhoneRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.SearchRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "SearchRecord");
            qName2 = new javax.xml.namespace.QName("", "SearchRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfTaxRuleRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.TaxRuleRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "TaxRuleRecord");
            qName2 = new javax.xml.namespace.QName("", "TaxRuleRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfUnfvrRentalRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.UnfvrRentalRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "UnfvrRentalRecord");
            qName2 = new javax.xml.namespace.QName("", "UnfvrRentalRecord");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ContactRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.ContactRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerIdRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.CustomerIdRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.CustomerRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "DIYDetailRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.DIYDetailRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "EmailAddressRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.EmailAddressRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "InsertRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.InsertRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "PhoneRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.PhoneRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "PRODetailRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.PRODetailRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "RentalRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.RentalRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "SearchRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.SearchRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "TaxblStatRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.TaxblStatRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "TaxRuleRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.TaxRuleRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "UnfvrRentalRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.UnfvrRentalRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "VhclInsrRecord");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.VhclInsrRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceException");
            cachedSerQNames.add(qName);
            cls = com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgNameCity(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String cityNm, java.lang.String stCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByExOrgNameCity"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, orgNm, cityNm, stCd, cntryCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String firstNm, java.lang.String lastNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, firstNm, lastNm, pstlCd, cntryCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.InsertRecord insertCustomer(java.lang.String locTypCd, java.lang.String locNbr, com.homedepot.ss.sh.webservices.customer.CustomerRecord customer) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "insertCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, customer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.InsertRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.InsertRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.InsertRecord.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String firstNm, java.lang.String lastNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByExName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, firstNm, lastNm, pstlCd, cntryCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.CustomerRecord getCustomer(java.lang.String locTypCd, java.lang.String locNbr, int hcustNbr) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "getCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, new java.lang.Integer(hcustNbr)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.CustomerRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.CustomerRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.CustomerRecord.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByOrgName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, orgNm, pstlCd, cntryCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateCustomer(java.lang.String locTypCd, java.lang.String locNbr, com.homedepot.ss.sh.webservices.customer.CustomerRecord customer) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "updateCustomer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, customer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByOrgNameCity(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String cityNm, java.lang.String stCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByOrgNameCity"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, orgNm, cityNm, stCd, cntryCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByPhone(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String cntryCd, java.lang.String phnAreaCityCd, java.lang.String phnLoclNbr, short custTypInd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByPhone"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, cntryCd, phnAreaCityCd, phnLoclNbr, new java.lang.Short(custTypInd)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord searchByExOrgName(java.lang.String locTypCd, java.lang.String locNbr, java.lang.String orgNm, java.lang.String pstlCd, java.lang.String cntryCd) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "searchByExOrgName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {locTypCd, locNbr, orgNm, pstlCd, cntryCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.homedepot.ss.sh.webservices.customer.ArrayOfSearchRecord) org.apache.axis.utils.JavaUtils.convert(_resp, com.homedepot.ss.sh.webservices.customer.SearchRecord[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) {
              throw (com.homedepot.ss.sh.webservices.customer.exceptions.CustomerWebServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
