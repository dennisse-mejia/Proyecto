/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.loginUser;
import Vista.*;
import Vista.MiInformacion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class CambiarContra extends javax.swing.JFrame {

    /**
     * Creates new form cambiarContra
     */
    public CambiarContra() {
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
        cancelarbtn = new javax.swing.JButton();
        aceptarbtn = new javax.swing.JButton();
        contraAnterior = new javax.swing.JPasswordField();
        contraNueva = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelarbtn.setBackground(new java.awt.Color(87, 62, 88));
        cancelarbtn.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        cancelarbtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelarbtn.setText("CANCELAR");
        cancelarbtn.setBorder(null);
        cancelarbtn.setBorderPainted(false);
        cancelarbtn.setContentAreaFilled(false);
        cancelarbtn.setFocusPainted(false);
        cancelarbtn.setFocusable(false);
        cancelarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarbtnActionPerformed(evt);
            }
        });

        aceptarbtn.setBackground(new java.awt.Color(87, 62, 88));
        aceptarbtn.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        aceptarbtn.setForeground(new java.awt.Color(255, 255, 255));
        aceptarbtn.setText("ACEPTAR");
        aceptarbtn.setBorder(null);
        aceptarbtn.setBorderPainted(false);
        aceptarbtn.setContentAreaFilled(false);
        aceptarbtn.setFocusPainted(false);
        aceptarbtn.setFocusable(false);
        aceptarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarbtnActionPerformed(evt);
            }
        });

        contraAnterior.setOpaque(false);
        contraAnterior.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        contraAnterior.setBorder(null); // Sin borde

        contraNueva.setOpaque(false);
        contraNueva.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        contraNueva.setBorder(null); // Sin borde

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("Contraseña anterior:");

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel2.setText("Contraseña nueva:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(339, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cancelarbtn)
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contraAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(aceptarbtn)))
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarbtn)
                    .addComponent(aceptarbtn))
                .addGap(172, 172, 172))
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

    private void cancelarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarbtnActionPerformed
        MiInformacion miInfo = new MiInformacion();
        miInfo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarbtnActionPerformed

    private void aceptarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarbtnActionPerformed
        String contraseñaActual = new String(contraAnterior.getPassword());
        String nuevaContraseña = new String(contraNueva.getPassword());

        boolean cambioExitoso = loginUser.cambiarContraseña(contraseñaActual, nuevaContraseña);

        if (cambioExitoso) {
            //JOptionPane.showMessageDialog(this, "Contraseña cambiada exitosamente.");
            MiInformacion miInfo = new MiInformacion();
            miInfo.setVisible(true);
            this.dispose();
        } else {
            //JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña.");
        }
    }//GEN-LAST:event_aceptarbtnActionPerformed

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
                new CambiarContra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarbtn;
    private javax.swing.JButton cancelarbtn;
    private javax.swing.JPasswordField contraAnterior;
    private javax.swing.JPasswordField contraNueva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/resources/cambiarContra.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}
