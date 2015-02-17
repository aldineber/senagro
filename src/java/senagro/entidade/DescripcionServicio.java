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
@Table(name = "descripcion_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionServicio.findAll", query = "SELECT d FROM DescripcionServicio d"),
    @NamedQuery(name = "DescripcionServicio.findByIdServivio", query = "SELECT d FROM DescripcionServicio d WHERE d.idServivio = :idServivio"),
    @NamedQuery(name = "DescripcionServicio.findByProveedorIdProveedor", query = "SELECT d FROM DescripcionServicio d WHERE d.proveedorIdProveedor = :proveedorIdProveedor"),
    @NamedQuery(name = "DescripcionServicio.findByPosicion", query = "SELECT d FROM DescripcionServicio d WHERE d.posicion = :posicion"),
    @NamedQuery(name = "DescripcionServicio.findByTarifa", query = "SELECT d FROM DescripcionServicio d WHERE d.tarifa = :tarifa"),
    @NamedQuery(name = "DescripcionServicio.findByDescripcionServicio", query = "SELECT d FROM DescripcionServicio d WHERE d.descripcionServicio = :descripcionServicio"),
    @NamedQuery(name = "DescripcionServicio.findByUnidad", query = "SELECT d FROM DescripcionServicio d WHERE d.unidad = :unidad"),
    @NamedQuery(name = "DescripcionServicio.findByPrioridad", query = "SELECT d FROM DescripcionServicio d WHERE d.prioridad = :prioridad")})
public class DescripcionServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servivio")
    private Integer idServivio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proveedor_id_proveedor")
    private int proveedorIdProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "posicion")
    private String posicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tarifa")
    private String tarifa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion_servicio")
    private String descripcionServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unidad")
    private String unidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prioridad")
    private String prioridad;

    public DescripcionServicio() {
    }

    public DescripcionServicio(Integer idServivio) {
        this.idServivio = idServivio;
    }

    public DescripcionServicio(Integer idServivio, int proveedorIdProveedor, String posicion, String tarifa, String descripcionServicio, String unidad, String prioridad) {
        this.idServivio = idServivio;
        this.proveedorIdProveedor = proveedorIdProveedor;
        this.posicion = posicion;
        this.tarifa = tarifa;
        this.descripcionServicio = descripcionServicio;
        this.unidad = unidad;
        this.prioridad = prioridad;
    }

    public Integer getIdServivio() {
        return idServivio;
    }

    public void setIdServivio(Integer idServivio) {
        this.idServivio = idServivio;
    }

    public int getProveedorIdProveedor() {
        return proveedorIdProveedor;
    }

    public void setProveedorIdProveedor(int proveedorIdProveedor) {
        this.proveedorIdProveedor = proveedorIdProveedor;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServivio != null ? idServivio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionServicio)) {
            return false;
        }
        DescripcionServicio other = (DescripcionServicio) object;
        if ((this.idServivio == null && other.idServivio != null) || (this.idServivio != null && !this.idServivio.equals(other.idServivio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.DescripcionServicio[ idServivio=" + idServivio + " ]";
    }
    
}
