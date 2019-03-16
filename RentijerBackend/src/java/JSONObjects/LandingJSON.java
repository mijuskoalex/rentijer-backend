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
public class LandingJSON {

    private String naziv;
    private Integer id;
    private List<LandingJSON> oglasi;

    public LandingJSON(String naziv, Integer id) {
        this.naziv = naziv;
        this.id = id;
    }

    public LandingJSON(String naziv, Integer id, List<LandingJSON> oglasi) {
        this.naziv = naziv;
        this.id = id;
        this.oglasi = oglasi;
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

    public List<LandingJSON> getOglasi() {
        return oglasi;
    }

    public void setOglasi(List<LandingJSON> oglasi) {
        this.oglasi = oglasi;
    }

    @Override
    public String toString() {
        return "LandingJSON{" + "naziv=" + naziv + ", id=" + id + ", oglasi=" + oglasi + '}';
    }

    public LandingJSON() {
    }

}