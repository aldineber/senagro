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
@Table(name = "tipo_labor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLabor.findAll", query = "SELECT t FROM TipoLabor t"),
    @NamedQuery(name = "TipoLabor.findByIdLabor", query = "SELECT t FROM TipoLabor t WHERE t.idLabor = :idLabor"),
    @NamedQuery(name = "TipoLabor.findByLaboresidLaboresCampo", query = "SELECT t FROM TipoLabor t WHERE t.laboresidLaboresCampo = :laboresidLaboresCampo"),
    @NamedQuery(name = "TipoLabor.findByNombretipoLabor", query = "SELECT t FROM TipoLabor t WHERE t.nombretipoLabor = :nombretipoLabor")})
public class TipoLabor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_labor")
    private Integer idLabor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "labores_id_Labores_Campo")
    private int laboresidLaboresCampo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombretipo_labor")
    private String nombretipoLabor;

    public TipoLabor() {
    }

    public TipoLabor(Integer idLabor) {
        this.idLabor = idLabor;
    }

    public TipoLabor(Integer idLabor, int laboresidLaboresCampo, String nombretipoLabor) {
        this.idLabor = idLabor;
        this.laboresidLaboresCampo = laboresidLaboresCampo;
        this.nombretipoLabor = nombretipoLabor;
    }

    public Integer getIdLabor() {
        return idLabor;
    }

    public void setIdLabor(Integer idLabor) {
        this.idLabor = idLabor;
    }

    public int getLaboresidLaboresCampo() {
        return laboresidLaboresCampo;
    }

    public void setLaboresidLaboresCampo(int laboresidLaboresCampo) {
        this.laboresidLaboresCampo = laboresidLaboresCampo;
    }

    public String getNombretipoLabor() {
        return nombretipoLabor;
    }

    public void setNombretipoLabor(String nombretipoLabor) {
        this.nombretipoLabor = nombretipoLabor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLabor != null ? idLabor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLabor)) {
            return false;
        }
        TipoLabor other = (TipoLabor) object;
        if ((this.idLabor == null && other.idLabor != null) || (this.idLabor != null && !this.idLabor.equals(other.idLabor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.TipoLabor[ idLabor=" + idLabor + " ]";
    }
    
}
