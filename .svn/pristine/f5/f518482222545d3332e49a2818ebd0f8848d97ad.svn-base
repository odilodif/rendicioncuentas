/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.funcionarios;

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
@Table(name = "tbl_datos_funcionarios", catalog = "rendiciondb", schema = "esq_usuarios_internos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDatosFuncionarios.findAll", query = "SELECT t FROM TblDatosFuncionarios t")
    , @NamedQuery(name = "TblDatosFuncionarios.findByIdDatoFuncionario", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.idDatoFuncionario = :idDatoFuncionario")
    , @NamedQuery(name = "TblDatosFuncionarios.findByIdentificador", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.identificador = :identificador")
    , @NamedQuery(name = "TblDatosFuncionarios.findByNombre", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.nombre = :nombre")  
    , @NamedQuery(name = "TblDatosFuncionarios.findByTipoDocumento", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "TblDatosFuncionarios.findByNacionalidad", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "TblDatosFuncionarios.findByGenero", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.genero = :genero")
    , @NamedQuery(name = "TblDatosFuncionarios.findByEstadoCivil", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "TblDatosFuncionarios.findByCedulaMilitar", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.cedulaMilitar = :cedulaMilitar")
    , @NamedQuery(name = "TblDatosFuncionarios.findByFechaNacimiento", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblDatosFuncionarios.findByEdad", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.edad = :edad")
    , @NamedQuery(name = "TblDatosFuncionarios.findByTipoSangre", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.tipoSangre = :tipoSangre")
    , @NamedQuery(name = "TblDatosFuncionarios.findByIdentificacionEtnica", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.identificacionEtnica = :identificacionEtnica")
    , @NamedQuery(name = "TblDatosFuncionarios.findByNacionalidadIndigena", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.nacionalidadIndigena = :nacionalidadIndigena")
    , @NamedQuery(name = "TblDatosFuncionarios.findByFechaModificacion", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "TblDatosFuncionarios.findByFotografia", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.fotografia = :fotografia")
    , @NamedQuery(name = "TblDatosFuncionarios.findByEstadoEmpleado", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.estadoEmpleado = :estadoEmpleado")
    , @NamedQuery(name = "TblDatosFuncionarios.findByExtensionTelefono", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.extensionTelefono = :extensionTelefono")
    , @NamedQuery(name = "TblDatosFuncionarios.findByDomicilio", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.domicilio = :domicilio")
    , @NamedQuery(name = "TblDatosFuncionarios.findByConvencional", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.convencional = :convencional")
    , @NamedQuery(name = "TblDatosFuncionarios.findByCelular", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.celular = :celular")
    , @NamedQuery(name = "TblDatosFuncionarios.findByMailPersonal", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.mailPersonal = :mailPersonal")
    , @NamedQuery(name = "TblDatosFuncionarios.findByMailInstitucional", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.mailInstitucional = :mailInstitucional")
    , @NamedQuery(name = "TblDatosFuncionarios.findByTieneDiscapacidad", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.tieneDiscapacidad = :tieneDiscapacidad")
    , @NamedQuery(name = "TblDatosFuncionarios.findByCarnetConadisEmpleado", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.carnetConadisEmpleado = :carnetConadisEmpleado")
    , @NamedQuery(name = "TblDatosFuncionarios.findByRepresentanteFamiliarDiscapacidad", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.representanteFamiliarDiscapacidad = :representanteFamiliarDiscapacidad")
    , @NamedQuery(name = "TblDatosFuncionarios.findByIdParroquia", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.idParroquia = :idParroquia")
    , @NamedQuery(name = "TblDatosFuncionarios.findByIdProvincia", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.idProvincia = :idProvincia")
    , @NamedQuery(name = "TblDatosFuncionarios.findByIdCanton", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.idCanton = :idCanton")
    , @NamedQuery(name = "TblDatosFuncionarios.findByTieneEnfermedadCatastrofica", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.tieneEnfermedadCatastrofica = :tieneEnfermedadCatastrofica")
    , @NamedQuery(name = "TblDatosFuncionarios.findByNombreEnfermedadCatastrofica", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.nombreEnfermedadCatastrofica = :nombreEnfermedadCatastrofica")
    , @NamedQuery(name = "TblDatosFuncionarios.findByCarnetConadisFamiliar", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.carnetConadisFamiliar = :carnetConadisFamiliar")
    , @NamedQuery(name = "TblDatosFuncionarios.findByTipoEmpleado", query = "SELECT t FROM TblDatosFuncionarios t WHERE t.tipoEmpleado = :tipoEmpleado")})
public class TblDatosFuncionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dato_funcionario", nullable = false)
    private Integer idDatoFuncionario;
    @Column(name = "identificador", length = 13)
    private String identificador;
    @Column(name = "nombre", length = 256)
    private String nombre;
    @Column(name = "tipo_documento", length = 16)
    private String tipoDocumento;
    @Column(name = "nacionalidad", length = 64)
    private String nacionalidad;
    @Column(name = "genero", length = 16)
    private String genero;
    @Column(name = "estado_civil", length = 16)
    private String estadoCivil;
    @Column(name = "cedula_militar", length = 32)
    private String cedulaMilitar;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "tipo_sangre", length = 4)
    private String tipoSangre;
    @Column(name = "identificacion_etnica", length = 16)
    private String identificacionEtnica;
    @Column(name = "nacionalidad_indigena", length = 16)
    private String nacionalidadIndigena;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "fotografia", length = 256)
    private String fotografia;
    @Column(name = "estado_empleado", length = 32)
    private String estadoEmpleado;
    @Column(name = "extension_telefono")
    private Integer extensionTelefono;
    @Column(name = "domicilio", length = 256)
    private String domicilio;
    @Column(name = "convencional", length = 16)
    private String convencional;
    @Column(name = "celular", length = 16)
    private String celular;
    @Column(name = "mail_personal", length = 256)
    private String mailPersonal;
    @Column(name = "mail_institucional", length = 256)
    private String mailInstitucional;
    @Column(name = "tiene_discapacidad", length = 2)
    private String tieneDiscapacidad;
    @Column(name = "carnet_conadis_empleado", length = 16)
    private String carnetConadisEmpleado;
    @Column(name = "representante_familiar_discapacidad", length = 2)
    private String representanteFamiliarDiscapacidad;
    @Column(name = "id_parroquia")
    private Integer idParroquia;
    @Column(name = "id_provincia")
    private Integer idProvincia;
    @Column(name = "id_canton")
    private Integer idCanton;
    @Column(name = "tiene_enfermedad_catastrofica", length = 2)
    private String tieneEnfermedadCatastrofica;
    @Column(name = "nombre_enfermedad_catastrofica", length = 64)
    private String nombreEnfermedadCatastrofica;
    @Column(name = "carnet_conadis_familiar", length = 10)
    private String carnetConadisFamiliar;
    @Column(name = "tipo_empleado", length = 32)
    private String tipoEmpleado;
    @Column(name = "periodo")
    private Integer periodo;
    @Column(name = "cargo", length = 100)
    private String cargo;
    

    public TblDatosFuncionarios() {
    }

    public TblDatosFuncionarios(Integer idDatoFuncionario) {
        this.idDatoFuncionario = idDatoFuncionario;
    }

    public Integer getIdDatoFuncionario() {
        return idDatoFuncionario;
    }

    public void setIdDatoFuncionario(Integer idDatoFuncionario) {
        this.idDatoFuncionario = idDatoFuncionario;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCedulaMilitar() {
        return cedulaMilitar;
    }

    public void setCedulaMilitar(String cedulaMilitar) {
        this.cedulaMilitar = cedulaMilitar;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getIdentificacionEtnica() {
        return identificacionEtnica;
    }

    public void setIdentificacionEtnica(String identificacionEtnica) {
        this.identificacionEtnica = identificacionEtnica;
    }

    public String getNacionalidadIndigena() {
        return nacionalidadIndigena;
    }

    public void setNacionalidadIndigena(String nacionalidadIndigena) {
        this.nacionalidadIndigena = nacionalidadIndigena;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Integer getExtensionTelefono() {
        return extensionTelefono;
    }

    public void setExtensionTelefono(Integer extensionTelefono) {
        this.extensionTelefono = extensionTelefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getConvencional() {
        return convencional;
    }

    public void setConvencional(String convencional) {
        this.convencional = convencional;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMailPersonal() {
        return mailPersonal;
    }

    public void setMailPersonal(String mailPersonal) {
        this.mailPersonal = mailPersonal;
    }

    public String getMailInstitucional() {
        return mailInstitucional;
    }

    public void setMailInstitucional(String mailInstitucional) {
        this.mailInstitucional = mailInstitucional;
    }

    public String getTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(String tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public String getCarnetConadisEmpleado() {
        return carnetConadisEmpleado;
    }

    public void setCarnetConadisEmpleado(String carnetConadisEmpleado) {
        this.carnetConadisEmpleado = carnetConadisEmpleado;
    }

    public String getRepresentanteFamiliarDiscapacidad() {
        return representanteFamiliarDiscapacidad;
    }

    public void setRepresentanteFamiliarDiscapacidad(String representanteFamiliarDiscapacidad) {
        this.representanteFamiliarDiscapacidad = representanteFamiliarDiscapacidad;
    }

    public Integer getIdParroquia() {
        return idParroquia;
    }

    public void setIdParroquia(Integer idParroquia) {
        this.idParroquia = idParroquia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Integer idCanton) {
        this.idCanton = idCanton;
    }

    public String getTieneEnfermedadCatastrofica() {
        return tieneEnfermedadCatastrofica;
    }

    public void setTieneEnfermedadCatastrofica(String tieneEnfermedadCatastrofica) {
        this.tieneEnfermedadCatastrofica = tieneEnfermedadCatastrofica;
    }

    public String getNombreEnfermedadCatastrofica() {
        return nombreEnfermedadCatastrofica;
    }

    public void setNombreEnfermedadCatastrofica(String nombreEnfermedadCatastrofica) {
        this.nombreEnfermedadCatastrofica = nombreEnfermedadCatastrofica;
    }

    public String getCarnetConadisFamiliar() {
        return carnetConadisFamiliar;
    }

    public void setCarnetConadisFamiliar(String carnetConadisFamiliar) {
        this.carnetConadisFamiliar = carnetConadisFamiliar;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatoFuncionario != null ? idDatoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDatosFuncionarios)) {
            return false;
        }
        TblDatosFuncionarios other = (TblDatosFuncionarios) object;
        if ((this.idDatoFuncionario == null && other.idDatoFuncionario != null) || (this.idDatoFuncionario != null && !this.idDatoFuncionario.equals(other.idDatoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.funcionarios.TblDatosFuncionarios[ idDatoFuncionario=" + idDatoFuncionario + " ]";
    }
    
}
