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
@Table(name = "suerte_tipo_restriccion_quema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuerteTipoRestriccionQuema.findAll", query = "SELECT s FROM SuerteTipoRestriccionQuema s"),
    @NamedQuery(name = "SuerteTipoRestriccionQuema.findBySuertetipoRestriccionquemacol", query = "SELECT s FROM SuerteTipoRestriccionQuema s WHERE s.suertetipoRestriccionquemacol = :suertetipoRestriccionquemacol"),
    @NamedQuery(name = "SuerteTipoRestriccionQuema.findBySuerteCodigoUniSuerte", query = "SELECT s FROM SuerteTipoRestriccionQuema s WHERE s.suerteCodigoUniSuerte = :suerteCodigoUniSuerte"),
    @NamedQuery(name = "SuerteTipoRestriccionQuema.findByTipoRestriccionquemaidtiporestrincion", query = "SELECT s FROM SuerteTipoRestriccionQuema s WHERE s.tipoRestriccionquemaidtiporestrincion = :tipoRestriccionquemaidtiporestrincion")})
public class SuerteTipoRestriccionQuema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_tipo_Restriccion_quemacol")
    private Integer suertetipoRestriccionquemacol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_codigo_uni_suerte")
    private int suerteCodigoUniSuerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_Restriccion_quema_id_tipo_restrincion")
    private int tipoRestriccionquemaidtiporestrincion;

    public SuerteTipoRestriccionQuema() {
    }

    public SuerteTipoRestriccionQuema(Integer suertetipoRestriccionquemacol) {
        this.suertetipoRestriccionquemacol = suertetipoRestriccionquemacol;
    }

    public SuerteTipoRestriccionQuema(Integer suertetipoRestriccionquemacol, int suerteCodigoUniSuerte, int tipoRestriccionquemaidtiporestrincion) {
        this.suertetipoRestriccionquemacol = suertetipoRestriccionquemacol;
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
        this.tipoRestriccionquemaidtiporestrincion = tipoRestriccionquemaidtiporestrincion;
    }

    public Integer getSuertetipoRestriccionquemacol() {
        return suertetipoRestriccionquemacol;
    }

    public void setSuertetipoRestriccionquemacol(Integer suertetipoRestriccionquemacol) {
        this.suertetipoRestriccionquemacol = suertetipoRestriccionquemacol;
    }

    public int getSuerteCodigoUniSuerte() {
        return suerteCodigoUniSuerte;
    }

    public void setSuerteCodigoUniSuerte(int suerteCodigoUniSuerte) {
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
    }

    public int getTipoRestriccionquemaidtiporestrincion() {
        return tipoRestriccionquemaidtiporestrincion;
    }

    public void setTipoRestriccionquemaidtiporestrincion(int tipoRestriccionquemaidtiporestrincion) {
        this.tipoRestriccionquemaidtiporestrincion = tipoRestriccionquemaidtiporestrincion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suertetipoRestriccionquemacol != null ? suertetipoRestriccionquemacol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuerteTipoRestriccionQuema)) {
            return false;
        }
        SuerteTipoRestriccionQuema other = (SuerteTipoRestriccionQuema) object;
        if ((this.suertetipoRestriccionquemacol == null && other.suertetipoRestriccionquemacol != null) || (this.suertetipoRestriccionquemacol != null && !this.suertetipoRestriccionquemacol.equals(other.suertetipoRestriccionquemacol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.SuerteTipoRestriccionQuema[ suertetipoRestriccionquemacol=" + suertetipoRestriccionquemacol + " ]";
    }
    
}
