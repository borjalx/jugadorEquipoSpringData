package com.daw.basquet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		context.getBean(JugadorService.class).testJugador();
		context.getBean(JugadorService.class).ConsultasJugador();
		context.getBean(JugadorService.class).ConsultasEquipo();
	}
}
