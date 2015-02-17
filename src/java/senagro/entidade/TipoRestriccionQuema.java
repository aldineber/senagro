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
@Table(name = "tipo_restriccion_quema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRestriccionQuema.findAll", query = "SELECT t FROM TipoRestriccionQuema t"),
    @NamedQuery(name = "TipoRestriccionQuema.findByIdTipoRestrincion", query = "SELECT t FROM TipoRestriccionQuema t WHERE t.idTipoRestrincion = :idTipoRestrincion"),
    @NamedQuery(name = "TipoRestriccionQuema.findByNombreRestriccion", query = "SELECT t FROM TipoRestriccionQuema t WHERE t.nombreRestriccion = :nombreRestriccion"),
    @NamedQuery(name = "TipoRestriccionQuema.findByAreaRestrincionHa", query = "SELECT t FROM TipoRestriccionQuema t WHERE t.areaRestrincionHa = :areaRestrincionHa")})
public class TipoRestriccionQuema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_restrincion")
    private Integer idTipoRestrincion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_restriccion")
    private String nombreRestriccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area_restrincion_ha")
    private double areaRestrincionHa;

    public TipoRestriccionQuema() {
    }

    public TipoRestriccionQuema(Integer idTipoRestrincion) {
        this.idTipoRestrincion = idTipoRestrincion;
    }

    public TipoRestriccionQuema(Integer idTipoRestrincion, String nombreRestriccion, double areaRestrincionHa) {
        this.idTipoRestrincion = idTipoRestrincion;
        this.nombreRestriccion = nombreRestriccion;
        this.areaRestrincionHa = areaRestrincionHa;
    }

    public Integer getIdTipoRestrincion() {
        return idTipoRestrincion;
    }

    public void setIdTipoRestrincion(Integer idTipoRestrincion) {
        this.idTipoRestrincion = idTipoRestrincion;
    }

    public String getNombreRestriccion() {
        return nombreRestriccion;
    }

    public void setNombreRestriccion(String nombreRestriccion) {
        this.nombreRestriccion = nombreRestriccion;
    }

    public double getAreaRestrincionHa() {
        return areaRestrincionHa;
    }

    public void setAreaRestrincionHa(double areaRestrincionHa) {
        this.areaRestrincionHa = areaRestrincionHa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRestrincion != null ? idTipoRestrincion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRestriccionQuema)) {
            return false;
        }
        TipoRestriccionQuema other = (TipoRestriccionQuema) object;
        if ((this.idTipoRestrincion == null && other.idTipoRestrincion != null) || (this.idTipoRestrincion != null && !this.idTipoRestrincion.equals(other.idTipoRestrincion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.TipoRestriccionQuema[ idTipoRestrincion=" + idTipoRestrincion + " ]";
    }
    
}
