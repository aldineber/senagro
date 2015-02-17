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
@Table(name = "suerte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suerte.findAll", query = "SELECT s FROM Suerte s"),
    @NamedQuery(name = "Suerte.findByCodigoUniSuerte", query = "SELECT s FROM Suerte s WHERE s.codigoUniSuerte = :codigoUniSuerte"),
    @NamedQuery(name = "Suerte.findBySectoridsector", query = "SELECT s FROM Suerte s WHERE s.sectoridsector = :sectoridsector"),
    @NamedQuery(name = "Suerte.findByIdSuerte", query = "SELECT s FROM Suerte s WHERE s.idSuerte = :idSuerte")})
public class Suerte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_uni_suerte")
    private Integer codigoUniSuerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sector_id_sector")
    private int sectoridsector;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_suerte")
    private int idSuerte;

    public Suerte() {
    }

    public Suerte(Integer codigoUniSuerte) {
        this.codigoUniSuerte = codigoUniSuerte;
    }

    public Suerte(Integer codigoUniSuerte, int sectoridsector, int idSuerte) {
        this.codigoUniSuerte = codigoUniSuerte;
        this.sectoridsector = sectoridsector;
        this.idSuerte = idSuerte;
    }

    public Integer getCodigoUniSuerte() {
        return codigoUniSuerte;
    }

    public void setCodigoUniSuerte(Integer codigoUniSuerte) {
        this.codigoUniSuerte = codigoUniSuerte;
    }

    public int getSectoridsector() {
        return sectoridsector;
    }

    public void setSectoridsector(int sectoridsector) {
        this.sectoridsector = sectoridsector;
    }

    public int getIdSuerte() {
        return idSuerte;
    }

    public void setIdSuerte(int idSuerte) {
        this.idSuerte = idSuerte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUniSuerte != null ? codigoUniSuerte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suerte)) {
            return false;
        }
        Suerte other = (Suerte) object;
        if ((this.codigoUniSuerte == null && other.codigoUniSuerte != null) || (this.codigoUniSuerte != null && !this.codigoUniSuerte.equals(other.codigoUniSuerte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Suerte[ codigoUniSuerte=" + codigoUniSuerte + " ]";
    }
    
}
