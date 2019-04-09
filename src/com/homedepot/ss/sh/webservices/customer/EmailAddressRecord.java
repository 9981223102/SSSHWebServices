/**
 * EmailAddressRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class EmailAddressRecord  implements java.io.Serializable,CustomerProtocol {
    private short emailAddrTypCd;

    private java.lang.String emailAddrTxt;

    private java.lang.String solicitFlg;

    public EmailAddressRecord() {
    }

    public EmailAddressRecord(
           short emailAddrTypCd,
           java.lang.String emailAddrTxt,
           java.lang.String solicitFlg) {
           this.emailAddrTypCd = emailAddrTypCd;
           this.emailAddrTxt = emailAddrTxt;
           this.solicitFlg = solicitFlg;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs			Data to populate email address with
	 * @throws SQLException		Thrown if an exception is encountered iterating the resultset
	 */
	public EmailAddressRecord(ResultSet rs) throws SQLException
	{
		this();
		emailAddrTypCd = rs.getShort(COL_EMAIL_ADDR_TYP_CD);
		emailAddrTxt = rs.getString(COL_EMAIL_ADDR_TXT);
		solicitFlg = rs.getString(COL_SOLCT_FLG);
	}    
    // WAS2TOMCAT Changes END
    /**
     * Gets the emailAddrTypCd value for this EmailAddressRecord.
     * 
     * @return emailAddrTypCd
     */
    public short getEmailAddrTypCd() {
        return emailAddrTypCd;
    }


    /**
     * Sets the emailAddrTypCd value for this EmailAddressRecord.
     * 
     * @param emailAddrTypCd
     */
    public void setEmailAddrTypCd(short emailAddrTypCd) {
        this.emailAddrTypCd = emailAddrTypCd;
    }


    /**
     * Gets the emailAddrTxt value for this EmailAddressRecord.
     * 
     * @return emailAddrTxt
     */
    public java.lang.String getEmailAddrTxt() {
        return emailAddrTxt;
    }


    /**
     * Sets the emailAddrTxt value for this EmailAddressRecord.
     * 
     * @param emailAddrTxt
     */
    public void setEmailAddrTxt(java.lang.String emailAddrTxt) {
        this.emailAddrTxt = emailAddrTxt;
    }


    /**
     * Gets the solicitFlg value for this EmailAddressRecord.
     * 
     * @return solicitFlg
     */
    public java.lang.String getSolicitFlg() {
        return solicitFlg;
    }


    /**
     * Sets the solicitFlg value for this EmailAddressRecord.
     * 
     * @param solicitFlg
     */
    public void setSolicitFlg(java.lang.String solicitFlg) {
        this.solicitFlg = solicitFlg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmailAddressRecord)) return false;
        EmailAddressRecord other = (EmailAddressRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.emailAddrTypCd == other.getEmailAddrTypCd() &&
            ((this.emailAddrTxt==null && other.getEmailAddrTxt()==null) || 
             (this.emailAddrTxt!=null &&
              this.emailAddrTxt.equals(other.getEmailAddrTxt()))) &&
            ((this.solicitFlg==null && other.getSolicitFlg()==null) || 
             (this.solicitFlg!=null &&
              this.solicitFlg.equals(other.getSolicitFlg())));
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
        _hashCode += getEmailAddrTypCd();
        if (getEmailAddrTxt() != null) {
            _hashCode += getEmailAddrTxt().hashCode();
        }
        if (getSolicitFlg() != null) {
            _hashCode += getSolicitFlg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmailAddressRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "EmailAddressRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddrTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailAddrTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddrTxt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailAddrTxt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solicitFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "solicitFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
