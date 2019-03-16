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
@Table(name = "korisnici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnici.findAll", query = "SELECT k FROM Korisnici k"),
    @NamedQuery(name = "Korisnici.findById", query = "SELECT k FROM Korisnici k WHERE k.id = :id"),
    @NamedQuery(name = "Korisnici.findByIme", query = "SELECT k FROM Korisnici k WHERE k.ime = :ime"),
    @NamedQuery(name = "Korisnici.findByPrezime", query = "SELECT k FROM Korisnici k WHERE k.prezime = :prezime"),
    @NamedQuery(name = "Korisnici.findByEmail", query = "SELECT k FROM Korisnici k WHERE k.email = :email"),
    @NamedQuery(name = "Korisnici.findByBrojTelefona", query = "SELECT k FROM Korisnici k WHERE k.brojTelefona = :brojTelefona"),
    @NamedQuery(name = "Korisnici.findByLozinka", query = "SELECT k FROM Korisnici k WHERE k.lozinka = :lozinka")})
public class Korisnici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prezime")
    private String prezime;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "brojTelefona")
    private String brojTelefona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lozinka")
    private String lozinka;
    @JoinColumn(name = "idTip", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipKorisnika idTip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKorisnik")
    private Collection<Oglas> oglasCollection;

    public Korisnici() {
    }

    public Korisnici(Integer id) {
        this.id = id;
    }

    public Korisnici(Integer id, String ime, String prezime, String email, String brojTelefona, String lozinka) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.lozinka = lozinka;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public TipKorisnika getIdTip() {
        return idTip;
    }

    public void setIdTip(TipKorisnika idTip) {
        this.idTip = idTip;
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
        if (!(object instanceof Korisnici)) {
            return false;
        }
        Korisnici other = (Korisnici) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Korisnici[ id=" + id + " ]";
    }

}
