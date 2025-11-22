package com.pepets.spa.mascota_service.controller;

import com.pepets.spa.mascota_service.dto.MascotaDTO;
import com.pepets.spa.mascota_service.service.MascotaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    @PostMapping
    public MascotaDTO crear(@RequestBody MascotaDTO dto) {
        return mascotaService.crearMascota(dto);
    }

    @GetMapping("/{id}")
    public MascotaDTO obtener(@PathVariable Long id) {
        return mascotaService.obtenerPorId(id);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<MascotaDTO> listarPorCliente(@PathVariable Long idCliente) {
        return mascotaService.listarPorCliente(idCliente);
    }

    @GetMapping
    public List<MascotaDTO> listar() {
        return mascotaService.listarMascotas();
    }

    @PutMapping("/{id}")
    public MascotaDTO actualizar(@PathVariable Long id, @RequestBody MascotaDTO dto) {
        return mascotaService.actualizarMascota(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
    }
}
