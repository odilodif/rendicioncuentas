/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_informe", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInforme.findAll", query = "SELECT t FROM TblInforme t")
    , @NamedQuery(name = "TblInforme.findByInfCod", query = "SELECT t FROM TblInforme t WHERE t.infCod = :infCod")
    , @NamedQuery(name = "TblInforme.findByInstCod", query = "SELECT t FROM TblInforme t WHERE t.instCod = :instCod")
    , @NamedQuery(name = "TblInforme.findByInfPeriodo", query = "SELECT t FROM TblInforme t WHERE t.infPeriodo = :infPeriodo")
    , @NamedQuery(name = "TblInforme.findByInfDesde", query = "SELECT t FROM TblInforme t WHERE t.infDesde = :infDesde")
    , @NamedQuery(name = "TblInforme.findByInfHasta", query = "SELECT t FROM TblInforme t WHERE t.infHasta = :infHasta")
    , @NamedQuery(name = "TblInforme.findByInfFechaini", query = "SELECT t FROM TblInforme t WHERE t.infFechaini = :infFechaini")
    , @NamedQuery(name = "TblInforme.findByInfFechafin", query = "SELECT t FROM TblInforme t WHERE t.infFechafin = :infFechafin")
    , @NamedQuery(name = "TblInforme.findByInfVerificador", query = "SELECT t FROM TblInforme t WHERE t.infVerificador = :infVerificador")
    , @NamedQuery(name = "TblInforme.findByInfEstado", query = "SELECT t FROM TblInforme t WHERE t.infEstado = :infEstado")})

