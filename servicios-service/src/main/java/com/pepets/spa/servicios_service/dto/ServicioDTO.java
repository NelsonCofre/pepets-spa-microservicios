package com.pepets.spa.servicios_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
}
