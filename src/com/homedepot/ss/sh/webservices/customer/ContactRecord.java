/**
 * ContactRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class ContactRecord  implements java.io.Serializable,CustomerProtocol {
    private int cntctHostCustNbr;

    private java.lang.String locTypCd;

    private java.lang.String locNbr;

    private int seqNbr;

    private short cntctMethCd;

    private short cntctAddrCd;

    private short cntctPhnCd;

    private short cntctEmailTypCd;

    private java.lang.String cntctWkBgnTm;

    private java.lang.String cntctWkEndTm;

    private java.lang.String cntctWkendBgnTm;

    private java.lang.String cntctWkendEndTm;

    private java.lang.String actvFlg;

    private int agntSeqNbr;

    private java.lang.String agntLocTypCd;

    private java.lang.String agntLocNbr;

    public ContactRecord() {
    }

    public ContactRecord(
           int cntctHostCustNbr,
           java.lang.String locTypCd,
           java.lang.String locNbr,
           int seqNbr,
           short cntctMethCd,
           short cntctAddrCd,
           short cntctPhnCd,
           short cntctEmailTypCd,
           java.lang.String cntctWkBgnTm,
           java.lang.String cntctWkEndTm,
           java.lang.String cntctWkendBgnTm,
           java.lang.String cntctWkendEndTm,
           java.lang.String actvFlg,
           int agntSeqNbr,
           java.lang.String agntLocTypCd,
           java.lang.String agntLocNbr) {
           this.cntctHostCustNbr = cntctHostCustNbr;
           this.locTypCd = locTypCd;
           this.locNbr = locNbr;
           this.seqNbr = seqNbr;
           this.cntctMethCd = cntctMethCd;
           this.cntctAddrCd = cntctAddrCd;
           this.cntctPhnCd = cntctPhnCd;
           this.cntctEmailTypCd = cntctEmailTypCd;
           this.cntctWkBgnTm = cntctWkBgnTm;
           this.cntctWkEndTm = cntctWkEndTm;
           this.cntctWkendBgnTm = cntctWkendBgnTm;
           this.cntctWkendEndTm = cntctWkendEndTm;
           this.actvFlg = actvFlg;
           this.agntSeqNbr = agntSeqNbr;
           this.agntLocTypCd = agntLocTypCd;
           this.agntLocNbr = agntLocNbr;
    }
    // WAS2TOMCAT Changes START
    
	/**
	 * Constructor
	 * 
	 * @param rs			Data to populate contact record with
	 * @throws SQLException		Thrown if an exception occurs iterating the resultset
	 */
	public ContactRecord(ResultSet rs) throws SQLException
	{
		this();
		cntctHostCustNbr = rs.getInt(COL_CNTCT_HCUST_NBR);
		locTypCd = rs.getString(COL_LOC_TYP_CD);
		locNbr = rs.getString(COL_LOC_NBR);
		seqNbr = rs.getInt(COL_SEQ_NBR);
		cntctMethCd = rs.getShort(COL_CNTCT_METH_CD);
		cntctAddrCd = rs.getShort(COL_CNTCT_ADDR_TYP_CD);
		cntctPhnCd = rs.getShort(COL_CNTCT_PHN_TYP_CD);
		cntctEmailTypCd = rs.getShort(COL_CNTCT_EMAIL_TYP_CD);
		cntctWkBgnTm = rs.getString(COL_CNTCT_WK_BGN_TM);
		cntctWkEndTm = rs.getString(COL_CNTCT_WK_END_TM);
		cntctWkendBgnTm = rs.getString(COL_CNTCT_WKND_BGN_TM);
		cntctWkendEndTm = rs.getString(COL_CNTCT_WKND_END_TM);
		actvFlg = rs.getString(COL_ACTV_FLG);
		agntSeqNbr = rs.getInt(COL_AGNT_SEQ_NBR);
		agntLocTypCd = rs.getString(COL_AGNT_LOC_TYP_CD);
		agntLocNbr = rs.getString(COL_AGNT_LOC_NBR);
	} // end constructor    
	// WAS2TOMCAT Changes END
    /**
     * Gets the cntctHostCustNbr value for this ContactRecord.
     * 
     * @return cntctHostCustNbr
     */
    public int getCntctHostCustNbr() {
        return cntctHostCustNbr;
    }


    /**
     * Sets the cntctHostCustNbr value for this ContactRecord.
     * 
     * @param cntctHostCustNbr
     */
    public void setCntctHostCustNbr(int cntctHostCustNbr) {
        this.cntctHostCustNbr = cntctHostCustNbr;
    }


    /**
     * Gets the locTypCd value for this ContactRecord.
     * 
     * @return locTypCd
     */
    public java.lang.String getLocTypCd() {
        return locTypCd;
    }


    /**
     * Sets the locTypCd value for this ContactRecord.
     * 
     * @param locTypCd
     */
    public void setLocTypCd(java.lang.String locTypCd) {
        this.locTypCd = locTypCd;
    }


    /**
     * Gets the locNbr value for this ContactRecord.
     * 
     * @return locNbr
     */
    public java.lang.String getLocNbr() {
        return locNbr;
    }


    /**
     * Sets the locNbr value for this ContactRecord.
     * 
     * @param locNbr
     */
    public void setLocNbr(java.lang.String locNbr) {
        this.locNbr = locNbr;
    }


    /**
     * Gets the seqNbr value for this ContactRecord.
     * 
     * @return seqNbr
     */
    public int getSeqNbr() {
        return seqNbr;
    }


    /**
     * Sets the seqNbr value for this ContactRecord.
     * 
     * @param seqNbr
     */
    public void setSeqNbr(int seqNbr) {
        this.seqNbr = seqNbr;
    }


    /**
     * Gets the cntctMethCd value for this ContactRecord.
     * 
     * @return cntctMethCd
     */
    public short getCntctMethCd() {
        return cntctMethCd;
    }


    /**
     * Sets the cntctMethCd value for this ContactRecord.
     * 
     * @param cntctMethCd
     */
    public void setCntctMethCd(short cntctMethCd) {
        this.cntctMethCd = cntctMethCd;
    }


    /**
     * Gets the cntctAddrCd value for this ContactRecord.
     * 
     * @return cntctAddrCd
     */
    public short getCntctAddrCd() {
        return cntctAddrCd;
    }


    /**
     * Sets the cntctAddrCd value for this ContactRecord.
     * 
     * @param cntctAddrCd
     */
    public void setCntctAddrCd(short cntctAddrCd) {
        this.cntctAddrCd = cntctAddrCd;
    }


    /**
     * Gets the cntctPhnCd value for this ContactRecord.
     * 
     * @return cntctPhnCd
     */
    public short getCntctPhnCd() {
        return cntctPhnCd;
    }


    /**
     * Sets the cntctPhnCd value for this ContactRecord.
     * 
     * @param cntctPhnCd
     */
    public void setCntctPhnCd(short cntctPhnCd) {
        this.cntctPhnCd = cntctPhnCd;
    }


    /**
     * Gets the cntctEmailTypCd value for this ContactRecord.
     * 
     * @return cntctEmailTypCd
     */
    public short getCntctEmailTypCd() {
        return cntctEmailTypCd;
    }


    /**
     * Sets the cntctEmailTypCd value for this ContactRecord.
     * 
     * @param cntctEmailTypCd
     */
    public void setCntctEmailTypCd(short cntctEmailTypCd) {
        this.cntctEmailTypCd = cntctEmailTypCd;
    }


    /**
     * Gets the cntctWkBgnTm value for this ContactRecord.
     * 
     * @return cntctWkBgnTm
     */
    public java.lang.String getCntctWkBgnTm() {
        return cntctWkBgnTm;
    }


    /**
     * Sets the cntctWkBgnTm value for this ContactRecord.
     * 
     * @param cntctWkBgnTm
     */
    public void setCntctWkBgnTm(java.lang.String cntctWkBgnTm) {
        this.cntctWkBgnTm = cntctWkBgnTm;
    }


    /**
     * Gets the cntctWkEndTm value for this ContactRecord.
     * 
     * @return cntctWkEndTm
     */
    public java.lang.String getCntctWkEndTm() {
        return cntctWkEndTm;
    }


    /**
     * Sets the cntctWkEndTm value for this ContactRecord.
     * 
     * @param cntctWkEndTm
     */
    public void setCntctWkEndTm(java.lang.String cntctWkEndTm) {
        this.cntctWkEndTm = cntctWkEndTm;
    }


    /**
     * Gets the cntctWkendBgnTm value for this ContactRecord.
     * 
     * @return cntctWkendBgnTm
     */
    public java.lang.String getCntctWkendBgnTm() {
        return cntctWkendBgnTm;
    }


    /**
     * Sets the cntctWkendBgnTm value for this ContactRecord.
     * 
     * @param cntctWkendBgnTm
     */
    public void setCntctWkendBgnTm(java.lang.String cntctWkendBgnTm) {
        this.cntctWkendBgnTm = cntctWkendBgnTm;
    }


    /**
     * Gets the cntctWkendEndTm value for this ContactRecord.
     * 
     * @return cntctWkendEndTm
     */
    public java.lang.String getCntctWkendEndTm() {
        return cntctWkendEndTm;
    }


    /**
     * Sets the cntctWkendEndTm value for this ContactRecord.
     * 
     * @param cntctWkendEndTm
     */
    public void setCntctWkendEndTm(java.lang.String cntctWkendEndTm) {
        this.cntctWkendEndTm = cntctWkendEndTm;
    }


    /**
     * Gets the actvFlg value for this ContactRecord.
     * 
     * @return actvFlg
     */
    public java.lang.String getActvFlg() {
        return actvFlg;
    }


    /**
     * Sets the actvFlg value for this ContactRecord.
     * 
     * @param actvFlg
     */
    public void setActvFlg(java.lang.String actvFlg) {
        this.actvFlg = actvFlg;
    }


    /**
     * Gets the agntSeqNbr value for this ContactRecord.
     * 
     * @return agntSeqNbr
     */
    public int getAgntSeqNbr() {
        return agntSeqNbr;
    }


    /**
     * Sets the agntSeqNbr value for this ContactRecord.
     * 
     * @param agntSeqNbr
     */
    public void setAgntSeqNbr(int agntSeqNbr) {
        this.agntSeqNbr = agntSeqNbr;
    }


    /**
     * Gets the agntLocTypCd value for this ContactRecord.
     * 
     * @return agntLocTypCd
     */
    public java.lang.String getAgntLocTypCd() {
        return agntLocTypCd;
    }


    /**
     * Sets the agntLocTypCd value for this ContactRecord.
     * 
     * @param agntLocTypCd
     */
    public void setAgntLocTypCd(java.lang.String agntLocTypCd) {
        this.agntLocTypCd = agntLocTypCd;
    }


    /**
     * Gets the agntLocNbr value for this ContactRecord.
     * 
     * @return agntLocNbr
     */
    public java.lang.String getAgntLocNbr() {
        return agntLocNbr;
    }


    /**
     * Sets the agntLocNbr value for this ContactRecord.
     * 
     * @param agntLocNbr
     */
    public void setAgntLocNbr(java.lang.String agntLocNbr) {
        this.agntLocNbr = agntLocNbr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContactRecord)) return false;
        ContactRecord other = (ContactRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cntctHostCustNbr == other.getCntctHostCustNbr() &&
            ((this.locTypCd==null && other.getLocTypCd()==null) || 
             (this.locTypCd!=null &&
              this.locTypCd.equals(other.getLocTypCd()))) &&
            ((this.locNbr==null && other.getLocNbr()==null) || 
             (this.locNbr!=null &&
              this.locNbr.equals(other.getLocNbr()))) &&
            this.seqNbr == other.getSeqNbr() &&
            this.cntctMethCd == other.getCntctMethCd() &&
            this.cntctAddrCd == other.getCntctAddrCd() &&
            this.cntctPhnCd == other.getCntctPhnCd() &&
            this.cntctEmailTypCd == other.getCntctEmailTypCd() &&
            ((this.cntctWkBgnTm==null && other.getCntctWkBgnTm()==null) || 
             (this.cntctWkBgnTm!=null &&
              this.cntctWkBgnTm.equals(other.getCntctWkBgnTm()))) &&
            ((this.cntctWkEndTm==null && other.getCntctWkEndTm()==null) || 
             (this.cntctWkEndTm!=null &&
              this.cntctWkEndTm.equals(other.getCntctWkEndTm()))) &&
            ((this.cntctWkendBgnTm==null && other.getCntctWkendBgnTm()==null) || 
             (this.cntctWkendBgnTm!=null &&
              this.cntctWkendBgnTm.equals(other.getCntctWkendBgnTm()))) &&
            ((this.cntctWkendEndTm==null && other.getCntctWkendEndTm()==null) || 
             (this.cntctWkendEndTm!=null &&
              this.cntctWkendEndTm.equals(other.getCntctWkendEndTm()))) &&
            ((this.actvFlg==null && other.getActvFlg()==null) || 
             (this.actvFlg!=null &&
              this.actvFlg.equals(other.getActvFlg()))) &&
            this.agntSeqNbr == other.getAgntSeqNbr() &&
            ((this.agntLocTypCd==null && other.getAgntLocTypCd()==null) || 
             (this.agntLocTypCd!=null &&
              this.agntLocTypCd.equals(other.getAgntLocTypCd()))) &&
            ((this.agntLocNbr==null && other.getAgntLocNbr()==null) || 
             (this.agntLocNbr!=null &&
              this.agntLocNbr.equals(other.getAgntLocNbr())));
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
        _hashCode += getCntctHostCustNbr();
        if (getLocTypCd() != null) {
            _hashCode += getLocTypCd().hashCode();
        }
        if (getLocNbr() != null) {
            _hashCode += getLocNbr().hashCode();
        }
        _hashCode += getSeqNbr();
        _hashCode += getCntctMethCd();
        _hashCode += getCntctAddrCd();
        _hashCode += getCntctPhnCd();
        _hashCode += getCntctEmailTypCd();
        if (getCntctWkBgnTm() != null) {
            _hashCode += getCntctWkBgnTm().hashCode();
        }
        if (getCntctWkEndTm() != null) {
            _hashCode += getCntctWkEndTm().hashCode();
        }
        if (getCntctWkendBgnTm() != null) {
            _hashCode += getCntctWkendBgnTm().hashCode();
        }
        if (getCntctWkendEndTm() != null) {
            _hashCode += getCntctWkendEndTm().hashCode();
        }
        if (getActvFlg() != null) {
            _hashCode += getActvFlg().hashCode();
        }
        _hashCode += getAgntSeqNbr();
        if (getAgntLocTypCd() != null) {
            _hashCode += getAgntLocTypCd().hashCode();
        }
        if (getAgntLocNbr() != null) {
            _hashCode += getAgntLocNbr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContactRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ContactRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctHostCustNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctHostCustNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("cntctMethCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctMethCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctAddrCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctAddrCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctPhnCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctPhnCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctEmailTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctEmailTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctWkBgnTm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctWkBgnTm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctWkEndTm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctWkEndTm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctWkendBgnTm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctWkendBgnTm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctWkendEndTm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctWkendEndTm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actvFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actvFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agntSeqNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agntSeqNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agntLocTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agntLocTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agntLocNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agntLocNbr"));
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
