/**
 * ValidarPermisoPeticion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gob.cpccs.utilidades.webService.Bsg.accesoBsgService;

@SuppressWarnings("serial")
public class ValidarPermisoPeticion  implements java.io.Serializable {
    private java.lang.String cedula;

    private java.lang.String urlsw;

    public ValidarPermisoPeticion() {
    }

    public ValidarPermisoPeticion(
           java.lang.String cedula,
           java.lang.String urlsw) {
           this.cedula = cedula;
           this.urlsw = urlsw;
    }


    /**
     * Gets the cedula value for this ValidarPermisoPeticion.
     * 
     * @return cedula
     */
    public java.lang.String getCedula() {
        return cedula;
    }


    /**
     * Sets the cedula value for this ValidarPermisoPeticion.
     * 
     * @param cedula
     */
    public void setCedula(java.lang.String cedula) {
        this.cedula = cedula;
    }


    /**
     * Gets the urlsw value for this ValidarPermisoPeticion.
     * 
     * @return urlsw
     */
    public java.lang.String getUrlsw() {
        return urlsw;
    }


    /**
     * Sets the urlsw value for this ValidarPermisoPeticion.
     * 
     * @param urlsw
     */
    public void setUrlsw(java.lang.String urlsw) {
        this.urlsw = urlsw;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValidarPermisoPeticion)) return false;
        ValidarPermisoPeticion other = (ValidarPermisoPeticion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cedula==null && other.getCedula()==null) || 
             (this.cedula!=null &&
              this.cedula.equals(other.getCedula()))) &&
            ((this.urlsw==null && other.getUrlsw()==null) || 
             (this.urlsw!=null &&
              this.urlsw.equals(other.getUrlsw())));
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
        if (getCedula() != null) {
            _hashCode += getCedula().hashCode();
        }
        if (getUrlsw() != null) {
            _hashCode += getUrlsw().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValidarPermisoPeticion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bsg.gob.ec/AccesoBSGService", "validarPermisoPeticion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cedula");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cedula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("urlsw");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Urlsw"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
    @SuppressWarnings("rawtypes")
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
    @SuppressWarnings("rawtypes")
public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
