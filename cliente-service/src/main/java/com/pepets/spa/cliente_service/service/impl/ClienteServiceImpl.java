package com.pepets.spa.cliente_service.service.impl;

import com.pepets.spa.cliente_service.dto.ClienteDTO;
import com.pepets.spa.cliente_service.model.Cliente;
import com.pepets.spa.cliente_service.repository.ClienteRepository;
import com.pepets.spa.cliente_service.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repo;

    @Override
    public ClienteDTO registrar(ClienteDTO dto) {

        if (repo.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        Cliente c = Cliente.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        repo.save(c);

        dto.setId(c.getId());
        return dto;
    }

    @Override
    public ClienteDTO login(String email, String password) {
        Cliente c = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email no encontrado"));

        if (!c.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return new ClienteDTO(c.getId(), c.getNombre(), c.getEmail(), c.getPassword());
    }

    @Override
    public ClienteDTO obtener(Long id) {
        Cliente c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no existe"));

        return new ClienteDTO(c.getId(), c.getNombre(), c.getEmail(), c.getPassword());
    }

    @Override
public ClienteDTO actualizar(Long id, ClienteDTO dto) {

    Cliente c = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no existe"));

    // Solo actualiza nombre y contraseña
    c.setNombre(dto.getNombre());
    c.setPassword(dto.getPassword());

    repo.save(c);

    return new ClienteDTO(c.getId(), c.getNombre(), c.getEmail(), c.getPassword());
}

}
