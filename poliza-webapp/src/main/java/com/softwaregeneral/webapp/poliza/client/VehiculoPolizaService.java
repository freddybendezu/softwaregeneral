package com.softwaregeneral.webapp.poliza.client;

import com.softwaregeneral.webapp.poliza.domain.Vehiculo;
import com.softwaregeneral.webapp.poliza.domain.VehiculoPoliza;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by frankmoley on 5/23/17.
 */
@FeignClient("POLIZABUSINESSSERVICES")
public interface VehiculoPolizaService {

    @RequestMapping(value = "/polizas", method = RequestMethod.GET)
    public List<Vehiculo> getAllPolizas(@RequestParam(name="fecha", required=false)String fecha);

    @RequestMapping(value="/vehiculoPolizas/{fecha}", method=RequestMethod.GET)
    public List<VehiculoPoliza> getVehiculoPolizasPorFecha(@PathVariable("fecha") String fecha);
}
