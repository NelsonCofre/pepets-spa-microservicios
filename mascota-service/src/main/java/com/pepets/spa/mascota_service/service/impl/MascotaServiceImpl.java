package com.pepets.spa.mascota_service.service.impl;

import com.pepets.spa.mascota_service.client.ClienteClient;
import com.pepets.spa.mascota_service.dto.MascotaDTO;
import com.pepets.spa.mascota_service.model.Mascota;
import com.pepets.spa.mascota_service.repository.MascotaRepository;
import com.pepets.spa.mascota_service.service.MascotaService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final ClienteClient clienteClient;

    private MascotaDTO mapToDTO(Mascota m) {
        return MascotaDTO.builder()
                .id(m.getId())
                .nombre(m.getNombre())
                .especie(m.getEspecie())
                .raza(m.getRaza())
                .edad(m.getEdad())
                .idCliente(m.getIdCliente())
                .build();
    }

    private Mascota mapToEntity(MascotaDTO dto) {
        return Mascota.builder()
                .nombre(dto.getNombre())
                .especie(dto.getEspecie())
                .raza(dto.getRaza())
                .edad(dto.getEdad())
                .idCliente(dto.getIdCliente())
                .build();
    }

    @Override
    public MascotaDTO crearMascota(MascotaDTO mascotaDTO) {

        // Validar existencia del cliente
        clienteClient.obtenerClientePorId(mascotaDTO.getIdCliente());

        Mascota mascota = mapToEntity(mascotaDTO);
        Mascota guardada = mascotaRepository.save(mascota);
        return mapToDTO(guardada);
    }

    @Override
    public MascotaDTO obtenerPorId(Long id) {
        Mascota m = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        return mapToDTO(m);
    }

    @Override
    public List<MascotaDTO> listarPorCliente(Long idCliente) {
        return mascotaRepository.findByIdCliente(idCliente)
                .stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MascotaDTO> listarMascotas() {
        return mascotaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MascotaDTO actualizarMascota(Long id, MascotaDTO dto) {
        Mascota m = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        m.setNombre(dto.getNombre());
        m.setEspecie(dto.getEspecie());
        m.setRaza(dto.getRaza());
        m.setEdad(dto.getEdad());
        m.setIdCliente(dto.getIdCliente());

        Mascota actualizada = mascotaRepository.save(m);
        return mapToDTO(actualizada);
    }

    @Override
    public void eliminarMascota(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RuntimeException("Mascota no encontrada");
        }
        mascotaRepository.deleteById(id);
    }
}
