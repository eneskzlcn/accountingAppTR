/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc
 */
public class Carihareketkaydi2 extends javax.swing.JFrame {

    /**
     * Creates new form carihareketkaydi2
     */
    
    public Carihareketkaydi2() {
        initComponents();
        
        
         
    }DefaultComboBoxModel dcbm32 = new DefaultComboBoxModel();
        DefaultComboBoxModel islemgun = new DefaultComboBoxModel();
        DefaultComboBoxModel islemay = new DefaultComboBoxModel();
        DefaultComboBoxModel islemyil = new DefaultComboBoxModel();
        DefaultComboBoxModel vadeyil = new DefaultComboBoxModel();
        DefaultComboBoxModel vadeay = new DefaultComboBoxModel();
        DefaultComboBoxModel vadegun = new DefaultComboBoxModel();
        DefaultComboBoxModel saat = new DefaultComboBoxModel();
        DefaultComboBoxModel dakika = new DefaultComboBoxModel();
        DefaultComboBoxModel saniye = new DefaultComboBoxModel();
        
   
    String secilicaritc;
    String url = "jdbc:derby://localhost:1527/sample ";
    String user = "app";
    String pass = "app";
    int cari_id;
    
    public Carihareketkaydi2(String s) {
        
            initComponents();
             
            secilicaritc = s;
           try { 
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Cari WHERE TcKimlik = '"+secilicaritc+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ticariunvan.setText(rs.getString("TicariUnvan"));
                ad.setText(rs.getString("Adi"));
                soyad.setText(rs.getString("Soyadi"));
                cari_id = rs.getInt("Cari_id");
            }
            } catch (SQLException ex) {
            Logger.getLogger(Carihareketkaydi2.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            dcbm32.addElement(" ");
            dcbm32.addElement("Nakit");
            dcbm32.addElement("Kredi Karti");
            dcbm32.addElement("Cek");
            dcbm32.addElement("Makbuz");
            dcbm32.addElement("Taksit");
            jComboBox6.setModel(dcbm32);
            
            
            String gunn = "";
            for (int i = 0; i < 32; i++) {
                if(i<10){
                    gunn = "0"+ i;
                }
                else{
                    gunn = String.valueOf(i);
                }
                islemgun.addElement(gunn);
                vadegun.addElement(gunn);
                
                
            }
            String yil;
            for (int i = 1970; i < 2020;i++) {
                yil = String.valueOf(i);
                islemyil.addElement(yil);
                
                
            }
            String vadeyilii;
            for (int i = 2019; i < 2200; i++) {
                vadeyilii = String.valueOf(i);
                vadeyil.addElement(vadeyilii);
                
            }
            String islemayii;
            for (int i = 1; i < 13; i++) {
                if(i<10){
                    islemayii="0"+i;
                
                
            }
                else{
                    islemayii = String.valueOf(i);
                    
                }
                islemay.addElement(islemayii);
                vadeay.addElement(islemayii);
            
            }
            String saats = "";
            for (int i = 0; i < 24; i++) {
                if(i<10){
                    saats = "0" + i;
                }
                else{
                    saats = String.valueOf(i);
                }
                saat.addElement(saats);
                
            }
            String dkvesn;
            for (int i = 0; i < 60; i++) {
                if(i<10){
                    dkvesn = "0" + i;
                }
                else{
                    dkvesn = String.valueOf(i);
                }
                dakika.addElement(dkvesn);
                saniye.addElement(dkvesn);
                
            }
            islemgunu.setModel(islemgun);
            islemayi.setModel(islemay);
            islemyili.setModel(islemyil);
            islemsaati.setModel(saat);
            islemdakikasi.setModel(dakika);
            islemsaniyesi.setModel(saniye);
            vadegunu.setModel(vadegun);
            vadeayi.setModel(vadeay);
            vadeyili.setModel(vadeyil);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel57 = new javax.swing.JLabel();
        borc = new javax.swing.JRadioButton();
        alacak = new javax.swing.JRadioButton();
        jLabel58 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<String>();
        ad = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        soyad = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        ticariunvan = new javax.swing.JTextField();
        islemgunu = new javax.swing.JComboBox<String>();
        islemayi = new javax.swing.JComboBox<String>();
        islemyili = new javax.swing.JComboBox<String>();
        islemsaati = new javax.swing.JComboBox<String>();
        islemdakikasi = new javax.swing.JComboBox<String>();
        islemsaniyesi = new javax.swing.JComboBox<String>();
        vadegunu = new javax.swing.JComboBox<String>();
        vadeayi = new javax.swing.JComboBox<String>();
        vadeyili = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Tutar Turu");

        buttonGroup1.add(borc);
        borc.setText("Borc");

        buttonGroup1.add(alacak);
        alacak.setText("Alacak");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Islem Tutarı");

        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jLabel59.setText("TL");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Islem Turu");

        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        ad.setEditable(false);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Islem Tarıhı");

        soyad.setEditable(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Islem Saatı");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Tarih Bilgileri");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Vade Tarıhı");

        jButton27.setText("ISLEMI KAYDET");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setText("Tıcarı Unvan");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Ad");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Soyadı");

        ticariunvan.setEditable(false);

        islemdakikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                islemdakikasiActionPerformed(evt);
            }
        });

        islemsaniyesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                islemsaniyesiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CARİ HAREKET KAYDİ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton27)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel64)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel66)))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ticariunvan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alacak)
                                .addGap(18, 18, 18)
                                .addComponent(borc))
                            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel59))
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel62)
                            .addComponent(jLabel61)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel63)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(islemsaati, 0, 53, Short.MAX_VALUE)
                                    .addComponent(islemgunu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(vadegunu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(islemayi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(islemyili, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(islemdakikasi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(islemsaniyesi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(vadeayi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(vadeyili, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticariunvan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(soyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alacak)
                            .addComponent(borc))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(islemgunu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(islemayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(islemyili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel61))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(islemsaati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(islemdakikasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(islemsaniyesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(vadeyili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vadeayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vadegunu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8))))
                .addGap(49, 49, 49)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed
    DefaultComboBoxModel dcbm82 = new DefaultComboBoxModel();
    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        String islemtarih = String.valueOf(islemgunu.getSelectedItem())+"."+String.valueOf(islemayi.getSelectedItem()+"." +
                String.valueOf(islemyili.getSelectedItem()));
        String islemsaat = String.valueOf(islemsaati.getSelectedItem())+ "."+String.valueOf(islemdakikasi.getSelectedItem())+"."+
                String.valueOf(islemsaniyesi.getSelectedItem());
        String vadetarihi =String.valueOf(vadegunu.getSelectedItem()+"."+String.valueOf(vadeayi.getSelectedItem())
                +"." + String.valueOf(vadeyili.getSelectedItem()));
        
        
        int a = 0;
        try {
            
        
       
        int c = Integer.valueOf(jTextField30.getText());
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lutfen sayiyla doldurulmasi gereken yerleri sayiyla doldurun");
            a = 5;
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select i.islemId from Islem i");
        List<Integer> idler = q.getResultList();
        Integer enbuyukid = 0;
        for (Integer i : idler) {
            if(i >= enbuyukid){
                enbuyukid = i+1;
            }
            else{
                enbuyukid++;
            }

        }
        
        String dosya = "c://dosyalar//Islemler.txt";
        if(a == 0){
            String[] options = new String[2];
            options[0] = "Evet";
            options[1] = "Hayır";
            int x = JOptionPane.showOptionDialog(null, "Gercekten kaydetmek istiyor musunuz ?", "Uyarı", 0, JOptionPane.INFORMATION_MESSAGE, null, options,null);
            if(x == JOptionPane.YES_OPTION){
                
                
                    em.getTransaction().begin();
                    Islem islem = new Islem();
                    islem.setCariId(cari_id);
                    islem.setIslemId(enbuyukid);
                    if(alacak.isSelected()){
                        islem.setTutarturu("Alacak");
                    }
                    if(borc.isSelected()){
                        islem.setTutarturu("Borc");
                    }
                    islem.setTutar(Integer.valueOf(jTextField30.getText()));
                    islem.setIslemsaati(islemsaat);
                    islem.setIslemturu(String.valueOf(jComboBox6.getSelectedItem()));
                    islem.setVadetarihi(vadetarihi);
                    islem.setTarih(islemtarih);
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
                    }
                }
                    
                this.setVisible(Boolean.FALSE);
                JOptionPane.showMessageDialog(null, "Kaydedildi");
        }
            
            else if(x==JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null,"Isleminiz kaydedilmedi.", "Uyarı", 1);
            }
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void islemsaniyesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_islemsaniyesiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_islemsaniyesiActionPerformed

    private void islemdakikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_islemdakikasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_islemdakikasiActionPerformed

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
            java.util.logging.Logger.getLogger(Carihareketkaydi2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carihareketkaydi2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carihareketkaydi2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carihareketkaydi2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carihareketkaydi2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad;
    private javax.swing.JRadioButton alacak;
    private javax.swing.JRadioButton borc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> islemayi;
    private javax.swing.JComboBox<String> islemdakikasi;
    private javax.swing.JComboBox<String> islemgunu;
    private javax.swing.JComboBox<String> islemsaati;
    private javax.swing.JComboBox<String> islemsaniyesi;
    private javax.swing.JComboBox<String> islemyili;
    private javax.swing.JButton jButton27;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField soyad;
    private javax.swing.JTextField ticariunvan;
    private javax.swing.JComboBox<String> vadeayi;
    private javax.swing.JComboBox<String> vadegunu;
    private javax.swing.JComboBox<String> vadeyili;
    // End of variables declaration//GEN-END:variables
}
