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
@Table(name = "tbl_cobertura_nacional", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCoberturaNacional.findAll", query = "SELECT t FROM TblCoberturaNacional t")
    , @NamedQuery(name = "TblCoberturaNacional.findByCnCod", query = "SELECT t FROM TblCoberturaNacional t WHERE t.cnCod = :cnCod")
    , @NamedQuery(name = "TblCoberturaNacional.findByCnCobertura", query = "SELECT t FROM TblCoberturaNacional t WHERE t.cnCobertura = :cnCobertura")
    , @NamedQuery(name = "TblCoberturaNacional.findByCnUnidades", query = "SELECT t FROM TblCoberturaNacional t WHERE t.cnUnidades = :cnUnidades")
    , @NamedQuery(name = "TblCoberturaNacional.findByCnTipo", query = "SELECT t FROM TblCoberturaNacional t WHERE t.cnTipo = :cnTipo")
    , @NamedQuery(name = "TblCoberturaNacional.findByCnDescripcion", query = "SELECT t FROM TblCoberturaNacional t WHERE t.cnDescripcion = :cnDescripcion")})
public class TblCoberturaNacional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cn_cod", nullable = false)
    private Integer cnCod;
    @Column(name = "cn_cobertura", length = 200)
    private String cnCobertura;
    @Column(name = "cn_unidades")
    private Integer cnUnidades;
    @Column(name = "cn_tipo", length = 10)
    private String cnTipo;
    @Column(name = "cn_descripcion", length = 500)
    private String cnDescripcion;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;
    
    @Column(name = "cn_estado", length = 15)
    private String cnestado;
    
    public TblCoberturaNacional() {
    }

    public TblCoberturaNacional(Integer cnCod) {
        this.cnCod = cnCod;
    }

    public Integer getCnCod() {
        return cnCod;
    }

    public void setCnCod(Integer cnCod) {
        this.cnCod = cnCod;
    }

    public String getCnCobertura() {
        return cnCobertura;
    }

    public void setCnCobertura(String cnCobertura) {
        this.cnCobertura = cnCobertura;
    }

    public Integer getCnUnidades() {
        return cnUnidades;
    }

    public void setCnUnidades(Integer cnUnidades) {
        this.cnUnidades = cnUnidades;
    }

    public String getCnTipo() {
        return cnTipo;
    }

    public void setCnTipo(String cnTipo) {
        this.cnTipo = cnTipo;
    }

    public String getCnDescripcion() {
        return cnDescripcion;
    }

    public void setCnDescripcion(String cnDescripcion) {
        this.cnDescripcion = cnDescripcion;
    }

    public TblInforme getInfCod() {
        return infCod;
    }

    public void setInfCod(TblInforme infCod) {
        this.infCod = infCod;
    }

    public String getCnestado() {
        return cnestado;
    }

    public void setCnestado(String cnestado) {
        this.cnestado = cnestado;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnCod != null ? cnCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCoberturaNacional)) {
            return false;
        }
        TblCoberturaNacional other = (TblCoberturaNacional) object;
        if ((this.cnCod == null && other.cnCod != null) || (this.cnCod != null && !this.cnCod.equals(other.cnCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblCoberturaNacional[ cnCod=" + cnCod + " ]";
    }
    
}
