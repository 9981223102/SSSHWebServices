/**
 * SkuLookupService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.sku;

public interface SkuLookupService extends javax.xml.rpc.Service {
    public java.lang.String getSkuLookupAddress();

    public com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup getSkuLookup() throws javax.xml.rpc.ServiceException;

    public com.homedepot.ss.sh.webservices.lookup.sku.SkuLookup getSkuLookup(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
