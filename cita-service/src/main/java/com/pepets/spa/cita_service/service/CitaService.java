package com.pepets.spa.cita_service.service;

import com.pepets.spa.cita_service.model.Cita;

import java.util.List;

public interface CitaService {
    Cita crear(Cita c);

    Cita obtener(Long id);

    List<Cita> listar();

    List<Cita> listarPorCliente(Long clienteId);

    Cita actualizar(Long id, Cita c);

    void eliminar(Long id);
}
