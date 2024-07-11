/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.usuario;

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

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_usuario_localizacion", catalog = "rendiciondb", schema = "esq_usuario")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "TblUsuarioLocalizacion.findAll", query = "SELECT t FROM TblUsuarioLocalizacion t"),
		@NamedQuery(name = "TblUsuarioLocalizacion.findByFunLocCod", query = "SELECT t FROM TblUsuarioLocalizacion t WHERE t.funLocCod = :funLocCod"),
		@NamedQuery(name = "TblUsuarioLocalizacion.findByIdentificador", query = "SELECT t FROM TblUsuarioLocalizacion t WHERE t.identificador = :identificador"),
		@NamedQuery(name = "TblUsuarioLocalizacion.findByRolCod", query = "SELECT t FROM TblUsuarioLocalizacion t WHERE t.rolCod = :rolCod"),
		@NamedQuery(name = "TblUsuarioLocalizacion.findByProvCod", query = "SELECT t FROM TblUsuarioLocalizacion t WHERE t.provCod = :provCod") })
public class TblUsuarioLocalizacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "fun_loc_cod", nullable = false)
	private Integer funLocCod;
	@Basic(optional = false)
	@Column(name = "identificador", nullable = false, length = 15)
	private String identificador;
	@Basic(optional = false)
	@Column(name = "rol_cod", nullable = false)
	private int rolCod;
	@Basic(optional = false)
	@Column(name = "prov_cod", nullable = false)
	private int provCod;
	@Basic(optional = false)
	@Column(name = "periodo", nullable = false)
	private Integer periodo;

	public TblUsuarioLocalizacion() {
	}

	public TblUsuarioLocalizacion(Integer funLocCod) {
		this.funLocCod = funLocCod;
	}

	public TblUsuarioLocalizacion(Integer funLocCod, String identificador, int rolCod, int provCod, Integer periodo) {
		this.funLocCod = funLocCod;
		this.identificador = identificador;
		this.rolCod = rolCod;
		this.provCod = provCod;
		this.periodo = periodo;
	}

	public Integer getFunLocCod() {
		return funLocCod;
	}

	public void setFunLocCod(Integer funLocCod) {
		this.funLocCod = funLocCod;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getRolCod() {
		return rolCod;
	}

	public void setRolCod(int rolCod) {
		this.rolCod = rolCod;
	}

	public int getProvCod() {
		return provCod;
	}

	
	public void setProvCod(int provCod) {
		this.provCod = provCod;
	}
	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (funLocCod != null ? funLocCod.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TblUsuarioLocalizacion)) {
			return false;
		}
		TblUsuarioLocalizacion other = (TblUsuarioLocalizacion) object;
		if ((this.funLocCod == null && other.funLocCod != null)
				|| (this.funLocCod != null && !this.funLocCod.equals(other.funLocCod))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gob.cpccs.model.usuario.TblUsuarioLocalizacion[ funLocCod=" + funLocCod + " ]";
	}

}
