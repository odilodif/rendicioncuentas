/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.seguridad;

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
 * @author CAMM
 */
@Entity
@Table(name = "tbl_historico_instituciones", catalog = "rendiciondb", schema = "esq_seguridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHistoricoInstituciones.findAll", query = "SELECT t FROM TblHistoricoInstituciones t")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByIdHistorial", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.idHistorial = :idHistorial")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByIdTecnico", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.idTecnico = :idTecnico")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByIdNombreTecnico", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.idNombreTecnico = :idNombreTecnico")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByDatoHistorico", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.datoHistorico = :datoHistorico")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByDatoActual", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.datoActual = :datoActual")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByAprobadoPor", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.aprobadoPor = :aprobadoPor")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByVersionSistema", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.versionSistema = :versionSistema")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByIpAdress", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.ipAdress = :ipAdress")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByHostName", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.hostName = :hostName")
    , @NamedQuery(name = "TblHistoricoInstituciones.findBySolicitadoPor", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.solicitadoPor = :solicitadoPor")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByAcccion", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.acccion = :acccion")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByFechaAccion", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.fechaAccion = :fechaAccion")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByDescripcion", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByRutaAnexo", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.rutaAnexo = :rutaAnexo")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByCodReferencial", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.codReferencial = :codReferencial")
    , @NamedQuery(name = "TblHistoricoInstituciones.findByTipoHistorico", query = "SELECT t FROM TblHistoricoInstituciones t WHERE t.tipoHistorico = :tipoHistorico")})
public class TblHistoricoInstituciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial", nullable = false)
    private Integer idHistorial;
    @Column(name = "id_tecnico")
    private Integer idTecnico;
    @Column(name = "id_nombre_tecnico", length = 255)
    private String idNombreTecnico;
    @Column(name = "dato_historico", length = 2147483647)
    private String datoHistorico;
    @Column(name = "dato_actual", length = 2147483647)
    private String datoActual;
    @Column(name = "aprobado_por", length = 255)
    private String aprobadoPor;
    @Column(name = "version_sistema", length = 255)
    private String versionSistema;
    @Column(name = "ip_adress", length = 255)
    private String ipAdress;
    @Column(name = "host_name", length = 255)
    private String hostName;
    @Column(name = "solicitado_por", length = 255)
    private String solicitadoPor;
    @Column(name = "acccion", length = 500)
    private String acccion;
    @Column(name = "fecha_accion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAccion;
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    @Column(name = "ruta_anexo", length = 255)
    private String rutaAnexo;
    @Column(name = "cod_referencial")
    private Integer codReferencial;
    @Column(name = "tipo_historico", length = 30)
    private String tipoHistorico;

    public TblHistoricoInstituciones() {
    }

    public TblHistoricoInstituciones(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getIdNombreTecnico() {
        return idNombreTecnico;
    }

    public void setIdNombreTecnico(String idNombreTecnico) {
        this.idNombreTecnico = idNombreTecnico;
    }

    public String getDatoHistorico() {
        return datoHistorico;
    }

    public void setDatoHistorico(String datoHistorico) {
        this.datoHistorico = datoHistorico;
    }

    public String getDatoActual() {
        return datoActual;
    }

    public void setDatoActual(String datoActual) {
        this.datoActual = datoActual;
    }

    public String getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(String aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public String getVersionSistema() {
        return versionSistema;
    }

    public void setVersionSistema(String versionSistema) {
        this.versionSistema = versionSistema;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getSolicitadoPor() {
        return solicitadoPor;
    }

    public void setSolicitadoPor(String solicitadoPor) {
        this.solicitadoPor = solicitadoPor;
    }

    public String getAcccion() {
        return acccion;
    }

    public void setAcccion(String acccion) {
        this.acccion = acccion;
    }

    public Date getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(Date fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaAnexo() {
        return rutaAnexo;
    }

    public void setRutaAnexo(String rutaAnexo) {
        this.rutaAnexo = rutaAnexo;
    }

    public Integer getCodReferencial() {
        return codReferencial;
    }

    public void setCodReferencial(Integer codReferencial) {
        this.codReferencial = codReferencial;
    }

    public String getTipoHistorico() {
        return tipoHistorico;
    }

    public void setTipoHistorico(String tipoHistorico) {
        this.tipoHistorico = tipoHistorico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHistoricoInstituciones)) {
            return false;
        }
        TblHistoricoInstituciones other = (TblHistoricoInstituciones) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.seguridad.TblHistoricoInstituciones[ idHistorial=" + idHistorial + " ]";
    }
    
}
