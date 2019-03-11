/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author WinPC
 */
@Named(value = "korisnik") //ili @Managedean(name="korisnik")
@SessionScoped
public class Korisnik implements Serializable{
    
    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private String brojTelefona;
    private int poeni;
    private boolean slatiMail;
    private boolean praviKorisnik;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    
    public int getPoeni() {
        return poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public boolean isSlatiMail() {
        return slatiMail;
    }

    public void setSlatiMail(boolean slatiMail) {
        this.slatiMail = slatiMail;
    }

    public boolean isPraviKorisnik() {
        return praviKorisnik;
    }

    public void setPraviKorisnik(boolean praviKorisnik) {
        this.praviKorisnik = praviKorisnik;
    }
    
}
