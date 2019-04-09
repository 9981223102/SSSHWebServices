/**
 * VhclInsrRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class VhclInsrRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String prvdrNm;

    private java.lang.String plcyNbr;

    private java.util.Calendar plcyExpDt;

    private java.lang.String phnAreaCityCd;

    private java.lang.String phnLoclNbr;

    private java.lang.String phnExt;

    public VhclInsrRecord() {
    }

    public VhclInsrRecord(
           java.lang.String prvdrNm,
           java.lang.String plcyNbr,
           java.util.Calendar plcyExpDt,
           java.lang.String phnAreaCityCd,
           java.lang.String phnLoclNbr,
           java.lang.String phnExt) {
           this.prvdrNm = prvdrNm;
           this.plcyNbr = plcyNbr;
           this.plcyExpDt = plcyExpDt;
           this.phnAreaCityCd = phnAreaCityCd;
           this.phnLoclNbr = phnLoclNbr;
           this.phnExt = phnExt;
    }
    // WAS2TOMCAT Changes START 
	/**
	 * Constructor
	 * 
	 * @param rs		Data for the vehicle insurance record
	 * @throws SQLException		Thown if a problem is encountered with the
	 * 													ResultSet		
	 */
	public VhclInsrRecord(ResultSet rs) throws SQLException
	{
		this();
		prvdrNm = rs.getString(COL_INSR_PRVDR_NM);
		plcyNbr = rs.getString(COL_INSR_PLCY_NBR);
		//Tomcat Migration - Tcs Changes 08/11/2010
		/*localPlcyExpDt = rs.getDate(COL_INSR_PLCY_EXPIR_DT);*/
		if(rs.getDate(COL_INSR_PLCY_EXPIR_DT) != null){
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(rs.getDate(COL_INSR_PLCY_EXPIR_DT));
			plcyExpDt= calendar;
		}
		phnAreaCityCd = rs.getString(COL_PHN_AREA_CITY_CD);
		phnLoclNbr = rs.getString(COL_PHN_LOCAL_NBR);
		phnExt = rs.getString(COL_PHN_EXT_NBR);
	}
    // WAS2TOMCAT Changes END
    /**
     * Gets the prvdrNm value for this VhclInsrRecord.
     * 
     * @return prvdrNm
     */
    public java.lang.String getPrvdrNm() {
        return prvdrNm;
    }


    /**
     * Sets the prvdrNm value for this VhclInsrRecord.
     * 
     * @param prvdrNm
     */
    public void setPrvdrNm(java.lang.String prvdrNm) {
        this.prvdrNm = prvdrNm;
    }


    /**
     * Gets the plcyNbr value for this VhclInsrRecord.
     * 
     * @return plcyNbr
     */
    public java.lang.String getPlcyNbr() {
        return plcyNbr;
    }


    /**
     * Sets the plcyNbr value for this VhclInsrRecord.
     * 
     * @param plcyNbr
     */
    public void setPlcyNbr(java.lang.String plcyNbr) {
        this.plcyNbr = plcyNbr;
    }


    /**
     * Gets the plcyExpDt value for this VhclInsrRecord.
     * 
     * @return plcyExpDt
     */
    public java.util.Calendar getPlcyExpDt() {
        return plcyExpDt;
    }


    /**
     * Sets the plcyExpDt value for this VhclInsrRecord.
     * 
     * @param plcyExpDt
     */
    public void setPlcyExpDt(java.util.Calendar plcyExpDt) {
        this.plcyExpDt = plcyExpDt;
    }


    /**
     * Gets the phnAreaCityCd value for this VhclInsrRecord.
     * 
     * @return phnAreaCityCd
     */
    public java.lang.String getPhnAreaCityCd() {
        return phnAreaCityCd;
    }


    /**
     * Sets the phnAreaCityCd value for this VhclInsrRecord.
     * 
     * @param phnAreaCityCd
     */
    public void setPhnAreaCityCd(java.lang.String phnAreaCityCd) {
        this.phnAreaCityCd = phnAreaCityCd;
    }


    /**
     * Gets the phnLoclNbr value for this VhclInsrRecord.
     * 
     * @return phnLoclNbr
     */
    public java.lang.String getPhnLoclNbr() {
        return phnLoclNbr;
    }


    /**
     * Sets the phnLoclNbr value for this VhclInsrRecord.
     * 
     * @param phnLoclNbr
     */
    public void setPhnLoclNbr(java.lang.String phnLoclNbr) {
        this.phnLoclNbr = phnLoclNbr;
    }


    /**
     * Gets the phnExt value for this VhclInsrRecord.
     * 
     * @return phnExt
     */
    public java.lang.String getPhnExt() {
        return phnExt;
    }


    /**
     * Sets the phnExt value for this VhclInsrRecord.
     * 
     * @param phnExt
     */
    public void setPhnExt(java.lang.String phnExt) {
        this.phnExt = phnExt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VhclInsrRecord)) return false;
        VhclInsrRecord other = (VhclInsrRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.prvdrNm==null && other.getPrvdrNm()==null) || 
             (this.prvdrNm!=null &&
              this.prvdrNm.equals(other.getPrvdrNm()))) &&
            ((this.plcyNbr==null && other.getPlcyNbr()==null) || 
             (this.plcyNbr!=null &&
              this.plcyNbr.equals(other.getPlcyNbr()))) &&
            ((this.plcyExpDt==null && other.getPlcyExpDt()==null) || 
             (this.plcyExpDt!=null &&
              this.plcyExpDt.equals(other.getPlcyExpDt()))) &&
            ((this.phnAreaCityCd==null && other.getPhnAreaCityCd()==null) || 
             (this.phnAreaCityCd!=null &&
              this.phnAreaCityCd.equals(other.getPhnAreaCityCd()))) &&
            ((this.phnLoclNbr==null && other.getPhnLoclNbr()==null) || 
             (this.phnLoclNbr!=null &&
              this.phnLoclNbr.equals(other.getPhnLoclNbr()))) &&
            ((this.phnExt==null && other.getPhnExt()==null) || 
             (this.phnExt!=null &&
              this.phnExt.equals(other.getPhnExt())));
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
        if (getPrvdrNm() != null) {
            _hashCode += getPrvdrNm().hashCode();
        }
        if (getPlcyNbr() != null) {
            _hashCode += getPlcyNbr().hashCode();
        }
        if (getPlcyExpDt() != null) {
            _hashCode += getPlcyExpDt().hashCode();
        }
        if (getPhnAreaCityCd() != null) {
            _hashCode += getPhnAreaCityCd().hashCode();
        }
        if (getPhnLoclNbr() != null) {
            _hashCode += getPhnLoclNbr().hashCode();
        }
        if (getPhnExt() != null) {
            _hashCode += getPhnExt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VhclInsrRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "VhclInsrRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prvdrNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prvdrNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plcyNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plcyNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plcyExpDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plcyExpDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
