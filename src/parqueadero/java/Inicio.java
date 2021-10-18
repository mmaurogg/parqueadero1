/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mao
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //consulta(placa);
    }
    
    private static void consulta(String placa) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            //traemos el drive
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); //inicializar la conexión
            pstmt = conn.prepareStatement("SELECT placa, responsable,tipo, ingreso, salida, parqueaderos_id FROM vehiculos WHERE placa= " + placa );                                  //aca va la consulta SELECT (ejecuta la consulta)
            rs = pstmt.executeQuery();                                          //capturo valor de consulta
            while (rs.next()){                                                  //recorrer la consulta
                
            }                
        } catch  (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {            // cierro las conexiones
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
