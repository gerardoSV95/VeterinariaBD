/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.ConexionDB;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Gerardo
 */


public class getCliente extends ConexionDB{
    ConexionDB conexion = null;
    
    public Object [][] getClientes(){
        conexion = new ConexionDB();
        Object [][] cliente;
        int i=0;
        int cant=0;
        try {
            String sentencia = "SELECT (*) FROM DUENIO";
            PreparedStatement ps = conexion.conecta.prepareStatement(sentencia);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cant = rs.getInt(1);
            }
            cliente = new Object[cant][4];
            String consulta = "SELECT ID_CLIENTE, NOMBRE, APELLIDO_PAT, APELLIDO_MAT FROM DUENIO";
            ps = conexion.conecta.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                cliente[i][0] = (rs.getInt(1));
                cliente[i][1] = (rs.getString(2));
                cliente[i][2] = (rs.getString(3));
                i++;
            }
            return cliente;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+ e);
            return null;
        }                       
    }
}
