package com.pepets.spa.cliente_service.controller;

import com.pepets.spa.cliente_service.dto.LoginRequest;

import com.pepets.spa.cliente_service.dto.ClienteDTO;
import com.pepets.spa.cliente_service.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/register")
    public ClienteDTO registrar(@RequestBody ClienteDTO dto) {
        return clienteService.registrar(dto);
    }

    @PostMapping("/login")
    public ClienteDTO login(@RequestBody LoginRequest request) {
        return clienteService.login(request.getEmail(), request.getPassword());
    }

    @GetMapping("/{id}")
    public ClienteDTO obtener(@PathVariable Long id) {
        return clienteService.obtener(id);
    }

    @PutMapping("/{id}")
    public ClienteDTO actualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return clienteService.actualizar(id, dto);
    }

}
