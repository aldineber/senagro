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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Empresa.findByDireccionEmpresa", query = "SELECT e FROM Empresa e WHERE e.direccionEmpresa = :direccionEmpresa"),
    @NamedQuery(name = "Empresa.findByTelefonoFijoEmpresa", query = "SELECT e FROM Empresa e WHERE e.telefonoFijoEmpresa = :telefonoFijoEmpresa"),
    @NamedQuery(name = "Empresa.findByTelefonoCelularEmpresa", query = "SELECT e FROM Empresa e WHERE e.telefonoCelularEmpresa = :telefonoCelularEmpresa"),
    @NamedQuery(name = "Empresa.findByCorreoEmpresa", query = "SELECT e FROM Empresa e WHERE e.correoEmpresa = :correoEmpresa")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion_empresa")
    private String direccionEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_fijo_empresa")
    private int telefonoFijoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_celular_empresa")
    private int telefonoCelularEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "correo_empresa")
    private String correoEmpresa;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String nombreEmpresa, String direccionEmpresa, int telefonoFijoEmpresa, int telefonoCelularEmpresa, String correoEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoFijoEmpresa = telefonoFijoEmpresa;
        this.telefonoCelularEmpresa = telefonoCelularEmpresa;
        this.correoEmpresa = correoEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public int getTelefonoFijoEmpresa() {
        return telefonoFijoEmpresa;
    }

    public void setTelefonoFijoEmpresa(int telefonoFijoEmpresa) {
        this.telefonoFijoEmpresa = telefonoFijoEmpresa;
    }

    public int getTelefonoCelularEmpresa() {
        return telefonoCelularEmpresa;
    }

    public void setTelefonoCelularEmpresa(int telefonoCelularEmpresa) {
        this.telefonoCelularEmpresa = telefonoCelularEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
