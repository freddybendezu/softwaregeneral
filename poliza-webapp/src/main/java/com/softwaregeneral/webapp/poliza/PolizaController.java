package com.softwaregeneral.webapp.poliza;

import com.softwaregeneral.webapp.poliza.client.VehiculoPolizaService;
import com.softwaregeneral.webapp.poliza.domain.VehiculoPoliza;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(value="/polizas")
public class PolizaController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final VehiculoPolizaService vehiculoPolizaService;


    @Autowired
    public PolizaController(VehiculoPolizaService vehiculoPolizaService){
        super();
        this.vehiculoPolizaService = vehiculoPolizaService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getPolizas(@RequestParam(value="fecha", required=false)String fechaString, Model model){
        String fecha = fechaString;
        if(StringUtils.isBlank(fechaString)){
            fecha = this.createTodayDateString();
        }
        List<VehiculoPoliza> vehiculoPolizas = this.vehiculoPolizaService.getVehiculoPolizasPorFecha(fecha);
        model.addAttribute("vehiculoPolizas", vehiculoPolizas);
        return "polizas";
    }

    public String createTodayDateString(){
        return DATE_FORMAT.format(new Date());
    }
}