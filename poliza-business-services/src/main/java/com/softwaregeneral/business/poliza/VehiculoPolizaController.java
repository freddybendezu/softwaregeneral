package com.softwaregeneral.business.poliza;

import com.softwaregeneral.business.poliza.client.PolizaService;
import com.softwaregeneral.business.poliza.domain.Poliza;
import com.softwaregeneral.business.poliza.domain.Vehiculo;
import com.softwaregeneral.business.poliza.client.VehiculoService;
import com.softwaregeneral.business.poliza.domain.VehiculoPoliza;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@RestController
@Api(value="vehiculoPolizas", description = "Proceso de negocio para contratar una poliza", tags=("vehiculoPolizas"))
public class VehiculoPolizaController {
    @Autowired
    private PolizaService polizaService;

    @Autowired
    private VehiculoPolizaBusinessProcess businessProcess;

    @RequestMapping(value = "/polizas", method = RequestMethod.GET)
    @ApiOperation(value="Mostrar todas las polizas", notes="Mostrar todos las polizas del sistema", nickname="getPolizas")
    public List<Poliza> getAllPolizas(@RequestParam(name="fecha", required=false)String fecha){
        return this.polizaService.findAll(fecha);
    }

    @RequestMapping(value="/vehiculoPolizas/{fecha}", method=RequestMethod.GET)
    @ApiOperation(value="Mostrar vehiculos con poliza", notes="muestra toda las poliza por fecha", nickname="getPolizasPorFecha")
    public List<VehiculoPoliza> getPolizasPorFecha(@PathVariable("fecha") String fecha){
        return this.businessProcess.getVehiculoPolizasPorFecha(fecha);
    }

}
