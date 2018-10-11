package com.softwaregeneral.services.poliza;

import com.softwaregeneral.services.poliza.utils.DateTimeUtils;
import com.softwaregeneral.services.poliza.utils.PolizaTranslator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@RestController
@RequestMapping(value="/polizas")
@Api(value="polizas", description = "Operas con los datos de las poliza", tags=("polizas"))
public class PolizaController {

    @Autowired
    private PolizaRepository polizaRepository;

    @Autowired
    private DateTimeUtils dateTimeUtils;

    @Autowired
    private PolizaTranslator polizaTranslator;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Obtener todas las poliza", notes="Obtener todas las poliza del sistema", nickname="getPolizas")
    public List<Poliza> findAll(@RequestParam(name="fecha", required=false)String fecha){
        List<PolizaEntity> entities = null;
        if(StringUtils.isNotBlank(fecha)){
            entities = this.polizaRepository.findByFecha(this.dateTimeUtils.createDateFromDateString(fecha));
        }else{
            entities = (List<PolizaEntity>) this.polizaRepository.findAll();
        }
        List<Poliza> polizas = new ArrayList<>(entities.size());
        entities.forEach(entity->{
            polizas.add(this.polizaTranslator.translateEntityToPoliza(entity));
        });
        return polizas;
    }
}
