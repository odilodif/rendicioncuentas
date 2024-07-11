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

import org.apache.commons.lang.StringEscapeUtils;

import gob.cpccs.utilidades.Constantes;

/**
 *
 * @author Wilmer Guamán
 */

	
@Entity
@Table(name = "tbl_sede", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSede.findAll", query = "SELECT t FROM TblSede t")
    , @NamedQuery(name = "TblSede.findBySeCod", query = "SELECT t FROM TblSede t WHERE t.seCod = :seCod")
    , @NamedQuery(name = "TblSede.findBySeNombre", query = "SELECT t FROM TblSede t WHERE t.seNombre = :seNombre")
    , @NamedQuery(name = "TblSede.findBySeProvincia", query = "SELECT t FROM TblSede t WHERE t.seProvincia = :seProvincia")
    , @NamedQuery(name = "TblSede.findBySeCanton", query = "SELECT t FROM TblSede t WHERE t.seCanton = :seCanton")
    , @NamedQuery(name = "TblSede.findBySeParroquia", query = "SELECT t FROM TblSede t WHERE t.seParroquia = :seParroquia")
    , @NamedQuery(name = "TblSede.findBySeDireccion", query = "SELECT t FROM TblSede t WHERE t.seDireccion = :seDireccion")
    , @NamedQuery(name = "TblSede.findBySeMail", query = "SELECT t FROM TblSede t WHERE t.seMail = :seMail")
    , @NamedQuery(name = "TblSede.findBySeWeb", query = "SELECT t FROM TblSede t WHERE t.seWeb = :seWeb")
    , @NamedQuery(name = "TblSede.findBySeRuc", query = "SELECT t FROM TblSede t WHERE t.seRuc = :seRuc")
    , @NamedQuery(name = "TblSede.findBySeRepresentante", query = "SELECT t FROM TblSede t WHERE t.seRepresentante = :seRepresentante")
    , @NamedQuery(name = "TblSede.findBySeCargo", query = "SELECT t FROM TblSede t WHERE t.seCargo = :seCargo")
    , @NamedQuery(name = "TblSede.findBySeDesignacion", query = "SELECT t FROM TblSede t WHERE t.seDesignacion = :seDesignacion")
    , @NamedQuery(name = "TblSede.findBySeMailrep", query = "SELECT t FROM TblSede t WHERE t.seMailrep = :seMailrep")
    , @NamedQuery(name = "TblSede.findBySeTelrep", query = "SELECT t FROM TblSede t WHERE t.seTelrep = :seTelrep")
    , @NamedQuery(name = "TblSede.findBySeUnidades", query = "SELECT t FROM TblSede t WHERE t.seUnidades = :seUnidades")
    , @NamedQuery(name = "TblSede.findBySeCobertura", query = "SELECT t FROM TblSede t WHERE t.seCobertura = :seCobertura")
    , @NamedQuery(name = "TblSede.findBySeEstudiantes", query = "SELECT t FROM TblSede t WHERE t.seEstudiantes = :seEstudiantes")
    , @NamedQuery(name = "TblSede.findBySeHombre", query = "SELECT t FROM TblSede t WHERE t.seHombre = :seHombre")
    , @NamedQuery(name = "TblSede.findBySeMujeres", query = "SELECT t FROM TblSede t WHERE t.seMujeres = :seMujeres")
    , @NamedQuery(name = "TblSede.findBySeGlbti", query = "SELECT t FROM TblSede t WHERE t.seGlbti = :seGlbti")
    , @NamedQuery(name = "TblSede.findBySeMontubios", query = "SELECT t FROM TblSede t WHERE t.seMontubios = :seMontubios")
    , @NamedQuery(name = "TblSede.findBySeMestizos", query = "SELECT t FROM TblSede t WHERE t.seMestizos = :seMestizos")
    , @NamedQuery(name = "TblSede.findBySeCholos", query = "SELECT t FROM TblSede t WHERE t.seCholos = :seCholos")
    , @NamedQuery(name = "TblSede.findBySeAfroecuatorianos", query = "SELECT t FROM TblSede t WHERE t.seAfroecuatorianos = :seAfroecuatorianos")
    , @NamedQuery(name = "TblSede.findBySeIndigenas", query = "SELECT t FROM TblSede t WHERE t.seIndigenas = :seIndigenas")
    , @NamedQuery(name = "TblSede.findBySeExtranjeros", query = "SELECT t FROM TblSede t WHERE t.seExtranjeros = :seExtranjeros")
    , @NamedQuery(name = "TblSede.findBySeDiscapacitados", query = "SELECT t FROM TblSede t WHERE t.seDiscapacitados = :seDiscapacitados")
    , @NamedQuery(name = "TblSede.findBySeLink", query = "SELECT t FROM TblSede t WHERE t.seLink = :seLink")})


