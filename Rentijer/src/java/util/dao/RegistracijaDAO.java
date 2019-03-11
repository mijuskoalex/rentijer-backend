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
import util.DB;

/**
 *
 * @author WinPC
 */
public class RegistracijaDAO {

    public static String noviKorisnik(String ime, String prezime, String email, String lozinka, String brojTelefona) throws SQLException{
        
        Connection con = null;
        PreparedStatement ps = null;
        String poruka = "";
        
        try{
            con = DB.getInstance().getConnection();
            
            ps = con.prepareStatement("SELECT Ime FROM korisnik WHERE Email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                poruka = "Korisnik sa ovim email-om vec postoji!!!";
                return poruka;
            }
            
            ps = con.prepareStatement("INSERT INTO korisnik (Ime, Prezime, Lozinka, BrojTelefona, Email, Tip) values (?, ?, ?, ?, ?, ?)");
            ps.setString(5, email);
            ps.setString(3, lozinka);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(4, brojTelefona);
            ps.setInt(6, 1);
            ps.execute();
            
            poruka = "Uspesno ste se registrovali!";
           
                return poruka;
                
        }catch (SQLException ex) {
			System.out.println("Greska pri registracija -->" + ex.getMessage());
			return null;
		} finally {
                    ps.close();
                    
                    DB.getInstance().putConnection(con);    
		}
    }
    
}
