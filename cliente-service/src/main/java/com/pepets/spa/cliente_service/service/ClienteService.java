package com.pepets.spa.cliente_service.service;

import com.pepets.spa.cliente_service.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO obtenerClientePorId(Long id);

    ClienteDTO obtenerClientePorEmail(String email);

    List<ClienteDTO> listarClientes();

    ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO);

    void eliminarCliente(Long id);
}
