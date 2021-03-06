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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class Carihesapekstre2 extends javax.swing.JFrame {

    /**
     * Creates new form carihesapekstre2
     */
    public Carihesapekstre2() {
        initComponents();
    }
    String url = "jdbc:derby://localhost:1527/sample";
    String user = "app";
    String pass = "app";

    String seciliisyeriadi, secilicaritc;
    int seciliisyeriid;
    int secilicariid;
    String ticariunvan;
    DefaultTableModel dtm = new DefaultTableModel();

    public Carihesapekstre2(String s, String b) {
        initComponents();
        seciliisyeriadi = s;
        secilicaritc = b;

        try {

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Cari WHERE TcKimlik = '" + secilicaritc + "'";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                secilicariid = rs.getInt("Cari_id");
                ticariunvan = rs.getString("TicariUnvan");
            }
            dtm.setColumnIdentifiers(new Object[]{"Islem Tarihi", "Islem Saati", "Islem Tutarı", "Tutar Turu", "Islem Turu", "TicariUnvan"});
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
            EntityManager em = emf.createEntityManager();

            int borcsayac = 0;
            int alacaksayac = 0;
            int toplambakiye = 0;
            Query q = em.createQuery("Select i from Islem i WHERE i.cariId = " + secilicariid);
            List<Islem> islemler = q.getResultList();
            for (Islem islem : islemler) {
                Vector vector = new Vector();
                vector.add(islem.getTarih());
                vector.add(islem.getIslemsaati());
                vector.add(islem.getTutar());
                vector.add(islem.getTutarturu());
                vector.add(islem.getIslemturu());
                vector.add(ticariunvan);
                dtm.addRow(vector);
                if (islem.getTutarturu().equals("Borc")) {
                    borcsayac += islem.getTutar();
                } else {
                    alacaksayac += islem.getTutar();
                }

            }
            jTable1.setModel(dtm);
            if (borcsayac > alacaksayac) {
                jTextField66.setText("Borc");
                toplambakiye = borcsayac - alacaksayac;
            } else if (borcsayac < alacaksayac) {
                jTextField66.setText("Alacak");
                toplambakiye = alacaksayac - borcsayac;
            } else if (borcsayac == alacaksayac) {
                jTextField66.setText("");
                toplambakiye = alacaksayac - borcsayac;
            }
            toplamborc.setText(String.valueOf(borcsayac));
            toplamalacak.setText(String.valueOf(alacaksayac));
            geneltoplam.setText(String.valueOf(toplambakiye));

        } catch (SQLException ex) {
            Logger.getLogger(Carihesapekstre2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel105 = new javax.swing.JLabel();
        toplamalacak = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel120 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        toplamborc = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jTextField66 = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        geneltoplam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel105.setText("TL");

        toplamalacak.setEditable(false);

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel102.setText("Bakiye Turu");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable1);

        jLabel120.setText("TL");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Toplam Borc");

        jLabel121.setText("TL");

        toplamborc.setEditable(false);

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("Toplam Alacak");

        jTextField66.setEditable(false);

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel99.setText("Toplam Bakiye");

        geneltoplam.setEditable(false);

        jButton1.setText("CIKIS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CARİNİN HESAP EKSTRESİ");

        jButton2.setText("Secili Islemi Sil");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(geneltoplam, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel121))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(toplamborc, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel120)))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addGap(18, 18, 18)
                        .addComponent(toplamalacak, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel105)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(256, 256, 256))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(639, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toplamalacak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel105)
                            .addComponent(toplamborc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel120)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102)
                            .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel121)
                            .addComponent(geneltoplam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(461, 461, 461)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(Boolean.FALSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select i from Islem i where i.cariId =" + secilicariid);
        List<Islem> islemler = q.getResultList();
        for (Islem islem : islemler) {
            if (jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString().equals(islem.getIslemsaati())) {
                String[] options = new String[2];
                options[0] = "Evet";
                options[1] = "Hayır";
                int x = JOptionPane.showOptionDialog(null, "Gercekten silmek istiyor musunuz ?", "Uyarı", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                if (x == JOptionPane.YES_OPTION) {

                    em.getTransaction().begin();
                    em.remove(islem);
                    em.getTransaction().commit();
                    dtm.removeRow(jTable1.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Isleminiz Silindi");
                    break;
                } else if (x == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Islem silinmedi");
                }
            }
        }
        em.close();
        emf.close();

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Carihesapekstre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carihesapekstre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carihesapekstre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carihesapekstre2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carihesapekstre2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField geneltoplam;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField toplamalacak;
    private javax.swing.JTextField toplamborc;
    // End of variables declaration//GEN-END:variables
}
