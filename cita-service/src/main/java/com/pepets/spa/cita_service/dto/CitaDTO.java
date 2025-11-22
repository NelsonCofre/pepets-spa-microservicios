package com.pepets.spa.cita_service.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaDTO {

    private Long id;

    @NotNull(message = "clienteId es obligatorio")
    private Long clienteId;

    @NotNull(message = "mascotaId es obligatorio")
    private Long mascotaId;

    @NotNull(message = "servicioId es obligatorio")
    private Long servicioId;

    @NotNull(message = "fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "hora es obligatoria")
    private LocalTime hora;

    private String estado; // opcional al crear, por defecto PENDIENTE

    private String notas;
}
