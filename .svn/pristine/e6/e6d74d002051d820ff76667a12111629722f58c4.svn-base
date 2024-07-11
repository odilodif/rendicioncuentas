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

import org.apache.commons.lang.StringEscapeUtils;

import gob.cpccs.utilidades.Constantes;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_procesos_contratacion", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProcesosContratacion.findAll", query = "SELECT t FROM TblProcesosContratacion t")
    , @NamedQuery(name = "TblProcesosContratacion.findByPcoCod", query = "SELECT t FROM TblProcesosContratacion t WHERE t.pcoCod = :pcoCod")
    , @NamedQuery(name = "TblProcesosContratacion.findByPcoTipoContrat", query = "SELECT t FROM TblProcesosContratacion t WHERE t.pcoTipoContrat = :pcoTipoContrat")
    , @NamedQuery(name = "TblProcesosContratacion.findByPcoNumeroAdj", query = "SELECT t FROM TblProcesosContratacion t WHERE t.pcoNumeroAdj = :pcoNumeroAdj")
    , @NamedQuery(name = "TblProcesosContratacion.findByPcoValorAdj", query = "SELECT t FROM TblProcesosContratacion t WHERE t.pcoValorAdj = :pcoValorAdj")
    , @NamedQuery(name = "TblProcesosContratacion.findByPcoNumeroFin", query = "SELECT t FROM TblProcesosContratacion t WHERE t.pcoNumeroFin = :pcoNumeroFin")
    , @NamedQuery(name = "TblProcesosContratacion.findByPcoValorFin", query = "SELECT t FROM TblProcesosContratacion t WHERE t.pcoValorFin = :pcoValorFin")
    , @NamedQuery(name = "TblProcesosContratacion.findByPcoLink", query = "SELECT t FROM TblProcesosContratacion t WHERE t.pcoLink = :pcoLink")})
public class TblProcesosContratacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pco_cod", nullable = false)
    private Integer pcoCod;
    @Column(name = "pco_tipo_contrat", length = 200)
    private String pcoTipoContrat;
    @Column(name = "pco_numero_adj")
    private Integer pcoNumeroAdj;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pco_valor_adj", precision = 18, scale = 2)
    private BigDecimal pcoValorAdj;
    @Column(name = "pco_numero_fin")
    private Integer pcoNumeroFin;
    @Column(name = "pco_valor_fin", precision = 16, scale = 2)
    private BigDecimal pcoValorFin;
    @Column(name = "pco_link", length = 500)
    private String pcoLink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblProcesosContratacion() {
    }

    public TblProcesosContratacion(Integer pcoCod) {
        this.pcoCod = pcoCod;
    }

    public Integer getPcoCod() {
        return pcoCod;
    }

    public void setPcoCod(Integer pcoCod) {
        this.pcoCod = pcoCod;
    }

    public String getPcoTipoContrat() {
        return pcoTipoContrat;
    }

    public void setPcoTipoContrat(String pcoTipoContrat) {
        this.pcoTipoContrat = pcoTipoContrat;
    }

    public Integer getPcoNumeroAdj() {
        return pcoNumeroAdj;
    }

    public void setPcoNumeroAdj(Integer pcoNumeroAdj) {
        this.pcoNumeroAdj = pcoNumeroAdj;
    }

    public BigDecimal getPcoValorAdj() {
        return pcoValorAdj;
    }

    public void setPcoValorAdj(BigDecimal pcoValorAdj) {
        this.pcoValorAdj = pcoValorAdj;
    }

    public Integer getPcoNumeroFin() {
        return pcoNumeroFin;
    }

    public void setPcoNumeroFin(Integer pcoNumeroFin) {
        this.pcoNumeroFin = pcoNumeroFin;
    }

    public BigDecimal getPcoValorFin() {
        return pcoValorFin;
    }

    public void setPcoValorFin(BigDecimal pcoValorFin) {
        this.pcoValorFin = pcoValorFin;
    }

    public String getPcoLink() {
        return pcoLink;
    }

    public void setPcoLink(String pcoLink) {
        this.pcoLink = pcoLink;
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
        hash += (pcoCod != null ? pcoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProcesosContratacion)) {
            return false;
        }
        TblProcesosContratacion other = (TblProcesosContratacion) object;
        if ((this.pcoCod == null && other.pcoCod != null) || (this.pcoCod != null && !this.pcoCod.equals(other.pcoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblProcesosContratacion[ pcoCod=" + pcoCod + " ]";
    }
    
}
