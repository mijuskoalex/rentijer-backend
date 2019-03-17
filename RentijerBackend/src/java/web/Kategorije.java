/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
@Table(name = "kategorije")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorije.findAll", query = "SELECT k FROM Kategorije k"),
    @NamedQuery(name = "Kategorije.findById", query = "SELECT k FROM Kategorije k WHERE k.id = :id"),
    @NamedQuery(name = "Kategorije.AllKats", query = "SELECT k FROM Kategorije k WHERE k.idKat is null and k.idPodKat is null"),
    @NamedQuery(name = "Kategorije.AllPodKatsForKat", query = "SELECT k FROM Kategorije k WHERE k.idKat = :idKat and k.idPodKat is null"),
    @NamedQuery(name = "Kategorije.AllPodPodKatsForPodKat", query = "SELECT k FROM Kategorije k WHERE k.idPodKat = :idPodKat"),
    @NamedQuery(name = "Kategorije.findByIdKat", query = "SELECT k FROM Kategorije k WHERE k.idKat = :idKat"),
    @NamedQuery(name = "Kategorije.findByIdPodKat", query = "SELECT k FROM Kategorije k WHERE k.idPodKat = :idPodKat"),
    @NamedQuery(name = "Kategorije.findByNaziv", query = "SELECT k FROM Kategorije k WHERE k.naziv = :naziv")})
public class Kategorije implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "idKat")
    private Integer idKat;
    @Column(name = "idPodKat")
    private Integer idPodKat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPodPodKat")
    private Collection<Oglas> oglasCollection;

    public Kategorije() {
    }

    public Kategorije(Integer id) {
        this.id = id;
    }

    public Kategorije(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKat() {
        return idKat;
    }

    public void setIdKat(Integer idKat) {
        this.idKat = idKat;
    }

    public Integer getIdPodKat() {
        return idPodKat;
    }

    public void setIdPodKat(Integer idPodKat) {
        this.idPodKat = idPodKat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public Collection<Oglas> getOglasCollection() {
        return oglasCollection;
    }

    public void setOglasCollection(Collection<Oglas> oglasCollection) {
        this.oglasCollection = oglasCollection;
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
        if (!(object instanceof Kategorije)) {
            return false;
        }
        Kategorije other = (Kategorije) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kategorije{" + "id=" + id + ", idKat=" + idKat + ", idPodKat=" + idPodKat + ", naziv=" + naziv + ", oglasCollection=" + oglasCollection + '}';
    }

}
