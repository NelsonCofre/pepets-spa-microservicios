// package com.pepets.spa.cita_service.config;

// import com.pepets.spa.cita_service.model.Servicio;
// import com.pepets.spa.cita_service.repository.ServicioRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component
// @RequiredArgsConstructor
// public class DataLoader implements CommandLineRunner {

//     private final ServicioRepository servicioRepository;

//     @Override
//     public void run(String... args) throws Exception {

//         if (servicioRepository.count() == 0) {

//             Servicio s1 = Servicio.builder()
//                     .nombre("Baño Relajante")
//                     .descripcion("Baño profesional con productos hipoalergénicos y masaje.")
//                     .precio(12000.0)
//                     .duracionMin(30)
//                     .imagenUrl("https://i.imgur.com/banio.jpg")
//                     .build();

//             Servicio s2 = Servicio.builder()
//                     .nombre("Corte de Pelo")
//                     .descripcion("Estilo personalizado según raza y preferencia del dueño.")
//                     .precio(18000.0)
//                     .duracionMin(45)
//                     .imagenUrl("https://i.imgur.com/corte.jpg")
//                     .build();

//             Servicio s3 = Servicio.builder()
//                     .nombre("Alojamiento Canino")
//                     .descripcion("Estancia segura con zonas de juego y supervisión.")
//                     .precio(25000.0)
//                     .duracionMin(1440) // 1 día
//                     .imagenUrl("https://i.imgur.com/alojamiento.jpg")
//                     .build();

//             Servicio s4 = Servicio.builder()
//                     .nombre("Baño Especial Felino")
//                     .descripcion("Baño suave especial para gatos, productos hipoalergénicos.")
//                     .precio(15000.0)
//                     .duracionMin(25)
//                     .imagenUrl("https://i.imgur.com/banioGato.jpg")
//                     .build();

//             Servicio s5 = Servicio.builder()
//                     .nombre("Corte de Uñas")
//                     .descripcion("Corte seguro para perros o gatos, realizado por especialistas.")
//                     .precio(8000.0)
//                     .duracionMin(15)
//                     .imagenUrl("https://i.imgur.com/unias.jpg")
//                     .build();

//             servicioRepository.save(s1);
//             servicioRepository.save(s2);
//             servicioRepository.save(s3);
//             servicioRepository.save(s4);
//             servicioRepository.save(s5);

//             System.out.println(">>> Servicios iniciales cargados en la BD");
//         }
//     }
// }
