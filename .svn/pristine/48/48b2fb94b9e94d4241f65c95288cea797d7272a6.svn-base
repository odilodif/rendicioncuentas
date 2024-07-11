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

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_negar_autoridad", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNegarAutoridad.findAll", query = "SELECT t FROM TblNegarAutoridad t")
    , @NamedQuery(name = "TblNegarAutoridad.findByNegaCod", query = "SELECT t FROM TblNegarAutoridad t WHERE t.negaCod = :negaCod")
    , @NamedQuery(name = "TblNegarAutoridad.findByAutNom", query = "SELECT t FROM TblNegarAutoridad t WHERE t.autNom = :autNom")
    , @NamedQuery(name = "TblNegarAutoridad.findByNegaObs", query = "SELECT t FROM TblNegarAutoridad t WHERE t.negaObs = :negaObs")
    , @NamedQuery(name = "TblNegarAutoridad.findByAutCed", query = "SELECT t FROM TblNegarAutoridad t WHERE t.autCed = :autCed")
    , @NamedQuery(name = "TblNegarAutoridad.findByNegaFec", query = "SELECT t FROM TblNegarAutoridad t WHERE t.negaFec = :negaFec")
    , @NamedQuery(name = "TblNegarAutoridad.findByNegaTipo", query = "SELECT t FROM TblNegarAutoridad t WHERE t.negaTipo = :negaTipo")})
public class TblNegarAutoridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nega_cod", nullable = false)
    private Integer negaCod;
    @Column(name = "aut_nom", length = 255)
    private String autNom;
    @Column(name = "nega_obs", length = 500)
    private String negaObs;
    @Column(name = "aut_ced", length = 15)
    private String autCed;
    @Column(name = "nega_fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date negaFec;
    @Column(name = "nega_tipo", length = 50)
    private String negaTipo;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod")
    @ManyToOne(optional = false)
    private TblInformeAutoridad infAutCod;
    @Column(name = "identificadortecnico", length = 15)
    private String identificadortecnico;
    
    public String getIdentificadortecnico() {
		return identificadortecnico;
	}

	public void setIdentificadortecnico(String identificadortecnico) {
		this.identificadortecnico = identificadortecnico;
	}

	public TblNegarAutoridad() {
    }

    public TblNegarAutoridad(Integer negaCod) {
        this.negaCod = negaCod;
    }

    public Integer getNegaCod() {
        return negaCod;
    }

    public void setNegaCod(Integer negaCod) {
        this.negaCod = negaCod;
    }

    public String getAutNom() {
        return autNom;
    }

    public void setAutNom(String autNom) {
        this.autNom = autNom;
    }

    public String getNegaObs() {
        return negaObs;
    }

    public void setNegaObs(String negaObs) {
        this.negaObs = negaObs;
    }

    public String getAutCed() {
        return autCed;
    }

    public void setAutCed(String autCed) {
        this.autCed = autCed;
    }

    public Date getNegaFec() {
        return negaFec;
    }

    public void setNegaFec(Date negaFec) {
        this.negaFec = negaFec;
    }

    public String getNegaTipo() {
        return negaTipo;
    }

    public void setNegaTipo(String negaTipo) {
        this.negaTipo = negaTipo;
    }

    public TblInformeAutoridad getInfAutCod() {
        return infAutCod;
    }

    public void setInfAutCod(TblInformeAutoridad infAutCod) {
        this.infAutCod = infAutCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (negaCod != null ? negaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNegarAutoridad)) {
            return false;
        }
        TblNegarAutoridad other = (TblNegarAutoridad) object;
        if ((this.negaCod == null && other.negaCod != null) || (this.negaCod != null && !this.negaCod.equals(other.negaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblNegarAutoridad[ negaCod=" + negaCod + " ]";
    }
    
}
