/**
 * PhoneRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class PhoneRecord  implements java.io.Serializable,CustomerProtocol {
    private short phnNbrTypCd;

    private java.lang.String phnAreaCityCd;

    private java.lang.String phnLoclNbr;

    private java.lang.String phnExt;

    private java.lang.String phnPin;

    private java.lang.String cntryCd;

    private java.lang.String prefFlg;

    public PhoneRecord() {
    }

    public PhoneRecord(
           short phnNbrTypCd,
           java.lang.String phnAreaCityCd,
           java.lang.String phnLoclNbr,
           java.lang.String phnExt,
           java.lang.String phnPin,
           java.lang.String cntryCd,
           java.lang.String prefFlg) {
           this.phnNbrTypCd = phnNbrTypCd;
           this.phnAreaCityCd = phnAreaCityCd;
           this.phnLoclNbr = phnLoclNbr;
           this.phnExt = phnExt;
           this.phnPin = phnPin;
           this.cntryCd = cntryCd;
           this.prefFlg = prefFlg;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs			Data to populate phone record from
	 * @throws SQLException		Thrown if an exception occurs iterating the resultset
	 */
	public PhoneRecord(ResultSet rs) throws SQLException
	{
		this();
		phnNbrTypCd = rs.getShort(COL_PHN_NBR_TYP_CD);
		phnAreaCityCd = rs.getString(COL_PHN_AREA_CITY_CD);
		phnLoclNbr = rs.getString(COL_PHN_LOCAL_NBR);
		phnExt = rs.getString(COL_PHN_EXT_NBR);
		phnPin = rs.getString(COL_PHN_PIN_NBR);
		cntryCd = rs.getString(COL_CNTRY_CD);
		prefFlg = rs.getString(COL_PREF_PHN_FLG);
	} // end constructor
	// WAS2TOMCAT Changes END

    /**
     * Gets the phnNbrTypCd value for this PhoneRecord.
     * 
     * @return phnNbrTypCd
     */
    public short getPhnNbrTypCd() {
        return phnNbrTypCd;
    }


    /**
     * Sets the phnNbrTypCd value for this PhoneRecord.
     * 
     * @param phnNbrTypCd
     */
    public void setPhnNbrTypCd(short phnNbrTypCd) {
        this.phnNbrTypCd = phnNbrTypCd;
    }


    /**
     * Gets the phnAreaCityCd value for this PhoneRecord.
     * 
     * @return phnAreaCityCd
     */
    public java.lang.String getPhnAreaCityCd() {
        return phnAreaCityCd;
    }


    /**
     * Sets the phnAreaCityCd value for this PhoneRecord.
     * 
     * @param phnAreaCityCd
     */
    public void setPhnAreaCityCd(java.lang.String phnAreaCityCd) {
        this.phnAreaCityCd = phnAreaCityCd;
    }


    /**
     * Gets the phnLoclNbr value for this PhoneRecord.
     * 
     * @return phnLoclNbr
     */
    public java.lang.String getPhnLoclNbr() {
        return phnLoclNbr;
    }


    /**
     * Sets the phnLoclNbr value for this PhoneRecord.
     * 
     * @param phnLoclNbr
     */
    public void setPhnLoclNbr(java.lang.String phnLoclNbr) {
        this.phnLoclNbr = phnLoclNbr;
    }


    /**
     * Gets the phnExt value for this PhoneRecord.
     * 
     * @return phnExt
     */
    public java.lang.String getPhnExt() {
        return phnExt;
    }


    /**
     * Sets the phnExt value for this PhoneRecord.
     * 
     * @param phnExt
     */
    public void setPhnExt(java.lang.String phnExt) {
        this.phnExt = phnExt;
    }


    /**
     * Gets the phnPin value for this PhoneRecord.
     * 
     * @return phnPin
     */
    public java.lang.String getPhnPin() {
        return phnPin;
    }


    /**
     * Sets the phnPin value for this PhoneRecord.
     * 
     * @param phnPin
     */
    public void setPhnPin(java.lang.String phnPin) {
        this.phnPin = phnPin;
    }


    /**
     * Gets the cntryCd value for this PhoneRecord.
     * 
     * @return cntryCd
     */
    public java.lang.String getCntryCd() {
        return cntryCd;
    }


    /**
     * Sets the cntryCd value for this PhoneRecord.
     * 
     * @param cntryCd
     */
    public void setCntryCd(java.lang.String cntryCd) {
        this.cntryCd = cntryCd;
    }


    /**
     * Gets the prefFlg value for this PhoneRecord.
     * 
     * @return prefFlg
     */
    public java.lang.String getPrefFlg() {
        return prefFlg;
    }


    /**
     * Sets the prefFlg value for this PhoneRecord.
     * 
     * @param prefFlg
     */
    public void setPrefFlg(java.lang.String prefFlg) {
        this.prefFlg = prefFlg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PhoneRecord)) return false;
        PhoneRecord other = (PhoneRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.phnNbrTypCd == other.getPhnNbrTypCd() &&
            ((this.phnAreaCityCd==null && other.getPhnAreaCityCd()==null) || 
             (this.phnAreaCityCd!=null &&
              this.phnAreaCityCd.equals(other.getPhnAreaCityCd()))) &&
            ((this.phnLoclNbr==null && other.getPhnLoclNbr()==null) || 
             (this.phnLoclNbr!=null &&
              this.phnLoclNbr.equals(other.getPhnLoclNbr()))) &&
            ((this.phnExt==null && other.getPhnExt()==null) || 
             (this.phnExt!=null &&
              this.phnExt.equals(other.getPhnExt()))) &&
            ((this.phnPin==null && other.getPhnPin()==null) || 
             (this.phnPin!=null &&
              this.phnPin.equals(other.getPhnPin()))) &&
            ((this.cntryCd==null && other.getCntryCd()==null) || 
             (this.cntryCd!=null &&
              this.cntryCd.equals(other.getCntryCd()))) &&
            ((this.prefFlg==null && other.getPrefFlg()==null) || 
             (this.prefFlg!=null &&
              this.prefFlg.equals(other.getPrefFlg())));
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
        _hashCode += getPhnNbrTypCd();
        if (getPhnAreaCityCd() != null) {
            _hashCode += getPhnAreaCityCd().hashCode();
        }
        if (getPhnLoclNbr() != null) {
            _hashCode += getPhnLoclNbr().hashCode();
        }
        if (getPhnExt() != null) {
            _hashCode += getPhnExt().hashCode();
        }
        if (getPhnPin() != null) {
            _hashCode += getPhnPin().hashCode();
        }
        if (getCntryCd() != null) {
            _hashCode += getCntryCd().hashCode();
        }
        if (getPrefFlg() != null) {
            _hashCode += getPrefFlg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PhoneRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "PhoneRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phnNbrTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phnNbrTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phnAreaCityCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phnAreaCityCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phnLoclNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phnLoclNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phnExt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phnExt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phnPin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phnPin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntryCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntryCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prefFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prefFlg"));
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
