/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import parqueadero.java.Vehiculo;

/**
 *
 * @author Mao
 */
public interface ModVehiculoIface {
    
    List<Vehiculo> consultarLista();
    
    Vehiculo consultar (int id);
    
    Vehiculo ver (int id);
    
    Integer guardar (Vehiculo vehiculo);
    
    boolean modificar(Vehiculo vehiculo);
    
    boolean borrar (int id);
    
}
