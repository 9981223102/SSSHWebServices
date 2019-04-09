/**
 * PRODetailRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class PRODetailRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String orgNm;

    private java.lang.String SICCd;

    private java.lang.String taxExmptFlg;

    private java.util.Calendar taxExmptUpdDt;

    private java.lang.String fedTaxId;

    private com.homedepot.ss.sh.webservices.customer.AgentRecord[] agents;

    public PRODetailRecord() {
    }

    public PRODetailRecord(
           java.lang.String orgNm,
           java.lang.String SICCd,
           java.lang.String taxExmptFlg,
           java.util.Calendar taxExmptUpdDt,
           java.lang.String fedTaxId,
           com.homedepot.ss.sh.webservices.customer.AgentRecord[] agents) {
           this.orgNm = orgNm;
           this.SICCd = SICCd;
           this.taxExmptFlg = taxExmptFlg;
           this.taxExmptUpdDt = taxExmptUpdDt;
           this.fedTaxId = fedTaxId;
           this.agents = agents;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs			Data to build this PRODetailRecord from
	 * @throws SQLException		Thrown if there is an exception iterating the result set
	 */
	public PRODetailRecord(ResultSet rs) throws SQLException
	{
		this();
		orgNm = rs.getString(COL_ORG_CUST_NM);
		SICCd = rs.getString(COL_SIC_CD);
		taxExmptFlg = rs.getString(COL_TAX_EXMPT_FLG);
		
		//Tomcat Migration - Tcs Changes 08/12/2010
   		/*localTaxExmptUpdDt = rs.getDate(COL_TAX_EXMPT_UPD_DT);*/
		if(rs.getDate(COL_TAX_EXMPT_UPD_DT) != null){
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(rs.getDate(COL_TAX_EXMPT_UPD_DT));
			taxExmptUpdDt=calendar;
		}
		fedTaxId = rs.getString(COL_FED_TAX_ID);
	} // end constructor
    // WAS2TOMCAT Changes END

    /**
     * Gets the orgNm value for this PRODetailRecord.
     * 
     * @return orgNm
     */
    public java.lang.String getOrgNm() {
        return orgNm;
    }


    /**
     * Sets the orgNm value for this PRODetailRecord.
     * 
     * @param orgNm
     */
    public void setOrgNm(java.lang.String orgNm) {
        this.orgNm = orgNm;
    }


    /**
     * Gets the SICCd value for this PRODetailRecord.
     * 
     * @return SICCd
     */
    public java.lang.String getSICCd() {
        return SICCd;
    }


    /**
     * Sets the SICCd value for this PRODetailRecord.
     * 
     * @param SICCd
     */
    public void setSICCd(java.lang.String SICCd) {
        this.SICCd = SICCd;
    }


    /**
     * Gets the taxExmptFlg value for this PRODetailRecord.
     * 
     * @return taxExmptFlg
     */
    public java.lang.String getTaxExmptFlg() {
        return taxExmptFlg;
    }


    /**
     * Sets the taxExmptFlg value for this PRODetailRecord.
     * 
     * @param taxExmptFlg
     */
    public void setTaxExmptFlg(java.lang.String taxExmptFlg) {
        this.taxExmptFlg = taxExmptFlg;
    }


    /**
     * Gets the taxExmptUpdDt value for this PRODetailRecord.
     * 
     * @return taxExmptUpdDt
     */
    public java.util.Calendar getTaxExmptUpdDt() {
        return taxExmptUpdDt;
    }


    /**
     * Sets the taxExmptUpdDt value for this PRODetailRecord.
     * 
     * @param taxExmptUpdDt
     */
    public void setTaxExmptUpdDt(java.util.Calendar taxExmptUpdDt) {
        this.taxExmptUpdDt = taxExmptUpdDt;
    }


    /**
     * Gets the fedTaxId value for this PRODetailRecord.
     * 
     * @return fedTaxId
     */
    public java.lang.String getFedTaxId() {
        return fedTaxId;
    }


    /**
     * Sets the fedTaxId value for this PRODetailRecord.
     * 
     * @param fedTaxId
     */
    public void setFedTaxId(java.lang.String fedTaxId) {
        this.fedTaxId = fedTaxId;
    }


    /**
     * Gets the agents value for this PRODetailRecord.
     * 
     * @return agents
     */
    public com.homedepot.ss.sh.webservices.customer.AgentRecord[] getAgents() {
        return agents;
    }


    /**
     * Sets the agents value for this PRODetailRecord.
     * 
     * @param agents
     */
    public void setAgents(com.homedepot.ss.sh.webservices.customer.AgentRecord[] agents) {
        this.agents = agents;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PRODetailRecord)) return false;
        PRODetailRecord other = (PRODetailRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.orgNm==null && other.getOrgNm()==null) || 
             (this.orgNm!=null &&
              this.orgNm.equals(other.getOrgNm()))) &&
            ((this.SICCd==null && other.getSICCd()==null) || 
             (this.SICCd!=null &&
              this.SICCd.equals(other.getSICCd()))) &&
            ((this.taxExmptFlg==null && other.getTaxExmptFlg()==null) || 
             (this.taxExmptFlg!=null &&
              this.taxExmptFlg.equals(other.getTaxExmptFlg()))) &&
            ((this.taxExmptUpdDt==null && other.getTaxExmptUpdDt()==null) || 
             (this.taxExmptUpdDt!=null &&
              this.taxExmptUpdDt.equals(other.getTaxExmptUpdDt()))) &&
            ((this.fedTaxId==null && other.getFedTaxId()==null) || 
             (this.fedTaxId!=null &&
              this.fedTaxId.equals(other.getFedTaxId()))) &&
            ((this.agents==null && other.getAgents()==null) || 
             (this.agents!=null &&
              java.util.Arrays.equals(this.agents, other.getAgents())));
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
        if (getOrgNm() != null) {
            _hashCode += getOrgNm().hashCode();
        }
        if (getSICCd() != null) {
            _hashCode += getSICCd().hashCode();
        }
        if (getTaxExmptFlg() != null) {
            _hashCode += getTaxExmptFlg().hashCode();
        }
        if (getTaxExmptUpdDt() != null) {
            _hashCode += getTaxExmptUpdDt().hashCode();
        }
        if (getFedTaxId() != null) {
            _hashCode += getFedTaxId().hashCode();
        }
        if (getAgents() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAgents());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAgents(), i);
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
        new org.apache.axis.description.TypeDesc(PRODetailRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "PRODetailRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SICCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SICCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxExmptFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxExmptFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxExmptUpdDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxExmptUpdDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fedTaxId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fedTaxId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agents");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agents"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AgentRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "AgentRecord"));
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
