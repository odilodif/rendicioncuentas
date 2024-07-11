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
@Table(name = "tbl_implementacion_presupuesto", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblImplementacionPresupuesto.findAll", query = "SELECT t FROM TblImplementacionPresupuesto t")
    , @NamedQuery(name = "TblImplementacionPresupuesto.findByImpleCod", query = "SELECT t FROM TblImplementacionPresupuesto t WHERE t.impleCod = :impleCod")
    , @NamedQuery(name = "TblImplementacionPresupuesto.findByImpleOpc", query = "SELECT t FROM TblImplementacionPresupuesto t WHERE t.impleOpc = :impleOpc")
    , @NamedQuery(name = "TblImplementacionPresupuesto.findByImplePorce", query = "SELECT t FROM TblImplementacionPresupuesto t WHERE t.implePorce = :implePorce")
    , @NamedQuery(name = "TblImplementacionPresupuesto.findByImpleGrupo", query = "SELECT t FROM TblImplementacionPresupuesto t WHERE t.impleGrupo = :impleGrupo")
    , @NamedQuery(name = "TblImplementacionPresupuesto.findByImplePorcengrupo", query = "SELECT t FROM TblImplementacionPresupuesto t WHERE t.implePorcengrupo = :implePorcengrupo")
    , @NamedQuery(name = "TblImplementacionPresupuesto.findByImpleEstado", query = "SELECT t FROM TblImplementacionPresupuesto t WHERE t.impleEstado = :impleEstado")})
public class TblImplementacionPresupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "imple_cod", nullable = false)
    private Integer impleCod;
    @Column(name = "imple_opc", length = 5)
    private String impleOpc;
    @Column(name = "imple_porce", length = 10)
    private String implePorce;
    @Column(name = "imple_grupo", length = 200)
    private String impleGrupo;
    @Column(name = "imple_porcengrupo", length = 10)
    private String implePorcengrupo;
    @Column(name = "imple_estado", length = 15)
    private String impleEstado;
    @JoinColumn(name = "info_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infoCod;

    public TblImplementacionPresupuesto() {
    }

    public TblImplementacionPresupuesto(Integer impleCod) {
        this.impleCod = impleCod;
    }

    public Integer getImpleCod() {
        return impleCod;
    }

    public void setImpleCod(Integer impleCod) {
        this.impleCod = impleCod;
    }

    public String getImpleOpc() {
        return impleOpc;
    }

    public void setImpleOpc(String impleOpc) {
        this.impleOpc = impleOpc;
    }

    public String getImplePorce() {
        return implePorce;
    }

    public void setImplePorce(String implePorce) {
        this.implePorce = implePorce;
    }

    public String getImpleGrupo() {
        return impleGrupo;
    }

    public void setImpleGrupo(String impleGrupo) {
        this.impleGrupo = impleGrupo;
    }

    public String getImplePorcengrupo() {
        return implePorcengrupo;
    }

    public void setImplePorcengrupo(String implePorcengrupo) {
        this.implePorcengrupo = implePorcengrupo;
    }

    public String getImpleEstado() {
        return impleEstado;
    }

    public void setImpleEstado(String impleEstado) {
        this.impleEstado = impleEstado;
    }

    public TblInforme getInfoCod() {
        return infoCod;
    }

    public void setInfoCod(TblInforme infoCod) {
        this.infoCod = infoCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (impleCod != null ? impleCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblImplementacionPresupuesto)) {
            return false;
        }
        TblImplementacionPresupuesto other = (TblImplementacionPresupuesto) object;
        if ((this.impleCod == null && other.impleCod != null) || (this.impleCod != null && !this.impleCod.equals(other.impleCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblImplementacionPresupuesto[ impleCod=" + impleCod + " ]";
    }
    
}
