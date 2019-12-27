/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class Kullanici {
    String kullaniciadi,
            kullaniciparola;
    int isyeri_id;
    int id = 0;
    
    
    
     public int idatama() {

        int yeniid = 1;
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            Statement st = con.createStatement();
            String sql = "SELECT Kullanici_id FROM Kullanici";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("Kullanici_id") >= yeniid) {
                    yeniid = rs.getInt("Kullanici_id");
                }
                else{
                 yeniid = 0;
                }
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Isyeri.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return yeniid + 1;
        
    }
     public Kullanici(){
    this.id = this.idatama();
    
    }
}

    

    





    
    
    

