/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.gestion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "tbl_funciones_autoridades_fin", catalog = "rendiciondb", schema = "esq_gestion")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblFuncionesAutoridadesFin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fa_cod", nullable = false)
    private Integer faCod;
    @Column(name = "fa_funcion", length = 2147483647)
    private String faFuncion;
    @Column(name = "fa_acciones", length = 2147483647)
    private String faAcciones;
    @Column(name = "fa_resultado", length = 2147483647)
    private String faResultado;
    @Column(name = "fa_obs", length = 2147483647)
    private String faObs;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod", nullable = false)
    @ManyToOne( optional = false)
    private TblInformeAutoridadFin infAutCod;

}
