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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByRolesIdRoles", query = "SELECT e FROM Empleado e WHERE e.rolesIdRoles = :rolesIdRoles"),
    @NamedQuery(name = "Empleado.findByCargosIdCargo", query = "SELECT e FROM Empleado e WHERE e.cargosIdCargo = :cargosIdCargo"),
    @NamedQuery(name = "Empleado.findByNombre1Empleado", query = "SELECT e FROM Empleado e WHERE e.nombre1Empleado = :nombre1Empleado"),
    @NamedQuery(name = "Empleado.findByNombre2Empleado", query = "SELECT e FROM Empleado e WHERE e.nombre2Empleado = :nombre2Empleado"),
    @NamedQuery(name = "Empleado.findByApellido1Empleado", query = "SELECT e FROM Empleado e WHERE e.apellido1Empleado = :apellido1Empleado"),
    @NamedQuery(name = "Empleado.findByApellido2Empleado", query = "SELECT e FROM Empleado e WHERE e.apellido2Empleado = :apellido2Empleado"),
    @NamedQuery(name = "Empleado.findByProfesionEmpleado", query = "SELECT e FROM Empleado e WHERE e.profesionEmpleado = :profesionEmpleado"),
    @NamedQuery(name = "Empleado.findByTelefonoEmpleado", query = "SELECT e FROM Empleado e WHERE e.telefonoEmpleado = :telefonoEmpleado"),
    @NamedQuery(name = "Empleado.findByCelularEmpleado", query = "SELECT e FROM Empleado e WHERE e.celularEmpleado = :celularEmpleado"),
    @NamedQuery(name = "Empleado.findByCorreoEmpleado", query = "SELECT e FROM Empleado e WHERE e.correoEmpleado = :correoEmpleado"),
    @NamedQuery(name = "Empleado.findByDireccionUsuario", query = "SELECT e FROM Empleado e WHERE e.direccionUsuario = :direccionUsuario")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roles_id_roles")
    private int rolesIdRoles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cargos_id_cargo")
    private int cargosIdCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre_1_empleado")
    private String nombre1Empleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre_2_empleado")
    private String nombre2Empleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "apellido_1_empleado")
    private String apellido1Empleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "apellido_2_empleado")
    private String apellido2Empleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "profesion_empleado")
    private String profesionEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "celular_empleado")
    private String celularEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo_empleado")
    private String correoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion_usuario")
    private String direccionUsuario;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, int rolesIdRoles, int cargosIdCargo, String nombre1Empleado, String nombre2Empleado, String apellido1Empleado, String apellido2Empleado, String profesionEmpleado, String telefonoEmpleado, String celularEmpleado, String correoEmpleado, String direccionUsuario) {
        this.idEmpleado = idEmpleado;
        this.rolesIdRoles = rolesIdRoles;
        this.cargosIdCargo = cargosIdCargo;
        this.nombre1Empleado = nombre1Empleado;
        this.nombre2Empleado = nombre2Empleado;
        this.apellido1Empleado = apellido1Empleado;
        this.apellido2Empleado = apellido2Empleado;
        this.profesionEmpleado = profesionEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.celularEmpleado = celularEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.direccionUsuario = direccionUsuario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getRolesIdRoles() {
        return rolesIdRoles;
    }

    public void setRolesIdRoles(int rolesIdRoles) {
        this.rolesIdRoles = rolesIdRoles;
    }

    public int getCargosIdCargo() {
        return cargosIdCargo;
    }

    public void setCargosIdCargo(int cargosIdCargo) {
        this.cargosIdCargo = cargosIdCargo;
    }

    public String getNombre1Empleado() {
        return nombre1Empleado;
    }

    public void setNombre1Empleado(String nombre1Empleado) {
        this.nombre1Empleado = nombre1Empleado;
    }

    public String getNombre2Empleado() {
        return nombre2Empleado;
    }

    public void setNombre2Empleado(String nombre2Empleado) {
        this.nombre2Empleado = nombre2Empleado;
    }

    public String getApellido1Empleado() {
        return apellido1Empleado;
    }

    public void setApellido1Empleado(String apellido1Empleado) {
        this.apellido1Empleado = apellido1Empleado;
    }

    public String getApellido2Empleado() {
        return apellido2Empleado;
    }

    public void setApellido2Empleado(String apellido2Empleado) {
        this.apellido2Empleado = apellido2Empleado;
    }

    public String getProfesionEmpleado() {
        return profesionEmpleado;
    }

    public void setProfesionEmpleado(String profesionEmpleado) {
        this.profesionEmpleado = profesionEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getCelularEmpleado() {
        return celularEmpleado;
    }

    public void setCelularEmpleado(String celularEmpleado) {
        this.celularEmpleado = celularEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
