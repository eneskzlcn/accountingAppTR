/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pc
 */
public class Tumekstre extends javax.swing.JFrame {

    /**
     * Creates new form tumesktre
     */
    public Tumekstre() {
        initComponents();
    }

    String seciliisyeriadi;
    String url = "jdbc:derby://localhost:1527/sample";
    String user = "app";
    String pass = "app";
    DefaultTableModel dtm = new DefaultTableModel();
    int seciliisyeriid;

    public Tumekstre(String s) {
        initComponents();
        int carisayisi = 0;
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Cari";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                carisayisi++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tumekstre.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] idler = new int[carisayisi];
        int i = 0;
        seciliisyeriadi = s;
        dtm.setColumnIdentifiers(new Object[]{"Islem Tarihi", "Islem Saati", "Vade Tarihi", "Islem Tutarı", "Tutar Turu", "Islem Turu", "Cari Adi"});
        try {

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Isyeri WHERE Adi = '" + seciliisyeriadi + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                seciliisyeriid = rs.getInt("Isyeri_id");
            }
            Statement st2 = con.createStatement();
            String sql2 = "SELECT * FROM Cari";
            ResultSet rs2 = st2.executeQuery(sql2);
            while (rs2.next()) {

                if (rs2.getInt("Isyeri_id") == seciliisyeriid) {

                    idler[i] = rs2.getInt("Cari_id");

                    i++;
                }
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tumekstre.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select i from Islem i");
        List<Islem> islemler = q.getResultList();
        boolean acaba = false;
        String secilicari = "";
        for (Islem islem : islemler) {

            for (int j = 0; j < idler.length; j++) {

                if (islem.getCariId() == idler[j]) {
                    acaba = true;

                }

            }

            if (acaba) {
                try {
                    Connection con = DriverManager.getConnection(url, user, pass);
                    Statement st = con.createStatement();
                    String sql = "SELECT * FROM Cari WHERE Cari_id =" + islem.getCariId();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        secilicari = rs.getString("Adi");
                    }
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("");
                }
                Vector vector = new Vector();
                vector.add(islem.getTarih());
                vector.add(islem.getIslemsaati());
                vector.add(islem.getVadetarihi());
                vector.add(islem.getTutar());
                vector.add(islem.getTutarturu());
                vector.add(islem.getIslemturu());
                vector.add(secilicari);
                dtm.addRow(vector);

            }
        }

        jTable6.setModel(dtm);
        em.close();
        emf.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        geneltoplam = new javax.swing.JTextField();
        toplamborc = new javax.swing.JTextField();
        toplamalacak = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        turu = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel144 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel166.setText("Toplam Alacak");

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel167.setText("Genel Toplam");

        geneltoplam.setEditable(false);

        toplamborc.setEditable(false);

        toplamalacak.setEditable(false);

        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel168.setText("Toplam Turu");

        turu.setEditable(false);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane16.setViewportView(jTable6);

        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel144.setText("Toplam Borc");

        jButton1.setText("CIKIS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Islem Kayıtlari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("TL");

        jLabel2.setText("TL");

        jLabel3.setText("TL");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("TUM EKSTRE");

        jButton3.setText("Toplam Hesapla");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Secili Islemi Sil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Dosyaya Islem Yaz");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Dosyadan Islem Oku");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(turu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel166))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(toplamborc)
                                            .addComponent(toplamalacak, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(geneltoplam, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel168)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(toplamborc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel166)
                                    .addComponent(toplamalacak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel167)
                                    .addComponent(geneltoplam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(turu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        KayitliIslemler gecmisislemler = new KayitliIslemler();
        gecmisislemler.setVisible(Boolean.TRUE);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        this.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int borcsayac = 0;
        int alacaksayac = 0;
        int toplamsayac = 0;

        for (int j = 0; j < jTable6.getRowCount(); j++) {

            if (String.valueOf(jTable6.getValueAt(j, 4)).equals("Borc")) {

                borcsayac += Integer.valueOf(jTable6.getValueAt(j, 3).toString());

            } else if (String.valueOf(jTable6.getValueAt(j, 4)).equals("Alacak")) {
                alacaksayac += Integer.valueOf(jTable6.getValueAt(j, 3).toString());
            }

        }
        toplamborc.setText(String.valueOf(borcsayac));
        toplamalacak.setText(String.valueOf(alacaksayac));
        if (borcsayac < alacaksayac) {
            turu.setText("Alacak");
            toplamsayac = alacaksayac - borcsayac;
            geneltoplam.setText(String.valueOf(toplamsayac));
        } else if (borcsayac > alacaksayac) {
            turu.setText("Borc");
            toplamsayac = borcsayac - alacaksayac;
            geneltoplam.setText(String.valueOf(toplamsayac));
        } else if (borcsayac == alacaksayac) {
            turu.setText("");
            geneltoplam.setText(String.valueOf(toplamsayac));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(jTable6.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Lutfen tablodan silmek istediginiz islemi secin");
            return;
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select i from Islem i");
        List<Islem> islemler = q.getResultList();
        for (Islem islem : islemler) {
            if (jTable6.getValueAt(jTable6.getSelectedRow(), 1).toString().equals(islem.getIslemsaati())) {
                String[] options = new String[2];
                options[0] = "Evet";
                options[1] = "Hayır";
                int x = JOptionPane.showOptionDialog(null, "Gercekten silmek istiyor musunuz ?", "Uyarı", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                if (x == JOptionPane.YES_OPTION) {

                    em.getTransaction().begin();
                    em.remove(islem);
                    em.getTransaction().commit();
                    dtm.removeRow(jTable6.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Silindi");
                    break;
                } else if (x == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Islem silinmedi");
                }
            }
        }
        em.close();
        emf.close();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(jTable6.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Lutfen dosyaya yazmak istediginiz islemi tablodan secin!");
        return;
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT i from Islem i");
        List<Islem> islemler = q.getResultList();
        String path = "C:\\Users\\DELL\\Documents\\NetBeansProjects\\JavaApplication1\\src\\proje\\Islemlermis.dat";
        
        for (Islem islem : islemler) {
            if(islem.getIslemsaati().equals(jTable6.getValueAt(jTable6.getSelectedRow(),1).toString())){
                ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
                oos.writeObject(islem); 
            } catch (IOException ex) {
                Logger.getLogger(Carihesapekstre2.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Carihesapekstre2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            }

            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(jTable6.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,"Lutfen dosyasını okumak istediginiz islemi tablodan secin");
            return;
        }
       String path = "C:\\Users\\DELL\\Documents\\NetBeansProjects\\JavaApplication1\\src\\proje\\Islemlermis.dat";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT i from Islem i");
        List<Islem> islemler = q.getResultList();
        for (Islem islem : islemler) {
            if(jTable6.getValueAt(jTable6.getSelectedRow(), 1).toString().equals(islem.getIslemsaati())){
                ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
            while (true) {
                Islem islems = (Islem) ois.readObject();
                String yazi = "Islem Tarihi = " + islems.getTarih() + "\r\n" + "Islem Saati = " + islems.getIslemsaati() + "\r\n"
                        + "Islem turu = " + islems.getIslemturu() + "\r\n" + "Tutar = " + islems.getTutar() + "\r\n"
                        + "Tutar Turu = " + islems.getTutarturu() + "\r\n" + "Vade Tarihi = " + islems.getVadetarihi()+"\r\n";
                
                jTextArea1.setText(yazi);
                
            }
        } catch (EOFException e) {

        }catch(StreamCorruptedException e){
        }
        catch (IOException ex) {
            Logger.getLogger(Carihesapekstre2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Carihesapekstre2.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Carihesapekstre2.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
            
        }
        
        }

        


    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Tumekstre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tumekstre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tumekstre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tumekstre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tumekstre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField geneltoplam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField toplamalacak;
    private javax.swing.JTextField toplamborc;
    private javax.swing.JTextField turu;
    // End of variables declaration//GEN-END:variables
}
