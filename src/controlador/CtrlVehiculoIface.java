/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import parqueadero.java.Vehiculo;

/**
 *
 * @author Mao
 */
public interface CtrlVehiculoIface {
    
    List<Vehiculo> listar();
    
    Vehiculo consultar (int id);
    
    Vehiculo ver (int id);
    
    Integer guardar (Vehiculo vehiculo);
    
    Vehiculo editar (int id);
    
    boolean modificar (Vehiculo vehiculo);
    
    boolean borrar (int id);
    
}
