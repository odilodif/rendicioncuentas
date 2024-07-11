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

import lombok.ToString;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_proyecto_comunicacional", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "TblProyectoComunicacional.findAll", query = "SELECT t FROM TblProyectoComunicacional t")
    , @NamedQuery(name = "TblProyectoComunicacional.findByProCodigo", query = "SELECT t FROM TblProyectoComunicacional t WHERE t.proCodigo = :proCodigo")
    , @NamedQuery(name = "TblProyectoComunicacional.findByProNombre", query = "SELECT t FROM TblProyectoComunicacional t WHERE t.proNombre = :proNombre")
    , @NamedQuery(name = "TblProyectoComunicacional.findByProOpcion", query = "SELECT t FROM TblProyectoComunicacional t WHERE t.proOpcion = :proOpcion")
    , @NamedQuery(name = "TblProyectoComunicacional.findByProEstado", query = "SELECT t FROM TblProyectoComunicacional t WHERE t.proEstado = :proEstado")})
*/
@ToString
public class TblProyectoComunicacional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_codigo", nullable = false)
    private Integer proCodigo;
    @Column(name = "pro_nombre", length = 255)
    private String proNombre;
    @Column(name = "pro_opcion", length = 15)
    private String proOpcion;
    @Column(name = "pro_estado", length = 15)
    private String proEstado;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblProyectoComunicacional() {
    }

    public TblProyectoComunicacional(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProOpcion() {
        return proOpcion;
    }

    public void setProOpcion(String proOpcion) {
        this.proOpcion = proOpcion;
    }

    public String getProEstado() {
        return proEstado;
    }

    public void setProEstado(String proEstado) {
        this.proEstado = proEstado;
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
        hash += (proCodigo != null ? proCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProyectoComunicacional)) {
            return false;
        }
        TblProyectoComunicacional other = (TblProyectoComunicacional) object;
        if ((this.proCodigo == null && other.proCodigo != null) || (this.proCodigo != null && !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

 /*   @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblProyectoComunicacional[ proCodigo=" + proCodigo + " ]";
    }*/
    
}
