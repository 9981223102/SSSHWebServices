/**
 * CustomerIdRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class CustomerIdRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String locTypCd;

    private java.lang.String locNbr;

    private int seqNbr;

    private short jursdTypCd;

    private short jursdLvl;

    private int jursdCd;

    private short custIdTypCd;

    private java.lang.String custIdNbr;

    private java.util.Calendar custIdExpDt;

    public CustomerIdRecord() {
    }

    public CustomerIdRecord(
           java.lang.String locTypCd,
           java.lang.String locNbr,
           int seqNbr,
           short jursdTypCd,
           short jursdLvl,
           int jursdCd,
           short custIdTypCd,
           java.lang.String custIdNbr,
           java.util.Calendar custIdExpDt) {
           this.locTypCd = locTypCd;
           this.locNbr = locNbr;
           this.seqNbr = seqNbr;
           this.jursdTypCd = jursdTypCd;
           this.jursdLvl = jursdLvl;
           this.jursdCd = jursdCd;
           this.custIdTypCd = custIdTypCd;
           this.custIdNbr = custIdNbr;
           this.custIdExpDt = custIdExpDt;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs			Date to populate customer id record with
	 * @throws SQLException		Thrown if an exception is encountered iterating the resultset
	 */
	public CustomerIdRecord(ResultSet rs) throws SQLException
	{
		this();
		locTypCd = rs.getString(COL_LOC_TYP_CD);
		locNbr = rs.getString(COL_LOC_NBR);
		seqNbr = rs.getInt(COL_SEQ_NBR);
		jursdTypCd = rs.getShort(COL_JURSD_TYP_CD);
		jursdLvl = rs.getShort(COL_JURSD_LVL_CD);
		jursdCd = rs.getInt(COL_JURSD_CD);
		custIdTypCd = rs.getShort(COL_CUST_ID_TYP_CD);
		custIdNbr = rs.getString(COL_CUST_ID_NBR);
		
		//Tomcat Migration - Tcs Changes 08/11/2010	
		/*localCustIdExpDt = rs.getDate(COL_CUST_ID_EXPIR_DT);*/
		if (rs.getDate(COL_CUST_ID_EXPIR_DT) != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rs.getDate(COL_CUST_ID_EXPIR_DT));
			custIdExpDt=calendar;
		}
		
	} // end constructor
    // WAS2TOMCAT Changes END
    /**
     * Gets the locTypCd value for this CustomerIdRecord.
     * 
     * @return locTypCd
     */
    public java.lang.String getLocTypCd() {
        return locTypCd;
    }


    /**
     * Sets the locTypCd value for this CustomerIdRecord.
     * 
     * @param locTypCd
     */
    public void setLocTypCd(java.lang.String locTypCd) {
        this.locTypCd = locTypCd;
    }


    /**
     * Gets the locNbr value for this CustomerIdRecord.
     * 
     * @return locNbr
     */
    public java.lang.String getLocNbr() {
        return locNbr;
    }


    /**
     * Sets the locNbr value for this CustomerIdRecord.
     * 
     * @param locNbr
     */
    public void setLocNbr(java.lang.String locNbr) {
        this.locNbr = locNbr;
    }


    /**
     * Gets the seqNbr value for this CustomerIdRecord.
     * 
     * @return seqNbr
     */
    public int getSeqNbr() {
        return seqNbr;
    }


    /**
     * Sets the seqNbr value for this CustomerIdRecord.
     * 
     * @param seqNbr
     */
    public void setSeqNbr(int seqNbr) {
        this.seqNbr = seqNbr;
    }


    /**
     * Gets the jursdTypCd value for this CustomerIdRecord.
     * 
     * @return jursdTypCd
     */
    public short getJursdTypCd() {
        return jursdTypCd;
    }


    /**
     * Sets the jursdTypCd value for this CustomerIdRecord.
     * 
     * @param jursdTypCd
     */
    public void setJursdTypCd(short jursdTypCd) {
        this.jursdTypCd = jursdTypCd;
    }


    /**
     * Gets the jursdLvl value for this CustomerIdRecord.
     * 
     * @return jursdLvl
     */
    public short getJursdLvl() {
        return jursdLvl;
    }


    /**
     * Sets the jursdLvl value for this CustomerIdRecord.
     * 
     * @param jursdLvl
     */
    public void setJursdLvl(short jursdLvl) {
        this.jursdLvl = jursdLvl;
    }


    /**
     * Gets the jursdCd value for this CustomerIdRecord.
     * 
     * @return jursdCd
     */
    public int getJursdCd() {
        return jursdCd;
    }


    /**
     * Sets the jursdCd value for this CustomerIdRecord.
     * 
     * @param jursdCd
     */
    public void setJursdCd(int jursdCd) {
        this.jursdCd = jursdCd;
    }


    /**
     * Gets the custIdTypCd value for this CustomerIdRecord.
     * 
     * @return custIdTypCd
     */
    public short getCustIdTypCd() {
        return custIdTypCd;
    }


    /**
     * Sets the custIdTypCd value for this CustomerIdRecord.
     * 
     * @param custIdTypCd
     */
    public void setCustIdTypCd(short custIdTypCd) {
        this.custIdTypCd = custIdTypCd;
    }


    /**
     * Gets the custIdNbr value for this CustomerIdRecord.
     * 
     * @return custIdNbr
     */
    public java.lang.String getCustIdNbr() {
        return custIdNbr;
    }


    /**
     * Sets the custIdNbr value for this CustomerIdRecord.
     * 
     * @param custIdNbr
     */
    public void setCustIdNbr(java.lang.String custIdNbr) {
        this.custIdNbr = custIdNbr;
    }


    /**
     * Gets the custIdExpDt value for this CustomerIdRecord.
     * 
     * @return custIdExpDt
     */
    public java.util.Calendar getCustIdExpDt() {
        return custIdExpDt;
    }


    /**
     * Sets the custIdExpDt value for this CustomerIdRecord.
     * 
     * @param custIdExpDt
     */
    public void setCustIdExpDt(java.util.Calendar custIdExpDt) {
        this.custIdExpDt = custIdExpDt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerIdRecord)) return false;
        CustomerIdRecord other = (CustomerIdRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.locTypCd==null && other.getLocTypCd()==null) || 
             (this.locTypCd!=null &&
              this.locTypCd.equals(other.getLocTypCd()))) &&
            ((this.locNbr==null && other.getLocNbr()==null) || 
             (this.locNbr!=null &&
              this.locNbr.equals(other.getLocNbr()))) &&
            this.seqNbr == other.getSeqNbr() &&
            this.jursdTypCd == other.getJursdTypCd() &&
            this.jursdLvl == other.getJursdLvl() &&
            this.jursdCd == other.getJursdCd() &&
            this.custIdTypCd == other.getCustIdTypCd() &&
            ((this.custIdNbr==null && other.getCustIdNbr()==null) || 
             (this.custIdNbr!=null &&
              this.custIdNbr.equals(other.getCustIdNbr()))) &&
            ((this.custIdExpDt==null && other.getCustIdExpDt()==null) || 
             (this.custIdExpDt!=null &&
              this.custIdExpDt.equals(other.getCustIdExpDt())));
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
        if (getLocTypCd() != null) {
            _hashCode += getLocTypCd().hashCode();
        }
        if (getLocNbr() != null) {
            _hashCode += getLocNbr().hashCode();
        }
        _hashCode += getSeqNbr();
        _hashCode += getJursdTypCd();
        _hashCode += getJursdLvl();
        _hashCode += getJursdCd();
        _hashCode += getCustIdTypCd();
        if (getCustIdNbr() != null) {
            _hashCode += getCustIdNbr().hashCode();
        }
        if (getCustIdExpDt() != null) {
            _hashCode += getCustIdExpDt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerIdRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerIdRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seqNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jursdTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jursdTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jursdLvl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jursdLvl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jursdCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jursdCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custIdTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custIdTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custIdNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custIdNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custIdExpDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custIdExpDt"));
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
