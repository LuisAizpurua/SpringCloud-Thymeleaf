package com.bolsadeideas.springboot.server.proyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringServerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServerClientApplication.class, args);
	}
}
