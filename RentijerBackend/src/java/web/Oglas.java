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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "oglas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oglas.findAll", query = "SELECT o FROM Oglas o")
    , @NamedQuery(name = "Oglas.findById", query = "SELECT o FROM Oglas o WHERE o.id = :id")
    , @NamedQuery(name = "Oglas.findByIdPodPodKat", query = "SELECT o FROM Oglas o WHERE o.idPodPodKat = :id")
    //, @NamedQuery(name = "Oglas.findByIdPodPodKatPlusPolja", query = "SELECT o FROM Oglas o join o.idPodPodKat op WHERE o.idPodPodKat = :id")
    , @NamedQuery(name = "Oglas.findByOpis", query = "SELECT o FROM Oglas o WHERE o.opis = :opis")})
public class Oglas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "opis")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOglas")
    private Collection<OglasPolje> oglasPoljeCollection;
    @JoinColumn(name = "idKorisnik", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Korisnici idKorisnik;
    @JoinColumn(name = "idPodPodKat", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kategorije idPodPodKat;

    public Oglas() {
    }

    public Oglas(Integer id) {
        this.id = id;
    }

    public Oglas(Integer id, String opis) {
        this.id = id;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @XmlTransient
    public Collection<OglasPolje> getOglasPoljeCollection() {
        return oglasPoljeCollection;
    }

    public void setOglasPoljeCollection(Collection<OglasPolje> oglasPoljeCollection) {
        this.oglasPoljeCollection = oglasPoljeCollection;
    }

    public Korisnici getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Korisnici idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public Kategorije getIdPodPodKat() {
        return idPodPodKat;
    }

    public void setIdPodPodKat(Kategorije idPodPodKat) {
        this.idPodPodKat = idPodPodKat;
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
        if (!(object instanceof Oglas)) {
            return false;
        }
        Oglas other = (Oglas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Oglas[ id=" + id + " ]";
    }
    
}
