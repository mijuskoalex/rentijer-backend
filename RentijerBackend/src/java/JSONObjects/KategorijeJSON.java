/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONObjects;

import java.util.List;
import web.Kategorije;

/**
 *
 * @author StefanBurscher
 */
public class KategorijeJSON {

    private Integer id;
    private String naziv;
    private List<KategorijeJSON> children;

    public KategorijeJSON(Kategorije kat) {
        this.id = kat.getId();
        this.naziv = kat.getNaziv();
    }

    public KategorijeJSON(Integer id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public KategorijeJSON(Integer id, String naziv, List<KategorijeJSON> children) {
        this.id = id;
        this.naziv = naziv;
        this.children = children;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<KategorijeJSON> getChildren() {
        return children;
    }

    public void setChildren(List<KategorijeJSON> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "KategorijeJSON{" + "id=" + id + ", naziv=" + naziv + ", children=" + children + '}';
    }

    public KategorijeJSON() {
    }

}
