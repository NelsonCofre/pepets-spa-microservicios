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

    private Long servicioId;

    private String fecha;

    private String hora;

    private String estado;
}
