package com.pepets.spa.mascota_service.service;

import com.pepets.spa.mascota_service.dto.MascotaDTO;

import java.util.List;

public interface MascotaService {
    MascotaDTO crearMascota(MascotaDTO dto);

    List<MascotaDTO> obtenerMascotasPorCliente(Long clienteId);

    MascotaDTO obtenerPorId(Long id);

    MascotaDTO actualizarMascota(Long id, MascotaDTO dto);

    void eliminarMascota(Long id);

    List<MascotaDTO> obtenerTodas();

}
