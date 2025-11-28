package com.pepets.spa.cita_service.controller;

import com.pepets.spa.cita_service.model.Servicio;
import com.pepets.spa.cita_service.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService servicioService;

    @PostMapping
    public Servicio crear(@RequestBody Servicio s) {
        return servicioService.crear(s);
    }

    @GetMapping("/{id}")
    public Servicio obtener(@PathVariable Long id) {
        return servicioService.obtener(id);
    }

    @GetMapping
    public List<Servicio> listar() {
        return servicioService.listar();
    }

    @PutMapping("/{id}")
    public Servicio actualizar(@PathVariable Long id, @RequestBody Servicio s) {
        return servicioService.actualizar(id, s);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioService.eliminar(id);
    }
}
