/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_usuario", catalog = "rendiciondb", schema = "esq_usuario")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "TblUsuario.findAll", query = "SELECT t FROM TblUsuario t"),
		@NamedQuery(name = "TblUsuario.findByIdUser", query = "SELECT t FROM TblUsuario t WHERE t.idUser = :idUser"),
		@NamedQuery(name = "TblUsuario.findByNombre", query = "SELECT t FROM TblUsuario t WHERE t.nombre = :nombre"),
		@NamedQuery(name = "TblUsuario.findByIdentificador", query = "SELECT t FROM TblUsuario t WHERE t.identificador = :identificador"),
		@NamedQuery(name = "TblUsuario.findByEmail", query = "SELECT t FROM TblUsuario t WHERE t.email = :email"),
		@NamedQuery(name = "TblUsuario.findByPassword", query = "SELECT t FROM TblUsuario t WHERE t.password = :password"),
		@NamedQuery(name = "TblUsuario.findByFechaRegistro", query = "SELECT t FROM TblUsuario t WHERE t.fechaRegistro = :fechaRegistro"),
		@NamedQuery(name = "TblUsuario.findByEstado", query = "SELECT t FROM TblUsuario t WHERE t.estado = :estado"),
		@NamedQuery(name = "TblUsuario.findByFechaNacimiento", query = "SELECT t FROM TblUsuario t WHERE t.fechaNacimiento = :fechaNacimiento"),
		@NamedQuery(name = "TblUsuario.findByNombreAbuela", query = "SELECT t FROM TblUsuario t WHERE t.nombreAbuela = :nombreAbuela"),
		@NamedQuery(name = "TblUsuario.findByPeriodo", query = "SELECT t FROM TblUsuario t WHERE t.periodo = :periodo") })
public class TblUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_user", nullable = false)
	private Integer idUser;
	@Basic(optional = false)
	@Column(name = "nombre", nullable = false, length = 300)
	private String nombre;
	@Basic(optional = false)
	@Column(name = "identificador", nullable = false, length = 13)
	private String identificador;
	@Basic(optional = false)
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	@Column(name = "password", length = 250)
	private String password;
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	@Column(name = "estado")
	private Integer estado;
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Column(name = "nombre_abuela", length = 200)
	private String nombreAbuela;
	@Column(name = "periodo")
	private Integer periodo;
	@Column(name = "codigo_temporal", length = 256)
	private String codigoTemporal;
	@Column(name = "provincia")
	private Integer provincia;
	@Column(name = "codigo_intitucion_autorida")
	private Integer codigoIntitucionAutorida;
	@Column(name = "tipo_user", length = 15)
	private String tipoUser;

	@OneToMany(mappedBy = "idUser")
	private List<TblUsuarioRol> tblUsuarioRolList;

	public TblUsuario() {
	}

	public TblUsuario(Integer idUser) {
		this.idUser = idUser;
	}

	public TblUsuario(Integer idUser, String nombre, String identificador, String email) {
		this.idUser = idUser;
		this.nombre = nombre;
		this.identificador = identificador;
		this.email = email;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreAbuela() {
		return nombreAbuela;
	}

	public void setNombreAbuela(String nombreAbuela) {
		this.nombreAbuela = nombreAbuela;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Integer getProvincia() {
		return provincia;
	}

	public void setProvincia(Integer provincia) {
		this.provincia = provincia;
	}

	public Integer getCodigoIntitucionAutorida() {
		return codigoIntitucionAutorida;
	}

	public void setCodigoIntitucionAutorida(Integer codigoIntitucionAutorida) {
		this.codigoIntitucionAutorida = codigoIntitucionAutorida;
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}

	@XmlTransient
	public List<TblUsuarioRol> getTblUsuarioRolList() {
		return tblUsuarioRolList;
	}

	public void setTblUsuarioRolList(List<TblUsuarioRol> tblUsuarioRolList) {
		this.tblUsuarioRolList = tblUsuarioRolList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUser != null ? idUser.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TblUsuario)) {
			return false;
		}
		TblUsuario other = (TblUsuario) object;
		if ((this.idUser == null && other.idUser != null)
				|| (this.idUser != null && !this.idUser.equals(other.idUser))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gob.cpccs.model.usuario.TblUsuario[ idUser=" + idUser + " ]";
	}

	public String getCodigoTemporal() {
		return codigoTemporal;
	}

	public void setCodigoTemporal(String codigoTemporal) {
		this.codigoTemporal = codigoTemporal;
	}

}
