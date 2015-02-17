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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johann
 */
@Entity
@Table(name = "detalle_suerte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSuerte.findAll", query = "SELECT d FROM DetalleSuerte d"),
    @NamedQuery(name = "DetalleSuerte.findByDetalleSuerte", query = "SELECT d FROM DetalleSuerte d WHERE d.detalleSuerte = :detalleSuerte"),
    @NamedQuery(name = "DetalleSuerte.findBySuerteCodigoUniSuerte", query = "SELECT d FROM DetalleSuerte d WHERE d.suerteCodigoUniSuerte = :suerteCodigoUniSuerte"),
    @NamedQuery(name = "DetalleSuerte.findByNumeroCorte", query = "SELECT d FROM DetalleSuerte d WHERE d.numeroCorte = :numeroCorte"),
    @NamedQuery(name = "DetalleSuerte.findByFechaSiembra", query = "SELECT d FROM DetalleSuerte d WHERE d.fechaSiembra = :fechaSiembra"),
    @NamedQuery(name = "DetalleSuerte.findByFechaProximoCorte", query = "SELECT d FROM DetalleSuerte d WHERE d.fechaProximoCorte = :fechaProximoCorte"),
    @NamedQuery(name = "DetalleSuerte.findByNuevaFechaProximoCorte", query = "SELECT d FROM DetalleSuerte d WHERE d.nuevaFechaProximoCorte = :nuevaFechaProximoCorte"),
    @NamedQuery(name = "DetalleSuerte.findByFechaUltimoCorte", query = "SELECT d FROM DetalleSuerte d WHERE d.fechaUltimoCorte = :fechaUltimoCorte"),
    @NamedQuery(name = "DetalleSuerte.findByEdadProximoCorte", query = "SELECT d FROM DetalleSuerte d WHERE d.edadProximoCorte = :edadProximoCorte"),
    @NamedQuery(name = "DetalleSuerte.findByEdadHoyMeses", query = "SELECT d FROM DetalleSuerte d WHERE d.edadHoyMeses = :edadHoyMeses"),
    @NamedQuery(name = "DetalleSuerte.findByCosechaMesPpto", query = "SELECT d FROM DetalleSuerte d WHERE d.cosechaMesPpto = :cosechaMesPpto")})
public class DetalleSuerte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "detalle_suerte")
    private Integer detalleSuerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suerte_codigo_uni_suerte")
    private int suerteCodigoUniSuerte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_corte")
    private int numeroCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_siembra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSiembra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_proximo_corte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProximoCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nueva_fecha_proximo_corte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nuevaFechaProximoCorte;
    @Column(name = "fecha_ultimo_corte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_proximo_corte")
    private int edadProximoCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_hoy_meses")
    private int edadHoyMeses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cosecha_mes_ppto")
    private double cosechaMesPpto;

    public DetalleSuerte() {
    }

    public DetalleSuerte(Integer detalleSuerte) {
        this.detalleSuerte = detalleSuerte;
    }

    public DetalleSuerte(Integer detalleSuerte, int suerteCodigoUniSuerte, int numeroCorte, Date fechaSiembra, Date fechaProximoCorte, Date nuevaFechaProximoCorte, int edadProximoCorte, int edadHoyMeses, double cosechaMesPpto) {
        this.detalleSuerte = detalleSuerte;
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
        this.numeroCorte = numeroCorte;
        this.fechaSiembra = fechaSiembra;
        this.fechaProximoCorte = fechaProximoCorte;
        this.nuevaFechaProximoCorte = nuevaFechaProximoCorte;
        this.edadProximoCorte = edadProximoCorte;
        this.edadHoyMeses = edadHoyMeses;
        this.cosechaMesPpto = cosechaMesPpto;
    }

    public Integer getDetalleSuerte() {
        return detalleSuerte;
    }

    public void setDetalleSuerte(Integer detalleSuerte) {
        this.detalleSuerte = detalleSuerte;
    }

    public int getSuerteCodigoUniSuerte() {
        return suerteCodigoUniSuerte;
    }

    public void setSuerteCodigoUniSuerte(int suerteCodigoUniSuerte) {
        this.suerteCodigoUniSuerte = suerteCodigoUniSuerte;
    }

    public int getNumeroCorte() {
        return numeroCorte;
    }

    public void setNumeroCorte(int numeroCorte) {
        this.numeroCorte = numeroCorte;
    }

    public Date getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(Date fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public Date getFechaProximoCorte() {
        return fechaProximoCorte;
    }

    public void setFechaProximoCorte(Date fechaProximoCorte) {
        this.fechaProximoCorte = fechaProximoCorte;
    }

    public Date getNuevaFechaProximoCorte() {
        return nuevaFechaProximoCorte;
    }

    public void setNuevaFechaProximoCorte(Date nuevaFechaProximoCorte) {
        this.nuevaFechaProximoCorte = nuevaFechaProximoCorte;
    }

    public Date getFechaUltimoCorte() {
        return fechaUltimoCorte;
    }

    public void setFechaUltimoCorte(Date fechaUltimoCorte) {
        this.fechaUltimoCorte = fechaUltimoCorte;
    }

    public int getEdadProximoCorte() {
        return edadProximoCorte;
    }

    public void setEdadProximoCorte(int edadProximoCorte) {
        this.edadProximoCorte = edadProximoCorte;
    }

    public int getEdadHoyMeses() {
        return edadHoyMeses;
    }

    public void setEdadHoyMeses(int edadHoyMeses) {
        this.edadHoyMeses = edadHoyMeses;
    }

    public double getCosechaMesPpto() {
        return cosechaMesPpto;
    }

    public void setCosechaMesPpto(double cosechaMesPpto) {
        this.cosechaMesPpto = cosechaMesPpto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleSuerte != null ? detalleSuerte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSuerte)) {
            return false;
        }
        DetalleSuerte other = (DetalleSuerte) object;
        if ((this.detalleSuerte == null && other.detalleSuerte != null) || (this.detalleSuerte != null && !this.detalleSuerte.equals(other.detalleSuerte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "senagro.entidade.DetalleSuerte[ detalleSuerte=" + detalleSuerte + " ]";
    }
    
}
