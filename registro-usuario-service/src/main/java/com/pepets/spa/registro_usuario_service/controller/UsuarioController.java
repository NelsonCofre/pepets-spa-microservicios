package com.pepets.spa.registro_usuario_service.controller;

import com.pepets.spa.registro_usuario_service.dto.UsuarioDTO;
import com.pepets.spa.registro_usuario_service.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO crear(@RequestBody UsuarioDTO dto) {
        return usuarioService.crearUsuario(dto);
    }

    @GetMapping("/email/{email}")
    public UsuarioDTO buscar(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email);
    }
}
