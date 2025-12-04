package com.pepets.spa.cita_service.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaDTO {

    private Long id;

    private Long clienteId;

    private Long mascotaId;
    private String mascotaNombre;   // <- NUEVO

    private Long servicioId;
    private String servicioNombre;  // <- NUEVO

    private String fecha;

    private String hora;

    private String estado;
}

