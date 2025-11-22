package com.pepets.spa.servicios_service.controller;

import com.pepets.spa.servicios_service.dto.ServicioDTO;
import com.pepets.spa.servicios_service.service.ServicioService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService servicioService;

    @PostMapping
    public ServicioDTO crear(@RequestBody ServicioDTO dto) {
        return servicioService.crearServicio(dto);
    }

    @GetMapping
    public List<ServicioDTO> listar() {
        return servicioService.listarServicios();
    }

    @GetMapping("/{id}")
    public ServicioDTO obtener(@PathVariable Long id) {
        return servicioService.obtenerServicio(id);
    }

    @PutMapping("/{id}")
    public ServicioDTO actualizar(@PathVariable Long id, @RequestBody ServicioDTO dto) {
        return servicioService.actualizarServicio(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}
