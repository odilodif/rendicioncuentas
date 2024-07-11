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

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_cobertura_geografica", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCoberturaGeografica.findAll", query = "SELECT t FROM TblCoberturaGeografica t")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgCod", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgCod = :cgCod")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgTipocobertura", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgTipocobertura = :cgTipocobertura")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgDescCobertura", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgDescCobertura = :cgDescCobertura")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgCantidad", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgCantidad = :cgCantidad")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgHombres", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgHombres = :cgHombres")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgMujeres", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgMujeres = :cgMujeres")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgGlbti", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgGlbti = :cgGlbti")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgMontubios", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgMontubios = :cgMontubios")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgMestizos", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgMestizos = :cgMestizos")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgCholos", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgCholos = :cgCholos")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgIndigenas", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgIndigenas = :cgIndigenas")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgAfroecuatoriano", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgAfroecuatoriano = :cgAfroecuatoriano")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgLink", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgLink = :cgLink")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgDiscapacitado", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgDiscapacitado = :cgDiscapacitado")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgExtanjeros", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgExtanjeros = :cgExtanjeros")
    , @NamedQuery(name = "TblCoberturaGeografica.findByCgTotal", query = "SELECT t FROM TblCoberturaGeografica t WHERE t.cgTotal = :cgTotal")})
public class TblCoberturaGeografica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cg_cod", nullable = false)
    private Integer cgCod;
    @Column(name = "cg_tipocobertura", length = 800)
    private String cgTipocobertura;
    @Column(name = "cg_desc_cobertura", length = 800)
    private String cgDescCobertura;
    @Column(name = "cg_cantidad")
    private Integer cgCantidad;
    @Column(name = "cg_hombres")
    private Integer cgHombres;
    @Column(name = "cg_mujeres")
    private Integer cgMujeres;
    @Column(name = "cg_glbti")
    private Integer cgGlbti;
    @Column(name = "cg_montubios")
    private Integer cgMontubios;
    @Column(name = "cg_mestizos")
    private Integer cgMestizos;
    @Column(name = "cg_cholos")
    private Integer cgCholos;
    @Column(name = "cg_indigenas")
    private Integer cgIndigenas;
    @Column(name = "cg_afroecuatoriano")
    private Integer cgAfroecuatoriano;
    @Column(name = "cg_link", length = 255)
    private String cgLink;
    @Column(name = "cg_discapacitado")
    private Integer cgDiscapacitado;
    @Column(name = "cg_extanjeros")
    private Integer cgExtanjeros;
    @Column(name = "cg_total")
    private Integer cgTotal;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblCoberturaGeografica() {
    }

    public TblCoberturaGeografica(Integer cgCod) {
        this.cgCod = cgCod;
    }

    public Integer getCgCod() {
        return cgCod;
    }

    public void setCgCod(Integer cgCod) {
        this.cgCod = cgCod;
    }

    public String getCgTipocobertura() {
        return cgTipocobertura;
    }

    public void setCgTipocobertura(String cgTipocobertura) {
        this.cgTipocobertura = cgTipocobertura;
    }

    public String getCgDescCobertura() {
        return cgDescCobertura;
    }

    public void setCgDescCobertura(String cgDescCobertura) {
        this.cgDescCobertura = cgDescCobertura;
    }

    public Integer getCgCantidad() {
        return cgCantidad;
    }

    public void setCgCantidad(Integer cgCantidad) {
        this.cgCantidad = cgCantidad;
    }

    public Integer getCgHombres() {
        return cgHombres;
    }

    public void setCgHombres(Integer cgHombres) {
        this.cgHombres = cgHombres;
    }

    public Integer getCgMujeres() {
        return cgMujeres;
    }

    public void setCgMujeres(Integer cgMujeres) {
        this.cgMujeres = cgMujeres;
    }

    public Integer getCgGlbti() {
        return cgGlbti;
    }

    public void setCgGlbti(Integer cgGlbti) {
        this.cgGlbti = cgGlbti;
    }

    public Integer getCgMontubios() {
        return cgMontubios;
    }

    public void setCgMontubios(Integer cgMontubios) {
        this.cgMontubios = cgMontubios;
    }

    public Integer getCgMestizos() {
        return cgMestizos;
    }

    public void setCgMestizos(Integer cgMestizos) {
        this.cgMestizos = cgMestizos;
    }

    public Integer getCgCholos() {
        return cgCholos;
    }

    public void setCgCholos(Integer cgCholos) {
        this.cgCholos = cgCholos;
    }

    public Integer getCgIndigenas() {
        return cgIndigenas;
    }

    public void setCgIndigenas(Integer cgIndigenas) {
        this.cgIndigenas = cgIndigenas;
    }

    public Integer getCgAfroecuatoriano() {
        return cgAfroecuatoriano;
    }

    public void setCgAfroecuatoriano(Integer cgAfroecuatoriano) {
        this.cgAfroecuatoriano = cgAfroecuatoriano;
    }

    public String getCgLink() {
        return cgLink;
    }

    public void setCgLink(String cgLink) {
        this.cgLink = cgLink;
    }

    public Integer getCgDiscapacitado() {
        return cgDiscapacitado;
    }

    public void setCgDiscapacitado(Integer cgDiscapacitado) {
        this.cgDiscapacitado = cgDiscapacitado;
    }

    public Integer getCgExtanjeros() {
        return cgExtanjeros;
    }

    public void setCgExtanjeros(Integer cgExtanjeros) {
        this.cgExtanjeros = cgExtanjeros;
    }

    public Integer getCgTotal() {
        return cgTotal;
    }

    public void setCgTotal(Integer cgTotal) {
        this.cgTotal = cgTotal;
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
        hash += (cgCod != null ? cgCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCoberturaGeografica)) {
            return false;
        }
        TblCoberturaGeografica other = (TblCoberturaGeografica) object;
        if ((this.cgCod == null && other.cgCod != null) || (this.cgCod != null && !this.cgCod.equals(other.cgCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblCoberturaGeografica[ cgCod=" + cgCod + " ]";
    }
    
}
