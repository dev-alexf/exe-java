package com.loja.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 *
 * A anotação @SpringBootApplication combina três anotações:
 *   - @Configuration       → marca a classe como fonte de definições de beans
 *   - @EnableAutoConfiguration → habilita a configuração automática do Spring
 *   - @ComponentScan       → varre o pacote em busca de @Component, @Service, @Controller, etc.
 */
@SpringBootApplication
public class ClientesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientesApiApplication.class, args);
        System.out.println("==============================================");
        System.out.println("  API de Clientes iniciada com sucesso!");
        System.out.println("  Acesse: http://localhost:8080/clientes");
        System.out.println("==============================================");
    }
}
