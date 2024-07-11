/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_datos_informe", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDatosInforme.findAll", query = "SELECT t FROM TblDatosInforme t")
    , @NamedQuery(name = "TblDatosInforme.findByIdDatos", query = "SELECT t FROM TblDatosInforme t WHERE t.idDatos = :idDatos")
    , @NamedQuery(name = "TblDatosInforme.findByInfFecharc", query = "SELECT t FROM TblDatosInforme t WHERE t.infFecharc = :infFecharc")
    , @NamedQuery(name = "TblDatosInforme.findByInfHombre", query = "SELECT t FROM TblDatosInforme t WHERE t.infHombre = :infHombre")
    , @NamedQuery(name = "TblDatosInforme.findByInfMujeres", query = "SELECT t FROM TblDatosInforme t WHERE t.infMujeres = :infMujeres")
    , @NamedQuery(name = "TblDatosInforme.findByInfGlbti", query = "SELECT t FROM TblDatosInforme t WHERE t.infGlbti = :infGlbti")
    , @NamedQuery(name = "TblDatosInforme.findByInfMontubios", query = "SELECT t FROM TblDatosInforme t WHERE t.infMontubios = :infMontubios")
    , @NamedQuery(name = "TblDatosInforme.findByInfMestizos", query = "SELECT t FROM TblDatosInforme t WHERE t.infMestizos = :infMestizos")
    , @NamedQuery(name = "TblDatosInforme.findByInfCholos", query = "SELECT t FROM TblDatosInforme t WHERE t.infCholos = :infCholos")
    , @NamedQuery(name = "TblDatosInforme.findByInfIndigenas", query = "SELECT t FROM TblDatosInforme t WHERE t.infIndigenas = :infIndigenas")
    , @NamedQuery(name = "TblDatosInforme.findByInfAfroecuatorianos", query = "SELECT t FROM TblDatosInforme t WHERE t.infAfroecuatorianos = :infAfroecuatorianos")
    , @NamedQuery(name = "TblDatosInforme.findByInfUsuarios", query = "SELECT t FROM TblDatosInforme t WHERE t.infUsuarios = :infUsuarios")})
public class TblDatosInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_datos", nullable = false)
    private Integer idDatos;
    @Column(name = "inf_fecharc")
    @Temporal(TemporalType.DATE)
    private Date infFecharc;
    @Column(name = "inf_hombre")
    private Integer infHombre;
    @Column(name = "inf_mujeres")
    private Integer infMujeres;
    @Column(name = "inf_glbti")
    private Integer infGlbti;
    @Column(name = "inf_montubios")
    private Integer infMontubios;
    @Column(name = "inf_mestizos")
    private Integer infMestizos;
    @Column(name = "inf_cholos")
    private Integer infCholos;
    @Column(name = "inf_indigenas")
    private Integer infIndigenas;
    @Column(name = "inf_afroecuatorianos")
    private Integer infAfroecuatorianos;
    @Column(name = "inf_usuarios")
    private Integer infUsuarios;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblDatosInforme() {
    }

    public TblDatosInforme(Integer idDatos) {
        this.idDatos = idDatos;
    }

    public Integer getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(Integer idDatos) {
        this.idDatos = idDatos;
    }

    public Date getInfFecharc() {
        return infFecharc;
    }

    public void setInfFecharc(Date infFecharc) {
        this.infFecharc = infFecharc;
    }

    public Integer getInfHombre() {
        return infHombre;
    }

    public void setInfHombre(Integer infHombre) {
        this.infHombre = infHombre;
    }

    public Integer getInfMujeres() {
        return infMujeres;
    }

    public void setInfMujeres(Integer infMujeres) {
        this.infMujeres = infMujeres;
    }

    public Integer getInfGlbti() {
        return infGlbti;
    }

    public void setInfGlbti(Integer infGlbti) {
        this.infGlbti = infGlbti;
    }

    public Integer getInfMontubios() {
        return infMontubios;
    }

    public void setInfMontubios(Integer infMontubios) {
        this.infMontubios = infMontubios;
    }

    public Integer getInfMestizos() {
        return infMestizos;
    }

    public void setInfMestizos(Integer infMestizos) {
        this.infMestizos = infMestizos;
    }

    public Integer getInfCholos() {
        return infCholos;
    }

    public void setInfCholos(Integer infCholos) {
        this.infCholos = infCholos;
    }

    public Integer getInfIndigenas() {
        return infIndigenas;
    }

    public void setInfIndigenas(Integer infIndigenas) {
        this.infIndigenas = infIndigenas;
    }

    public Integer getInfAfroecuatorianos() {
        return infAfroecuatorianos;
    }

    public void setInfAfroecuatorianos(Integer infAfroecuatorianos) {
        this.infAfroecuatorianos = infAfroecuatorianos;
    }

    public Integer getInfUsuarios() {
        return infUsuarios;
    }

    public void setInfUsuarios(Integer infUsuarios) {
        this.infUsuarios = infUsuarios;
    }

    public TblInforme getInfCod() {
        return infCod;
    }

    public void setInfCod(TblInforme infCod) {
        this.infCod = infCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatos != null ? idDatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDatosInforme)) {
            return false;
        }
        TblDatosInforme other = (TblDatosInforme) object;
        if ((this.idDatos == null && other.idDatos != null) || (this.idDatos != null && !this.idDatos.equals(other.idDatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblDatosInforme[ idDatos=" + idDatos + " ]";
    }
    
}
