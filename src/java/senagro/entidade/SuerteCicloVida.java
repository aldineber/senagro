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
@Table(name = "suerte_ciclo_vida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuerteCicloVida.findAll", query = "SELECT s FROM SuerteCicloVida s"),
    @NamedQuery(name = "SuerteCicloVida.findByIdsuertecicloVidacol", query = "SELECT s FROM SuerteCicloVida s WHERE s.idsuertecicloVidacol = :idsuertecicloVidacol"),
    @NamedQuery(name = "SuerteCicloVida.findByCicloVidaidcicloVida", query = "SELECT s FROM SuerteCicloVida s WHERE s.cicloVidaidcicloVida = :cicloVidaidcicloVida"),
    @NamedQuery(name = "SuerteCicloVida.findBySuerteCodigoUniSuerte", query = "SELECT s FROM SuerteCicloVida s WHERE s.suerteCodigoUniSuerte = :suerteCodigoUniSuerte")})
public class SuerteCicloVida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsuerteciclo_vidacol")
    private Integer idsuertecicloVidacol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ciclo_Vida_id_ciclo_Vida")
    private int cicloVidaidcicloVida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_codigo_uni_suerte")
    private int suerteCodigoUniSuerte;

    public SuerteCicloVida() {
    }

    public SuerteCicloVida(Integer idsuertecicloVidacol) {
        this.idsuertecicloVidacol = idsuertecicloVidacol;
    }

    public SuerteCicloVida(Integer idsuertecicloVidacol, int cicloVidaidcicloVida, int suerteCodigoUniSuerte) {
        this.idsuertecicloVidacol = idsuertecicloVidacol;
        this.cicloVidaidcicloVida = cicloVidaidcicloVida;
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
    }

    public Integer getIdsuertecicloVidacol() {
        return idsuertecicloVidacol;
    }

    public void setIdsuertecicloVidacol(Integer idsuertecicloVidacol) {
        this.idsuertecicloVidacol = idsuertecicloVidacol;
    }

    public int getCicloVidaidcicloVida() {
        return cicloVidaidcicloVida;
    }

    public void setCicloVidaidcicloVida(int cicloVidaidcicloVida) {
        this.cicloVidaidcicloVida = cicloVidaidcicloVida;
    }

    public int getSuerteCodigoUniSuerte() {
        return suerteCodigoUniSuerte;
    }

    public void setSuerteCodigoUniSuerte(int suerteCodigoUniSuerte) {
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsuertecicloVidacol != null ? idsuertecicloVidacol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuerteCicloVida)) {
            return false;
        }
        SuerteCicloVida other = (SuerteCicloVida) object;
        if ((this.idsuertecicloVidacol == null && other.idsuertecicloVidacol != null) || (this.idsuertecicloVidacol != null && !this.idsuertecicloVidacol.equals(other.idsuertecicloVidacol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.SuerteCicloVida[ idsuertecicloVidacol=" + idsuertecicloVidacol + " ]";
    }
    
}
