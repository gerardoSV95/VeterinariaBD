/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gerardo
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    ConexionDB conexion = null;
    public Productos() {
        initComponents();
        conexion = new ConexionDB();
        Productos();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameIngresarProd = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        JPNL_Encabezado1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel_Footer1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rSLabelHora2 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextNameProd = new javax.swing.JTextField();
        jTextPz = new javax.swing.JTextField();
        jTextPrecio = new javax.swing.JTextField();
        jComboPresentacion = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        JPNL_Encabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBL_Productos = new rojerusan.RSTableMetro();
        jPanel_Footer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTexTotal = new javax.swing.JTextField();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha = new rojeru_san.rsdate.RSLabelFecha();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jFrameIngresarProd.setLocation(new java.awt.Point(400, 100));
        jFrameIngresarProd.setSize(new java.awt.Dimension(821, 658));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPNL_Encabezado1.setBackground(new java.awt.Color(236, 236, 236));

        jLabel4.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 23, 37));
        jLabel4.setText("INGRESAR PRODUCTO");

        javax.swing.GroupLayout JPNL_Encabezado1Layout = new javax.swing.GroupLayout(JPNL_Encabezado1);
        JPNL_Encabezado1.setLayout(JPNL_Encabezado1Layout);
        JPNL_Encabezado1Layout.setHorizontalGroup(
            JPNL_Encabezado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_Encabezado1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addContainerGap(680, Short.MAX_VALUE))
        );
        JPNL_Encabezado1Layout.setVerticalGroup(
            JPNL_Encabezado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.add(JPNL_Encabezado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 60));

        jPanel_Footer1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(109, 109, 109));
        jLabel9.setText("NO. EMPLEADO:");

        rSLabelHora2.setForeground(new java.awt.Color(109, 109, 109));
        rSLabelHora2.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        JLBL_Fecha1.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_Fecha1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        JLBL_Fecha1.setFormato("yyyy-MM-dd");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Reloj.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Calendario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_Footer1Layout = new javax.swing.GroupLayout(jPanel_Footer1);
        jPanel_Footer1.setLayout(jPanel_Footer1Layout);
        jPanel_Footer1Layout.setHorizontalGroup(
            jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Footer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelHora2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(JLBL_Fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(157, 157, 157)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(139, 139, 139))
        );
        jPanel_Footer1Layout.setVerticalGroup(
            jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Footer1Layout.createSequentialGroup()
                .addGroup(jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_Footer1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanel_Footer1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_Footer1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelHora2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLBL_Fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
        );

        jPanel2.add(jPanel_Footer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 800, 60));

        jLabel5.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel5.setText("Nombre del producto");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel12.setText("Piensas a ingresar");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel13.setText("Presentacion");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        jLabel14.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel14.setText("Precio");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        jTextNameProd.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jPanel2.add(jTextNameProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 190, -1));

        jTextPz.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jPanel2.add(jTextPz, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 190, -1));

        jTextPrecio.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jPanel2.add(jTextPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 190, -1));

        jComboPresentacion.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jComboPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PZ", "Kilogramo", "Litros" }));
        jPanel2.add(jComboPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 190, -1));

        jButton3.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jButton3.setText("Ingresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, -1, -1));

        jButton4.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, -1, -1));

        javax.swing.GroupLayout jFrameIngresarProdLayout = new javax.swing.GroupLayout(jFrameIngresarProd.getContentPane());
        jFrameIngresarProd.getContentPane().setLayout(jFrameIngresarProdLayout);
        jFrameIngresarProdLayout.setHorizontalGroup(
            jFrameIngresarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameIngresarProdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jFrameIngresarProdLayout.setVerticalGroup(
            jFrameIngresarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrameIngresarProdLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setSize(new java.awt.Dimension(920, 190));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPNL_Encabezado.setBackground(new java.awt.Color(236, 236, 236));

        jLabel3.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 23, 37));
        jLabel3.setText("PRODUCTOS");

        javax.swing.GroupLayout JPNL_EncabezadoLayout = new javax.swing.GroupLayout(JPNL_Encabezado);
        JPNL_Encabezado.setLayout(JPNL_EncabezadoLayout);
        JPNL_EncabezadoLayout.setHorizontalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_EncabezadoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addContainerGap(763, Short.MAX_VALUE))
        );
        JPNL_EncabezadoLayout.setVerticalGroup(
            JPNL_EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(JPNL_Encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 60));

        JTBL_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTO", "EXISTENCIA", "PRESENTACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane1.setViewportView(JTBL_Productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 920, 430));

        jPanel_Footer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(109, 109, 109));
        jLabel6.setText("NO. EMPLEADO:");

        jTexTotal.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jTexTotal.setForeground(new java.awt.Color(109, 109, 109));
        jTexTotal.setBorder(null);

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
                            .addComponent(jTexTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLBL_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
            .addGroup(jPanel_FooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 920, 60));

        jButton1.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jButton1.setText("Ingresar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, -1, -1));

        jButton2.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, -1, -1));

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
    private void Productos(){
        try {
            String consulta = "SELECT PRODUCTO,EXISTENCIA,PRESENTACION FROM PRODUCTO";
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
    private void ingresarProducto(){
        int Id_prod = 0;
        String nProd, existencia, presentacion, precio;
        nProd = jTextNameProd.getText();
        existencia = jTextPz.getText();
        presentacion = jComboPresentacion.getSelectedItem().toString();
        precio = jTextPrecio.getText();
        try {
            String consulta = "SELECT MAX(ID_PRODUCTO)+1 FROM PRODUCTO";
            PreparedStatement ps = conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Id_prod = rs.getInt(1);
            }
            consulta = "INSERT INTO PRODUCTO VALUES ('"+Id_prod+"','"+nProd+"','"+existencia+"','"+presentacion+"','"+precio+"')";
            ps =(PreparedStatement) conexion.conecta.prepareStatement(consulta);
            rs = ps.executeQuery();            
            JOptionPane.showMessageDialog(null, "Ingreso finalizado con exito!");
            jFrameIngresarProd.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
            
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ingresarProducto();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jFrameIngresarProd.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jFrameIngresarProd.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha1;
    private javax.swing.JPanel JPNL_Encabezado;
    private javax.swing.JPanel JPNL_Encabezado1;
    private rojerusan.RSTableMetro JTBL_Productos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboPresentacion;
    private javax.swing.JFrame jFrameIngresarProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Footer;
    private javax.swing.JPanel jPanel_Footer1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTexTotal;
    private javax.swing.JTextField jTextNameProd;
    private javax.swing.JTextField jTextPrecio;
    private javax.swing.JTextField jTextPz;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora2;
    // End of variables declaration//GEN-END:variables
}
