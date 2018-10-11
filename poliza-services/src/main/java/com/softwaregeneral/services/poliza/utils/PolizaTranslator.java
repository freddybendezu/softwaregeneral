package com.softwaregeneral.services.poliza.utils;

import com.softwaregeneral.services.poliza.Poliza;
import com.softwaregeneral.services.poliza.PolizaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Creado por Freddy Bendezu.
 */
@Component
public class PolizaTranslator {

    private final DateTimeUtils dateTimeUtils;

    @Autowired
    public PolizaTranslator(DateTimeUtils dateTimeUtils){
        super();
        this.dateTimeUtils = dateTimeUtils;
    }

    public Poliza translateEntityToPoliza(PolizaEntity polizaEntity){
        Poliza poliza = new Poliza();
        poliza.setId(polizaEntity.getId());
        poliza.setVehiculoId(polizaEntity.getVehiculoId());
        poliza.setClienteId(polizaEntity.getClienteId());
        poliza.setFecha(this.dateTimeUtils.createDateStringFromDate(polizaEntity.getFecha()));
        return poliza;
    }

    public PolizaEntity translatePolizaToEntity(Poliza poliza){
        PolizaEntity entity = new PolizaEntity();
        entity.setClienteId(poliza.getClienteId());
        entity.setId(poliza.getId());
        entity.setVehiculoId(poliza.getVehiculoId());
        entity.setFecha(new java.sql.Date(this.dateTimeUtils.createDateFromDateString(poliza.getFecha()).getTime()));
        return entity;
    }
}
