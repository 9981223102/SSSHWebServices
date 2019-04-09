/**
 * TaxblStatRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class TaxblStatRecord  implements java.io.Serializable,CustomerProtocol {
    private short taxblStatCd;

    private int taxPayAgreeCd;

    public TaxblStatRecord() {
    }

    public TaxblStatRecord(
           short taxblStatCd,
           int taxPayAgreeCd) {
           this.taxblStatCd = taxblStatCd;
           this.taxPayAgreeCd = taxPayAgreeCd;
    }
    
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs			Taxbl stat data
	 * @throws SQLException		Thrown if an exception occurs iterating the resultset
	 */
	public TaxblStatRecord(ResultSet rs) throws SQLException
	{
		taxblStatCd = rs.getShort(COL_TAXBL_STAT_CD);
		taxPayAgreeCd = rs.getInt(COL_TAX_PAY_AGREE_CD);
	}
    // WAS2TOMCAT Changes END
	
    /**
     * Gets the taxblStatCd value for this TaxblStatRecord.
     * 
     * @return taxblStatCd
     */
    public short getTaxblStatCd() {
        return taxblStatCd;
    }


    /**
     * Sets the taxblStatCd value for this TaxblStatRecord.
     * 
     * @param taxblStatCd
     */
    public void setTaxblStatCd(short taxblStatCd) {
        this.taxblStatCd = taxblStatCd;
    }


    /**
     * Gets the taxPayAgreeCd value for this TaxblStatRecord.
     * 
     * @return taxPayAgreeCd
     */
    public int getTaxPayAgreeCd() {
        return taxPayAgreeCd;
    }


    /**
     * Sets the taxPayAgreeCd value for this TaxblStatRecord.
     * 
     * @param taxPayAgreeCd
     */
    public void setTaxPayAgreeCd(int taxPayAgreeCd) {
        this.taxPayAgreeCd = taxPayAgreeCd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TaxblStatRecord)) return false;
        TaxblStatRecord other = (TaxblStatRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.taxblStatCd == other.getTaxblStatCd() &&
            this.taxPayAgreeCd == other.getTaxPayAgreeCd();
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
        _hashCode += getTaxblStatCd();
        _hashCode += getTaxPayAgreeCd();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TaxblStatRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "TaxblStatRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxblStatCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxblStatCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxPayAgreeCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxPayAgreeCd"));
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
