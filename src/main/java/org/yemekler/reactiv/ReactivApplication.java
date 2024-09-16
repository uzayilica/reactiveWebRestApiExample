package org.yemekler.reactiv;


import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;


@SpringBootApplication
public class ReactivApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactivApplication.class, args);


    }
}