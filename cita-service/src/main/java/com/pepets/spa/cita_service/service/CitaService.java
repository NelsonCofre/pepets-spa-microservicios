package com.pepets.spa.cita_service.service;

import com.pepets.spa.cita_service.dto.CitaDTO;

import java.time.LocalDate;
import java.util.List;

public interface CitaService {

    CitaDTO crearCita(CitaDTO dto);

    CitaDTO obtenerPorId(Long id);

    List<CitaDTO> listarPorCliente(Long clienteId);

    List<CitaDTO> listarPorMascota(Long mascotaId);

    List<CitaDTO> listarPorFecha(LocalDate fecha);

    List<CitaDTO> listarTodas();

    CitaDTO actualizarCita(Long id, CitaDTO dto);

    void eliminarCita(Long id);

    CitaDTO cambiarEstado(Long id, String nuevoEstado);
}
