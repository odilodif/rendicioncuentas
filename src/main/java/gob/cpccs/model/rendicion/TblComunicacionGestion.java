/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_comunicacion_gestion", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblComunicacionGestion.findAll", query = "SELECT t FROM TblComunicacionGestion t")
    , @NamedQuery(name = "TblComunicacionGestion.findByCgCod", query = "SELECT t FROM TblComunicacionGestion t WHERE t.cgCod = :cgCod")
    , @NamedQuery(name = "TblComunicacionGestion.findByCgNombre", query = "SELECT t FROM TblComunicacionGestion t WHERE t.cgNombre = :cgNombre")
    , @NamedQuery(name = "TblComunicacionGestion.findByCgNumero", query = "SELECT t FROM TblComunicacionGestion t WHERE t.cgNumero = :cgNumero")
    , @NamedQuery(name = "TblComunicacionGestion.findByCgPorlocales", query = "SELECT t FROM TblComunicacionGestion t WHERE t.cgPorlocales = :cgPorlocales")
    , @NamedQuery(name = "TblComunicacionGestion.findByCgPornacionales", query = "SELECT t FROM TblComunicacionGestion t WHERE t.cgPornacionales = :cgPornacionales")
    , @NamedQuery(name = "TblComunicacionGestion.findByCgPorinternacional", query = "SELECT t FROM TblComunicacionGestion t WHERE t.cgPorinternacional = :cgPorinternacional")
    , @NamedQuery(name = "TblComunicacionGestion.findByCgMedioverif", query = "SELECT t FROM TblComunicacionGestion t WHERE t.cgMedioverif = :cgMedioverif")})
public class TblComunicacionGestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cg_cod", nullable = false)
    private Integer cgCod;
    @Column(name = "cg_nombre", length = 200)
    private String cgNombre;
    @Column(name = "cg_numero")
    private Integer cgNumero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cg_porlocales", precision = 18, scale = 2)
    private BigDecimal cgPorlocales;
    @Column(name = "cg_pornacionales", precision = 18, scale = 2)
    private BigDecimal cgPornacionales;
    @Column(name = "cg_porinternacional", precision = 18, scale = 2)
    private BigDecimal cgPorinternacional;
    @Column(name = "cg_medioverif", length = 200)
    private String cgMedioverif;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cgCod")
    private List<TblDetalleComunicagestion> tblDetalleComunicagestionList;

    public TblComunicacionGestion() {
    }

    public TblComunicacionGestion(Integer cgCod) {
        this.cgCod = cgCod;
    }

    public Integer getCgCod() {
        return cgCod;
    }

    public void setCgCod(Integer cgCod) {
        this.cgCod = cgCod;
    }

    public String getCgNombre() {
        return cgNombre;
    }

    public void setCgNombre(String cgNombre) {
        this.cgNombre = cgNombre;
    }

    public Integer getCgNumero() {
        return cgNumero;
    }

    public void setCgNumero(Integer cgNumero) {
        this.cgNumero = cgNumero;
    }

    public BigDecimal getCgPorlocales() {
        return cgPorlocales;
    }

    public void setCgPorlocales(BigDecimal cgPorlocales) {
        this.cgPorlocales = cgPorlocales;
    }

    public BigDecimal getCgPornacionales() {
        return cgPornacionales;
    }

    public void setCgPornacionales(BigDecimal cgPornacionales) {
        this.cgPornacionales = cgPornacionales;
    }

    public BigDecimal getCgPorinternacional() {
        return cgPorinternacional;
    }

    public void setCgPorinternacional(BigDecimal cgPorinternacional) {
        this.cgPorinternacional = cgPorinternacional;
    }

    public String getCgMedioverif() {
        return cgMedioverif;
    }

    public void setCgMedioverif(String cgMedioverif) {
        this.cgMedioverif = cgMedioverif;
    }

    public TblInforme getInfCod() {
        return infCod;
    }

    public void setInfCod(TblInforme infCod) {
        this.infCod = infCod;
    }

    @XmlTransient
    public List<TblDetalleComunicagestion> getTblDetalleComunicagestionList() {
        return tblDetalleComunicagestionList;
    }

    public void setTblDetalleComunicagestionList(List<TblDetalleComunicagestion> tblDetalleComunicagestionList) {
        this.tblDetalleComunicagestionList = tblDetalleComunicagestionList;
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
        if (!(object instanceof TblComunicacionGestion)) {
            return false;
        }
        TblComunicacionGestion other = (TblComunicacionGestion) object;
        if ((this.cgCod == null && other.cgCod != null) || (this.cgCod != null && !this.cgCod.equals(other.cgCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblComunicacionGestion[ cgCod=" + cgCod + " ]";
    }
    
}
