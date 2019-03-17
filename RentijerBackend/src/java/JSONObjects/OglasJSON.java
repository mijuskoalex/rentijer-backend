/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONObjects;

import java.util.List;
import web.Kategorije;
import web.Oglas;

/**
 *
 * @author StefanBurscher
 */
public class OglasJSON {

    private Integer id;
    private Integer idKorisnika;
    private String opis;
    private List<KategorijeJSON> kategorije;

    public OglasJSON(Oglas ogl) {
        this.id = ogl.getId();
        this.idKorisnika = ogl.getIdKorisnik().getId();
        this.opis = ogl.getOpis();
    }

    public OglasJSON(Integer id, Integer idKorisnika, String opis) {
        this.id = id;
        this.idKorisnika = idKorisnika;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<KategorijeJSON> getKategorije() {
        return kategorije;
    }

    public void setKategorije(List<KategorijeJSON> kategorije) {
        this.kategorije = kategorije;
    }

    @Override
    public String toString() {
        return "OglasJSON{" + "id=" + id + ", idKorisnika=" + idKorisnika + ", opis=" + opis + ", kategorije=" + kategorije + '}';
    }

}
