package com.softwaregeneral.services.poliza;

import javax.persistence.*;
import java.sql.Date;

/**
 * Creado por Freddy Bendezu.
 */
@Entity
@Table(name="POLIZA")
public class PolizaEntity {
    @Id
    @Column(name="POLIZA_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="VEHICULO_ID")
    private long vehiculoId;
    @Column(name="CLIENTE_ID")
    private long clienteId;
    @Column(name="FECHA")
    private Date fecha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(long vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
