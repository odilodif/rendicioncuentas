/**
 * MensajeError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gob.cpccs.utilidades.webService.Bsg.accesoBsgService;

@SuppressWarnings("serial")
public class MensajeError  implements java.io.Serializable {
    private java.lang.String codError;

    private java.lang.String desError;

    public MensajeError() {
    }

    public MensajeError(
           java.lang.String codError,
           java.lang.String desError) {
           this.codError = codError;
           this.desError = desError;
    }


    /**
     * Gets the codError value for this MensajeError.
     * 
     * @return codError
     */
    public java.lang.String getCodError() {
        return codError;
    }


    /**
     * Sets the codError value for this MensajeError.
     * 
     * @param codError
     */
    public void setCodError(java.lang.String codError) {
        this.codError = codError;
    }


    /**
     * Gets the desError value for this MensajeError.
     * 
     * @return desError
     */
    public java.lang.String getDesError() {
        return desError;
    }


    /**
     * Sets the desError value for this MensajeError.
     * 
     * @param desError
     */
    public void setDesError(java.lang.String desError) {
        this.desError = desError;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MensajeError)) return false;
        MensajeError other = (MensajeError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codError==null && other.getCodError()==null) || 
             (this.codError!=null &&
              this.codError.equals(other.getCodError()))) &&
            ((this.desError==null && other.getDesError()==null) || 
             (this.desError!=null &&
              this.desError.equals(other.getDesError())));
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
        if (getCodError() != null) {
            _hashCode += getCodError().hashCode();
        }
        if (getDesError() != null) {
            _hashCode += getDesError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MensajeError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bsg.gob.ec/AccesoBSGService", "mensajeError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CodError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DesError"));
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
