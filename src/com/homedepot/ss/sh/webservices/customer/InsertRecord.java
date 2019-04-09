/**
 * InsertRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

public class InsertRecord  implements java.io.Serializable {
    private int hostCustNbr;

    private int localCustNbr;

    public InsertRecord() {
    }

    public InsertRecord(
           int hostCustNbr,
           int localCustNbr) {
           this.hostCustNbr = hostCustNbr;
           this.localCustNbr = localCustNbr;
    }


    /**
     * Gets the hostCustNbr value for this InsertRecord.
     * 
     * @return hostCustNbr
     */
    public int getHostCustNbr() {
        return hostCustNbr;
    }


    /**
     * Sets the hostCustNbr value for this InsertRecord.
     * 
     * @param hostCustNbr
     */
    public void setHostCustNbr(int hostCustNbr) {
        this.hostCustNbr = hostCustNbr;
    }


    /**
     * Gets the localCustNbr value for this InsertRecord.
     * 
     * @return localCustNbr
     */
    public int getLocalCustNbr() {
        return localCustNbr;
    }


    /**
     * Sets the localCustNbr value for this InsertRecord.
     * 
     * @param localCustNbr
     */
    public void setLocalCustNbr(int localCustNbr) {
        this.localCustNbr = localCustNbr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsertRecord)) return false;
        InsertRecord other = (InsertRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.hostCustNbr == other.getHostCustNbr() &&
            this.localCustNbr == other.getLocalCustNbr();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getHostCustNbr();
        _hashCode += getLocalCustNbr();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsertRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "InsertRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostCustNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hostCustNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localCustNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "localCustNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
