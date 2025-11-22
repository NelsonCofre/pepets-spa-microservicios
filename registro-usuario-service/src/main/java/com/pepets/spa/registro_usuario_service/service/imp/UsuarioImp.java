package com.pepets.spa.registro_usuario_service.service.imp;

import com.pepets.spa.registro_usuario_service.dto.UsuarioDTO;
import com.pepets.spa.registro_usuario_service.model.Usuario;
import com.pepets.spa.registro_usuario_service.repository.UsuarioRepository;
import com.pepets.spa.registro_usuario_service.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO dto) {

        Usuario usuario = Usuario.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .rol(dto.getRol())
                .build();

        Usuario guardado = usuarioRepository.save(usuario);

        return new UsuarioDTO(
                guardado.getId(),
                guardado.getEmail(),
                null, // NO devolver la contraseña
                guardado.getRol());
    }

    @Override
    public UsuarioDTO buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElse(null);

        if (usuario == null)
            return null;

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getPassword(), // se envía para verificar en auth-service
                usuario.getRol());
    }
}
