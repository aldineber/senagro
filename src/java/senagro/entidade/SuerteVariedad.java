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
@Table(name = "suerte_variedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuerteVariedad.findAll", query = "SELECT s FROM SuerteVariedad s"),
    @NamedQuery(name = "SuerteVariedad.findByIdsuertevariedadcol", query = "SELECT s FROM SuerteVariedad s WHERE s.idsuertevariedadcol = :idsuertevariedadcol"),
    @NamedQuery(name = "SuerteVariedad.findBySuerteCodigoUniSuerte", query = "SELECT s FROM SuerteVariedad s WHERE s.suerteCodigoUniSuerte = :suerteCodigoUniSuerte"),
    @NamedQuery(name = "SuerteVariedad.findByVariedadIdVariedad", query = "SELECT s FROM SuerteVariedad s WHERE s.variedadIdVariedad = :variedadIdVariedad")})
public class SuerteVariedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsuertevariedadcol")
    private Integer idsuertevariedadcol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_codigo_uni_suerte")
    private int suerteCodigoUniSuerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "variedad_id_variedad")
    private int variedadIdVariedad;

    public SuerteVariedad() {
    }

    public SuerteVariedad(Integer idsuertevariedadcol) {
        this.idsuertevariedadcol = idsuertevariedadcol;
    }

    public SuerteVariedad(Integer idsuertevariedadcol, int suerteCodigoUniSuerte, int variedadIdVariedad) {
        this.idsuertevariedadcol = idsuertevariedadcol;
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
        this.variedadIdVariedad = variedadIdVariedad;
    }

    public Integer getIdsuertevariedadcol() {
        return idsuertevariedadcol;
    }

    public void setIdsuertevariedadcol(Integer idsuertevariedadcol) {
        this.idsuertevariedadcol = idsuertevariedadcol;
    }

    public int getSuerteCodigoUniSuerte() {
        return suerteCodigoUniSuerte;
    }

    public void setSuerteCodigoUniSuerte(int suerteCodigoUniSuerte) {
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
    }

    public int getVariedadIdVariedad() {
        return variedadIdVariedad;
    }

    public void setVariedadIdVariedad(int variedadIdVariedad) {
        this.variedadIdVariedad = variedadIdVariedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsuertevariedadcol != null ? idsuertevariedadcol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuerteVariedad)) {
            return false;
        }
        SuerteVariedad other = (SuerteVariedad) object;
        if ((this.idsuertevariedadcol == null && other.idsuertevariedadcol != null) || (this.idsuertevariedadcol != null && !this.idsuertevariedadcol.equals(other.idsuertevariedadcol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.SuerteVariedad[ idsuertevariedadcol=" + idsuertevariedadcol + " ]";
    }
    
}
