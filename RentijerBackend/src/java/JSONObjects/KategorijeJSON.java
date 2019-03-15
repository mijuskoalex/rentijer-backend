/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONObjects;

import java.util.List;

/**
 *
 * @author StefanBurscher
 */
public class KategorijeJSON {

    private String naziv;
    private Integer id;
    private List<KategorijeJSON> children;

    public KategorijeJSON(String naziv, Integer id) {
        this.naziv = naziv;
        this.id = id;
    }

    public KategorijeJSON(String naziv, Integer id, List<KategorijeJSON> children) {
        this.naziv = naziv;
        this.id = id;
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
        return "KategorijeJSON{" + "naziv=" + naziv + ", id=" + id + ", children=" + children + '}';
    }

    public KategorijeJSON() {
    }

}
