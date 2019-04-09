/**
 * SkuLookupServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.sku;

public class SkuLookupServiceLocator extends org.apache.axis.client.Service implements com.homedepot.ss.sh.webservices.lookup.sku.SkuLookupService {

    public SkuLookupServiceLocator() {
    }


    public SkuLookupServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SkuLookupServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SkuLookup
    private java.lang.String SkuLookup_address = "http://webapps-qa.homedepot.com/SSSHWebServicesWeb/services/SkuLookup";

    public java.lang.String getSkuLookupAddress() {
        return SkuLookup_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SkuLookupWSDDServiceName = "SkuLookup";

    public java.lang.String getSkuLookupWSDDServiceName() {
        return SkuLookupWSDDServiceName;
    }

    public void setSkuLookupWSDDServiceName(java.lang.String name) {
        SkuLookupWSDDServiceName = name;
    }

    public com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup getSkuLookup() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SkuLookup_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSkuLookup(endpoint);
    }

    public com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup getSkuLookup(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.homedepot.ss.sh.webservices.lookup.sku.SkuLookupSoapBindingStub _stub = new com.homedepot.ss.sh.webservices.lookup.sku.SkuLookupSoapBindingStub(portAddress, this);
            _stub.setPortName(getSkuLookupWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSkuLookupEndpointAddress(java.lang.String address) {
        SkuLookup_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup.class.isAssignableFrom(serviceEndpointInterface)) {
                com.homedepot.ss.sh.webservices.lookup.sku.SkuLookupSoapBindingStub _stub = new com.homedepot.ss.sh.webservices.lookup.sku.SkuLookupSoapBindingStub(new java.net.URL(SkuLookup_address), this);
                _stub.setPortName(getSkuLookupWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SkuLookup".equals(inputPortName)) {
            return getSkuLookup();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sku.lookup.webservices.sh.ss.homedepot.com", "SkuLookupService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sku.lookup.webservices.sh.ss.homedepot.com", "SkuLookup"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SkuLookup".equals(portName)) {
            setSkuLookupEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
