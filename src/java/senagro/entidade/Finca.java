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
@Table(name = "finca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finca.findAll", query = "SELECT f FROM Finca f"),
    @NamedQuery(name = "Finca.findByIdFinca", query = "SELECT f FROM Finca f WHERE f.idFinca = :idFinca"),
    @NamedQuery(name = "Finca.findByZonaIdZona", query = "SELECT f FROM Finca f WHERE f.zonaIdZona = :zonaIdZona"),
    @NamedQuery(name = "Finca.findByTipoFinca", query = "SELECT f FROM Finca f WHERE f.tipoFinca = :tipoFinca"),
    @NamedQuery(name = "Finca.findByNombreFinca", query = "SELECT f FROM Finca f WHERE f.nombreFinca = :nombreFinca"),
    @NamedQuery(name = "Finca.findByUbicacionGeografica", query = "SELECT f FROM Finca f WHERE f.ubicacionGeografica = :ubicacionGeografica")})
public class Finca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_finca")
    private Integer idFinca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zona_id_zona")
    private int zonaIdZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo_finca")
    private String tipoFinca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_finca")
    private String nombreFinca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ubicacion_geografica")
    private double ubicacionGeografica;

    public Finca() {
    }

    public Finca(Integer idFinca) {
        this.idFinca = idFinca;
    }

    public Finca(Integer idFinca, int zonaIdZona, String tipoFinca, String nombreFinca, double ubicacionGeografica) {
        this.idFinca = idFinca;
        this.zonaIdZona = zonaIdZona;
        this.tipoFinca = tipoFinca;
        this.nombreFinca = nombreFinca;
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public Integer getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Integer idFinca) {
        this.idFinca = idFinca;
    }

    public int getZonaIdZona() {
        return zonaIdZona;
    }

    public void setZonaIdZona(int zonaIdZona) {
        this.zonaIdZona = zonaIdZona;
    }

    public String getTipoFinca() {
        return tipoFinca;
    }

    public void setTipoFinca(String tipoFinca) {
        this.tipoFinca = tipoFinca;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }

    public double getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(double ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFinca != null ? idFinca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finca)) {
            return false;
        }
        Finca other = (Finca) object;
        if ((this.idFinca == null && other.idFinca != null) || (this.idFinca != null && !this.idFinca.equals(other.idFinca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Finca[ idFinca=" + idFinca + " ]";
    }
    
}
