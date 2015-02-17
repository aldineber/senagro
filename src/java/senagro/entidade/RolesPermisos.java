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
@Table(name = "roles_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesPermisos.findAll", query = "SELECT r FROM RolesPermisos r"),
    @NamedQuery(name = "RolesPermisos.findByRolesPermisoscol", query = "SELECT r FROM RolesPermisos r WHERE r.rolesPermisoscol = :rolesPermisoscol"),
    @NamedQuery(name = "RolesPermisos.findByRolesIdRoles", query = "SELECT r FROM RolesPermisos r WHERE r.rolesIdRoles = :rolesIdRoles"),
    @NamedQuery(name = "RolesPermisos.findByPermisosIdpermisos", query = "SELECT r FROM RolesPermisos r WHERE r.permisosIdpermisos = :permisosIdpermisos")})
public class RolesPermisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "roles_permisoscol")
    private Integer rolesPermisoscol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roles_id_roles")
    private int rolesIdRoles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permisos_idpermisos")
    private int permisosIdpermisos;

    public RolesPermisos() {
    }

    public RolesPermisos(Integer rolesPermisoscol) {
        this.rolesPermisoscol = rolesPermisoscol;
    }

    public RolesPermisos(Integer rolesPermisoscol, int rolesIdRoles, int permisosIdpermisos) {
        this.rolesPermisoscol = rolesPermisoscol;
        this.rolesIdRoles = rolesIdRoles;
        this.permisosIdpermisos = permisosIdpermisos;
    }

    public Integer getRolesPermisoscol() {
        return rolesPermisoscol;
    }

    public void setRolesPermisoscol(Integer rolesPermisoscol) {
        this.rolesPermisoscol = rolesPermisoscol;
    }

    public int getRolesIdRoles() {
        return rolesIdRoles;
    }

    public void setRolesIdRoles(int rolesIdRoles) {
        this.rolesIdRoles = rolesIdRoles;
    }

    public int getPermisosIdpermisos() {
        return permisosIdpermisos;
    }

    public void setPermisosIdpermisos(int permisosIdpermisos) {
        this.permisosIdpermisos = permisosIdpermisos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolesPermisoscol != null ? rolesPermisoscol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesPermisos)) {
            return false;
        }
        RolesPermisos other = (RolesPermisos) object;
        if ((this.rolesPermisoscol == null && other.rolesPermisoscol != null) || (this.rolesPermisoscol != null && !this.rolesPermisoscol.equals(other.rolesPermisoscol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.RolesPermisos[ rolesPermisoscol=" + rolesPermisoscol + " ]";
    }
    
}
