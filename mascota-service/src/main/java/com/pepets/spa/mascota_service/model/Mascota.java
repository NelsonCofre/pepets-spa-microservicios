package com.pepets.spa.mascota_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mascotas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long clienteId; // Relación con cliente-service

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo; // perro, gato, etc.

    @Column(nullable = false)
    private Integer edad; // opcional, pero útil
}
