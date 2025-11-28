// package com.pepets.spa.cliente_service.config;

// import com.pepets.spa.cliente_service.model.Cliente;
// import com.pepets.spa.cliente_service.repository.ClienteRepository;
// import jakarta.annotation.PostConstruct;
// import lombok.RequiredArgsConstructor;
// import net.datafaker.Faker;
// import org.springframework.stereotype.Component;

// @Component
// @RequiredArgsConstructor
// public class DataLoader {

//     private final ClienteRepository clienteRepository;

//     @PostConstruct
//     public void initData() {

//         if (clienteRepository.count() > 0) {
//             return;
//         }

//         Faker faker = new Faker();

//         for (int i = 0; i < 5; i++) {
//             Cliente cliente = Cliente.builder()
//                     .nombre(faker.name().fullName())
//                     .email(faker.internet().emailAddress())
//                     .telefono(faker.phoneNumber().cellPhone())
//                     .direccion(faker.address().fullAddress())
//                     .password("123456") // <-- NUEVA CONTRASEÑA SIN ENCRIPTAR
//                     .build();

//             clienteRepository.save(cliente);
//         }

//         System.out.println(">>> 5 clientes generados con contraseña en cliente-service");
//     }
// }
