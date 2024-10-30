package com.bolsadeideas.springboot.app.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@RibbonClient("servicio-usuario")
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
@EnableDiscoveryClient
public class SpringProyectoInterfazApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProyectoInterfazApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}