/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.loginUser;
import Vista.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class MiInformacion extends javax.swing.JFrame {

    /**
     * Creates new form MiInformacion
     */
    public MiInformacion() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        cargarInformacionUsuario();

    }

    private void cargarInformacionUsuario() {
        String usuario = loginUser.obtenerUsuarioLogueado();
        int puntos = loginUser.obtenerPuntos();
        int partidasTotales = loginUser.obtenerTotalPartidas();
        int partidasHeroes = loginUser.obtenerPartidasHeroes();
        int partidasVillanos = loginUser.obtenerPartidasVillanos();

        usuariosInfo.setText(usuario);
        this.puntos.setText(String.valueOf(puntos));
        jugadasHeroes.setText(String.valueOf(partidasHeroes));
        jugadasVillanos.setText(String.valueOf(partidasVillanos));
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
        cambiarContrabtn = new javax.swing.JButton();
        eliminarCuentabtn = new javax.swing.JButton();
        salirbtn = new javax.swing.JButton();
        logs = new javax.swing.JButton();
        usuarioLabel = new javax.swing.JLabel();
        puntosLabel = new javax.swing.JLabel();
        jugadasHeroesLbl = new javax.swing.JLabel();
        jugadasVillanosLbl = new javax.swing.JLabel();
        usuariosInfo = new javax.swing.JLabel();
        puntos = new javax.swing.JLabel();
        jugadasHeroes = new javax.swing.JLabel();
        jugadasVillanos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cambiarContrabtn.setBackground(new java.awt.Color(82, 82, 82));
        cambiarContrabtn.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        cambiarContrabtn.setText("Cambiar mi contraseña");
        cambiarContrabtn.setBorderPainted(false);
        cambiarContrabtn.setContentAreaFilled(false);
        cambiarContrabtn.setFocusPainted(false);
        cambiarContrabtn.setFocusable(false);
        cambiarContrabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarContrabtnActionPerformed(evt);
            }
        });

        eliminarCuentabtn.setBackground(new java.awt.Color(82, 82, 82));
        eliminarCuentabtn.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        eliminarCuentabtn.setText("Eliminar cuenta");
        eliminarCuentabtn.setBorderPainted(false);
        eliminarCuentabtn.setContentAreaFilled(false);
        eliminarCuentabtn.setFocusPainted(false);
        eliminarCuentabtn.setFocusable(false);
        eliminarCuentabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCuentabtnActionPerformed(evt);
            }
        });

        salirbtn.setBackground(new java.awt.Color(87, 62, 88));
        salirbtn.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        salirbtn.setForeground(new java.awt.Color(255, 255, 255));
        salirbtn.setText("Salir");
        salirbtn.setBorderPainted(false);
        salirbtn.setContentAreaFilled(false);
        salirbtn.setFocusPainted(false);
        salirbtn.setFocusable(false);
        salirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirbtnActionPerformed(evt);
            }
        });

        logs.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        logs.setText("Log ultimos juegos");
        logs.setBorderPainted(false);
        logs.setContentAreaFilled(false);
        logs.setFocusPainted(false);
        logs.setFocusable(false);
        logs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logsActionPerformed(evt);
            }
        });

        usuarioLabel.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        usuarioLabel.setText("Usuario:");

        puntosLabel.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        puntosLabel.setText("Puntos:");

        jugadasHeroesLbl.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        jugadasHeroesLbl.setText("Jugadas Heroes:");

        jugadasVillanosLbl.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        jugadasVillanosLbl.setText("Jugadas Villanos:");

        usuariosInfo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        usuariosInfo.setOpaque(true);

        puntos.setOpaque(true);

        jugadasHeroes.setOpaque(true);

        jugadasVillanos.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(salirbtn)
                        .addGap(166, 166, 166))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(eliminarCuentabtn)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cambiarContrabtn)
                        .addGap(95, 95, 95))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jugadasVillanosLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugadasVillanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(puntosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuariosInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puntos, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jugadasHeroesLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugadasHeroes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addComponent(logs)
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuariosInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(puntosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(puntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jugadasHeroesLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugadasHeroes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jugadasVillanosLbl)
                            .addComponent(jugadasVillanos, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(logs)))
                .addGap(46, 46, 46)
                .addComponent(cambiarContrabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(eliminarCuentabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(salirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
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

    private void salirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirbtnActionPerformed
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_salirbtnActionPerformed

    private void cambiarContrabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarContrabtnActionPerformed
        CambiarContra m = new CambiarContra();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cambiarContrabtnActionPerformed

    private void eliminarCuentabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCuentabtnActionPerformed
        EliminarCuenta m = new EliminarCuenta();
        m.setVisible(true);
        this.dispose();

//        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar tu cuenta?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
//        if (confirm == JOptionPane.YES_OPTION) {
//            boolean eliminacionExitosa = loginUser.eliminarCuenta();
//            if (eliminacionExitosa) {
//                MenuInicio inicio = new MenuInicio();
//                inicio.setVisible(true);
//                this.dispose();
//            }
//        }
    }//GEN-LAST:event_eliminarCuentabtnActionPerformed

    private void logsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logsActionPerformed
        Logs logs = new Logs();
        logs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logsActionPerformed

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
                new MiInformacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiarContrabtn;
    private javax.swing.JButton eliminarCuentabtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jugadasHeroes;
    private javax.swing.JLabel jugadasHeroesLbl;
    private javax.swing.JLabel jugadasVillanos;
    private javax.swing.JLabel jugadasVillanosLbl;
    private javax.swing.JButton logs;
    private javax.swing.JLabel puntos;
    private javax.swing.JLabel puntosLabel;
    private javax.swing.JButton salirbtn;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JLabel usuariosInfo;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/resources/miInfo.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}