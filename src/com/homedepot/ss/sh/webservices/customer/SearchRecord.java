/**
 * SearchRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class SearchRecord  implements java.io.Serializable,CustomerProtocol {
    private int hostCustNbr;

    private int loclCustNbr;

    private short phnNbrTypCd;

    private java.lang.String phnAreaCityCd;

    private java.lang.String phnLoclNbr;

    private java.lang.String firstNm;

    private java.lang.String lastNm;

    private java.lang.String orgNm;

    private java.lang.String addrLn1Txt;

    private java.lang.String cityNm;

    private java.lang.String stCd;

    private java.lang.String pstlCd;

    private int seqNbr;

    private short custStatCd;

    private java.util.Calendar lastUpdTm;

    public SearchRecord() {
    }

    public SearchRecord(
           int hostCustNbr,
           int loclCustNbr,
           short phnNbrTypCd,
           java.lang.String phnAreaCityCd,
           java.lang.String phnLoclNbr,
           java.lang.String firstNm,
           java.lang.String lastNm,
           java.lang.String orgNm,
           java.lang.String addrLn1Txt,
           java.lang.String cityNm,
           java.lang.String stCd,
           java.lang.String pstlCd,
           int seqNbr,
           short custStatCd,
           java.util.Calendar lastUpdTm) {
           this.hostCustNbr = hostCustNbr;
           this.loclCustNbr = loclCustNbr;
           this.phnNbrTypCd = phnNbrTypCd;
           this.phnAreaCityCd = phnAreaCityCd;
           this.phnLoclNbr = phnLoclNbr;
           this.firstNm = firstNm;
           this.lastNm = lastNm;
           this.orgNm = orgNm;
           this.addrLn1Txt = addrLn1Txt;
           this.cityNm = cityNm;
           this.stCd = stCd;
           this.pstlCd = pstlCd;
           this.seqNbr = seqNbr;
           this.custStatCd = custStatCd;
           this.lastUpdTm = lastUpdTm;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs				Data to populate search record with
	 * @throws SQLException		Thrown if an exception occurs iterating the resultset
	 */
	public SearchRecord(ResultSet rs) throws SQLException
	{
		this();
		hostCustNbr = rs.getInt(COL_HOST_CUST_NBR);
		loclCustNbr = rs.getInt(COL_LOCAL_CUST_NBR);
		firstNm = rs.getString(COL_FRST_NM);
		lastNm = rs.getString(COL_LAST_NM);
		orgNm = rs.getString(COL_ORG_CUST_NM);
		phnNbrTypCd = rs.getShort(COL_PHN_NBR_TYP_CD);
		phnAreaCityCd = rs.getString(COL_PHN_AREA_CITY_CD);
		phnLoclNbr = rs.getString(COL_PHN_LOCAL_NBR);
		addrLn1Txt = rs.getString(COL_ADDR_LINE1_TXT);
		cityNm = rs.getString(COL_CITY_NM);
		stCd = rs.getString(COL_ST_CD);
		pstlCd = rs.getString(COL_PSTL_CD);
		
		/* 
		 * Time pulled from the resultset will be in the format of the timezone on the machine.
		 * Since this is the case, we will add the offset back to the time to make it GMT.
		 */
		if(rs.getTimestamp(COL_LAST_UPD_TS) != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rs.getTimestamp(COL_LAST_UPD_TS));
			int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
			calendar.add(Calendar.MILLISECOND, offset);
			lastUpdTm = calendar;			
		}
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*localLastUpdTm = calendar.getTime();*/


		seqNbr = rs.getInt(COL_SEQ_NBR);
		custStatCd = rs.getShort(COL_CUST_STAT_CD);
	} // end constructor
    // WAS2TOMCAT Changes END

    /**
     * Gets the hostCustNbr value for this SearchRecord.
     * 
     * @return hostCustNbr
     */
    public int getHostCustNbr() {
        return hostCustNbr;
    }


    /**
     * Sets the hostCustNbr value for this SearchRecord.
     * 
     * @param hostCustNbr
     */
    public void setHostCustNbr(int hostCustNbr) {
        this.hostCustNbr = hostCustNbr;
    }


    /**
     * Gets the loclCustNbr value for this SearchRecord.
     * 
     * @return loclCustNbr
     */
    public int getLoclCustNbr() {
        return loclCustNbr;
    }


    /**
     * Sets the loclCustNbr value for this SearchRecord.
     * 
     * @param loclCustNbr
     */
    public void setLoclCustNbr(int loclCustNbr) {
        this.loclCustNbr = loclCustNbr;
    }


    /**
     * Gets the phnNbrTypCd value for this SearchRecord.
     * 
     * @return phnNbrTypCd
     */
    public short getPhnNbrTypCd() {
        return phnNbrTypCd;
    }


    /**
     * Sets the phnNbrTypCd value for this SearchRecord.
     * 
     * @param phnNbrTypCd
     */
    public void setPhnNbrTypCd(short phnNbrTypCd) {
        this.phnNbrTypCd = phnNbrTypCd;
    }


    /**
     * Gets the phnAreaCityCd value for this SearchRecord.
     * 
     * @return phnAreaCityCd
     */
    public java.lang.String getPhnAreaCityCd() {
        return phnAreaCityCd;
    }


    /**
     * Sets the phnAreaCityCd value for this SearchRecord.
     * 
     * @param phnAreaCityCd
     */
    public void setPhnAreaCityCd(java.lang.String phnAreaCityCd) {
        this.phnAreaCityCd = phnAreaCityCd;
    }


    /**
     * Gets the phnLoclNbr value for this SearchRecord.
     * 
     * @return phnLoclNbr
     */
    public java.lang.String getPhnLoclNbr() {
        return phnLoclNbr;
    }


    /**
     * Sets the phnLoclNbr value for this SearchRecord.
     * 
     * @param phnLoclNbr
     */
    public void setPhnLoclNbr(java.lang.String phnLoclNbr) {
        this.phnLoclNbr = phnLoclNbr;
    }


    /**
     * Gets the firstNm value for this SearchRecord.
     * 
     * @return firstNm
     */
    public java.lang.String getFirstNm() {
        return firstNm;
    }


    /**
     * Sets the firstNm value for this SearchRecord.
     * 
     * @param firstNm
     */
    public void setFirstNm(java.lang.String firstNm) {
        this.firstNm = firstNm;
    }


    /**
     * Gets the lastNm value for this SearchRecord.
     * 
     * @return lastNm
     */
    public java.lang.String getLastNm() {
        return lastNm;
    }


    /**
     * Sets the lastNm value for this SearchRecord.
     * 
     * @param lastNm
     */
    public void setLastNm(java.lang.String lastNm) {
        this.lastNm = lastNm;
    }


    /**
     * Gets the orgNm value for this SearchRecord.
     * 
     * @return orgNm
     */
    public java.lang.String getOrgNm() {
        return orgNm;
    }


    /**
     * Sets the orgNm value for this SearchRecord.
     * 
     * @param orgNm
     */
    public void setOrgNm(java.lang.String orgNm) {
        this.orgNm = orgNm;
    }


    /**
     * Gets the addrLn1Txt value for this SearchRecord.
     * 
     * @return addrLn1Txt
     */
    public java.lang.String getAddrLn1Txt() {
        return addrLn1Txt;
    }


    /**
     * Sets the addrLn1Txt value for this SearchRecord.
     * 
     * @param addrLn1Txt
     */
    public void setAddrLn1Txt(java.lang.String addrLn1Txt) {
        this.addrLn1Txt = addrLn1Txt;
    }


    /**
     * Gets the cityNm value for this SearchRecord.
     * 
     * @return cityNm
     */
    public java.lang.String getCityNm() {
        return cityNm;
    }


    /**
     * Sets the cityNm value for this SearchRecord.
     * 
     * @param cityNm
     */
    public void setCityNm(java.lang.String cityNm) {
        this.cityNm = cityNm;
    }


    /**
     * Gets the stCd value for this SearchRecord.
     * 
     * @return stCd
     */
    public java.lang.String getStCd() {
        return stCd;
    }


    /**
     * Sets the stCd value for this SearchRecord.
     * 
     * @param stCd
     */
    public void setStCd(java.lang.String stCd) {
        this.stCd = stCd;
    }


    /**
     * Gets the pstlCd value for this SearchRecord.
     * 
     * @return pstlCd
     */
    public java.lang.String getPstlCd() {
        return pstlCd;
    }


    /**
     * Sets the pstlCd value for this SearchRecord.
     * 
     * @param pstlCd
     */
    public void setPstlCd(java.lang.String pstlCd) {
        this.pstlCd = pstlCd;
    }


    /**
     * Gets the seqNbr value for this SearchRecord.
     * 
     * @return seqNbr
     */
    public int getSeqNbr() {
        return seqNbr;
    }


    /**
     * Sets the seqNbr value for this SearchRecord.
     * 
     * @param seqNbr
     */
    public void setSeqNbr(int seqNbr) {
        this.seqNbr = seqNbr;
    }


    /**
     * Gets the custStatCd value for this SearchRecord.
     * 
     * @return custStatCd
     */
    public short getCustStatCd() {
        return custStatCd;
    }


    /**
     * Sets the custStatCd value for this SearchRecord.
     * 
     * @param custStatCd
     */
    public void setCustStatCd(short custStatCd) {
        this.custStatCd = custStatCd;
    }


    /**
     * Gets the lastUpdTm value for this SearchRecord.
     * 
     * @return lastUpdTm
     */
    public java.util.Calendar getLastUpdTm() {
        return lastUpdTm;
    }


    /**
     * Sets the lastUpdTm value for this SearchRecord.
     * 
     * @param lastUpdTm
     */
    public void setLastUpdTm(java.util.Calendar lastUpdTm) {
        this.lastUpdTm = lastUpdTm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchRecord)) return false;
        SearchRecord other = (SearchRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.hostCustNbr == other.getHostCustNbr() &&
            this.loclCustNbr == other.getLoclCustNbr() &&
            this.phnNbrTypCd == other.getPhnNbrTypCd() &&
            ((this.phnAreaCityCd==null && other.getPhnAreaCityCd()==null) || 
             (this.phnAreaCityCd!=null &&
              this.phnAreaCityCd.equals(other.getPhnAreaCityCd()))) &&
            ((this.phnLoclNbr==null && other.getPhnLoclNbr()==null) || 
             (this.phnLoclNbr!=null &&
              this.phnLoclNbr.equals(other.getPhnLoclNbr()))) &&
            ((this.firstNm==null && other.getFirstNm()==null) || 
             (this.firstNm!=null &&
              this.firstNm.equals(other.getFirstNm()))) &&
            ((this.lastNm==null && other.getLastNm()==null) || 
             (this.lastNm!=null &&
              this.lastNm.equals(other.getLastNm()))) &&
            ((this.orgNm==null && other.getOrgNm()==null) || 
             (this.orgNm!=null &&
              this.orgNm.equals(other.getOrgNm()))) &&
            ((this.addrLn1Txt==null && other.getAddrLn1Txt()==null) || 
             (this.addrLn1Txt!=null &&
              this.addrLn1Txt.equals(other.getAddrLn1Txt()))) &&
            ((this.cityNm==null && other.getCityNm()==null) || 
             (this.cityNm!=null &&
              this.cityNm.equals(other.getCityNm()))) &&
            ((this.stCd==null && other.getStCd()==null) || 
             (this.stCd!=null &&
              this.stCd.equals(other.getStCd()))) &&
            ((this.pstlCd==null && other.getPstlCd()==null) || 
             (this.pstlCd!=null &&
              this.pstlCd.equals(other.getPstlCd()))) &&
            this.seqNbr == other.getSeqNbr() &&
            this.custStatCd == other.getCustStatCd() &&
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
        _hashCode += getHostCustNbr();
        _hashCode += getLoclCustNbr();
        _hashCode += getPhnNbrTypCd();
        if (getPhnAreaCityCd() != null) {
            _hashCode += getPhnAreaCityCd().hashCode();
        }
        if (getPhnLoclNbr() != null) {
            _hashCode += getPhnLoclNbr().hashCode();
        }
        if (getFirstNm() != null) {
            _hashCode += getFirstNm().hashCode();
        }
        if (getLastNm() != null) {
            _hashCode += getLastNm().hashCode();
        }
        if (getOrgNm() != null) {
            _hashCode += getOrgNm().hashCode();
        }
        if (getAddrLn1Txt() != null) {
            _hashCode += getAddrLn1Txt().hashCode();
        }
        if (getCityNm() != null) {
            _hashCode += getCityNm().hashCode();
        }
        if (getStCd() != null) {
            _hashCode += getStCd().hashCode();
        }
        if (getPstlCd() != null) {
            _hashCode += getPstlCd().hashCode();
        }
        _hashCode += getSeqNbr();
        _hashCode += getCustStatCd();
        if (getLastUpdTm() != null) {
            _hashCode += getLastUpdTm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "SearchRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostCustNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hostCustNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loclCustNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loclCustNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("firstNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstNm"));
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
        elemField.setFieldName("orgNm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "orgNm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrLn1Txt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrLn1Txt"));
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
        elemField.setFieldName("seqNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seqNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custStatCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custStatCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
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
