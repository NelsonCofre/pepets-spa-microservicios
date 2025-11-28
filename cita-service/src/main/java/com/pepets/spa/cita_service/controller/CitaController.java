package com.pepets.spa.cita_service.controller;

import com.pepets.spa.cita_service.model.Cita;
import com.pepets.spa.cita_service.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public Cita crear(@RequestBody Cita c) {
        return citaService.crear(c);
    }

    @GetMapping("/{id}")
    public Cita obtener(@PathVariable Long id) {
        return citaService.obtener(id);
    }

    @GetMapping
    public List<Cita> listar() {
        return citaService.listar();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Cita> listarPorCliente(@PathVariable Long clienteId) {
        return citaService.listarPorCliente(clienteId);
    }

    @PutMapping("/{id}")
    public Cita actualizar(@PathVariable Long id, @RequestBody Cita c) {
        return citaService.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
    }
}
