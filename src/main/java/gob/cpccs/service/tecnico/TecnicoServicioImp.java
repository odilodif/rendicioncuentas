package gob.cpccs.service.tecnico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.funcionarios.TblDatosFuncionarios;
import gob.cpccs.model.usuario.TblUsuarioLocalizacion;
import gob.cpccs.repository.registroUsuarioInterno.*;
import gob.cpccs.repository.tecnico.UsuarioLocalizacionRepository;

@Service
public class TecnicoServicioImp implements TecnicoServicio{
    @Autowired 
    private UsuarioLocalizacionRepository uservicio;
    
    @Autowired
    private UsuarioInternoRepository UsuarioInternoRepository;
    
	@Override
    public List<TblUsuarioLocalizacion> obtenerLocalizacionXtecnico(String identificador, int periodo,int rolCod) {
         return uservicio.findByIdentificadorAndPeriodoAndRolCod(identificador, periodo,rolCod);
    }
	@Override
	public void guardarUsuarioLocalizacion(TblUsuarioLocalizacion tblUsuarioLocalizacion) {
		uservicio.save(tblUsuarioLocalizacion);
		
	}
	@Override
	public TblUsuarioLocalizacion obtenerLocalizacionXtecnicoProvincial(String identificador, int periodo, int rolCod) {
		return uservicio.findByIdentificadorAndPeriodoAndRolCodIn(identificador, periodo, rolCod);
	}
	
	@Override
	public List<TblDatosFuncionarios> obtenerTecnicos(String estadoEmpleado, String cargo){
		return UsuarioInternoRepository.findByEstadoEmpleadoAndCargoTecnico(estadoEmpleado, cargo);
	}
	@Override
	public void DeleteEstadoTblLocalizacionXidentificador(String identificador, Integer periodo) {
		uservicio.DeleteTblLocalizacionXidentificador(identificador, periodo);
		
	}
	@Override
	public List<TblDatosFuncionarios> obtenerTecnicosPorPeriodo(String estadoEmpleado, String cargo, Integer periodo) {
		// TODO Auto-generated method stub
		return UsuarioInternoRepository.findByEstadoEmpleadoAndCargoTecnicoAndPeriodo(estadoEmpleado, cargo, periodo);
	}
}
