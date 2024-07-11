package gob.cpccs.utilidades.webService.Bsg.accesoBsgService;

public class BSG04_Acceder_BSGProxy implements gob.cpccs.utilidades.webService.Bsg.accesoBsgService.BSG04_Acceder_BSG {
  private String _endpoint = null;
  private gob.cpccs.utilidades.webService.Bsg.accesoBsgService.BSG04_Acceder_BSG bSG04_Acceder_BSG = null;
  
  public BSG04_Acceder_BSGProxy() {
    _initBSG04_Acceder_BSGProxy();
  }
  
  public BSG04_Acceder_BSGProxy(String endpoint) {
    _endpoint = endpoint;
    _initBSG04_Acceder_BSGProxy();
  }
  
  private void _initBSG04_Acceder_BSGProxy() {
    try {
      bSG04_Acceder_BSG = (new gob.cpccs.utilidades.webService.Bsg.accesoBsgService.AccesoBSGServiceLocator()).getBSG04_Acceder_BSGPort();
      if (bSG04_Acceder_BSG != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bSG04_Acceder_BSG)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bSG04_Acceder_BSG)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bSG04_Acceder_BSG != null)
      ((javax.xml.rpc.Stub)bSG04_Acceder_BSG)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gob.cpccs.utilidades.webService.Bsg.accesoBsgService.BSG04_Acceder_BSG getBSG04_Acceder_BSG() {
    if (bSG04_Acceder_BSG == null)
      _initBSG04_Acceder_BSGProxy();
    return bSG04_Acceder_BSG;
  }
  
  public gob.cpccs.utilidades.webService.Bsg.accesoBsgService.ValidarPermisoRespuesta validarPermiso(gob.cpccs.utilidades.webService.Bsg.accesoBsgService.ValidarPermisoPeticion validarPermisoPeticion) throws java.rmi.RemoteException{
    if (bSG04_Acceder_BSG == null)
      _initBSG04_Acceder_BSGProxy();
    return bSG04_Acceder_BSG.validarPermiso(validarPermisoPeticion);
  }
  
  
}