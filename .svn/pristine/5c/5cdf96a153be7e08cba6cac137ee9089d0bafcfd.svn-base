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

import org.apache.commons.lang.StringEscapeUtils;

import gob.cpccs.utilidades.Constantes;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_implementacion_igualdad", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblImplementacionIgualdad.findAll", query = "SELECT t FROM TblImplementacionIgualdad t")
    , @NamedQuery(name = "TblImplementacionIgualdad.findByPiCod", query = "SELECT t FROM TblImplementacionIgualdad t WHERE t.piCod = :piCod")
    , @NamedQuery(name = "TblImplementacionIgualdad.findByPiNombre", query = "SELECT t FROM TblImplementacionIgualdad t WHERE t.piNombre = :piNombre")
    , @NamedQuery(name = "TblImplementacionIgualdad.findByPiImplementado", query = "SELECT t FROM TblImplementacionIgualdad t WHERE t.piImplementado = :piImplementado")
    , @NamedQuery(name = "TblImplementacionIgualdad.findByPiUsuarios", query = "SELECT t FROM TblImplementacionIgualdad t WHERE t.piUsuarios = :piUsuarios")
    , @NamedQuery(name = "TblImplementacionIgualdad.findByPiPolitica", query = "SELECT t FROM TblImplementacionIgualdad t WHERE t.piPolitica = :piPolitica")
    , @NamedQuery(name = "TblImplementacionIgualdad.findByPiDetalle", query = "SELECT t FROM TblImplementacionIgualdad t WHERE t.piDetalle = :piDetalle")
    , @NamedQuery(name = "TblImplementacionIgualdad.findByPiResultado", query = "SELECT t FROM TblImplementacionIgualdad t WHERE t.piResultado = :piResultado")})
public class TblImplementacionIgualdad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pi_cod", nullable = false)
    private Integer piCod;
    @Column(name = "pi_nombre", length = 200)
    private String piNombre;
    @Column(name = "pi_implementado", length = 2)
    private String piImplementado;
    @Column(name = "pi_usuarios")
    private Integer piUsuarios;
    @Column(name = "pi_politica", length = 2147483647)
    private String piPolitica;
    @Column(name = "pi_detalle", length = 2147483647)
    private String piDetalle;
    @Column(name = "pi_resultado", length = 2147483647)
    private String piResultado;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblImplementacionIgualdad() {
    }

    public TblImplementacionIgualdad(Integer piCod) {
        this.piCod = piCod;
    }

    public Integer getPiCod() {
        return piCod;
    }

    public void setPiCod(Integer piCod) {
        this.piCod = piCod;
    }

    public String getPiNombre() {
        return piNombre;
    }

    public void setPiNombre(String piNombre) {
        this.piNombre = piNombre;
    }

    public String getPiImplementado() {
        return piImplementado;
    }

    public void setPiImplementado(String piImplementado) {
        this.piImplementado = piImplementado;
    }

    public Integer getPiUsuarios() {
        return piUsuarios;
    }

    public void setPiUsuarios(Integer piUsuarios) {
        this.piUsuarios = piUsuarios;
    }

    public String getPiPolitica() {
        return piPolitica;
    }

    public void setPiPolitica(String piPolitica) {
        this.piPolitica = piPolitica;
    }

    public String getPiDetalle() {
        return piDetalle;
    }

    public void setPiDetalle(String piDetalle) {
        this.piDetalle = piDetalle;
    }

    public String getPiResultado() {
        return piResultado;
    }

    public void setPiResultado(String piResultado) {
        this.piResultado = piResultado;
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
        hash += (piCod != null ? piCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblImplementacionIgualdad)) {
            return false;
        }
        TblImplementacionIgualdad other = (TblImplementacionIgualdad) object;
        if ((this.piCod == null && other.piCod != null) || (this.piCod != null && !this.piCod.equals(other.piCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblImplementacionIgualdad[ piCod=" + piCod + " ]";
    }
    
}
