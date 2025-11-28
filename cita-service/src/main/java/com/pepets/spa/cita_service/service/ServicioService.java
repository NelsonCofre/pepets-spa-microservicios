package com.pepets.spa.cita_service.service;

import com.pepets.spa.cita_service.model.Servicio;

import java.util.List;

public interface ServicioService {
    Servicio crear(Servicio s);

    Servicio obtener(Long id);

    List<Servicio> listar();

    Servicio actualizar(Long id, Servicio s);

    void eliminar(Long id);
}
