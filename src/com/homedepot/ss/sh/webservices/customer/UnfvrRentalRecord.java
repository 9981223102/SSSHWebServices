/**
 * UnfvrRentalRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class UnfvrRentalRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String locTypCd;

    private java.lang.String locNbr;

    private java.lang.String locName;

    private int rntlAgrmntNbr;

    private java.lang.String rpgmPhnAreaCd;

    private java.lang.String rpgmPhnLoclNbr;

    private java.lang.String rpgmPhnExt;

    private short unfvrRactvyCd;

    private double unfvrRactvyAmt;

    private java.util.Calendar resDt;

    private java.util.Calendar rntlAgrmntCloseDt;

    private java.lang.String lastUpdUserId;

    private java.util.Calendar lastUpdTm;

    public UnfvrRentalRecord() {
    }

    public UnfvrRentalRecord(
           java.lang.String locTypCd,
           java.lang.String locNbr,
           java.lang.String locName,
           int rntlAgrmntNbr,
           java.lang.String rpgmPhnAreaCd,
           java.lang.String rpgmPhnLoclNbr,
           java.lang.String rpgmPhnExt,
           short unfvrRactvyCd,
           double unfvrRactvyAmt,
           java.util.Calendar resDt,
           java.util.Calendar rntlAgrmntCloseDt,
           java.lang.String lastUpdUserId,
           java.util.Calendar lastUpdTm) {
           this.locTypCd = locTypCd;
           this.locNbr = locNbr;
           this.locName = locName;
           this.rntlAgrmntNbr = rntlAgrmntNbr;
           this.rpgmPhnAreaCd = rpgmPhnAreaCd;
           this.rpgmPhnLoclNbr = rpgmPhnLoclNbr;
           this.rpgmPhnExt = rpgmPhnExt;
           this.unfvrRactvyCd = unfvrRactvyCd;
           this.unfvrRactvyAmt = unfvrRactvyAmt;
           this.resDt = resDt;
           this.rntlAgrmntCloseDt = rntlAgrmntCloseDt;
           this.lastUpdUserId = lastUpdUserId;
           this.lastUpdTm = lastUpdTm;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs		Data for the unfavorable rental activity record
	 * @throws SQLException		Thown if a problem is encountered with the
	 * 													ResultSet		
	 */	
	public UnfvrRentalRecord(ResultSet rs) throws SQLException
	{
		this();
		locTypCd = rs.getString(COL_LOC_TYP_CD);
		locNbr = rs.getString(COL_LOC_NBR);
		locName = rs.getString(COL_LOC_NM);
		rntlAgrmntNbr = rs.getInt(COL_RAGREE_NBR);
		rpgmPhnAreaCd = rs.getString(COL_RPGM_PHN_ACTY_CD);
		rpgmPhnLoclNbr = rs.getString(COL_RPGM_PHN_LOCL_NBR);
		rpgmPhnExt = rs.getString(COL_RPGM_PHN_EXT_NBR);
		unfvrRactvyCd = rs.getShort(COL_UNFVR_RACTVY_CD);
		unfvrRactvyAmt = rs.getDouble(COL_UNFVR_RACTVY_AMT);
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*localResDt = rs.getDate(COL_RSLTN_DT);*/
		if(rs.getDate(COL_RSLTN_DT) != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rs.getDate(COL_RSLTN_DT));
			resDt=calendar;
		}
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*localRntlAgrmntCloseDt = rs.getDate(COL_RAGREE_CLS_DT);*/
		if(rs.getDate(COL_RAGREE_CLS_DT) != null){
			Calendar calendar1=Calendar.getInstance();
			calendar1.setTime(rs.getDate(COL_RAGREE_CLS_DT));
			rntlAgrmntCloseDt=calendar1;
		}
		lastUpdUserId = rs.getString(COL_LAST_UPD_USER_ID);
		/* 
		 * Time pulled from the resultset will be in the format of the timezone on the machine.
		 * Since this is the case, we will add the offset back to the time to make it GMT.
		 */
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		if (rs.getTimestamp(COL_LAST_UPD_TS) != null){
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(rs.getTimestamp(COL_LAST_UPD_TS));
			int offset = calendar2.get(Calendar.ZONE_OFFSET) + calendar2.get(Calendar.DST_OFFSET);
			calendar2.add(Calendar.MILLISECOND, offset);
			lastUpdTm = calendar2;			
		}
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*localLastUpdTm = calendar.getTime();*/
	}
	// WAS2TOMCAT Changes END

    /**
     * Gets the locTypCd value for this UnfvrRentalRecord.
     * 
     * @return locTypCd
     */
    public java.lang.String getLocTypCd() {
        return locTypCd;
    }


    /**
     * Sets the locTypCd value for this UnfvrRentalRecord.
     * 
     * @param locTypCd
     */
    public void setLocTypCd(java.lang.String locTypCd) {
        this.locTypCd = locTypCd;
    }


    /**
     * Gets the locNbr value for this UnfvrRentalRecord.
     * 
     * @return locNbr
     */
    public java.lang.String getLocNbr() {
        return locNbr;
    }


    /**
     * Sets the locNbr value for this UnfvrRentalRecord.
     * 
     * @param locNbr
     */
    public void setLocNbr(java.lang.String locNbr) {
        this.locNbr = locNbr;
    }


    /**
     * Gets the locName value for this UnfvrRentalRecord.
     * 
     * @return locName
     */
    public java.lang.String getLocName() {
        return locName;
    }


    /**
     * Sets the locName value for this UnfvrRentalRecord.
     * 
     * @param locName
     */
    public void setLocName(java.lang.String locName) {
        this.locName = locName;
    }


    /**
     * Gets the rntlAgrmntNbr value for this UnfvrRentalRecord.
     * 
     * @return rntlAgrmntNbr
     */
    public int getRntlAgrmntNbr() {
        return rntlAgrmntNbr;
    }


    /**
     * Sets the rntlAgrmntNbr value for this UnfvrRentalRecord.
     * 
     * @param rntlAgrmntNbr
     */
    public void setRntlAgrmntNbr(int rntlAgrmntNbr) {
        this.rntlAgrmntNbr = rntlAgrmntNbr;
    }


    /**
     * Gets the rpgmPhnAreaCd value for this UnfvrRentalRecord.
     * 
     * @return rpgmPhnAreaCd
     */
    public java.lang.String getRpgmPhnAreaCd() {
        return rpgmPhnAreaCd;
    }


    /**
     * Sets the rpgmPhnAreaCd value for this UnfvrRentalRecord.
     * 
     * @param rpgmPhnAreaCd
     */
    public void setRpgmPhnAreaCd(java.lang.String rpgmPhnAreaCd) {
        this.rpgmPhnAreaCd = rpgmPhnAreaCd;
    }


    /**
     * Gets the rpgmPhnLoclNbr value for this UnfvrRentalRecord.
     * 
     * @return rpgmPhnLoclNbr
     */
    public java.lang.String getRpgmPhnLoclNbr() {
        return rpgmPhnLoclNbr;
    }


    /**
     * Sets the rpgmPhnLoclNbr value for this UnfvrRentalRecord.
     * 
     * @param rpgmPhnLoclNbr
     */
    public void setRpgmPhnLoclNbr(java.lang.String rpgmPhnLoclNbr) {
        this.rpgmPhnLoclNbr = rpgmPhnLoclNbr;
    }


    /**
     * Gets the rpgmPhnExt value for this UnfvrRentalRecord.
     * 
     * @return rpgmPhnExt
     */
    public java.lang.String getRpgmPhnExt() {
        return rpgmPhnExt;
    }


    /**
     * Sets the rpgmPhnExt value for this UnfvrRentalRecord.
     * 
     * @param rpgmPhnExt
     */
    public void setRpgmPhnExt(java.lang.String rpgmPhnExt) {
        this.rpgmPhnExt = rpgmPhnExt;
    }


    /**
     * Gets the unfvrRactvyCd value for this UnfvrRentalRecord.
     * 
     * @return unfvrRactvyCd
     */
    public short getUnfvrRactvyCd() {
        return unfvrRactvyCd;
    }


    /**
     * Sets the unfvrRactvyCd value for this UnfvrRentalRecord.
     * 
     * @param unfvrRactvyCd
     */
    public void setUnfvrRactvyCd(short unfvrRactvyCd) {
        this.unfvrRactvyCd = unfvrRactvyCd;
    }


    /**
     * Gets the unfvrRactvyAmt value for this UnfvrRentalRecord.
     * 
     * @return unfvrRactvyAmt
     */
    public double getUnfvrRactvyAmt() {
        return unfvrRactvyAmt;
    }


    /**
     * Sets the unfvrRactvyAmt value for this UnfvrRentalRecord.
     * 
     * @param unfvrRactvyAmt
     */
    public void setUnfvrRactvyAmt(double unfvrRactvyAmt) {
        this.unfvrRactvyAmt = unfvrRactvyAmt;
    }


    /**
     * Gets the resDt value for this UnfvrRentalRecord.
     * 
     * @return resDt
     */
    public java.util.Calendar getResDt() {
        return resDt;
    }


    /**
     * Sets the resDt value for this UnfvrRentalRecord.
     * 
     * @param resDt
     */
    public void setResDt(java.util.Calendar resDt) {
        this.resDt = resDt;
    }


    /**
     * Gets the rntlAgrmntCloseDt value for this UnfvrRentalRecord.
     * 
     * @return rntlAgrmntCloseDt
     */
    public java.util.Calendar getRntlAgrmntCloseDt() {
        return rntlAgrmntCloseDt;
    }


    /**
     * Sets the rntlAgrmntCloseDt value for this UnfvrRentalRecord.
     * 
     * @param rntlAgrmntCloseDt
     */
    public void setRntlAgrmntCloseDt(java.util.Calendar rntlAgrmntCloseDt) {
        this.rntlAgrmntCloseDt = rntlAgrmntCloseDt;
    }


    /**
     * Gets the lastUpdUserId value for this UnfvrRentalRecord.
     * 
     * @return lastUpdUserId
     */
    public java.lang.String getLastUpdUserId() {
        return lastUpdUserId;
    }


    /**
     * Sets the lastUpdUserId value for this UnfvrRentalRecord.
     * 
     * @param lastUpdUserId
     */
    public void setLastUpdUserId(java.lang.String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }


    /**
     * Gets the lastUpdTm value for this UnfvrRentalRecord.
     * 
     * @return lastUpdTm
     */
    public java.util.Calendar getLastUpdTm() {
        return lastUpdTm;
    }


    /**
     * Sets the lastUpdTm value for this UnfvrRentalRecord.
     * 
     * @param lastUpdTm
     */
    public void setLastUpdTm(java.util.Calendar lastUpdTm) {
        this.lastUpdTm = lastUpdTm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnfvrRentalRecord)) return false;
        UnfvrRentalRecord other = (UnfvrRentalRecord) obj;
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
            ((this.locName==null && other.getLocName()==null) || 
             (this.locName!=null &&
              this.locName.equals(other.getLocName()))) &&
            this.rntlAgrmntNbr == other.getRntlAgrmntNbr() &&
            ((this.rpgmPhnAreaCd==null && other.getRpgmPhnAreaCd()==null) || 
             (this.rpgmPhnAreaCd!=null &&
              this.rpgmPhnAreaCd.equals(other.getRpgmPhnAreaCd()))) &&
            ((this.rpgmPhnLoclNbr==null && other.getRpgmPhnLoclNbr()==null) || 
             (this.rpgmPhnLoclNbr!=null &&
              this.rpgmPhnLoclNbr.equals(other.getRpgmPhnLoclNbr()))) &&
            ((this.rpgmPhnExt==null && other.getRpgmPhnExt()==null) || 
             (this.rpgmPhnExt!=null &&
              this.rpgmPhnExt.equals(other.getRpgmPhnExt()))) &&
            this.unfvrRactvyCd == other.getUnfvrRactvyCd() &&
            this.unfvrRactvyAmt == other.getUnfvrRactvyAmt() &&
            ((this.resDt==null && other.getResDt()==null) || 
             (this.resDt!=null &&
              this.resDt.equals(other.getResDt()))) &&
            ((this.rntlAgrmntCloseDt==null && other.getRntlAgrmntCloseDt()==null) || 
             (this.rntlAgrmntCloseDt!=null &&
              this.rntlAgrmntCloseDt.equals(other.getRntlAgrmntCloseDt()))) &&
            ((this.lastUpdUserId==null && other.getLastUpdUserId()==null) || 
             (this.lastUpdUserId!=null &&
              this.lastUpdUserId.equals(other.getLastUpdUserId()))) &&
            ((this.lastUpdTm==null && other.getLastUpdTm()==null) || 
             (this.lastUpdTm!=null &&
              this.lastUpdTm.equals(other.getLastUpdTm())));
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
        if (getLocName() != null) {
            _hashCode += getLocName().hashCode();
        }
        _hashCode += getRntlAgrmntNbr();
        if (getRpgmPhnAreaCd() != null) {
            _hashCode += getRpgmPhnAreaCd().hashCode();
        }
        if (getRpgmPhnLoclNbr() != null) {
            _hashCode += getRpgmPhnLoclNbr().hashCode();
        }
        if (getRpgmPhnExt() != null) {
            _hashCode += getRpgmPhnExt().hashCode();
        }
        _hashCode += getUnfvrRactvyCd();
        _hashCode += new Double(getUnfvrRactvyAmt()).hashCode();
        if (getResDt() != null) {
            _hashCode += getResDt().hashCode();
        }
        if (getRntlAgrmntCloseDt() != null) {
            _hashCode += getRntlAgrmntCloseDt().hashCode();
        }
        if (getLastUpdUserId() != null) {
            _hashCode += getLastUpdUserId().hashCode();
        }
        if (getLastUpdTm() != null) {
            _hashCode += getLastUpdTm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnfvrRentalRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "UnfvrRentalRecord"));
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
        elemField.setFieldName("locName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rntlAgrmntNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rntlAgrmntNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rpgmPhnAreaCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rpgmPhnAreaCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rpgmPhnLoclNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rpgmPhnLoclNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rpgmPhnExt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rpgmPhnExt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unfvrRactvyCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unfvrRactvyCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unfvrRactvyAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unfvrRactvyAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rntlAgrmntCloseDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rntlAgrmntCloseDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastUpdUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdTm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastUpdTm"));
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
