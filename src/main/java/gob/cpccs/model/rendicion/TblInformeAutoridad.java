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

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_informe_autoridad", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInformeAutoridad.findAll", query = "SELECT t FROM TblInformeAutoridad t")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutCod", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutCod = :infAutCod")
    , @NamedQuery(name = "TblInformeAutoridad.findByIdentificador", query = "SELECT t FROM TblInformeAutoridad t WHERE t.identificador = :identificador")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutPeriodo", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutPeriodo = :infAutPeriodo")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutDesde", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutDesde = :infAutDesde")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutHasta", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutHasta = :infAutHasta")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutFechain", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutFechain = :infAutFechain")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutFechafin", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutFechafin = :infAutFechafin")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutVerificador", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutVerificador = :infAutVerificador")
    , @NamedQuery(name = "TblInformeAutoridad.findByInfAutEstado", query = "SELECT t FROM TblInformeAutoridad t WHERE t.infAutEstado = :infAutEstado")})
public class TblInformeAutoridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inf_aut_cod", nullable = false)
    private Integer infAutCod;
    @Basic(optional = false)
    @Column(name = "identificador")
    private Integer identificador;
    @Basic(optional = false)
    @Column(name = "inf_aut_periodo")
    private int infAutPeriodo;
    @Column(name = "inf_aut_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutDesde;
    @Column(name = "inf_aut_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutHasta;
    @Column(name = "inf_aut_fechain")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutFechain;
    @Column(name = "inf_aut_fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutFechafin;
    @Column(name = "inf_aut_verificador", length = 15)
    private String infAutVerificador;
    @Column(name = "inf_aut_estado", length = 15)
    private String infAutEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infAutCod")
    private List<TblFuncionesAutoridades> tblFuncionesAutoridadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infAutCod")
    private List<TblAmecanismosPc> tblAmecanismosPcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infAutCod")
    private List<TblNegarAutoridad> tblNegarAutoridadList;
    @OneToMany(mappedBy = "infAutCod")
    private List<TblPropuestas> tblPropuestasList;
    @Column(name = "inf_aut_fecha_rendicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRendicion;
    @Column(name = "inf_aut_lugar", length = 255)
    private String lugar;
    @Column(name = "inf_aut_numero_asistentes")
    private Integer numeroAsistentes;
    @Column(name = "inf_aut_medio_tributario", length = 255)
    private String infAutMedioTributario;
    @Column(name = "inf_aut_tributo", length = 15)
    private String infAutTributo;
    @Column(name = "ina_proceso_rc", length = 255)
    private String inaProcesoRc;
    @Column(name = "ina_aportes_ciu", length = 4)
    private String inaAportesCiu;
    @Basic(optional = false)
    @Column(name = "inf_contador_apertura")
    private Integer infContadorApertura;
    public TblInformeAutoridad() {
    }

    public TblInformeAutoridad(Integer infAutCod) {
        this.infAutCod = infAutCod;
    }

    public TblInformeAutoridad(Integer infAutCod,  int infAutPeriodo) {
        this.infAutCod = infAutCod;
        this.infAutPeriodo = infAutPeriodo;
    }

    public Integer getInfAutCod() {
        return infAutCod;
    }

    public void setInfAutCod(Integer infAutCod) {
        this.infAutCod = infAutCod;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public int getInfAutPeriodo() {
        return infAutPeriodo;
    }

    public void setInfAutPeriodo(int infAutPeriodo) {
        this.infAutPeriodo = infAutPeriodo;
    }

    public Date getInfAutDesde() {
        return infAutDesde;
    }

    public void setInfAutDesde(Date infAutDesde) {
        this.infAutDesde = infAutDesde;
    }

    public Date getInfAutHasta() {
        return infAutHasta;
    }

    public void setInfAutHasta(Date infAutHasta) {
        this.infAutHasta = infAutHasta;
    }

    public Date getInfAutFechain() {
        return infAutFechain;
    }

    public void setInfAutFechain(Date infAutFechain) {
        this.infAutFechain = infAutFechain;
    }

    public Date getInfAutFechafin() {
        return infAutFechafin;
    }

    public void setInfAutFechafin(Date infAutFechafin) {
        this.infAutFechafin = infAutFechafin;
    }

    public String getInfAutVerificador() {
        return infAutVerificador;
    }

    public void setInfAutVerificador(String infAutVerificador) {
        this.infAutVerificador = infAutVerificador;
    }

    public String getInfAutEstado() {
        return infAutEstado;
    }

    public void setInfAutEstado(String infAutEstado) {
        this.infAutEstado = infAutEstado;
    }

    @XmlTransient
    public List<TblFuncionesAutoridades> getTblFuncionesAutoridadesList() {
        return tblFuncionesAutoridadesList;
    }

    public void setTblFuncionesAutoridadesList(List<TblFuncionesAutoridades> tblFuncionesAutoridadesList) {
        this.tblFuncionesAutoridadesList = tblFuncionesAutoridadesList;
    }

    @XmlTransient
    public List<TblAmecanismosPc> getTblAmecanismosPcList() {
        return tblAmecanismosPcList;
    }

    public void setTblAmecanismosPcList(List<TblAmecanismosPc> tblAmecanismosPcList) {
        this.tblAmecanismosPcList = tblAmecanismosPcList;
    }

    @XmlTransient
    public List<TblNegarAutoridad> getTblNegarAutoridadList() {
        return tblNegarAutoridadList;
    }

    public void setTblNegarAutoridadList(List<TblNegarAutoridad> tblNegarAutoridadList) {
        this.tblNegarAutoridadList = tblNegarAutoridadList;
    }

    @XmlTransient
    public List<TblPropuestas> getTblPropuestasList() {
        return tblPropuestasList;
    }

    public void setTblPropuestasList(List<TblPropuestas> tblPropuestasList) {
        this.tblPropuestasList = tblPropuestasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infAutCod != null ? infAutCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInformeAutoridad)) {
            return false;
        }
        TblInformeAutoridad other = (TblInformeAutoridad) object;
        if ((this.infAutCod == null && other.infAutCod != null) || (this.infAutCod != null && !this.infAutCod.equals(other.infAutCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblInformeAutoridad[ infAutCod=" + infAutCod + " ]";
    }
    
    
    public Date getFechaRendicion() {
        return fechaRendicion;
    }

    public void setFechaRendicion(Date fechaRendicion) {
        this.fechaRendicion = fechaRendicion;
    }
    
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    
    public Integer getNumeroAsistentes() {
        return numeroAsistentes;
    }

    public void setNumeroAsistentes(Integer numeroAsistentes) {
        this.numeroAsistentes = numeroAsistentes;
    }

    public String getInfAutMedioTributario() {
        return infAutMedioTributario;
    }

    public void setInfAutMedioTributario(String infAutMedioTributario) {
        this.infAutMedioTributario = infAutMedioTributario;
    }
    
    public String getInfAutTributo() {
        return infAutTributo;
    }

    public void setInfAutTributo(String infAutTributo) {
        this.infAutTributo = infAutTributo;
    }
    
    public String getInaProcesoRc() {
        return inaProcesoRc;
    }

    public void setInaProcesoRc(String inaProcesoRc) {
        this.inaProcesoRc = inaProcesoRc;
    }
    
    public String getInaAportesCiu() {
        return inaAportesCiu;
    }

    public void setInaAportesCiu(String inaAportesCiu) {
        this.inaAportesCiu = inaAportesCiu;
    }
    
    public Integer getInfContadorApertura() {
        return infContadorApertura;
    }

    public void setInfContadorApertura(Integer infContadorApertura) {
        this.infContadorApertura = infContadorApertura;
    }
    
    
}
