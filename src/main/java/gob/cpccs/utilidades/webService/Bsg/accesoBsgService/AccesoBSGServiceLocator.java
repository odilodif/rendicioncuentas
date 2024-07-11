/**
 * AccesoBSGServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gob.cpccs.utilidades.webService.Bsg.accesoBsgService;

@SuppressWarnings("serial")
public class AccesoBSGServiceLocator extends org.apache.axis.client.Service implements gob.cpccs.utilidades.webService.Bsg.accesoBsgService.AccesoBSGService {

    public AccesoBSGServiceLocator() {
    }


    public AccesoBSGServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AccesoBSGServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BSG04_Acceder_BSGPort
    private java.lang.String BSG04_Acceder_BSGPort_address = "https://www.bsg.gob.ec/sw/STI/BSGSW08_Acceder_BSG";

    public java.lang.String getBSG04_Acceder_BSGPortAddress() {
        return BSG04_Acceder_BSGPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BSG04_Acceder_BSGPortWSDDServiceName = "BSG04_Acceder_BSGPort";

    public java.lang.String getBSG04_Acceder_BSGPortWSDDServiceName() {
        return BSG04_Acceder_BSGPortWSDDServiceName;
    }

    public void setBSG04_Acceder_BSGPortWSDDServiceName(java.lang.String name) {
        BSG04_Acceder_BSGPortWSDDServiceName = name;
    }

    public gob.cpccs.utilidades.webService.Bsg.accesoBsgService.BSG04_Acceder_BSG getBSG04_Acceder_BSGPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BSG04_Acceder_BSGPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBSG04_Acceder_BSGPort(endpoint);
    }

    public gob.cpccs.utilidades.webService.Bsg.accesoBsgService.BSG04_Acceder_BSG getBSG04_Acceder_BSGPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            gob.cpccs.utilidades.webService.Bsg.accesoBsgService.AccesoBSGServiceSoapBindingStub _stub = new gob.cpccs.utilidades.webService.Bsg.accesoBsgService.AccesoBSGServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBSG04_Acceder_BSGPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBSG04_Acceder_BSGPortEndpointAddress(java.lang.String address) {
        BSG04_Acceder_BSGPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (gob.cpccs.utilidades.webService.Bsg.accesoBsgService.BSG04_Acceder_BSG.class.isAssignableFrom(serviceEndpointInterface)) {
                gob.cpccs.utilidades.webService.Bsg.accesoBsgService.AccesoBSGServiceSoapBindingStub _stub = new gob.cpccs.utilidades.webService.Bsg.accesoBsgService.AccesoBSGServiceSoapBindingStub(new java.net.URL(BSG04_Acceder_BSGPort_address), this);
                _stub.setPortName(getBSG04_Acceder_BSGPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BSG04_Acceder_BSGPort".equals(inputPortName)) {
            return getBSG04_Acceder_BSGPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bsg.gob.ec/AccesoBSGService", "AccesoBSGService");
    }

    @SuppressWarnings("rawtypes")
private java.util.HashSet ports = null;

    @SuppressWarnings({"rawtypes", "unchecked"})
public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bsg.gob.ec/AccesoBSGService", "BSG04_Acceder_BSGPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BSG04_Acceder_BSGPort".equals(portName)) {
            setBSG04_Acceder_BSGPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
