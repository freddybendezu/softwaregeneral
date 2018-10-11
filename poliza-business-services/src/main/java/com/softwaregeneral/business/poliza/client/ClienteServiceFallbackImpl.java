package com.softwaregeneral.business.poliza.client;

import com.softwaregeneral.business.poliza.domain.Cliente;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Creado por Freddy Bendezu.
 */
@Component
public class ClienteServiceFallbackImpl implements ClienteService {
    @Override
    public List<Cliente> findAll(String email) {
        return Collections.emptyList();
    }

    @Override
    public Cliente findOne(long id) {
        Cliente cliente = new Cliente();
        cliente.setNombre("Poliza");
        cliente.setApellido("Anonima");
        return cliente;
    }
}
