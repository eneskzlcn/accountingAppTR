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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class Cari {
    String ticariunvan,adi,soyadi,
            istelefon,ceptelefon,evtelefon,
            evadresi,isadresi,vergidairesi,vergino,grup,
            email,tckimlik,aciklama,durumperf,banka1adi,banka2adi,hesapno1,hesapno2;
    int cari_id,isyeri_id;
    public int idatama() {

        int yeniid = 1;
        try {

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            Statement st = con.createStatement();
            String sql = "SELECT Cari_id FROM Cari";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("Cari_id") >= yeniid) {
                    yeniid = rs.getInt("Cari_id");
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
    public Cari(){
        this.cari_id = this.idatama();
    
    }
    public String toString(){
        return this.tckimlik;
    }
    
    
}
