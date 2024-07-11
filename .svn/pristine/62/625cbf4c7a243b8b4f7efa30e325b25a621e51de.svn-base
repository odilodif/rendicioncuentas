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
@Table(name = "tbl_modalidad_estudios", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblModalidadEstudios.findAll", query = "SELECT t FROM TblModalidadEstudios t")
    , @NamedQuery(name = "TblModalidadEstudios.findByMosCod", query = "SELECT t FROM TblModalidadEstudios t WHERE t.mosCod = :mosCod")
    , @NamedQuery(name = "TblModalidadEstudios.findByMosTipo", query = "SELECT t FROM TblModalidadEstudios t WHERE t.mosTipo = :mosTipo")})
public class TblModalidadEstudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mos_cod", nullable = false)
    private Integer mosCod;
    @Column(name = "mos_tipo", length = 200)
    private String mosTipo;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblModalidadEstudios() {
    }

    public TblModalidadEstudios(Integer mosCod) {
        this.mosCod = mosCod;
    }

    public Integer getMosCod() {
        return mosCod;
    }

    public void setMosCod(Integer mosCod) {
        this.mosCod = mosCod;
    }

    public String getMosTipo() {
        return mosTipo;
    }

    public void setMosTipo(String mosTipo) {
        this.mosTipo = mosTipo;
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
        hash += (mosCod != null ? mosCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblModalidadEstudios)) {
            return false;
        }
        TblModalidadEstudios other = (TblModalidadEstudios) object;
        if ((this.mosCod == null && other.mosCod != null) || (this.mosCod != null && !this.mosCod.equals(other.mosCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblModalidadEstudios[ mosCod=" + mosCod + " ]";
    }
    
}
