/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.gestion;

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
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringEscapeUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import gob.cpccs.utilidades.Constantes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_propuestas_fin", catalog = "rendiciondb", schema = "esq_gestion")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblPropuestasFin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id", nullable = false)
    private Integer proId;
    @Column(name = "pro_descripcion", length = 2147483647)
    private String proDescripcion;
    @Column(name = "pro_resultados", length = 2147483647)
    private String proResultados;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod")
    @ManyToOne
    private TblInformeAutoridadFin infAutCod;

  
}
