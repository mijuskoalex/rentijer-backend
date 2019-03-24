/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zlatic
 */
@Entity
@Table(name = "slike")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slike.findAll", query = "SELECT s FROM Slike s")
    , @NamedQuery(name = "Slike.findById", query = "SELECT s FROM Slike s WHERE s.id = :id")
    , @NamedQuery(name = "Slike.findByNaziv", query = "SELECT s FROM Slike s WHERE s.naziv = :naziv")})
public class Slike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "naziv")
    private String naziv;
    @JoinColumn(name = "idOglas", referencedColumnName = "id")
    @ManyToOne
    private Oglas idOglas;

    public Slike() {
    }

    public Slike(Integer id) {
        this.id = id;
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

    public Oglas getIdOglas() {
        return idOglas;
    }

    public void setIdOglas(Oglas idOglas) {
        this.idOglas = idOglas;
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
        if (!(object instanceof Slike)) {
            return false;
        }
        Slike other = (Slike) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Slike[ id=" + id + " ]";
    }
    
}
