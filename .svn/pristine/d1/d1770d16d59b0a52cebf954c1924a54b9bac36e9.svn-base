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
@Table(name = "tbl_funciones_autoridades", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFuncionesAutoridades.findAll", query = "SELECT t FROM TblFuncionesAutoridades t")
    , @NamedQuery(name = "TblFuncionesAutoridades.findByFaCod", query = "SELECT t FROM TblFuncionesAutoridades t WHERE t.faCod = :faCod")
    , @NamedQuery(name = "TblFuncionesAutoridades.findByFaFuncion", query = "SELECT t FROM TblFuncionesAutoridades t WHERE t.faFuncion = :faFuncion")
    , @NamedQuery(name = "TblFuncionesAutoridades.findByFaAcciones", query = "SELECT t FROM TblFuncionesAutoridades t WHERE t.faAcciones = :faAcciones")
    , @NamedQuery(name = "TblFuncionesAutoridades.findByFaResultado", query = "SELECT t FROM TblFuncionesAutoridades t WHERE t.faResultado = :faResultado")
    , @NamedQuery(name = "TblFuncionesAutoridades.findByFaObs", query = "SELECT t FROM TblFuncionesAutoridades t WHERE t.faObs = :faObs")})
public class TblFuncionesAutoridades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fa_cod", nullable = false)
    private Integer faCod;
    @Column(name = "fa_funcion", length = 2147483647)
    private String faFuncion;
    @Column(name = "fa_acciones", length = 2147483647)
    private String faAcciones;
    @Column(name = "fa_resultado", length = 2147483647)
    private String faResultado;
    @Column(name = "fa_obs", length = 2147483647)
    private String faObs;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInformeAutoridad infAutCod;

    public TblFuncionesAutoridades() {
    }

    public TblFuncionesAutoridades(Integer faCod) {
        this.faCod = faCod;
    }

    public Integer getFaCod() {
        return faCod;
    }

    public void setFaCod(Integer faCod) {
        this.faCod = faCod;
    }

    public String getFaFuncion() {
        return faFuncion;
    }

    public void setFaFuncion(String faFuncion) {
        this.faFuncion = faFuncion;
    }

    public String getFaAcciones() {
        return faAcciones;
    }

    public void setFaAcciones(String faAcciones) {
        this.faAcciones = faAcciones;
    }

    public String getFaResultado() {
        return faResultado;
    }

    public void setFaResultado(String faResultado) {
        this.faResultado = faResultado;
    }

    public String getFaObs() {
        return faObs;
    }

    public void setFaObs(String faObs) {
        this.faObs = faObs;
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
        hash += (faCod != null ? faCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFuncionesAutoridades)) {
            return false;
        }
        TblFuncionesAutoridades other = (TblFuncionesAutoridades) object;
        if ((this.faCod == null && other.faCod != null) || (this.faCod != null && !this.faCod.equals(other.faCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblFuncionesAutoridades[ faCod=" + faCod + " ]";
    }
    
}
