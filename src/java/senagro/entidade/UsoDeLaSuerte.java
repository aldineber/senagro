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
@Table(name = "uso_de_la_suerte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsoDeLaSuerte.findAll", query = "SELECT u FROM UsoDeLaSuerte u"),
    @NamedQuery(name = "UsoDeLaSuerte.findByIdUsoDeLaSuerte", query = "SELECT u FROM UsoDeLaSuerte u WHERE u.idUsoDeLaSuerte = :idUsoDeLaSuerte"),
    @NamedQuery(name = "UsoDeLaSuerte.findByNombreSiembra", query = "SELECT u FROM UsoDeLaSuerte u WHERE u.nombreSiembra = :nombreSiembra"),
    @NamedQuery(name = "UsoDeLaSuerte.findByCultivo", query = "SELECT u FROM UsoDeLaSuerte u WHERE u.cultivo = :cultivo")})
public class UsoDeLaSuerte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_uso_de_la_suerte")
    private Integer idUsoDeLaSuerte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_siembra")
    private String nombreSiembra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cultivo")
    private String cultivo;

    public UsoDeLaSuerte() {
    }

    public UsoDeLaSuerte(Integer idUsoDeLaSuerte) {
        this.idUsoDeLaSuerte = idUsoDeLaSuerte;
    }

    public UsoDeLaSuerte(Integer idUsoDeLaSuerte, String nombreSiembra, String cultivo) {
        this.idUsoDeLaSuerte = idUsoDeLaSuerte;
        this.nombreSiembra = nombreSiembra;
        this.cultivo = cultivo;
    }

    public Integer getIdUsoDeLaSuerte() {
        return idUsoDeLaSuerte;
    }

    public void setIdUsoDeLaSuerte(Integer idUsoDeLaSuerte) {
        this.idUsoDeLaSuerte = idUsoDeLaSuerte;
    }

    public String getNombreSiembra() {
        return nombreSiembra;
    }

    public void setNombreSiembra(String nombreSiembra) {
        this.nombreSiembra = nombreSiembra;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsoDeLaSuerte != null ? idUsoDeLaSuerte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoDeLaSuerte)) {
            return false;
        }
        UsoDeLaSuerte other = (UsoDeLaSuerte) object;
        if ((this.idUsoDeLaSuerte == null && other.idUsoDeLaSuerte != null) || (this.idUsoDeLaSuerte != null && !this.idUsoDeLaSuerte.equals(other.idUsoDeLaSuerte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.UsoDeLaSuerte[ idUsoDeLaSuerte=" + idUsoDeLaSuerte + " ]";
    }
    
}
