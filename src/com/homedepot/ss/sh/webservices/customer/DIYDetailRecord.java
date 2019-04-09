/**
 * DIYDetailRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class DIYDetailRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String firstNm;

    private java.lang.String middleNm;

    private java.lang.String lastNm;

    private java.lang.String suffix;

    private java.lang.String title;

    private java.util.Calendar birthDt;

    public DIYDetailRecord() {
    }

    public DIYDetailRecord(
           java.lang.String firstNm,
           java.lang.String middleNm,
           java.lang.String lastNm,
           java.lang.String suffix,
           java.lang.String title,
           java.util.Calendar birthDt) {
           this.firstNm = firstNm;
           this.middleNm = middleNm;
           this.lastNm = lastNm;
           this.suffix = suffix;
           this.title = title;
           this.birthDt = birthDt;
    }

    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs			Data to populate DIY record with
	 * @throws SQLException			Thrown if an exception is encountered iterating the resultset
	 */
	public DIYDetailRecord(ResultSet rs) throws SQLException
	{
		this();
		firstNm = rs.getString(COL_FRST_NM);
		middleNm = rs.getString(COL_MID_NM);
		lastNm = rs.getString(COL_LAST_NM);
		suffix = rs.getString(COL_SFX_NM);
		title = rs.getString(COL_TTL_NM);
		
   		/*localBirthDt = rs.getDate(COL_BRTH_DT);*/
   		if(rs.getDate(COL_BRTH_DT) != null){
			Calendar calendar=Calendar.getInstance();
	   		calendar.setTime(rs.getDate(COL_BRTH_DT));
	   		birthDt=calendar;
   		}
		
	} // end constructor
    // WAS2TOMCAT Changes END    

    /**
     * Gets the firstNm value for this DIYDetailRecord.
     * 
     * @return firstNm
     */
    public java.lang.String getFirstNm() {
        return firstNm;
    }


    /**
     * Sets the firstNm value for this DIYDetailRecord.
     * 
     * @param firstNm
     */
    public void setFirstNm(java.lang.String firstNm) {
        this.firstNm = firstNm;
    }


    /**
     * Gets the middleNm value for this DIYDetailRecord.
     * 
     * @return middleNm
     */
    public java.lang.String getMiddleNm() {
        return middleNm;
    }


    /**
     * Sets the middleNm value for this DIYDetailRecord.
     * 
     * @param middleNm
     */
    public void setMiddleNm(java.lang.String middleNm) {
        this.middleNm = middleNm;
    }


    /**
     * Gets the lastNm value for this DIYDetailRecord.
     * 
     * @return lastNm
     */
    public java.lang.String getLastNm() {
        return lastNm;
    }


    /**
     * Sets the lastNm value for this DIYDetailRecord.
     * 
     * @param lastNm
     */
    public void setLastNm(java.lang.String lastNm) {
        this.lastNm = lastNm;
    }


    /**
     * Gets the suffix value for this DIYDetailRecord.
     * 
     * @return suffix
     */
    public java.lang.String getSuffix() {
        return suffix;
    }


    /**
     * Sets the suffix value for this DIYDetailRecord.
     * 
     * @param suffix
     */
    public void setSuffix(java.lang.String suffix) {
        this.suffix = suffix;
    }


    /**
     * Gets the title value for this DIYDetailRecord.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this DIYDetailRecord.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the birthDt value for this DIYDetailRecord.
     * 
     * @return birthDt
     */
    public java.util.Calendar getBirthDt() {
        return birthDt;
    }


    /**
     * Sets the birthDt value for this DIYDetailRecord.
     * 
     * @param birthDt
     */
    public void setBirthDt(java.util.Calendar birthDt) {
        this.birthDt = birthDt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DIYDetailRecord)) return false;
        DIYDetailRecord other = (DIYDetailRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.firstNm==null && other.getFirstNm()==null) || 
             (this.firstNm!=null &&
              this.firstNm.equals(other.getFirstNm()))) &&
            ((this.middleNm==null && other.getMiddleNm()==null) || 
             (this.middleNm!=null &&
              this.middleNm.equals(other.getMiddleNm()))) &&
            ((this.lastNm==null && other.getLastNm()==null) || 
             (this.lastNm!=null &&
              this.lastNm.equals(other.getLastNm()))) &&
            ((this.suffix==null && other.getSuffix()==null) || 
             (this.suffix!=null &&
              this.suffix.equals(other.getSuffix()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.birthDt==null && other.getBirthDt()==null) || 
             (this.birthDt!=null &&
              this.birthDt.equals(other.getBirthDt())));
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
        if (getFirstNm() != null) {
            _hashCode += getFirstNm().hashCode();
        }
        if (getMiddleNm() != null) {
            _hashCode += getMiddleNm().hashCode();
        }
        if (getLastNm() != null) {
            _hashCode += getLastNm().hashCode();
        }
        if (getSuffix() != null) {
            _hashCode += getSuffix().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getBirthDt() != null) {
            _hashCode += getBirthDt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DIYDetailRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "DIYDetailRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("middleNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "middleNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suffix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suffix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birthDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
