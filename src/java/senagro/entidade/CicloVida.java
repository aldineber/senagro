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
@Table(name = "ciclo_vida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CicloVida.findAll", query = "SELECT c FROM CicloVida c"),
    @NamedQuery(name = "CicloVida.findByIdcicloVida", query = "SELECT c FROM CicloVida c WHERE c.idcicloVida = :idcicloVida"),
    @NamedQuery(name = "CicloVida.findByEdadCultivoIdEdad", query = "SELECT c FROM CicloVida c WHERE c.edadCultivoIdEdad = :edadCultivoIdEdad"),
    @NamedQuery(name = "CicloVida.findByTiempoCicloVida", query = "SELECT c FROM CicloVida c WHERE c.tiempoCicloVida = :tiempoCicloVida")})
public class CicloVida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciclo_Vida")
    private Integer idcicloVida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_cultivo_id_edad")
    private int edadCultivoIdEdad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_ciclo_vida")
    private int tiempoCicloVida;

    public CicloVida() {
    }

    public CicloVida(Integer idcicloVida) {
        this.idcicloVida = idcicloVida;
    }

    public CicloVida(Integer idcicloVida, int edadCultivoIdEdad, int tiempoCicloVida) {
        this.idcicloVida = idcicloVida;
        this.edadCultivoIdEdad = edadCultivoIdEdad;
        this.tiempoCicloVida = tiempoCicloVida;
    }

    public Integer getIdcicloVida() {
        return idcicloVida;
    }

    public void setIdcicloVida(Integer idcicloVida) {
        this.idcicloVida = idcicloVida;
    }

    public int getEdadCultivoIdEdad() {
        return edadCultivoIdEdad;
    }

    public void setEdadCultivoIdEdad(int edadCultivoIdEdad) {
        this.edadCultivoIdEdad = edadCultivoIdEdad;
    }

    public int getTiempoCicloVida() {
        return tiempoCicloVida;
    }

    public void setTiempoCicloVida(int tiempoCicloVida) {
        this.tiempoCicloVida = tiempoCicloVida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcicloVida != null ? idcicloVida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CicloVida)) {
            return false;
        }
        CicloVida other = (CicloVida) object;
        if ((this.idcicloVida == null && other.idcicloVida != null) || (this.idcicloVida != null && !this.idcicloVida.equals(other.idcicloVida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.CicloVida[ idcicloVida=" + idcicloVida + " ]";
    }
    
}
