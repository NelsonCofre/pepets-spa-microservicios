package com.pepets.spa.cliente_service.service;

import org.springframework.stereotype.Service;

import com.pepets.spa.cliente_service.dto.ClienteDTO;

@Service
public interface ClienteService {
    ClienteDTO registrar(ClienteDTO dto);

    ClienteDTO login(String email, String password);

    ClienteDTO obtener(Long id);

    ClienteDTO actualizar(Long id, ClienteDTO dto);

}
