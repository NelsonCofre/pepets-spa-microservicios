package com.pepets.spa.mascota_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MascotaDTO {
    private Long id;
    private Long clienteId;
    private String nombre;
    private String tipo;
    private Integer edad;
}
