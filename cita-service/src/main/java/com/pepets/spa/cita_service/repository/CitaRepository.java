package com.pepets.spa.cita_service.repository;

import com.pepets.spa.cita_service.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByClienteId(Long clienteId);

    List<Cita> findByMascotaId(Long mascotaId);

    List<Cita> findByFecha(LocalDate fecha);
}
