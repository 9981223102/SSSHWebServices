/**
 * TaxRateRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homedepot.ss.sh.webservices.lookup.taxrate;

public class TaxRateRecord  implements java.io.Serializable {
    private double freightTax;

    private double laborTax;

    private boolean PSTincGST;

    private double salesTax;

    private double useTax;

    public TaxRateRecord() {
    }

    public TaxRateRecord(
           double freightTax,
           double laborTax,
           boolean PSTincGST,
           double salesTax,
           double useTax) {
           this.freightTax = freightTax;
           this.laborTax = laborTax;
           this.PSTincGST = PSTincGST;
           this.salesTax = salesTax;
           this.useTax = useTax;
    }


    /**
     * Gets the freightTax value for this TaxRateRecord.
     * 
     * @return freightTax
     */
    public double getFreightTax() {
        return freightTax;
    }


    /**
     * Sets the freightTax value for this TaxRateRecord.
     * 
     * @param freightTax
     */
    public void setFreightTax(double freightTax) {
        this.freightTax = freightTax;
    }


    /**
     * Gets the laborTax value for this TaxRateRecord.
     * 
     * @return laborTax
     */
    public double getLaborTax() {
        return laborTax;
    }


    /**
     * Sets the laborTax value for this TaxRateRecord.
     * 
     * @param laborTax
     */
    public void setLaborTax(double laborTax) {
        this.laborTax = laborTax;
    }


    /**
     * Gets the PSTincGST value for this TaxRateRecord.
     * 
     * @return PSTincGST
     */
    public boolean isPSTincGST() {
        return PSTincGST;
    }


    /**
     * Sets the PSTincGST value for this TaxRateRecord.
     * 
     * @param PSTincGST
     */
    public void setPSTincGST(boolean PSTincGST) {
        this.PSTincGST = PSTincGST;
    }


    /**
     * Gets the salesTax value for this TaxRateRecord.
     * 
     * @return salesTax
     */
    public double getSalesTax() {
        return salesTax;
    }


    /**
     * Sets the salesTax value for this TaxRateRecord.
     * 
     * @param salesTax
     */
    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }


    /**
     * Gets the useTax value for this TaxRateRecord.
     * 
     * @return useTax
     */
    public double getUseTax() {
        return useTax;
    }


    /**
     * Sets the useTax value for this TaxRateRecord.
     * 
     * @param useTax
     */
    public void setUseTax(double useTax) {
        this.useTax = useTax;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TaxRateRecord)) return false;
        TaxRateRecord other = (TaxRateRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.freightTax == other.getFreightTax() &&
            this.laborTax == other.getLaborTax() &&
            this.PSTincGST == other.isPSTincGST() &&
            this.salesTax == other.getSalesTax() &&
            this.useTax == other.getUseTax();
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
        _hashCode += new Double(getFreightTax()).hashCode();
        _hashCode += new Double(getLaborTax()).hashCode();
        _hashCode += (isPSTincGST() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Double(getSalesTax()).hashCode();
        _hashCode += new Double(getUseTax()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TaxRateRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://taxrate.lookup.webservices.sh.ss.homedepot.com", "TaxRateRecord","p344"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("freightTax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "freightTax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("laborTax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "laborTax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PSTincGST");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PSTincGST"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesTax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salesTax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useTax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "useTax"));
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
