package com.pepets.spa.registro_usuario_service.service;

import com.pepets.spa.registro_usuario_service.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO crearUsuario(UsuarioDTO dto);

    UsuarioDTO buscarPorEmail(String email);
}
