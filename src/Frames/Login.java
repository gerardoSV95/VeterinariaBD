/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.ConexionDB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Gerardo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    
    ConexionDB conexion = null;
    public Login() {
        initComponents();      
        conexion = new ConexionDB();
        
          
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTF_Usuario = new RSMaterialComponent.RSTextFieldMaterial();
        JPF_Contrasena = new RSMaterialComponent.RSPasswordMaterial();
        jLabel6 = new javax.swing.JLabel();
        JLBL_Copyright1 = new javax.swing.JLabel();
        JLBL_Copyright2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Black.png"))); // NOI18N
        jPanel2.add(jLabel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        jLabel2.setFont(new java.awt.Font("Raleway", 0, 36)); // NOI18N
        jLabel2.setText("VetClinic");
        jPanel2.add(jLabel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        jLabel3.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel3.setText("Clinica Veterinaria S.A de C.V.");
        jPanel2.add(jLabel3);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 630));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Login/Icono_Usuario.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Login/Icono_Contrasena.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        JTF_Usuario.setForeground(new java.awt.Color(24, 23, 37));
        JTF_Usuario.setColorMaterial(new java.awt.Color(66, 63, 102));
        JTF_Usuario.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        JTF_Usuario.setPhColor(new java.awt.Color(102, 102, 102));
        JTF_Usuario.setPlaceholder("Ingrese su Usuario");
        JTF_Usuario.setSelectionColor(new java.awt.Color(66, 63, 102));
        JTF_Usuario.setVelMils(150);
        jPanel1.add(JTF_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        JPF_Contrasena.setForeground(new java.awt.Color(24, 23, 37));
        JPF_Contrasena.setColorMaterial(new java.awt.Color(66, 63, 102));
        JPF_Contrasena.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        JPF_Contrasena.setPhColor(new java.awt.Color(102, 102, 102));
        JPF_Contrasena.setPlaceholder("Ingrese su Contraseña");
        JPF_Contrasena.setSelectionColor(new java.awt.Color(66, 63, 102));
        JPF_Contrasena.setVelMils(150);
        jPanel1.add(JPF_Contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Raleway", 0, 36)); // NOI18N
        jLabel6.setText("INICIAR SESIÓN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        JLBL_Copyright1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLBL_Copyright1.setForeground(new java.awt.Color(24, 23, 37));
        JLBL_Copyright1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Copyright1.setText("Por favor, inicie sesión para utilizar ");
        jPanel1.add(JLBL_Copyright1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        JLBL_Copyright2.setBackground(new java.awt.Color(24, 23, 37));
        JLBL_Copyright2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        JLBL_Copyright2.setForeground(new java.awt.Color(24, 23, 37));
        JLBL_Copyright2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLBL_Copyright2.setText("la aplicación");
        jPanel1.add(JLBL_Copyright2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, -1, -1));

        jButton1.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jButton1.setText("INGRESAR");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            String consulta = " SELECT * FROM EMPLEADO WHERE USUARIO= '"+JTF_Usuario.getText()+"' AND CONTRASEÑA= '"+JPF_Contrasena.getText()+"'";//FR122011    
            PreparedStatement ps = conexion.conecta.prepareStatement(consulta);                                                                   //ABCD12            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(rootPane, "Acceso Correcto.");
                FPrincipal fP = new FPrincipal();
                fP.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no existe dentro de la base de datos");
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error en consulta");
        }
          
//          try {
//            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","usr_vet","VetPass");
//            String consulta = " SELECT * FROM EMPLEADO WHERE USUARIO= '"+JTF_Usuario.getText()+"' AND CONTRASEÑA= '"+JPF_Contrasena.getText()+"'";
//            PreparedStatement ps = conn.prepareStatement(consulta);
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                JOptionPane.showMessageDialog(null, "¡Acceso correcto!");
//                    FPrincipal fP = new FPrincipal();                    
//                    fP.setVisible(true);
//                    this.dispose();
//            }else{
//                JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto");
//            }
//        } catch (Exception e) {
//              System.out.println(e);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed
  
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel JLBL_Copyright1;
    public static javax.swing.JLabel JLBL_Copyright2;
    private RSMaterialComponent.RSPasswordMaterial JPF_Contrasena;
    private RSMaterialComponent.RSTextFieldMaterial JTF_Usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
