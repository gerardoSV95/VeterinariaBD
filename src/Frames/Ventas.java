/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.ConexionDB;
import Clases.getCliente;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Gerardo
 */
public class Ventas extends javax.swing.JFrame {
    /**
     * Creates new form Ventas
     */
    DefaultTableModel dm;
    double total;
    double sub_total;
    double importe;
    int ID_cliente,ID_Ncliente, ID_TPAGO, ID_EMPELADO,ID_ESTADO;
    ConexionDB conexion = null;
    
    
    public Ventas() {
        initComponents();
        conexion = new ConexionDB();        
        total=0;
        sub_total = 0;
        importe = 0;
        productos();
        //llenadoTPago();
    }
    private void productos(){
        jTextCantidad.requestFocusInWindow();
        try {            
            String consulta = "SELECT PRODUCTO,EXISTENCIA,PRESENTACION,PRECIO FROM PRODUCTO";
            PreparedStatement ps = conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rms = rs.getMetaData();
            ArrayList<Object[]> data=new ArrayList<>();            
            while(rs.next()){                
                Object [] rows = new Object[rms.getColumnCount()];
                for(int i=0; i<rows.length;i++){
                    rows[i] = rs.getObject(i+1);
                }
                data.add(rows);
            }
            DefaultTableModel dtm = (DefaultTableModel)this.JTBL_Productos.getModel();
            for(int i=0;i<data.size();i++){
                dtm.addRow(data.get(i));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error en consulta");
        }
    }
    private void llenadoTPago(){                              
        try {            
            String consultaP = "SELECT ID_MPAGO, METODO FROM METODOPAGO ";
            PreparedStatement ps = (PreparedStatement)conexion.conecta.prepareStatement(consultaP);
            ResultSet rs = ps.executeQuery();    
            jComboTPago.addItem("-Seleccionar pago-");
            while(rs.next()){
                jComboTPago.addItem(rs.getString("METODO"));
                ID_TPAGO = rs.getInt("ID_MPAGO");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 404");
        }
    }
    private void llenadoEmpleado(){        
        try {
            String consulta = "SELECT ID_EMPLEADO,NOMBRE, APELLIDO_PAT FROM EMPLEADO";
            PreparedStatement ps = (PreparedStatement)conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            jComboEmpleado.addItem("-Seleccione un empelado-");
            while(rs.next()){
                jComboEmpleado.addItem(rs.getString("NOMBRE")+" "+ rs.getString("APELLIDO_PAT"));
                ID_EMPELADO = rs.getInt("ID_EMPLEADO");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void llenadoCliente(){        
        try {
            String consulta = "SELECT MAX(ID_CLIENTE)+1 FROM DUENIO";
            PreparedStatement ps = (PreparedStatement)conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ID_Ncliente = rs.getInt(1);
            }
            consulta = "SELECT ID_CLIENTE, NOMBRE, APELLIDO_PAT FROM DUENIO";
            ps = (PreparedStatement)conexion.conecta.prepareStatement(consulta);
            rs = ps.executeQuery();
            jComboCliente.addItem("-Seleccione un cliente-");
            while(rs.next()){
                jComboCliente.addItem(rs.getString("NOMBRE")+" "+rs.getString("APELLIDO_PAT"));
                ID_cliente = rs.getInt("ID_CLIENTE");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }          
    }
    private void comboEstado(){
        try {
            String consulta = "SELECT ID_ESTADO, ESTADO FROM ESTADO";
            PreparedStatement ps = conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            jComboEdo.addItem("- Selecciones un estado -");
            while(rs.next()){
                jComboEdo.addItem(rs.getString("ESTADO"));
                ID_ESTADO = rs.getInt("ID_ESTADO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    private void fVenta(){
        String fecha;
        int n_id=0;
        fecha = JLBL_FechaVP.getFecha();         
        try {
            String consulta = "SELECT MAX(ID_VENTA )+1 FROM VENTA";
            PreparedStatement ps = conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                n_id = rs.getInt(1);
            }
            consulta = "INSERT INTO VENTA VALUES ('"+n_id+"','"+fecha+"','"+ID_EMPELADO+"','"+ID_TPAGO+"','"+ID_cliente+"')";
            ps = conexion.conecta.prepareStatement(consulta);
            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Venta finalizada con exito!");
            jDialogFCompra.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
    private void nuevoCliente(){           
        String nombre, apellido1, apellido2, fechaR;        
        nombre = jTextRCnombre.getText();
        apellido1 = jTextFRCAP.getText();
        apellido2 = jTextFRCAM.getText();
        fechaR = JLBL_FechaRC.getFecha();
        
         try {            
            String consulta = "INSERT INTO DUENIO VALUES ('"+ID_Ncliente+"','"+nombre+"','"+apellido1+"','"+apellido2+"','"+fechaR+"','"+ID_ESTADO+"')";
            PreparedStatement ps =conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Registro finalizado con exito!");
            jDialogRCliente.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
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

        jDialogFCompra = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        JPNL_Encabezado1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelFooter = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTexTotal1 = new javax.swing.JTextField();
        rSLabelHora2 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboEmpleado = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboTPago = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonNCliente = new javax.swing.JButton();
        jComboCliente = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        JLBL_FechaVP = new rojeru_san.rsdate.RSLabelFecha();
        jDialogRCliente = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextRCnombre = new javax.swing.JTextField();
        jTextFRCAP = new javax.swing.JTextField();
        jTextFRCAM = new javax.swing.JTextField();
        JLBL_FechaRC = new rojeru_san.rsdate.RSLabelFecha();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextFRCcalle = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextFRCAlc = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jComboEdo = new javax.swing.JComboBox<>();
        jTextFRCNI = new javax.swing.JTextField();
        jTextFRCNE = new javax.swing.JTextField();
        jTextFRC_CP = new javax.swing.JTextField();
        jButtonFRCliente = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBL_Ventas = new rojerusan.RSTableMetro();
        jPanel_Footer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTexTotal = new javax.swing.JTextField();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha = new rojeru_san.rsdate.RSLabelFecha();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JPNL_Encabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JPLN_Control = new javax.swing.JPanel();
        JBTN_Buscar = new rojeru_san.RSButtonRiple();
        JBTN_CobrarVenta = new rojeru_san.RSButtonRiple();
        JBTN_QuitarProducto = new rojeru_san.RSButtonRiple();
        JBTN_Cancelar = new rojeru_san.RSButtonRiple();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTBL_Productos = new rojerusan.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jTextCantidad = new javax.swing.JTextField();

        jDialogFCompra.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogFCompra.setPreferredSize(new java.awt.Dimension(810, 600));
        jDialogFCompra.setSize(new java.awt.Dimension(810, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPNL_Encabezado1.setBackground(new java.awt.Color(236, 236, 236));

        jLabel4.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 23, 37));
        jLabel4.setText("VENTA DE PRODUCTOS");

        javax.swing.GroupLayout JPNL_Encabezado1Layout = new javax.swing.GroupLayout(JPNL_Encabezado1);
        JPNL_Encabezado1.setLayout(JPNL_Encabezado1Layout);
        JPNL_Encabezado1Layout.setHorizontalGroup(
            JPNL_Encabezado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_Encabezado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPNL_Encabezado1Layout.setVerticalGroup(
            JPNL_Encabezado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(JPNL_Encabezado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 60));

        jPanelFooter.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(109, 109, 109));
        jLabel9.setText("NO. EMPLEADO:");

        jTexTotal1.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jTexTotal1.setForeground(new java.awt.Color(109, 109, 109));
        jTexTotal1.setBorder(null);
        jTexTotal1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTexTotal1PropertyChange(evt);
            }
        });

        rSLabelHora2.setForeground(new java.awt.Color(109, 109, 109));
        rSLabelHora2.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        JLBL_Fecha1.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_Fecha1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        JLBL_Fecha1.setFormato("yyyy-MM-dd");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Reloj.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Calendario.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(109, 109, 109));
        jLabel5.setText("TOTAL: $");

        javax.swing.GroupLayout jPanelFooterLayout = new javax.swing.GroupLayout(jPanelFooter);
        jPanelFooter.setLayout(jPanelFooterLayout);
        jPanelFooterLayout.setHorizontalGroup(
            jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelHora2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(JLBL_Fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTexTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanelFooterLayout.setVerticalGroup(
            jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFooterLayout.createSequentialGroup()
                .addGroup(jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFooterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanelFooterLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFooterLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelHora2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLBL_Fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
            .addGroup(jPanelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTexTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.add(jPanelFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 790, 70));

        jLabel12.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel12.setText("Cliente");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel13.setText("Empleado");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jComboEmpleado.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jComboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(jComboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, 30));

        jLabel14.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel14.setText("Pago");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        jComboTPago.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jPanel2.add(jComboTPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 170, 30));

        jLabel15.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel15.setText("Fecha");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jButton1.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 140, 40));

        jButtonNCliente.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButtonNCliente.setText("Nuevo Cliente");
        jButtonNCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNClienteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 140, 40));

        jComboCliente.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jPanel2.add(jComboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 180, 30));

        jButton3.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jButton3.setText("FINALIZAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 140, 40));

        JLBL_FechaVP.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_FechaVP.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        JLBL_FechaVP.setFormato("dd-MM-YY");
        jPanel2.add(JLBL_FechaVP, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 110, 40));

        javax.swing.GroupLayout jDialogFCompraLayout = new javax.swing.GroupLayout(jDialogFCompra.getContentPane());
        jDialogFCompra.getContentPane().setLayout(jDialogFCompraLayout);
        jDialogFCompraLayout.setHorizontalGroup(
            jDialogFCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialogFCompraLayout.setVerticalGroup(
            jDialogFCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDialogRCliente.setBackground(new java.awt.Color(255, 255, 255));
        jDialogRCliente.setLocation(new java.awt.Point(400, 100));
        jDialogRCliente.setSize(new java.awt.Dimension(668, 491));

        jLabel16.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel16.setText("Nombre");

        jLabel17.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel17.setText("Apellido paterno");

        jLabel18.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel18.setText("Apellido materno");

        jTextFRCAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFRCAPActionPerformed(evt);
            }
        });

        JLBL_FechaRC.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_FechaRC.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        JLBL_FechaRC.setFormato("dd-MM-yy");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Calendario.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel25.setText("Fecha");

        jLabel19.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel19.setText("Calle");

        jLabel20.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel20.setText("Alcaldia");

        jLabel21.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel21.setText("Codigo postal");

        jLabel22.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel22.setText("No. Interior");

        jLabel23.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel23.setText("No. Exterior");

        jTextFRC_CP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFRC_CPActionPerformed(evt);
            }
        });

