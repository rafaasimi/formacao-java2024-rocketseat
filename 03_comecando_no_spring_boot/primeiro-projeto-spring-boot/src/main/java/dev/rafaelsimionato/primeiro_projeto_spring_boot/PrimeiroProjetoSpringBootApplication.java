package dev.rafaelsimionato.primeiro_projeto_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.rafaelsimionato"})
public class PrimeiroProjetoSpringBootApplication {

	static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringBootApplication.class, args);
	}

}
