package com.softwaregeneral.services.vehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Creado por Freddy Bendezu.
 */
@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long>{
    Vehiculo findByVehiculoNro(String vehiculoNro);
}
