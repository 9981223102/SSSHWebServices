/**
 * TaxRateLookupServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.taxrate;

public class TaxRateLookupServiceLocator extends org.apache.axis.client.Service implements com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookupService {

    public TaxRateLookupServiceLocator() {
    }


    public TaxRateLookupServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaxRateLookupServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TaxRateLookup
    private java.lang.String TaxRateLookup_address = "http://webapps-qa.homedepot.com/SSSHWebServicesWeb/services/TaxRateLookup";

    public java.lang.String getTaxRateLookupAddress() {
        return TaxRateLookup_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaxRateLookupWSDDServiceName = "TaxRateLookup";

    public java.lang.String getTaxRateLookupWSDDServiceName() {
        return TaxRateLookupWSDDServiceName;
    }

    public void setTaxRateLookupWSDDServiceName(java.lang.String name) {
        TaxRateLookupWSDDServiceName = name;
    }

    public com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookup getTaxRateLookup() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaxRateLookup_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaxRateLookup(endpoint);
    }

    public com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookup getTaxRateLookup(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookupSoapBindingStub _stub = new com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookupSoapBindingStub(portAddress, this);
            _stub.setPortName(getTaxRateLookupWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaxRateLookupEndpointAddress(java.lang.String address) {
        TaxRateLookup_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookup.class.isAssignableFrom(serviceEndpointInterface)) {
                com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookupSoapBindingStub _stub = new com.homedepot.ss.sh.webservices.lookup.taxrate.TaxRateLookupSoapBindingStub(new java.net.URL(TaxRateLookup_address), this);
                _stub.setPortName(getTaxRateLookupWSDDServiceName());
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
        if ("TaxRateLookup".equals(inputPortName)) {
            return getTaxRateLookup();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://taxrate.lookup.webservices.sh.ss.homedepot.com", "TaxRateLookupService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://taxrate.lookup.webservices.sh.ss.homedepot.com", "TaxRateLookup"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TaxRateLookup".equals(portName)) {
            setTaxRateLookupEndpointAddress(address);
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
