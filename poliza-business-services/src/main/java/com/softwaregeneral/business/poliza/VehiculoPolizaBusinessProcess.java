package com.softwaregeneral.business.poliza;

import com.softwaregeneral.business.poliza.domain.Vehiculo;
import com.softwaregeneral.business.poliza.client.ClienteService;
import com.softwaregeneral.business.poliza.client.PolizaService;
import com.softwaregeneral.business.poliza.client.VehiculoService;
import com.softwaregeneral.business.poliza.domain.Cliente;
import com.softwaregeneral.business.poliza.domain.Poliza;
import com.softwaregeneral.business.poliza.domain.VehiculoPoliza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creado por Freddy Bendezu.
 */
@Service
public class VehiculoPolizaBusinessProcess {

    private ClienteService clienteService;
    private VehiculoService vehiculoService;
    private PolizaService polizaService;

    @Autowired
    public VehiculoPolizaBusinessProcess(ClienteService clienteService, VehiculoService vehiculoService, PolizaService polizaService) {
        this.clienteService = clienteService;
        this.vehiculoService = vehiculoService;
        this.polizaService = polizaService;
    }

    public List<VehiculoPoliza> getVehiculoPolizasPorFecha(String dateString){
        List<VehiculoPoliza> vehiculoPolizas = new ArrayList<>();
        Iterable<Poliza> polizas = this.polizaService.findAll(dateString);
        if(null!=polizas){
            polizas.forEach(poliza -> {
                Cliente cliente = this.clienteService.findOne(poliza.getClienteId());
                Vehiculo vehiculo = this.vehiculoService.findOne(poliza.getVehiculoId());
                if(null!= cliente) {
                    VehiculoPoliza vehiculoPoliza = new VehiculoPoliza();
                    vehiculoPoliza.setFecha(poliza.getFecha());
                    vehiculoPoliza.setNombre(cliente.getNombre());
                    vehiculoPoliza.setApellido(cliente.getApellido());
                    vehiculoPoliza.setVehiculoMarca(vehiculo.getMarca());
                    vehiculoPoliza.setVehiculoModelo(vehiculo.getModelo());
                    vehiculoPoliza.setClienteId(poliza.getClienteId());
                    vehiculoPoliza.setVehiculoId(poliza.getVehiculoId());
                    vehiculoPolizas.add(vehiculoPoliza);
                }

            });
        }

        return vehiculoPolizas;
    }
}
