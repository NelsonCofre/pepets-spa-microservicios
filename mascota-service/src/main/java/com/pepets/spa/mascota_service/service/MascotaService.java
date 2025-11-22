package com.pepets.spa.mascota_service.service;

import com.pepets.spa.mascota_service.dto.MascotaDTO;

import java.util.List;

public interface MascotaService {

    MascotaDTO crearMascota(MascotaDTO mascotaDTO);

    MascotaDTO obtenerPorId(Long id);

    List<MascotaDTO> listarPorCliente(Long idCliente);

    List<MascotaDTO> listarMascotas();

    MascotaDTO actualizarMascota(Long id, MascotaDTO mascotaDTO);

    void eliminarMascota(Long id);
}
