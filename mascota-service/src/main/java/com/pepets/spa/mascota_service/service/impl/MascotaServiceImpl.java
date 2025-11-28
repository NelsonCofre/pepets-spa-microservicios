package com.pepets.spa.mascota_service.service.impl;

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

        private final MascotaRepository mascotaRepo;

        @Override
        public MascotaDTO crearMascota(MascotaDTO dto) {
                Mascota m = Mascota.builder()
                                .nombre(dto.getNombre())
                                .tipo(dto.getTipo())
                                .edad(dto.getEdad())
                                .clienteId(dto.getClienteId())
                                .build();

                mascotaRepo.save(m);

                dto.setId(m.getId());
                return dto;
        }

        @Override
        public List<MascotaDTO> obtenerMascotasPorCliente(Long clienteId) {
                return mascotaRepo.findByClienteId(clienteId)
                                .stream()
                                .map(m -> MascotaDTO.builder()
                                                .id(m.getId())
                                                .clienteId(m.getClienteId())
                                                .nombre(m.getNombre())
                                                .tipo(m.getTipo())
                                                .edad(m.getEdad())
                                                .build())
                                .collect(Collectors.toList());
        }

        @Override
        public MascotaDTO obtenerPorId(Long id) {
                Mascota m = mascotaRepo.findById(id)
                                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

                return MascotaDTO.builder()
                                .id(m.getId())
                                .clienteId(m.getClienteId())
                                .nombre(m.getNombre())
                                .tipo(m.getTipo())
                                .edad(m.getEdad())
                                .build();
        }

        @Override
        public MascotaDTO actualizarMascota(Long id, MascotaDTO dto) {
                Mascota m = mascotaRepo.findById(id)
                                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

                // Actualizamos los campos
                m.setNombre(dto.getNombre());
                m.setTipo(dto.getTipo());
                m.setEdad(dto.getEdad());

                mascotaRepo.save(m);

                // Retornamos DTO actualizado
                return MascotaDTO.builder()
                                .id(m.getId())
                                .clienteId(m.getClienteId())
                                .nombre(m.getNombre())
                                .tipo(m.getTipo())
                                .edad(m.getEdad())
                                .build();
        }

        @Override
        public void eliminarMascota(Long id) {
                if (!mascotaRepo.existsById(id)) {
                        throw new RuntimeException("Mascota no encontrada");
                }
                mascotaRepo.deleteById(id);
        }

        @Override
        public List<MascotaDTO> obtenerTodas() {
                return mascotaRepo.findAll()
                                .stream()
                                .map(m -> MascotaDTO.builder()
                                                .id(m.getId())
                                                .clienteId(m.getClienteId())
                                                .nombre(m.getNombre())
                                                .tipo(m.getTipo())
                                                .edad(m.getEdad())
                                                .build())
                                .collect(Collectors.toList());
        }

}
