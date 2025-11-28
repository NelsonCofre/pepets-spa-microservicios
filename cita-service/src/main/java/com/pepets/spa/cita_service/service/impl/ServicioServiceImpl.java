package com.pepets.spa.cita_service.service.impl;

import com.pepets.spa.cita_service.model.Servicio;
import com.pepets.spa.cita_service.repository.ServicioRepository;
import com.pepets.spa.cita_service.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    @Override
    public Servicio crear(Servicio s) {
        return servicioRepository.save(s);
    }

    @Override
    public Servicio obtener(Long id) {
        return servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

    @Override
    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio actualizar(Long id, Servicio s) {
        Servicio original = obtener(id);

        original.setNombre(s.getNombre());
        original.setDescripcion(s.getDescripcion());
        original.setPrecio(s.getPrecio());
        original.setDuracionMin(s.getDuracionMin());
        original.setImagenUrl(s.getImagenUrl());

        return servicioRepository.save(original);
    }

    @Override
    public void eliminar(Long id) {
        servicioRepository.deleteById(id);
    }
}
