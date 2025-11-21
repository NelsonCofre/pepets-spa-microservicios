package com.pepets.spa.cita_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Fecha de la cita (debe ser hoy o futura) */
    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate fecha;

    /** Hora de la cita (no puede ser nula) */
    @NotNull
    @Column(nullable = false)
    private LocalTime hora;

    /** Cliente asociado a la cita */
    @NotNull
    @Column(nullable = false)
    private Long idCliente;

    /** Mascota asociada a la cita */
    @NotNull
    @Column(nullable = false)
    private Long idMascota;

    /** Estado de la cita (por defecto: PENDIENTE) */
    @Column(nullable = false)
    private String estado;

    /** Asigna estado por defecto si no se envía */
    @PrePersist
    public void prePersist() {
        if (estado == null) {
            estado = "PENDIENTE";
        }
    }
}
