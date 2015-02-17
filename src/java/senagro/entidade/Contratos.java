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
@Table(name = "contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratos.findAll", query = "SELECT c FROM Contratos c"),
    @NamedQuery(name = "Contratos.findByIdContrato", query = "SELECT c FROM Contratos c WHERE c.idContrato = :idContrato"),
    @NamedQuery(name = "Contratos.findByProveedoridproveedor", query = "SELECT c FROM Contratos c WHERE c.proveedoridproveedor = :proveedoridproveedor"),
    @NamedQuery(name = "Contratos.findByFechaInicio", query = "SELECT c FROM Contratos c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Contratos.findByFechaTermino", query = "SELECT c FROM Contratos c WHERE c.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Contratos.findByClausulas", query = "SELECT c FROM Contratos c WHERE c.clausulas = :clausulas")})
public class Contratos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contrato")
    private Integer idContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Proveedor_id_proveedor")
    private int proveedoridproveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clausulas")
    private String clausulas;

    public Contratos() {
    }

    public Contratos(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Contratos(Integer idContrato, int proveedoridproveedor, Date fechaInicio, Date fechaTermino, String clausulas) {
        this.idContrato = idContrato;
        this.proveedoridproveedor = proveedoridproveedor;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.clausulas = clausulas;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public int getProveedoridproveedor() {
        return proveedoridproveedor;
    }

    public void setProveedoridproveedor(int proveedoridproveedor) {
        this.proveedoridproveedor = proveedoridproveedor;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getClausulas() {
        return clausulas;
    }

    public void setClausulas(String clausulas) {
        this.clausulas = clausulas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContrato != null ? idContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratos)) {
            return false;
        }
        Contratos other = (Contratos) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Contratos[ idContrato=" + idContrato + " ]";
    }
    
}
