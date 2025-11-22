package com.pepets.spa.cita_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Espera que cliente-service exponga: GET /api/clientes/{id}
 * Puedes adaptar la ruta si tu cliente-service la expone distinta.
 */
@FeignClient(name = "cliente-service")
public interface ClienteClient {

    @GetMapping("/api/clientes/{id}")
    Object obtenerClientePorId(@PathVariable Long id);
}
