/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroleri;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modeli.Korisnik;
import util.dao.RegistracijaDAO;

/**
 *
 * @author WinPC
 */
@ManagedBean(name = "RegistracijaKontroler")
@SessionScoped
public class RegistracijaKontroler {
    
    private String ime;
    private String prezime;
    private String email;
    private String brojTelefona;
    private String lozinka;
    private Korisnik korisnik;
    private String poruka = "";

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
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

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public String registracija() throws SQLException{
        poruka = RegistracijaDAO.noviKorisnik(ime, prezime, email, lozinka, brojTelefona);
        return "index";
    }
}
