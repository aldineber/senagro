/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senagro.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johann
 */
@Entity
@Table(name = "area_neta_ha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaNetaHa.findAll", query = "SELECT a FROM AreaNetaHa a"),
    @NamedQuery(name = "AreaNetaHa.findByIdAreaNetaHa", query = "SELECT a FROM AreaNetaHa a WHERE a.idAreaNetaHa = :idAreaNetaHa"),
    @NamedQuery(name = "AreaNetaHa.findByAreaNeta", query = "SELECT a FROM AreaNetaHa a WHERE a.areaNeta = :areaNeta")})
public class AreaNetaHa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_area_neta_ha")
    private Integer idAreaNetaHa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area_neta")
    private double areaNeta;

    public AreaNetaHa() {
    }

    public AreaNetaHa(Integer idAreaNetaHa) {
        this.idAreaNetaHa = idAreaNetaHa;
    }

    public AreaNetaHa(Integer idAreaNetaHa, double areaNeta) {
        this.idAreaNetaHa = idAreaNetaHa;
        this.areaNeta = areaNeta;
    }

    public Integer getIdAreaNetaHa() {
        return idAreaNetaHa;
    }

    public void setIdAreaNetaHa(Integer idAreaNetaHa) {
        this.idAreaNetaHa = idAreaNetaHa;
    }

    public double getAreaNeta() {
        return areaNeta;
    }

    public void setAreaNeta(double areaNeta) {
        this.areaNeta = areaNeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaNetaHa != null ? idAreaNetaHa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaNetaHa)) {
            return false;
        }
        AreaNetaHa other = (AreaNetaHa) object;
        if ((this.idAreaNetaHa == null && other.idAreaNetaHa != null) || (this.idAreaNetaHa != null && !this.idAreaNetaHa.equals(other.idAreaNetaHa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.AreaNetaHa[ idAreaNetaHa=" + idAreaNetaHa + " ]";
    }
    
}
