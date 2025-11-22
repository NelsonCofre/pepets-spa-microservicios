package com.pepets.spa.cliente_service.controller;

import com.pepets.spa.cliente_service.dto.ClienteDTO;
import com.pepets.spa.cliente_service.service.ClienteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ClienteDTO crear(@RequestBody ClienteDTO dto) {
        return clienteService.crearCliente(dto);
    }

    @GetMapping("/{id}")
    public ClienteDTO obtenerPorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping("/email/{email}")
    public ClienteDTO obtenerPorEmail(@PathVariable String email) {
        return clienteService.obtenerClientePorEmail(email);
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return clienteService.listarClientes();
    }

    @PutMapping("/{id}")
    public ClienteDTO actualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return clienteService.actualizarCliente(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
