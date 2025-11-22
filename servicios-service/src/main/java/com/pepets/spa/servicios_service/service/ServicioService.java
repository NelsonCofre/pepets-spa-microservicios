package com.pepets.spa.servicios_service.service;

import com.pepets.spa.servicios_service.dto.ServicioDTO;

import java.util.List;

public interface ServicioService {

    ServicioDTO crearServicio(ServicioDTO dto);

    List<ServicioDTO> listarServicios();

    ServicioDTO obtenerServicio(Long id);

    ServicioDTO actualizarServicio(Long id, ServicioDTO dto);

    void eliminarServicio(Long id);
}
