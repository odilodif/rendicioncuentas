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
@Table(name = "tbl_asamblea_ciudadana", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAsambleaCiudadana.findAll", query = "SELECT t FROM TblAsambleaCiudadana t")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcCod", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acCod = :acCod")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcEspaciosParticipa", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acEspaciosParticipa = :acEspaciosParticipa")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcExiste", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acExiste = :acExiste")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcValidaGestTerritorio", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acValidaGestTerritorio = :acValidaGestTerritorio")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcDescrPlanficacion", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acDescrPlanficacion = :acDescrPlanficacion")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcDescLogros", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acDescLogros = :acDescLogros")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcNomRespon", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acNomRespon = :acNomRespon")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcMeilRespon", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acMeilRespon = :acMeilRespon")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcTelfRespon", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acTelfRespon = :acTelfRespon")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcRepreTerri", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acRepreTerri = :acRepreTerri")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcGrupEspe", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acGrupEspe = :acGrupEspe")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcGrupPrio", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acGrupPrio = :acGrupPrio")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcGremial", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acGremial = :acGremial")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcSocOrga", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acSocOrga = :acSocOrga")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcUnidParti", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acUnidParti = :acUnidParti")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcGrupEsta", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acGrupEsta = :acGrupEsta")
    , @NamedQuery(name = "TblAsambleaCiudadana.findByAcOtro", query = "SELECT t FROM TblAsambleaCiudadana t WHERE t.acOtro = :acOtro")})
public class TblAsambleaCiudadana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ac_cod", nullable = false)
    private Integer acCod;
    @Column(name = "ac_espacios_participa", length = 2147483647)
    private String acEspaciosParticipa;
    @Column(name = "ac_existe", length = 2)
    private String acExiste;
    @Column(name = "ac_valida_gest_territorio", length = 10)
    private String acValidaGestTerritorio;
    @Column(name = "ac_descr_planficacion", length = 2147483647)
    private String acDescrPlanficacion;
    @Column(name = "ac_desc_logros", length = 2147483647)
    private String acDescLogros;
    @Column(name = "ac_nom_respon", length = 100)
    private String acNomRespon;
    @Column(name = "ac_meil_respon", length = 300)
    private String acMeilRespon;
    @Column(name = "ac_telf_respon", length = 200)
    private String acTelfRespon;
    @Column(name = "ac_repre_terri", length = 300)
    private String acRepreTerri;
    @Column(name = "ac_grup_espe", length = 50)
    private String acGrupEspe;
    @Column(name = "ac_grup_prio", length = 50)
    private String acGrupPrio;
    @Column(name = "ac_gremial", length = 50)
    private String acGremial;
    @Column(name = "ac_soc_orga", length = 50)
    private String acSocOrga;
    @Column(name = "ac_unid_parti", length = 50)
    private String acUnidParti;
    @Column(name = "ac_grup_esta", length = 50)
    private String acGrupEsta;
    @Column(name = "ac_otro", length = 50)
    private String acOtro;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblAsambleaCiudadana() {
    }

    public TblAsambleaCiudadana(Integer acCod) {
        this.acCod = acCod;
    }

    public Integer getAcCod() {
        return acCod;
    }

    public void setAcCod(Integer acCod) {
        this.acCod = acCod;
    }

    public String getAcEspaciosParticipa() {
        return acEspaciosParticipa;
    }

    public void setAcEspaciosParticipa(String acEspaciosParticipa) {
        this.acEspaciosParticipa = acEspaciosParticipa;
    }

    public String getAcExiste() {
        return acExiste;
    }

    public void setAcExiste(String acExiste) {
        this.acExiste = acExiste;
    }

    public String getAcValidaGestTerritorio() {
        return acValidaGestTerritorio;
    }

    public void setAcValidaGestTerritorio(String acValidaGestTerritorio) {
        this.acValidaGestTerritorio = acValidaGestTerritorio;
    }

    public String getAcDescrPlanficacion() {
        return acDescrPlanficacion;
    }

    public void setAcDescrPlanficacion(String acDescrPlanficacion) {
        this.acDescrPlanficacion = acDescrPlanficacion;
    }

    public String getAcDescLogros() {
        return acDescLogros;
    }

    public void setAcDescLogros(String acDescLogros) {
        this.acDescLogros = acDescLogros;
    }

    public String getAcNomRespon() {
        return acNomRespon;
    }

    public void setAcNomRespon(String acNomRespon) {
        this.acNomRespon = acNomRespon;
    }

    public String getAcMeilRespon() {
        return acMeilRespon;
    }

    public void setAcMeilRespon(String acMeilRespon) {
        this.acMeilRespon = acMeilRespon;
    }

    public String getAcTelfRespon() {
        return acTelfRespon;
    }

    public void setAcTelfRespon(String acTelfRespon) {
        this.acTelfRespon = acTelfRespon;
    }

    public String getAcRepreTerri() {
        return acRepreTerri;
    }

    public void setAcRepreTerri(String acRepreTerri) {
        this.acRepreTerri = acRepreTerri;
    }

    public String getAcGrupEspe() {
        return acGrupEspe;
    }

    public void setAcGrupEspe(String acGrupEspe) {
        this.acGrupEspe = acGrupEspe;
    }

    public String getAcGrupPrio() {
        return acGrupPrio;
    }

    public void setAcGrupPrio(String acGrupPrio) {
        this.acGrupPrio = acGrupPrio;
    }

    public String getAcGremial() {
        return acGremial;
    }

    public void setAcGremial(String acGremial) {
        this.acGremial = acGremial;
    }

    public String getAcSocOrga() {
        return acSocOrga;
    }

    public void setAcSocOrga(String acSocOrga) {
        this.acSocOrga = acSocOrga;
    }

    public String getAcUnidParti() {
        return acUnidParti;
    }

    public void setAcUnidParti(String acUnidParti) {
        this.acUnidParti = acUnidParti;
    }

    public String getAcGrupEsta() {
        return acGrupEsta;
    }

    public void setAcGrupEsta(String acGrupEsta) {
        this.acGrupEsta = acGrupEsta;
    }

    public String getAcOtro() {
        return acOtro;
    }

    public void setAcOtro(String acOtro) {
        this.acOtro = acOtro;
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
        hash += (acCod != null ? acCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAsambleaCiudadana)) {
            return false;
        }
        TblAsambleaCiudadana other = (TblAsambleaCiudadana) object;
        if ((this.acCod == null && other.acCod != null) || (this.acCod != null && !this.acCod.equals(other.acCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblAsambleaCiudadana[ acCod=" + acCod + " ]";
    }
    
}
