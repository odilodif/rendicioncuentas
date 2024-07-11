/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.catalogos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author CAMM
 */
@Entity
@Table(name = "tbl_institucion", catalog = "rendiciondb", schema = "esq_catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInstitucion.findAll", query = "SELECT t FROM TblInstitucion t")
    , @NamedQuery(name = "TblInstitucion.findByInstCod", query = "SELECT t FROM TblInstitucion t WHERE t.instCod = :instCod")
    , @NamedQuery(name = "TblInstitucion.findByInstRuc", query = "SELECT t FROM TblInstitucion t WHERE t.instRuc = :instRuc")
    , @NamedQuery(name = "TblInstitucion.findByInstNom", query = "SELECT t FROM TblInstitucion t WHERE t.instNom = :instNom")
    , @NamedQuery(name = "TblInstitucion.findByProvCod", query = "SELECT t FROM TblInstitucion t WHERE t.provCod = :provCod")
    , @NamedQuery(name = "TblInstitucion.findByCantCod", query = "SELECT t FROM TblInstitucion t WHERE t.cantCod = :cantCod")
    , @NamedQuery(name = "TblInstitucion.findByParroCod", query = "SELECT t FROM TblInstitucion t WHERE t.parroCod = :parroCod")
    , @NamedQuery(name = "TblInstitucion.findByInstDir", query = "SELECT t FROM TblInstitucion t WHERE t.instDir = :instDir")
    , @NamedQuery(name = "TblInstitucion.findByInstTel", query = "SELECT t FROM TblInstitucion t WHERE t.instTel = :instTel")
    , @NamedQuery(name = "TblInstitucion.findByInstEma", query = "SELECT t FROM TblInstitucion t WHERE t.instEma = :instEma")
    , @NamedQuery(name = "TblInstitucion.findByInstPag", query = "SELECT t FROM TblInstitucion t WHERE t.instPag = :instPag")
    , @NamedQuery(name = "TblInstitucion.findByInstTipDes", query = "SELECT t FROM TblInstitucion t WHERE t.instTipDes = :instTipDes")
    , @NamedQuery(name = "TblInstitucion.findByInstDesUdaf", query = "SELECT t FROM TblInstitucion t WHERE t.instDesUdaf = :instDesUdaf")
    , @NamedQuery(name = "TblInstitucion.findByInstFechaCreacion", query = "SELECT t FROM TblInstitucion t WHERE t.instFechaCreacion = :instFechaCreacion")
    , @NamedQuery(name = "TblInstitucion.findByInstFechaRegistro", query = "SELECT t FROM TblInstitucion t WHERE t.instFechaRegistro = :instFechaRegistro")
    , @NamedQuery(name = "TblInstitucion.findByInstFechaActivar", query = "SELECT t FROM TblInstitucion t WHERE t.instFechaActivar = :instFechaActivar")
    , @NamedQuery(name = "TblInstitucion.findByInstVerificador", query = "SELECT t FROM TblInstitucion t WHERE t.instVerificador = :instVerificador")
    , @NamedQuery(name = "TblInstitucion.findByInstEstado", query = "SELECT t FROM TblInstitucion t WHERE t.instEstado = :instEstado")
    , @NamedQuery(name = "TblInstitucion.findByInstPeriodo", query = "SELECT t FROM TblInstitucion t WHERE t.instPeriodo = :instPeriodo")
    , @NamedQuery(name = "TblInstitucion.findByInstRucDoc", query = "SELECT t FROM TblInstitucion t WHERE t.instRucDoc = :instRucDoc")})
