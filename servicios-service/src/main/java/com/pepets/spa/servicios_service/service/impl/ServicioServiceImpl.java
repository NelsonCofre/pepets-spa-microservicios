package com.pepets.spa.servicios_service.service.impl;

import com.pepets.spa.servicios_service.dto.ServicioDTO;
import com.pepets.spa.servicios_service.model.Servicio;
import com.pepets.spa.servicios_service.repository.ServicioRepository;
import com.pepets.spa.servicios_service.service.ServicioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    @Override
    public ServicioDTO crearServicio(ServicioDTO dto) {
        Servicio servicio = Servicio.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .descripcion(dto.getDescripcion())
                .build();

        Servicio guardado = servicioRepository.save(servicio);

        return mapToDTO(guardado);
    }

    @Override
    public List<ServicioDTO> listarServicios() {
        return servicioRepository.findAll()
                .stream().map(this::mapToDTO).toList();
    }

    @Override
    public ServicioDTO obtenerServicio(Long id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElse(null);

        if (servicio == null)
            return null;

        return mapToDTO(servicio);
    }

    @Override
    public ServicioDTO actualizarServicio(Long id, ServicioDTO dto) {
        Servicio servicio = servicioRepository.findById(id)
                .orElse(null);

        if (servicio == null)
            return null;

        servicio.setNombre(dto.getNombre());
        servicio.setPrecio(dto.getPrecio());
        servicio.setDescripcion(dto.getDescripcion());

        Servicio actualizado = servicioRepository.save(servicio);

        return mapToDTO(actualizado);
    }

    @Override
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }

    private ServicioDTO mapToDTO(Servicio servicio) {
        return ServicioDTO.builder()
                .id(servicio.getId())
                .nombre(servicio.getNombre())
                .precio(servicio.getPrecio())
                .descripcion(servicio.getDescripcion())
                .build();
    }
}
