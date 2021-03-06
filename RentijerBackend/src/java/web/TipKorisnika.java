/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WinPC
 */
@Entity
@Table(name = "tip_korisnika")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipKorisnika.findAll", query = "SELECT t FROM TipKorisnika t"),
    @NamedQuery(name = "TipKorisnika.findById", query = "SELECT t FROM TipKorisnika t WHERE t.id = :id"),
    @NamedQuery(name = "TipKorisnika.findByVrsta", query = "SELECT t FROM TipKorisnika t WHERE t.vrsta = :vrsta")})
public class TipKorisnika implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vrsta")
    private String vrsta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTip")
    private Collection<Korisnici> korisniciCollection;

    public TipKorisnika() {
    }

    public TipKorisnika(Integer id) {
        this.id = id;
    }

    public TipKorisnika(Integer id, String vrsta) {
        this.id = id;
        this.vrsta = vrsta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    @XmlTransient
    public Collection<Korisnici> getKorisniciCollection() {
        return korisniciCollection;
    }

    public void setKorisniciCollection(Collection<Korisnici> korisniciCollection) {
        this.korisniciCollection = korisniciCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipKorisnika)) {
            return false;
        }
        TipKorisnika other = (TipKorisnika) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipKorisnika{" + "id=" + id + ", vrsta=" + vrsta + ", korisniciCollection=" + korisniciCollection + '}';
    }

}
