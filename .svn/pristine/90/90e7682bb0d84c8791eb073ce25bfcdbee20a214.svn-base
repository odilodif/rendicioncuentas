/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringEscapeUtils;

import gob.cpccs.utilidades.Constantes;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_mecanismo_participacion_ciudadana", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findAll", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaCod", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaCod = :mecaCod")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaNombre", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaNombre = :mecaNombre")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaImplementado", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaImplementado = :mecaImplementado")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaNumero", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaNumero = :mecaNumero")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaMedioverifica", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaMedioverifica = :mecaMedioverifica")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaTi", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaTi = :mecaTi")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaConvocatorias", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaConvocatorias = :mecaConvocatorias")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaDescLogros", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaDescLogros = :mecaDescLogros")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaSec", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaSec = :mecaSec")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaEnti", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaEnti = :mecaEnti")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaOrg", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaOrg = :mecaOrg")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaOtros", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaOtros = :mecaOtros")
    , @NamedQuery(name = "TblMecanismoParticipacionCiudadana.findByMecaActores", query = "SELECT t FROM TblMecanismoParticipacionCiudadana t WHERE t.mecaActores = :mecaActores")})
public class TblMecanismoParticipacionCiudadana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meca_cod", nullable = false)
    private Integer mecaCod;
    @Column(name = "meca_nombre", length = 200)
    private String mecaNombre;
    @Column(name = "meca_implementado", length = 2)
    private String mecaImplementado;
    @Column(name = "meca_numero")
    private Integer mecaNumero;
    @Column(name = "meca_medioverifica", length = 2147483647)
    private String mecaMedioverifica;
    @Column(name = "meca_ti", length = 200)
    private String mecaTi;
    @Column(name = "meca_convocatorias")
    private Integer mecaConvocatorias;
    @Column(name = "meca_desc_logros", length = 2147483647)
    private String mecaDescLogros;
    @Column(name = "meca_sec", length = 100)
    private String mecaSec;
    @Column(name = "meca_enti", length = 100)
    private String mecaEnti;
    @Column(name = "meca_org", length = 100)
    private String mecaOrg;
    @Column(name = "meca_otros", length = 100)
    private String mecaOtros;
    @Column(name = "meca_actores", length = 100)
    private String mecaActores;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblMecanismoParticipacionCiudadana() {
    }

    public TblMecanismoParticipacionCiudadana(Integer mecaCod) {
        this.mecaCod = mecaCod;
    }

    public Integer getMecaCod() {
        return mecaCod;
    }

    public void setMecaCod(Integer mecaCod) {
        this.mecaCod = mecaCod;
    }

    public String getMecaNombre() {
        return mecaNombre;
    }

    public void setMecaNombre(String mecaNombre) {
        this.mecaNombre = mecaNombre;
    }

    public String getMecaImplementado() {
        return mecaImplementado;
    }

    public void setMecaImplementado(String mecaImplementado) {
        this.mecaImplementado = mecaImplementado;
    }

    public Integer getMecaNumero() {
        return mecaNumero;
    }

    public void setMecaNumero(Integer mecaNumero) {
        this.mecaNumero = mecaNumero;
    }

    public String getMecaMedioverifica() {
        return mecaMedioverifica;
    }

    public void setMecaMedioverifica(String mecaMedioverifica) {
        this.mecaMedioverifica = mecaMedioverifica;
    }

    public String getMecaTi() {
        return mecaTi;
    }

    public void setMecaTi(String mecaTi) {
        this.mecaTi = mecaTi;
    }

    public Integer getMecaConvocatorias() {
        return mecaConvocatorias;
    }

    public void setMecaConvocatorias(Integer mecaConvocatorias) {
        this.mecaConvocatorias = mecaConvocatorias;
    }

    public String getMecaDescLogros() {
        return mecaDescLogros;
    }

    public void setMecaDescLogros(String mecaDescLogros) {
        this.mecaDescLogros = mecaDescLogros;
    }

    public String getMecaSec() {
        return mecaSec;
    }

    public void setMecaSec(String mecaSec) {
        this.mecaSec = mecaSec;
    }

    public String getMecaEnti() {
        return mecaEnti;
    }

    public void setMecaEnti(String mecaEnti) {
        this.mecaEnti = mecaEnti;
    }

    public String getMecaOrg() {
        return mecaOrg;
    }

    public void setMecaOrg(String mecaOrg) {
        this.mecaOrg = mecaOrg;
    }

    public String getMecaOtros() {
        return mecaOtros;
    }

    public void setMecaOtros(String mecaOtros) {
        this.mecaOtros = mecaOtros;
    }

    public String getMecaActores() {
        return mecaActores;
    }

    public void setMecaActores(String mecaActores) {
        this.mecaActores = mecaActores;
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
        hash += (mecaCod != null ? mecaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMecanismoParticipacionCiudadana)) {
            return false;
        }
        TblMecanismoParticipacionCiudadana other = (TblMecanismoParticipacionCiudadana) object;
        if ((this.mecaCod == null && other.mecaCod != null) || (this.mecaCod != null && !this.mecaCod.equals(other.mecaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblMecanismoParticipacionCiudadana[ mecaCod=" + mecaCod + " ]";
    }
    
}
