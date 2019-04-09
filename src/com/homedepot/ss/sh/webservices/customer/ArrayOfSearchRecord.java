/**
 * ArrayOfSearchRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

public class ArrayOfSearchRecord  implements java.io.Serializable {
    private com.homedepot.ss.sh.webservices.customer.SearchRecord[] searchRecord;

    public ArrayOfSearchRecord() {
    }

    public ArrayOfSearchRecord(
           com.homedepot.ss.sh.webservices.customer.SearchRecord[] searchRecord) {
           this.searchRecord = searchRecord;
    }


    /**
     * Gets the searchRecord value for this ArrayOfSearchRecord.
     * 
     * @return searchRecord
     */
    public com.homedepot.ss.sh.webservices.customer.SearchRecord[] getSearchRecord() {
        return searchRecord;
    }


    /**
     * Sets the searchRecord value for this ArrayOfSearchRecord.
     * 
     * @param searchRecord
     */
    public void setSearchRecord(com.homedepot.ss.sh.webservices.customer.SearchRecord[] searchRecord) {
        this.searchRecord = searchRecord;
    }

    public com.homedepot.ss.sh.webservices.customer.SearchRecord getSearchRecord(int i) {
        return this.searchRecord[i];
    }

    public void setSearchRecord(int i, com.homedepot.ss.sh.webservices.customer.SearchRecord _value) {
        this.searchRecord[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfSearchRecord)) return false;
        ArrayOfSearchRecord other = (ArrayOfSearchRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchRecord==null && other.getSearchRecord()==null) || 
             (this.searchRecord!=null &&
              java.util.Arrays.equals(this.searchRecord, other.getSearchRecord())));
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
        if (getSearchRecord() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchRecord());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchRecord(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfSearchRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ArrayOfSearchRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SearchRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "SearchRecord"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
