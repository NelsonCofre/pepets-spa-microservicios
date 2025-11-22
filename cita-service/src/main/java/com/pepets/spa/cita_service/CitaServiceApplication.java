
package com.pepets.spa.cita_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.pepets.spa.cita_service.client")
public class CitaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CitaServiceApplication.class, args);
		System.out.println("----------cita-service iniciado correctamente");
	}
}
