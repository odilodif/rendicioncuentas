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
@Table(name = "tbl_articulacion_pp", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblArticulacionPp.findAll", query = "SELECT t FROM TblArticulacionPp t")
    , @NamedQuery(name = "TblArticulacionPp.findByAppCod", query = "SELECT t FROM TblArticulacionPp t WHERE t.appCod = :appCod")
    , @NamedQuery(name = "TblArticulacionPp.findByAppDescripcion", query = "SELECT t FROM TblArticulacionPp t WHERE t.appDescripcion = :appDescripcion")
    , @NamedQuery(name = "TblArticulacionPp.findByAppArticulacion", query = "SELECT t FROM TblArticulacionPp t WHERE t.appArticulacion = :appArticulacion")
    , @NamedQuery(name = "TblArticulacionPp.findByAppMedioverif", query = "SELECT t FROM TblArticulacionPp t WHERE t.appMedioverif = :appMedioverif")})
public class TblArticulacionPp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_cod", nullable = false)
    private Integer appCod;
    @Column(name = "app_descripcion", length = 200)
    private String appDescripcion;
    @Column(name = "app_articulacion", length = 2)
    private String appArticulacion;
    @Column(name = "app_medioverif", length = 500)
    private String appMedioverif;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblArticulacionPp() {
    }

    public TblArticulacionPp(Integer appCod) {
        this.appCod = appCod;
    }

    public Integer getAppCod() {
        return appCod;
    }

    public void setAppCod(Integer appCod) {
        this.appCod = appCod;
    }

    public String getAppDescripcion() {
        return appDescripcion;
    }

    public void setAppDescripcion(String appDescripcion) {
        this.appDescripcion = appDescripcion;
    }

    public String getAppArticulacion() {
        return appArticulacion;
    }

    public void setAppArticulacion(String appArticulacion) {
        this.appArticulacion = appArticulacion;
    }

    public String getAppMedioverif() {
        return appMedioverif;
    }

    public void setAppMedioverif(String appMedioverif) {
        this.appMedioverif = appMedioverif;
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
        hash += (appCod != null ? appCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblArticulacionPp)) {
            return false;
        }
        TblArticulacionPp other = (TblArticulacionPp) object;
        if ((this.appCod == null && other.appCod != null) || (this.appCod != null && !this.appCod.equals(other.appCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblArticulacionPp[ appCod=" + appCod + " ]";
    }
    
}
