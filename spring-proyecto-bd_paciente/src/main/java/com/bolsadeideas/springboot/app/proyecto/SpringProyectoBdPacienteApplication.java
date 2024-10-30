package com.bolsadeideas.springboot.app.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringProyectoBdPacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProyectoBdPacienteApplication.class, args);
	}

}
