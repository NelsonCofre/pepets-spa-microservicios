package com.pepets.spa.cita_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Espera que mascota-service exponga: GET /api/mascotas/{id}
 */
@FeignClient(name = "mascota-service")
public interface MascotaClient {

    @GetMapping("/api/mascotas/{id}")
    Object obtenerMascotaPorId(@PathVariable Long id);
}