public class TblSede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "se_cod", nullable = false)
    private Integer seCod;
    @Column(name = "se_nombre", length = 200)
    private String seNombre;
    @Column(name = "se_provincia")
    private Integer seProvincia;
    @Column(name = "se_canton")
    private Integer seCanton;
    @Column(name = "se_parroquia")
    private Integer seParroquia;
    @Column(name = "se_direccion", length = 200)
    private String seDireccion;
    @Column(name = "se_mail", length = 100)
    private String seMail;
    @Column(name = "se_web", length = 100)
    private String seWeb;
    @Column(name = "se_ruc", length = 100)
    private String seRuc;
    @Column(name = "se_representante", length = 100)
    private String seRepresentante;
    @Column(name = "se_cargo", length = 100)
    private String seCargo;
    @Column(name = "se_designacion")
   @Temporal(TemporalType.DATE)
    private Date seDesignacion;
    @Column(name = "se_mailrep", length = 200)
    private String seMailrep;
    @Column(name = "se_telrep", length = 20)
    private String seTelrep;
    @Column(name = "se_unidades")
    private Integer seUnidades;
    @Column(name = "se_cobertura")
    private String seCobertura;
    @Column(name = "se_estudiantes")
    private Integer seEstudiantes;
    @Column(name = "se_hombre")
    private Integer seHombre;
    @Column(name = "se_mujeres")
    private Integer seMujeres;
    @Column(name = "se_glbti")
    private Integer seGlbti;
    @Column(name = "se_montubios")
    private Integer seMontubios;
    @Column(name = "se_mestizos")
    private Integer seMestizos;
    @Column(name = "se_cholos")
    private Integer seCholos;
    @Column(name = "se_afroecuatorianos")
    private Integer seAfroecuatorianos;
    @Column(name = "se_indigenas")
    private Integer seIndigenas;
    @Column(name = "se_extranjeros")
    private Integer seExtranjeros;
    @Column(name = "se_discapacitados")
    private Integer seDiscapacitados;
    @Column(name = "se_link", length = 100)
    private String seLink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblSede() {
    }

    public TblSede(Integer seCod) {
        this.seCod = seCod;
    }

    public Integer getSeCod() {
        return seCod;
    }

    public void setSeCod(Integer seCod) {
        this.seCod = seCod;
    }

    public String getSeNombre() {
        return seNombre;
    }

    public void setSeNombre(String seNombre) {
        this.seNombre = seNombre;
    }

    public Integer getSeProvincia() {
        return seProvincia;
    }

    public void setSeProvincia(Integer seProvincia) {
        this.seProvincia = seProvincia;
    }

    public Integer getSeCanton() {
        return seCanton;
    }

    public void setSeCanton(Integer seCanton) {
        this.seCanton = seCanton;
    }

    public Integer getSeParroquia() {
        return seParroquia;
    }

    public void setSeParroquia(Integer seParroquia) {
        this.seParroquia = seParroquia;
    }

    public String getSeDireccion() {
        return seDireccion;
    }

    public void setSeDireccion(String seDireccion) {
        this.seDireccion = seDireccion;
    }

    public String getSeMail() {
        return seMail;
    }

    public void setSeMail(String seMail) {
        this.seMail = seMail;
    }

    public String getSeWeb() {
        return seWeb;
    }

    public void setSeWeb(String seWeb) {
        this.seWeb = seWeb;
    }

    public String getSeRuc() {
        return seRuc;
    }

    public void setSeRuc(String seRuc) {
        this.seRuc = seRuc;
    }

    public String getSeRepresentante() {
        return seRepresentante;
    }

    public void setSeRepresentante(String seRepresentante) {
        this.seRepresentante = seRepresentante;
    }

    public String getSeCargo() {
        return seCargo;
    }

    public void setSeCargo(String seCargo) {
        this.seCargo = seCargo;
    }

    public Date getSeDesignacion() {
        return seDesignacion;
    }

    public void setSeDesignacion(Date seDesignacion) {
        this.seDesignacion = seDesignacion;
    }

    public String getSeMailrep() {
        return seMailrep;
    }

    public void setSeMailrep(String seMailrep) {
        this.seMailrep = seMailrep;
    }

    public String getSeTelrep() {
        return seTelrep;
    }

    public void setSeTelrep(String seTelrep) {
        this.seTelrep = seTelrep;
    }

    public Integer getSeUnidades() {
        return seUnidades;
    }

    public void setSeUnidades(Integer seUnidades) {
        this.seUnidades = seUnidades;
    }

    public String getSeCobertura() {
        return seCobertura;
    }

    public void setSeCobertura(String seCobertura) {
        this.seCobertura = seCobertura;
    }

    public Integer getSeEstudiantes() {
        return seEstudiantes;
    }

    public void setSeEstudiantes(Integer seEstudiantes) {
        this.seEstudiantes = seEstudiantes;
    }

    public Integer getSeHombre() {
        return seHombre;
    }

    public void setSeHombre(Integer seHombre) {
        this.seHombre = seHombre;
    }

    public Integer getSeMujeres() {
        return seMujeres;
    }

    public void setSeMujeres(Integer seMujeres) {
        this.seMujeres = seMujeres;
    }

    public Integer getSeGlbti() {
        return seGlbti;
    }

    public void setSeGlbti(Integer seGlbti) {
        this.seGlbti = seGlbti;
    }

    public Integer getSeMontubios() {
        return seMontubios;
    }

    public void setSeMontubios(Integer seMontubios) {
        this.seMontubios = seMontubios;
    }

    public Integer getSeMestizos() {
        return seMestizos;
    }

    public void setSeMestizos(Integer seMestizos) {
        this.seMestizos = seMestizos;
    }

    public Integer getSeCholos() {
        return seCholos;
    }

    public void setSeCholos(Integer seCholos) {
        this.seCholos = seCholos;
    }

    public Integer getSeAfroecuatorianos() {
        return seAfroecuatorianos;
    }

    public void setSeAfroecuatorianos(Integer seAfroecuatorianos) {
        this.seAfroecuatorianos = seAfroecuatorianos;
    }

    public Integer getSeIndigenas() {
        return seIndigenas;
    }

    public void setSeIndigenas(Integer seIndigenas) {
        this.seIndigenas = seIndigenas;
    }

    public Integer getSeExtranjeros() {
        return seExtranjeros;
    }

    public void setSeExtranjeros(Integer seExtranjeros) {
        this.seExtranjeros = seExtranjeros;
    }

    public Integer getSeDiscapacitados() {
        return seDiscapacitados;
    }

    public void setSeDiscapacitados(Integer seDiscapacitados) {
        this.seDiscapacitados = seDiscapacitados;
    }

    public String getSeLink() {
        return seLink;
    }

    public void setSeLink(String seLink) {
        this.seLink = seLink;
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
        hash += (seCod != null ? seCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSede)) {
            return false;
        }
        TblSede other = (TblSede) object;
        if ((this.seCod == null && other.seCod != null) || (this.seCod != null && !this.seCod.equals(other.seCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblSede[ seCod=" + seCod + " ]";
    }
    
}
