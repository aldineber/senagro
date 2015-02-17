/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senagro.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johann
 */
@Entity
@Table(name = "programacion_labores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramacionLabores.findAll", query = "SELECT p FROM ProgramacionLabores p"),
    @NamedQuery(name = "ProgramacionLabores.findByIdUnicoLabor", query = "SELECT p FROM ProgramacionLabores p WHERE p.idUnicoLabor = :idUnicoLabor"),
    @NamedQuery(name = "ProgramacionLabores.findByIdLabor", query = "SELECT p FROM ProgramacionLabores p WHERE p.idLabor = :idLabor"),
    @NamedQuery(name = "ProgramacionLabores.findByNombreLabor", query = "SELECT p FROM ProgramacionLabores p WHERE p.nombreLabor = :nombreLabor"),
    @NamedQuery(name = "ProgramacionLabores.findByDescripcionLabor", query = "SELECT p FROM ProgramacionLabores p WHERE p.descripcionLabor = :descripcionLabor"),
    @NamedQuery(name = "ProgramacionLabores.findByObservacionLabor", query = "SELECT p FROM ProgramacionLabores p WHERE p.observacionLabor = :observacionLabor"),
    @NamedQuery(name = "ProgramacionLabores.findByFechaInicio", query = "SELECT p FROM ProgramacionLabores p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ProgramacionLabores.findByFechaTerminacion", query = "SELECT p FROM ProgramacionLabores p WHERE p.fechaTerminacion = :fechaTerminacion")})
public class ProgramacionLabores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_unico_labor")
    private Integer idUnicoLabor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Labor")
    private int idLabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_labor")
    private String nombreLabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion_labor")
    private String descripcionLabor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "observacion_labor")
    private String observacionLabor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_terminacion")
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;

    public ProgramacionLabores() {
    }

    public ProgramacionLabores(Integer idUnicoLabor) {
        this.idUnicoLabor = idUnicoLabor;
    }

    public ProgramacionLabores(Integer idUnicoLabor, int idLabor, String nombreLabor, String descripcionLabor, String observacionLabor, Date fechaInicio, Date fechaTerminacion) {
        this.idUnicoLabor = idUnicoLabor;
        this.idLabor = idLabor;
        this.nombreLabor = nombreLabor;
        this.descripcionLabor = descripcionLabor;
        this.observacionLabor = observacionLabor;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
    }

    public Integer getIdUnicoLabor() {
        return idUnicoLabor;
    }

    public void setIdUnicoLabor(Integer idUnicoLabor) {
        this.idUnicoLabor = idUnicoLabor;
    }

    public int getIdLabor() {
        return idLabor;
    }

    public void setIdLabor(int idLabor) {
        this.idLabor = idLabor;
    }

    public String getNombreLabor() {
        return nombreLabor;
    }

    public void setNombreLabor(String nombreLabor) {
        this.nombreLabor = nombreLabor;
    }

    public String getDescripcionLabor() {
        return descripcionLabor;
    }

    public void setDescripcionLabor(String descripcionLabor) {
        this.descripcionLabor = descripcionLabor;
    }

    public String getObservacionLabor() {
        return observacionLabor;
    }

    public void setObservacionLabor(String observacionLabor) {
        this.observacionLabor = observacionLabor;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnicoLabor != null ? idUnicoLabor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionLabores)) {
            return false;
        }
        ProgramacionLabores other = (ProgramacionLabores) object;
        if ((this.idUnicoLabor == null && other.idUnicoLabor != null) || (this.idUnicoLabor != null && !this.idUnicoLabor.equals(other.idUnicoLabor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.ProgramacionLabores[ idUnicoLabor=" + idUnicoLabor + " ]";
    }
    
}
