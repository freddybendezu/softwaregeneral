package com.softwaregeneral.service.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Creado por Freddy Bendezu.
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    Cliente findByEmail(String email);
}
