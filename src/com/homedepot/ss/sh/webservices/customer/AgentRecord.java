/**
 * AgentRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class AgentRecord  implements java.io.Serializable,CustomerProtocol {
    private java.lang.String locTypCd;

    private java.lang.String locNbr;

    private int seqNbr;

    private java.util.Calendar crtTm;

    private short jursdTypCd;

    private short jursdLvl;

    private int jursdCd;

    private short custIdTypCd;

    private java.lang.String custIdNbr;

    private java.util.Calendar custIdExpDt;

    private java.lang.String firstNm;

    private java.lang.String middleNm;

    private java.lang.String lastNm;

    private java.lang.String suffix;

    private java.lang.String title;

    private java.lang.String actvFlg;

    private java.lang.String lastUpdUserId;

    private java.util.Calendar lastUpdTm;

    public AgentRecord() {
    }

    public AgentRecord(
           java.lang.String locTypCd,
           java.lang.String locNbr,
           int seqNbr,
           java.util.Calendar crtTm,
           short jursdTypCd,
           short jursdLvl,
           int jursdCd,
           short custIdTypCd,
           java.lang.String custIdNbr,
           java.util.Calendar custIdExpDt,
           java.lang.String firstNm,
           java.lang.String middleNm,
           java.lang.String lastNm,
           java.lang.String suffix,
           java.lang.String title,
           java.lang.String actvFlg,
           java.lang.String lastUpdUserId,
           java.util.Calendar lastUpdTm) {
           this.locTypCd = locTypCd;
           this.locNbr = locNbr;
           this.seqNbr = seqNbr;
           this.crtTm = crtTm;
           this.jursdTypCd = jursdTypCd;
           this.jursdLvl = jursdLvl;
           this.jursdCd = jursdCd;
           this.custIdTypCd = custIdTypCd;
           this.custIdNbr = custIdNbr;
           this.custIdExpDt = custIdExpDt;
           this.firstNm = firstNm;
           this.middleNm = middleNm;
           this.lastNm = lastNm;
           this.suffix = suffix;
           this.title = title;
           this.actvFlg = actvFlg;
           this.lastUpdUserId = lastUpdUserId;
           this.lastUpdTm = lastUpdTm;
    }
    // WAS2TOMCAT Changes START
	/**
	 * Constructor
	 * 
	 * @param rs		Data to create the agent record from
	 * @throws SQLException		Thrown if an exception occurs iterating the resultset
	 */
	public AgentRecord(ResultSet rs) throws SQLException
	{
		this();
		locTypCd = rs.getString(COL_LOC_TYP_CD);
		locNbr = rs.getString(COL_LOC_NBR);
		seqNbr = rs.getInt(COL_SEQ_NBR);

		/* 
		 * Time pulled from the resultset will be in the format of the timezone on the machine.
		 * Since this is the case, we will add the offset back to the time to make it GMT.
		 */
		Calendar calendar = Calendar.getInstance();
		if(rs.getTimestamp(COL_CRT_TS) != null){
			calendar.setTime(rs.getTimestamp(COL_CRT_TS));			
			int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
			calendar.add(Calendar.MILLISECOND, offset);	
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*localCrtTm = calendar.getTime();*/
			crtTm = calendar;			
		}

		
		jursdTypCd = rs.getShort(COL_JURSD_TYP_CD);
		jursdLvl = rs.getShort(COL_JURSD_LVL_CD);
		jursdCd = rs.getInt(COL_JURSD_CD);
		custIdTypCd = rs.getShort(COL_CUST_ID_TYP_CD);
		custIdNbr = rs.getString(COL_CUST_ID_NBR);
		
		//Tomcat Migration - Tcs Changes 08/12/2010
		/*localCustIdExpDt = rs.getDate(COL_CUST_ID_EXPIR_DT);*/
		if (rs.getDate(COL_CUST_ID_EXPIR_DT) != null){
			calendar.setTime(rs.getDate(COL_CUST_ID_EXPIR_DT));
			custIdExpDt=calendar;			
		}

		
   		firstNm = rs.getString(COL_FRST_NM);
		middleNm = rs.getString(COL_MID_NM);
		lastNm = rs.getString(COL_LAST_NM);
		suffix = rs.getString(COL_SFX_NM);
		title = rs.getString(COL_TTL_NM);
		actvFlg = rs.getString(COL_ACTV_FLG);
		lastUpdUserId = rs.getString(COL_LAST_UPD_USER_ID);
		
		/* 
		 * Time pulled from the resultset will be in the format of the timezone on the machine.
		 * Since this is the case, we will add the offset back to the time to make it GMT.
		 */
		calendar = Calendar.getInstance();
		if (rs.getTimestamp(COL_LAST_UPD_TS) != null){
			calendar.setTime(rs.getTimestamp(COL_LAST_UPD_TS));
			int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
			calendar.add(Calendar.MILLISECOND, offset);
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*localLastUpdTm = calendar.getTime();*/
			lastUpdTm = calendar;			
		}

		
	} // end constructor
    // WAS2TOMCAT Changes END

    /**
     * Gets the locTypCd value for this AgentRecord.
     * 
     * @return locTypCd
     */
    public java.lang.String getLocTypCd() {
        return locTypCd;
    }


    /**
     * Sets the locTypCd value for this AgentRecord.
     * 
     * @param locTypCd
     */
    public void setLocTypCd(java.lang.String locTypCd) {
        this.locTypCd = locTypCd;
    }


    /**
     * Gets the locNbr value for this AgentRecord.
     * 
     * @return locNbr
     */
    public java.lang.String getLocNbr() {
        return locNbr;
    }


    /**
     * Sets the locNbr value for this AgentRecord.
     * 
     * @param locNbr
     */
    public void setLocNbr(java.lang.String locNbr) {
        this.locNbr = locNbr;
    }


    /**
     * Gets the seqNbr value for this AgentRecord.
     * 
     * @return seqNbr
     */
    public int getSeqNbr() {
        return seqNbr;
    }


    /**
     * Sets the seqNbr value for this AgentRecord.
     * 
     * @param seqNbr
     */
    public void setSeqNbr(int seqNbr) {
        this.seqNbr = seqNbr;
    }


    /**
     * Gets the crtTm value for this AgentRecord.
     * 
     * @return crtTm
     */
    public java.util.Calendar getCrtTm() {
        return crtTm;
    }


    /**
     * Sets the crtTm value for this AgentRecord.
     * 
     * @param crtTm
     */
    public void setCrtTm(java.util.Calendar crtTm) {
        this.crtTm = crtTm;
    }


    /**
     * Gets the jursdTypCd value for this AgentRecord.
     * 
     * @return jursdTypCd
     */
    public short getJursdTypCd() {
        return jursdTypCd;
    }


    /**
     * Sets the jursdTypCd value for this AgentRecord.
     * 
     * @param jursdTypCd
     */
    public void setJursdTypCd(short jursdTypCd) {
        this.jursdTypCd = jursdTypCd;
    }


    /**
     * Gets the jursdLvl value for this AgentRecord.
     * 
     * @return jursdLvl
     */
    public short getJursdLvl() {
        return jursdLvl;
    }


    /**
     * Sets the jursdLvl value for this AgentRecord.
     * 
     * @param jursdLvl
     */
    public void setJursdLvl(short jursdLvl) {
        this.jursdLvl = jursdLvl;
    }


    /**
     * Gets the jursdCd value for this AgentRecord.
     * 
     * @return jursdCd
     */
    public int getJursdCd() {
        return jursdCd;
    }


    /**
     * Sets the jursdCd value for this AgentRecord.
     * 
     * @param jursdCd
     */
    public void setJursdCd(int jursdCd) {
        this.jursdCd = jursdCd;
    }


    /**
     * Gets the custIdTypCd value for this AgentRecord.
     * 
     * @return custIdTypCd
     */
    public short getCustIdTypCd() {
        return custIdTypCd;
    }


    /**
     * Sets the custIdTypCd value for this AgentRecord.
     * 
     * @param custIdTypCd
     */
    public void setCustIdTypCd(short custIdTypCd) {
        this.custIdTypCd = custIdTypCd;
    }


    /**
     * Gets the custIdNbr value for this AgentRecord.
     * 
     * @return custIdNbr
     */
    public java.lang.String getCustIdNbr() {
        return custIdNbr;
    }


    /**
     * Sets the custIdNbr value for this AgentRecord.
     * 
     * @param custIdNbr
     */
    public void setCustIdNbr(java.lang.String custIdNbr) {
        this.custIdNbr = custIdNbr;
    }


    /**
     * Gets the custIdExpDt value for this AgentRecord.
     * 
     * @return custIdExpDt
     */
    public java.util.Calendar getCustIdExpDt() {
        return custIdExpDt;
    }


    /**
     * Sets the custIdExpDt value for this AgentRecord.
     * 
     * @param custIdExpDt
     */
    public void setCustIdExpDt(java.util.Calendar custIdExpDt) {
        this.custIdExpDt = custIdExpDt;
    }


    /**
     * Gets the firstNm value for this AgentRecord.
     * 
     * @return firstNm
     */
    public java.lang.String getFirstNm() {
        return firstNm;
    }


    /**
     * Sets the firstNm value for this AgentRecord.
     * 
     * @param firstNm
     */
    public void setFirstNm(java.lang.String firstNm) {
        this.firstNm = firstNm;
    }


    /**
     * Gets the middleNm value for this AgentRecord.
     * 
     * @return middleNm
     */
    public java.lang.String getMiddleNm() {
        return middleNm;
    }


    /**
     * Sets the middleNm value for this AgentRecord.
     * 
     * @param middleNm
     */
    public void setMiddleNm(java.lang.String middleNm) {
        this.middleNm = middleNm;
    }


    /**
     * Gets the lastNm value for this AgentRecord.
     * 
     * @return lastNm
     */
    public java.lang.String getLastNm() {
        return lastNm;
    }


    /**
     * Sets the lastNm value for this AgentRecord.
     * 
     * @param lastNm
     */
    public void setLastNm(java.lang.String lastNm) {
        this.lastNm = lastNm;
    }


    /**
     * Gets the suffix value for this AgentRecord.
     * 
     * @return suffix
     */
    public java.lang.String getSuffix() {
        return suffix;
    }


    /**
     * Sets the suffix value for this AgentRecord.
     * 
     * @param suffix
     */
    public void setSuffix(java.lang.String suffix) {
        this.suffix = suffix;
    }


    /**
     * Gets the title value for this AgentRecord.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this AgentRecord.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the actvFlg value for this AgentRecord.
     * 
     * @return actvFlg
     */
    public java.lang.String getActvFlg() {
        return actvFlg;
    }


    /**
     * Sets the actvFlg value for this AgentRecord.
     * 
     * @param actvFlg
     */
    public void setActvFlg(java.lang.String actvFlg) {
        this.actvFlg = actvFlg;
    }


    /**
     * Gets the lastUpdUserId value for this AgentRecord.
     * 
     * @return lastUpdUserId
     */
    public java.lang.String getLastUpdUserId() {
        return lastUpdUserId;
    }


    /**
     * Sets the lastUpdUserId value for this AgentRecord.
     * 
     * @param lastUpdUserId
     */
    public void setLastUpdUserId(java.lang.String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }


    /**
     * Gets the lastUpdTm value for this AgentRecord.
     * 
     * @return lastUpdTm
     */
    public java.util.Calendar getLastUpdTm() {
        return lastUpdTm;
    }


    /**
     * Sets the lastUpdTm value for this AgentRecord.
     * 
     * @param lastUpdTm
     */
    public void setLastUpdTm(java.util.Calendar lastUpdTm) {
        this.lastUpdTm = lastUpdTm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgentRecord)) return false;
        AgentRecord other = (AgentRecord) obj;
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
            ((this.crtTm==null && other.getCrtTm()==null) || 
             (this.crtTm!=null &&
              this.crtTm.equals(other.getCrtTm()))) &&
            this.jursdTypCd == other.getJursdTypCd() &&
            this.jursdLvl == other.getJursdLvl() &&
            this.jursdCd == other.getJursdCd() &&
            this.custIdTypCd == other.getCustIdTypCd() &&
            ((this.custIdNbr==null && other.getCustIdNbr()==null) || 
             (this.custIdNbr!=null &&
              this.custIdNbr.equals(other.getCustIdNbr()))) &&
            ((this.custIdExpDt==null && other.getCustIdExpDt()==null) || 
             (this.custIdExpDt!=null &&
              this.custIdExpDt.equals(other.getCustIdExpDt()))) &&
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
            ((this.actvFlg==null && other.getActvFlg()==null) || 
             (this.actvFlg!=null &&
              this.actvFlg.equals(other.getActvFlg()))) &&
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
        _hashCode += getSeqNbr();
        if (getCrtTm() != null) {
            _hashCode += getCrtTm().hashCode();
        }
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
        if (getActvFlg() != null) {
            _hashCode += getActvFlg().hashCode();
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
        new org.apache.axis.description.TypeDesc(AgentRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AgentRecord"));
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
        elemField.setFieldName("crtTm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "crtTm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("actvFlg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actvFlg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
