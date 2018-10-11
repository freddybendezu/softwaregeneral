package com.softwaregeneral.business.poliza.client;

import com.softwaregeneral.business.poliza.domain.Poliza;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@FeignClient("POLIZASERVICES")
public interface PolizaService {
    @RequestMapping(value = "/polizas", method = RequestMethod.GET)
    List<Poliza> findAll(@RequestParam(name = "fecha", required = false) String fecha);
}