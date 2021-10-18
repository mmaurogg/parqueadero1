/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import parqueadero.java.Inicio;
import parqueadero.java.Vehiculo;

/**
 *
 * @author Mao
 */
public class ModVehiculoImpl implements ModVehiculoIface {

    @Override
    public List<Vehiculo> consultarLista() {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); 
            pstmt = conn.prepareStatement("select id, placa,responsable,tipo,ingreso,salida,id_parqueaderos from parqueadero.vehiculos" );
            rs = pstmt.executeQuery();                                          
            Vehiculo vehiculo;
            while (rs.next()){                                                  
                vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setResponsable(rs.getString("responsable"));
                vehiculo.setTipo(rs.getString("tipo"));
                vehiculo.setIngreso(rs.getDate("ingreso"));
                vehiculo.setSalida(rs.getDate("salida"));
                vehiculo.setParqueaderos_id(rs.getInt("id_parqueaderos"));
                listaVehiculos.add(vehiculo);
            }                
        } catch  (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaVehiculos;
    }

    @Override
    public Vehiculo consultar(int id) {
        Vehiculo vehiculo = null;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); 
            pstmt = conn.prepareStatement("select id, placa,responsable,tipo,ingreso,salida,id_parqueaderos from parqueadero.vehiculos WHERE Id = " + id );
            rs = pstmt.executeQuery();
            if (rs.next()){                                                  
                vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setResponsable(rs.getString("responsable"));
                vehiculo.setTipo(rs.getString("tipo"));
                vehiculo.setIngreso(rs.getDate("ingreso"));
                vehiculo.setSalida(rs.getDate("salida"));
                vehiculo.setParqueaderos_id(rs.getInt("id_parqueaderos"));
            }
                      
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return vehiculo;
    }

    @Override
    public Vehiculo ver(int id) {
        Vehiculo vehiculo = null;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); 
            pstmt = conn.prepareStatement("select id, placa,responsable,tipo,ingreso,salida,id_parqueaderos from parqueadero.vehiculos WHERE Id = " + id );
            rs = pstmt.executeQuery();
            if (rs.next()){                                                  
                vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setIngreso(rs.getDate("ingreso"));
                
            }
            
            Date ingreso = vehiculo.getIngreso();
            
            SimpleDateFormat dtf = new SimpleDateFormat("hh:mm:ss");            
            JOptionPane.showInternalMessageDialog(null , "La hora de ingreso fue: "+dtf.format(ingreso));
      
                      
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return vehiculo;
    }
    
    @Override
    public Integer guardar(Vehiculo vehiculo) {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); 

            String sql = "INSERT INTO parqueadero.vehiculos (placa, responsable, tipo, ingreso, id_parqueaderos) VALUES ('" + vehiculo.getPlaca() + "', '" + vehiculo.getResponsable() + "', '" + vehiculo.getTipo() + "', SYSDATE(), " + vehiculo.getParqueaderos_id() + " )";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.execute(); 
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }

    @Override
    public boolean modificar(Vehiculo vehiculo) {
        boolean modificado = false;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); 
            
            if (vehiculo.getSalida() != null ){
                JOptionPane.showInternalMessageDialog(null , "El vehiculo ya no se encuentra en el parqueadero");
                
            } else {            
            String sql = "UPDATE parqueadero.vehiculos SET salida = SYSDATE()WHERE id = " + vehiculo.getId();
            pstmt = conn.prepareStatement(sql);
            
            modificado = pstmt.execute(); 
            
            long valorPago = calcularValor(vehiculo.getId());
             JOptionPane.showInternalMessageDialog(null , "El valor a pagar es de: "+valorPago);
            
            }
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modificado;
        
    }

    @Override
    public boolean borrar(int id) {
        boolean borrado = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); 
            String sql = "DELETE FROM parqueadero.vehiculos WHERE id = " + id;
            pstmt = conn.prepareStatement( sql );
            borrado = pstmt.execute(); 
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return borrado;
        
    }
    
    private long calcularValor(int id){
       
        Vehiculo vehiculo = null;
        long cobro = 0; 
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/parqueadero","root","Dysson01"); 
            pstmt = conn.prepareStatement("select id, ingreso,salida FROM parqueadero.vehiculos WHERE Id = " + id );
            rs = pstmt.executeQuery();
            if (rs.next()){                                                  
                vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setIngreso(rs.getDate("ingreso"));
                vehiculo.setSalida(rs.getDate("salida"));
                }
            
        Date ingreso = vehiculo.getIngreso();
        Date salida = vehiculo.getSalida();
        
        long dif = salida.getTime() - ingreso.getTime();
        cobro = (dif*100)/60000;
                
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex){
            
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cobro;
        
    }

}
