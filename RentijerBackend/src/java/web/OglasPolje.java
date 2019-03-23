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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author WinPC
 */
@Entity
@Table(name = "oglas_polje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OglasPolje.findAll", query = "SELECT o FROM OglasPolje o"),
    @NamedQuery(name = "OglasPolje.findById", query = "SELECT o FROM OglasPolje o WHERE o.id = :id"),
    @NamedQuery(name = "OglasPolje.findByVrednost", query = "SELECT o FROM OglasPolje o WHERE o.vrednost = :vrednost")})
public class OglasPolje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vrednost")
    private String vrednost;
    @JoinColumn(name = "idOglas", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Oglas idOglas;
    @JoinColumn(name = "idPolje", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Polja idPolje;

    public OglasPolje() {
    }

    public OglasPolje(Integer id) {
        this.id = id;
    }

    public OglasPolje(Integer id, String vrednost) {
        this.id = id;
        this.vrednost = vrednost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

    public Oglas getIdOglas() {
        return idOglas;
    }

    public void setIdOglas(Oglas idOglas) {
        this.idOglas = idOglas;
    }

    public Polja getIdPolje() {
        return idPolje;
    }

    public void setIdPolje(Polja idPolje) {
        this.idPolje = idPolje;
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
        if (!(object instanceof OglasPolje)) {
            return false;
        }
        OglasPolje other = (OglasPolje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OglasPolje{" + "id=" + id + ", vrednost=" + vrednost + ", idOglas=" + idOglas + ", idPolje=" + idPolje + '}';
    }

}
