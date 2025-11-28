// package com.pepets.spa.mascota_service.config;

// import com.pepets.spa.mascota_service.model.Mascota;
// import com.pepets.spa.mascota_service.repository.MascotaRepository;
// import jakarta.annotation.PostConstruct;
// import lombok.RequiredArgsConstructor;
// import net.datafaker.Faker;
// import org.springframework.stereotype.Component;

// @Component
// @RequiredArgsConstructor
// public class DataLoader {

//     private final MascotaRepository mascotaRepository;

//     @PostConstruct
//     public void loadData() {

//         if (mascotaRepository.count() > 0) {
//             return;
//         }

//         Faker faker = new Faker();

//         for (int i = 0; i < 5; i++) {

//             Mascota mascota = Mascota.builder()
//                     .nombre(faker.animal().name())
//                     .especie(faker.options().option("Perro", "Gato", "Conejo", "Tortuga", "Hamster"))
//                     .raza(faker.dog().breed()) // aunque no sea perro, se ve bien
//                     .edad(faker.number().numberBetween(1, 18))
//                     .idCliente(faker.number().numberBetween(1L, 5L)) // MATCH con clientes generados
//                     .build();

//             mascotaRepository.save(mascota);
//         }

//         System.out.println(">>> 5 Mascotas creadas en mascota-service");
//     }
// }
