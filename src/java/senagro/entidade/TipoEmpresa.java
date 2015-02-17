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
@Table(name = "tipo_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEmpresa.findAll", query = "SELECT t FROM TipoEmpresa t"),
    @NamedQuery(name = "TipoEmpresa.findByIdTipoEmpresa", query = "SELECT t FROM TipoEmpresa t WHERE t.idTipoEmpresa = :idTipoEmpresa"),
    @NamedQuery(name = "TipoEmpresa.findByFuncion", query = "SELECT t FROM TipoEmpresa t WHERE t.funcion = :funcion"),
    @NamedQuery(name = "TipoEmpresa.findByEmpresaIdEmpresa", query = "SELECT t FROM TipoEmpresa t WHERE t.empresaIdEmpresa = :empresaIdEmpresa")})
public class TipoEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_empresa")
    private Integer idTipoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "funcion")
    private String funcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empresa_id_empresa")
    private int empresaIdEmpresa;

    public TipoEmpresa() {
    }

    public TipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public TipoEmpresa(Integer idTipoEmpresa, String funcion, int empresaIdEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
        this.funcion = funcion;
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    public Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(int empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEmpresa != null ? idTipoEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpresa)) {
            return false;
        }
        TipoEmpresa other = (TipoEmpresa) object;
        if ((this.idTipoEmpresa == null && other.idTipoEmpresa != null) || (this.idTipoEmpresa != null && !this.idTipoEmpresa.equals(other.idTipoEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.TipoEmpresa[ idTipoEmpresa=" + idTipoEmpresa + " ]";
    }
    
}
