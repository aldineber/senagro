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
@Table(name = "labores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Labores.findAll", query = "SELECT l FROM Labores l"),
    @NamedQuery(name = "Labores.findByIdLaboresCampo", query = "SELECT l FROM Labores l WHERE l.idLaboresCampo = :idLaboresCampo"),
    @NamedQuery(name = "Labores.findByProveedoridproveedor", query = "SELECT l FROM Labores l WHERE l.proveedoridproveedor = :proveedoridproveedor"),
    @NamedQuery(name = "Labores.findByProgramacionLaboresIdUnicoLabor", query = "SELECT l FROM Labores l WHERE l.programacionLaboresIdUnicoLabor = :programacionLaboresIdUnicoLabor"),
    @NamedQuery(name = "Labores.findByZonaIdZona", query = "SELECT l FROM Labores l WHERE l.zonaIdZona = :zonaIdZona"),
    @NamedQuery(name = "Labores.findByTipoLabor", query = "SELECT l FROM Labores l WHERE l.tipoLabor = :tipoLabor"),
    @NamedQuery(name = "Labores.findByTiempoLabor", query = "SELECT l FROM Labores l WHERE l.tiempoLabor = :tiempoLabor"),
    @NamedQuery(name = "Labores.findByTercero", query = "SELECT l FROM Labores l WHERE l.tercero = :tercero")})
public class Labores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Labores_Campo")
    private Integer idLaboresCampo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Proveedor_id_proveedor")
    private int proveedoridproveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "programacion_labores_id_unico_labor")
    private int programacionLaboresIdUnicoLabor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zona_id_zona")
    private int zonaIdZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo_Labor")
    private String tipoLabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tiempo_Labor")
    private String tiempoLabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tercero")
    private String tercero;

    public Labores() {
    }

    public Labores(Integer idLaboresCampo) {
        this.idLaboresCampo = idLaboresCampo;
    }

    public Labores(Integer idLaboresCampo, int proveedoridproveedor, int programacionLaboresIdUnicoLabor, int zonaIdZona, String tipoLabor, String tiempoLabor, String tercero) {
        this.idLaboresCampo = idLaboresCampo;
        this.proveedoridproveedor = proveedoridproveedor;
        this.programacionLaboresIdUnicoLabor = programacionLaboresIdUnicoLabor;
        this.zonaIdZona = zonaIdZona;
        this.tipoLabor = tipoLabor;
        this.tiempoLabor = tiempoLabor;
        this.tercero = tercero;
    }

    public Integer getIdLaboresCampo() {
        return idLaboresCampo;
    }

    public void setIdLaboresCampo(Integer idLaboresCampo) {
        this.idLaboresCampo = idLaboresCampo;
    }

    public int getProveedoridproveedor() {
        return proveedoridproveedor;
    }

    public void setProveedoridproveedor(int proveedoridproveedor) {
        this.proveedoridproveedor = proveedoridproveedor;
    }

    public int getProgramacionLaboresIdUnicoLabor() {
        return programacionLaboresIdUnicoLabor;
    }

    public void setProgramacionLaboresIdUnicoLabor(int programacionLaboresIdUnicoLabor) {
        this.programacionLaboresIdUnicoLabor = programacionLaboresIdUnicoLabor;
    }

    public int getZonaIdZona() {
        return zonaIdZona;
    }

    public void setZonaIdZona(int zonaIdZona) {
        this.zonaIdZona = zonaIdZona;
    }

    public String getTipoLabor() {
        return tipoLabor;
    }

    public void setTipoLabor(String tipoLabor) {
        this.tipoLabor = tipoLabor;
    }

    public String getTiempoLabor() {
        return tiempoLabor;
    }

    public void setTiempoLabor(String tiempoLabor) {
        this.tiempoLabor = tiempoLabor;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLaboresCampo != null ? idLaboresCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Labores)) {
            return false;
        }
        Labores other = (Labores) object;
        if ((this.idLaboresCampo == null && other.idLaboresCampo != null) || (this.idLaboresCampo != null && !this.idLaboresCampo.equals(other.idLaboresCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Labores[ idLaboresCampo=" + idLaboresCampo + " ]";
    }
    
}
