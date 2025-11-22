package com.pepets.spa.registro_usuario_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private Long id;
    private String email;
    private String password; // al crear SÍ se envía
    private String rol;
}