public class TblInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inf_cod", nullable = false)
    private Integer infCod;
    @Basic(optional = false)
    @Column(name = "inst_cod", nullable = false)
    private int instCod;
    @Basic(optional = false)
    @Column(name = "inf_periodo", nullable = false)
    private int infPeriodo;
    @Basic(optional = false)
    @Column(name = "inf_desde", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date infDesde;
    @Basic(optional = false)
    @Column(name = "inf_hasta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date infHasta;
    @Column(name = "inf_fechaini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infFechaini;
    @Column(name = "inf_fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infFechafin;
    @Column(name = "inf_verificador", length = 15)
    private String infVerificador;
    @Column(name = "inf_estado", length = 15)
    private String infEstado;

    @Column(name = "inf_gpr_educacion", length = 100)
    private String infGprEducacion;
    
    @Basic(optional = false)
    @Column(name = "inf_contador_apertura")
    private Integer infContadorApertura;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblCumplimientoObligaciones> tblCumplimientoObligacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infoCod")
    private List<TblImplementacionPresupuesto> tblImplementacionPresupuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblObligacionesEducacion> tblObligacionesEducacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblDetalleEjecucionp> tblDetalleEjecucionpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblParticipacionCiudadana> tblParticipacionCiudadanaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblCumplimientoMedios> tblCumplimientoMediosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblImplementacionIgualdad> tblImplementacionIgualdadList;
    @OneToMany(mappedBy = "infCod")
    private List<TblMecanismosTranparenciaAccInf> tblMecanismosTranparenciaAccInfList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infAutCod")
    private List<TblPlanTrabajo> tblPlanTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblPlanTrabajoGad> tblPlanTrabajoGadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblCoberturaNacional> tblCoberturaNacionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblCompromisosInformeant> tblCompromisosInformeantList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblMecanismosContolSocial> tblMecanismosContolSocialList;
    @OneToMany(mappedBy = "infCod")
    private List<TblSeguroCampesino> tblSeguroCampesinoList;
    @OneToMany(mappedBy = "infCod")
    private List<TblDerechosAutor> tblDerechosAutorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblMecanismoParticipacionCiudadana> tblMecanismoParticipacionCiudadanaList;
    @OneToMany(mappedBy = "infCod")
    private List<TblProcesosContratacion> tblProcesosContratacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblDatosInforme> tblDatosInformeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblAsambleaCiudadana> tblAsambleaCiudadanaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblComunicacionGestion> tblComunicacionGestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblModalidadEstudios> tblModalidadEstudiosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblObrasAnteriores> tblObrasAnterioresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblAnteproyectoPresupuesto> tblAnteproyectoPresupuestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblPlanDesarrollo> tblPlanDesarrolloList;
    //@OneToMany(mappedBy = "infCod")
    //private List<TblSede> tblSedeList;
    @OneToMany(mappedBy = "infCod")
    private List<TblSeguroGeneral> tblSeguroGeneralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblMecanismoRendicionCuentas> tblMecanismoRendicionCuentasList;
    @OneToMany(mappedBy = "infCod")
    private List<TblPresupuestoInstitucional> tblPresupuestoInstitucionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblCumplimientoSugerenciaCiudadana> tblCumplimientoSugerenciaCiudadanaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblDatosMedio> tblDatosMedioList;
    @OneToMany(mappedBy = "infCod")
    private List<TblFinanciamiento> tblFinanciamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblCoberturaGeografica> tblCoberturaGeograficaList;
    @OneToMany(mappedBy = "infCod")
    private List<TblProduccionAudiovisual> tblProduccionAudiovisualList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblPresupuestoEducacion> tblPresupuestoEducacionList;
    @OneToMany(mappedBy = "infCod")
    private List<TblReclamosMedios> tblReclamosMediosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblObjetivosPlanDesarrollo> tblObjetivosPlanDesarrolloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblCoberturaInstitucional> tblCoberturaInstitucionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblFondoPrestacional> tblFondoPrestacionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infoCod")
    private List<TblFasePresupuestoParticipativo> tblFasePresupuestoParticipativoList;
    @OneToMany(mappedBy = "infCod")
    private List<TblProyPresupuestoParticipativo> tblProyPresupuestoParticipativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblIncoporacionRecomendaciones> tblIncoporacionRecomendacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblPlanificacionParticipativa> tblPlanificacionParticipativaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblPorcentajePresupuesto> tblPorcentajePresupuestoList;
    @OneToMany(mappedBy = "infCod")
    private List<TblEnajenacionBienes> tblEnajenacionBienesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infCod")
    private List<TblArticulacionPp> tblArticulacionPpList;
    @OneToMany(mappedBy = "infCod")
    private List<TblInformacionFinanciera> tblInformacionFinancieraList;
    @OneToMany(mappedBy = "infCod")
    private List<TblSugerenciaCiudadana> tblSugerenciaCiudadanaList;

    public TblInforme() {
    }

    public TblInforme(Integer infCod) {
        this.infCod = infCod;
    }

    public TblInforme(Integer infCod, int instCod, int infPeriodo, Date infDesde, Date infHasta) {
        this.infCod = infCod;
        this.instCod = instCod;
        this.infPeriodo = infPeriodo;
        this.infDesde = infDesde;
        this.infHasta = infHasta;
    }

    public Integer getInfCod() {
        return infCod;
    }

    public void setInfCod(Integer infCod) {
        this.infCod = infCod;
    }

    public int getInstCod() {
        return instCod;
    }

    public void setInstCod(int instCod) {
        this.instCod = instCod;
    }

    public int getInfPeriodo() {
        return infPeriodo;
    }

    public void setInfPeriodo(int infPeriodo) {
        this.infPeriodo = infPeriodo;
    }

    public Date getInfDesde() {
        return infDesde;
    }

    public void setInfDesde(Date infDesde) {
        this.infDesde = infDesde;
    }

    public Date getInfHasta() {
        return infHasta;
    }

    public void setInfHasta(Date infHasta) {
        this.infHasta = infHasta;
    }

    public Date getInfFechaini() {
        return infFechaini;
    }

    public void setInfFechaini(Date infFechaini) {
        this.infFechaini = infFechaini;
    }

    public Date getInfFechafin() {
        return infFechafin;
    }

    public void setInfFechafin(Date infFechafin) {
        this.infFechafin = infFechafin;
    }

    public String getInfVerificador() {
        return infVerificador;
    }

    public void setInfVerificador(String infVerificador) {
        this.infVerificador = infVerificador;
    }


    public String getInfEstado() {
        return infEstado;
    }

    public void setInfEstado(String infEstado) {
        this.infEstado = infEstado;
    }
    
    public String getInfGprEducacion() {
        return infGprEducacion;
    }

    public void setInfGprEducacion(String infGprEducacion) {
        this.infGprEducacion = infGprEducacion;
    }

    @XmlTransient
    public List<TblCumplimientoObligaciones> getTblCumplimientoObligacionesList() {
        return tblCumplimientoObligacionesList;
    }

    public void setTblCumplimientoObligacionesList(List<TblCumplimientoObligaciones> tblCumplimientoObligacionesList) {
        this.tblCumplimientoObligacionesList = tblCumplimientoObligacionesList;
    }

    @XmlTransient
    public List<TblImplementacionPresupuesto> getTblImplementacionPresupuestoList() {
        return tblImplementacionPresupuestoList;
    }

    public void setTblImplementacionPresupuestoList(List<TblImplementacionPresupuesto> tblImplementacionPresupuestoList) {
        this.tblImplementacionPresupuestoList = tblImplementacionPresupuestoList;
    }

    @XmlTransient
    public List<TblObligacionesEducacion> getTblObligacionesEducacionList() {
        return tblObligacionesEducacionList;
    }

    public void setTblObligacionesEducacionList(List<TblObligacionesEducacion> tblObligacionesEducacionList) {
        this.tblObligacionesEducacionList = tblObligacionesEducacionList;
    }

    @XmlTransient
    public List<TblDetalleEjecucionp> getTblDetalleEjecucionpList() {
        return tblDetalleEjecucionpList;
    }

    public void setTblDetalleEjecucionpList(List<TblDetalleEjecucionp> tblDetalleEjecucionpList) {
        this.tblDetalleEjecucionpList = tblDetalleEjecucionpList;
    }

    @XmlTransient
    public List<TblParticipacionCiudadana> getTblParticipacionCiudadanaList() {
        return tblParticipacionCiudadanaList;
    }

    public void setTblParticipacionCiudadanaList(List<TblParticipacionCiudadana> tblParticipacionCiudadanaList) {
        this.tblParticipacionCiudadanaList = tblParticipacionCiudadanaList;
    }

    @XmlTransient
    public List<TblCumplimientoMedios> getTblCumplimientoMediosList() {
        return tblCumplimientoMediosList;
    }

    public void setTblCumplimientoMediosList(List<TblCumplimientoMedios> tblCumplimientoMediosList) {
        this.tblCumplimientoMediosList = tblCumplimientoMediosList;
    }

    @XmlTransient
    public List<TblImplementacionIgualdad> getTblImplementacionIgualdadList() {
        return tblImplementacionIgualdadList;
    }

    public void setTblImplementacionIgualdadList(List<TblImplementacionIgualdad> tblImplementacionIgualdadList) {
        this.tblImplementacionIgualdadList = tblImplementacionIgualdadList;
    }

    @XmlTransient
    public List<TblMecanismosTranparenciaAccInf> getTblMecanismosTranparenciaAccInfList() {
        return tblMecanismosTranparenciaAccInfList;
    }

    public void setTblMecanismosTranparenciaAccInfList(List<TblMecanismosTranparenciaAccInf> tblMecanismosTranparenciaAccInfList) {
        this.tblMecanismosTranparenciaAccInfList = tblMecanismosTranparenciaAccInfList;
    }

    @XmlTransient
    public List<TblPlanTrabajo> getTblPlanTrabajoList() {
        return tblPlanTrabajoList;
    }

    public void setTblPlanTrabajoList(List<TblPlanTrabajo> tblPlanTrabajoList) {
        this.tblPlanTrabajoList = tblPlanTrabajoList;
    }

    @XmlTransient
    public List<TblPlanTrabajoGad> getTblPlanTrabajoGadList() {
        return tblPlanTrabajoGadList;
    }

    public void setTblPlanTrabajoGadList(List<TblPlanTrabajoGad> tblPlanTrabajoGadList) {
        this.tblPlanTrabajoGadList = tblPlanTrabajoGadList;
    }

    @XmlTransient
    public List<TblCoberturaNacional> getTblCoberturaNacionalList() {
        return tblCoberturaNacionalList;
    }

    public void setTblCoberturaNacionalList(List<TblCoberturaNacional> tblCoberturaNacionalList) {
        this.tblCoberturaNacionalList = tblCoberturaNacionalList;
    }

    @XmlTransient
    public List<TblCompromisosInformeant> getTblCompromisosInformeantList() {
        return tblCompromisosInformeantList;
    }

    public void setTblCompromisosInformeantList(List<TblCompromisosInformeant> tblCompromisosInformeantList) {
        this.tblCompromisosInformeantList = tblCompromisosInformeantList;
    }

    @XmlTransient
    public List<TblMecanismosContolSocial> getTblMecanismosContolSocialList() {
        return tblMecanismosContolSocialList;
    }

    public void setTblMecanismosContolSocialList(List<TblMecanismosContolSocial> tblMecanismosContolSocialList) {
        this.tblMecanismosContolSocialList = tblMecanismosContolSocialList;
    }

    @XmlTransient
    public List<TblSeguroCampesino> getTblSeguroCampesinoList() {
        return tblSeguroCampesinoList;
    }

    public void setTblSeguroCampesinoList(List<TblSeguroCampesino> tblSeguroCampesinoList) {
        this.tblSeguroCampesinoList = tblSeguroCampesinoList;
    }

    @XmlTransient
    public List<TblDerechosAutor> getTblDerechosAutorList() {
        return tblDerechosAutorList;
    }

    public void setTblDerechosAutorList(List<TblDerechosAutor> tblDerechosAutorList) {
        this.tblDerechosAutorList = tblDerechosAutorList;
    }

    @XmlTransient
    public List<TblMecanismoParticipacionCiudadana> getTblMecanismoParticipacionCiudadanaList() {
        return tblMecanismoParticipacionCiudadanaList;
    }

    public void setTblMecanismoParticipacionCiudadanaList(List<TblMecanismoParticipacionCiudadana> tblMecanismoParticipacionCiudadanaList) {
        this.tblMecanismoParticipacionCiudadanaList = tblMecanismoParticipacionCiudadanaList;
    }

    @XmlTransient
    public List<TblProcesosContratacion> getTblProcesosContratacionList() {
        return tblProcesosContratacionList;
    }

    public void setTblProcesosContratacionList(List<TblProcesosContratacion> tblProcesosContratacionList) {
        this.tblProcesosContratacionList = tblProcesosContratacionList;
    }

    @XmlTransient
    public List<TblDatosInforme> getTblDatosInformeList() {
        return tblDatosInformeList;
    }

    public void setTblDatosInformeList(List<TblDatosInforme> tblDatosInformeList) {
        this.tblDatosInformeList = tblDatosInformeList;
    }

    @XmlTransient
    public List<TblAsambleaCiudadana> getTblAsambleaCiudadanaList() {
        return tblAsambleaCiudadanaList;
    }

    public void setTblAsambleaCiudadanaList(List<TblAsambleaCiudadana> tblAsambleaCiudadanaList) {
        this.tblAsambleaCiudadanaList = tblAsambleaCiudadanaList;
    }

    @XmlTransient
    public List<TblComunicacionGestion> getTblComunicacionGestionList() {
        return tblComunicacionGestionList;
    }

    public void setTblComunicacionGestionList(List<TblComunicacionGestion> tblComunicacionGestionList) {
        this.tblComunicacionGestionList = tblComunicacionGestionList;
    }

    @XmlTransient
    public List<TblModalidadEstudios> getTblModalidadEstudiosList() {
        return tblModalidadEstudiosList;
    }

    public void setTblModalidadEstudiosList(List<TblModalidadEstudios> tblModalidadEstudiosList) {
        this.tblModalidadEstudiosList = tblModalidadEstudiosList;
    }

    @XmlTransient
    public List<TblObrasAnteriores> getTblObrasAnterioresList() {
        return tblObrasAnterioresList;
    }

    public void setTblObrasAnterioresList(List<TblObrasAnteriores> tblObrasAnterioresList) {
        this.tblObrasAnterioresList = tblObrasAnterioresList;
    }

    @XmlTransient
    public List<TblAnteproyectoPresupuesto> getTblAnteproyectoPresupuestoList() {
        return tblAnteproyectoPresupuestoList;
    }

    public void setTblAnteproyectoPresupuestoList(List<TblAnteproyectoPresupuesto> tblAnteproyectoPresupuestoList) {
        this.tblAnteproyectoPresupuestoList = tblAnteproyectoPresupuestoList;
    }

    @XmlTransient
    public List<TblPlanDesarrollo> getTblPlanDesarrolloList() {
        return tblPlanDesarrolloList;
    }

    public void setTblPlanDesarrolloList(List<TblPlanDesarrollo> tblPlanDesarrolloList) {
        this.tblPlanDesarrolloList = tblPlanDesarrolloList;
    }

    /*@XmlTransient
    public List<TblSede> getTblSedeList() {
        return tblSedeList;
    }

    public void setTblSedeList(List<TblSede> tblSedeList) {
        this.tblSedeList = tblSedeList;
    }*/

    @XmlTransient
    public List<TblSeguroGeneral> getTblSeguroGeneralList() {
        return tblSeguroGeneralList;
    }

    public void setTblSeguroGeneralList(List<TblSeguroGeneral> tblSeguroGeneralList) {
        this.tblSeguroGeneralList = tblSeguroGeneralList;
    }

    @XmlTransient
    public List<TblMecanismoRendicionCuentas> getTblMecanismoRendicionCuentasList() {
        return tblMecanismoRendicionCuentasList;
    }

    public void setTblMecanismoRendicionCuentasList(List<TblMecanismoRendicionCuentas> tblMecanismoRendicionCuentasList) {
        this.tblMecanismoRendicionCuentasList = tblMecanismoRendicionCuentasList;
    }

    @XmlTransient
    public List<TblPresupuestoInstitucional> getTblPresupuestoInstitucionalList() {
        return tblPresupuestoInstitucionalList;
    }

    public void setTblPresupuestoInstitucionalList(List<TblPresupuestoInstitucional> tblPresupuestoInstitucionalList) {
        this.tblPresupuestoInstitucionalList = tblPresupuestoInstitucionalList;
    }

    @XmlTransient
    public List<TblCumplimientoSugerenciaCiudadana> getTblCumplimientoSugerenciaCiudadanaList() {
        return tblCumplimientoSugerenciaCiudadanaList;
    }

    public void setTblCumplimientoSugerenciaCiudadanaList(List<TblCumplimientoSugerenciaCiudadana> tblCumplimientoSugerenciaCiudadanaList) {
        this.tblCumplimientoSugerenciaCiudadanaList = tblCumplimientoSugerenciaCiudadanaList;
    }

    @XmlTransient
    public List<TblDatosMedio> getTblDatosMedioList() {
        return tblDatosMedioList;
    }

    public void setTblDatosMedioList(List<TblDatosMedio> tblDatosMedioList) {
        this.tblDatosMedioList = tblDatosMedioList;
    }

    @XmlTransient
    public List<TblFinanciamiento> getTblFinanciamientoList() {
        return tblFinanciamientoList;
    }

    public void setTblFinanciamientoList(List<TblFinanciamiento> tblFinanciamientoList) {
        this.tblFinanciamientoList = tblFinanciamientoList;
    }

    @XmlTransient
    public List<TblCoberturaGeografica> getTblCoberturaGeograficaList() {
        return tblCoberturaGeograficaList;
    }

    public void setTblCoberturaGeograficaList(List<TblCoberturaGeografica> tblCoberturaGeograficaList) {
        this.tblCoberturaGeograficaList = tblCoberturaGeograficaList;
    }

    @XmlTransient
    public List<TblProduccionAudiovisual> getTblProduccionAudiovisualList() {
        return tblProduccionAudiovisualList;
    }

    public void setTblProduccionAudiovisualList(List<TblProduccionAudiovisual> tblProduccionAudiovisualList) {
        this.tblProduccionAudiovisualList = tblProduccionAudiovisualList;
    }

    @XmlTransient
    public List<TblPresupuestoEducacion> getTblPresupuestoEducacionList() {
        return tblPresupuestoEducacionList;
    }

    public void setTblPresupuestoEducacionList(List<TblPresupuestoEducacion> tblPresupuestoEducacionList) {
        this.tblPresupuestoEducacionList = tblPresupuestoEducacionList;
    }

    @XmlTransient
    public List<TblReclamosMedios> getTblReclamosMediosList() {
        return tblReclamosMediosList;
    }

    public void setTblReclamosMediosList(List<TblReclamosMedios> tblReclamosMediosList) {
        this.tblReclamosMediosList = tblReclamosMediosList;
    }

    @XmlTransient
    public List<TblObjetivosPlanDesarrollo> getTblObjetivosPlanDesarrolloList() {
        return tblObjetivosPlanDesarrolloList;
    }

    public void setTblObjetivosPlanDesarrolloList(List<TblObjetivosPlanDesarrollo> tblObjetivosPlanDesarrolloList) {
        this.tblObjetivosPlanDesarrolloList = tblObjetivosPlanDesarrolloList;
    }

    @XmlTransient
    public List<TblCoberturaInstitucional> getTblCoberturaInstitucionalList() {
        return tblCoberturaInstitucionalList;
    }

    public void setTblCoberturaInstitucionalList(List<TblCoberturaInstitucional> tblCoberturaInstitucionalList) {
        this.tblCoberturaInstitucionalList = tblCoberturaInstitucionalList;
    }

    @XmlTransient
    public List<TblFondoPrestacional> getTblFondoPrestacionalList() {
        return tblFondoPrestacionalList;
    }

    public void setTblFondoPrestacionalList(List<TblFondoPrestacional> tblFondoPrestacionalList) {
        this.tblFondoPrestacionalList = tblFondoPrestacionalList;
    }

    @XmlTransient
    public List<TblFasePresupuestoParticipativo> getTblFasePresupuestoParticipativoList() {
        return tblFasePresupuestoParticipativoList;
    }

    public void setTblFasePresupuestoParticipativoList(List<TblFasePresupuestoParticipativo> tblFasePresupuestoParticipativoList) {
        this.tblFasePresupuestoParticipativoList = tblFasePresupuestoParticipativoList;
    }

    @XmlTransient
    public List<TblProyPresupuestoParticipativo> getTblProyPresupuestoParticipativoList() {
        return tblProyPresupuestoParticipativoList;
    }

    public void setTblProyPresupuestoParticipativoList(List<TblProyPresupuestoParticipativo> tblProyPresupuestoParticipativoList) {
        this.tblProyPresupuestoParticipativoList = tblProyPresupuestoParticipativoList;
    }

    @XmlTransient
    public List<TblIncoporacionRecomendaciones> getTblIncoporacionRecomendacionesList() {
        return tblIncoporacionRecomendacionesList;
    }

    public void setTblIncoporacionRecomendacionesList(List<TblIncoporacionRecomendaciones> tblIncoporacionRecomendacionesList) {
        this.tblIncoporacionRecomendacionesList = tblIncoporacionRecomendacionesList;
    }

    @XmlTransient
    public List<TblPlanificacionParticipativa> getTblPlanificacionParticipativaList() {
        return tblPlanificacionParticipativaList;
    }

    public void setTblPlanificacionParticipativaList(List<TblPlanificacionParticipativa> tblPlanificacionParticipativaList) {
        this.tblPlanificacionParticipativaList = tblPlanificacionParticipativaList;
    }

    @XmlTransient
    public List<TblPorcentajePresupuesto> getTblPorcentajePresupuestoList() {
        return tblPorcentajePresupuestoList;
    }

    public void setTblPorcentajePresupuestoList(List<TblPorcentajePresupuesto> tblPorcentajePresupuestoList) {
        this.tblPorcentajePresupuestoList = tblPorcentajePresupuestoList;
    }

    @XmlTransient
    public List<TblEnajenacionBienes> getTblEnajenacionBienesList() {
        return tblEnajenacionBienesList;
    }

    public void setTblEnajenacionBienesList(List<TblEnajenacionBienes> tblEnajenacionBienesList) {
        this.tblEnajenacionBienesList = tblEnajenacionBienesList;
    }

    @XmlTransient
    public List<TblArticulacionPp> getTblArticulacionPpList() {
        return tblArticulacionPpList;
    }

    public void setTblArticulacionPpList(List<TblArticulacionPp> tblArticulacionPpList) {
        this.tblArticulacionPpList = tblArticulacionPpList;
    }

    @XmlTransient
    public List<TblInformacionFinanciera> getTblInformacionFinancieraList() {
        return tblInformacionFinancieraList;
    }

    public void setTblInformacionFinancieraList(List<TblInformacionFinanciera> tblInformacionFinancieraList) {
        this.tblInformacionFinancieraList = tblInformacionFinancieraList;
    }

    @XmlTransient
    public List<TblSugerenciaCiudadana> getTblSugerenciaCiudadanaList() {
        return tblSugerenciaCiudadanaList;
    }

    public void setTblSugerenciaCiudadanaList(List<TblSugerenciaCiudadana> tblSugerenciaCiudadanaList) {
        this.tblSugerenciaCiudadanaList = tblSugerenciaCiudadanaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infCod != null ? infCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInforme)) {
            return false;
        }
        TblInforme other = (TblInforme) object;
        if ((this.infCod == null && other.infCod != null) || (this.infCod != null && !this.infCod.equals(other.infCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblInforme[ infCod=" + infCod + " ]";
    }
    
    public Integer getInfContadorApertura() {
        return infContadorApertura;
    }

    public void setInfContadorApertura(Integer infContadorApertura) {
        this.infContadorApertura = infContadorApertura;
    }
    
}
