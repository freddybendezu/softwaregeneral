package com.softwaregeneral.services.vehiculo;

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
@RequestMapping(value="/vehiculos")
@Api(value="vehiculos", description = "Operaciones sobre los vehiculos", tags=("vehiculos"))
public class VehiculoController {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Mostrar todos los vehiculos", notes="Mostrar todos los vehiculos en el sistema", nickname="getVehiculos")
    public List<Vehiculo> findAll(@RequestParam(name="vehiculoNro", required = false)String vehiculoNro){
        if(StringUtils.isNotEmpty(vehiculoNro)){
            return Collections.singletonList(this.vehiculoRepository.findByVehiculoNro(vehiculoNro));
        }
        return (List<Vehiculo>) this.vehiculoRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Mostrar un vehiculo", notes="Mostrar un vehiculo por id", nickname = "getVehiculo")
    public Vehiculo findOne(@PathVariable("id")long id){
        return this.vehiculoRepository.findOne(id);
    }
}
