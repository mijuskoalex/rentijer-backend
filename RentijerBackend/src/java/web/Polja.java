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
@Table(name = "polja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polja.findAll", query = "SELECT p FROM Polja p")
    , @NamedQuery(name = "Polja.findById", query = "SELECT p FROM Polja p WHERE p.id = :id")
    , @NamedQuery(name = "Polja.findByNaziv", query = "SELECT p FROM Polja p WHERE p.naziv = :naziv")})
public class Polja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPolje")
    private Collection<OglasPolje> oglasPoljeCollection;

    public Polja() {
    }

    public Polja(Integer id) {
        this.id = id;
    }

    public Polja(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public Collection<OglasPolje> getOglasPoljeCollection() {
        return oglasPoljeCollection;
    }

    public void setOglasPoljeCollection(Collection<OglasPolje> oglasPoljeCollection) {
        this.oglasPoljeCollection = oglasPoljeCollection;
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
        if (!(object instanceof Polja)) {
            return false;
        }
        Polja other = (Polja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Polja[ id=" + id + " ]";
    }
    
}
