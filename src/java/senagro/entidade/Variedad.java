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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johann
 */
@Entity
@Table(name = "variedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variedad.findAll", query = "SELECT v FROM Variedad v"),
    @NamedQuery(name = "Variedad.findByIdVariedad", query = "SELECT v FROM Variedad v WHERE v.idVariedad = :idVariedad"),
    @NamedQuery(name = "Variedad.findByTipoVariedad", query = "SELECT v FROM Variedad v WHERE v.tipoVariedad = :tipoVariedad")})
public class Variedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_variedad")
    private Integer idVariedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo_variedad")
    private String tipoVariedad;

    public Variedad() {
    }

    public Variedad(Integer idVariedad) {
        this.idVariedad = idVariedad;
    }

    public Variedad(Integer idVariedad, String tipoVariedad) {
        this.idVariedad = idVariedad;
        this.tipoVariedad = tipoVariedad;
    }

    public Integer getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(Integer idVariedad) {
        this.idVariedad = idVariedad;
    }

    public String getTipoVariedad() {
        return tipoVariedad;
    }

    public void setTipoVariedad(String tipoVariedad) {
        this.tipoVariedad = tipoVariedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariedad != null ? idVariedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variedad)) {
            return false;
        }
        Variedad other = (Variedad) object;
        if ((this.idVariedad == null && other.idVariedad != null) || (this.idVariedad != null && !this.idVariedad.equals(other.idVariedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Variedad[ idVariedad=" + idVariedad + " ]";
    }
    
}
