/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.gestion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_informe_autoridad_fin", catalog = "rendiciondb", schema = "esq_gestion")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblInformeAutoridadFin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inf_aut_cod", nullable = false)
    private Integer infAutCod;
    @Basic(optional = false)
    @Column(name = "identificador")
    private String identificador;
    @Basic(optional = false)
    @Column(name = "inf_aut_periodo")
    private int infAutPeriodo;
    @Column(name = "inf_aut_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutDesde;
    @Column(name = "inf_aut_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutHasta;
    @Column(name = "inf_aut_fechain")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutFechain;
    @Column(name = "inf_aut_fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infAutFechafin;
    @Column(name = "inf_aut_verificador", length = 15)
    private String infAutVerificador;
    @Column(name = "inf_aut_estado", length = 15)
    private String infAutEstado;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "infAutCod",orphanRemoval = true)
    private List<TblFuncionesAutoridadesFin> tblFuncionesAutoridadesList;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "infAutCod",orphanRemoval = true)
    private List<TblAmecanismosPcFin> tblAmecanismosPcList;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "infAutCod",orphanRemoval = true)
    private List<TblPropuestasFin> tblPropuestasList;
    @Column(name = "inf_aut_fecha_rendicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRendicion;
    @Column(name = "inf_aut_lugar", length = 255)
    private String lugar;
    @Column(name = "inf_aut_numero_asistentes")
    private Integer numeroAsistentes;
    @Column(name = "inf_aut_medio_tributario", length = 255)
    private String infAutMedioTributario;
    @Column(name = "inf_aut_tributo", length = 15)
    private String infAutTributo;
    @Column(name = "ina_proceso_rc", length = 255)
    private String inaProcesoRc;
    @Column(name = "ina_aportes_ciu", length = 4)
    private String inaAportesCiu;
    @Basic(optional = false)
    @Column(name = "inf_contador_apertura")
    private Integer infContadorApertura;
   
    
    
}
