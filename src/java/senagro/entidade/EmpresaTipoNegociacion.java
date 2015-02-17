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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johann
 */
@Entity
@Table(name = "empresa_tipo_negociacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaTipoNegociacion.findAll", query = "SELECT e FROM EmpresaTipoNegociacion e"),
    @NamedQuery(name = "EmpresaTipoNegociacion.findByEmpresaTipoNegociacioncol", query = "SELECT e FROM EmpresaTipoNegociacion e WHERE e.empresaTipoNegociacioncol = :empresaTipoNegociacioncol"),
    @NamedQuery(name = "EmpresaTipoNegociacion.findByEmpresaIdEmpresa", query = "SELECT e FROM EmpresaTipoNegociacion e WHERE e.empresaIdEmpresa = :empresaIdEmpresa"),
    @NamedQuery(name = "EmpresaTipoNegociacion.findByTipoNegociacionIdTipoNegociacion", query = "SELECT e FROM EmpresaTipoNegociacion e WHERE e.tipoNegociacionIdTipoNegociacion = :tipoNegociacionIdTipoNegociacion")})
public class EmpresaTipoNegociacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_tipo_negociacioncol")
    private Integer empresaTipoNegociacioncol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_id_empresa")
    private int empresaIdEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_negociacion_id_tipo_negociacion")
    private int tipoNegociacionIdTipoNegociacion;

    public EmpresaTipoNegociacion() {
    }

    public EmpresaTipoNegociacion(Integer empresaTipoNegociacioncol) {
        this.empresaTipoNegociacioncol = empresaTipoNegociacioncol;
    }

    public EmpresaTipoNegociacion(Integer empresaTipoNegociacioncol, int empresaIdEmpresa, int tipoNegociacionIdTipoNegociacion) {
        this.empresaTipoNegociacioncol = empresaTipoNegociacioncol;
        this.empresaIdEmpresa = empresaIdEmpresa;
        this.tipoNegociacionIdTipoNegociacion = tipoNegociacionIdTipoNegociacion;
    }

    public Integer getEmpresaTipoNegociacioncol() {
        return empresaTipoNegociacioncol;
    }

    public void setEmpresaTipoNegociacioncol(Integer empresaTipoNegociacioncol) {
        this.empresaTipoNegociacioncol = empresaTipoNegociacioncol;
    }

    public int getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(int empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    public int getTipoNegociacionIdTipoNegociacion() {
        return tipoNegociacionIdTipoNegociacion;
    }

    public void setTipoNegociacionIdTipoNegociacion(int tipoNegociacionIdTipoNegociacion) {
        this.tipoNegociacionIdTipoNegociacion = tipoNegociacionIdTipoNegociacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaTipoNegociacioncol != null ? empresaTipoNegociacioncol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaTipoNegociacion)) {
            return false;
        }
        EmpresaTipoNegociacion other = (EmpresaTipoNegociacion) object;
        if ((this.empresaTipoNegociacioncol == null && other.empresaTipoNegociacioncol != null) || (this.empresaTipoNegociacioncol != null && !this.empresaTipoNegociacioncol.equals(other.empresaTipoNegociacioncol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.EmpresaTipoNegociacion[ empresaTipoNegociacioncol=" + empresaTipoNegociacioncol + " ]";
    }
    
}
