/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.java;

import java.util.Date;

public class Vehiculo {
    
    private int id;
    private String placa;
    private String responsable;
    private String tipo;
    private Date ingreso;
    private Date salida;
    private int parqueaderos_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }
    
    public int getParqueaderos_id() {
        return parqueaderos_id;
    }

    public void setParqueaderos_id(int parqueaderos_id) {
        this.parqueaderos_id = parqueaderos_id;
    }
            
}
