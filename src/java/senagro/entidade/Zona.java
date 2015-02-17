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
@Table(name = "zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z"),
    @NamedQuery(name = "Zona.findByIdZona", query = "SELECT z FROM Zona z WHERE z.idZona = :idZona"),
    @NamedQuery(name = "Zona.findByEmpresaIdEmpresa", query = "SELECT z FROM Zona z WHERE z.empresaIdEmpresa = :empresaIdEmpresa"),
    @NamedQuery(name = "Zona.findByNombreZona", query = "SELECT z FROM Zona z WHERE z.nombreZona = :nombreZona"),
    @NamedQuery(name = "Zona.findByUbicacionZona", query = "SELECT z FROM Zona z WHERE z.ubicacionZona = :ubicacionZona")})
public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_zona")
    private Integer idZona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_id_empresa")
    private int empresaIdEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_zona")
    private String nombreZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ubicacion_zona")
    private String ubicacionZona;

    public Zona() {
    }

    public Zona(Integer idZona) {
        this.idZona = idZona;
    }

    public Zona(Integer idZona, int empresaIdEmpresa, String nombreZona, String ubicacionZona) {
        this.idZona = idZona;
        this.empresaIdEmpresa = empresaIdEmpresa;
        this.nombreZona = nombreZona;
        this.ubicacionZona = ubicacionZona;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public int getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(int empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getUbicacionZona() {
        return ubicacionZona;
    }

    public void setUbicacionZona(String ubicacionZona) {
        this.ubicacionZona = ubicacionZona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZona != null ? idZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.idZona == null && other.idZona != null) || (this.idZona != null && !this.idZona.equals(other.idZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Zona[ idZona=" + idZona + " ]";
    }
    
}
