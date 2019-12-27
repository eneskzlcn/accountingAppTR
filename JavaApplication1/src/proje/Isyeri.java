/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class Isyeri {

    String adi;
    String telefon1;
    String telefon2;
    String email;
    String webadresi;
    String adres;

    int id = 0;
    
    public int idatama() {

        int yeniid = 1;
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            Statement st = con.createStatement();
            String sql = "SELECT Isyeri_id FROM Isyeri";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("Isyeri_id") >= yeniid) {
                    yeniid = rs.getInt("Isyeri_id");
                }
                else{
                    yeniid = 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Isyeri.class.getName()).log(Level.SEVERE, null, ex);

        }
        return yeniid + 1;
    }

    public Isyeri() {

        this.id = this.idatama();
        

    }

    

}
