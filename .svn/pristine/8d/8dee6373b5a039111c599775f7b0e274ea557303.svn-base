package gob.cpccs.service.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.funcionarios.TblDatosFuncionarios;
import gob.cpccs.repository.registroUsuarioInterno.UsuarioInternoRepository;

@Service
public class DatosFuncionariosServiceImpl implements DatosFuncionariosService {
	@Autowired
	private UsuarioInternoRepository UsuInterno;

	@Override
	public void guardarDatasFuncionarios(TblDatosFuncionarios tblDatosFuncionarios) {
		UsuInterno.save(tblDatosFuncionarios);

	}

	@Override
	public List<TblDatosFuncionarios> obtenerFuncionarioXCargo(String estadoEmpleado, String cargo) {

		return UsuInterno.findByEstadoEmpleadoAndCargo(estadoEmpleado, cargo);
	}

	@Override
	public TblDatosFuncionarios obtenerSubcoordinadorXEstadoXCargo(String estadoEmpleado, String cargo) {

		return UsuInterno.buscarXestadoXCargo(estadoEmpleado, cargo);
	}

	@Override
	public TblDatosFuncionarios ObtenerDatodFuncionarioXCod(Integer idDatoFuncionario) {
		return UsuInterno.findByIdDatoFuncionario(idDatoFuncionario);
	}

	@Override
	public List<TblDatosFuncionarios> obtenerFuncionarios(String estadoEmpleado) {
		return UsuInterno.findByEstadoEmpleadoOrderByIdDatoFuncionarioAsc(estadoEmpleado);
	}

	@Override
	public TblDatosFuncionarios ObtenerDatodFuncionarioXidentificador(String identificador) {

		return UsuInterno.findByIdentificador(identificador);
	}

	@Override
	public List<TblDatosFuncionarios> ListaFuncionariosXCodigo(Integer idDatoFuncionario) {
		return UsuInterno.findByIdDatoFuncionarioOrderByIdDatoFuncionario(idDatoFuncionario);
	}
}
