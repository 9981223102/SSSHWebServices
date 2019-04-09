/**
 * TaxRateLookupSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.taxrate;

public class TaxRateLookupSoapBindingSkeleton implements com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookup, org.apache.axis.wsdl.Skeleton {
    private com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookup impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "effectiveDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"), java.util.Calendar.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "zipCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cityName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "countyName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "stateCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getTaxRate", _params, new javax.xml.namespace.QName("", "getTaxRateReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://taxrate.lookup.webservices.sh.ss.homedepot.com", "TaxRateRecord"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://taxrate.lookup.webservices.sh.ss.homedepot.com", "getTaxRate"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getTaxRate") == null) {
            _myOperations.put("getTaxRate", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getTaxRate")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("TaxLookupException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.taxrate.lookup.webservices.sh.ss.homedepot.com", "TaxLookupException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.lookup.taxrate.exceptions.TaxLookupException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.taxrate.lookup.webservices.sh.ss.homedepot.com", "TaxLookupException"));
        _oper.addFault(_fault);
    }

    public TaxRateLookupSoapBindingSkeleton() {
        this.impl = new com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookupSoapBindingImpl();
    }

    public TaxRateLookupSoapBindingSkeleton(com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookup impl) {
        this.impl = impl;
    }
    public com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateRecord getTaxRate(java.util.Calendar effectiveDate, java.lang.String zipCode, java.lang.String cityName, java.lang.String countyName, java.lang.String stateCode, java.lang.String countryCode) throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.lookup.taxrate.exceptions.TaxLookupException
    {
        com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateRecord ret = impl.getTaxRate(effectiveDate, zipCode, cityName, countyName, stateCode, countryCode);
        return ret;
    }

}
