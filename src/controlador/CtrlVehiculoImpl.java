/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.ModVehiculoIface;
import modelo.ModVehiculoImpl;
import parqueadero.java.Vehiculo;


/**
 *
 * @author Mao
 */
public class CtrlVehiculoImpl implements CtrlVehiculoIface {
    ModVehiculoIface modVehiculo;

    @Override
    public List<Vehiculo> listar() {
        List<Vehiculo> lista = new ArrayList();
        modVehiculo = new ModVehiculoImpl();
        lista = modVehiculo.consultarLista();
        return lista;        
    }

    @Override
    public Vehiculo consultar(int id) {
        modVehiculo = new ModVehiculoImpl();
        return modVehiculo.consultar(id);
    }
    
    @Override
    public Vehiculo ver(int id) {
        modVehiculo = new ModVehiculoImpl();
        return modVehiculo.ver(id);
    }

    @Override
    public Integer guardar(Vehiculo vehiculo) {
        modVehiculo = new ModVehiculoImpl();
        return modVehiculo.guardar(vehiculo);
    }

    @Override
    public Vehiculo editar(int id) {
        modVehiculo = new ModVehiculoImpl();
        return modVehiculo.consultar(id);
    }
    
    @Override
    public boolean modificar(Vehiculo vehiculo) {
        modVehiculo = new ModVehiculoImpl();
        return modVehiculo.modificar(vehiculo);
    }

    @Override
    public boolean borrar(int id) {
        modVehiculo = new ModVehiculoImpl();
        return modVehiculo.borrar(id);
    }
    

}
