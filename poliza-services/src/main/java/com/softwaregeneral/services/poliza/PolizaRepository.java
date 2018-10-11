package com.softwaregeneral.services.poliza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@Repository
public interface PolizaRepository extends CrudRepository<PolizaEntity, Long> {
    List<PolizaEntity> findByFecha(Date fecha);
}
