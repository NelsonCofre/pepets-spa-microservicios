package com.pepets.spa.cita_service.service.impl;

import com.pepets.spa.cita_service.model.Cita;
import com.pepets.spa.cita_service.repository.CitaRepository;
import com.pepets.spa.cita_service.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    @Override
    public Cita crear(Cita c) {
        c.setEstado("pendiente");
        return citaRepository.save(c);
    }

    @Override
    public Cita obtener(Long id) {
        return citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
    }

    @Override
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    @Override
    public List<Cita> listarPorCliente(Long clienteId) {
        return citaRepository.findAll()
                .stream()
                .filter(c -> c.getClienteId().equals(clienteId))
                .toList();
    }

    @Override
    public Cita actualizar(Long id, Cita c) {
        Cita original = obtener(id);

        original.setFecha(c.getFecha());
        original.setHora(c.getHora());
        original.setMascotaId(c.getMascotaId());
        original.setServicioId(c.getServicioId());
        original.setEstado(c.getEstado());

        return citaRepository.save(original);
    }

    @Override
    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
}
