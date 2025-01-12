/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.loginUser;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form reportes
     */
    public Reportes() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        rankingBtn = new javax.swing.JButton();
        batallasBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rankingBtn.setBackground(new java.awt.Color(82, 82, 82));
        rankingBtn.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        rankingBtn.setText("Ranking");
        rankingBtn.setBorder(null);
        rankingBtn.setContentAreaFilled(false);
        rankingBtn.setFocusPainted(false);
        rankingBtn.setFocusable(false);
        rankingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingBtnActionPerformed(evt);
            }
        });

        batallasBtn.setBackground(new java.awt.Color(82, 82, 82));
        batallasBtn.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        batallasBtn.setText("Batallas");
        batallasBtn.setBorder(null);
        batallasBtn.setBorderPainted(false);
        batallasBtn.setContentAreaFilled(false);
        batallasBtn.setFocusPainted(false);
        batallasBtn.setFocusable(false);
        batallasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batallasBtnActionPerformed(evt);
            }
        });

        salirBtn.setBackground(new java.awt.Color(87, 62, 88));
        salirBtn.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        salirBtn.setForeground(new java.awt.Color(255, 255, 255));
        salirBtn.setText("Salir");
        salirBtn.setBorderPainted(false);
        salirBtn.setContentAreaFilled(false);
        salirBtn.setFocusPainted(false);
        salirBtn.setFocusable(false);
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(458, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batallasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rankingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(rankingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(batallasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void rankingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingBtnActionPerformed
        Ranking ranking = new Ranking();
        ranking.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rankingBtnActionPerformed

    private void batallasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batallasBtnActionPerformed
        Batallas batallas = new Batallas();
        batallas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_batallasBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batallasBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton rankingBtn;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/resources/reportes.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
}
