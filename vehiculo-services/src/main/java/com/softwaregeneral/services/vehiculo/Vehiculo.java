package com.softwaregeneral.services.vehiculo;

import javax.persistence.*;

/**
 * Creado por Freddy Bendezu.
 */
@Entity
@Table(name="VEHICULO")
public class Vehiculo {
    @Id
    @Column(name = "VEHICULO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "VEHICULO_NRO")
    private String vehiculoNro;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String modelo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVehiculoNumber() {
        return vehiculoNro;
    }

    public void setVehiculoNumber(String vehiculoNro) {
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
