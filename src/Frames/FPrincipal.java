/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;
import javax.swing.*;
/**
 *
 * @author Gerardo
 */
public class FPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FPrincipal
     */
    public FPrincipal() {
        initComponents();
    }

    FPrincipal(String nombre, String usuario) {
        initComponents();
        jTextField3.setText(usuario);
        jLabel5.setText(nombre);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JBTN_QuitarProducto = new rojeru_san.RSButtonRiple();
        jPanel4 = new javax.swing.JPanel();
        JBTN_QuitarProducto1 = new rojeru_san.RSButtonRiple();
        jPanel9 = new javax.swing.JPanel();
        JBTN_QuitarProducto2 = new rojeru_san.RSButtonRiple();
        jPanel5 = new javax.swing.JPanel();
        JBTN_QuitarProducto3 = new rojeru_san.RSButtonRiple();
        jPanel6 = new javax.swing.JPanel();
        JBTN_QuitarProducto4 = new rojeru_san.RSButtonRiple();
        jPanel8 = new javax.swing.JPanel();
        JBTN_QuitarProducto5 = new rojeru_san.RSButtonRiple();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha = new rojeru_san.rsdate.RSLabelFecha();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Raleway", 0, 36)); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 350, 40));

        jPanel2.setBackground(new java.awt.Color(34, 41, 50));

        jPanel3.setBackground(new java.awt.Color(34, 41, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        JBTN_QuitarProducto.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_clinica/Icono_home.png"))); // NOI18N
        JBTN_QuitarProducto.setText("Inicio");
        JBTN_QuitarProducto.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto.setPreferredSize(new java.awt.Dimension(160, 40));
        JBTN_QuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(JBTN_QuitarProducto);

        jPanel4.setBackground(new java.awt.Color(34, 41, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        JBTN_QuitarProducto1.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/icono_venta.png"))); // NOI18N
        JBTN_QuitarProducto1.setText("Venta");
        JBTN_QuitarProducto1.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto1.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto1.setPreferredSize(new java.awt.Dimension(160, 40));
        JBTN_QuitarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProducto1ActionPerformed(evt);
            }
        });
        jPanel2.add(JBTN_QuitarProducto1);

        jPanel9.setBackground(new java.awt.Color(34, 41, 50));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel9);

        JBTN_QuitarProducto2.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/icono_Clinica.png"))); // NOI18N
        JBTN_QuitarProducto2.setText("Clinica");
        JBTN_QuitarProducto2.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto2.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto2.setPreferredSize(new java.awt.Dimension(160, 40));
        JBTN_QuitarProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProducto2ActionPerformed(evt);
            }
        });
        jPanel2.add(JBTN_QuitarProducto2);

        jPanel5.setBackground(new java.awt.Color(34, 41, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        JBTN_QuitarProducto3.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/icono_users.png"))); // NOI18N
        JBTN_QuitarProducto3.setText("Usuarios");
        JBTN_QuitarProducto3.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto3.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto3.setPreferredSize(new java.awt.Dimension(160, 40));
        JBTN_QuitarProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProducto3ActionPerformed(evt);
            }
        });
        jPanel2.add(JBTN_QuitarProducto3);

        jPanel6.setBackground(new java.awt.Color(34, 41, 50));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6);

        JBTN_QuitarProducto4.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/icono_almacen.png"))); // NOI18N
        JBTN_QuitarProducto4.setText("Almacen");
        JBTN_QuitarProducto4.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto4.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto4.setPreferredSize(new java.awt.Dimension(160, 40));
        JBTN_QuitarProducto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProducto4ActionPerformed(evt);
            }
        });
        jPanel2.add(JBTN_QuitarProducto4);

        jPanel8.setBackground(new java.awt.Color(34, 41, 50));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8);

        JBTN_QuitarProducto5.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_clinica/Icono_Exit.png"))); // NOI18N
        JBTN_QuitarProducto5.setText("Salir");
        JBTN_QuitarProducto5.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto5.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto5.setPreferredSize(new java.awt.Dimension(160, 40));
        JBTN_QuitarProducto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProducto5ActionPerformed(evt);
            }
        });
        jPanel2.add(JBTN_QuitarProducto5);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 680));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Black.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Raleway", 0, 36)); // NOI18N
        jLabel3.setText("VetClinic");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 160, 30));

        jLabel4.setFont(new java.awt.Font("Raleway", 0, 36)); // NOI18N
        jLabel4.setText("BIENVENIDO/A");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(109, 109, 109));
        jLabel6.setText("USUARIO");

        jTextField3.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(109, 109, 109));
        jTextField3.setToolTipText("");
        jTextField3.setBorder(null);

        rSLabelHora1.setForeground(new java.awt.Color(109, 109, 109));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        JLBL_Fecha.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_Fecha.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        JLBL_Fecha.setFormato("yyyy-MM-dd");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Reloj.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Calendario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBL_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 9, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JLBL_Fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 720, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTN_QuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProductoActionPerformed

    }//GEN-LAST:event_JBTN_QuitarProductoActionPerformed

    private void JBTN_QuitarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBTN_QuitarProducto1ActionPerformed

    private void JBTN_QuitarProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProducto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBTN_QuitarProducto2ActionPerformed

    private void JBTN_QuitarProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProducto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBTN_QuitarProducto3ActionPerformed

    private void JBTN_QuitarProducto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProducto4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBTN_QuitarProducto4ActionPerformed

    private void JBTN_QuitarProducto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProducto5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBTN_QuitarProducto5ActionPerformed

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
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto1;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto2;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto3;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto4;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto5;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField3;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    // End of variables declaration//GEN-END:variables

}
