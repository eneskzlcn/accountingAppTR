/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Pc
 */
public class AlisFaturasi extends javax.swing.JFrame {

    /**
     * Creates new form AlisFaturasi
     */
    String url = "jdbc:derby://localhost:1527/sample";
    String user = "app";
    String pass = "app";

    public AlisFaturasi() {
        initComponents();
    }

    String seciliisyeriadi;
    int seciliisyeriid;
    DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

    DefaultComboBoxModel faturavegun = new DefaultComboBoxModel();
    DefaultComboBoxModel faturaveay = new DefaultComboBoxModel();

    DefaultComboBoxModel faturaveyıl = new DefaultComboBoxModel();
    DefaultComboBoxModel dakikas = new DefaultComboBoxModel();
    DefaultComboBoxModel saniyes = new DefaultComboBoxModel();
    DefaultComboBoxModel saats = new DefaultComboBoxModel();

    public AlisFaturasi(String s, DefaultTableModel dstm) {
        initComponents();
        String faturavegunu ="";
       
        for (int i = 0; i < 32; i++) {
            if(i<10){
                faturavegunu = "0"+String.valueOf(i);
            }
            else{
                faturavegunu = String.valueOf(i);
            }
            faturavegun.addElement(faturavegunu);

        }
        

        for (int i = 2019; i < 2200; i++) {
            faturaveyıl.addElement(i);

        }
        String faturveayi="";
        for (int i = 1; i < 13; i++) {
            if(i<10){
                faturveayi = "0"+String.valueOf(i);
            }
            else{
                faturveayi = String.valueOf(i);
            }
            faturaveay.addElement(faturveayi);

        }
        String dakikaicin = "";
        String saniyeicin= "";
        for (int i = 0; i < 60; i++) {
            if(i<10){
                dakikaicin = "0"+ String.valueOf(i);
                saniyeicin = String.valueOf(i);
            }
            else{
                dakikaicin = String.valueOf(i);
                saniyeicin = String.valueOf(i);
            }
            dakikas.addElement(dakikaicin);
            saniyes.addElement(saniyeicin);
        }
        String saaticin;
        for (int i = 0; i < 24; i++) {
            if(i<10){
                saaticin = "0"+String.valueOf(i);
            }
            else{
            saaticin = String.valueOf(i);
        }
            saats.addElement(saaticin);
        }

        faturaay.setModel(faturaveay);
        faturagun.setModel(faturavegun);
        faturayıl.setModel(faturaveyıl);
        saat.setModel(saats);
        dakika.setModel(dakikas);
        saniye.setModel(saniyes);
        jTable5.setModel(dstm);
        seciliisyeriadi = s;
        dcbm.addElement(" ");
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Isyeri WHERE Adi = '" + seciliisyeriadi + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                seciliisyeriid = rs.getInt("Isyeri_id");
            }
            Statement st2 = con.createStatement();
            String sql2 = "SELECT * FROM Cari WHERE Isyeri_id =" + seciliisyeriid;
            ResultSet rs2 = st2.executeQuery(sql2);
            while (rs2.next()) {
                dcbm.addElement(rs2.getString("Adi") + " " + rs2.getString("TcKimlik"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(AlisFaturasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox1.setModel(dcbm);
        int sayac = 0;
        for (int i = 0; i < jTable5.getRowCount(); i++) {
            sayac += (int) jTable5.getValueAt(i, 3);
        }
        jTextField52.setText(String.valueOf(sayac));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane11 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        hesapno = new javax.swing.JTextField();
        vergidairesi = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        ad = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        soyad = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ticariunvan = new javax.swing.JTextField();
        faturagun = new javax.swing.JComboBox<String>();
        faturaay = new javax.swing.JComboBox<String>();
        faturayıl = new javax.swing.JComboBox<String>();
        saat = new javax.swing.JComboBox<String>();
        dakika = new javax.swing.JComboBox<String>();
        saniye = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable5.setEnabled(false);
        jScrollPane11.setViewportView(jTable5);

        hesapno.setEditable(false);

        vergidairesi.setEditable(false);

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel113.setText("Vergi Dairesi");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel83.setText("         ALIS FATURASI");

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("Hesap No");

        ad.setEditable(false);

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Ad");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Soyad");

        soyad.setEditable(false);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Fatura Tarihi");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel106.setText("Fatura Saati");

        jButton31.setText("KAYDET");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jLabel117.setText("TL");

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel118.setText("Genel Toplam");

        jTextField52.setEditable(false);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cari Secin");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ticari Unvan");

        ticariunvan.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel118)
                .addGap(18, 18, 18)
                .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel117)
                .addGap(117, 117, 117)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(209, 209, 209)
                                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(209, 209, 209)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ticariunvan, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(122, 122, 122)
                                            .addComponent(jLabel113))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(42, 42, 42)
                                            .addComponent(jLabel90)))))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(vergidairesi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hesapno, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(52, 52, 52)
                                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(8, 8, 8)))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(saat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(faturagun, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(faturaay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dakika, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(faturayıl, 0, 74, Short.MAX_VALUE)
                                .addComponent(saniye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dakika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saniye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(hesapno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel90)
                                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(faturagun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(faturaay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(faturayıl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(soyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vergidairesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(ticariunvan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultTableModel dtm1 = new DefaultTableModel();
    String dosya = "c://dosyalar/Islemler.txt";
    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        String faturatarih = String.valueOf(faturagun.getSelectedItem()) + "."+
                String.valueOf(faturaay.getSelectedItem()) + "."+String.valueOf(faturayıl.getSelectedItem());
        String faturasaat =String.valueOf(saat.getSelectedItem()) + "." +String.valueOf(dakika.getSelectedItem()) + "."
                +String.valueOf(saniye.getSelectedItem());
        for (int i = 0; i < jTable5.getRowCount(); i++) {

        }
        
       
        int cari_id = 0;
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String[] dizi = String.valueOf(jComboBox1.getSelectedItem()).split(" ");
            String sql = "SELECT * FROM Cari WHERE TcKimlik = '" + dizi[1] + "'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                cari_id = rs.getInt("Cari_id");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlisFaturasi.class.getName()).log(Level.SEVERE, null, ex);

        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select i.islemId from Islem i");
        List<Integer> idler = q.getResultList();
        Integer enbuyukid = 0;
        for (Integer i : idler) {
            if (i >= enbuyukid) {
                enbuyukid = i + 1;
            } else {
                enbuyukid++;
            }

        }
        String[] options = new String[2];
            options[0] = "Evet";
            options[1] = "Hayır";
           
            int x = JOptionPane.showOptionDialog(null, "Gercekten kaydetmek istiyor musunuz ?", "Uyarı", 0, JOptionPane.INFORMATION_MESSAGE, null, options,null);
            if(x == JOptionPane.YES_OPTION){
            em.getTransaction().begin();

        Islem islem = new Islem();
        islem.setIslemId(enbuyukid);
        islem.setCariId(cari_id);
        islem.setTutar(Integer.parseInt(jTextField52.getText()));
        islem.setIslemturu("Fatura");
        islem.setIslemsaati(faturasaat);
        islem.setTarih(faturatarih);
        islem.setTutarturu("Borc");
        islem.setVadetarihi("");

        em.persist(islem);
        em.getTransaction().commit();
        em.close();
        emf.close();
        FileWriter fw = null;
                    try {
                    fw = new FileWriter(new File(dosya), true);
                    fw.write(islem.getTarih()+" "+"tarihi"+" "+islem.getIslemsaati()+ " "+" saatinde" + " "
                    + islem.getTutar() + " " + "TL tutarında" + " " + islem.getTutarturu()+ " " + "kaydedilmistir.\r\n");
                    
                } catch (IOException ex) {
                    Logger.getLogger(Carihareketkaydi2.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Carihareketkaydi2.class.getName()).log(Level.SEVERE, null, ex);
                    }}
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Urun";
            ResultSet rs = st.executeQuery(sql);
            String sql2 = "UPDATE URUN SET GirenMiktar = ?,KalanMiktar = ?";
            PreparedStatement prst = con.prepareStatement(sql2);
            while (rs.next()) {
                for (int i = 0; i < jTable5.getRowCount(); i++) {
                    if (jTable5.getValueAt(i, 0).equals(rs.getString("Adi"))) {
                        prst.setInt(1, rs.getInt("GirenMiktar") + Integer.valueOf(jTable5.getValueAt(i, 1).toString()));
                        prst.setInt(2, rs.getInt("KalanMiktar") + Integer.valueOf(jTable5.getValueAt(i, 1).toString()));
                        prst.executeUpdate();
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlisFaturasi.class.getName()).log(Level.SEVERE, null, ex);
        }try{
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM URUN";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < jTable5.getRowCount(); i++) {
                if(jTable5.getValueAt(i,0).equals(rs.getString("Adi"))){
                    
                    
                
                if(rs.getInt("KalanMiktar")> rs.getInt("MaximumMiktar")){
                    JOptionPane.showMessageDialog(null, "Stokta bulunması istenen maximum miktarın ustune cikildi!!");
                
            }
                }
                }
            }
            con.close();
        }
        catch(SQLException ex){
            Logger.getLogger(AlisFaturasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Islem kaydedildi.");
        this.setVisible(Boolean.FALSE);
            }
            else if (x == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Kaydedilmedi", "Uyari", 1);
            }

    }//GEN-LAST:event_jButton31ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            // TODO add your handling code here:
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String[] dizi = String.valueOf(jComboBox1.getSelectedItem()).split(" ");
            String sql = "SELECT * FROM Cari WHERE TcKimlik ='" + dizi[1] + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ticariunvan.setText(rs.getString("TicariUnvan"));
                ad.setText(rs.getString("Adi"));
                soyad.setText(rs.getString("Soyadi"));
                vergidairesi.setText(rs.getString("VergiDairesi"));
                hesapno.setText(rs.getString("Hesap1No"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AlisFaturasi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlisFaturasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlisFaturasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlisFaturasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlisFaturasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlisFaturasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad;
    private javax.swing.JComboBox<String> dakika;
    private javax.swing.JComboBox<String> faturaay;
    private javax.swing.JComboBox<String> faturagun;
    private javax.swing.JComboBox<String> faturayıl;
    private javax.swing.JTextField hesapno;
    private javax.swing.JButton jButton31;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JComboBox<String> saat;
    private javax.swing.JComboBox<String> saniye;
    private javax.swing.JTextField soyad;
    private javax.swing.JTextField ticariunvan;
    private javax.swing.JTextField vergidairesi;
    // End of variables declaration//GEN-END:variables
}