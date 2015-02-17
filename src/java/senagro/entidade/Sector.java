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
@Table(name = "sector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s"),
    @NamedQuery(name = "Sector.findByIdSector", query = "SELECT s FROM Sector s WHERE s.idSector = :idSector"),
    @NamedQuery(name = "Sector.findByFincaidfinca", query = "SELECT s FROM Sector s WHERE s.fincaidfinca = :fincaidfinca"),
    @NamedQuery(name = "Sector.findByAreaNetaHAidAaeanetaha", query = "SELECT s FROM Sector s WHERE s.areaNetaHAidAaeanetaha = :areaNetaHAidAaeanetaha")})
public class Sector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sector")
    private Integer idSector;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Finca_id_finca")
    private int fincaidfinca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Area_Neta_HA_idAaea_neta_ha")
    private int areaNetaHAidAaeanetaha;

    public Sector() {
    }

    public Sector(Integer idSector) {
        this.idSector = idSector;
    }

    public Sector(Integer idSector, int fincaidfinca, int areaNetaHAidAaeanetaha) {
        this.idSector = idSector;
        this.fincaidfinca = fincaidfinca;
        this.areaNetaHAidAaeanetaha = areaNetaHAidAaeanetaha;
    }

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

    public int getFincaidfinca() {
        return fincaidfinca;
    }

    public void setFincaidfinca(int fincaidfinca) {
        this.fincaidfinca = fincaidfinca;
    }

    public int getAreaNetaHAidAaeanetaha() {
        return areaNetaHAidAaeanetaha;
    }

    public void setAreaNetaHAidAaeanetaha(int areaNetaHAidAaeanetaha) {
        this.areaNetaHAidAaeanetaha = areaNetaHAidAaeanetaha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSector != null ? idSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idSector == null && other.idSector != null) || (this.idSector != null && !this.idSector.equals(other.idSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Sector[ idSector=" + idSector + " ]";
    }
    
}
