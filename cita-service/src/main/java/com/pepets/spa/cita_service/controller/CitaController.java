package com.pepets.spa.cita_service.controller;

import com.pepets.spa.cita_service.dto.CitaDTO;
import com.pepets.spa.cita_service.service.CitaService;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public CitaDTO crear(@RequestBody CitaDTO dto) {
        return citaService.crearCita(dto);
    }

    @GetMapping("/{id}")
    public CitaDTO obtener(@PathVariable Long id) {
        return citaService.obtenerPorId(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<CitaDTO> listarPorCliente(@PathVariable Long clienteId) {
        return citaService.listarPorCliente(clienteId);
    }

    @GetMapping("/mascota/{mascotaId}")
    public List<CitaDTO> listarPorMascota(@PathVariable Long mascotaId) {
        return citaService.listarPorMascota(mascotaId);
    }

    @GetMapping("/fecha")
    public List<CitaDTO> listarPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return citaService.listarPorFecha(fecha);
    }

    @GetMapping
    public List<CitaDTO> listarTodas() {
        return citaService.listarTodas();
    }

    @PutMapping("/{id}")
    public CitaDTO actualizar(@PathVariable Long id, @RequestBody CitaDTO dto) {
        return citaService.actualizarCita(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaService.eliminarCita(id);
    }

    @PatchMapping("/{id}/estado")
    public CitaDTO cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        return citaService.cambiarEstado(id, estado);
    }
}
