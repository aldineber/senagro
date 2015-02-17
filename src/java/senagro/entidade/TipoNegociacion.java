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
@Table(name = "tipo_negociacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoNegociacion.findAll", query = "SELECT t FROM TipoNegociacion t"),
    @NamedQuery(name = "TipoNegociacion.findByIdTipoNegociacion", query = "SELECT t FROM TipoNegociacion t WHERE t.idTipoNegociacion = :idTipoNegociacion"),
    @NamedQuery(name = "TipoNegociacion.findByNombreNegociacion", query = "SELECT t FROM TipoNegociacion t WHERE t.nombreNegociacion = :nombreNegociacion")})
public class TipoNegociacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_negociacion")
    private Integer idTipoNegociacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_negociacion")
    private String nombreNegociacion;

    public TipoNegociacion() {
    }

    public TipoNegociacion(Integer idTipoNegociacion) {
        this.idTipoNegociacion = idTipoNegociacion;
    }

    public TipoNegociacion(Integer idTipoNegociacion, String nombreNegociacion) {
        this.idTipoNegociacion = idTipoNegociacion;
        this.nombreNegociacion = nombreNegociacion;
    }

    public Integer getIdTipoNegociacion() {
        return idTipoNegociacion;
    }

    public void setIdTipoNegociacion(Integer idTipoNegociacion) {
        this.idTipoNegociacion = idTipoNegociacion;
    }

    public String getNombreNegociacion() {
        return nombreNegociacion;
    }

    public void setNombreNegociacion(String nombreNegociacion) {
        this.nombreNegociacion = nombreNegociacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoNegociacion != null ? idTipoNegociacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoNegociacion)) {
            return false;
        }
        TipoNegociacion other = (TipoNegociacion) object;
        if ((this.idTipoNegociacion == null && other.idTipoNegociacion != null) || (this.idTipoNegociacion != null && !this.idTipoNegociacion.equals(other.idTipoNegociacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.TipoNegociacion[ idTipoNegociacion=" + idTipoNegociacion + " ]";
    }
    
}
