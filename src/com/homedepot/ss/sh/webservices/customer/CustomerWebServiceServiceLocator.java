/**
 * CustomerWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

public class CustomerWebServiceServiceLocator extends org.apache.axis.client.Service implements com.homedepot.ss.sh.webservices.customer.CustomerWebServiceService {

    public CustomerWebServiceServiceLocator() {
    }


    public CustomerWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerWebService
    private java.lang.String CustomerWebService_address = "http://webapps-qa.homedepot.com/SSSHWebServicesWeb/services/CustomerWebService";

    public java.lang.String getCustomerWebServiceAddress() {
        return CustomerWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerWebServiceWSDDServiceName = "CustomerWebService";

    public java.lang.String getCustomerWebServiceWSDDServiceName() {
        return CustomerWebServiceWSDDServiceName;
    }

    public void setCustomerWebServiceWSDDServiceName(java.lang.String name) {
        CustomerWebServiceWSDDServiceName = name;
    }

    public com.homedepot.ss.sh.webservices.customer.CustomerWebService getCustomerWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerWebService(endpoint);
    }

    public com.homedepot.ss.sh.webservices.customer.CustomerWebService getCustomerWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.homedepot.ss.sh.webservices.customer.CustomerWebServiceSoapBindingStub _stub = new com.homedepot.ss.sh.webservices.customer.CustomerWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCustomerWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerWebServiceEndpointAddress(java.lang.String address) {
        CustomerWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.homedepot.ss.sh.webservices.customer.CustomerWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.homedepot.ss.sh.webservices.customer.CustomerWebServiceSoapBindingStub _stub = new com.homedepot.ss.sh.webservices.customer.CustomerWebServiceSoapBindingStub(new java.net.URL(CustomerWebService_address), this);
                _stub.setPortName(getCustomerWebServiceWSDDServiceName());
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
        if ("CustomerWebService".equals(inputPortName)) {
            return getCustomerWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerWebService".equals(portName)) {
            setCustomerWebServiceEndpointAddress(address);
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
