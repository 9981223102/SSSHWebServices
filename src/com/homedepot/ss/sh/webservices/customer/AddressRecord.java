/**
 * AddressRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class AddressRecord  implements java.io.Serializable,CustomerProtocol {
    private short addrTypCd;

    private java.lang.String addrLn1Txt;

    private java.lang.String addrLn2Txt;

    private java.lang.String addrLn3Txt;

    private java.lang.String addrLn4Txt;

    private java.lang.String addrLn5Txt;

    private java.lang.String cityNm;

    private java.lang.String cntyNm;

    private java.lang.String stCd;

    private java.lang.String pstlCd;

    private java.lang.String cntryCd;

    private java.lang.String primAddrTaxFlg;

    private java.lang.String axGeoCd;

    public AddressRecord() {
    }

    public AddressRecord(
           short addrTypCd,
           java.lang.String addrLn1Txt,
           java.lang.String addrLn2Txt,
           java.lang.String addrLn3Txt,
           java.lang.String addrLn4Txt,
           java.lang.String addrLn5Txt,
           java.lang.String cityNm,
           java.lang.String cntyNm,
           java.lang.String stCd,
           java.lang.String pstlCd,
           java.lang.String cntryCd,
           java.lang.String primAddrTaxFlg,
           java.lang.String axGeoCd) {
           this.addrTypCd = addrTypCd;
           this.addrLn1Txt = addrLn1Txt;
           this.addrLn2Txt = addrLn2Txt;
           this.addrLn3Txt = addrLn3Txt;
           this.addrLn4Txt = addrLn4Txt;
           this.addrLn5Txt = addrLn5Txt;
           this.cityNm = cityNm;
           this.cntyNm = cntyNm;
           this.stCd = stCd;
           this.pstlCd = pstlCd;
           this.cntryCd = cntryCd;
           this.primAddrTaxFlg = primAddrTaxFlg;
           this.axGeoCd = axGeoCd;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs		Resultset to populate data from
	 * @throws SQLException		Thrown if an exception occur iterating the ResultSet
	 */
	public AddressRecord(ResultSet rs) throws SQLException
	{
		this();
		addrTypCd = rs.getShort(COL_CUST_ADDR_TYP_CD);
		addrLn1Txt = rs.getString(COL_ADDR_LINE1_TXT);
		addrLn2Txt = rs.getString(COL_ADDR_LINE2_TXT);
		addrLn3Txt = rs.getString(COL_ADDR_LINE3_TXT);
		addrLn4Txt = rs.getString(COL_ADDR_LINE4_TXT);
		addrLn5Txt = rs.getString(COL_ADDR_LINE5_TXT);
		cityNm = rs.getString(COL_CITY_NM);
		cntyNm = rs.getString(COL_CNTY_NM);
		stCd = rs.getString(COL_ST_CD);
		pstlCd = rs.getString(COL_PSTL_CD);
		cntryCd = rs.getString(COL_CNTRY_CD);
		primAddrTaxFlg = rs.getString(COL_PRIM_ADDR_TAX_FLG);
		axGeoCd = rs.getString(COL_AX_GEO_CD);
	} // end constructor
	// WAS2TOMCAT Changes END

    /**
     * Gets the addrTypCd value for this AddressRecord.
     * 
     * @return addrTypCd
     */
    public short getAddrTypCd() {
        return addrTypCd;
    }


    /**
     * Sets the addrTypCd value for this AddressRecord.
     * 
     * @param addrTypCd
     */
    public void setAddrTypCd(short addrTypCd) {
        this.addrTypCd = addrTypCd;
    }


    /**
     * Gets the addrLn1Txt value for this AddressRecord.
     * 
     * @return addrLn1Txt
     */
    public java.lang.String getAddrLn1Txt() {
        return addrLn1Txt;
    }


    /**
     * Sets the addrLn1Txt value for this AddressRecord.
     * 
     * @param addrLn1Txt
     */
    public void setAddrLn1Txt(java.lang.String addrLn1Txt) {
        this.addrLn1Txt = addrLn1Txt;
    }


    /**
     * Gets the addrLn2Txt value for this AddressRecord.
     * 
     * @return addrLn2Txt
     */
    public java.lang.String getAddrLn2Txt() {
        return addrLn2Txt;
    }


    /**
     * Sets the addrLn2Txt value for this AddressRecord.
     * 
     * @param addrLn2Txt
     */
    public void setAddrLn2Txt(java.lang.String addrLn2Txt) {
        this.addrLn2Txt = addrLn2Txt;
    }


    /**
     * Gets the addrLn3Txt value for this AddressRecord.
     * 
     * @return addrLn3Txt
     */
    public java.lang.String getAddrLn3Txt() {
        return addrLn3Txt;
    }


    /**
     * Sets the addrLn3Txt value for this AddressRecord.
     * 
     * @param addrLn3Txt
     */
    public void setAddrLn3Txt(java.lang.String addrLn3Txt) {
        this.addrLn3Txt = addrLn3Txt;
    }


    /**
     * Gets the addrLn4Txt value for this AddressRecord.
     * 
     * @return addrLn4Txt
     */
    public java.lang.String getAddrLn4Txt() {
        return addrLn4Txt;
    }


    /**
     * Sets the addrLn4Txt value for this AddressRecord.
     * 
     * @param addrLn4Txt
     */
    public void setAddrLn4Txt(java.lang.String addrLn4Txt) {
        this.addrLn4Txt = addrLn4Txt;
    }


    /**
     * Gets the addrLn5Txt value for this AddressRecord.
     * 
     * @return addrLn5Txt
     */
    public java.lang.String getAddrLn5Txt() {
        return addrLn5Txt;
    }


    /**
     * Sets the addrLn5Txt value for this AddressRecord.
     * 
     * @param addrLn5Txt
     */
    public void setAddrLn5Txt(java.lang.String addrLn5Txt) {
        this.addrLn5Txt = addrLn5Txt;
    }


    /**
     * Gets the cityNm value for this AddressRecord.
     * 
     * @return cityNm
     */
    public java.lang.String getCityNm() {
        return cityNm;
    }


    /**
     * Sets the cityNm value for this AddressRecord.
     * 
     * @param cityNm
     */
    public void setCityNm(java.lang.String cityNm) {
        this.cityNm = cityNm;
    }


    /**
     * Gets the cntyNm value for this AddressRecord.
     * 
     * @return cntyNm
     */
    public java.lang.String getCntyNm() {
        return cntyNm;
    }


    /**
     * Sets the cntyNm value for this AddressRecord.
     * 
     * @param cntyNm
     */
    public void setCntyNm(java.lang.String cntyNm) {
        this.cntyNm = cntyNm;
    }


    /**
     * Gets the stCd value for this AddressRecord.
     * 
     * @return stCd
     */
    public java.lang.String getStCd() {
        return stCd;
    }


    /**
     * Sets the stCd value for this AddressRecord.
     * 
     * @param stCd
     */
    public void setStCd(java.lang.String stCd) {
        this.stCd = stCd;
    }


    /**
     * Gets the pstlCd value for this AddressRecord.
     * 
     * @return pstlCd
     */
    public java.lang.String getPstlCd() {
        return pstlCd;
    }


    /**
     * Sets the pstlCd value for this AddressRecord.
     * 
     * @param pstlCd
     */
    public void setPstlCd(java.lang.String pstlCd) {
        this.pstlCd = pstlCd;
    }


    /**
     * Gets the cntryCd value for this AddressRecord.
     * 
     * @return cntryCd
     */
    public java.lang.String getCntryCd() {
        return cntryCd;
    }


    /**
     * Sets the cntryCd value for this AddressRecord.
     * 
     * @param cntryCd
     */
    public void setCntryCd(java.lang.String cntryCd) {
        this.cntryCd = cntryCd;
    }


    /**
     * Gets the primAddrTaxFlg value for this AddressRecord.
     * 
     * @return primAddrTaxFlg
     */
    public java.lang.String getPrimAddrTaxFlg() {
        return primAddrTaxFlg;
    }


    /**
     * Sets the primAddrTaxFlg value for this AddressRecord.
     * 
     * @param primAddrTaxFlg
     */
    public void setPrimAddrTaxFlg(java.lang.String primAddrTaxFlg) {
        this.primAddrTaxFlg = primAddrTaxFlg;
    }


    /**
     * Gets the axGeoCd value for this AddressRecord.
     * 
     * @return axGeoCd
     */
    public java.lang.String getAxGeoCd() {
        return axGeoCd;
    }


    /**
     * Sets the axGeoCd value for this AddressRecord.
     * 
     * @param axGeoCd
     */
    public void setAxGeoCd(java.lang.String axGeoCd) {
        this.axGeoCd = axGeoCd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddressRecord)) return false;
        AddressRecord other = (AddressRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.addrTypCd == other.getAddrTypCd() &&
            ((this.addrLn1Txt==null && other.getAddrLn1Txt()==null) || 
             (this.addrLn1Txt!=null &&
              this.addrLn1Txt.equals(other.getAddrLn1Txt()))) &&
            ((this.addrLn2Txt==null && other.getAddrLn2Txt()==null) || 
             (this.addrLn2Txt!=null &&
              this.addrLn2Txt.equals(other.getAddrLn2Txt()))) &&
            ((this.addrLn3Txt==null && other.getAddrLn3Txt()==null) || 
             (this.addrLn3Txt!=null &&
              this.addrLn3Txt.equals(other.getAddrLn3Txt()))) &&
            ((this.addrLn4Txt==null && other.getAddrLn4Txt()==null) || 
             (this.addrLn4Txt!=null &&
              this.addrLn4Txt.equals(other.getAddrLn4Txt()))) &&
            ((this.addrLn5Txt==null && other.getAddrLn5Txt()==null) || 
             (this.addrLn5Txt!=null &&
              this.addrLn5Txt.equals(other.getAddrLn5Txt()))) &&
            ((this.cityNm==null && other.getCityNm()==null) || 
             (this.cityNm!=null &&
              this.cityNm.equals(other.getCityNm()))) &&
            ((this.cntyNm==null && other.getCntyNm()==null) || 
             (this.cntyNm!=null &&
              this.cntyNm.equals(other.getCntyNm()))) &&
            ((this.stCd==null && other.getStCd()==null) || 
             (this.stCd!=null &&
              this.stCd.equals(other.getStCd()))) &&
            ((this.pstlCd==null && other.getPstlCd()==null) || 
             (this.pstlCd!=null &&
              this.pstlCd.equals(other.getPstlCd()))) &&
            ((this.cntryCd==null && other.getCntryCd()==null) || 
             (this.cntryCd!=null &&
              this.cntryCd.equals(other.getCntryCd()))) &&
            ((this.primAddrTaxFlg==null && other.getPrimAddrTaxFlg()==null) || 
             (this.primAddrTaxFlg!=null &&
              this.primAddrTaxFlg.equals(other.getPrimAddrTaxFlg()))) &&
            ((this.axGeoCd==null && other.getAxGeoCd()==null) || 
             (this.axGeoCd!=null &&
              this.axGeoCd.equals(other.getAxGeoCd())));
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
        _hashCode += getAddrTypCd();
        if (getAddrLn1Txt() != null) {
            _hashCode += getAddrLn1Txt().hashCode();
        }
        if (getAddrLn2Txt() != null) {
            _hashCode += getAddrLn2Txt().hashCode();
        }
        if (getAddrLn3Txt() != null) {
            _hashCode += getAddrLn3Txt().hashCode();
        }
        if (getAddrLn4Txt() != null) {
            _hashCode += getAddrLn4Txt().hashCode();
        }
        if (getAddrLn5Txt() != null) {
            _hashCode += getAddrLn5Txt().hashCode();
        }
        if (getCityNm() != null) {
            _hashCode += getCityNm().hashCode();
        }
        if (getCntyNm() != null) {
            _hashCode += getCntyNm().hashCode();
        }
        if (getStCd() != null) {
            _hashCode += getStCd().hashCode();
        }
        if (getPstlCd() != null) {
            _hashCode += getPstlCd().hashCode();
        }
        if (getCntryCd() != null) {
            _hashCode += getCntryCd().hashCode();
        }
        if (getPrimAddrTaxFlg() != null) {
            _hashCode += getPrimAddrTaxFlg().hashCode();
        }
        if (getAxGeoCd() != null) {
            _hashCode += getAxGeoCd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddressRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AddressRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrLn1Txt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrLn1Txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrLn2Txt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrLn2Txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrLn3Txt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrLn3Txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrLn4Txt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrLn4Txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrLn5Txt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrLn5Txt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntyNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntyNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pstlCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pstlCd"));
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
        elemField.setFieldName("primAddrTaxFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primAddrTaxFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("axGeoCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "axGeoCd"));
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
