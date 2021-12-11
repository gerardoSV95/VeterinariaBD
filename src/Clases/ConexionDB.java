/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo
 */
public class ConexionDB {    
    
    public Connection conecta;
    public ConexionDB(){        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conecta = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","usr_vet","VetPass");               
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encuentra la Base de Datos");
            System.exit(0);
            
        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Falta libreria en Oracle SQL");
            System.exit(0);
            
        }
        
    } 	
}
