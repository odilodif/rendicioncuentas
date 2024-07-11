/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tbl_detalle_comunicagestion", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleComunicagestion.findAll", query = "SELECT t FROM TblDetalleComunicagestion t")
    , @NamedQuery(name = "TblDetalleComunicagestion.findByCgCod2", query = "SELECT t FROM TblDetalleComunicagestion t WHERE t.cgCod2 = :cgCod2")
    , @NamedQuery(name = "TblDetalleComunicagestion.findByDcNombre", query = "SELECT t FROM TblDetalleComunicagestion t WHERE t.dcNombre = :dcNombre")
    , @NamedQuery(name = "TblDetalleComunicagestion.findByDcMonto", query = "SELECT t FROM TblDetalleComunicagestion t WHERE t.dcMonto = :dcMonto")
    , @NamedQuery(name = "TblDetalleComunicagestion.findByDcMinutos", query = "SELECT t FROM TblDetalleComunicagestion t WHERE t.dcMinutos = :dcMinutos")})
public class TblDetalleComunicagestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cg_cod2", nullable = false)
    private Integer cgCod2;
    @Column(name = "dc_nombre", length = 3000)
    private String dcNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dc_monto", precision = 18, scale = 2)
    private BigDecimal dcMonto;
    @Column(name = "dc_minutos", length = 200)
    private String dcMinutos;
    @JoinColumn(name = "cg_cod", referencedColumnName = "cg_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblComunicacionGestion cgCod;

    public TblDetalleComunicagestion() {
    }

    public TblDetalleComunicagestion(Integer cgCod2) {
        this.cgCod2 = cgCod2;
    }

    public Integer getCgCod2() {
        return cgCod2;
    }

    public void setCgCod2(Integer cgCod2) {
        this.cgCod2 = cgCod2;
    }

    public String getDcNombre() {
        return dcNombre;
    }

    public void setDcNombre(String dcNombre) {
        this.dcNombre = dcNombre;
    }

    public BigDecimal getDcMonto() {
        return dcMonto;
    }

    public void setDcMonto(BigDecimal dcMonto) {
        this.dcMonto = dcMonto;
    }

    public String getDcMinutos() {
        return dcMinutos;
    }

    public void setDcMinutos(String dcMinutos) {
        this.dcMinutos = dcMinutos;
    }

    public TblComunicacionGestion getCgCod() {
        return cgCod;
    }

    public void setCgCod(TblComunicacionGestion cgCod) {
        this.cgCod = cgCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cgCod2 != null ? cgCod2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleComunicagestion)) {
            return false;
        }
        TblDetalleComunicagestion other = (TblDetalleComunicagestion) object;
        if ((this.cgCod2 == null && other.cgCod2 != null) || (this.cgCod2 != null && !this.cgCod2.equals(other.cgCod2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblDetalleComunicagestion[ cgCod2=" + cgCod2 + " ]";
    }
    
}
