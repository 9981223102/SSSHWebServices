/**
 * SkuLookupSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.sku;

public class SkuLookupSoapBindingSkeleton implements com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup, org.apache.axis.wsdl.Skeleton {
    private com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup impl;
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
        };
        _oper = new org.apache.axis.description.OperationDesc("getNextAvailableSku", _params, new javax.xml.namespace.QName("", "getNextAvailableSkuReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sku.lookup.webservices.sh.ss.homedepot.com", "getNextAvailableSku"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getNextAvailableSku") == null) {
            _myOperations.put("getNextAvailableSku", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getNextAvailableSku")).add(_oper);
        _fault = new org.apache.axis.description.FaultDesc();
        _fault.setName("SkuLookupException");
        _fault.setQName(new javax.xml.namespace.QName("http://exceptions.sku.lookup.webservices.sh.ss.homedepot.com", "SkuLookupException"));
        _fault.setClassName("com.homedepot.ss.sh.webservices.lookup.sku.exceptions.SkuLookupException");
        _fault.setXmlType(new javax.xml.namespace.QName("http://exceptions.sku.lookup.webservices.sh.ss.homedepot.com", "SkuLookupException"));
        _oper.addFault(_fault);
    }

    public SkuLookupSoapBindingSkeleton() {
        this.impl = new com.homedepot.ss.sh.webservices.lookup.sku.SkuLookupSoapBindingImpl();
    }

    public SkuLookupSoapBindingSkeleton(com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup impl) {
        this.impl = impl;
    }
    public int getNextAvailableSku() throws java.rmi.RemoteException, com.homedepot.ss.sh.webservices.lookup.sku.exceptions.SkuLookupException
    {
        int ret = impl.getNextAvailableSku();
        return ret;
    }

}
