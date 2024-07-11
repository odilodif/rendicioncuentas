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
@Table(name = "tbl_funciones_objetivos", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFuncionesObjetivos.findAll", query = "SELECT t FROM TblFuncionesObjetivos t")
    , @NamedQuery(name = "TblFuncionesObjetivos.findByFoCod", query = "SELECT t FROM TblFuncionesObjetivos t WHERE t.foCod = :foCod")
    , @NamedQuery(name = "TblFuncionesObjetivos.findByInstCod", query = "SELECT t FROM TblFuncionesObjetivos t WHERE t.instCod = :instCod")
    , @NamedQuery(name = "TblFuncionesObjetivos.findByFoNom", query = "SELECT t FROM TblFuncionesObjetivos t WHERE t.foNom = :foNom")
    , @NamedQuery(name = "TblFuncionesObjetivos.findByFoestado", query = "SELECT t FROM TblFuncionesObjetivos t WHERE t.foestado = :foestado")
    , @NamedQuery(name = "TblFuncionesObjetivos.findByFoTip", query = "SELECT t FROM TblFuncionesObjetivos t WHERE t.foTip = :foTip")
    , @NamedQuery(name = "TblFuncionesObjetivos.findByFoPeriodo", query = "SELECT t FROM TblFuncionesObjetivos t WHERE t.foPeriodo = :foPeriodo")})
public class TblFuncionesObjetivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fo_cod", nullable = false)
    private Integer foCod;
    @Basic(optional = false)
    @Column(name = "inst_cod", nullable = false)
    private int instCod;
    @Column(name = "fo_nom", length = 2147483647)
    private String foNom;
    @Column(name = "fo_tip", length = 100)
    private String foTip;
    @Column(name = "fo_periodo", length = 10)
    private String foPeriodo;
    @Column(name = "fo_estado", length = 10)
    private String foestado;

    public TblFuncionesObjetivos() {
    }

    public TblFuncionesObjetivos(Integer foCod) {
        this.foCod = foCod;
    }

    public TblFuncionesObjetivos(Integer foCod, int instCod) {
        this.foCod = foCod;
        this.instCod = instCod;
    }

    public Integer getFoCod() {
        return foCod;
    }

    public void setFoCod(Integer foCod) {
        this.foCod = foCod;
    }

    public int getInstCod() {
        return instCod;
    }

    public void setInstCod(int instCod) {
        this.instCod = instCod;
    }

    public String getFoNom() {
        return foNom;
    }

    public void setFoNom(String foNom) {
        this.foNom = foNom;
    }

    public String getFoTip() {
        return foTip;
    }

    public void setFoTip(String foTip) {
        this.foTip = foTip;
    }

    public String getFoPeriodo() {
        return foPeriodo;
    }

    public void setFoPeriodo(String foPeriodo) {
        this.foPeriodo = foPeriodo;
    }
    
    
    public String getFoestado() {
        return foestado;
    }

    public void setFoestado(String foestado) {
        this.foestado = foestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foCod != null ? foCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFuncionesObjetivos)) {
            return false;
        }
        TblFuncionesObjetivos other = (TblFuncionesObjetivos) object;
        if ((this.foCod == null && other.foCod != null) || (this.foCod != null && !this.foCod.equals(other.foCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblFuncionesObjetivos[ foCod=" + foCod + " ]";
    }
    
}
