/**
 * TaxRuleRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class TaxRuleRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String locTypCd;

    private java.lang.String locNbr;

    private int seqNbr;

    private short jursdTypCd;

    private short jursdLvl;

    private int jursdCd;

    private java.lang.String taxPaymtAuthFlg;

    private java.lang.String taxExmptActvFlg;

    private short taxTyp;

    private short taxCd;

    private java.util.Calendar effBgnDt;

    private java.util.Calendar effEndDt;

    private double taxExmptAmt;

    private double taxExmptPct;

    public TaxRuleRecord() {
    }

    public TaxRuleRecord(
           java.lang.String locTypCd,
           java.lang.String locNbr,
           int seqNbr,
           short jursdTypCd,
           short jursdLvl,
           int jursdCd,
           java.lang.String taxPaymtAuthFlg,
           java.lang.String taxExmptActvFlg,
           short taxTyp,
           short taxCd,
           java.util.Calendar effBgnDt,
           java.util.Calendar effEndDt,
           double taxExmptAmt,
           double taxExmptPct) {
           this.locTypCd = locTypCd;
           this.locNbr = locNbr;
           this.seqNbr = seqNbr;
           this.jursdTypCd = jursdTypCd;
           this.jursdLvl = jursdLvl;
           this.jursdCd = jursdCd;
           this.taxPaymtAuthFlg = taxPaymtAuthFlg;
           this.taxExmptActvFlg = taxExmptActvFlg;
           this.taxTyp = taxTyp;
           this.taxCd = taxCd;
           this.effBgnDt = effBgnDt;
           this.effEndDt = effEndDt;
           this.taxExmptAmt = taxExmptAmt;
           this.taxExmptPct = taxExmptPct;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs		Data for the agent record
	 * @throws SQLException		Thown if a problem is encountered with the
	 * 													ResultSet		
	 */		
	public TaxRuleRecord(ResultSet rs) throws SQLException
	{
		this();
		locTypCd = rs.getString(COL_LOC_TYP_CD);
		locNbr = rs.getString(COL_LOC_NBR);
		seqNbr = rs.getInt(COL_SEQ_NBR);
		jursdTypCd = rs.getShort(COL_JURSD_TYP_CD);
		jursdLvl = rs.getShort(COL_JURSD_LVL_CD);
		jursdCd = rs.getShort(COL_JURSD_CD);
		taxPaymtAuthFlg = rs.getString(COL_TAX_PAYMT_AUTH_FLG);
		taxExmptActvFlg = rs.getString(COL_TAX_EXMPT_ACTV_FLG);
		taxTyp = rs.getShort(COL_TAX_TYP_CD);
		taxCd = rs.getShort(COL_TAX_CD);
		
		//Tomcat Migration - Tcs Changes 08/11/2010
		/*localEffBgnDt = rs.getDate(COL_EFF_BGN_DT);*/
		if (rs.getDate(COL_EFF_BGN_DT)!= null){
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(rs.getDate(COL_EFF_BGN_DT));
			effBgnDt=calendar;
		}
		
		//Tomcat Migration - Tcs Changes 08/11/2010
		/*localEffEndDt = rs.getDate(COL_EFF_END_DT);*/
		if (rs.getDate(COL_EFF_END_DT) != null){
			Calendar calendar1=Calendar.getInstance();
			calendar1.setTime(rs.getDate(COL_EFF_END_DT));
			effEndDt=calendar1;
		}
		taxExmptAmt = rs.getDouble(COL_TAX_EXMPT_AMT);
		taxExmptPct = rs.getDouble(COL_TAX_EXMPT_PCT);
	}
    
    // WAS2TOMCAT Changes END

    /**
     * Gets the locTypCd value for this TaxRuleRecord.
     * 
     * @return locTypCd
     */
    public java.lang.String getLocTypCd() {
        return locTypCd;
    }


    /**
     * Sets the locTypCd value for this TaxRuleRecord.
     * 
     * @param locTypCd
     */
    public void setLocTypCd(java.lang.String locTypCd) {
        this.locTypCd = locTypCd;
    }


    /**
     * Gets the locNbr value for this TaxRuleRecord.
     * 
     * @return locNbr
     */
    public java.lang.String getLocNbr() {
        return locNbr;
    }


    /**
     * Sets the locNbr value for this TaxRuleRecord.
     * 
     * @param locNbr
     */
    public void setLocNbr(java.lang.String locNbr) {
        this.locNbr = locNbr;
    }


    /**
     * Gets the seqNbr value for this TaxRuleRecord.
     * 
     * @return seqNbr
     */
    public int getSeqNbr() {
        return seqNbr;
    }


    /**
     * Sets the seqNbr value for this TaxRuleRecord.
     * 
     * @param seqNbr
     */
    public void setSeqNbr(int seqNbr) {
        this.seqNbr = seqNbr;
    }


    /**
     * Gets the jursdTypCd value for this TaxRuleRecord.
     * 
     * @return jursdTypCd
     */
    public short getJursdTypCd() {
        return jursdTypCd;
    }


    /**
     * Sets the jursdTypCd value for this TaxRuleRecord.
     * 
     * @param jursdTypCd
     */
    public void setJursdTypCd(short jursdTypCd) {
        this.jursdTypCd = jursdTypCd;
    }


    /**
     * Gets the jursdLvl value for this TaxRuleRecord.
     * 
     * @return jursdLvl
     */
    public short getJursdLvl() {
        return jursdLvl;
    }


    /**
     * Sets the jursdLvl value for this TaxRuleRecord.
     * 
     * @param jursdLvl
     */
    public void setJursdLvl(short jursdLvl) {
        this.jursdLvl = jursdLvl;
    }


    /**
     * Gets the jursdCd value for this TaxRuleRecord.
     * 
     * @return jursdCd
     */
    public int getJursdCd() {
        return jursdCd;
    }


    /**
     * Sets the jursdCd value for this TaxRuleRecord.
     * 
     * @param jursdCd
     */
    public void setJursdCd(int jursdCd) {
        this.jursdCd = jursdCd;
    }


    /**
     * Gets the taxPaymtAuthFlg value for this TaxRuleRecord.
     * 
     * @return taxPaymtAuthFlg
     */
    public java.lang.String getTaxPaymtAuthFlg() {
        return taxPaymtAuthFlg;
    }


    /**
     * Sets the taxPaymtAuthFlg value for this TaxRuleRecord.
     * 
     * @param taxPaymtAuthFlg
     */
    public void setTaxPaymtAuthFlg(java.lang.String taxPaymtAuthFlg) {
        this.taxPaymtAuthFlg = taxPaymtAuthFlg;
    }


    /**
     * Gets the taxExmptActvFlg value for this TaxRuleRecord.
     * 
     * @return taxExmptActvFlg
     */
    public java.lang.String getTaxExmptActvFlg() {
        return taxExmptActvFlg;
    }


    /**
     * Sets the taxExmptActvFlg value for this TaxRuleRecord.
     * 
     * @param taxExmptActvFlg
     */
    public void setTaxExmptActvFlg(java.lang.String taxExmptActvFlg) {
        this.taxExmptActvFlg = taxExmptActvFlg;
    }


    /**
     * Gets the taxTyp value for this TaxRuleRecord.
     * 
     * @return taxTyp
     */
    public short getTaxTyp() {
        return taxTyp;
    }


    /**
     * Sets the taxTyp value for this TaxRuleRecord.
     * 
     * @param taxTyp
     */
    public void setTaxTyp(short taxTyp) {
        this.taxTyp = taxTyp;
    }


    /**
     * Gets the taxCd value for this TaxRuleRecord.
     * 
     * @return taxCd
     */
    public short getTaxCd() {
        return taxCd;
    }


    /**
     * Sets the taxCd value for this TaxRuleRecord.
     * 
     * @param taxCd
     */
    public void setTaxCd(short taxCd) {
        this.taxCd = taxCd;
    }


    /**
     * Gets the effBgnDt value for this TaxRuleRecord.
     * 
     * @return effBgnDt
     */
    public java.util.Calendar getEffBgnDt() {
        return effBgnDt;
    }


    /**
     * Sets the effBgnDt value for this TaxRuleRecord.
     * 
     * @param effBgnDt
     */
    public void setEffBgnDt(java.util.Calendar effBgnDt) {
        this.effBgnDt = effBgnDt;
    }


    /**
     * Gets the effEndDt value for this TaxRuleRecord.
     * 
     * @return effEndDt
     */
    public java.util.Calendar getEffEndDt() {
        return effEndDt;
    }


    /**
     * Sets the effEndDt value for this TaxRuleRecord.
     * 
     * @param effEndDt
     */
    public void setEffEndDt(java.util.Calendar effEndDt) {
        this.effEndDt = effEndDt;
    }


    /**
     * Gets the taxExmptAmt value for this TaxRuleRecord.
     * 
     * @return taxExmptAmt
     */
    public double getTaxExmptAmt() {
        return taxExmptAmt;
    }


    /**
     * Sets the taxExmptAmt value for this TaxRuleRecord.
     * 
     * @param taxExmptAmt
     */
    public void setTaxExmptAmt(double taxExmptAmt) {
        this.taxExmptAmt = taxExmptAmt;
    }


    /**
     * Gets the taxExmptPct value for this TaxRuleRecord.
     * 
     * @return taxExmptPct
     */
    public double getTaxExmptPct() {
        return taxExmptPct;
    }


    /**
     * Sets the taxExmptPct value for this TaxRuleRecord.
     * 
     * @param taxExmptPct
     */
    public void setTaxExmptPct(double taxExmptPct) {
        this.taxExmptPct = taxExmptPct;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TaxRuleRecord)) return false;
        TaxRuleRecord other = (TaxRuleRecord) obj;
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
            ((this.taxPaymtAuthFlg==null && other.getTaxPaymtAuthFlg()==null) || 
             (this.taxPaymtAuthFlg!=null &&
              this.taxPaymtAuthFlg.equals(other.getTaxPaymtAuthFlg()))) &&
            ((this.taxExmptActvFlg==null && other.getTaxExmptActvFlg()==null) || 
             (this.taxExmptActvFlg!=null &&
              this.taxExmptActvFlg.equals(other.getTaxExmptActvFlg()))) &&
            this.taxTyp == other.getTaxTyp() &&
            this.taxCd == other.getTaxCd() &&
            ((this.effBgnDt==null && other.getEffBgnDt()==null) || 
             (this.effBgnDt!=null &&
              this.effBgnDt.equals(other.getEffBgnDt()))) &&
            ((this.effEndDt==null && other.getEffEndDt()==null) || 
             (this.effEndDt!=null &&
              this.effEndDt.equals(other.getEffEndDt()))) &&
            this.taxExmptAmt == other.getTaxExmptAmt() &&
            this.taxExmptPct == other.getTaxExmptPct();
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
        if (getTaxPaymtAuthFlg() != null) {
            _hashCode += getTaxPaymtAuthFlg().hashCode();
        }
        if (getTaxExmptActvFlg() != null) {
            _hashCode += getTaxExmptActvFlg().hashCode();
        }
        _hashCode += getTaxTyp();
        _hashCode += getTaxCd();
        if (getEffBgnDt() != null) {
            _hashCode += getEffBgnDt().hashCode();
        }
        if (getEffEndDt() != null) {
            _hashCode += getEffEndDt().hashCode();
        }
        _hashCode += new Double(getTaxExmptAmt()).hashCode();
        _hashCode += new Double(getTaxExmptPct()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TaxRuleRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "TaxRuleRecord"));
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
        elemField.setFieldName("taxPaymtAuthFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxPaymtAuthFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxExmptActvFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxExmptActvFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxTyp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxTyp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effBgnDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effBgnDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effEndDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effEndDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxExmptAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxExmptAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxExmptPct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxExmptPct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
