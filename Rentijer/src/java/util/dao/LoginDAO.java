/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modeli.Admin;
import modeli.Korisnik;
import modeli.Moderator;
import util.DB;

/**
 *
 * @author WinPC
 */
public class LoginDAO {

    public static int dohvatiTip(String email, String lozinka) throws SQLException {
        
        Connection con = null;
        PreparedStatement ps = null;
        
        
        try{
            con = DB.getInstance().getConnection();
            ps = con.prepareStatement("SELECT IdZap, Lozinka, Ime, Prezime FROM zaposleni WHERE Email = ? AND Lozinka = ?");
            ps.setString(1, email);
            ps.setString(2, lozinka);
            int tipZ = 0;
            int tip = 0;
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                 tipZ = rs.getInt("IdZap");
                 ps = con.prepareStatement("SELECT Tip FROM administratori WHERE IdZap = ?");
                 ps.setInt(1, tipZ);
                 ResultSet rs2 = ps.executeQuery();
                 if(rs2.next()){
                     tip = rs2.getInt("Tip");
                 }
                 if(tip == 0){
                     ps = con.prepareStatement("SELECT Tip FROM moderatori WHERE IdZap = ?");
                     ps.setInt(1, tipZ);
                     rs2 = ps.executeQuery();
                 if(rs2.next()){
                     tip = rs2.getInt("Tip");
                 }  
                 }
                 
            }
                if(tip == 0){
                    ps = con.prepareStatement("SELECT Email, Lozinka, Ime, Prezime, Tip FROM korisnik WHERE Email = ? AND Lozinka = ?");
                    ps.setString(1, email);
                    ps.setString(2, lozinka);
                    rs = ps.executeQuery();
                    if(rs.next()){
                        tip = rs.getInt("Tip");
                    }
                }
                
                return tip;
                
        }catch (SQLException ex) {
			System.out.println("Greska u logovanju -->" + ex.getMessage());
			return 0;
		} finally {
                    ps.close();
                    
                    DB.getInstance().putConnection(con);    
		}
    }

    public static Korisnik dohvatiKorisnika(String email, String lozinka) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
             con = DB.getInstance().getConnection();
            ps = con.prepareStatement("SELECT IdKor, Ime, Prezime, Email, BrojTelefona, Poeni FROM korisnik WHERE Email = ? AND Lozinka = ?");
            ps.setString(1, email);
            ps.setString(2, lozinka);
            ResultSet rs = ps.executeQuery();
             
            if(rs.next()){
                int id = rs.getInt("IdKor");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String brTel = rs.getString("BrojTelefona");
                int poeni = rs.getInt("Poeni");
                
                
               Korisnik korisnik = new Korisnik();
                
                korisnik.setId(id);
                korisnik.setIme(ime);
                korisnik.setLozinka(lozinka);
                korisnik.setBrojTelefona(brTel);
                korisnik.setEmail(email);
                korisnik.setPrezime(prezime);
                korisnik.setPoeni(poeni);
                
               
                return korisnik;
            }
            
             
        }catch (SQLException ex) {
                    
			System.out.println("Greska u logovanju -->" + ex.getMessage());
			return null;
        } finally {
                    ps.close();
                    DB.getInstance().putConnection(con);    
		}
         return null;
    }

    public static Admin dohvatiAdmina(String email, String lozinka) throws SQLException {
     Connection con = null;
        PreparedStatement ps = null;
        try{
             con = DB.getInstance().getConnection();
            ps = con.prepareStatement("SELECT Email, Lozinka, Ime, Prezime FROM zaposleni WHERE Email = ? AND Lozinka = ?");
            ps.setString(1, email);
            ps.setString(2, lozinka);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String pass = rs.getString("Lozinka");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                
                Admin admin = new Admin();
                
                admin.setIme(ime);
                admin.setLozinka(pass);
                admin.setPrezime(prezime);
                admin.setEmail(email);
                
                return admin;
                
            }
        }catch (SQLException ex) {
			System.out.println("Greska u logovanju -->" + ex.getMessage());
			return null;
		} finally {
                    ps.close();
                    DB.getInstance().putConnection(con);    
		}
        return null;
    }

    public static Moderator dohvatiModeratora(String email, String lozinka) throws SQLException  {
        
        Connection con = null;
        PreparedStatement ps = null;
        try{
            
             con = DB.getInstance().getConnection();
            ps = con.prepareStatement("SELECT Email, Lozinka, Ime, Prezime FROM zaposleni WHERE Email = ? AND Lozinka = ?");
            ps.setString(1, email);
            ps.setString(2, lozinka);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                String pass = rs.getString("Lozinka");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                
                Moderator moderator = new Moderator();
                
                moderator.setIme(ime);
                moderator.setLozinka(pass);
                moderator.setPrezime(prezime);
                moderator.setEmail(email);
                return moderator;
                
            }
        }catch (SQLException ex) {
			System.out.println("Greska u logovanju -->" + ex.getMessage());
			return null;
		} finally {
                    ps.close();
                    DB.getInstance().putConnection(con);    
		}
                    return null;   
    }

    public static String promenaLozinke(String email, String lozinka, String lozinka2) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        String poruka = "";
        try{
            
            con = DB.getInstance().getConnection();
            ps = con.prepareStatement("SELECT Lozinka FROM korisnik WHERE Email = ? AND Lozinka = ?");
            ps.setString(1, email);
            ps.setString(2, lozinka);
            ResultSet rs = ps.executeQuery();
            System.out.println("GRESKA 2");
            
            if(!rs.next()){
                poruka = "Uneta lozinka nije ispravna!";
                return poruka;
            }
            ps = con.prepareStatement("UPDATE korisnik SET Lozinka = ? WHERE Email = ? AND Lozinka = ?");
            ps.setString(1, lozinka2);
            ps.setString(2, email);
            ps.setString(3, lozinka);
            ps.executeUpdate();
            poruka = "Sifra je uspresno promenjena!";
            return poruka;
            
        }catch (SQLException ex) {
			System.out.println("Greska u logovanju -->" + ex.getMessage());
			return null;
		} finally {
                    ps.close();
                    DB.getInstance().putConnection(con);    
		}
    }
}   

