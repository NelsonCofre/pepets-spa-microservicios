package com.pepets.spa.cita_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer duracionMin;

    private String imagenUrl;
}
