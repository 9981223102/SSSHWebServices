/**
 * RentalRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class RentalRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String dfltDpstMeth;

    private short rntlCustStatCd;

    private java.lang.String dmgWvrReqdFlg;

    private java.lang.String custPOReqdFlg;

    private java.lang.String jobSiteReqdFlg;

    private short ltdRntlCnt;

    private double ltdRntlAmt;

    private java.util.Calendar custLastRntlDt;

    private java.lang.String rntlFedTaxId;

    private java.util.Calendar rntlTaxExmptUpdDt;

    private com.homedepot.ss.sh.webservices.customer.UnfvrRentalRecord[] unfvrRactvyRecords;

    public RentalRecord() {
    }

    public RentalRecord(
           java.lang.String dfltDpstMeth,
           short rntlCustStatCd,
           java.lang.String dmgWvrReqdFlg,
           java.lang.String custPOReqdFlg,
           java.lang.String jobSiteReqdFlg,
           short ltdRntlCnt,
           double ltdRntlAmt,
           java.util.Calendar custLastRntlDt,
           java.lang.String rntlFedTaxId,
           java.util.Calendar rntlTaxExmptUpdDt,
           com.homedepot.ss.sh.webservices.customer.UnfvrRentalRecord[] unfvrRactvyRecords) {
           this.dfltDpstMeth = dfltDpstMeth;
           this.rntlCustStatCd = rntlCustStatCd;
           this.dmgWvrReqdFlg = dmgWvrReqdFlg;
           this.custPOReqdFlg = custPOReqdFlg;
           this.jobSiteReqdFlg = jobSiteReqdFlg;
           this.ltdRntlCnt = ltdRntlCnt;
           this.ltdRntlAmt = ltdRntlAmt;
           this.custLastRntlDt = custLastRntlDt;
           this.rntlFedTaxId = rntlFedTaxId;
           this.rntlTaxExmptUpdDt = rntlTaxExmptUpdDt;
           this.unfvrRactvyRecords = unfvrRactvyRecords;
    }

    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs				Data to populate rental record with
	 * @throws SQLException
	 */
	public RentalRecord(ResultSet rs) throws SQLException
	{
		this();
		rntlCustStatCd = rs.getShort(COL_CUST_STAT_CD);
		dfltDpstMeth = rs.getString(COL_DFLT_DEPST_METH_CD);
		dmgWvrReqdFlg = rs.getString(COL_DMG_WVR_REQD_FLG);
		custPOReqdFlg = rs.getString(COL_CUST_PO_REQD_FLG);
		jobSiteReqdFlg = rs.getString(COL_JOB_SITE_REQD_FLG);
		ltdRntlCnt = rs.getShort(COL_LTD_RNTL_CNT);
		ltdRntlAmt = rs.getDouble(COL_LTD_RNTL_AMT);
		
		//Tomcat Migration - Tcs Changes 08/12/2010
   		/*localCustLastRntlDt = rs.getDate(COL_CUST_LAST_RNTL_DT);*/
		if (rs.getDate(COL_CUST_LAST_RNTL_DT) != null){
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(rs.getDate(COL_CUST_LAST_RNTL_DT));
			custLastRntlDt=calendar;
		}
		rntlFedTaxId = rs.getString(COL_FED_TAX_ID);
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*localRntlTaxExmptUpdDt = rs.getDate(COL_TAX_EXMPT_UPD_DT);*/
		if (rs.getDate(COL_TAX_EXMPT_UPD_DT) != null){
			Calendar calendar=Calendar.getInstance();		
			calendar.setTime(rs.getDate(COL_TAX_EXMPT_UPD_DT));
			rntlTaxExmptUpdDt=calendar;
		}
	}
	// WAS2TOMCAT Changes END
    /**
     * Gets the dfltDpstMeth value for this RentalRecord.
     * 
     * @return dfltDpstMeth
     */
    public java.lang.String getDfltDpstMeth() {
        return dfltDpstMeth;
    }


    /**
     * Sets the dfltDpstMeth value for this RentalRecord.
     * 
     * @param dfltDpstMeth
     */
    public void setDfltDpstMeth(java.lang.String dfltDpstMeth) {
        this.dfltDpstMeth = dfltDpstMeth;
    }


    /**
     * Gets the rntlCustStatCd value for this RentalRecord.
     * 
     * @return rntlCustStatCd
     */
    public short getRntlCustStatCd() {
        return rntlCustStatCd;
    }


    /**
     * Sets the rntlCustStatCd value for this RentalRecord.
     * 
     * @param rntlCustStatCd
     */
    public void setRntlCustStatCd(short rntlCustStatCd) {
        this.rntlCustStatCd = rntlCustStatCd;
    }


    /**
     * Gets the dmgWvrReqdFlg value for this RentalRecord.
     * 
     * @return dmgWvrReqdFlg
     */
    public java.lang.String getDmgWvrReqdFlg() {
        return dmgWvrReqdFlg;
    }


    /**
     * Sets the dmgWvrReqdFlg value for this RentalRecord.
     * 
     * @param dmgWvrReqdFlg
     */
    public void setDmgWvrReqdFlg(java.lang.String dmgWvrReqdFlg) {
        this.dmgWvrReqdFlg = dmgWvrReqdFlg;
    }


    /**
     * Gets the custPOReqdFlg value for this RentalRecord.
     * 
     * @return custPOReqdFlg
     */
    public java.lang.String getCustPOReqdFlg() {
        return custPOReqdFlg;
    }


    /**
     * Sets the custPOReqdFlg value for this RentalRecord.
     * 
     * @param custPOReqdFlg
     */
    public void setCustPOReqdFlg(java.lang.String custPOReqdFlg) {
        this.custPOReqdFlg = custPOReqdFlg;
    }


    /**
     * Gets the jobSiteReqdFlg value for this RentalRecord.
     * 
     * @return jobSiteReqdFlg
     */
    public java.lang.String getJobSiteReqdFlg() {
        return jobSiteReqdFlg;
    }


    /**
     * Sets the jobSiteReqdFlg value for this RentalRecord.
     * 
     * @param jobSiteReqdFlg
     */
    public void setJobSiteReqdFlg(java.lang.String jobSiteReqdFlg) {
        this.jobSiteReqdFlg = jobSiteReqdFlg;
    }


    /**
     * Gets the ltdRntlCnt value for this RentalRecord.
     * 
     * @return ltdRntlCnt
     */
    public short getLtdRntlCnt() {
        return ltdRntlCnt;
    }


    /**
     * Sets the ltdRntlCnt value for this RentalRecord.
     * 
     * @param ltdRntlCnt
     */
    public void setLtdRntlCnt(short ltdRntlCnt) {
        this.ltdRntlCnt = ltdRntlCnt;
    }


    /**
     * Gets the ltdRntlAmt value for this RentalRecord.
     * 
     * @return ltdRntlAmt
     */
    public double getLtdRntlAmt() {
        return ltdRntlAmt;
    }


    /**
     * Sets the ltdRntlAmt value for this RentalRecord.
     * 
     * @param ltdRntlAmt
     */
    public void setLtdRntlAmt(double ltdRntlAmt) {
        this.ltdRntlAmt = ltdRntlAmt;
    }


    /**
     * Gets the custLastRntlDt value for this RentalRecord.
     * 
     * @return custLastRntlDt
     */
    public java.util.Calendar getCustLastRntlDt() {
        return custLastRntlDt;
    }


    /**
     * Sets the custLastRntlDt value for this RentalRecord.
     * 
     * @param custLastRntlDt
     */
    public void setCustLastRntlDt(java.util.Calendar custLastRntlDt) {
        this.custLastRntlDt = custLastRntlDt;
    }


    /**
     * Gets the rntlFedTaxId value for this RentalRecord.
     * 
     * @return rntlFedTaxId
     */
    public java.lang.String getRntlFedTaxId() {
        return rntlFedTaxId;
    }


    /**
     * Sets the rntlFedTaxId value for this RentalRecord.
     * 
     * @param rntlFedTaxId
     */
    public void setRntlFedTaxId(java.lang.String rntlFedTaxId) {
        this.rntlFedTaxId = rntlFedTaxId;
    }


    /**
     * Gets the rntlTaxExmptUpdDt value for this RentalRecord.
     * 
     * @return rntlTaxExmptUpdDt
     */
    public java.util.Calendar getRntlTaxExmptUpdDt() {
        return rntlTaxExmptUpdDt;
    }


    /**
     * Sets the rntlTaxExmptUpdDt value for this RentalRecord.
     * 
     * @param rntlTaxExmptUpdDt
     */
    public void setRntlTaxExmptUpdDt(java.util.Calendar rntlTaxExmptUpdDt) {
        this.rntlTaxExmptUpdDt = rntlTaxExmptUpdDt;
    }


    /**
     * Gets the unfvrRactvyRecords value for this RentalRecord.
     * 
     * @return unfvrRactvyRecords
     */
    public com.homedepot.ss.sh.webservices.customer.UnfvrRentalRecord[] getUnfvrRactvyRecords() {
        return unfvrRactvyRecords;
    }


    /**
     * Sets the unfvrRactvyRecords value for this RentalRecord.
     * 
     * @param unfvrRactvyRecords
     */
    public void setUnfvrRactvyRecords(com.homedepot.ss.sh.webservices.customer.UnfvrRentalRecord[] unfvrRactvyRecords) {
        this.unfvrRactvyRecords = unfvrRactvyRecords;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RentalRecord)) return false;
        RentalRecord other = (RentalRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dfltDpstMeth==null && other.getDfltDpstMeth()==null) || 
             (this.dfltDpstMeth!=null &&
              this.dfltDpstMeth.equals(other.getDfltDpstMeth()))) &&
            this.rntlCustStatCd == other.getRntlCustStatCd() &&
            ((this.dmgWvrReqdFlg==null && other.getDmgWvrReqdFlg()==null) || 
             (this.dmgWvrReqdFlg!=null &&
              this.dmgWvrReqdFlg.equals(other.getDmgWvrReqdFlg()))) &&
            ((this.custPOReqdFlg==null && other.getCustPOReqdFlg()==null) || 
             (this.custPOReqdFlg!=null &&
              this.custPOReqdFlg.equals(other.getCustPOReqdFlg()))) &&
            ((this.jobSiteReqdFlg==null && other.getJobSiteReqdFlg()==null) || 
             (this.jobSiteReqdFlg!=null &&
              this.jobSiteReqdFlg.equals(other.getJobSiteReqdFlg()))) &&
            this.ltdRntlCnt == other.getLtdRntlCnt() &&
            this.ltdRntlAmt == other.getLtdRntlAmt() &&
            ((this.custLastRntlDt==null && other.getCustLastRntlDt()==null) || 
             (this.custLastRntlDt!=null &&
              this.custLastRntlDt.equals(other.getCustLastRntlDt()))) &&
            ((this.rntlFedTaxId==null && other.getRntlFedTaxId()==null) || 
             (this.rntlFedTaxId!=null &&
              this.rntlFedTaxId.equals(other.getRntlFedTaxId()))) &&
            ((this.rntlTaxExmptUpdDt==null && other.getRntlTaxExmptUpdDt()==null) || 
             (this.rntlTaxExmptUpdDt!=null &&
              this.rntlTaxExmptUpdDt.equals(other.getRntlTaxExmptUpdDt()))) &&
            ((this.unfvrRactvyRecords==null && other.getUnfvrRactvyRecords()==null) || 
             (this.unfvrRactvyRecords!=null &&
              java.util.Arrays.equals(this.unfvrRactvyRecords, other.getUnfvrRactvyRecords())));
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
        if (getDfltDpstMeth() != null) {
            _hashCode += getDfltDpstMeth().hashCode();
        }
        _hashCode += getRntlCustStatCd();
        if (getDmgWvrReqdFlg() != null) {
            _hashCode += getDmgWvrReqdFlg().hashCode();
        }
        if (getCustPOReqdFlg() != null) {
            _hashCode += getCustPOReqdFlg().hashCode();
        }
        if (getJobSiteReqdFlg() != null) {
            _hashCode += getJobSiteReqdFlg().hashCode();
        }
        _hashCode += getLtdRntlCnt();
        _hashCode += new Double(getLtdRntlAmt()).hashCode();
        if (getCustLastRntlDt() != null) {
            _hashCode += getCustLastRntlDt().hashCode();
        }
        if (getRntlFedTaxId() != null) {
            _hashCode += getRntlFedTaxId().hashCode();
        }
        if (getRntlTaxExmptUpdDt() != null) {
            _hashCode += getRntlTaxExmptUpdDt().hashCode();
        }
        if (getUnfvrRactvyRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnfvrRactvyRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnfvrRactvyRecords(), i);
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
        new org.apache.axis.description.TypeDesc(RentalRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "RentalRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dfltDpstMeth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dfltDpstMeth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rntlCustStatCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rntlCustStatCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dmgWvrReqdFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dmgWvrReqdFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custPOReqdFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custPOReqdFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobSiteReqdFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobSiteReqdFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ltdRntlCnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ltdRntlCnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ltdRntlAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ltdRntlAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custLastRntlDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custLastRntlDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rntlFedTaxId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rntlFedTaxId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rntlTaxExmptUpdDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rntlTaxExmptUpdDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unfvrRactvyRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unfvrRactvyRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "UnfvrRentalRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "UnfvrRentalRecord"));
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
