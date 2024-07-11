package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblMecanismosContolSocial;

public interface MecanismoControlSocialService {
    // Mecanismos de control social//  
    List<TblMecanismosContolSocial> obtenerRegistroControlSocial(Integer infCod);
    void guardarControlSocial(TblMecanismosContolSocial tblMecanismosContolSocial);
    TblMecanismosContolSocial ObtenerRegistroContrSocial(Integer mecCod);
	Integer ContadorMCS(Integer info_cod, String nombre);
	TblMecanismosContolSocial ObtenerRegistroContrSocialNombre(Integer info_cod, String nombre);
}
