/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroleri;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import modeli.Admin;
import modeli.Korisnik;
import modeli.Moderator;
import util.SessionUtils;
import util.dao.LoginDAO;

/**
 *
 * @author WinPC
 */
@ManagedBean(name = "LoginKontroler")
@SessionScoped
public class LoginKontroler implements Serializable {

  
    private String email;
    private String lozinka;
    private String lozinka2;
    private Korisnik korisnik;
    private Admin admin;
    private Moderator moderator;
    private String poruka = "";

    
    public String getLozinka2() {
        return lozinka2;
    }

    public void setLozinka2(String lozinka2) {
        this.lozinka2 = lozinka2;
    }
    
      public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }
    
    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
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

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    public String login() throws SQLException{
        int tip = LoginDAO.dohvatiTip(email, lozinka);
        if(tip == 1){
            
                korisnik = LoginDAO.dohvatiKorisnika(email, lozinka);
                HttpSession sesija= SessionUtils.getSession();
                sesija.setAttribute("email", email);
                sesija.setAttribute("tip", "korisnik");
                poruka = "";
                return "pocetna";
                
        }else if(tip == 2){
            
                admin = LoginDAO.dohvatiAdmina(email, lozinka);
                HttpSession sesija= SessionUtils.getSession();
                sesija.setAttribute("email", email);
                sesija.setAttribute("tip", "admin");
               poruka = "";
               return "admin";
        }else if(tip == 3){
            moderator = LoginDAO.dohvatiModeratora(email, lozinka);
            HttpSession sesija= SessionUtils.getSession();
            sesija.setAttribute("email", email);
            sesija.setAttribute("tip", "moderator");
            poruka = "";
            return "moderator";
        }else{
            poruka = "Pogresno korisnicko ime ili lozinka!!!";
                
                return "index";
        }
    }
    
    public String logout() {
        System.out.println("GRESKA 11");
        HttpSession sesija = SessionUtils.getSession();
        System.out.println("GRESKA 1");
        sesija.invalidate();
        System.out.println("GRESKA 2");
        return "index";
    }
    
    public void promenaLozinke() throws SQLException{
        poruka = LoginDAO.promenaLozinke(email, lozinka, lozinka2);
    }
}