@Data
@AllArgsConstructor
@Builder
public class TblInstitucion implements Serializable {

  

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inst_cod", nullable = false)
    private Integer instCod;
    @Basic(optional = false)
    @Column(name = "inst_ruc", nullable = false, length = 14)
    private String instRuc;
    @Basic(optional = false)
    @Column(name = "inst_nom", nullable = false, length = 500)
    private String instNom;
    @Column(name = "prov_cod")
    private Integer provCod;
    @Column(name = "cant_cod")
    private Integer cantCod;
    @Column(name = "parro_cod")
    private Integer parroCod;
    @Column(name = "inst_dir", length = 1000)
    private String instDir;
    @Column(name = "inst_tel", length = 15)
    private String instTel;
    @Column(name = "inst_ema", length = 250)
    private String instEma;
    @Column(name = "inst_pag", length = 1000)
    private String instPag;
    @Basic(optional = false)
    @Column(name = "inst_tip_des", nullable = false, length = 500)
    private String instTipDes;
    @Basic(optional = false)
    @Column(name = "inst_des_udaf", nullable = false, length = 500)
    private String instDesUdaf;
    @Basic(optional = false)
    @Column(name = "inst_fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date instFechaCreacion;
    @Column(name = "inst_fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date instFechaRegistro;
    @Column(name = "inst_fecha_activar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date instFechaActivar;
    @Column(name = "inst_verificador", length = 50)
    private String instVerificador;
    @Basic(optional = false)
    @Column(name = "inst_estado", nullable = false, length = 15)
    private String instEstado;
    @Basic(optional = false)
    @Column(name = "inst_periodo", nullable = false)
    private int instPeriodo;
    @Column(name = "inst_ruc_doc", length = 500)
    private String instRucDoc;
    @JoinColumn(name = "inst_fun_cod", referencedColumnName = "fun_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblFuncion instFunCod;
    @JoinColumn(name = "inst_sec_cod", referencedColumnName = "sec_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblSector instSecCod;
    @JoinColumn(name = "inst_tf_cod", referencedColumnName = "tf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblTipoInforme instTfCod;
    @JoinColumn(name = "inst_tme_cod", referencedColumnName = "tme_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblTipoMedio instTmeCod;
    @JoinColumn(name = "ties_cod", referencedColumnName = "ties_cod",      nullable = false)
    @ManyToOne(optional = false)
    private TblTipoIes tiesCod;
	
    public TblInstitucion() {
		
	}

	public TblInstitucion(Integer instCod) {
		super();
		this.instCod = instCod;
	}

	

	public TblInstitucion(Integer instCod, int instPeriodo) {
		this.instCod = instCod;
		this.instPeriodo = instPeriodo;
	}

	public Integer getInstCod() {
		return instCod;
	}

	public void setInstCod(Integer instCod) {
		this.instCod = instCod;
	}

	public String getInstRuc() {
		return instRuc;
	}

	public void setInstRuc(String instRuc) {
		this.instRuc = instRuc;
	}

	public String getInstNom() {
		return instNom;
	}

	public void setInstNom(String instNom) {
		this.instNom = instNom;
	}

	public Integer getProvCod() {
		return provCod;
	}

	public void setProvCod(Integer provCod) {
		this.provCod = provCod;
	}

	public Integer getCantCod() {
		return cantCod;
	}

	public void setCantCod(Integer cantCod) {
		this.cantCod = cantCod;
	}

	public Integer getParroCod() {
		return parroCod;
	}

	public void setParroCod(Integer parroCod) {
		this.parroCod = parroCod;
	}

	public String getInstDir() {
		return instDir;
	}

	public void setInstDir(String instDir) {
		this.instDir = instDir;
	}

	public String getInstTel() {
		return instTel;
	}

	public void setInstTel(String instTel) {
		this.instTel = instTel;
	}

	public String getInstEma() {
		return instEma;
	}

	public void setInstEma(String instEma) {
		this.instEma = instEma;
	}

	public String getInstPag() {
		return instPag;
	}

	public void setInstPag(String instPag) {
		this.instPag = instPag;
	}

	public String getInstTipDes() {
		return instTipDes;
	}

	public void setInstTipDes(String instTipDes) {
		this.instTipDes = instTipDes;
	}

	public String getInstDesUdaf() {
		return instDesUdaf;
	}

	public void setInstDesUdaf(String instDesUdaf) {
		this.instDesUdaf = instDesUdaf;
	}

	public Date getInstFechaCreacion() {
		return instFechaCreacion;
	}

	public void setInstFechaCreacion(Date instFechaCreacion) {
		this.instFechaCreacion = instFechaCreacion;
	}

	public Date getInstFechaRegistro() {
		return instFechaRegistro;
	}

	public void setInstFechaRegistro(Date instFechaRegistro) {
		this.instFechaRegistro = instFechaRegistro;
	}

	public Date getInstFechaActivar() {
		return instFechaActivar;
	}

	public void setInstFechaActivar(Date instFechaActivar) {
		this.instFechaActivar = instFechaActivar;
	}

	public String getInstVerificador() {
		return instVerificador;
	}

	public void setInstVerificador(String instVerificador) {
		this.instVerificador = instVerificador;
	}

	public String getInstEstado() {
		return instEstado;
	}

	public void setInstEstado(String instEstado) {
		this.instEstado = instEstado;
	}

	public int getInstPeriodo() {
		return instPeriodo;
	}

	public void setInstPeriodo(int instPeriodo) {
		this.instPeriodo = instPeriodo;
	}

	public String getInstRucDoc() {
		return instRucDoc;
	}

	public void setInstRucDoc(String instRucDoc) {
		this.instRucDoc = instRucDoc;
	}

	public TblFuncion getInstFunCod() {
		return instFunCod;
	}

	public void setInstFunCod(TblFuncion instFunCod) {
		this.instFunCod = instFunCod;
	}

	public TblSector getInstSecCod() {
		return instSecCod;
	}

	public void setInstSecCod(TblSector instSecCod) {
		this.instSecCod = instSecCod;
	}

	public TblTipoInforme getInstTfCod() {
		return instTfCod;
	}

	public void setInstTfCod(TblTipoInforme instTfCod) {
		this.instTfCod = instTfCod;
	}

	public TblTipoMedio getInstTmeCod() {
		return instTmeCod;
	}

	public void setInstTmeCod(TblTipoMedio instTmeCod) {
		this.instTmeCod = instTmeCod;
	}

	public TblTipoIes getTiesCod() {
		return tiesCod;
	}

	public void setTiesCod(TblTipoIes tiesCod) {
		this.tiesCod = tiesCod;
	}
	
	// Getter y Setter para instPeriodo como String
    public String getInstPeriodoAsString() {
        return String.valueOf(instPeriodo);
    }

    public void setInstPeriodoFromString(String instPeriodo) {
        try {
            this.instPeriodo = Integer.parseInt(instPeriodo);
        } catch (NumberFormatException e) {
            // Manejar la excepción si la cadena no puede ser parseada a un entero
            // Por ejemplo, puedes establecer un valor predeterminado o lanzar una excepción personalizada
            this.instPeriodo = 0; // O cualquier otro valor predeterminado
        }
    }

    

    
}
