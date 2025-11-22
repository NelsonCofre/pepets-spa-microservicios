package com.pepets.spa.cita_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Espera que servicios-service exponga: GET /servicios/{id}
 */
@FeignClient(name = "servicios-service")
public interface ServicioClient {

    @GetMapping("/servicios/{id}")
    Object obtenerServicioPorId(@PathVariable Long id);
}
