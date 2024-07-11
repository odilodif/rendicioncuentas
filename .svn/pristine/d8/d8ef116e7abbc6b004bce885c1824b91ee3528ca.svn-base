/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.usuario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_autoridad", catalog = "rendiciondb", schema = "esq_autoridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAutoridad.findAll", query = "SELECT t FROM TblAutoridad t")
    , @NamedQuery(name = "TblAutoridad.findByAutCodigo", query = "SELECT t FROM TblAutoridad t WHERE t.autCodigo = :autCodigo")
    , @NamedQuery(name = "TblAutoridad.findByNombre", query = "SELECT t FROM TblAutoridad t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblAutoridad.findByIdentificador", query = "SELECT t FROM TblAutoridad t WHERE t.identificador = :identificador")
    , @NamedQuery(name = "TblAutoridad.findByEmail", query = "SELECT t FROM TblAutoridad t WHERE t.email = :email")
    , @NamedQuery(name = "TblAutoridad.findByTelefono", query = "SELECT t FROM TblAutoridad t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TblAutoridad.findByDireccion", query = "SELECT t FROM TblAutoridad t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TblAutoridad.findByPassword", query = "SELECT t FROM TblAutoridad t WHERE t.password = :password")
    , @NamedQuery(name = "TblAutoridad.findByFechaRegistro", query = "SELECT t FROM TblAutoridad t WHERE t.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "TblAutoridad.findByCelular", query = "SELECT t FROM TblAutoridad t WHERE t.celular = :celular")
    , @NamedQuery(name = "TblAutoridad.findByEstado", query = "SELECT t FROM TblAutoridad t WHERE t.estado = :estado")
    , @NamedQuery(name = "TblAutoridad.findByWeb", query = "SELECT t FROM TblAutoridad t WHERE t.web = :web")
    , @NamedQuery(name = "TblAutoridad.findByDignidad", query = "SELECT t FROM TblAutoridad t WHERE t.dignidad = :dignidad")
    , @NamedQuery(name = "TblAutoridad.findByPeriodo", query = "SELECT t FROM TblAutoridad t WHERE t.periodo = :periodo")
    , @NamedQuery(name = "TblAutoridad.findByProvincia", query = "SELECT t FROM TblAutoridad t WHERE t.provincia = :provincia")
    , @NamedQuery(name = "TblAutoridad.findByCanton", query = "SELECT t FROM TblAutoridad t WHERE t.canton = :canton")
    , @NamedQuery(name = "TblAutoridad.findByParroquia", query = "SELECT t FROM TblAutoridad t WHERE t.parroquia = :parroquia")
    , @NamedQuery(name = "TblAutoridad.findByRutaArchivoValidador", query = "SELECT t FROM TblAutoridad t WHERE t.rutaArchivoValidador = :rutaArchivoValidador")
    , @NamedQuery(name = "TblAutoridad.findByInstitucionDignidad", query = "SELECT t FROM TblAutoridad t WHERE t.institucionDignidad = :institucionDignidad")
    , @NamedQuery(name = "TblAutoridad.findByAmbito", query = "SELECT t FROM TblAutoridad t WHERE t.ambito = :ambito")
    , @NamedQuery(name = "TblAutoridad.findByNombreAbuela", query = "SELECT t FROM TblAutoridad t WHERE t.nombreAbuela = :nombreAbuela")
    , @NamedQuery(name = "TblAutoridad.findByMesNacimiento", query = "SELECT t FROM TblAutoridad t WHERE t.mesNacimiento = :mesNacimiento")})
