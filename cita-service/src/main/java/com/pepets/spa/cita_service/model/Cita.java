package com.pepets.spa.cita_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;
    private Long mascotaId;
    private Long servicioId;

    private String fecha;
    private String hora;

    private String estado; // pendiente, confirmada, cancelada
}
