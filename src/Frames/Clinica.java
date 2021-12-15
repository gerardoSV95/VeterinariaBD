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
import javax.swing.table.TableModel;
import java.util.Calendar;

/**
 *
 * @author Gerardo
 */

public class Clinica extends javax.swing.JFrame {
    /**
     * Creates new form Clinica
     */
    int ID_TMASCOTA, ID_TSERVICIO;
    String ID_VACUNA;
    ConexionDB conexion = null;
    public Clinica() {
        initComponents();
        conexion = new ConexionDB();
    }
    private void comboVacuna(){
        comboMascota();
        comboServicio();
         try {
            String consulta = "SELECT V_ID, VACUNA FROM VACUNA";
            PreparedStatement ps = (PreparedStatement)conexion.conecta.prepareStatement(consulta);
            ResultSet rs  = ps.executeQuery();
            jComboVacuna.addItem("- Seleccione vacuna -");
            while(rs.next()){
                jComboVacuna.addItem(rs.getString("VACUNA"));
                ID_VACUNA = rs.getString("V_ID");
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error en combo Vacuna"+e);
        }
    }
    private void comboMascota(){
        try {
            String consulta = "SELECT ID_TMASCOTA, TIPO_MASCOTA FROM MASCOTA";
            PreparedStatement ps = (PreparedStatement)conexion.conecta.prepareStatement(consulta);
            ResultSet rs  = ps.executeQuery();
            jComboTMascota.addItem("- Seleccione mascota -");
            while(rs.next()){
                jComboTMascota.addItem(rs.getString("TIPO_MASCOTA"));
                ID_TMASCOTA = rs.getInt("ID_TMASCOTA");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en combo Mascota "+e);
        }
    }
    private void comboServicio(){
        try {
            String consulta = "SELECT ID_TSERVICIO, TSERVICIO FROM TIPOSERVICIO";
            PreparedStatement ps = (PreparedStatement)conexion.conecta.prepareStatement(consulta);
            ResultSet rs  = ps.executeQuery();
            jComboTServicio.addItem("- Seleccione servicio -");
            while(rs.next()){
                jComboTServicio.addItem(rs.getString("TSERVICIO"));
                ID_TSERVICIO = rs.getInt("ID_TSERVICIO");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
    private void nuevoPaciente(){
        Object nPaciete[];
        String nombre,  diagnostico, medicina, vacuna, fEntrada, tMascota, tServicio ;
        int edad, ID=0, costo;
        
        fEntrada = JLBL_FechaIn.getFecha();
        nombre = jTextNombre.getText();
        edad = Integer.parseInt(jTextEdad.getText());
        diagnostico = jTextDiagnostico.getText();
        medicina = jTextMedicinas.getText();
        costo = Integer.parseInt(jTextCosto.getText());
        vacuna = jComboVacuna.getSelectedItem().toString();
        tMascota = jComboTMascota.getSelectedItem().toString();
        tServicio = jComboTServicio.getSelectedItem().toString();
        
        try {
            String consulta = "SELECT MAX (ID_PACIENTE)+1 FROM PACIENTE";
            PreparedStatement ps = (PreparedStatement)conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ID = rs.getInt(1);
            }
            String sentencia = "INSERT INTO PACIENTE VALUES ('"+ID+"','"+nombre+"','"+edad+"','"+ID_VACUNA+"','"+diagnostico+"','"+costo+"','"+medicina+"','"+ID_TMASCOTA+"','"+ID_TSERVICIO+"','"+ID+"')";
            PreparedStatement ps1 =(PreparedStatement)conexion.conecta.prepareStatement(sentencia);
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente ingresado con exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
            
    private void hPaciente(){
        jDialog1.setModal(true);
        jDialog1.setVisible(true);
        Object paciente[] ;        
        try {
            String id, nombre, edad, diagnostico, medicina, vacuna, dias_estancia, costo;
            paciente = new Object[8];
            String consulta =   "SELECT ID_PACIENTE, NOMBRE, EDAD, DIAGNOSTICO, MEDICINAS,  VACUNA, DIAS_ESTANCIA, COSTO FROM PACIENTE JOIN VACUNA ON  ID_VACUNA  = V_ID JOIN ESTANCIA ON P_ID_ESTANCIA = ID_ESTANCIA WHERE NOMBRE  = '"+jTextNombreP.getText()+"'";
            PreparedStatement ps =(PreparedStatement)conexion.conecta.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();            
            ArrayList<Object[]> data=new ArrayList<>();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Paciente encontrado");
                paciente[0] = rs.getInt(1);
                paciente[1] = rs.getString(2);
                paciente[2] = rs.getInt(3);
                paciente[3] = rs.getString(4);
                paciente[4] = rs.getString(5);
                paciente[5] = rs.getString(6);
                paciente[6] = rs.getInt(7);
                paciente[7] = rs.getInt(8);
                data.add(paciente);                                
                DefaultTableModel dtm = (DefaultTableModel)this.JTBL_historialP.getModel();                
                id =  paciente[0].toString();
                nombre =  paciente[1].toString();
                edad = paciente[2].toString();
                diagnostico = paciente[3].toString();
                medicina = paciente[4].toString();
                vacuna = paciente[5].toString();
                dias_estancia = paciente[6].toString();
                costo = paciente[7].toString();
                String fElementos[] = { nombre, edad, diagnostico, medicina, vacuna, dias_estancia, costo};
                dtm.addRow(fElementos);
            }else{
                JOptionPane.showMessageDialog(null, "El paciente no existe dentro de la base de datos");
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+ e);
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

        jDialog1 = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextNombreP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBL_historialP = new rojerusan.RSTableMetro();
        jButton2 = new javax.swing.JButton();
        jPanel_Footer = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rSLabelHora2 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFrameIngresarP = new javax.swing.JFrame();
        JPNL_Encabezado1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboVacuna = new javax.swing.JComboBox<>();
        jTextNombre = new javax.swing.JTextField();
        jTextEdad = new javax.swing.JTextField();
        jTextDiagnostico = new javax.swing.JTextField();
        jTextCosto = new javax.swing.JTextField();
        jTextMedicinas = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jComboTMascota = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jComboTServicio = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        JLBL_FechaIn = new rojeru_san.rsdate.RSLabelFecha();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel_Footer1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        rSLabelHora3 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha2 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JPNL_Encabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JPLN_Control = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JBTN_QuitarProducto = new rojeru_san.RSButtonRiple();
        jPanel5 = new javax.swing.JPanel();
        JBTN_BuscarP = new rojeru_san.RSButtonRiple();
        jPanel3 = new javax.swing.JPanel();
        JBTN_AddP = new rojeru_san.RSButtonRiple();
        jPanel4 = new javax.swing.JPanel();
        JBTN_QuitarProducto1 = new rojeru_san.RSButtonRiple();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        JLBL_Fecha = new rojeru_san.rsdate.RSLabelFecha();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jDialog1.setLocation(new java.awt.Point(400, 110));
        jDialog1.setModal(true);
        jDialog1.setSize(new java.awt.Dimension(724, 580));

        jLabel5.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel5.setText("HISTORIAL PACIENTES");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel12.setText("Nombre del paciente");

        jTextNombreP.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jTextNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombrePActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JTBL_historialP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "EDAD", "DIAGNOSTICO", "MEDICINAS", "VACUNA", "DIAS_ESTANCIA", "COSTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTBL_historialP.setAltoHead(30);
        JTBL_historialP.setColorBackgoundHead(new java.awt.Color(34, 41, 50));
        JTBL_historialP.setColorBordeFilas(new java.awt.Color(109, 109, 109));
        JTBL_historialP.setColorBordeHead(new java.awt.Color(255, 255, 255));
        JTBL_historialP.setColorFilasBackgound2(new java.awt.Color(230, 230, 230));
        JTBL_historialP.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        JTBL_historialP.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        JTBL_historialP.setColorSelBackgound(new java.awt.Color(54, 63, 73));
        JTBL_historialP.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        JTBL_historialP.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_historialP.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_historialP.setFuenteHead(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        JTBL_historialP.setGridColor(new java.awt.Color(255, 255, 255));
        JTBL_historialP.setGrosorBordeFilas(0);
        JTBL_historialP.setGrosorBordeHead(0);
        JTBL_historialP.setRowHeight(30);
        JTBL_historialP.setSelectionBackground(new java.awt.Color(66, 63, 102));
        JTBL_historialP.getTableHeader().setReorderingAllowed(false);
        JTBL_historialP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBL_historialPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTBL_historialP);

        jButton2.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jTextNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
        );

        jPanel_Footer.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel_FooterLayout = new javax.swing.GroupLayout(jPanel_Footer);
        jPanel_Footer.setLayout(jPanel_FooterLayout);
        jPanel_FooterLayout.setHorizontalGroup(
            jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(JLBL_Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_FooterLayout.setVerticalGroup(
            jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FooterLayout.createSequentialGroup()
                .addGroup(jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_FooterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanel_FooterLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_FooterLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelHora2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLBL_Fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_FooterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jFrameIngresarP.setLocation(new java.awt.Point(400, 100));
        jFrameIngresarP.setPreferredSize(new java.awt.Dimension(796, 460));
        jFrameIngresarP.setResizable(false);
        jFrameIngresarP.setSize(new java.awt.Dimension(724, 480));

        JPNL_Encabezado1.setBackground(new java.awt.Color(236, 236, 236));

        jLabel13.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(24, 23, 37));
        jLabel13.setText("Ingresar paciente");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel17.setText("Nombre");

        jLabel18.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel18.setText("Edad");

        jLabel19.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel19.setText("Diagnostico");

        jLabel20.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel20.setText("Costo");

        jLabel21.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel21.setText("Medicinas");

        jTextDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDiagnosticoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel22.setText("Vacuna");

        jLabel23.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel23.setText("Tipo mascota");

        jLabel24.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel24.setText("Tipo servicio");

        jLabel25.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        jLabel25.setText("Fecha de ingreso:");

        JLBL_FechaIn.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_FechaIn.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        JLBL_FechaIn.setFormato("yyyy-MM-dd");

        jButton3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jButton3.setText("Finalizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jTextNombre)
                    .addComponent(jTextCosto)
                    .addComponent(jTextDiagnostico)
                    .addComponent(jTextMedicinas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboVacuna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboTMascota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboTServicio, 0, 123, Short.MAX_VALUE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(JLBL_FechaIn, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))))
                .addGap(86, 86, 86))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboVacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jComboTMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jComboTServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jTextCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addComponent(JLBL_FechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextMedicinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPNL_Encabezado1Layout = new javax.swing.GroupLayout(JPNL_Encabezado1);
        JPNL_Encabezado1.setLayout(JPNL_Encabezado1Layout);
        JPNL_Encabezado1Layout.setHorizontalGroup(
            JPNL_Encabezado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_Encabezado1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPNL_Encabezado1Layout.setVerticalGroup(
            JPNL_Encabezado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNL_Encabezado1Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_Footer1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(109, 109, 109));
        jLabel14.setText("NO. EMPLEADO:");

        rSLabelHora3.setForeground(new java.awt.Color(109, 109, 109));
        rSLabelHora3.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        JLBL_Fecha2.setForeground(new java.awt.Color(109, 109, 109));
        JLBL_Fecha2.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        JLBL_Fecha2.setFormato("yyyy-MM-dd");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Reloj.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Calendario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_Footer1Layout = new javax.swing.GroupLayout(jPanel_Footer1);
        jPanel_Footer1.setLayout(jPanel_Footer1Layout);
        jPanel_Footer1Layout.setHorizontalGroup(
            jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Footer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelHora3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(JLBL_Fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(249, Short.MAX_VALUE))
        );
        jPanel_Footer1Layout.setVerticalGroup(
            jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_Footer1Layout.createSequentialGroup()
                .addGroup(jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_Footer1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(jPanel_Footer1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_Footer1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel_Footer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelHora3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLBL_Fecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Footer1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jFrameIngresarPLayout = new javax.swing.GroupLayout(jFrameIngresarP.getContentPane());
        jFrameIngresarP.getContentPane().setLayout(jFrameIngresarPLayout);
        jFrameIngresarPLayout.setHorizontalGroup(
            jFrameIngresarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNL_Encabezado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Footer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameIngresarPLayout.setVerticalGroup(
            jFrameIngresarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameIngresarPLayout.createSequentialGroup()
                .addComponent(JPNL_Encabezado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_Footer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPNL_Encabezado.setBackground(new java.awt.Color(236, 236, 236));

        jLabel3.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 23, 37));
        jLabel3.setText("Pacientes");

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

        JPLN_Control.setBackground(new java.awt.Color(34, 41, 50));

        jPanel2.setBackground(new java.awt.Color(34, 41, 50));

        jPanel8.setBackground(new java.awt.Color(34, 41, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        JPLN_Control.add(jPanel2);

        JBTN_QuitarProducto.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_clinica/Icono_home.png"))); // NOI18N
        JBTN_QuitarProducto.setText("Inicio");
        JBTN_QuitarProducto.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto.setPreferredSize(new java.awt.Dimension(230, 40));
        JBTN_QuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProductoActionPerformed(evt);
            }
        });
        JPLN_Control.add(JBTN_QuitarProducto);

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

        JPLN_Control.add(jPanel5);

        JBTN_BuscarP.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_BuscarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_Ventas/Icono_Buscar.png"))); // NOI18N
        JBTN_BuscarP.setText("Historial paciente");
        JBTN_BuscarP.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_BuscarP.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_BuscarP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_BuscarP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_BuscarP.setPreferredSize(new java.awt.Dimension(230, 40));
        JBTN_BuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_BuscarPActionPerformed(evt);
            }
        });
        JPLN_Control.add(JBTN_BuscarP);

        jPanel3.setBackground(new java.awt.Color(34, 41, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        JPLN_Control.add(jPanel3);

        JBTN_AddP.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_AddP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_clinica/icono_add.png"))); // NOI18N
        JBTN_AddP.setText("Ingresar paciente");
        JBTN_AddP.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_AddP.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_AddP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_AddP.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_AddP.setPreferredSize(new java.awt.Dimension(230, 40));
        JBTN_AddP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_AddPActionPerformed(evt);
            }
        });
        JPLN_Control.add(JBTN_AddP);

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

        JPLN_Control.add(jPanel4);

        JBTN_QuitarProducto1.setBackground(new java.awt.Color(34, 41, 50));
        JBTN_QuitarProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img_clinica/Icono_Exit.png"))); // NOI18N
        JBTN_QuitarProducto1.setText("Salir");
        JBTN_QuitarProducto1.setColorHover(new java.awt.Color(54, 63, 73));
        JBTN_QuitarProducto1.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        JBTN_QuitarProducto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JBTN_QuitarProducto1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        JBTN_QuitarProducto1.setPreferredSize(new java.awt.Dimension(230, 40));
        JBTN_QuitarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTN_QuitarProducto1ActionPerformed(evt);
            }
        });
        JPLN_Control.add(JBTN_QuitarProducto1);

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

        JPLN_Control.add(jPanel6);

        jPanel1.add(JPLN_Control, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 240, 540));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(109, 109, 109));
        jLabel6.setText("NO. EMPLEADO:");

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
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBL_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBL_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel7))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 920, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Black.png"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Raleway", 0, 36)); // NOI18N
        jLabel4.setText("VetClinic");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 160, 30));

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

    private void JBTN_BuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_BuscarPActionPerformed
        jDialog1.setModal(true);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_JBTN_BuscarPActionPerformed

    private void JBTN_AddPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_AddPActionPerformed
        comboVacuna();                
        jFrameIngresarP.setVisible(true);
    }//GEN-LAST:event_JBTN_AddPActionPerformed

    private void JBTN_QuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProductoActionPerformed

    }//GEN-LAST:event_JBTN_QuitarProductoActionPerformed

    private void JBTN_QuitarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTN_QuitarProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBTN_QuitarProducto1ActionPerformed

    private void JTBL_historialPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBL_historialPMouseClicked

    }//GEN-LAST:event_JTBL_historialPMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hPaciente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombrePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombrePActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jDialog1.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDiagnosticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDiagnosticoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        nuevoPaciente();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jFrameIngresarP.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Clinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clinica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple JBTN_AddP;
    private rojeru_san.RSButtonRiple JBTN_BuscarP;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto;
    private rojeru_san.RSButtonRiple JBTN_QuitarProducto1;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha1;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_Fecha2;
    public static rojeru_san.rsdate.RSLabelFecha JLBL_FechaIn;
    private javax.swing.JPanel JPLN_Control;
    private javax.swing.JPanel JPNL_Encabezado;
    private javax.swing.JPanel JPNL_Encabezado1;
    private rojerusan.RSTableMetro JTBL_historialP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboTMascota;
    private javax.swing.JComboBox<String> jComboTServicio;
    private javax.swing.JComboBox<String> jComboVacuna;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrameIngresarP;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Footer;
    private javax.swing.JPanel jPanel_Footer1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCosto;
    private javax.swing.JTextField jTextDiagnostico;
    private javax.swing.JTextField jTextEdad;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextMedicinas;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextNombreP;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora2;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora3;
    // End of variables declaration//GEN-END:variables
}
