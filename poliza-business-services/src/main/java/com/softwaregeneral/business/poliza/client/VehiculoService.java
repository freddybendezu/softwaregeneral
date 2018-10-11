package com.softwaregeneral.business.poliza.client;

import com.softwaregeneral.business.poliza.domain.Vehiculo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@FeignClient(value="VEHICULOSERVICES")
public interface VehiculoService {

    @RequestMapping(value="/vehiculos", method= RequestMethod.GET)
    List<Vehiculo> findAll(@RequestParam(name="vehiculoNro", required=false)String vehiculoNro);

    @RequestMapping(value="/vehiculos/{id}", method = RequestMethod.GET)
    Vehiculo findOne(@PathVariable("id")long id);
}
