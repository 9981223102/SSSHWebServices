/**
 * CustomerRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.homedepot.ss.sh.webservices.customer.interfaces.CustomerProtocol;

public class CustomerRecord  implements java.io.Serializable,CustomerProtocol {
    private int hostCustNbr;

    private int localCustNbr;

    private short custTypCd;

    private short custStatCd;

    private java.util.Calendar statEffDt;

    private short cntctMethCd;

    private short cntctAddrCd;

    private short cntctPhnCd;

    private short cntctEmailTypCd;

    private java.lang.String cntctWkBgnTm;

    private java.lang.String cntctWkEndTm;

    private java.lang.String cntctWkendBgnTm;

    private java.lang.String cntctWkendEndTm;

    private java.lang.Short emailCltCd;

    private java.util.Calendar emailCltRqstDt;

    private int seqNbr;

    private java.lang.String lastUpdUserId;

    private java.util.Calendar lastUpdTm;

    private com.homedepot.ss.sh.webservices.customer.PhoneRecord[] phoneRecords;

    private com.homedepot.ss.sh.webservices.customer.AddressRecord[] addrRecords;

    private com.homedepot.ss.sh.webservices.customer.EmailAddressRecord[] emailAddrRecords;

    private com.homedepot.ss.sh.webservices.customer.VhclInsrRecord vhclInsrRecord;

    private com.homedepot.ss.sh.webservices.customer.CustomerIdRecord[] custIdRecords;

    private com.homedepot.ss.sh.webservices.customer.RentalRecord rentalRecord;

    private com.homedepot.ss.sh.webservices.customer.ContactRecord[] cntctRecords;

    private com.homedepot.ss.sh.webservices.customer.TaxRuleRecord[] taxRuleRecords;

    private com.homedepot.ss.sh.webservices.customer.TaxblStatRecord taxblStatRecord;

    private com.homedepot.ss.sh.webservices.customer.PRODetailRecord PRODetailRecord;

    private com.homedepot.ss.sh.webservices.customer.DIYDetailRecord DIYDetailRecord;

    public CustomerRecord() {
    }

    public CustomerRecord(
           int hostCustNbr,
           int localCustNbr,
           short custTypCd,
           short custStatCd,
           java.util.Calendar statEffDt,
           short cntctMethCd,
           short cntctAddrCd,
           short cntctPhnCd,
           short cntctEmailTypCd,
           java.lang.String cntctWkBgnTm,
           java.lang.String cntctWkEndTm,
           java.lang.String cntctWkendBgnTm,
           java.lang.String cntctWkendEndTm,
           java.lang.Short emailCltCd,
           java.util.Calendar emailCltRqstDt,
           int seqNbr,
           java.lang.String lastUpdUserId,
           java.util.Calendar lastUpdTm,
           com.homedepot.ss.sh.webservices.customer.PhoneRecord[] phoneRecords,
           com.homedepot.ss.sh.webservices.customer.AddressRecord[] addrRecords,
           com.homedepot.ss.sh.webservices.customer.EmailAddressRecord[] emailAddrRecords,
           com.homedepot.ss.sh.webservices.customer.VhclInsrRecord vhclInsrRecord,
           com.homedepot.ss.sh.webservices.customer.CustomerIdRecord[] custIdRecords,
           com.homedepot.ss.sh.webservices.customer.RentalRecord rentalRecord,
           com.homedepot.ss.sh.webservices.customer.ContactRecord[] cntctRecords,
           com.homedepot.ss.sh.webservices.customer.TaxRuleRecord[] taxRuleRecords,
           com.homedepot.ss.sh.webservices.customer.TaxblStatRecord taxblStatRecord,
           com.homedepot.ss.sh.webservices.customer.PRODetailRecord PRODetailRecord,
           com.homedepot.ss.sh.webservices.customer.DIYDetailRecord DIYDetailRecord) {
           this.hostCustNbr = hostCustNbr;
           this.localCustNbr = localCustNbr;
           this.custTypCd = custTypCd;
           this.custStatCd = custStatCd;
           this.statEffDt = statEffDt;
           this.cntctMethCd = cntctMethCd;
           this.cntctAddrCd = cntctAddrCd;
           this.cntctPhnCd = cntctPhnCd;
           this.cntctEmailTypCd = cntctEmailTypCd;
           this.cntctWkBgnTm = cntctWkBgnTm;
           this.cntctWkEndTm = cntctWkEndTm;
           this.cntctWkendBgnTm = cntctWkendBgnTm;
           this.cntctWkendEndTm = cntctWkendEndTm;
           this.emailCltCd = emailCltCd;
           this.emailCltRqstDt = emailCltRqstDt;
           this.seqNbr = seqNbr;
           this.lastUpdUserId = lastUpdUserId;
           this.lastUpdTm = lastUpdTm;
           this.phoneRecords = phoneRecords;
           this.addrRecords = addrRecords;
           this.emailAddrRecords = emailAddrRecords;
           this.vhclInsrRecord = vhclInsrRecord;
           this.custIdRecords = custIdRecords;
           this.rentalRecord = rentalRecord;
           this.cntctRecords = cntctRecords;
           this.taxRuleRecords = taxRuleRecords;
           this.taxblStatRecord = taxblStatRecord;
           this.PRODetailRecord = PRODetailRecord;
           this.DIYDetailRecord = DIYDetailRecord;
    }
	/**
	 * Constructor
	 * 
	 * @param rs			Data to build the customer record using
	 * @throws SQLException		Thrown if an exception occurs iterating the resultset
	 */
	public CustomerRecord(ResultSet rs) throws SQLException
	{
		this();
		// set the header data
		hostCustNbr = rs.getInt(COL_HOST_CUST_NBR);
		localCustNbr = rs.getInt(COL_LOCAL_CUST_NBR);
		custTypCd = rs.getShort(COL_CUST_TYP_CD);
		custStatCd = rs.getShort(COL_CUST_STAT_CD);

		//Tomcat Migration - TCS changes 08/11/2010
		/*localStatEffDt = rs.getDate(COL_CUST_STAT_EFF_DT);*/

		Calendar statEffDt = Calendar.getInstance();
		if (rs.getDate(COL_CUST_STAT_EFF_DT) != null ){
			statEffDt.setTime(rs.getDate(COL_CUST_STAT_EFF_DT));
			this.statEffDt=statEffDt;
		}

		cntctMethCd = rs.getShort(COL_CNTCT_METH_CD);
		cntctAddrCd = rs.getShort(COL_CNTCT_ADDR_TYP_CD);
		cntctPhnCd = rs.getShort(COL_CNTCT_PHN_TYP_CD);
		cntctEmailTypCd = rs.getShort(COL_CNTCT_EMAIL_TYP_CD);
		cntctWkBgnTm = rs.getString(COL_CNTCT_WK_BGN_TM);
		cntctWkEndTm = rs.getString(COL_CNTCT_WK_END_TM);
		cntctWkendBgnTm = rs.getString(COL_CNTCT_WKND_BGN_TM);
		cntctWkendEndTm = rs.getString(COL_CNTCT_WKND_END_TM);

		if(rs.getObject(COL_EMAIL_CLT_CD) != null)
		{
			emailCltCd = new Short(rs.getShort(COL_EMAIL_CLT_CD));
		} // end if

		//Tomcat Migration - TCS changes 08/12/2010
		/*localEmailCltRqstDt =rs.getDate(COL_EMAIL_CLT_RQST_DT);*/		
		
		Calendar emailCltRqstDt=Calendar.getInstance();
		if (rs.getDate(COL_EMAIL_CLT_RQST_DT) != null){
			emailCltRqstDt.setTime(rs.getDate(COL_EMAIL_CLT_RQST_DT));
			this.emailCltRqstDt=emailCltRqstDt;
		}	
		
		
		lastUpdUserId = rs.getString(COL_LAST_UPD_USER_ID);
		
		/* 
		 * Time pulled from the resultset will be in the format of the timezone on the machine.
		 * Since this is the case, we will add the offset back to the time to make it GMT.
		 */
		Calendar calendar = Calendar.getInstance();
		if(rs.getTimestamp(COL_LAST_UPD_TS) != null){
			calendar.setTime(rs.getTimestamp(COL_LAST_UPD_TS));
			int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
			calendar.add(Calendar.MILLISECOND, offset);	
			
			//Tomcat Migration - Tcs Changes 08/12/2010
			/*localLastUpdTm = calendar.getTime();*/
			lastUpdTm = calendar;			
		}	

		// create customer detail record
		if (getCustTypCd() == DIY_CUST_TYP_CD)
		{
			setDIYDetailRecord(new DIYDetailRecord(rs));
		} // end if
		else
		{
			setPRODetailRecord(new PRODetailRecord(rs));
		} // end else
	} // end constructor
    

    /**
     * Gets the hostCustNbr value for this CustomerRecord.
     * 
     * @return hostCustNbr
     */
    public int getHostCustNbr() {
        return hostCustNbr;
    }


    /**
     * Sets the hostCustNbr value for this CustomerRecord.
     * 
     * @param hostCustNbr
     */
    public void setHostCustNbr(int hostCustNbr) {
        this.hostCustNbr = hostCustNbr;
    }


    /**
     * Gets the localCustNbr value for this CustomerRecord.
     * 
     * @return localCustNbr
     */
    public int getLocalCustNbr() {
        return localCustNbr;
    }


    /**
     * Sets the localCustNbr value for this CustomerRecord.
     * 
     * @param localCustNbr
     */
    public void setLocalCustNbr(int localCustNbr) {
        this.localCustNbr = localCustNbr;
    }


    /**
     * Gets the custTypCd value for this CustomerRecord.
     * 
     * @return custTypCd
     */
    public short getCustTypCd() {
        return custTypCd;
    }


    /**
     * Sets the custTypCd value for this CustomerRecord.
     * 
     * @param custTypCd
     */
    public void setCustTypCd(short custTypCd) {
        this.custTypCd = custTypCd;
    }


    /**
     * Gets the custStatCd value for this CustomerRecord.
     * 
     * @return custStatCd
     */
    public short getCustStatCd() {
        return custStatCd;
    }


    /**
     * Sets the custStatCd value for this CustomerRecord.
     * 
     * @param custStatCd
     */
    public void setCustStatCd(short custStatCd) {
        this.custStatCd = custStatCd;
    }


    /**
     * Gets the statEffDt value for this CustomerRecord.
     * 
     * @return statEffDt
     */
    public java.util.Calendar getStatEffDt() {
        return statEffDt;
    }


    /**
     * Sets the statEffDt value for this CustomerRecord.
     * 
     * @param statEffDt
     */
    public void setStatEffDt(java.util.Calendar statEffDt) {
        this.statEffDt = statEffDt;
    }


    /**
     * Gets the cntctMethCd value for this CustomerRecord.
     * 
     * @return cntctMethCd
     */
    public short getCntctMethCd() {
        return cntctMethCd;
    }


    /**
     * Sets the cntctMethCd value for this CustomerRecord.
     * 
     * @param cntctMethCd
     */
    public void setCntctMethCd(short cntctMethCd) {
        this.cntctMethCd = cntctMethCd;
    }


    /**
     * Gets the cntctAddrCd value for this CustomerRecord.
     * 
     * @return cntctAddrCd
     */
    public short getCntctAddrCd() {
        return cntctAddrCd;
    }


    /**
     * Sets the cntctAddrCd value for this CustomerRecord.
     * 
     * @param cntctAddrCd
     */
    public void setCntctAddrCd(short cntctAddrCd) {
        this.cntctAddrCd = cntctAddrCd;
    }


    /**
     * Gets the cntctPhnCd value for this CustomerRecord.
     * 
     * @return cntctPhnCd
     */
    public short getCntctPhnCd() {
        return cntctPhnCd;
    }


    /**
     * Sets the cntctPhnCd value for this CustomerRecord.
     * 
     * @param cntctPhnCd
     */
    public void setCntctPhnCd(short cntctPhnCd) {
        this.cntctPhnCd = cntctPhnCd;
    }


    /**
     * Gets the cntctEmailTypCd value for this CustomerRecord.
     * 
     * @return cntctEmailTypCd
     */
    public short getCntctEmailTypCd() {
        return cntctEmailTypCd;
    }


    /**
     * Sets the cntctEmailTypCd value for this CustomerRecord.
     * 
     * @param cntctEmailTypCd
     */
    public void setCntctEmailTypCd(short cntctEmailTypCd) {
        this.cntctEmailTypCd = cntctEmailTypCd;
    }


    /**
     * Gets the cntctWkBgnTm value for this CustomerRecord.
     * 
     * @return cntctWkBgnTm
     */
    public java.lang.String getCntctWkBgnTm() {
        return cntctWkBgnTm;
    }


    /**
     * Sets the cntctWkBgnTm value for this CustomerRecord.
     * 
     * @param cntctWkBgnTm
     */
    public void setCntctWkBgnTm(java.lang.String cntctWkBgnTm) {
        this.cntctWkBgnTm = cntctWkBgnTm;
    }


    /**
     * Gets the cntctWkEndTm value for this CustomerRecord.
     * 
     * @return cntctWkEndTm
     */
    public java.lang.String getCntctWkEndTm() {
        return cntctWkEndTm;
    }


    /**
     * Sets the cntctWkEndTm value for this CustomerRecord.
     * 
     * @param cntctWkEndTm
     */
    public void setCntctWkEndTm(java.lang.String cntctWkEndTm) {
        this.cntctWkEndTm = cntctWkEndTm;
    }


    /**
     * Gets the cntctWkendBgnTm value for this CustomerRecord.
     * 
     * @return cntctWkendBgnTm
     */
    public java.lang.String getCntctWkendBgnTm() {
        return cntctWkendBgnTm;
    }


    /**
     * Sets the cntctWkendBgnTm value for this CustomerRecord.
     * 
     * @param cntctWkendBgnTm
     */
    public void setCntctWkendBgnTm(java.lang.String cntctWkendBgnTm) {
        this.cntctWkendBgnTm = cntctWkendBgnTm;
    }


    /**
     * Gets the cntctWkendEndTm value for this CustomerRecord.
     * 
     * @return cntctWkendEndTm
     */
    public java.lang.String getCntctWkendEndTm() {
        return cntctWkendEndTm;
    }


    /**
     * Sets the cntctWkendEndTm value for this CustomerRecord.
     * 
     * @param cntctWkendEndTm
     */
    public void setCntctWkendEndTm(java.lang.String cntctWkendEndTm) {
        this.cntctWkendEndTm = cntctWkendEndTm;
    }


    /**
     * Gets the emailCltCd value for this CustomerRecord.
     * 
     * @return emailCltCd
     */
    public java.lang.Short getEmailCltCd() {
        return emailCltCd;
    }


    /**
     * Sets the emailCltCd value for this CustomerRecord.
     * 
     * @param emailCltCd
     */
    public void setEmailCltCd(java.lang.Short emailCltCd) {
        this.emailCltCd = emailCltCd;
    }


    /**
     * Gets the emailCltRqstDt value for this CustomerRecord.
     * 
     * @return emailCltRqstDt
     */
    public java.util.Calendar getEmailCltRqstDt() {
        return emailCltRqstDt;
    }


    /**
     * Sets the emailCltRqstDt value for this CustomerRecord.
     * 
     * @param emailCltRqstDt
     */
    public void setEmailCltRqstDt(java.util.Calendar emailCltRqstDt) {
        this.emailCltRqstDt = emailCltRqstDt;
    }


    /**
     * Gets the seqNbr value for this CustomerRecord.
     * 
     * @return seqNbr
     */
    public int getSeqNbr() {
        return seqNbr;
    }


    /**
     * Sets the seqNbr value for this CustomerRecord.
     * 
     * @param seqNbr
     */
    public void setSeqNbr(int seqNbr) {
        this.seqNbr = seqNbr;
    }


    /**
     * Gets the lastUpdUserId value for this CustomerRecord.
     * 
     * @return lastUpdUserId
     */
    public java.lang.String getLastUpdUserId() {
        return lastUpdUserId;
    }


    /**
     * Sets the lastUpdUserId value for this CustomerRecord.
     * 
     * @param lastUpdUserId
     */
    public void setLastUpdUserId(java.lang.String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }


    /**
     * Gets the lastUpdTm value for this CustomerRecord.
     * 
     * @return lastUpdTm
     */
    public java.util.Calendar getLastUpdTm() {
        return lastUpdTm;
    }


    /**
     * Sets the lastUpdTm value for this CustomerRecord.
     * 
     * @param lastUpdTm
     */
    public void setLastUpdTm(java.util.Calendar lastUpdTm) {
        this.lastUpdTm = lastUpdTm;
    }


    /**
     * Gets the phoneRecords value for this CustomerRecord.
     * 
     * @return phoneRecords
     */
    public com.homedepot.ss.sh.webservices.customer.PhoneRecord[] getPhoneRecords() {
        return phoneRecords;
    }


    /**
     * Sets the phoneRecords value for this CustomerRecord.
     * 
     * @param phoneRecords
     */
    public void setPhoneRecords(com.homedepot.ss.sh.webservices.customer.PhoneRecord[] phoneRecords) {
        this.phoneRecords = phoneRecords;
    }


    /**
     * Gets the addrRecords value for this CustomerRecord.
     * 
     * @return addrRecords
     */
    public com.homedepot.ss.sh.webservices.customer.AddressRecord[] getAddrRecords() {
        return addrRecords;
    }


    /**
     * Sets the addrRecords value for this CustomerRecord.
     * 
     * @param addrRecords
     */
    public void setAddrRecords(com.homedepot.ss.sh.webservices.customer.AddressRecord[] addrRecords) {
        this.addrRecords = addrRecords;
    }


    /**
     * Gets the emailAddrRecords value for this CustomerRecord.
     * 
     * @return emailAddrRecords
     */
    public com.homedepot.ss.sh.webservices.customer.EmailAddressRecord[] getEmailAddrRecords() {
        return emailAddrRecords;
    }


    /**
     * Sets the emailAddrRecords value for this CustomerRecord.
     * 
     * @param emailAddrRecords
     */
    public void setEmailAddrRecords(com.homedepot.ss.sh.webservices.customer.EmailAddressRecord[] emailAddrRecords) {
        this.emailAddrRecords = emailAddrRecords;
    }


    /**
     * Gets the vhclInsrRecord value for this CustomerRecord.
     * 
     * @return vhclInsrRecord
     */
    public com.homedepot.ss.sh.webservices.customer.VhclInsrRecord getVhclInsrRecord() {
        return vhclInsrRecord;
    }


    /**
     * Sets the vhclInsrRecord value for this CustomerRecord.
     * 
     * @param vhclInsrRecord
     */
    public void setVhclInsrRecord(com.homedepot.ss.sh.webservices.customer.VhclInsrRecord vhclInsrRecord) {
        this.vhclInsrRecord = vhclInsrRecord;
    }


    /**
     * Gets the custIdRecords value for this CustomerRecord.
     * 
     * @return custIdRecords
     */
    public com.homedepot.ss.sh.webservices.customer.CustomerIdRecord[] getCustIdRecords() {
        return custIdRecords;
    }


    /**
     * Sets the custIdRecords value for this CustomerRecord.
     * 
     * @param custIdRecords
     */
    public void setCustIdRecords(com.homedepot.ss.sh.webservices.customer.CustomerIdRecord[] custIdRecords) {
        this.custIdRecords = custIdRecords;
    }


    /**
     * Gets the rentalRecord value for this CustomerRecord.
     * 
     * @return rentalRecord
     */
    public com.homedepot.ss.sh.webservices.customer.RentalRecord getRentalRecord() {
        return rentalRecord;
    }


    /**
     * Sets the rentalRecord value for this CustomerRecord.
     * 
     * @param rentalRecord
     */
    public void setRentalRecord(com.homedepot.ss.sh.webservices.customer.RentalRecord rentalRecord) {
        this.rentalRecord = rentalRecord;
    }


    /**
     * Gets the cntctRecords value for this CustomerRecord.
     * 
     * @return cntctRecords
     */
    public com.homedepot.ss.sh.webservices.customer.ContactRecord[] getCntctRecords() {
        return cntctRecords;
    }


    /**
     * Sets the cntctRecords value for this CustomerRecord.
     * 
     * @param cntctRecords
     */
    public void setCntctRecords(com.homedepot.ss.sh.webservices.customer.ContactRecord[] cntctRecords) {
        this.cntctRecords = cntctRecords;
    }


    /**
     * Gets the taxRuleRecords value for this CustomerRecord.
     * 
     * @return taxRuleRecords
     */
    public com.homedepot.ss.sh.webservices.customer.TaxRuleRecord[] getTaxRuleRecords() {
        return taxRuleRecords;
    }


    /**
     * Sets the taxRuleRecords value for this CustomerRecord.
     * 
     * @param taxRuleRecords
     */
    public void setTaxRuleRecords(com.homedepot.ss.sh.webservices.customer.TaxRuleRecord[] taxRuleRecords) {
        this.taxRuleRecords = taxRuleRecords;
    }


    /**
     * Gets the taxblStatRecord value for this CustomerRecord.
     * 
     * @return taxblStatRecord
     */
    public com.homedepot.ss.sh.webservices.customer.TaxblStatRecord getTaxblStatRecord() {
        return taxblStatRecord;
    }


    /**
     * Sets the taxblStatRecord value for this CustomerRecord.
     * 
     * @param taxblStatRecord
     */
    public void setTaxblStatRecord(com.homedepot.ss.sh.webservices.customer.TaxblStatRecord taxblStatRecord) {
        this.taxblStatRecord = taxblStatRecord;
    }


    /**
     * Gets the PRODetailRecord value for this CustomerRecord.
     * 
     * @return PRODetailRecord
     */
    public com.homedepot.ss.sh.webservices.customer.PRODetailRecord getPRODetailRecord() {
        return PRODetailRecord;
    }


    /**
     * Sets the PRODetailRecord value for this CustomerRecord.
     * 
     * @param PRODetailRecord
     */
    public void setPRODetailRecord(com.homedepot.ss.sh.webservices.customer.PRODetailRecord PRODetailRecord) {
        this.PRODetailRecord = PRODetailRecord;
    }


    /**
     * Gets the DIYDetailRecord value for this CustomerRecord.
     * 
     * @return DIYDetailRecord
     */
    public com.homedepot.ss.sh.webservices.customer.DIYDetailRecord getDIYDetailRecord() {
        return DIYDetailRecord;
    }


    /**
     * Sets the DIYDetailRecord value for this CustomerRecord.
     * 
     * @param DIYDetailRecord
     */
    public void setDIYDetailRecord(com.homedepot.ss.sh.webservices.customer.DIYDetailRecord DIYDetailRecord) {
        this.DIYDetailRecord = DIYDetailRecord;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerRecord)) return false;
        CustomerRecord other = (CustomerRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.hostCustNbr == other.getHostCustNbr() &&
            this.localCustNbr == other.getLocalCustNbr() &&
            this.custTypCd == other.getCustTypCd() &&
            this.custStatCd == other.getCustStatCd() &&
            ((this.statEffDt==null && other.getStatEffDt()==null) || 
             (this.statEffDt!=null &&
              this.statEffDt.equals(other.getStatEffDt()))) &&
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
            ((this.emailCltCd==null && other.getEmailCltCd()==null) || 
             (this.emailCltCd!=null &&
              this.emailCltCd.equals(other.getEmailCltCd()))) &&
            ((this.emailCltRqstDt==null && other.getEmailCltRqstDt()==null) || 
             (this.emailCltRqstDt!=null &&
              this.emailCltRqstDt.equals(other.getEmailCltRqstDt()))) &&
            this.seqNbr == other.getSeqNbr() &&
            ((this.lastUpdUserId==null && other.getLastUpdUserId()==null) || 
             (this.lastUpdUserId!=null &&
              this.lastUpdUserId.equals(other.getLastUpdUserId()))) &&
            ((this.lastUpdTm==null && other.getLastUpdTm()==null) || 
             (this.lastUpdTm!=null &&
              this.lastUpdTm.equals(other.getLastUpdTm()))) &&
            ((this.phoneRecords==null && other.getPhoneRecords()==null) || 
             (this.phoneRecords!=null &&
              java.util.Arrays.equals(this.phoneRecords, other.getPhoneRecords()))) &&
            ((this.addrRecords==null && other.getAddrRecords()==null) || 
             (this.addrRecords!=null &&
              java.util.Arrays.equals(this.addrRecords, other.getAddrRecords()))) &&
            ((this.emailAddrRecords==null && other.getEmailAddrRecords()==null) || 
             (this.emailAddrRecords!=null &&
              java.util.Arrays.equals(this.emailAddrRecords, other.getEmailAddrRecords()))) &&
            ((this.vhclInsrRecord==null && other.getVhclInsrRecord()==null) || 
             (this.vhclInsrRecord!=null &&
              this.vhclInsrRecord.equals(other.getVhclInsrRecord()))) &&
            ((this.custIdRecords==null && other.getCustIdRecords()==null) || 
             (this.custIdRecords!=null &&
              java.util.Arrays.equals(this.custIdRecords, other.getCustIdRecords()))) &&
            ((this.rentalRecord==null && other.getRentalRecord()==null) || 
             (this.rentalRecord!=null &&
              this.rentalRecord.equals(other.getRentalRecord()))) &&
            ((this.cntctRecords==null && other.getCntctRecords()==null) || 
             (this.cntctRecords!=null &&
              java.util.Arrays.equals(this.cntctRecords, other.getCntctRecords()))) &&
            ((this.taxRuleRecords==null && other.getTaxRuleRecords()==null) || 
             (this.taxRuleRecords!=null &&
              java.util.Arrays.equals(this.taxRuleRecords, other.getTaxRuleRecords()))) &&
            ((this.taxblStatRecord==null && other.getTaxblStatRecord()==null) || 
             (this.taxblStatRecord!=null &&
              this.taxblStatRecord.equals(other.getTaxblStatRecord()))) &&
            ((this.PRODetailRecord==null && other.getPRODetailRecord()==null) || 
             (this.PRODetailRecord!=null &&
              this.PRODetailRecord.equals(other.getPRODetailRecord()))) &&
            ((this.DIYDetailRecord==null && other.getDIYDetailRecord()==null) || 
             (this.DIYDetailRecord!=null &&
              this.DIYDetailRecord.equals(other.getDIYDetailRecord())));
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
        _hashCode += getLocalCustNbr();
        _hashCode += getCustTypCd();
        _hashCode += getCustStatCd();
        if (getStatEffDt() != null) {
            _hashCode += getStatEffDt().hashCode();
        }
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
        if (getEmailCltCd() != null) {
            _hashCode += getEmailCltCd().hashCode();
        }
        if (getEmailCltRqstDt() != null) {
            _hashCode += getEmailCltRqstDt().hashCode();
        }
        _hashCode += getSeqNbr();
        if (getLastUpdUserId() != null) {
            _hashCode += getLastUpdUserId().hashCode();
        }
        if (getLastUpdTm() != null) {
            _hashCode += getLastUpdTm().hashCode();
        }
        if (getPhoneRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPhoneRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPhoneRecords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAddrRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAddrRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAddrRecords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEmailAddrRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEmailAddrRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEmailAddrRecords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVhclInsrRecord() != null) {
            _hashCode += getVhclInsrRecord().hashCode();
        }
        if (getCustIdRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustIdRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustIdRecords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRentalRecord() != null) {
            _hashCode += getRentalRecord().hashCode();
        }
        if (getCntctRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCntctRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCntctRecords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTaxRuleRecords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTaxRuleRecords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTaxRuleRecords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTaxblStatRecord() != null) {
            _hashCode += getTaxblStatRecord().hashCode();
        }
        if (getPRODetailRecord() != null) {
            _hashCode += getPRODetailRecord().hashCode();
        }
        if (getDIYDetailRecord() != null) {
            _hashCode += getDIYDetailRecord().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostCustNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hostCustNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localCustNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "localCustNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custTypCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custTypCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custStatCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custStatCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statEffDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statEffDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
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
        elemField.setFieldName("emailCltCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailCltCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailCltRqstDt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailCltRqstDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seqNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seqNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "PhoneRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "PhoneRecord"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addrRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addrRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "AddressRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "AddressRecord"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddrRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailAddrRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "EmailAddressRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "EmailAddressRecord"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vhclInsrRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vhclInsrRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "VhclInsrRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custIdRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "custIdRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "CustomerIdRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "CustomerIdRecord"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rentalRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rentalRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "RentalRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cntctRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cntctRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "ContactRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "ContactRecord"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxRuleRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxRuleRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "TaxRuleRecord"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "TaxRuleRecord"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxblStatRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxblStatRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "TaxblStatRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PRODetailRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PRODetailRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "PRODetailRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DIYDetailRecord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DIYDetailRecord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://customer.webservices.sh.ss.homedepot.com", "DIYDetailRecord"));
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