        jButtonFRCliente.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jButtonFRCliente.setText("Finalizar");
        jButtonFRCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFRClienteActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel26.setText("Estado");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel27.setText("Registrar Cliente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogRClienteLayout = new javax.swing.GroupLayout(jDialogRCliente.getContentPane());
        jDialogRCliente.getContentPane().setLayout(jDialogRClienteLayout);
        jDialogRClienteLayout.setHorizontalGroup(
            jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogRClienteLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jDialogRClienteLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(49, 49, 49)
                            .addComponent(jTextFRCcalle, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(jLabel20)
                            .addGap(30, 30, 30)
                            .addComponent(jTextFRCAlc))
                        .addGroup(jDialogRClienteLayout.createSequentialGroup()
                            .addGap(275, 275, 275)
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFRCNE)
                                .addComponent(jComboEdo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jDialogRClienteLayout.createSequentialGroup()
                            .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogRClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFRC_CP))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogRClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFRCNI, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32)
                            .addComponent(jLabel26)))
                    .addGroup(jDialogRClienteLayout.createSequentialGroup()
                        .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(21, 21, 21)
                        .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextRCnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jTextFRCAP)
                            .addComponent(jTextFRCAM))
                        .addGap(44, 44, 44)
                        .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jDialogRClienteLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JLBL_FechaRC, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDialogRClienteLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButtonFRCliente)
                        .addGap(64, 64, 64)
                        .addComponent(jButton5)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jDialogRClienteLayout.setVerticalGroup(
            jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRClienteLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogRClienteLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(JLBL_FechaRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogRClienteLayout.createSequentialGroup()
                        .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogRClienteLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jTextRCnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogRClienteLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(5, 5, 5)))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextFRCAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextFRCAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFRCcalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFRCAlc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFRCNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFRCNE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFRC_CP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboEdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(32, 32, 32)
                .addGroup(jDialogRClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFRCliente)
                    .addComponent(jButton5))
                .addGap(73, 73, 73))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTBL_Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTO", "PRESENTACION", "CANTIDAD", "PRECIO UNITARIO", "IMPORTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_Ventas.setAltoHead(30);
        JTBL_Ventas.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_Ventas.setColorBordeFilas(new java.awt.Color(109, 109, 109));
        JTBL_Ventas.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_Ventas.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_Ventas.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_Ventas.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_Ventas.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_Ventas.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_Ventas.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Ventas.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Ventas.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Ventas.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_Ventas.setGrosorBordeFilas(0);
        JTBL_Ventas.setGrosorBordeHead(0);
        JTBL_Ventas.setRowHeight(30);
        JTBL_Ventas.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_Ventas.getTableHeader().setReorderingAllowed(false);
        JTBL_Ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_VentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTBL_Ventas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 920, 220));

        jPanel_Footer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(109, 109, 109));
        jLabel6.setText("NO. EMPLEADO:");

        jTexTotal.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jTexTotal.setForeground(new java.awt.Color(109, 109, 109));
        jTexTotal.setBorder(null);
        jTexTotal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTexTotalPropertyChange(evt);
            }
        });

        rSLabelHora1.setForeground(new java.awt.Color(109, 109, 109));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        JLBL_Fecha.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_Fecha.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        JLBL_Fecha.setFormato("yyyy-MM-dd");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Reloj.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Calendario.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(109, 109, 109));
        jLabel1.setText("TOTAL: $");

        javax.swing.GroupLayout jPanel_FooterLayout = new javax.swing.GroupLayout(jPanel_Footer);
        jPanel_Footer.setLayout(jPanel_FooterLayout);
        jPanel_FooterLayout.setHorizontalGroup(
            jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(JLBL_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(99, 99, 99)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTexTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel_FooterLayout.setVerticalGroup(
            jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FooterLayout.createSequentialGroup()
                .addGroup(jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_FooterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(jPanel_FooterLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_FooterLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelHora1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTexTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JLBL_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
        );

        jPanel1.add(jPanel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 920, 60));

        JPNL_Encabezado.setBackground(new java.awt.Color(236, 236, 236));

        jLabel3.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 23, 37));
        jLabel3.setText("VENTA DE PRODUCTOS");

        javax.swing.GroupLayout JPNL_EncabezadoLayout = new javax.swing.GroupLayout(JPNL_Encabezado);
        JPNL_Encabezado.setLayout(JPNL_EncabezadoLayout);
        JPNL_EncabezadoLayout.setHorizontalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_EncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPNL_EncabezadoLayout.setVerticalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel1.add(JPNL_Encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));

        JPLN_Control.setBackground(new java.awt.Color(255, 255, 255));

        JBTN_Buscar.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Buscar.png"))); // NOI18N
        JBTN_Buscar.setText("Agregar Producto");
        JBTN_Buscar.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_Buscar.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_Buscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Buscar.setMinimumSize(new java.awt.Dimension(219, 29));
        JBTN_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_BuscarActionPerformed(evt);
            }
        });

        JBTN_CobrarVenta.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_CobrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Caja.png"))); // NOI18N
        JBTN_CobrarVenta.setText("Cobrar venta");
        JBTN_CobrarVenta.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_CobrarVenta.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_CobrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_CobrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CobrarVentaActionPerformed(evt);
            }
        });

        JBTN_QuitarProducto.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Eliminar.png"))); // NOI18N
        JBTN_QuitarProducto.setText("Quitar producto");
        JBTN_QuitarProducto.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProductoActionPerformed(evt);
            }
        });

        JBTN_Cancelar.setBackground(new java.awt.Color(255, 68, 68));
        JBTN_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Cancelar.png"))); // NOI18N
        JBTN_Cancelar.setText("Cancelar Venta");
        JBTN_Cancelar.setColorHover(new java.awt.Color(255, 100, 100));
        JBTN_Cancelar.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_Cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPLN_ControlLayout = new javax.swing.GroupLayout(JPLN_Control);
        JPLN_Control.setLayout(JPLN_ControlLayout);
        JPLN_ControlLayout.setHorizontalGroup(
            JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLN_ControlLayout.createSequentialGroup()
                .addComponent(JBTN_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_CobrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_QuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        JPLN_ControlLayout.setVerticalGroup(
            JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLN_ControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPLN_ControlLayout.createSequentialGroup()
                        .addGroup(JPLN_ControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBTN_QuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBTN_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBTN_CobrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JBTN_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(JPLN_Control, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 890, -1));

        JTBL_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTO", "EXISTENCIA", "PRESENTACION", "COSTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_Productos.setAltoHead(30);
        JTBL_Productos.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_Productos.setColorBordeFilas(new java.awt.Color(109, 109, 109));
        JTBL_Productos.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_Productos.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_Productos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_Productos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_Productos.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_Productos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_Productos.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Productos.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Productos.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_Productos.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_Productos.setGrosorBordeFilas(0);
        JTBL_Productos.setGrosorBordeHead(0);
        JTBL_Productos.setRowHeight(30);
        JTBL_Productos.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_Productos.getTableHeader().setReorderingAllowed(false);
        JTBL_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_ProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTBL_Productos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 920, 190));

        jLabel2.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel2.setText("CANTIDAD");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, -1));

        jTextCantidad.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jTextCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadActionPerformed(evt);
            }
        });
        jTextCantidad.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextCantidadPropertyChange(evt);
            }
        });
        jPanel1.add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTBL_VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_VentasMouseClicked

    }//GEN-LAST:event_JTBL_VentasMouseClicked

    private void JTBL_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_ProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JTBL_ProductosMouseClicked

    private void jTexTotalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTexTotalPropertyChange
        // TODO add your handling code here:
        jTexTotal.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }//GEN-LAST:event_jTexTotalPropertyChange

    private void jTextCantidadPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextCantidadPropertyChange
        jTextCantidad.setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }//GEN-LAST:event_jTextCantidadPropertyChange

    private void jTexTotal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTexTotal1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexTotal1PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialogFCompra.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadoActionPerformed

    }//GEN-LAST:event_jComboEmpleadoActionPerformed

    private void JBTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CancelarActionPerformed
        int res;
        res = JOptionPane.showConfirmDialog(null, "¿Estas seguro de cancelar la compra?","Advertencia",JOptionPane.WARNING_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            FPrincipal fp = new FPrincipal();
            fp.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_JBTN_CancelarActionPerformed

    private void JBTN_QuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProductoActionPerformed
        double x=0.0,importe,pfinal;
        int fsel,resp;
        try {
            fsel = JTBL_Ventas.getSelectedRow();
            if(fsel==-1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un producto para poder eliminarlo.","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else{
                resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar el producto?","Eliminar",JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
                    importe = Double.parseDouble(JTBL_Ventas.getValueAt(fsel, 4).toString());
                    pfinal = Double.parseDouble(jTexTotal.getText())- importe;
                    total = pfinal;
                    jTexTotal.setText(""+total);
                    dm = (DefaultTableModel)JTBL_Ventas.getModel();
                    dm.removeRow(fsel);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_JBTN_QuitarProductoActionPerformed

    private void JBTN_CobrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_CobrarVentaActionPerformed
        jTexTotal.setText(""+total);
        llenadoTPago();
        llenadoEmpleado();
        llenadoCliente();
        jDialogFCompra.setModal(true);
        jDialogFCompra.setVisible(true);
    }//GEN-LAST:event_JBTN_CobrarVentaActionPerformed

    private void JBTN_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_BuscarActionPerformed
        int fsel = JTBL_Productos.getSelectedRow();
        try {
            String producto, presentacion, precio, cantidad, importe;
            double calcula=0.0, x=0.0, iva= 0.0;
            int canti=0;
            if(fsel==-1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un producto","Advertencia",JOptionPane.WARNING_MESSAGE);
            }else{
                dm = (DefaultTableModel) JTBL_Productos.getModel();
                producto = JTBL_Productos.getValueAt(fsel, 0).toString();
                presentacion = JTBL_Productos.getValueAt(fsel, 2).toString();
                precio = JTBL_Productos.getValueAt(fsel, 3).toString();
                cantidad = jTextCantidad.getText();

                x = (Double.parseDouble(precio) * Integer.parseInt(cantidad));
                importe = String.valueOf(x);

                dm = (DefaultTableModel) JTBL_Ventas.getModel();
                String fElementos[] = {producto, presentacion, cantidad, precio, importe};
                dm.addRow(fElementos);

                calcula = (Double.parseDouble(precio)*Integer.parseInt(jTextCantidad.getText()));
                total = total+calcula;
            }                      
        } catch (Exception e) {

        }
    }//GEN-LAST:event_JBTN_BuscarActionPerformed

    private void jTextFRC_CPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFRC_CPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFRC_CPActionPerformed

    private void jButtonNClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNClienteActionPerformed
        comboEstado();        
        jDialogRCliente.setModal(true);
        jDialogRCliente.setVisible(true);
    }//GEN-LAST:event_jButtonNClienteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fVenta();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFRCAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFRCAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFRCAPActionPerformed

    private void jTextCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadActionPerformed
        
    }//GEN-LAST:event_jTextCantidadActionPerformed

    private void jButtonFRClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFRClienteActionPerformed
        nuevoCliente();
    }//GEN-LAST:event_jButtonFRClienteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jDialogRCliente.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_Buscar;
    private rojeru_san.RSButtonRiple JBTN_Cancelar;
    private rojeru_san.RSButtonRiple JBTN_CobrarVenta;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha1;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_FechaRC;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_FechaVP;
    private javax.swing.JPanel JPLN_Control;
    private javax.swing.JPanel JPNL_Encabezado;
    private javax.swing.JPanel JPNL_Encabezado1;
    private rojerusan.RSTableMetro JTBL_Productos;
    private rojerusan.RSTableMetro JTBL_Ventas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonFRCliente;
    private javax.swing.JButton jButtonNCliente;
    private javax.swing.JComboBox<String> jComboCliente;
    private javax.swing.JComboBox<String> jComboEdo;
    private javax.swing.JComboBox<String> jComboEmpleado;
    private javax.swing.JComboBox<String> jComboTPago;
    private javax.swing.JDialog jDialogFCompra;
    private javax.swing.JDialog jDialogRCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanel_Footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTexTotal;
    private javax.swing.JTextField jTexTotal1;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextFRCAM;
    private javax.swing.JTextField jTextFRCAP;
    private javax.swing.JTextField jTextFRCAlc;
    private javax.swing.JTextField jTextFRCNE;
    private javax.swing.JTextField jTextFRCNI;
    private javax.swing.JTextField jTextFRC_CP;
    private javax.swing.JTextField jTextFRCcalle;
    private javax.swing.JTextField jTextRCnombre;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora2;
    // End of variables declaration//GEN-END:variables
}
