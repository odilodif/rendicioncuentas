/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.catalogos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Wilmer
 */
@Entity
@Table(name = "tbl_tipo_ies", catalog = "rendiciondb", schema = "esq_catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipoIes.findAll", query = "SELECT t FROM TblTipoMedio t")
    , @NamedQuery(name = "TblTipoIes.findByIesCod", query = "SELECT t FROM TblTipoIes t WHERE t.tiesCod = :tiesCod")
    , @NamedQuery(name = "TblTipoIes.findByIesDes", query = "SELECT t FROM TblTipoIes t WHERE t.tiesDes = :tiesDes")
    , @NamedQuery(name = "TblTipoIes.findByIesEst", query = "SELECT t FROM TblTipoIes t WHERE t.tiesEst = :tiesEst")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblTipoIes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ties_cod", nullable = false)
    private Integer tiesCod;
    @Column(name = "ties_des", length = 100)
    private String tiesDes;
    @Column(name = "ties_est", length = 10)
    private String tiesEst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiesCod")
    private List<TblInstitucion> tblInstitucionList;

    
}
