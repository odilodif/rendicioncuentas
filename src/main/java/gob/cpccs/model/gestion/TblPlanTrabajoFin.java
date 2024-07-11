package gob.cpccs.model.gestion;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_plan_trabajo_fin", catalog = "rendiciondb", schema = "esq_gestion")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblPlanTrabajoFin implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "plt_cod", nullable = false)
    private Integer pltCod;
    @Column(name = "plt_plan", length = 2147483647)
    private String pltPlan;
    @Column(name = "ptl_acciones", length = 2147483647)
    private String ptlAcciones;
    @Column(name = "ptl_resultados", length = 2147483647)
    private String ptlResultados;
    @Column(name = "ptl_obs", length = 2147483647)
    private String ptlObs;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInformeAutoridadFin infAutCod;


}
