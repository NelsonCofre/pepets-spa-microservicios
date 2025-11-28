package com.pepets.spa.cliente_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String email;
    private String password;
}
