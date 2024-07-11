/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.retroalimentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author rata
 */
@Entity
@Table(name = "tbl_matriz", catalog = "rendiciondb", schema = "esq_retroalimentacion")
@NamedQueries({ @NamedQuery(name = "TblMatriz.findAll", query = "SELECT m FROM TblMatriz m"),
		@NamedQuery(name = "TblMatriz.findByIdMatriz", query = "SELECT m FROM TblMatriz m WHERE m.idMatriz = :idMatriz"),
		@NamedQuery(name = "TblMatriz.findByMatriz", query = "SELECT m FROM TblMatriz m WHERE m.matriz = :matriz"),
		@NamedQuery(name = "TblMatriz.findByPeriodo", query = "SELECT m FROM TblMatriz m WHERE m.periodo = :periodo") })

@AllArgsConstructor
@Builder
public class TblMatriz implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id_matriz", nullable = false)
	private Integer idMatriz;
	@Column(name = "matriz", length = 2147483647)
	private String matriz;
	@Column(name = "periodo", length = 2147483647)
	private String periodo;
	/*
	 * añado lista para optener todas las calificaciones de las autoridades. por:
	 * Paul Tapia
	 */
	@Setter
	@Getter
	@Builder.Default
	@XmlTransient
	@OneToMany(mappedBy = "idMatriz")
	private List<TblInformeCalificadoAutoridades> tblInformeCalificadoAutoridadesList = new ArrayList<>();

	public TblMatriz() {
	}

	public TblMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}

	public Integer getIdMatriz() {
		return idMatriz;
	}

	public void setIdMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}

	public String getMatriz() {
		return matriz;
	}

	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idMatriz != null ? idMatriz.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TblMatriz)) {
			return false;
		}
		TblMatriz other = (TblMatriz) object;
		if ((this.idMatriz == null && other.idMatriz != null)
				|| (this.idMatriz != null && !this.idMatriz.equals(other.idMatriz))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gob.cpccs.model.retroalimentacion.TblMatriz[ idMatriz=" + idMatriz + " ]";
	}

}
