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

import gob.cpccs.model.dto.rendicion.TblAportesCiudadanosDTO;
import gob.cpccs.utilidades.Constantes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_amecanismos_pc_fin", catalog = "rendiciondb", schema = "esq_gestion")
@XmlRootElement
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Getter
@Setter
public class TblAmecanismosPcFin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ame_cod", nullable = false)
    private Integer ameCod;
    @Basic(optional = false)
    @Column(name = "ame_desc", nullable = false, length = 4)
    private String ameDesc;
    @Basic(optional = false)
    @Column(name = "ame_medio", nullable = false, length = 2147483647)
    private String ameMedio;
    @Basic(optional = false)
    @Column(name = "ame_tipo", nullable = false, length = 50)
    private String ameTipo;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInformeAutoridadFin infAutCod;

  
    
}
