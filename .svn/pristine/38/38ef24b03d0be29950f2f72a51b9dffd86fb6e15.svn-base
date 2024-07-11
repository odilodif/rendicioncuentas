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
@Table(name = "tbl_cobertura_institucional", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCoberturaInstitucional.findAll", query = "SELECT t FROM TblCoberturaInstitucional t")
    , @NamedQuery(name = "TblCoberturaInstitucional.findByCiCod", query = "SELECT t FROM TblCoberturaInstitucional t WHERE t.ciCod = :ciCod")
    , @NamedQuery(name = "TblCoberturaInstitucional.findByInstCod", query = "SELECT t FROM TblCoberturaInstitucional t WHERE t.instCod = :instCod")
    , @NamedQuery(name = "TblCoberturaInstitucional.findByCiNombre", query = "SELECT t FROM TblCoberturaInstitucional t WHERE t.ciNombre = :ciNombre")
    , @NamedQuery(name = "TblCoberturaInstitucional.findByCiDetalle", query = "SELECT t FROM TblCoberturaInstitucional t WHERE t.ciDetalle = :ciDetalle")})
public class TblCoberturaInstitucional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ci_cod", nullable = false)
    private Integer ciCod;
    @Basic(optional = false)
    @Column(name = "inst_cod", nullable = false)
    private int instCod;
    @Column(name = "ci_nombre", length = 200)
    private String ciNombre;
    @Column(name = "ci_detalle", length = 400)
    private String ciDetalle;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;
    @Column(name = "ci_estado", length = 15)
    private String ciestado;
    public TblCoberturaInstitucional() {
    }

    public TblCoberturaInstitucional(Integer ciCod) {
        this.ciCod = ciCod;
    }

    public TblCoberturaInstitucional(Integer ciCod, int instCod) {
        this.ciCod = ciCod;
        this.instCod = instCod;
    }

    public Integer getCiCod() {
        return ciCod;
    }

    public void setCiCod(Integer ciCod) {
        this.ciCod = ciCod;
    }

    public int getInstCod() {
        return instCod;
    }

    public void setInstCod(int instCod) {
        this.instCod = instCod;
    }

    public String getCiNombre() {
        return ciNombre;
    }

    public void setCiNombre(String ciNombre) {
        this.ciNombre = ciNombre;
    }

    public String getCiDetalle() {
        return ciDetalle;
    }

    public void setCiDetalle(String ciDetalle) {
        this.ciDetalle = ciDetalle;
    }

    public TblInforme getInfCod() {
        return infCod;
    }

    public void setInfCod(TblInforme infCod) {
        this.infCod = infCod;
    }

    
    public String getCCiestado() {
        return ciestado;
    }

    public void setCiestado(String ciestado) {
        this.ciestado = ciestado;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciCod != null ? ciCod.hashCode() : 0);
        return hash;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCoberturaInstitucional)) {
            return false;
        }
        TblCoberturaInstitucional other = (TblCoberturaInstitucional) object;
        if ((this.ciCod == null && other.ciCod != null) || (this.ciCod != null && !this.ciCod.equals(other.ciCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblCoberturaInstitucional[ ciCod=" + ciCod + " ]";
    }
    
}
