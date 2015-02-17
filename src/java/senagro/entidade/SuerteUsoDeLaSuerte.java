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
@Table(name = "suerte_uso_de_la_suerte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuerteUsoDeLaSuerte.findAll", query = "SELECT s FROM SuerteUsoDeLaSuerte s"),
    @NamedQuery(name = "SuerteUsoDeLaSuerte.findBySuerteUsoDeLaSuertecol", query = "SELECT s FROM SuerteUsoDeLaSuerte s WHERE s.suerteUsoDeLaSuertecol = :suerteUsoDeLaSuertecol"),
    @NamedQuery(name = "SuerteUsoDeLaSuerte.findBySuerteCodigoUniSuerte", query = "SELECT s FROM SuerteUsoDeLaSuerte s WHERE s.suerteCodigoUniSuerte = :suerteCodigoUniSuerte"),
    @NamedQuery(name = "SuerteUsoDeLaSuerte.findByUsoDeLaSuerteIdUsoDeLaSuerte", query = "SELECT s FROM SuerteUsoDeLaSuerte s WHERE s.usoDeLaSuerteIdUsoDeLaSuerte = :usoDeLaSuerteIdUsoDeLaSuerte")})
public class SuerteUsoDeLaSuerte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_uso_de_la_suertecol")
    private Integer suerteUsoDeLaSuertecol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_codigo_uni_suerte")
    private int suerteCodigoUniSuerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uso_de_la_suerte_id_uso_de_la_suerte")
    private int usoDeLaSuerteIdUsoDeLaSuerte;

    public SuerteUsoDeLaSuerte() {
    }

    public SuerteUsoDeLaSuerte(Integer suerteUsoDeLaSuertecol) {
        this.suerteUsoDeLaSuertecol = suerteUsoDeLaSuertecol;
    }

    public SuerteUsoDeLaSuerte(Integer suerteUsoDeLaSuertecol, int suerteCodigoUniSuerte, int usoDeLaSuerteIdUsoDeLaSuerte) {
        this.suerteUsoDeLaSuertecol = suerteUsoDeLaSuertecol;
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
        this.usoDeLaSuerteIdUsoDeLaSuerte = usoDeLaSuerteIdUsoDeLaSuerte;
    }

    public Integer getSuerteUsoDeLaSuertecol() {
        return suerteUsoDeLaSuertecol;
    }

    public void setSuerteUsoDeLaSuertecol(Integer suerteUsoDeLaSuertecol) {
        this.suerteUsoDeLaSuertecol = suerteUsoDeLaSuertecol;
    }

    public int getSuerteCodigoUniSuerte() {
        return suerteCodigoUniSuerte;
    }

    public void setSuerteCodigoUniSuerte(int suerteCodigoUniSuerte) {
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
    }

    public int getUsoDeLaSuerteIdUsoDeLaSuerte() {
        return usoDeLaSuerteIdUsoDeLaSuerte;
    }

    public void setUsoDeLaSuerteIdUsoDeLaSuerte(int usoDeLaSuerteIdUsoDeLaSuerte) {
        this.usoDeLaSuerteIdUsoDeLaSuerte = usoDeLaSuerteIdUsoDeLaSuerte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suerteUsoDeLaSuertecol != null ? suerteUsoDeLaSuertecol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuerteUsoDeLaSuerte)) {
            return false;
        }
        SuerteUsoDeLaSuerte other = (SuerteUsoDeLaSuerte) object;
        if ((this.suerteUsoDeLaSuertecol == null && other.suerteUsoDeLaSuertecol != null) || (this.suerteUsoDeLaSuertecol != null && !this.suerteUsoDeLaSuertecol.equals(other.suerteUsoDeLaSuertecol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.SuerteUsoDeLaSuerte[ suerteUsoDeLaSuertecol=" + suerteUsoDeLaSuertecol + " ]";
    }
    
}
