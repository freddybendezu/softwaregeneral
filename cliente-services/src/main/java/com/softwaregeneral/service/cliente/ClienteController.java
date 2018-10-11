package com.softwaregeneral.service.cliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@RestController
@RequestMapping(value="/clientes")
@Api(value="clientes", description = "Operaciones con los datos del cliente", tags=("clientes"))
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(method= RequestMethod.GET)
    @ApiOperation(value="Todos los clientes", notes="Todos los clientes del sistema", nickname="getClientes")
    public List<Cliente> findAll(@RequestParam(name="email", required = false)String email){
        if(StringUtils.isNotBlank(email)){
            return Collections.singletonList(this.clienteRepository.findByEmail(email));
        }
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cliente findOne(@PathVariable(name="id")long id){
        return this.clienteRepository.findOne(id);
    }
}
