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
@Table(name = "seccion_suerte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeccionSuerte.findAll", query = "SELECT s FROM SeccionSuerte s"),
    @NamedQuery(name = "SeccionSuerte.findByCodigoSec", query = "SELECT s FROM SeccionSuerte s WHERE s.codigoSec = :codigoSec"),
    @NamedQuery(name = "SeccionSuerte.findBySuerteCodigoUniSuerte", query = "SELECT s FROM SeccionSuerte s WHERE s.suerteCodigoUniSuerte = :suerteCodigoUniSuerte"),
    @NamedQuery(name = "SeccionSuerte.findByIdSector", query = "SELECT s FROM SeccionSuerte s WHERE s.idSector = :idSector"),
    @NamedQuery(name = "SeccionSuerte.findBySubdivision", query = "SELECT s FROM SeccionSuerte s WHERE s.subdivision = :subdivision")})
public class SeccionSuerte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Codigo_Sec")
    private Integer codigoSec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_codigo_uni_suerte")
    private int suerteCodigoUniSuerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sector")
    private int idSector;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subdivision")
    private int subdivision;

    public SeccionSuerte() {
    }

    public SeccionSuerte(Integer codigoSec) {
        this.codigoSec = codigoSec;
    }

    public SeccionSuerte(Integer codigoSec, int suerteCodigoUniSuerte, int idSector, int subdivision) {
        this.codigoSec = codigoSec;
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
        this.idSector = idSector;
        this.subdivision = subdivision;
    }

    public Integer getCodigoSec() {
        return codigoSec;
    }

    public void setCodigoSec(Integer codigoSec) {
        this.codigoSec = codigoSec;
    }

    public int getSuerteCodigoUniSuerte() {
        return suerteCodigoUniSuerte;
    }

    public void setSuerteCodigoUniSuerte(int suerteCodigoUniSuerte) {
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public int getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(int subdivision) {
        this.subdivision = subdivision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSec != null ? codigoSec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeccionSuerte)) {
            return false;
        }
        SeccionSuerte other = (SeccionSuerte) object;
        if ((this.codigoSec == null && other.codigoSec != null) || (this.codigoSec != null && !this.codigoSec.equals(other.codigoSec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.SeccionSuerte[ codigoSec=" + codigoSec + " ]";
    }
    
}