public class TblAutoridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aut_codigo", nullable = false)
    private Integer autCodigo;
    @Column(name = "nombre", length = 300)
    private String nombre;
    @Column(name = "identificador", length = 10)
    private String identificador;
    @Column(name = "email", length = 200)
    private String email;
    @Column(name = "telefono", length = 20)
    private String telefono;
    @Column(name = "direccion", length = 500)
    private String direccion;
    @Column(name = "password", length = 250)
    private String password;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_activar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivar;
    @Column(name = "celular", length = 20)
    private String celular;
    @Column(name = "estado", length = 15)
    private String estado;
    @Column(name = "web", length = 1000)
    private String web;
    @Column(name = "dignidad", length = 100)
    private String dignidad;
    @Column(name = "periodo")
    private Integer periodo;
    @Column(name = "provincia")
    private Integer provincia;
    @Column(name = "canton")
    private Integer canton;
    @Column(name = "parroquia")
    private Integer parroquia;
    @Column(name = "ruta_archivo_validador", length = 500)
    private String rutaArchivoValidador;
    @Column(name = "institucion_dignidad", length = 100)
    private String institucionDignidad;
    @Column(name = "ambito", length = 100)
    private String ambito;
    @Column(name = "nombre_abuela", length = 50)
    private String nombreAbuela;
    @Column(name = "mes_nacimiento", length = 50)
    private String mesNacimiento;
    @Column(name = "aut_verificador", length = 15)
    private String autVerificador;
    
    @Column(name = "tipo_autoridad", length = 15)
    private String tipoAutoridad;
    
    @Column(name = "documento_cedula", length = 500)
    private String documentoCedula;

    /**
	 * @return the tipoAutoridad
	 */
	public String getTipoAutoridad() {
		return tipoAutoridad;
	}

	/**
	 * @param tipoAutoridad the tipoAutoridad to set
	 */
	public void setTipoAutoridad(String tipoAutoridad) {
		this.tipoAutoridad = tipoAutoridad;
	}

	/**
	 * @return the documentoCedula
	 */
	public String getDocumentoCedula() {
		return documentoCedula;
	}

	/**
	 * @param documentoCedula the documentoCedula to set
	 */
	public void setDocumentoCedula(String documentoCedula) {
		this.documentoCedula = documentoCedula;
	}

	public TblAutoridad() {
    }

    public TblAutoridad(Integer autCodigo) {
        this.autCodigo = autCodigo;
    }

    public Integer getAutCodigo() {
        return autCodigo;
    }

    public void setAutCodigo(Integer autCodigo) {
        this.autCodigo = autCodigo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
    public Date getFechaActivar() {
        return fechaActivar;
    }

    public void setFechaActivar(Date fechaActivar) {
        this.fechaActivar = fechaActivar;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getDignidad() {
        return dignidad;
    }

    public void setDignidad(String dignidad) {
        this.dignidad = dignidad;
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

    public Integer getCanton() {
        return canton;
    }

    public void setCanton(Integer canton) {
        this.canton = canton;
    }

    public Integer getParroquia() {
        return parroquia;
    }

    public void setParroquia(Integer parroquia) {
        this.parroquia = parroquia;
    }

    public String getRutaArchivoValidador() {
        return rutaArchivoValidador;
    }

    public void setRutaArchivoValidador(String rutaArchivoValidador) {
        this.rutaArchivoValidador = rutaArchivoValidador;
    }

    public String getInstitucionDignidad() {
        return institucionDignidad;
    }

    public void setInstitucionDignidad(String institucionDignidad) {
        this.institucionDignidad = institucionDignidad;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getNombreAbuela() {
        return nombreAbuela;
    }

    public void setNombreAbuela(String nombreAbuela) {
        this.nombreAbuela = nombreAbuela;
    }

    public String getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(String mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public String getAutVerificador() {
        return autVerificador;
    }

    public void setAutVerificador(String autVerificador) {
        this.autVerificador = autVerificador;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autCodigo != null ? autCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAutoridad)) {
            return false;
        }
        TblAutoridad other = (TblAutoridad) object;
        if ((this.autCodigo == null && other.autCodigo != null) || (this.autCodigo != null && !this.autCodigo.equals(other.autCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.usuario.TblAutoridad[ autCodigo=" + autCodigo + " ]";
    }
    
}
