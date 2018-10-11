package com.softwaregeneral.business.poliza.client;

import com.softwaregeneral.business.poliza.domain.Cliente;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@FeignClient(value = "CLIENTESERVICES", fallback = ClienteServiceFallbackImpl.class)
public interface ClienteService {

    @RequestMapping(value="/clientes", method= RequestMethod.GET)
    List<Cliente> findAll(@RequestParam(name="email", required = false)String email);

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    Cliente findOne(@PathVariable(name="id")long id);
}
