package gob.cpccs.service.rendicion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblImplementacionIgualdad;
import gob.cpccs.model.rendicion.TblImplementacionPresupuesto;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblInformeAutoridad;
import gob.cpccs.model.rendicion.TblMecanismoRendicionCuentas;
import gob.cpccs.model.rendicion.TblMecanismosContolSocial;
import gob.cpccs.model.rendicion.TblParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;
import gob.cpccs.model.rendicion.TblPlanDesarrollo;


public interface InformeServicio {


	//InformeAutoridad
    void ActualizarInformeAutoridad(Date fechaRendicion, String lugar, Integer numeroAsistentes,  int infAutCod);
    void ActualizarInformeObligaciones(String infAutTributo, String infAutMedioTributario,  int infAutCod);
    void ActualizarInformeRendicion(String inaProcesoRc,  int infAutCod);
    void ActualizarInformeAportes(String inaAportesCiu,  int infAutCod);
	void finalizarInforme(int infAutCod, String infAutEstado, Date infAutFechafin,  String infAutVerificador);
	void AperturaInformeAutoridad(String infAutEstado, Integer infAutCod,  String infAutVerificador, Integer infContadorApertura);
    
	//Informe
    void ActualizarGrupoEducacion(String infGprEducacion, int infCod);
	TblInforme obtenerRegistroInforme(int instCod);
	void  AperturaInforme(String infEstado, Integer infCod, String infVerificador,  Integer infContadorApertura);
	TblInformeAutoridad	obtenerRegistroInforme(int infAutCod ,int periodo);
	
	TblInformeAutoridad	obtenerRegistroInformeAutCod(int infAutCod ,int periodo);

	
	TblInformeAutoridad	obtenerRegistroInformexIdentificador(int infAutCod ,int periodo);
	List<Object[]>	obtenerInformeAutoridadxIdentificador(String Estado, Integer periodo, String Identificador);
	void finalizarInformeInstitucion(int infCod, String infEstado, Date infFechafin,  String infVerificador);
	void finalizarTiempoInformeInstitucion(int infCod, String infEstado);

	
	void guardarInformeAutoridad(TblInformeAutoridad tblInformeAutoridad);
   //institucion	
	

	TblInforme obtenerRegistroInformeInstitucion(int instCod ,int periodo);
	List<Object[]> obtenerRegistroInformeInstitucionXInfcod(int infcod ,int periodo);
	List<Object[]> obtenerRegistroInformeInstitucionXInfcodMedios(int infcod ,int periodo);
	List<Object[]> obtenerRegistroInformeInstitucionXInfcodES(int infcod ,int periodo);

	
	void guardarInforme(TblInforme tblInforme);
	List<TblFuncionesObjetivos> obtenerRegistroInformeInstitucionFuncionesObjetivos(int instCod);
	List<TblFuncionesObjetivos> obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(int instCod, String foTip);
	//FuncionesObjetivos
	void guardarFuncionesObjetivos(TblFuncionesObjetivos tblFuncionesObjetivos);
	List<Object[]> BuscarFuncionesObjetivosInstCod(int codigoIntitucionAutorida, String estado, String periodo);
	List<Object[]> BuscarFuncionesObjetivosInstCodTipo(int codigoIntitucionAutorida, String estado, String periodo, String tipo);
	List<Object[]> BuscarFuncionesObjetivosInstCodSinTipo(int codigoIntitucionAutorida, String estado, String periodo);
	TblFuncionesObjetivos obtenerRegistroFuncionObjetivo(int identificador,String periodo);
	TblInforme obtenerRegistroInformeXcodPeriodo(Integer infCod ,Integer periodo);
    //PlanDesarrollo
	List<TblObjetivosPlanDesarrollo> OntenerRegistrosObjetivosXcod(TblInforme tblInforme);
    void guardarPlanDesarrollo(TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo);
	List<Object[]> obtenerRegistroObjetivosPlanXcod(TblInforme tblInforme);
	//EjecucionProgramatica
	void guardarEjecucionProgramtica(TblEjecucionProgramatica tblEjecucionProgramatica);
	List<TblEjecucionProgramatica> obtenerTotalesEjecucionProgramatica(int infCod);
	public TblObjetivosPlanDesarrollo obtenerIdObjetivoPlan(int foCod);
    void ActualizarTotalEjecucionProgramatica(BigDecimal eprSuma, int infCod);
    //Avances
    void guardarAvances(TblPlanDesarrollo tblPlanDesarrollo);
    List<Object[]> obtenerRegistroAvances(TblInforme tblInforme);
    
    //verficarllenadoInformes
    
    public String listar (int infAutCod, int infAutPeriodo);
    public String listarInstitucion (int infCod, int infAutPeriodo);
    public String listarInstitucionVinculadas (int infCod, int infAutPeriodo);
    public String listarEudcacionSuperior (int infCod, int infAutPeriodo);

    public String listarInstitucionFE (int infCod, int infAutPeriodo);
    public String listarInstitucionGADEP (int infCod, int infAutPeriodo);
    public String listarInstitucionFEEP (int infCod, int infAutPeriodo);
    public String listarInstitucionMedios (int infCod, int infAutPeriodo);
    public String listarInstitucionIESS (int infCod, int infAutPeriodo);
	List<Object[]> obtenerTotalesEjecucionProgramaticaNativa(int infCod);
	//Estanciar metodo Imp query competencias concurrentes para el periodo 2025
	/*
	List<Object[]> BuscarFuncionesObjetivosInstCodTipoConcurrentes(int codigoIntitucionAutorida, String estado,
			String periodo, String tipo);
	*/
	TblInforme obtenerDatosInformePorInstitucionCodigo(int instCod);
}
