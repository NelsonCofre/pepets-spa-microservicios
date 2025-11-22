package com.pepets.spa.cita_service.service.imp;

import com.pepets.spa.cita_service.client.MascotaClient;
import com.pepets.spa.cita_service.client.ServicioClient;
import com.pepets.spa.cita_service.client.ClienteClient;
import com.pepets.spa.cita_service.dto.CitaDTO;
import com.pepets.spa.cita_service.model.Cita;
import com.pepets.spa.cita_service.repository.CitaRepository;
import com.pepets.spa.cita_service.service.CitaService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final ClienteClient clienteClient;
    private final MascotaClient mascotaClient;
    private final ServicioClient servicioClient;

    private CitaDTO toDTO(Cita c) {
        return CitaDTO.builder()
                .id(c.getId())
                .clienteId(c.getClienteId())
                .mascotaId(c.getMascotaId())
                .servicioId(c.getServicioId())
                .fecha(c.getFecha())
                .hora(c.getHora())
                .estado(c.getEstado())
                .notas(c.getNotas())
                .build();
    }

    private Cita toEntity(CitaDTO dto) {
        return Cita.builder()
                .clienteId(dto.getClienteId())
                .mascotaId(dto.getMascotaId())
                .servicioId(dto.getServicioId())
                .fecha(dto.getFecha())
                .hora(dto.getHora())
                .estado(dto.getEstado() == null ? "PENDIENTE" : dto.getEstado())
                .notas(dto.getNotas())
                .build();
    }

    @Override
    public CitaDTO crearCita(CitaDTO dto) {
        // 1) Validar cliente existe
        Object cliente = clienteClient.obtenerClientePorId(dto.getClienteId());
        if (cliente == null) {
            throw new RuntimeException("Cliente no existe");
        }

        // 2) Validar mascota existe
        Object mascota = mascotaClient.obtenerMascotaPorId(dto.getMascotaId());
        if (mascota == null) {
            throw new RuntimeException("Mascota no existe");
        }

        // 3) Validar mascota pertenece al cliente (intentamos chequear idCliente si la
        // respuesta lo trae)
        // si el servicio mascota devuelve un map/obj con idCliente, podríamos
        // comprobar;
        // como precaución, dejamos que la validación la haga la respuesta del
        // cliente/mascota.
        // Opcional: si MascotaClient devuelve un objeto con getIdCliente(), verificar
        // aquí.

        // 4) Validar servicio existe
        Object servicio = servicioClient.obtenerServicioPorId(dto.getServicioId());
        if (servicio == null) {
            throw new RuntimeException("Servicio no existe");
        }

        // 5) Guardar
        Cita cita = toEntity(dto);
        cita.setFechaCreacion(LocalDateTime.now());
        Cita guardada = citaRepository.save(cita);
        return toDTO(guardada);
    }

    @Override
    public CitaDTO obtenerPorId(Long id) {
        Cita c = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return toDTO(c);
    }

    @Override
    public List<CitaDTO> listarPorCliente(Long clienteId) {
        return citaRepository.findByClienteId(clienteId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> listarPorMascota(Long mascotaId) {
        return citaRepository.findByMascotaId(mascotaId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> listarPorFecha(LocalDate fecha) {
        return citaRepository.findByFecha(fecha).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> listarTodas() {
        return citaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public CitaDTO actualizarCita(Long id, CitaDTO dto) {
        Cita c = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        // No cambiamos clienteId/mascotaId por seguridad, pero si quieres permitirlo,
        // valida con feign.
        c.setServicioId(dto.getServicioId());
        c.setFecha(dto.getFecha());
        c.setHora(dto.getHora());
        c.setEstado(dto.getEstado() == null ? c.getEstado() : dto.getEstado());
        c.setNotas(dto.getNotas());

        Cita actualizado = citaRepository.save(c);
        return toDTO(actualizado);
    }

    @Override
    public void eliminarCita(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepository.deleteById(id);
    }

    @Override
    public CitaDTO cambiarEstado(Long id, String nuevoEstado) {
        Cita c = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        c.setEstado(nuevoEstado);
        Cita actualizado = citaRepository.save(c);
        return toDTO(actualizado);
    }
}
