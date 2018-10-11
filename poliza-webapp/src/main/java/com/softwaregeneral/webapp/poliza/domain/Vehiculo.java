package com.softwaregeneral.webapp.poliza.domain;

/**
 * Created by frankmoley on 5/23/17.
 */
public class Vehiculo {
    private long id;
    private String vehiculoNro;
    private String marca;
    private String modelo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVehiculoNro() {
        return vehiculoNro;
    }

    public void setVehiculoNro(String vehiculoNro) {
        this.vehiculoNro = vehiculoNro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
