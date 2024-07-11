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
@Table(name = "tbl_anteproyecto_presupuesto", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAnteproyectoPresupuesto.findAll", query = "SELECT t FROM TblAnteproyectoPresupuesto t")
    , @NamedQuery(name = "TblAnteproyectoPresupuesto.findByAnteCod", query = "SELECT t FROM TblAnteproyectoPresupuesto t WHERE t.anteCod = :anteCod")
    , @NamedQuery(name = "TblAnteproyectoPresupuesto.findByAnteNom", query = "SELECT t FROM TblAnteproyectoPresupuesto t WHERE t.anteNom = :anteNom")
    , @NamedQuery(name = "TblAnteproyectoPresupuesto.findByAnteOpc", query = "SELECT t FROM TblAnteproyectoPresupuesto t WHERE t.anteOpc = :anteOpc")
    , @NamedQuery(name = "TblAnteproyectoPresupuesto.findByAnteFecha", query = "SELECT t FROM TblAnteproyectoPresupuesto t WHERE t.anteFecha = :anteFecha")
    , @NamedQuery(name = "TblAnteproyectoPresupuesto.findByAnteDescrip", query = "SELECT t FROM TblAnteproyectoPresupuesto t WHERE t.anteDescrip = :anteDescrip")
    , @NamedQuery(name = "TblAnteproyectoPresupuesto.findByAnteTipo", query = "SELECT t FROM TblAnteproyectoPresupuesto t WHERE t.anteTipo = :anteTipo")
    , @NamedQuery(name = "TblAnteproyectoPresupuesto.findByAnteEstado", query = "SELECT t FROM TblAnteproyectoPresupuesto t WHERE t.anteEstado = :anteEstado")})
public class TblAnteproyectoPresupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ante_cod", nullable = false)
    private Integer anteCod;
    @Column(name = "ante_nom", length = 200)
    private String anteNom;
    @Column(name = "ante_opc", length = 2147483647)
    private String anteOpc;
    @Column(name = "ante_fecha")
    @Temporal(TemporalType.DATE)
    private Date anteFecha;
    @Column(name = "ante_descrip", length = 2147483647)
    private String anteDescrip;
    @Column(name = "ante_tipo", length = 20)
    private String anteTipo;
    @Column(name = "ante_estado", length = 15)
    private String anteEstado;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblAnteproyectoPresupuesto() {
    }

    public TblAnteproyectoPresupuesto(Integer anteCod) {
        this.anteCod = anteCod;
    }

    public Integer getAnteCod() {
        return anteCod;
    }

    public void setAnteCod(Integer anteCod) {
        this.anteCod = anteCod;
    }

    public String getAnteNom() {
        return anteNom;
    }

    public void setAnteNom(String anteNom) {
        this.anteNom = anteNom;
    }

    public String getAnteOpc() {
        return anteOpc;
    }

    public void setAnteOpc(String anteOpc) {
        this.anteOpc = anteOpc;
    }

    public Date getAnteFecha() {
        return anteFecha;
    }

    public void setAnteFecha(Date anteFecha) {
        this.anteFecha = anteFecha;
    }

    public String getAnteDescrip() {
        return anteDescrip;
    }

    public void setAnteDescrip(String anteDescrip) {
        this.anteDescrip = anteDescrip;
    }

    public String getAnteTipo() {
        return anteTipo;
    }

    public void setAnteTipo(String anteTipo) {
        this.anteTipo = anteTipo;
    }

    public String getAnteEstado() {
        return anteEstado;
    }

    public void setAnteEstado(String anteEstado) {
        this.anteEstado = anteEstado;
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
        hash += (anteCod != null ? anteCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAnteproyectoPresupuesto)) {
            return false;
        }
        TblAnteproyectoPresupuesto other = (TblAnteproyectoPresupuesto) object;
        if ((this.anteCod == null && other.anteCod != null) || (this.anteCod != null && !this.anteCod.equals(other.anteCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblAnteproyectoPresupuesto[ anteCod=" + anteCod + " ]";
    }
    
}
